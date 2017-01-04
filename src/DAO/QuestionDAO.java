package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import model.Question;
import model.Question.QuestionType;

public class QuestionDAO extends MainDAO {

	private static final String TABLE_NAME_IE = "ie";
	private static final String TABLE_NAME_FT = "ft";
	private static final String TABLE_NAME_JP = "jp";
	private static final String TABLE_NAME_NS = "ns";
	
	public QuestionDAO() {
		super();
	}
	
	public ArrayList<Question> getAllQuestion(QuestionType type) {
		
		Statement stmt = createStatement();
		String sql = "SELECT IdEI, Question FROM " + TABLE_NAME_IE + ";";
		
		ArrayList<Question> eiQuestions = new ArrayList<>();
		
		try {
			ResultSet rs = stmt.executeQuery(sql);
			Question q; 
			while (rs.next()) {
				q = new Question();
				q.setId(rs.getInt("IdEI"));
				q.setQuestionType(QuestionType.EI);
				q.setText(rs.getString("Question"));
				eiQuestions.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return eiQuestions;
	}
	
}
