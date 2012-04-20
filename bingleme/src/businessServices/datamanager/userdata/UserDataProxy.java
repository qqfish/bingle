package businessServices.datamanager.userdata;

import baseUse.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.*;

public class UserDataProxy implements IUserData {

	private Connection con;

	public UserDataProxy() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/bingleme?user=root&password=123");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * 调用current的函数
	 * 
	 * 
	 * @param username
	 * @param password
	 * @throws SQLException
	 * @pdOid 6bfe42af-9449-42ac-9c5a-bc0106c4ba90
	 */
	public Boolean confirmUser(String username, String password)
			throws SQLException {
		String sql = "SELECT password FROM user WHERE userName= '" + username
				+ "'";
		ResultSet rs = con.createStatement().executeQuery(sql);
		if (rs.next()) {
			if (rs.getString(1) == password) {
				rs.close();
				return true;
			} else {
				rs.close();
				return false;
			}
		} else {
			rs.close();
			return false;
		}
	}

	/**
	 * 调用current的
	 * 
	 * @param username
	 * @param groupname
	 * @throws SQLException
	 * @pdOid 7d7003d9-d061-4f2c-ad2f-0d337a7f6af6
	 */
	public void changeUserGroup(String username, String groupname)
			throws SQLException {
		con.createStatement().executeQuery(
				"UPDATE user SET groupName = '" + groupname
						+ "' WHERE userName = '" + username + "'");

	}

	/**
	 * 调用current的
	 * 
	 * @param username
	 * @param friendname
	 * @throws SQLException
	 * @pdOid 4b207c8e-2bde-4b7a-81b8-afb578ca9837
	 */
	public void addFriend(String username, String friendname)
			throws SQLException {
		con.createStatement().execute(
				"INSERT INTO friend (friendName, userName) VALUES ('"
						+ friendname + "', '" + username + "')");
	}

	/**
	 * 调用current
	 * 
	 * @param username
	 * @param friendname
	 * @throws SQLException
	 * @pdOid 9a12d1c9-7e72-4947-bf35-738618645208
	 */
	public void deleteFriend(String username, String friendname)
			throws SQLException {
		con.createStatement().execute(
				"DELETE FROM friend WHERE username='" + username
						+ "' and friendName = '" + friendname + "'");
	}

	/**
	 * 调用current
	 * 
	 * 
	 * @param username
	 * @throws SQLException
	 * @pdOid e3178723-176f-4898-91a7-e02a7fe1f356
	 */
	public FriendList getFriendList(String username) throws SQLException {
		ResultSet rs = con.createStatement().executeQuery(
				"SELECT friendName FROM friend WHERE userName = '" + username
						+ "'");
		FriendList result = new FriendList();
		while (rs.next()) {
			result.add(rs.getString("friendName"));
		}
		rs.close();
		return result;

	}

	/**
	 * 用户一登陆时候 重数据库中取
	 * 
	 * 
	 * @param username
	 * @throws SQLException
	 * @pdOid 064dcadf-4c86-4279-9480-5bfe16b59b82
	 */
	public MessageSet getMessage(String username) throws SQLException {
		ResultSet rs = con.createStatement().executeQuery(
				"SELECT * FROM message WHERE userName = '" + username + "'");
		MessageSet result = new MessageSet();
		while (rs.next()) {
			result.addMessage(rs.getString("friendName"),
					rs.getString("messageContent"), rs.getDate("messageTime"));
		}
		rs.close();
		return result;
	}

	/**
	 * 直接生成sql
	 * 
	 * 
	 * @param from
	 * @param to
	 * @param content
	 * @throws SQLException
	 * @pdOid d552ef16-cc85-48dd-8d6b-fcf3e109b10a
	 */
	public void saveMessage(String from, String to, String content)
			throws SQLException {
		Date now = new Date();
		now.getTime();
		con.createStatement()
				.executeUpdate(
						"INSERT INTO message (friendName, userName, messageContent, messageTime) VALUES ('"
								+ from
								+ "', '"
								+ to
								+ "','"
								+ content
								+ "','"
								+ now + "')");
	}

