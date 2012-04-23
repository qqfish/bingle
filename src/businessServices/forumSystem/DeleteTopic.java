package businessServices.forumSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baseUse.Globalization;

public class DeleteTopic {
	List<Integer> topicIds;
	
	public DeleteTopic(){
		topicIds = new ArrayList<Integer>();
	}
	
	void deleteTopic(int topicId){
		topicIds.add(topicId);
	}
	void updateDatabase() throws SQLException{
		int[] i = new int[topicIds.size()];
		Globalization.forumData.deleteTopic(i);
	}
}
