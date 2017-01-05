package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import model.Question;
import model.Question.QuestionType;

public class QuestionDAO extends MainDAO {

	private static final String TABLE_NAME_IE = "ei";
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
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		sql = "SELECT IdFT, Question FROM " + TABLE_NAME_FT + ";";
		ArrayList<Question> ftQuestions = new ArrayList<>();
		
		try {
			ResultSet rs = stmt.executeQuery(sql);
			Question q; 
			while (rs.next()) {
				q = new Question();
				q.setId(rs.getInt("IdFT"));
				q.setQuestionType(QuestionType.FT);
				q.setText(rs.getString("Question"));
				ftQuestions.add(q);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		sql = "SELECT IdJP, Question FROM " + TABLE_NAME_JP + ";";
		ArrayList<Question> jpQuestions = new ArrayList<>();
		
		try {
			ResultSet rs = stmt.executeQuery(sql);
			Question q; 
			while (rs.next()) {
				q = new Question();
				q.setId(rs.getInt("IdJP"));
				q.setQuestionType(QuestionType.JP);
				q.setText(rs.getString("Question"));
				jpQuestions.add(q);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		sql = "SELECT IdNS, Question FROM " + TABLE_NAME_NS + ";";
		ArrayList<Question> nsQuestions = new ArrayList<>();
		
		try {
			ResultSet rs = stmt.executeQuery(sql);
			Question q; 
			while (rs.next()) {
				q = new Question();
				q.setId(rs.getInt("IdNS"));
				q.setQuestionType(QuestionType.NS);
				q.setText(rs.getString("Question"));
				nsQuestions.add(q);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		ArrayList<Question> allQuestions = new ArrayList<>();
		allQuestions.addAll(eiQuestions);
		allQuestions.addAll(ftQuestions);
		allQuestions.addAll(jpQuestions);
		allQuestions.addAll(nsQuestions);
		Collections.shuffle(allQuestions);
		
		return allQuestions;
	}
	
}
