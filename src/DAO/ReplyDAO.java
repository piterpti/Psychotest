package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import model.Reply;

public class ReplyDAO extends MainDAO{
	
	private static final String TABLE_REPLY = "reply";
	
	public ReplyDAO() {
		super();
	}
	
	public Reply getReply(String model) {
		
		Statement stmt = createStatement();
		String sql = "SELECT * FROM " + TABLE_REPLY + " WHERE IdReply=\'" + model + "\';";
		
		try {
			ResultSet rs = stmt.executeQuery(sql);
			Reply result = null;
			while (rs.next()) {
				result = new Reply();
				result.setReplyId(rs.getString("IdReply").toUpperCase());
				result.setName(rs.getString("Name"));
				result.setDescription(rs.getString("Description"));
				result.setProffesions(rs.getString("Professions"));
			}
			rs.close();
			stmt.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Reply> getReplies() {
		ArrayList<Reply> replies = new ArrayList<>();
		
		Statement stmt = createStatement();
		String sql = "SELECT * FROM " + TABLE_REPLY + ";";
		
		try {
			ResultSet rs = stmt.executeQuery(sql);
			Reply reply = null;
			while (rs.next()) {
				reply = new Reply();
				reply.setReplyId(rs.getString("IdReply").toUpperCase());
				reply.setName(rs.getString("Name"));
				reply.setDescription(rs.getString("Description"));
				reply.setProffesions(rs.getString("Professions"));
				replies.add(reply);
			}
			
			rs.close();
			stmt.close();
			
			return replies;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
