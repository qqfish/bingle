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
	
	public static IUserData iUserData() throws SQLException, ClassNotFoundException{
		if(userData == null){
			userData = new UserDataProxy();
		}
		return userData;
	}
	
	public static IDiseaseData iDiseaseData() throws SQLException, ClassNotFoundException{
		if(diseaseData == null){
			diseaseData = new DiseaseDataProxy(); 
		}
		return diseaseData;
	}
	
	public static IForumData iForumData() throws SQLException, ClassNotFoundException{
		if(forumData == null){
			forumData = new ForumDataProxy();
		}
		return forumData;
	}
	
	public static IForumSystem iForumSystem(){
		if(forumSystem == null){
			forumSystem = new ForumProxy();
		}
		return forumSystem;
	}
	
	public static ITagData iTagData() throws SQLException, ClassNotFoundException{
		if(tagData == null){
			tagData = new TagDataProxy();
		}
		return tagData;
	}
	
	public static void main(String args[])	throws SQLException, ClassNotFoundException{
		System.out.println(Global.iUserData().searchUser("y").getUserResult().get(0).getUsername());
	}
}