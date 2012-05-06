package baseUse;

import java.sql.SQLException;

import baseUse.forumData.ForumList;
import baseUse.forumData.TopicDetail;
import baseUse.forumData.TopicListDetail;

public interface IForumData {
	void deleteReply(int[] replyId) throws SQLException;
	void deleteTopic(int[] topicId) throws SQLException;
	TopicDetail getTopic(int topicId) throws SQLException;
	TopicListDetail getTopicList(String topicListName) throws SQLException;
	ForumList getForumList() throws SQLException;
	void newTopic(String topicName,String userName,String content,String topicListName) throws SQLException;
	void newReply(String content,int topicId,String userName) throws SQLException;
	void editReply(int replyId,String content) throws SQLException;
}
