package db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SQLiteJDBC {
	
	static SQLiteJDBC sqLiteJDBC;
	
	private static Connection conn;
	
	private static final String DB_USER = "username";
	private static final String DB_PASSWORD = "password";
	private static final String DB_PATH = "path";
	
	private SQLiteJDBC() {
		
	}
	
	public static SQLiteJDBC getInstance() {
		
		if (sqLiteJDBC == null) {
			
			sqLiteJDBC = new SQLiteJDBC();
			
			conn = null;
			try {
				Class.forName("org.sqlite.JDBC");
				
				String [] dbProperties = getDbDataFromProperties();
				
				
				if (dbProperties == null) {
					throw new FileNotFoundException();
				}
				
				
				String connectionStr = "jdbc:sqlite:" + dbProperties[2];
				
				conn = DriverManager.getConnection(connectionStr);
				conn.setAutoCommit(false);
				
			} catch (Exception sql) {
				System.err.println("Problem with establising database connection:" + sql);
			}
		} 
		
		return sqLiteJDBC;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	private static String[] getDbDataFromProperties() {
		
		Properties properties = new Properties();
		InputStream inputStream = null;
		
		try {
			
			inputStream = SQLiteJDBC.class.getClassLoader().getResourceAsStream("db.properties");
			
			properties.load(inputStream);
			
			String result[] = new String[] {
					properties.getProperty(DB_USER),
					properties.getProperty(DB_PASSWORD),
					properties.getProperty(DB_PATH)
			};
			
			return result;
			
		} catch (IOException e) {
			System.out.println("Can't load db proprties file");
		}
		
		return null;
	}

}
