package businessServices.forumSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baseUse.Global;

public class DeleteReply {
	List<Integer> replyIds;
	
	public DeleteReply(){
		replyIds = new ArrayList<Integer>();
	}
	
	void deleteReply(int replyId){
		replyIds.add(replyId);
	}
	void updataDataBase() throws SQLException{
		int[] i = new int[replyIds.size()];
		Global.iForumData().deleteReply(i);
	}
}
