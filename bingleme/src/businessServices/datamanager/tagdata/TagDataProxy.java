package businessServices.datamanager.tagdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import baseUse.ITagData;
import baseUse.TagAlternate;
import baseUse.TagData;
import baseUse.TagDataList;

public class TagDataProxy implements ITagData {

	private Connection con;

	public TagDataProxy() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/bingleme?user=root&password=123");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public List<String> searchTagName(String keyword, char typename)
			throws SQLException {
		List<String> result = new ArrayList<String>();
		ResultSet rs = con.createStatement().executeQuery(
				"SELECT tagName FROM tagAlternate WHERE tagAlternateName like '%"
						+ keyword + "%' and tagType = '" + typename + "'");
		while (rs.next()) {
			result.add(rs.getString("tagName"));
		}
		return result;
	}

	@Override
	public void updateTagDatabase(TagDataList content) {
		for(int i = 0; i < content.getTag().size()){
			if(content.getTag().get(i).getStatus() == 'a'){
				
			}
			else if(content.getTag().get(i).getStatus() == 'd'){
				
			}
			else if(content.getTag().get(i).getStatus() == 'e'){
				
			}
		}
	}

	@Override
	public TagData getTagData(String tagname, char typename)
			throws SQLException {
		Statement st = con.createStatement();
		ResultSet rs1 = st
				.executeQuery("SELECT tagAlternateName FROM tagAlternate WHERE tagName = '"
						+ tagname + "' and tagType = '" + typename + "'");
		ResultSet rs2 = st
				.executeQuery("SELECT tagIntro FROM tag WHERE tagName = '"
						+ tagname + "' and tagType = '" + typename + "'");
		List<TagAlternate> ta = new ArrayList<TagAlternate>();
		while(rs1.next()){
			ta.add(new TagAlternate(tagname, rs1.getString("tagAlternateName"), 'u'));
		}
		if(rs2.next()){
			TagData result = new TagData(tagname , rs2.getString("tagIntro"), ta, 'u');
			return result;
		}
		else{
			return null;
		}

	}

}
