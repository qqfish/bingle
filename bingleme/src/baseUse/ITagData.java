package baseUse;

import java.sql.SQLException;
import java.util.List;

public interface ITagData {
	/**
	 * @param keyword
	 * @throws SQLException 
	 * @pdOid ea682201-110c-4ed7-a860-171d50111d44
	 */
	List<String> searchTagName(String keyword, char typename) throws SQLException;

	/**
	 * @param content
	 * @pdOid a52293c0-4a4f-409c-850e-33263afb7bc0
	 */
	void updateTagDatabase(TagDataList content);

	/**
	 * @param tagname
	 * @throws SQLException 
	 * @pdOid 15ac697c-37fd-4d5d-bda1-2dae6d68bb50
	 */
	TagData getTagData(String tagname, char typename) throws SQLException;
}
