package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.QuestionDAO;
import model.Question.QuestionType;

import java.util.*;

/**
 * Servlet implementation class Question
 */
@WebServlet("/question")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String TAG_QUESTION_NO = "questionNo";
	private static final String TAG_QUESTIONS = "questions";
	
	public Question() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession userSession = request.getSession();
		
		Integer questionNo = (Integer) userSession.getAttribute(TAG_QUESTION_NO);
		
		
		int questionNumber;
		if (questionNo != null) { // kolejnie pytanie
			questionNumber = questionNo.intValue();
			questionNumber++;
			
			
		} else { // pierwsze pytanie
			questionNumber = 1;
			ArrayList<model.Question> questions = getQuestions();
			userSession.setAttribute(TAG_QUESTIONS, questions);
		}
		
		userSession.setAttribute(TAG_QUESTION_NO, questionNumber);
		request.getRequestDispatcher("WEB-INF/question.jsp").forward(request, response);
	}
	
	private ArrayList<model.Question> getQuestions() {
		QuestionDAO dao = new QuestionDAO();
		return dao.getAllQuestion(QuestionType.ALL);
	}

}
