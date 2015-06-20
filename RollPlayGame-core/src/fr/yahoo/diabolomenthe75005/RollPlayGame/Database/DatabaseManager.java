package fr.yahoo.diabolomenthe75005.RollPlayGame.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
	Connection c = null;
	public DatabaseManager()
	  {
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:RollPlayGame.db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	  }
	
	public boolean addTable(DbTable table){
		
		return true;
	}
}
