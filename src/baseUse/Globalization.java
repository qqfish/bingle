package baseUse;

import java.sql.SQLException;

import businessServices.datamanager.diseasedata.DiseaseDataProxy;
import businessServices.datamanager.forumdata.ForumDataProxy;
import businessServices.datamanager.tagdata.TagDataProxy;
import businessServices.datamanager.userdata.UserDataProxy;
import businessServices.forumSystem.ForumProxy;

public class Globalization{
	public static IForumData forumData;
	public static IForumSystem forumSystem;
	public static IDiseaseData diseaseData;
	public static IUserData userData;
	public static ITagData tagData;
	
	public Globalization() throws SQLException{
		//forumData = new ForumDataProxy();
		forumSystem = new ForumProxy();
		diseaseData = new DiseaseDataProxy();
		userData = new UserDataProxy();
		tagData = new TagDataProxy();
	}
}