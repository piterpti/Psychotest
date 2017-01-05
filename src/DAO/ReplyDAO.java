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

}
