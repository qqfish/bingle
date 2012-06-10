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
	private String userCache;
	
	public BTalkProxy(){
		talkCache = "currentTalkUser";
		userCache = "currentUser";
	}

	@Override
	public FriendList getFriendList(String username) throws SQLException {
		IUserData itf = new UserDataProxy();
		Global.cache().insert(talkCache, username, itf.getMessage(username));
		Global.cache().insert(userCache, username, "1");
		return itf.getFriendList(username);
	}

	@Override
	public void sendMessage(String from, String to, String content) throws SQLException {
		MessageList ml = (MessageList) Global.cache().getCache(talkCache, to);
		String online = (String) Global.cache().getCache(userCache, to);
		if(online == null){
			IUserData itf = new UserDataProxy();
			itf.saveMessage(from, to, content);
		} else{
			if(ml == null){
				ml = new MessageList();
				ml.setUsername(to);
			}
			ml.addMessage(from, content);
			System.out.println(Global.cache().updateOne(talkCache, to, ml));
		}
		
	}

	@Override
	public MessageList getMessage(String username) {
		MessageList result = (MessageList) Global.cache().getCache(talkCache, username);
		if(result == null){
			result = new MessageList();
			result.setUsername(username);
		}
		//System.out.println(result.getNewMessage().get(0).getContent());
		Global.cache().deleteCache(talkCache, username);
		return result;
	}

	@Override
	public void logoutTalk(String username) {
		// leave blank now save the message for a while
		
	}

	@Override
	public void addFriend(String username, String friendname) throws SQLException {
		IUserData itf = new UserDataProxy();
		itf.addFriend(username, friendname);
		itf.addFriend(friendname, username);
		
	}

	@Override
	public void deleteFriend(String username, String friendname) throws SQLException {
		IUserData itf = new UserDataProxy();
		itf.deleteFriend(username, friendname);
		itf.deleteFriend(friendname, username);
		
	}
	
	public static void main(String[] args) throws SQLException{
		BTalkProxy a = new BTalkProxy();
		a.sendMessage("aa", "yx", "aaaa");
	}

}
