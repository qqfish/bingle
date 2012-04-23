package businessServices.forumSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baseUse.Global;

public class DeleteTopic {
	List<Integer> topicIds;
	
	public DeleteTopic(){
		topicIds = new ArrayList<Integer>();
	}
	
	void deleteTopic(int topicId){
		topicIds.add(topicId);
	}
	void updateDatabase() throws SQLException, ClassNotFoundException{
		int[] i = new int[topicIds.size()];
		Global.iForumData().deleteTopic(i);
	}
}
