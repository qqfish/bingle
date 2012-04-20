package businessServices.forumSystem;

import java.sql.SQLException;
import baseUse.ForumList;
import baseUse.Globalization;
import baseUse.IForumSystem;
import baseUse.TopicDetail;
import baseUse.TopicListDetail;

public class ForumProxy implements IForumSystem {
	private CurrentForumList currentForumList;
	private CurrentTopic currentTopic;
	
	public ForumProxy(){
		currentForumList = new CurrentForumList();
		currentTopic = new CurrentTopic();
	}
	
	@Override
	public TopicListDetail getTopicList(String topicListName) throws SQLException {
		// TODO Auto-generated method stub
		return currentForumList.getTopicList(topicListName);
	}

	@Override
	public TopicDetail getTopic(int topicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTopic(int topicId,String listName) throws SQLException {
		// TODO Auto-generated method stub
		currentTopic.deleteTopic(topicId);
		currentForumList.updateTopicList(listName);
	}

	@Override
	public void deleteReply(int replyId,int topicId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ForumList getForumList() throws SQLException {
		// TODO Auto-generated method stub
		return Globalization.forumData.getForumList();
	}

	@Override
	public void newTopic(String topicName, String userName, String content,
			String topicListName) throws SQLException {
		// TODO Auto-generated method stub
		Globalization.forumData.newTopic(topicName,userName,content,topicListName);
		currentForumList.updateTopicList(topicListName);
	}

	@Override
	public void newReply(String content, int topicId, String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editRelpy(int Reply, String content) {
		// TODO Auto-generated method stub

	}

}
