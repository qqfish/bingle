package baseUse;

import java.sql.SQLException;

import baseUse.bTalkData.FriendList;
import baseUse.bTalkData.MessageList;

public interface IBTalkSystem {
	FriendList getFriendList(String username) throws SQLException;

	void sendMessage(String from, String to, String content) throws SQLException;

	MessageList getMessage(String username);

	void logoutTalk(String username);

	void addFriend(String username, String friendname) throws SQLException;

	void deleteFriend(String username, String friendname) throws SQLException;
}
