package baseUse;

import java.util.ArrayList;
import java.util.List;

public class FriendList {
	/** @pdOid 4f716928-e6fa-4b62-a1d4-78ad5cb2e8f6 */
	private List<String> friend;
	
	public FriendList(){
		friend = new ArrayList<String>();
	}
	
	public List<String> getFriendList(){
		return friend;
	}
	
	public void add(String friendname){
		friend.add(friendname);
	}
	
	public void delete(String friendname){
		friend.remove(friendname);
	}
}
	
