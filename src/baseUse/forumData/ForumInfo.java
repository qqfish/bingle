package baseUse.forumData;

import java.util.List;

public class ForumInfo {
	private String topicListName;
	private List<String> tagName;
	
	public ForumInfo(String tln,List<String> tn){
		topicListName = tln;
		tagName = tn;
	}
	
	public String getTopicListName(){
		return topicListName;
	}
	public List<String> getTagName(){
		return tagName;
	}
}
