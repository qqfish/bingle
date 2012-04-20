package baseUse;

import java.util.ArrayList;
import java.util.List;

public class TopicListDetail {
	private String topicListName;
	private int topicNum;
	private List<TopicInfo> topic;
	
	public TopicListDetail(){
		topic = new ArrayList();
	}
	public void setTopicListName(String tln){
		topicListName = tln;
	}
	public void setTopicNum(int tn){
		topicNum = tn;
	}
	public void setTopic(String tn,int ti,String a,int vn,int rn,String fet,String let){
		TopicInfo tmp = new TopicInfo(tn,ti,a,vn,rn,fet,let);
		topic.add(tmp);
	}
	
	public String getTopicListName(){
		return topicListName;
	}
	public int getTopicNum(){
		return topicNum;
	}
	public List<TopicInfo> getTopicInfo(){
		return topic;
	}
	
	public void deleteTopic(int topicId){
		for(int i=0;i < topic.size();i++){
			if(topic.get(i).getTopicId() == topicId){
				topic.remove(i);
				break;
			}
		}
	}
}