	/**
	 * 
	 * @param keyword
	 * @throws SQLException
	 * @pdOid 4bc30bc4-937c-4e49-b4c6-b12b243fb624
	 */
	public UserShortInfoList searchUser(String keyword) throws SQLException {
		ResultSet rs = con.createStatement().executeQuery(
				"SELECT * FROM userTag WHERE userName like '%" + keyword
						+ "%' or tagName like '%" + keyword
						+ "%' ORDER BY userName");
		UserShortInfoList result = new UserShortInfoList();
		List<List<String>> tag = new ArrayList<List<String>>();
		List<String> username = new ArrayList<String>();
		String sql = "SELECT userName,age,gender,currentDisease FROM user WHERE userName is null";
		while (rs.next()) {
			if (username.isEmpty()
					|| username.get(username.size() - 1) != rs
							.getString("userName")) {
				username.add(rs.getString("userName"));
				tag.add(new ArrayList<String>());
				tag.get(tag.size() - 1).add(rs.getString("tagName"));
				sql += " or userName = '" + rs.getString("userName") + "'";
			} else {
				tag.get(tag.size() - 1).add(rs.getString("tagName"));
			}
		}
		ResultSet rs1 = con.createStatement().executeQuery(
				sql + "ORDER BY userName");
		int i = 0;
		while (rs.next()) {
			result.add(rs1.getString("userName"),
					rs1.getString("currentDisease"), tag.get(i),
					rs1.getShort("age"), rs1.getBoolean("gender"));
			i++;
		}
		rs.close();
		return result;
	}

	/**
	 * 
	 * @param username
	 * @throws SQLException
	 * @pdOid 6f2893ab-ffcd-4cab-93b9-177a5dd2fd72
	 */
	public Boolean checkUsername(String username) throws SQLException {
		ResultSet rs = con.createStatement().executeQuery(
				"SELECT * FROM user WHERE userName '" + username + "'");
		if (rs.next()) {
			rs.close();
			return true;
		} else {
			rs.close();
			return false;
		}
	}

	/**
	 * 调用current
	 * 
	 * @param userinfo
	 * @throws SQLException
	 * @pdOid abda513f-a418-4860-b76f-3ad80ac354dc
	 */
	public void createUser(UserBaseInfo userinfo) throws SQLException {
		con.createStatement().executeUpdate(
				"INSERT INTO user (userName,password,email,age,gender) VALUES ('"
						+ userinfo.getUsername() + "','"
						+ userinfo.getPassword() + "','" + userinfo.getEmail()
						+ "','" + userinfo.getAge() + "','"
						+ userinfo.getGender() + ")");
	}

	/**
	 * @param username
	 * @throws SQLException
	 * @pdOid 73d748c8-e50f-4d18-81c9-0174e71a1081
	 */
	public UserDetailInfo getDetailUserInfo(String username)
			throws SQLException {
		Statement st = con.createStatement();
		ResultSet rsTag = st
				.executeQuery("SELECT tagName FROM userTag WHERE userName = '"
						+ username + "'");
		ResultSet rsUser = st
				.executeQuery("SELECT * FROM user WHERE userName = '"
						+ username + "'");
		ResultSet rsDisease = st
				.executeQuery("SELECT * FROM getDisease WHERE userName = '"
						+ username + "' ORDER BY diseaseName");
		ResultSet rsDrug = st
				.executeQuery("SELECT * FROM takeDrug WHERE userName = '"
						+ username + "' ORDER BY diseaseName");
		List<UserDiseaseInfo> userDisease = new ArrayList<UserDiseaseInfo>();
		while (rsDisease.next()) {
			List<String> drug = new ArrayList<String>();
			if (!rsDrug.isBeforeFirst()) {
				if (rsDrug.getString("diseaseName") != rsDisease
						.getString("diseaseName")) {
					userDisease.add(new UserDiseaseInfo(rsDisease
							.getString("diseaseName"), rsDisease
							.getString("treatmentIntro"), rsDisease
							.getString("reason"), rsDisease.getString("tips"),
							drug));
					continue;
				} else {
					drug.add(rsDrug.getString("tagName"));
				}
			}
			while (rsDrug.next()
					&& rsDrug.getString("diseaseName") == rsDisease
							.getString("diseaseName")) {
				drug.add(rsDrug.getString("tagName"));
			}
			userDisease.add(new UserDiseaseInfo(rsDisease
					.getString("diseaseName"), rsDisease
					.getString("treatmentIntro"),
					rsDisease.getString("reason"), rsDisease.getString("tips"),
					drug));
		}
		List<String> tags = new ArrayList<String>();
		while (rsTag.next()) {
			tags.add(rsTag.getString("tagName"));
		}
		UserDetailInfo result = new UserDetailInfo(username,
				rsUser.getShort("age"), rsUser.getString("address"),
				rsUser.getString("email"), rsUser.getInt("mindStatus"),
				rsUser.getInt("bodyStatus"), tags, userDisease);
		st.close();
		rsTag.close();
		rsUser.close();
		rsDisease.close();
		rsDrug.close();
		return result;
	}

