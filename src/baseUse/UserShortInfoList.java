package baseUse;

import java.util.List;

public class UserShortInfoList {
	/** @pdOid 3bc6c3eb-ead2-477c-a3fb-adda0b1496fa */
	private List<UserShortInfo> userResult;

	public UserShortInfoList(List<UserShortInfo> u){
		userResult = u;
	}
	
	public void setUserResult(List<UserShortInfo> u){
		userResult = u;
	}
	
	public void add(String username, String currentDisease, List<String> tagName, Short age, Boolean gender){
		userResult.add(new UserShortInfo(username, currentDisease, tagName, age, gender));
	}
	
	public List<UserShortInfo> getUserResult(){
		return userResult;
	}
	
	public List<UserShortInfo> getUserResultPage(int page, int perPage){
		int begin = perPage * (page - 1) - 1;
		int end = perPage * page - 1;
		if(begin > userResult.size()){
			return null;
		}
		if(end > userResult.size()){
			end = userResult.size() - 1;
		}
		List<UserShortInfo> result = userResult.subList(begin, end);
		return result;
	}
}
