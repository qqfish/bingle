package businessServices.searchSystem;

import java.sql.SQLException;
import java.util.List;

import baseUse.DiseaseDetailInfo;
import baseUse.DiseaseShortInfo;
import baseUse.DiseaseShortInfoList;
import baseUse.Global;
import baseUse.IDiseaseData;
import baseUse.ISearchSystem;
import baseUse.IUserData;
import baseUse.UserDetailInfo;
import baseUse.UserShortInfo;
import baseUse.UserShortInfoList;
import businessServices.datamanager.diseasedata.DiseaseDataProxy;
import businessServices.datamanager.userdata.UserDataProxy;

public class SearchSystemProxy implements ISearchSystem {

	@Override
	public UserDetailInfo getDetailUserInfo(String username)
			throws ClassNotFoundException, SQLException {
		UserDetailInfo result = (UserDetailInfo) Global.cache().getCache(
				"UserDetailInfo", username);
		if (result == null) {
			IUserData itf = new UserDataProxy();
			result = itf.getDetailUserInfo(username);
			if (result != null) {
				Global.cache().insert("UserDetailInfo", username, result);
			}
		}
		return result;
	}

	@Override
	public DiseaseDetailInfo getDiseaseDetail(String diseasename)
			throws SQLException, ClassNotFoundException {
		DiseaseDetailInfo result = (DiseaseDetailInfo) Global.cache().getCache(
				"DiseaseDetailInfo", diseasename);
		if (result == null) {
			IDiseaseData itf = new DiseaseDataProxy();
			result = itf.getDiseaseDetail(diseasename);
			if (result != null) {
				Global.cache().insert("DiseaseDetailInfo", diseasename, result);
			}
		}
		return result;
	}

	@Override
	public UserShortInfoList searchUser(String keyword, int page, int perPage)
			throws ClassNotFoundException, SQLException {
		UserShortInfoList resultlist = (UserShortInfoList) Global.cache()
				.getCache("UserShortInfoList", keyword);
		if (resultlist == null) {
			IUserData itf = new UserDataProxy();
			resultlist = itf.searchUser(keyword);
			if (resultlist != null) {
				Global.cache().insert("UserShortInfoList", keyword, resultlist);
			}
		}
		List<UserShortInfo> currentList = resultlist.getUserResultPage(page, perPage);
		UserShortInfoList result = new UserShortInfoList(currentList);
		result.setNum(resultlist.getNum());
		return result;
	}

	@Override
	public DiseaseShortInfoList searchDisease(String keyword, int page,
			int perPage) throws ClassNotFoundException, SQLException {
		DiseaseShortInfoList resultlist = (DiseaseShortInfoList) Global.cache()
				.getCache("DiseaseShortInfoList", keyword);
		if (resultlist == null) {
			IDiseaseData itf = new DiseaseDataProxy();
			resultlist = itf.searchDisease(keyword);
			if (resultlist != null) {
				Global.cache().insert("DiseaseShortInfoList", keyword,
						resultlist);
			}
		}
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
