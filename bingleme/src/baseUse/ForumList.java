package baseUse;

import java.util.ArrayList;
import java.util.List;

public class ForumList {
	private List<ForumInfo> forum;
	
	public ForumList(){
		forum = new ArrayList();
	}
	
	public void setForumList(String tln,List<String> tn){
		ForumInfo forumlist = new ForumInfo(tln,tn);
		forum.add(forumlist);
	}
	
	public List<ForumInfo> getForumList(){
		return forum;
	}
}
