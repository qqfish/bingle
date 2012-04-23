package baseUse;

import java.sql.SQLException;

import businessServices.datamanager.diseasedata.DiseaseDataProxy;
import businessServices.datamanager.forumdata.ForumDataProxy;
import businessServices.datamanager.tagdata.TagDataProxy;
import businessServices.datamanager.userdata.UserDataProxy;
import businessServices.forumSystem.ForumProxy;

public class Global{
	private static IForumData forumData;
	private static IForumSystem forumSystem;
	private static IDiseaseData diseaseData;
	private static IUserData userData;
	private static ITagData tagData;
	
	public static IUserData iUserData() throws SQLException{
		if(userData == null){
			userData = new UserDataProxy();
		}
		return userData;
	}
	
	public static IDiseaseData iDiseaseData() throws SQLException{
		if(diseaseData == null){
			diseaseData = new DiseaseDataProxy(); 
		}
		return diseaseData;
	}
}