package businessServices.datamanager.diseasedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import baseUse.IDiseaseData;
import baseUse.IUserData;
import baseUse.searchData.DiseaseDetailInfo;
import baseUse.searchData.DiseaseShortInfo;
import baseUse.searchData.DiseaseShortInfoList;
import baseUse.searchData.DrugInfo;
import baseUse.wikiData.DiseaseData;
import baseUse.wikiData.DiseaseDataList;
import baseUse.wikiData.DiseaseDataTag;
import businessServices.datamanager.userdata.UserDataProxy;

public class DiseaseDataProxy implements IDiseaseData {

	private Connection con;

	public DiseaseDataProxy() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		con = DriverManager
				.getConnection("jdbc:mysql://localhost/bingle?unicode=true&characterEncoding=UTF-8&user=root&password=123");

	}

	public void updateDiseaseDatabase(DiseaseDataList content) throws SQLException {
		Statement st = con.createStatement();
		for (int i = 0; i < content.getDisease().size(); i++) {
			DiseaseData current = content.getDisease().get(i);
			if (current.getStatus() == 'n') {
				st.executeUpdate("INSERT INTO diseaseData (diseaseName, diseaseIntro, editTime) VALUES ('"
						+ current.getDiseasename()
						+ "' , '"
						+ current.getDiseaseIntro()
						+ "' , '"
						+ current.getEditTime() + "')");
				for (int j = 0; j < current.getTag().size(); j++) {
					st.executeUpdate("INSERT INTO diseaseTag (diseaseName, tagName) VALUES ('"
							+ current.getDiseasename()
							+ "' , '"
							+ current.getTag().get(j).getTagname() + "')");
				}
			} else if (current.getStatus() == 'd') {
				st.executeUpdate("DELETE FROM diseaseTag WHERE diseaseName = '"
						+ current.getDiseasename() + "'");
				st.executeUpdate("DELETE FROM diseaseData WHERE diseaseName = '"
						+ current.getDiseasename() + "'");

			} else if (current.getStatus() == 'c') {
				st.executeUpdate("UPDATE diseaseData SET diseaseIntro = '"
						+ current.getDiseaseIntro() + "' , editTime = '"
						+ current.getEditTime() + "'");
				for (int j = 0; j < current.getTag().size(); j++) {
					DiseaseDataTag currentTag = current.getTag().get(j);
					if (currentTag.getStatus() == 'n') {
						st.executeUpdate("INSERT INTO diseaseTag (diseaseName, tagName) VALUES ('"
								+ current.getDiseasename()
								+ "' , '"
								+ currentTag.getTagname() + "')");
					} else if (currentTag.getStatus() == 'd') {
						st.executeUpdate("DELETE FROM diseaseTag WHERE diseasnName = '"
								+ current.getDiseasename()
								+ "' and tagName = '"
								+ currentTag.getTagname()
								+ "'");
					}
				}

			}
		}

	}

	public DiseaseShortInfoList searchDisease(String keyword)
			throws SQLException {
		ResultSet rs = con.createStatement().executeQuery(
				"SELECT * FROM diseaseTag WHERE diseaseName like '%" + keyword
						+ "%' or tagName like '%" + keyword
						+ "%' ORDER BY diseaseName");
		List<DiseaseShortInfo> ds = new ArrayList<DiseaseShortInfo>();
		while (rs.next()) {
			if (rs.isFirst()
					|| !ds.get(ds.size() - 1).getDiseasename().equals(rs
							.getString("diseaseName"))) {
				ds.add(new DiseaseShortInfo(rs.getString("diseaseName")));
			}
			ds.get(ds.size() - 1).addTagname(rs.getString("tagName"));
		}
		DiseaseShortInfoList result = new DiseaseShortInfoList(ds);
		return result;
	}

	public DiseaseDetailInfo getDiseaseDetail(String diseasename)
			throws SQLException, ClassNotFoundException {
		ResultSet rs1 = con.createStatement().executeQuery(
				"SELECT * FROM diseaseData WHERE diseaseName = '" + diseasename
						+ "'");
		ResultSet rs2 = con.createStatement().executeQuery(
				"SELECT tagName, count(*) as num FROM takeDrug WHERE diseaseName = '"
						+ diseasename + "' GROUP BY tagName ORDER BY num");
		if (rs1.next()) {
			DiseaseDetailInfo result = new DiseaseDetailInfo(
					rs1.getString("diseaseName"),
					rs1.getString("diseaseIntro"), rs1.getDate("editTime"));
			//get user info list from userData
			IUserData itf = new UserDataProxy();
			
			result.setUserOfThis(itf.searchUser(diseasename).getUserResultPage(1, 10));
			
			while (rs2.next()) {
				result.addDrug(new DrugInfo(rs2.getString("tagName"), rs2
						.getInt("num")));
			}
			return result;
		} else {
			return null;
		}
	}

}
