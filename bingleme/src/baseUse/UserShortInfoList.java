package baseUse;

import java.util.List;

public class UserShortInfoList {
	/** @pdOid 3bc6c3eb-ead2-477c-a3fb-adda0b1496fa */
	private List<UserShortInfo> userResult;

	public UserShortInfoList(List<UserShortInfo> u){
		userResult = u;
	}
	
	public void add(String username, String currentDisease, List<String> tagName, Short age, Boolean gender){
		userResult.add(new UserShortInfo(username, currentDisease, tagName, age, gender));
	}
	
	public List<UserShortInfo> getUserResult(){
		return userResult;
	}
}
