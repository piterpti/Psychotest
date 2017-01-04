package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import db.SQLiteJDBC;

/**
 * Servlet implementation class InitialServlet
 */
@WebServlet("/InitialServlet")
public class InitialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitialServlet() {
        super();
        SQLiteJDBC.getInstance();
    }
}
