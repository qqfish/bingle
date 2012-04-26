package baseUse;

import java.util.List;

public class UserShortInfoList {
	/** @pdOid 3bc6c3eb-ead2-477c-a3fb-adda0b1496fa */
	private List<UserShortInfo> userResult;
	private int num;

	public UserShortInfoList(List<UserShortInfo> u){
		userResult = u;
		num = u.size();
	}
	
	public void setUserResult(List<UserShortInfo> u){
		userResult = u;
	}
	
	public void setNum(int n){
		num = n;
	}
	
	public void add(String username, String currentDisease, List<String> tagName, Short age, Boolean gender){
		userResult.add(new UserShortInfo(username, currentDisease, tagName, age, gender));
	}
	
	public int getNum(){
		return num;
	}
	
	public List<UserShortInfo> getUserResult(){
		return userResult;
	}
	
	public List<UserShortInfo> getUserResultPage(int page, int perPage){
		int begin = perPage * (page - 1);
		int end = perPage * page ;
		if(begin > userResult.size()){
			return null;
		}
		if(end > userResult.size()){
			end = userResult.size();
		}
		List<UserShortInfo> result = userResult.subList(begin, end);
		return result;
	}
}
