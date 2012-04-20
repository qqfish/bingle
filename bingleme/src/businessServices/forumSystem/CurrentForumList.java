package businessServices.forumSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baseUse.Globalization;
import baseUse.TopicListDetail;

public class CurrentForumList {
	List<TopicListDetail> topicList;
	DeleteTopic deleteTopic;
	
	public CurrentForumList(){
		topicList = new ArrayList();
		deleteTopic = new DeleteTopic();
	}
	
	TopicListDetail getTopicList(String topicListName) throws SQLException{
		for(int i =0;i < topicList.size();i++){
			if(topicList.get(i).getTopicListName() == topicListName)
				return topicList.get(i);
		}
		TopicListDetail tld = Globalization.forumData.getTopicList(topicListName);	
		topicList.add(tld);
		return tld;
	}
	void deleteTopic(int topicId,String listName) throws SQLException{
		deleteTopic.deleteTopic(topicId);
		updateTopicList(listName);
	}
	void updateTopicList(String topicListName) throws SQLException{
		for(int i =0;i < topicList.size();i++){
			if(topicList.get(i).getTopicListName() == topicListName){
				TopicListDetail tld = Globalization.forumData.getTopicList(topicListName);
				topicList.set(i, tld);
				break;
			}
		}
	}
}
