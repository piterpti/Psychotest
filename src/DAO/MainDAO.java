package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.SQLiteJDBC;

public class MainDAO {

	private Connection conn;
	
	public MainDAO() {
		conn = SQLiteJDBC.getInstance().getConnection();
	}
	
	protected Statement createStatement() {
		try {
			
		return conn.createStatement();
		
		} catch (SQLException e) {
			print("Problem with creating statement:" + e.getMessage());
			return null;
		}
	}
	
	public void print(String toPrint) {
		System.out.println(toPrint);
	}
	
}
