import MTG.CardDatabase;
import MTG.Card;
import MTG.Deck;
import java.sql.*;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		System.out.println("Program Start");
		CardDatabase db = new CardDatabase();

		Deck deck1 = new Deck("Deck1", "Standard", db);
		deck1.addCard("Angelic Blessing");
		deck1.addCard("Holy Day");
		deck1.addCard("Ballista Squad");
		deck1.addCard("Bandage");
		deck1.addCard("Holy Strength");
		deck1.addCard("Holy Day");
		deck1.addCard("Field Marshal");
		deck1.addCard("Rule of Law");
		deck1.addCard("Serra Angel");
		System.out.println(deck1);

		try {
			ResultSet res = deck1.getCardInfo();
			// System.out.println(String.format("%-36s | %-50s | %-45s | %-30s | %-15s | %-25s",
			// 					"UUID", "Name", "Type", "Subtypes", "Rarity", "Keywords", "Text"));
			// System.out.println("-------------------------------------|----------------------------------------------------|-----------------------------------------------|--------------------------------|-----------------|--------------------------");
			while(res.next()) {
				System.out.println(	res.getString(1)+" | "+
									res.getString(61)+" | "+
									// res.getString(3)+" | "+
									// res.getString(4)+" | "+
									// res.getString(5)+" | "+
									// res.getString(6)+" | "+
									// res.getString(7)+" | "+
									// res.getString(8)+" | "+
									// res.getString(9)+" | "+
									// res.getString(10)+" | "+
									// res.getString(11)+" | "+
									// res.getString(12)+" | "+
									// res.getString(13)+" | "+
									// res.getString(14)+" | "+
									// res.getString(15)+" | "+
									// res.getString(16)+" | "+
									// res.getString(17)+" | "+
									// res.getString(18)+" | "+
									res.getString(19));
			}
		}
		catch(Exception e) {System.out.println(e);}
		System.out.println("Program End");
		db.close();
	}
}

