package baseUse;

import java.util.List;

public class FriendList {
	/** @pdOid 4f716928-e6fa-4b62-a1d4-78ad5cb2e8f6 */
	private List friend;
	
	public FriendList(){}
	
	public void add(String friendname){
		friend.add(friendname);
	}
	
	public void delete(String friendname){
		friend.remove(friendname);
	}
	
}
