package baseUse;

import java.sql.SQLException;

import baseUse.searchData.DiseaseDetailInfo;
import baseUse.searchData.DiseaseShortInfoList;
import baseUse.wikiData.DiseaseDataList;

public interface IDiseaseData {
	/**
	 * @param content
	 * @throws SQLException 
	 * @pdOid b1f9c619-a4b6-4c5a-a0b5-b128ed343474
	 */
	void updateDiseaseDatabase(DiseaseDataList content) throws SQLException;

	/**
	 * @param keyword
	 * @throws SQLException 
	 * @pdOid 15550abb-059f-40a2-8590-ef5b69d4a720
	 */
	DiseaseShortInfoList searchDisease(String keyword) throws SQLException;

	/**
	 * @param diseasename
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @pdOid b605bb3c-2213-42ce-99d3-c5e711b0e52a
	 */
	DiseaseDetailInfo getDiseaseDetail(String diseasename) throws SQLException, ClassNotFoundException;
}
