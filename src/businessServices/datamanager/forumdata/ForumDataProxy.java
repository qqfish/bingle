package businessServices.datamanager.forumdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Statement;

import baseUse.ForumList;
import baseUse.IForumData;
import baseUse.TopicDetail;
import baseUse.TopicListDetail;

public class ForumDataProxy implements IForumData{
	private String sql;
	private Connection con;
	public ForumDataProxy() throws SQLException, ClassNotFoundException{
		Class.forName("org.git.mm.mysql.Driver");
		con = DriverManager
				.getConnection("jdbc:mysql://localhost/bingle?user=root&password=zy102428");
	}
	
	public void deleteReply(int[] replyId) throws SQLException{
		sql = "delete from reply where replyId=?";
		for(int i =0;i < replyId.length;i++){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, replyId[i]);
			ps.executeUpdate();
			ps.close();
		}
	}
	public void deleteTopic(int[] topicId) throws SQLException{
		sql = "delete from topic where topicId=?";
		String sql2 = "delete from reply where topicId=?";
		for(int i =0;i < topicId.length;i++){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, topicId[i]);
			ps.executeUpdate();
			ps.close();
			
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, topicId[i]);
			ps2.executeUpdate();
			ps2.close();
		}
	}
	public TopicDetail getTopic(int topicId) throws SQLException{
		TopicDetail td = new TopicDetail();
		sql = "select * from topic where topicId=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, topicId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			td.setAuthor(rs.getString("userName"));
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
				td.setReplyNum(rs.getRow());
			}
			td.setReply(rs.getString("replyContent"), rs.getInt("replyId"),rs.getString("replyAuthor"), rs.getString("replyTime"));
		}
		rs.close();
		ps.close();
		
		return td;
	}
	public TopicListDetail getTopicList(String topicListName) throws SQLException{
		TopicListDetail tld = new TopicListDetail();
		tld.setTopicListName(topicListName);
		
		sql = "select * from topic where ListName=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, topicListName);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			String tn = rs.getString("topicSubject");
			int ti = rs.getInt("topicId");
			String a = rs.getString("userName");
			int vn = rs.getInt("numView");
			
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
			if(rs.isLast())
				tld.setTopicNum(rs.getRow());
		}
		rs.close();
		ps.close();
		
		return tld;
		
	}
	public ForumList getForumList() throws SQLException{
		ForumList fl = new ForumList();
		List<String> tagName = new ArrayList<String>();
		
		sql = "select listName from topicList";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			String ln = rs.getString("listName");
			
			String sql2 = "select tagName from forumTag where listName=?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setString(1, ln);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()){
				tagName.add(rs2.getString("tagName"));
			}
			fl.setForumList(ln,tagName);
			
			rs2.close();
			ps2.close();
		}
		rs.close();
		ps.close();
		return fl;
	}
	public void newTopic(String topicName,String userName,String content,String topicListName) throws SQLException{
		sql = "insert into topic(userName,listName,topicSubject) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, userName);
		ps.setString(2, topicListName);
		ps.setString(3, topicName);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		rs.close();
		ps.close();
		
		newReply(content,id,userName);
	}
	public void newReply(String content,int topicId,String userName) throws SQLException{
		sql = "insert into reply(topicId,replyAuthor,replyContent,replyTime) values(?,?,?,?)";
		Date date = new Date();
		Timestamp st=new Timestamp(date.getTime());
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,topicId);
		ps.setString(2, userName);
		ps.setString(3, content);
		ps.setTimestamp(4,st);
		ps.execute();
		ps.close();
	}
	public void editReply(int replyId,String content) throws SQLException{
		sql = "update reply set replyContent=? where replyId=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, content);
		ps.setInt(2, replyId);
		ps.executeUpdate();
		ps.close();
	}	

}
