package baseUse;

import java.sql.SQLException;
import java.util.List;

public interface IUserData {
	/**
	 * @param username
	 * @param password
	 * @throws SQLException
	 * @pdOid 71771432-8b9b-4438-86fa-ebc216acf3f2
	 */
	Boolean confirmUser(String username, String password) throws SQLException;

	/**
	 * @param username
	 * @param groupname
	 * @throws SQLException
	 * @pdOid 8fba25a5-930b-4721-8711-c06b81cbe8ff
	 */
	void changeUserGroup(String username, String groupname) throws SQLException;

	/**
	 * @param username
	 * @param friendname
	 * @throws SQLException
	 * @pdOid 6e9b8e59-5649-46ff-bb86-603ce54d971c
	 */
	void addFriend(String username, String friendname) throws SQLException;

	/**
	 * @param username
	 * @param friendname
	 * @throws SQLException
	 * @pdOid 6e3ed02a-a70e-4b06-9db5-b27ef6c1728a
	 */
	void deleteFriend(String username, String friendname) throws SQLException;

	/**
	 * @param username
	 * @throws SQLException
	 * @pdOid f1508a13-24ab-4c03-8f4f-21a104265610
	 */
	FriendList getFriendList(String username) throws SQLException;

	/**
	 * 用户一登陆时候
	 * 
	 * 
	 * @param username
	 * @throws SQLException
	 * @pdOid 5b8a0473-964d-444d-96ee-64e0c02091c9
	 */
	MessageSet getMessage(String username) throws SQLException;

	/**
	 * @param from
	 * @param to
	 * @param content
	 * @throws SQLException
	 * @pdOid 0b986f37-c003-4c23-8469-71521ee0e4cf
	 */
	void saveMessage(String from, String to, String content)
			throws SQLException;

	/**
	 * @param keyword
	 * @throws SQLException
	 * @pdOid 5acdcde6-5eb6-4550-9121-c8754a61e238
	 */
	UserShortInfoList searchUser(String keyword) throws SQLException;

	/**
	 * @param username
	 * @throws SQLException
	 * @pdOid 214b49e5-50bd-48c5-8589-6b431bf4336b
	 */
	Boolean checkUsername(String username) throws SQLException;

	/**
	 * @param userinfo
	 * @throws SQLException
	 * @pdOid e3375e9d-4ed5-4fa9-9747-81cf3576721c
	 */
	void createUser(UserBaseInfo userinfo) throws SQLException;

	/**
	 * @param username
	 * @throws SQLException
	 * @pdOid 3c12a4ec-96ee-418e-b012-657c8a6f3919
	 */
	UserDetailInfo getDetailUserInfo(String username) throws SQLException;

	/**
	 * @param userinfo
	 * @param username
	 * @throws SQLException
	 * @pdOid 20e830a9-8b1d-4937-87af-e4859ace90b6
	 */
	void updateUserInfo(String username, Short age, String address,
			String email, int mindStatus, int bodyStatus) throws SQLException;
	
	void deleteTag(String username, List<String> tagname) throws SQLException;
	
	void addTag(String username, List<String> tagname) throws SQLException;
	
	void addUserDisease(String username, String diseasename, String treatmentIntro, String reason, String tips) throws SQLException;
	
	void editUserDisease(String username , String diseasename, String treatmentIntro, String reason, String tips) throws SQLException;
	
	void deleteUserDisease(String username, String diseasename) throws SQLException;
	
	void addUserDiseaseDrug(String username, String diseasename,List<String> drugname) throws SQLException;
	
	void deleteUserDiseaseDrug(String username, String diseasename, List<String> drugname) throws SQLException;

}