	/**
	 * @param userinfo
	 * @param username
	 * @throws SQLException
	 * @pdOid 95a6e4a8-ceed-467e-930a-7a6b3c210df8
	 */
	public void updateUserInfo(String username, Short age, String address,
			String email, int mindStatus, int bodyStatus) throws SQLException {
		Statement st = con.createStatement();
		st.executeUpdate("UPDATE user SET age = '" + age + "', address = '"
				+ address + "', email = '" + email + "', mindStatus = '"
				+ mindStatus + "' bodyStatus = '" + bodyStatus
				+ "' WHERE userName = '" + username + "'");
		st.close();
	}

	@Override
	public void deleteTag(String username, List<String> tagname)
			throws SQLException {
		String sql = "DELETE FROM userTag WHERE userName = '" + username
				+ "' and (tagName = '" + tagname.get(0) + "'";
		for (int i = 1; i < tagname.size(); i++) {
			sql = sql + " or tagName = '" + tagname + "'";
		}
		sql = sql + ")";
		con.createStatement().executeUpdate(sql);
	}

	@Override
	public void addTag(String username, List<String> tagname)
			throws SQLException {
		Statement st = con.createStatement();
		for (int i = 0; i < tagname.size(); i++) {
			st.executeUpdate("INSERT INTO userTag (userName,tagName) VALUES ("
					+ username + ", " + tagname.get(i) + ")");
		}
		st.close();
	}

	@Override
	public void addUserDisease(String username, String diseasename,
			String treatmentIntro, String reason, String tips)
			throws SQLException {
		con.createStatement()
				.executeUpdate(
						"INSERT INTO getDisease (userName,diseaseName,treatmentIntro,reason,tips) VALUES ("
								+ username
								+ ","
								+ diseasename
								+ ","
								+ treatmentIntro
								+ ","
								+ reason
								+ ","
								+ tips
								+ ")");

	}

	@Override
	public void editUserDisease(String username, String diseasename,
			String treatmentIntro, String reason, String tips)
			throws SQLException {
		con.createStatement().executeUpdate(
				"UPDATE getDisease SET treatmentIntro = '" + treatmentIntro
						+ "', reason = '" + reason + "', tips = '" + tips
						+ "' WHERE userName = '" + username
						+ "' and diseaseName = '" + diseasename + "'");

	}

	@Override
	public void deleteUserDisease(String username, String diseasename)
			throws SQLException {
		Statement st = con.createStatement();
		st.executeUpdate("DELETE FROM takeDrug WHERE userName = '" + username
				+ "' and diseaseName = '" + diseasename + "'");
		st.executeUpdate("DELETE FROM getDisease WHERE userName = '" + username
				+ "' and diseaseName = '" + diseasename + "'");

	}

	@Override
	public void addUserDiseaseDrug(String username, String diseasename,
			List<String> drugname) throws SQLException {
		Statement st = con.createStatement();
		for (int i = 0; i < drugname.size(); i++) {
			st.executeUpdate("INSERT INTO takeDrug (userName,diseaseName,tagName) VALUES ("
					+ username
					+ ", "
					+ diseasename
					+ ", "
					+ drugname.get(i)
					+ ")");
		}
		st.close();
	}

	@Override
	public void deleteUserDiseaseDrug(String username, String diseasename,
			List<String> drugname) throws SQLException {
		String sql = "DELETE FROM takeDrug WHERE userName = '" + username
				+ "' and diseaseName = '" + diseasename + "' and (tagName = '"
				+ drugname.get(0) + "'";
		for (int i = 1; i < drugname.size(); i++) {
			sql = sql + " or tagName = '" + drugname.get(i) + "'";
		}
		sql = sql + ")";
		con.createStatement().executeUpdate(sql);

	}

}
