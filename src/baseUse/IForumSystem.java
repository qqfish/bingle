package baseUse;

import java.sql.SQLException;

public interface IForumSystem {
	TopicListDetail getTopicList(String topicListName) throws SQLException, ClassNotFoundException;
	TopicDetail	getTopic(int topicId) throws SQLException, ClassNotFoundException;
	void deleteTopic(int topicId,String listName) throws SQLException, ClassNotFoundException;
	void deleteReply(int replyId,int topicId) throws SQLException, ClassNotFoundException;
	ForumList getForumList() throws SQLException, ClassNotFoundException;
	void newTopic(String topicName,String userName,String content,String topicListName) throws SQLException, ClassNotFoundException;
	void newReply(String content,int topicId,String userName) throws SQLException, ClassNotFoundException;
	void editRelpy(int replyId,int topicId,String content) throws SQLException, ClassNotFoundException;
}
