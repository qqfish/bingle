package baseUse.forumData;

public class Reply {
	private String content;
	private int replyId;
	private String author;
	private String editTime;
	Reply(String c,int ri,String a,String et){
		content = c;
		replyId = ri;
		author = a;
		editTime = et;
	}
	
	public void setContent(String c){
		content = c;
	}
	public void setReplyId(int ri){
		replyId = ri;
	}
	public void setAuthor(String a){
		author = a;
	}
	public void setEditTime(String et){
		editTime = et;
	}
	
	public String getContent(){
		return content;
	}
	public int getReplyId(){
		return replyId;
	}
	public String getAuthor(){
		return author;
	}
	public String getEditTime(){
		return editTime;
	}
}
