package src.MTG;

// Program Imports

// Java Imports
import java.sql.*;

public class CardDatabase {

	//Database Info for connection
	protected final String DBUSERNAME = "readonly";
	protected final String DBPASSWORD = "readonly";
	protected final String DBNAME = "mtg-cards";
	protected final String DBADDRESS = "localhost:3306";
	protected final String DBTYPE = "mysql";

	private Connection con;
	private Statement stmt;

	/* Create connection */
	public CardDatabase() {
		try {
			Class.forName("com."+DBTYPE+".cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:"+DBTYPE+"://"+DBADDRESS+"/"+DBNAME, DBUSERNAME, DBPASSWORD);
			this.stmt = this.con.createStatement();
		}
		catch(Exception e) {System.out.println(e);}
	}




//Simplified query function for the rest of the program
	public ResultSet query(String req) {
		try{
			ResultSet res = this.stmt.executeQuery(req);
			return res;
		}
		catch(Exception e) {System.out.println(e);}
		return null;
	}

	public void close() {
		try {
			this.con.close();
		}
		catch(Exception e) {System.out.println(e);}
	}
}