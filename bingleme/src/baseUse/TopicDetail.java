package baseUse;

import java.util.List;


public class TopicDetail {
	private String topicName;
	private int topicId;
	private String author;
	private int viewNum;
	private int replyNum;
	private String firstEditTime;
	private String lastEditTime;
	private List<Reply> reply;
	
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
	public void setReply(String c,int ri,String a,String et){
		Reply tmp = new Reply(c,ri,a,et);
		reply.add(tmp);
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
	
	public void deleteReply(int ReplyId){
		for(int i=0;i < reply.size();i++){
			if(reply.get(i).getReplyId() == ReplyId){
				reply.remove(i);
				break;
			}
		}
	}
	public void deleteAll(){
		for(int i=0;i < reply.size();i++){
			reply.remove(i);
		}
	}
}
