package baseUse;

import java.sql.SQLException;

import businessServices.datamanager.forumdata.ForumDataProxy;
import businessServices.forumSystem.ForumProxy;

public class Globalization{
	public static IForumData forumData;
	public static IForumSystem forumSystem;
	
	public Globalization() throws ClassNotFoundException, SQLException{
			forumData = new ForumDataProxy();
			forumSystem = new ForumProxy();
	}
}
