package businessServices.datamanager.forumdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;

import baseUse.ForumList;
import baseUse.TopicDetail;
import baseUse.TopicListDetail;

public class ForumDataProxy {
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/public";
	private String uid = "root";
	private String pwd = "zy102428";
	public String sql;
	public Connection con;
	ForumDataProxy() throws SQLException{
		try{
			Class.forName(dbDriver);
			con = DriverManager.getConnection(url,uid,pwd);
		}
		catch(SQLException e){
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteReply(int[] replyId) throws SQLException{
		TopicDetail td = new TopicDetail();
		sql = "delete from reply where replyId=?";
		for(int i =0;i < replyId.length;i++){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, replyId[i]);
			ps.executeUpdate();
			ps.close();
			
			td.deleteReply(replyId[i]);
		}
	}
	public void deleteTopic(int[] topicId) throws SQLException{
		TopicListDetail tld = new TopicListDetail();
		sql = "delete from reply where replyId=?";
		for(int i =0;i < topicId.length;i++){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, topicId[i]);
			ps.executeUpdate();
			ps.close();
			
			tld.deleteTopic(topicId[i]);
		}
	}
	public TopicDetail getTopic(int topicId) throws SQLException{
		TopicDetail td = new TopicDetail();
		sql = "select * from topic where topicId=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, topicId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			td.setAuthor(rs.getString("topicAuthor"));
			td.setTopicId(topicId);
			td.setTopicName(rs.getString("topicSubject"));
			td.setViewNum(rs.getInt("numView"));
		}
		rs.close();
		ps.close();
		
		sql = "select * from reply where topicId=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, topicId);
		rs = ps.executeQuery();
		while(rs.next()){
			if(rs.isFirst()){
				td.setFirstEditTime(rs.getString("replyTime"));
			}
			if(rs.isLast()){
				td.setLastEditTime(rs.getString("replyTime"));
			}
			td.setReply(rs.getString("content"), rs.getInt("topicId"),rs.getString("author"), rs.getString("editTime"));
		}
		rs.close();
		ps.close();
		
		return td;
	}
	public TopicListDetail getTopicList(String topicListName) throws SQLException{
		TopicListDetail tld = new TopicListDetail();
		sql = "select * from topicList where topicListName=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, topicListName);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			tld.setTopicListName(topicListName);
			tld.setTopicNum(rs.getInt("topicNum"));
		}
		rs.close();
		ps.close();
		
		sql = "select * from topic where ListName=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, topicListName);
		rs = ps.executeQuery();
		while(rs.next()){
			String tn = rs.getString("topicName");
			int ti = rs.getInt("topicId");
			String a = rs.getString("topicAuthor");
			int vn = rs.getInt("numberView");
			
			String sql2 = "select * from reply where topicId=?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, ti);
			ResultSet rs2 = ps2.executeQuery();
			
			rs2.first();
			String fet = rs2.getString("replyTime");
			rs2.last();
			String let = rs2.getString("replyTime");
			int rn = rs2.getRow();
			
			rs2.close();
			ps2.close();
			
			tld.setTopic(tn, ti, a, vn, rn, fet, let);
		}
		rs.close();
		ps.close();
		
		return tld;
		
	}
	public ForumList getForumList() throws SQLException{
		ForumList fl = new ForumList();
		List<String> tagName = null;
		
		sql = "select listName from topicList";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			String ln = rs.getString("listName");
			
			String sql2 = "select * from forum	where listName=?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setString(1, ln);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()){
				tagName.add(rs.getString("tagName"));
			}
			fl.setForumList(ln,(String[]) tagName.toArray());
			
			tagName.clear();
			rs2.close();
			ps2.close();
		}
		rs.close();
		ps.close();
		return null;
	}
	public void update(TopicListDetail topicList,TopicDetail topic){
		
	}
	public void newTopic(String topicName,String userName,String content,String topicListName){
		
	}
}
