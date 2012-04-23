package baseUse;

import java.sql.SQLException;

public interface IForumSystem {
	TopicListDetail getTopicList(String topicListName) throws SQLException;
	TopicDetail	getTopic(int topicId) throws SQLException;
	void deleteTopic(int topicId,String listName) throws SQLException;
	void deleteReply(int replyId,int topicId) throws SQLException;
	ForumList getForumList() throws SQLException;
	void newTopic(String topicName,String userName,String content,String topicListName) throws SQLException;
	void newReply(String content,int topicId,String userName) throws SQLException;
	void editRelpy(int replyId,int topicId,String content) throws SQLException;
}
