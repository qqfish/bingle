package baseUse;

public class ForumInfo {
	private String topicListName;
	private String[] tagName;
	
	public ForumInfo(String tln,String[] tn){
		topicListName = tln;
		tagName = tn;
	}

	public void setTopicName(String tn){
		topicListName = tn;
	}
}
