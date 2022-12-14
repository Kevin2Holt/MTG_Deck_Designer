package src.MTG;

import src.MTG.Card;
import src.MTG.CardDatabase;
import src.gui.Window;

import java.sql.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
import java.io.*;

public class Deck {
	private String name;
	private ArrayList<Card> cards;
	private boolean isStandard = false;
	private boolean isCommander = false;
	final CardDatabase db = new CardDatabase();

	public Deck(String newName, String deckType) {
		this.name = newName;
		this.cards = new ArrayList<Card>();
		
		if(deckType.toUpperCase() == "STANDARD") {
			this.isStandard = true;
		}
		else if(deckType.toUpperCase() == "COMMANDER") {
			this.isCommander = true;
			this.cards.set(0, null);
		}
	}




	//Change Data
		public int addCard(String newName) {
			/*
			Return Codes:
			-4 => ERROR: Other function-specific error
			-3 => ERROR: Unable to find card in database
			-2 => ERROR: Validation Failed
			-1 => Deck is valid, but has Un- cards
			0  => Deck is valid
			1  => Not enough cards
			2  => Too many cards
			3  => Too many duplicates
			*/

			try {
				//Checks that card name exists
				ResultSet res = db.query("SELECT COUNT() FROM cards WHERE name = "+newName);//Data Validation
				if(res.getInt(1) >= 1) {
					this.cards.add(new Card(newName, db));
				}
			}
			catch(Exception e) {
				System.out.println(e);
				return -3;//ERROR: Unable to find card in database
			}
			return this.validate();
		}
		
		public int removeCard(String removeName) {
			if(this.getLastIndex(removeName) >=0) {
				this.cards.remove(this.getLastIndex(removeName));
			}
			return this.validate();
		}

		public int setCommander(String newName) {
			/*
			Return Codes:
			-4 => ERROR: Other function-specific error
			-3 => ERROR: Unable to find card in database
			-2 => ERROR: Validation Failed
			-1 => Deck is valid, but has Un- cards
			0  => Deck is valid
			1  => Not enough cards
			2  => Too many cards
			3  => Too many duplicates
			*/

			if(this.isCommander) {
				try {
					ResultSet res = db.query("SELECT COUNT() FROM cards WHERE name = "+newName);
					if(res.getInt(1) >= 1) {
						this.cards.set(0, new Card(newName, db));
					}
				}
				catch(Exception e) {
					System.out.println(e);
					return -3;//ERROR: Unable to find card in database
				}
				return this.validate();
			}
			else return -4;//ERROR: Deck does not have a Commander
		}




	//Get Info
		//Gets the last index of a card in the deck
		private int getLastIndex(String cardName) {
			for(int i = this.cards.size(); i >= 0; i--) {
				if(this.cards.get(i) != null && this.cards.get(i).getName().equals(cardName)) {
					return i;//If at least one is found, returns that index
				}
			}
			return -4;//ERROR: Unable to find card in deck
		}

		private ArrayList<String> getNamesList() {
			ArrayList<String> res = new ArrayList<String>();
			this.cards.forEach((card) -> res.add(card.getName()));
			return res;
		}

		private String toStringRes = "[";
		private void addToString(String txt) {
			toStringRes += "\'"+txt+"\', ";
		}
		@Override public String toString() {
			toStringRes = "[";
			this.cards.forEach((card) -> addToString(card.getName()));
			toStringRes = toStringRes.substring(0, toStringRes.length() - 2)+"]";
			return toStringRes;
		}

		private String getCardInfoQuery = "";
		private void addGetCardInfo(String txt) {
			getCardInfoQuery += " name = \'"+txt+"\' OR";
		}
		//Used to get all columns
		public ResultSet getCardInfo() {
			getCardInfoQuery = "SELECT * FROM cards WHERE";//Base of query
			this.cards.forEach((card) -> addGetCardInfo(card.getName()));//Add each card name to query
			getCardInfoQuery = getCardInfoQuery.substring(0, getCardInfoQuery.length() - 3)+" GROUP BY name";//Trim query & add ending statement
			return db.query(getCardInfoQuery);
		}
		//Used if you only want specific columns
		public ResultSet getCardInfoByColumn(String queryTxt) {
			getCardInfoQuery = "SELECT "+queryTxt+" FROM cards WHERE";//Base of query
			this.cards.forEach((card) -> addGetCardInfo(card.getName()));//Add each card name to query
			getCardInfoQuery = getCardInfoQuery.substring(0, getCardInfoQuery.length() - 3)+" GROUP BY name";//Trim query & add ending statemnent
			return db.query(getCardInfoQuery);
		}

		public String getDeckType() {
			if(this.isStandard) {
				return "STANDARD";
			}
			else if(this.isCommander) {
				return "COMMANDER";
			}
		}
		public String getName() {
			return this.name;
		}
		


	//Validation
		public ArrayList<String> findDuplicates() {
			ArrayList<String> res = new ArrayList<String>();
			final int allowedDuplicates;

			if(this.isStandard) {
				allowedDuplicates = 4;
			}
			else if(this.isCommander) {
				allowedDuplicates = 1;
			}
			else allowedDuplicates = 1;

			//Get frequencies of each card
			Map<String, Long> freq = this.getNamesList().stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			//Filter the cards that have a frequency greater than allowedDuplicates and add them to the result
			freq.entrySet().stream()
				.filter(entry -> entry.getValue() > allowedDuplicates)
				.forEach(entry -> res.add(entry.getKey()));
			return res;
		}

		
		public int validate() {
			/*
			Return Codes:
			-4 => ERROR: Other function-specific error
			-3 => ERROR: Unable to find card in database
			-2 => ERROR: Validation Failed
			-1 => Deck is valid, but has Un- cards
			0  => Deck is valid
			1  => Not enough cards
			2  => Too many cards
			3  => Too many duplicates
			*/

			if(this.isStandard) {
				if(this.cards.size() < 60) {
					return 1;//Not enough cards
				}
				else if(!this.findDuplicates().isEmpty()){
					return 3;//Too many duplicates
				}
				else if(false){															//Need to check for Un cards
					return -1;//Deck is valid, but has Un- cards
				}
				else return 0;
			}

			else if(this.isCommander) {
				if(this.cards.size() < 100) {
					return 1;//Not enough cards
				}
				else if(this.cards.size() > 100) {
					return 2;//Too many cards
				}
				else if(!this.findDuplicates().isEmpty()) {
					return 3;//Too many duplicates
				}
				else if(false){															//Need to check for Un cards
					return -1;//Deck is valid, but has Un- cards
				}
				else return 0;//Deck is valid
			}

			else return -2;//ERROR: Validation Failed
		}




	//Other
		public static Deck importDeck(Window window, File srcFile) {
			if(srcFile != null) {
				try {

					BufferedReader inFile = new BufferedReader(new FileReader(srcFile));
					String line = inFile.readLine();

					String tempName;
					String tempType;

					if(line != null) {
						tempName = line;
					}

					line = inFile.readLine();

					if(line != null) {
						tempType = line;
					}
					Deck res = new Deck(tempName,tempType);

					if(res.getDeckType().equals("COMMANDER")) {
						line = inFile.readLine();
						if(res.setCommander(line) <= -2) {//Checking for errors
							return null;
						}
					}

					line = inFile.readLine();

					while(line != null) {//Loop through the rest of lines
						if(line.equals("")) {}
						else if(res.addCard(line) <= -2) {//Checking for errors
							return null;
						}
						line = inFile.readLine();
					}

					return res;
					
				}
				catch(Exception e) {
					System.out.println(e);

					return null;
				}
			}
			return null;
		}
}