package modeltest;

import java.util.ArrayList;
import java.util.Random;

import DAO.QuestionDAO;
import DAO.ReplyDAO;
import junit.framework.TestCase;
import model.Question;
import model.Reply;
import model.Question.QuestionType;

public class PsychotestJunitTest extends TestCase {

	private int testsNumber = 1000000;
	
	private static final int MODELS_NUMBER = 16;
	
	public void testModelTest() {
		System.out.println("Test started");
		
		ReplyDAO replyDAO = new ReplyDAO();
		ArrayList<Reply> replies = replyDAO.getReplies();
		assertEquals(MODELS_NUMBER, replies.size());
		
		int onePercent = (int) Math.round(testsNumber * 0.01);
		int progress = 0;
		int prevoius = -1;
		
		QuestionDAO questionDAO = new QuestionDAO();
		Random generator = new Random();
		for (int i = 0; i < testsNumber; i++) {
			
			ArrayList<Question> questions = questionDAO.getAllQuestion(QuestionType.ALL);
			
			// random answers
			for (Question q : questions) {
				int answer = generator.nextInt(11);
				q.setUserRate(answer);
			}
			
			Reply model = calculatePersonalityProfile(questions);
			
			assertNotNull(model);
			
			boolean ok = false;
			for (Reply reply : replies) {
				if (reply.equals(model)) {
					reply.incCounter();
					ok = true;
					break;
				}
			}
			
			assertEquals(true, ok);
			
			
			progress = i / onePercent;
			if (progress > 0 && progress != prevoius) {
				System.out.println(progress + " %");
				prevoius = progress;
			}
		}
		
		int allAnswers = 0;
		
		for (Reply reply : replies) {
			System.out.println(reply);
			allAnswers += reply.getCounter();
		}
		
		assertEquals(testsNumber, allAnswers);
		System.out.println("All answers: " + allAnswers);
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
	
}
