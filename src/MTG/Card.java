package src.MTG;
// Program Imports
import src.MTG.CardDatabase;
// Java Imports
import java.sql.*;

public class Card {

	private String name;
	private CardDatabase db;

	public Card(String newName, CardDatabase newDB) {
		this.name = newName;
		this.db = newDB;
	}




// Get Calculated Info
	public ResultSet getCard() {
		return db.query("SELECT * FROM cards WHERE name = "+this.name);
	}

	public ResultSet getInfo(String selectQuery) {
		return db.query("SELECT "+selectQuery+" FROM cards WHERE name = "+this.name);
	}




// Getters
	public String getName() {
		return this.name;
	}


}