package baseUse;

import java.util.List;

public class ForumList {
	private List<ForumInfo> forum;
	public void setForumList(String tln,String[] tn){
		ForumInfo forumlist = new ForumInfo(tln,tn);
		forum.add(forumlist);
	}
}
