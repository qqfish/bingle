package businessServices.forumSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baseUse.Globalization;

public class DeleteReply {
	List<Integer> replyIds;
	
	public DeleteReply(){
		replyIds = new ArrayList();
	}
	
	void deleteReply(int replyId){
		replyIds.add(replyId);
	}
	void updataDataBase() throws SQLException{
		int[] i = new int[replyIds.size()];
		Globalization.forumData.deleteReply(i);
	}
}
