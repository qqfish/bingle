package businessServices.forumSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baseUse.Global;
import baseUse.TopicListDetail;

public class CurrentForumList {
	List<TopicListDetail> topicList;
	DeleteTopic deleteTopic;
	
	public CurrentForumList(){
		topicList = new ArrayList<TopicListDetail>();
		deleteTopic = new DeleteTopic();
	}
	
	TopicListDetail getTopicList(String topicListName) throws SQLException, ClassNotFoundException{
		for(int i =0;i < topicList.size();i++){
			if(topicList.get(i).getTopicListName() == topicListName)
				return topicList.get(i);
		}
		TopicListDetail tld = Global.iForumData().getTopicList(topicListName);
		topicList.add(tld);
		return tld;
	}
	void deleteTopic(int topicId,String listName) throws SQLException, ClassNotFoundException{
		deleteTopic.deleteTopic(topicId);
		updateTopicList(listName);
	}
	void updateTopicList(String topicListName) throws SQLException, ClassNotFoundException{
		for(int i =0;i < topicList.size();i++){
			if(topicList.get(i).getTopicListName() == topicListName){
				TopicListDetail tld = Global.iForumData().getTopicList(topicListName);
				topicList.set(i, tld);
				break;
			}
		}
	}
}
