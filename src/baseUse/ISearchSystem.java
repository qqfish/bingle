package baseUse;

import java.sql.SQLException;
import java.util.List;

public interface ISearchSystem {
	List<UserShortInfo> searchUser(String keyword, int page, int perPage) throws ClassNotFoundException, SQLException;
	List<UserShortInfo> searchUser(String keyword, int page) throws ClassNotFoundException, SQLException;
	UserDetailInfo getDetailUserInfo(String username) throws ClassNotFoundException, SQLException;
	List<DiseaseShortInfo> searchDisease(String keyword, int page, int perPage) throws ClassNotFoundException, SQLException;
	List<DiseaseShortInfo> searchDisease(String keyword, int page) throws ClassNotFoundException, SQLException;
	DiseaseDetailInfo getDiseaseDetail(String diseasename) throws SQLException, ClassNotFoundException;
}
