package businessServices.bTalkSystem;

import java.sql.SQLException;

import baseUse.Global;
import baseUse.IBTalkSystem;
import baseUse.IUserData;
import baseUse.bTalkData.FriendList;
import baseUse.bTalkData.MessageList;
import businessServices.datamanager.userdata.UserDataProxy;

public class BTalkProxy implements IBTalkSystem{
	
	private String talkCache;
	
	public BTalkProxy(){
		talkCache = "currentTalkUser";
	}

	@Override
	public FriendList getFriendList(String username) throws SQLException {
		IUserData itf = new UserDataProxy();
		Global.cache().insert(talkCache, username, itf.getMessage(username));
		return itf.getFriendList(username);
	}

	@Override
	public void sendMessage(String from, String to, String content) throws SQLException {
		MessageList ml = (MessageList) Global.cache().getCache(talkCache, to);
		if(ml == null){
			IUserData itf = new UserDataProxy();
			itf.saveMessage(from, to, content);
		} else{
			ml.addMessage(from, content);
			Global.cache().updateOne(talkCache, to, ml);
		}
		
	}

	@Override
	public MessageList getMessage(String username) {
		return (MessageList) Global.cache().getCache(talkCache, username);
	}

	@Override
	public void logoutTalk(String username) {
		// leave blank now save the message for a while
		
	}

	@Override
	public void addFriend(String username, String friendname) throws SQLException {
		IUserData itf = new UserDataProxy();
		itf.addFriend(username, friendname);
		
	}

	@Override
	public void deleteFriend(String username, String friendname) throws SQLException {
		IUserData itf = new UserDataProxy();
		itf.deleteFriend(username, friendname);
		
	}

}
