Creator: Kevin Holt
Date: 2022.12.17 (YMD)
Project: Magic: The Gathering - Deck Designer

To run the program, compile 'init.java' then run the 'init' class
	Commands (input into a command prompt terminal):
		MTG Deck Designer/ >  javac --module-path "<PATH-TO-JAVAFX-JAR>" --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web init.java
		MTG Deck Designer/ >  java --module-path "<PATH-TO-JAVAFX-JAR>" --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web init.java

Disclaimer:
	This project is currently set up for a mySQL database on 'localhost:3306'
	Database data is set up using the AllPrintings.sql file downloaded from 'htts://mtgjson.com'
	Database info can easily be adjusted at the top of the 'CardDatabase.java' file
		'final String' constants are provided at the top of the class

Other Notes:
	When adding cards to a deck, you need to enter the exact name as the database has in the 'name' column
	Leaving the Edit screen will lose all un-saved data
	Loading a deck and searching can take a few seconds. Please be patient

File Structure:
	init.java
	README.txt
	Test.deck
	Screenshots/
		Add_Card.png
		Add_Card2.png
		Change_Filter.png
		Edit_Page.png
		Home_Page.png
		Load_Deck.png
		Remove_Card.png
		Save_Deck.png
		Save_Successfull.png
		Search_Successfull.png
	src/
		gui/
			Create.java
			Edit.java
			Filter.java
			Home.java
			Search.java
		MTG/
			Card.java
			CardDatabase.java
			Deck.java
