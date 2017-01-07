package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.QuestionDAO;
import DAO.ReplyDAO;
import model.Question.QuestionType;
import model.Reply;

import java.util.*;

/**
 * Servlet implementation class Question
 */
@WebServlet("/question")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String TAG_QUESTION_NO = "questionNo";
	private static final String TAG_QUESTIONS = "questions";
	private static final String TAG_MODEL = "model";
	
	public Question() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession userSession = request.getSession();
		userSession.removeAttribute(TAG_QUESTION_NO);
		userSession.removeAttribute(TAG_QUESTIONS);
		userSession.setAttribute("end", false);
		
		ArrayList<model.Question> allQuestions = null;
		int questionNumber = 1;
		allQuestions = getQuestions();
		userSession.setAttribute(TAG_QUESTIONS, allQuestions);
		userSession.setAttribute(TAG_QUESTION_NO, questionNumber);
		request.getRequestDispatcher("WEB-INF/question.jsp").forward(request, response);
	}
	
	private ArrayList<model.Question> getQuestions() {
		QuestionDAO dao = new QuestionDAO();
		return dao.getAllQuestion(QuestionType.ALL);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String questionRate = req.getParameter("rate");
		int userRate = Integer.valueOf(questionRate);
		
		HttpSession session = req.getSession();
		if (isEnd(session)) {
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
		} else {
			boolean end = false;
			ArrayList<model.Question> allQuestions = (ArrayList<model.Question>) session.getAttribute(TAG_QUESTIONS);
			Integer currentQuestion = (Integer) session.getAttribute(TAG_QUESTION_NO);
			if (allQuestions != null && currentQuestion != null) {
				allQuestions.get(currentQuestion.intValue()-1).setUserRate(userRate);
				
				if (currentQuestion.intValue() >= allQuestions.size()) {
					end = true;
				} else {
					int counter = 1;
					for (model.Question question : allQuestions) {
						if (question.getUserRate() > 0) {
							counter++;
							continue;
						}
						session.setAttribute(TAG_QUESTION_NO, counter);
					}
				}
				session.setAttribute(TAG_QUESTIONS, allQuestions);
			} else {
				req.getRequestDispatcher("WEB-INF/test.jsp").forward(req, resp);
			}
			
			if (end) {
				Reply model = calculatePersonalityProfile(allQuestions);
				if (model == null) {
					// error
					req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
				}
				req.setAttribute(TAG_MODEL, model);
				session.setAttribute("end", true);
				req.getRequestDispatcher("WEB-INF/summary.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("WEB-INF/question.jsp").forward(req, resp);
			}
		}
	}
	
	private Reply calculatePersonalityProfile(ArrayList<model.Question> questions) {
		int ei = 0;;
		int eiQuestionsCount = 0;
		
		int ft = 0;
		int ftQuestionsCount = 0;
		
		int jp =0;
		int jpQuestionCount = 0;
		
		int ns = 0;
		int nsQuestionCount = 0;
		
		for (model.Question question : questions) {
			
			switch (question.getQuestionType()) {
				case EI:
					ei += question.getUserRate();
					eiQuestionsCount++;
					break;
				
				case FT:
					ftQuestionsCount++;
					ft += question.getUserRate();
					break;
					
				case JP:
					jpQuestionCount++;
					jp += question.getUserRate();
					break;
					
				case NS:
					nsQuestionCount++;
					ns += question.getUserRate();
					break;
					
				default:
					break;
			}
		}
		
		String personalityModel = "";
		if (10 * eiQuestionsCount / 2 > ei) {
			personalityModel += "E";
		} else {
			personalityModel += "I";
		}
		
		if (10 * nsQuestionCount / 2 > ns) {
			personalityModel += "N";
		} else {
			personalityModel += "S";
		}
		
		if (10 * ftQuestionsCount / 2 > ft) {
			personalityModel += "F";
		} else {
			personalityModel += "T";
		}
		
		if (10 * jpQuestionCount / 2 > jp) {
			personalityModel += "J";
		} else {
			personalityModel += "P";
		}
		
		personalityModel = personalityModel.toLowerCase();
		
		ReplyDAO dao = new ReplyDAO();
		
		return dao.getReply(personalityModel);
	}
	
	private boolean isEnd(HttpSession sess) {
		Boolean isSessionEnd = (Boolean) sess.getAttribute("end");
		if (isSessionEnd != null) {
			return isSessionEnd.booleanValue();
		}
		return false;
	}

}
