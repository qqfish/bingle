package businessServices.searchSystem;

import java.sql.SQLException;
import java.util.List;

import baseUse.Global;
import baseUse.IDiseaseData;
import baseUse.ISearchSystem;
import baseUse.IUserData;
import baseUse.searchData.DiseaseDetailInfo;
import baseUse.searchData.DiseaseShortInfo;
import baseUse.searchData.DiseaseShortInfoList;
import baseUse.searchData.UserDetailInfo;
import baseUse.searchData.UserShortInfo;
import baseUse.searchData.UserShortInfoList;
import businessServices.datamanager.diseasedata.DiseaseDataProxy;
import businessServices.datamanager.userdata.UserDataProxy;

public class SearchSystemProxy implements ISearchSystem {

	@Override
	public UserDetailInfo getDetailUserInfo(String username)
			throws ClassNotFoundException, SQLException {
		
		IUserData itf = new UserDataProxy();
		UserDetailInfo result = itf.getDetailUserInfo(username);
			
		return result;
	}

	@Override
	public DiseaseDetailInfo getDiseaseDetail(String diseasename)
			throws SQLException, ClassNotFoundException {
		DiseaseDetailInfo result;
		IDiseaseData itf = new DiseaseDataProxy();
		result = itf.getDiseaseDetail(diseasename);
		return result;
	}

	@Override
	public UserShortInfoList searchUser(String keyword, int page, int perPage)
			throws ClassNotFoundException, SQLException {
		UserShortInfoList resultlist;
		IUserData itf = new UserDataProxy();
		resultlist = itf.searchUser(keyword);
			
		List<UserShortInfo> currentList = resultlist.getUserResultPage(page, perPage);
		UserShortInfoList result = new UserShortInfoList(currentList);
		result.setNum(resultlist.getNum());
		return result;
	}

	@Override
	public DiseaseShortInfoList searchDisease(String keyword, int page,
			int perPage) throws ClassNotFoundException, SQLException {
		DiseaseShortInfoList resultlist;
		IDiseaseData itf = new DiseaseDataProxy();
		resultlist = itf.searchDisease(keyword);
			
		List<DiseaseShortInfo> currentList = resultlist.getDiseaseResultPage(page, perPage);
		DiseaseShortInfoList result = new DiseaseShortInfoList(currentList);
		result.setNum(resultlist.getNum());
		return result;
	}

	@Override
	public UserShortInfoList searchUser(String keyword, int page)
			throws ClassNotFoundException, SQLException {
		return searchUser(keyword, page, 25);
	}

	@Override
	public DiseaseShortInfoList searchDisease(String keyword, int page) throws ClassNotFoundException, SQLException {
		return searchDisease(keyword, page, 25);
	}

}
