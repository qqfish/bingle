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

	public TagDataProxy() throws SQLException, ClassNotFoundException {
		Class.forName("org.git.mm.mysql.Driver");
		con = DriverManager
				.getConnection("jdbc:mysql://localhost/bingle?user=root&password=zy102428");
	}

	
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
	public void updateTagDatabase(TagDataList content) throws SQLException {
		Statement st = con.createStatement();
		for (int i = 0; i < content.getTag().size(); i++) {
			TagData current = content.getTag().get(i);
			if (current.getStatus() == 'n') {
				st.executeUpdate("INSERT INTO tag (tagName, tagIntro, tagType) VALUES ('"
						+ current.getTagname()
						+ "' , '"
						+ current.getTagIntro()
						+ "' , '"
						+ current.getType()
						+ "')");
				for (int j = 0; j < current.getAlterName().size(); j++) {
					TagAlternate currentAl = current.getAlterName().get(j);
					st.executeUpdate("INSERT INTO tagAlternate (tagName, tagAlternateName, tagType) VALUES ('"
							+ current.getTagname()
							+ "' , '"
							+ currentAl.getAlternateName()
							+ "' , '"
							+ current.getType() + "')");
				}

			} else if (current.getStatus() == 'd') {
				st.executeUpdate("DELETE FROM tagAlternate WHERE tagName = '"
						+ current.getTagname() + "' and tagType = '"
						+ current.getType() + "'");
				st.executeUpdate("DELETE FROM tag WHERE tagName = '"
						+ current.getTagname() + "' and tagType = '"
						+ current.getType() + "'");
			} else if (current.getStatus() == 'c') {
				st.executeUpdate("UPDATE tag SET tagIntro = '"
						+ current.getTagIntro() + "' WHERE tagName = '"
						+ current.getTagname() + "' and tagType = '"
						+ current.getType() + "'");
				for (int j = 0; j < current.getAlterName().size(); j++) {
					TagAlternate currentAl = current.getAlterName().get(j);
					if (currentAl.getStatus() == 'n') {
						st.executeUpdate("INSERT INTO tagAlternate (tagName, tagAlternateName, tagType) VALUES ('"
								+ current.getTagname()
								+ "' , '"
								+ currentAl.getAlternateName()
								+ "' , '"
								+ current.getType() + "')");
					} else if (currentAl.getStatus() == 'd') {
						st.executeUpdate("DELETE FROM tagAlternate WHERE tagName = '"
								+ current.getTagname()
								+ "' and tagAlternateName = '"
								+ currentAl.getAlternateName()
								+ "' and tagType = '" + current.getType() + "'");
					}
				}
			}
		}
	}

	public TagData getTagData(String tagname, char typename)
			throws SQLException {
		Statement st = con.createStatement();
		ResultSet rs1 = st
				.executeQuery("SELECT tagAlternateName FROM tagAlternate WHERE tagName = '"
						+ tagname + "' and tagType = '" + typename + "'");
		List<TagAlternate> ta = new ArrayList<TagAlternate>();
		while (rs1.next()) {
			ta.add(new TagAlternate(rs1.getString("tagAlternateName"), 'u'));
		}
		ResultSet rs2 = st
				.executeQuery("SELECT tagIntro FROM tag WHERE tagName = '"
						+ tagname + "' and tagType = '" + typename + "'");
		if (rs2.next()) {
			TagData result = new TagData(tagname, rs2.getString("tagIntro"),
					ta, 'u' , typename);
			return result;
		} else {
			return null;
		}

	}
	
}
