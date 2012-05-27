package businessServices.forumSystem;

import java.sql.SQLException;
import baseUse.Global;
import baseUse.IForumData;
import baseUse.IForumSystem;
import baseUse.forumData.ForumList;
import baseUse.forumData.TopicDetail;
import baseUse.forumData.TopicListDetail;
import businessServices.datamanager.forumdata.ForumDataProxy;

public class ForumProxy implements IForumSystem {
	
	public ForumProxy(){
		super();
	}
	
	@Override
	public TopicListDetail getTopicList(String topicListName) throws SQLException, ClassNotFoundException {
		//TopicListDetail result = (TopicListDetail) Global.cache().getCache("CurrentForumList", topicListName);
		//if(result == null){
			IForumData  itf = new ForumDataProxy();
			TopicListDetail result = itf.getTopicList(topicListName);
			//if(result != null){
				//Global.cache().insert("CurrentForumList", topicListName, result);
			//}
		//}
		return result;
	}

	@Override
	public TopicDetail getTopic(int topicId) throws SQLException, ClassNotFoundException {
		//TopicDetail result = (TopicDetail) Global.cache().getCache("CurrentTopic", String.valueOf(topicId));
		//if(result == null){
			IForumData itf = new ForumDataProxy();
			TopicDetail result = itf.getTopic(topicId);
			itf.visitTopic(topicId);
			//if(result != null){
			//	Global.cache().insert("CurrentTopic", String.valueOf(topicId), result);
			//}
		//}
		return result;
	}

	@Override
	public void deleteTopic(int topicId,String listName) throws SQLException, ClassNotFoundException {
		//Global.cache().deleteCache("CurrentTopic", String.valueOf(topicId));
		//Global.cache().deleteCache("CurrentForumList", listName);
		IForumData itf = new ForumDataProxy();
		int del[] = new int[1];
		del[0] = topicId;
		itf.deleteTopic(del);
	}

	@Override
	public void deleteReply(int replyId,int topicId) throws SQLException, ClassNotFoundException {
		//Global.cache().deleteCache("CurrentTopic", String.valueOf(topicId));
		IForumData itf = new ForumDataProxy();
		int del[] = new int[1];
		del[0] = replyId;
		itf.deleteReply(del);
	}

	@Override
	public ForumList getForumList() throws SQLException, ClassNotFoundException {
		IForumData itf = new ForumDataProxy();
		return itf.getForumList();
	}

	@Override
	public void newTopic(String topicName, String userName, String content,
			String topicListName) throws SQLException, ClassNotFoundException {
		IForumData itf = new ForumDataProxy();
		itf.newTopic(topicName,userName,content,topicListName);
		//Global.cache().deleteCache("CurrentForumList", topicListName);
	}

	@Override
	public void newReply(String content, int topicId, String userName) throws SQLException {
		// TODO Auto-generated method stub
		IForumData itf = new ForumDataProxy();
		itf.newReply(content, topicId, userName);
		//Global.cache().deleteCache("CurrentTopic", String.valueOf(topicId));
	}

	@Override
	public void editRelpy(int replyId, int topicId, String content) throws SQLException, ClassNotFoundException {
		IForumData itf = new ForumDataProxy();
		itf.editReply(replyId, content);
		//Global.cache().deleteCache("CurrentTopic", String.valueOf(topicId));
	}	

}
