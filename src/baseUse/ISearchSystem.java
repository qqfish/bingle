package baseUse;

import java.sql.SQLException;

public interface ISearchSystem {
	UserShortInfoList searchUser(String keyword, int page, int perPage) throws ClassNotFoundException, SQLException;
	UserShortInfoList searchUser(String keyword, int page) throws ClassNotFoundException, SQLException;
	UserDetailInfo getDetailUserInfo(String username) throws ClassNotFoundException, SQLException;
	DiseaseShortInfoList searchDisease(String keyword, int page, int perPage) throws ClassNotFoundException, SQLException;
	DiseaseShortInfoList searchDisease(String keyword, int page) throws ClassNotFoundException, SQLException;
	DiseaseDetailInfo getDiseaseDetail(String diseasename) throws SQLException, ClassNotFoundException;
}
