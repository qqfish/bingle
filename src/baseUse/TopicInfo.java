package baseUse;

public class TopicInfo {
	private String topicName;
	private int topicId;
	private String author;
	private int viewNum;
	private int replyNum;
	private String firstEditTime;
	private String lastEditTime;
	
	public TopicInfo(){
	}
	public TopicInfo(String tn,int ti,String a,int vn,int rn,String fet,String let){
		topicName = tn;
		topicId = ti;
		author = a;
		viewNum = vn;
		replyNum = rn;
		firstEditTime = fet;
		lastEditTime = let;
	}
	public void setTopicName(String tn){
		topicName = tn;
	}
	public void setTopicId(int ti){
		topicId = ti;
	}
	public void setAuthor(String a){
		author = a;
	}
	public void setViewNum(int vn){
		viewNum = vn;
	}
	public void setReplyNum(int rn){
		replyNum = rn;
	}
	public void setFirstEditTime(String fet){
		firstEditTime = fet;
	}
	public void setLastEditTime(String let){
		lastEditTime = let;
	}
	
	public String getTopicName(){
		return topicName;
	}
	public int getTopicId(){
		return topicId;
	}
	public String getAuthor(){
		return author;
	}
	public int getViewNum(){
		return viewNum;
	}
	public int getReplyNum(){
		return replyNum;
	}
	public String getFirstEditTime(){
		return firstEditTime;
	}
	public String getLastEditTime(){
		return lastEditTime;
	}
}
