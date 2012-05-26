package baseUse;

import java.sql.SQLException;

import baseUse.wikiData.*;
import baseUse.wikiData.DiseaseData;
import baseUse.wikiData.DiseaseDataList;
import baseUse.wikiData.TagData;
import baseUse.wikiData.TagDataList;

public interface IWikiSystem {
	/**
	 * @param result
	 * @throws SQLException 
	 * @pdOid 8c544845-c80f-493d-b36b-e5fe5418f189
	 */
	void submitDisease(DiseaseDataList result) throws SQLException;

	/** @pdOid 51ea4868-7edf-4ec9-b60d-91e001294c3b */
	DiseaseDataList showDiseaseList();

	/**
	 * @param result
	 * @throws SQLException 
	 * @pdOid 78ffb6d1-ffd6-4087-98d9-0c7def9e5c5b
	 */
	void submitTag(TagDataList result) throws SQLException;

	/** @pdOid dad22213-4a23-465a-a8f1-cb019c51e8cb */
	TagDataList showTagList();

	/**
	 * @param content
	 * @pdOid 6dcb58b9-61b6-443c-8a0e-40918abca733
	 */
	void sendEditDisease(DiseaseData content);

	/**
	 * @param content
	 * @pdOid d59bfcbf-9a07-4d8a-8351-a6badd4bb66e
	 */
	void sendEditTag(TagData content);

	/**
	 * @param tagname
	 * @throws SQLException 
	 * @pdOid 4355c7c6-27d8-4c44-bd97-77a26a96fbca
	 */
	TagData getTagData(String tagname, char typename) throws SQLException;
}
