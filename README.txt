Creator: Kevin Holt
Date: 2022.12.03 (YMD)
Project: Magic: The Gathering Deck Designer

To run the program, compile 'Test.java' then run the 'Test' class
	Commands (input into a command prompt terminal):
		MTG Deck Designer/src >  javac Test.java
		MTG Deck Designer/src >  java Test

Disclaimer:
	This project is currently set up for a mySQL database on 'localhost:3306'
	Database data is set up using the .sql file downloaded from 'htts://mtgjson.com'
	Database info can easily be adjusted at the top of the 'CardDatabase.java' file
		'final String' constants are provided at the top of the class

File Structure:
	README.txt
	AllPrintings.sql
	src/
		Test.java
		MTG/
			Card.java
			Deck.java
			CardDatabase.java