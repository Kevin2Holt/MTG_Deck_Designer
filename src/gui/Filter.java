package src.gui;

//Program Imports
import src.gui.Edit;
import src.MTG.Deck;
//Java Imports
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.*;
import java.io.File;
import java.util.*;

public class Filter extends Application {

	/* Variable & Object Declarations */
		// Program Variables
		Deck curDeck;
		ArrayList<String> filter;
		// JavaFX Base Objects
		Stage root;
		Scene main;
		GridPane gp;
		// JavaFX GUI/Interactive Objects
		CheckBox idCB;
		CheckBox artistCB;
		CheckBox availabilityCB;
		CheckBox boosterTypesCB;
		CheckBox borderColorCB;
		CheckBox colorIdentityCB;
		CheckBox colorsCB;
		CheckBox convertedManaCostCB;
		CheckBox finishesCB;
		CheckBox flavorTextCB;
		CheckBox frameEffectsCB;
		CheckBox frameVersionCB;
		CheckBox hasAlternativeDeckLimitCB;
		CheckBox hasContentWarningCB;
		CheckBox isOnlineOnlyCB;
		CheckBox keywordsCB;
		CheckBox languageCB;
		CheckBox layoutCB;
		CheckBox leadershipSkillsCB;
		CheckBox loyaltyCB;
		CheckBox manaCostCB;
		CheckBox mcmIdCB;
		CheckBox mtgArenaIdCB;
		CheckBox nameCB;
		CheckBox numberCB;
		CheckBox powerCB;
		CheckBox printingsCB;
		CheckBox rarityCB;
		CheckBox signatureCB;
		CheckBox subtypesCB;
		CheckBox supertypesCB;
		CheckBox textCB;
		CheckBox toughnessCB;
		CheckBox typeCB;
		CheckBox uuidCB;
		Button applyFilterBtn;
		// Constants
		private final int width = 500;
		private final int height = 350;

	/* Used for Edit */
	public Filter(Deck newDeck, ArrayList<String> newFilter) {

		// Log to Console
		System.out.println("New Stage: Filter");

		/* Initialization */
			// Info & Back-end
			this.filter = newFilter;
			this.curDeck = newDeck;
			this.gp = new GridPane();
			this.root = new Stage();
			// Labels

			// Inputs
			this.idCB = new CheckBox("id");
			this.artistCB = new CheckBox("artist");
			this.availabilityCB = new CheckBox("availability");
			this.boosterTypesCB = new CheckBox("boosterTypes");
			this.borderColorCB = new CheckBox("borderColor");
			this.colorIdentityCB = new CheckBox("colorIdentity");
			this.colorsCB = new CheckBox("colors");
			this.convertedManaCostCB = new CheckBox("convertedManaCost");
			this.finishesCB = new CheckBox("finishes");
			this.flavorTextCB = new CheckBox("flavorText");
			this.frameEffectsCB = new CheckBox("frameEffects");
			this.frameVersionCB = new CheckBox("frameVersion");
			this.hasAlternativeDeckLimitCB = new CheckBox("hasAlternativeDeckLimit");
			this.hasContentWarningCB = new CheckBox("hasContentWarning");
			this.isOnlineOnlyCB = new CheckBox("isOnlineOnly");
			this.keywordsCB = new CheckBox("keywords");
			this.languageCB = new CheckBox("language");
			this.layoutCB = new CheckBox("layout");
			this.leadershipSkillsCB = new CheckBox("leadershipSkills");
			this.loyaltyCB = new CheckBox("loyalty");
			this.manaCostCB = new CheckBox("manaCost");
			this.mcmIdCB = new CheckBox("mcmId");
			this.mtgArenaIdCB = new CheckBox("mtgArenaId");
			this.nameCB = new CheckBox("name");
			this.numberCB = new CheckBox("number");
			this.powerCB = new CheckBox("power");
			this.printingsCB = new CheckBox("printings");
			this.rarityCB = new CheckBox("rarity");
			this.signatureCB = new CheckBox("signature");
			this.subtypesCB = new CheckBox("subtypes");
			this.supertypesCB = new CheckBox("supertypes");
			this.textCB = new CheckBox("text");
			this.toughnessCB = new CheckBox("toughness");
			this.typeCB = new CheckBox("type");
			this.uuidCB = new CheckBox("uuid");
				//Set Selected Filters
				if(this.filter.contains("id")) this.idCB.setSelected(true);
				if(this.filter.contains("artist")) this.artistCB.setSelected(true);
				if(this.filter.contains("availability")) this.availabilityCB.setSelected(true);
				if(this.filter.contains("boosterTypes")) this.boosterTypesCB.setSelected(true);
				if(this.filter.contains("borderColor")) this.borderColorCB.setSelected(true);
				if(this.filter.contains("colorIdentity")) this.colorIdentityCB.setSelected(true);
				if(this.filter.contains("colors")) this.colorsCB.setSelected(true);
				if(this.filter.contains("convertedManaCost")) this.convertedManaCostCB.setSelected(true);
				if(this.filter.contains("finishes")) this.finishesCB.setSelected(true);
				if(this.filter.contains("flavorText")) this.flavorTextCB.setSelected(true);
				if(this.filter.contains("frameEffects")) this.frameEffectsCB.setSelected(true);
				if(this.filter.contains("frameVersion")) this.frameVersionCB.setSelected(true);
				if(this.filter.contains("hasAlternativeDeckLimit")) this.hasAlternativeDeckLimitCB.setSelected(true);
				if(this.filter.contains("hasContentWarning")) this.hasContentWarningCB.setSelected(true);
				if(this.filter.contains("isOnlineOnly")) this.isOnlineOnlyCB.setSelected(true);
				if(this.filter.contains("keywords")) this.keywordsCB.setSelected(true);
				if(this.filter.contains("language")) this.languageCB.setSelected(true);
				if(this.filter.contains("layout")) this.layoutCB.setSelected(true);
				if(this.filter.contains("manaCost")) this.manaCostCB.setSelected(true);
				if(this.filter.contains("mcmId")) this.mcmIdCB.setSelected(true);
				if(this.filter.contains("mtgArenaId")) this.mtgArenaIdCB.setSelected(true);
				if(this.filter.contains("name")) this.nameCB.setSelected(true);
				if(this.filter.contains("number")) this.numberCB.setSelected(true);
				if(this.filter.contains("power")) this.powerCB.setSelected(true);
				if(this.filter.contains("printings")) this.printingsCB.setSelected(true);
				if(this.filter.contains("rarity")) this.rarityCB.setSelected(true);
				if(this.filter.contains("signature")) this.signatureCB.setSelected(true);
				if(this.filter.contains("subtypes")) this.subtypesCB.setSelected(true);
				if(this.filter.contains("supertypes")) this.supertypesCB.setSelected(true);
				if(this.filter.contains("text")) this.textCB.setSelected(true);
				if(this.filter.contains("toughness")) this.toughnessCB.setSelected(true);
				if(this.filter.contains("type")) this.typeCB.setSelected(true);
				if(this.filter.contains("uuid")) this.uuidCB.setSelected(true);

			// Buttons
			this.applyFilterBtn = new Button("Apply");
			this.applyFilterBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"Apply\"");
					System.out.println("Command - Apply Filter");
					for(int i = 0; i < filter.size(); i++) {
						System.out.println("\t"+filter.get(i));
					}

					/* Actions */
					ArrayList<String> res = new ArrayList<String>();
					if(idCB.isSelected()) 						res.add("id");
					if(artistCB.isSelected()) 					res.add("artist");
					if(availabilityCB.isSelected()) 			res.add("availablity");
					if(boosterTypesCB.isSelected()) 			res.add("boosterTypes");
					if(borderColorCB.isSelected()) 				res.add("borderColor");
					if(colorIdentityCB.isSelected()) 			res.add("colorIdentity");
					if(colorsCB.isSelected()) 					res.add("colors");
					if(convertedManaCostCB.isSelected()) 		res.add("convertedManaCost");
					if(finishesCB.isSelected()) 				res.add("finishes");
					if(flavorTextCB.isSelected()) 				res.add("flavorText");
					if(frameEffectsCB.isSelected()) 			res.add("frameEffects");
					if(frameVersionCB.isSelected()) 			res.add("frameVersion");
					if(hasAlternativeDeckLimitCB.isSelected()) 	res.add("hasAlternativeDeckLimit");
					if(hasContentWarningCB.isSelected()) 		res.add("hasContentWarning");
					if(isOnlineOnlyCB.isSelected()) 			res.add("isOnlineOnly");
					if(keywordsCB.isSelected()) 				res.add("keywords");
					if(languageCB.isSelected()) 				res.add("languages");
					if(layoutCB.isSelected()) 					res.add("layout");
					if(leadershipSkillsCB.isSelected()) 		res.add("leadershipSkills");
					if(loyaltyCB.isSelected()) 					res.add("loyalty");
					if(manaCostCB.isSelected()) 				res.add("manaCost");
					if(mcmIdCB.isSelected()) 					res.add("mcmId");
					if(mtgArenaIdCB.isSelected()) 				res.add("mtgArenaId");
					if(nameCB.isSelected()) 					res.add("name");
					if(numberCB.isSelected()) 					res.add("number");
					if(powerCB.isSelected()) 					res.add("power");
					if(printingsCB.isSelected()) 				res.add("printings");
					if(rarityCB.isSelected()) 					res.add("rarity");
					if(signatureCB.isSelected()) 				res.add("signature");
					if(subtypesCB.isSelected()) 				res.add("subtypes");
					if(supertypesCB.isSelected()) 				res.add("supertypes");
					if(textCB.isSelected()) 					res.add("text");
					if(toughnessCB.isSelected()) 				res.add("toughness");
					if(typeCB.isSelected()) 					res.add("type");
					if(uuidCB.isSelected()) 					res.add("uuid");
					// res.add("");
					root.close();
					Edit editWindow = new Edit(curDeck,filter);
				}
			});

		/* Place Objects							Coords	|	Col/Row-Span */
			// Row 0 - Top Row
			this.gp.add(idCB,						0, 0,		1, 1);
			this.gp.add(artistCB,					1, 0,		1, 1);
			this.gp.add(availabilityCB,				2, 0,		1, 1);
			this.gp.add(boosterTypesCB,				3, 0,		1, 1);
			// Row 1
			this.gp.add(borderColorCB,				0, 1,		1, 1);
			this.gp.add(colorIdentityCB,			1, 1,		1, 1);
			this.gp.add(colorsCB,					2, 1,		1, 1);
			this.gp.add(convertedManaCostCB,		3, 1,		1, 1);
			// Row 2
			this.gp.add(finishesCB,					0, 2,		1, 1);
			this.gp.add(flavorTextCB,				1, 2,		1, 1);
			this.gp.add(frameEffectsCB,				2, 2,		1, 1);
			this.gp.add(frameVersionCB,				3, 2,		1, 1);
			// Row 3
			this.gp.add(hasAlternativeDeckLimitCB,	0, 3,		1, 1);
			this.gp.add(hasContentWarningCB,		1, 3,		1, 1);
			this.gp.add(isOnlineOnlyCB,				2, 3,		1, 1);
			this.gp.add(keywordsCB,					3, 3,		1, 1);
			// Row 4
			this.gp.add(languageCB,					0, 4,		1, 1);
			this.gp.add(layoutCB,					1, 4,		1, 1);
			this.gp.add(leadershipSkillsCB,			2, 4,		1, 1);
			this.gp.add(loyaltyCB,					3, 4,		1, 1);
			// Row 5
			this.gp.add(manaCostCB,					0, 5,		1, 1);
			this.gp.add(mcmIdCB,					1, 5,		1, 1);
			this.gp.add(mtgArenaIdCB,				2, 5,		1, 1);
			this.gp.add(nameCB,						3, 5,		1, 1);
			// Row 6
			this.gp.add(numberCB,					0, 6,		1, 1);
			this.gp.add(powerCB,					1, 6,		1, 1);
			this.gp.add(printingsCB,				2, 6,		1, 1);
			this.gp.add(rarityCB,					3, 6,		1, 1);
			// Row 7
			this.gp.add(signatureCB,				0, 7,		1, 1);
			this.gp.add(subtypesCB,					1, 7,		1, 1);
			this.gp.add(supertypesCB,				2, 7,		1, 1);
			this.gp.add(textCB,						3, 7,		1, 1);
			// Row 8
			this.gp.add(toughnessCB,				0, 8,		1, 1);
			this.gp.add(typeCB,						1, 8,		1, 1);
			this.gp.add(uuidCB,						2, 8,		1, 1);
			// Row 9
			this.gp.add(applyFilterBtn,				0, 9,		2, 1);

		/* Set Base JavaFX Info */
			root.setTitle("Magic: The Gathering - Deck Designer: Filter");
			main = new Scene(gp,width,height);
			root.setScene(main);
			root.show();
	}

	/* Used for Search */
	public Filter(String searchQueryText, ArrayList<String> newFilter) {

		// Log to Console
		System.out.println("New Stage: Filter");

		/* Initialization */
			// Info & Back-end
			this.filter = newFilter;
			this.gp = new GridPane();
			this.root = new Stage();
			// Labels

			// Inputs
			this.idCB = new CheckBox("id");
			this.artistCB = new CheckBox("artist");
			this.availabilityCB = new CheckBox("availability");
			this.boosterTypesCB = new CheckBox("boosterTypes");
			this.borderColorCB = new CheckBox("borderColor");
			this.colorIdentityCB = new CheckBox("colorIdentity");
			this.colorsCB = new CheckBox("colors");
			this.convertedManaCostCB = new CheckBox("convertedManaCost");
			this.finishesCB = new CheckBox("finishes");
			this.flavorTextCB = new CheckBox("flavorText");
			this.frameEffectsCB = new CheckBox("frameEffects");
			this.frameVersionCB = new CheckBox("frameVersion");
			this.hasAlternativeDeckLimitCB = new CheckBox("hasAlternativeDeckLimit");
			this.hasContentWarningCB = new CheckBox("hasContentWarning");
			this.isOnlineOnlyCB = new CheckBox("isOnlineOnly");
			this.keywordsCB = new CheckBox("keywords");
			this.languageCB = new CheckBox("language");
			this.layoutCB = new CheckBox("layout");
			this.leadershipSkillsCB = new CheckBox("leadershipSkills");
			this.loyaltyCB = new CheckBox("loyalty");
			this.manaCostCB = new CheckBox("manaCost");
			this.mcmIdCB = new CheckBox("mcmId");
			this.mtgArenaIdCB = new CheckBox("mtgArenaId");
			this.nameCB = new CheckBox("name");
			this.numberCB = new CheckBox("number");
			this.powerCB = new CheckBox("power");
			this.printingsCB = new CheckBox("printings");
			this.rarityCB = new CheckBox("rarity");
			this.signatureCB = new CheckBox("signature");
			this.subtypesCB = new CheckBox("subtypes");
			this.supertypesCB = new CheckBox("supertypes");
			this.textCB = new CheckBox("text");
			this.toughnessCB = new CheckBox("toughness");
			this.typeCB = new CheckBox("type");
			this.uuidCB = new CheckBox("uuid");
				//Set Selected Filters
				if(this.filter.contains("id")) this.idCB.setSelected(true);
				if(this.filter.contains("artist")) this.artistCB.setSelected(true);
				if(this.filter.contains("availability")) this.availabilityCB.setSelected(true);
				if(this.filter.contains("boosterTypes")) this.boosterTypesCB.setSelected(true);
				if(this.filter.contains("borderColor")) this.borderColorCB.setSelected(true);
				if(this.filter.contains("colorIdentity")) this.colorIdentityCB.setSelected(true);
				if(this.filter.contains("colors")) this.colorsCB.setSelected(true);
				if(this.filter.contains("convertedManaCost")) this.convertedManaCostCB.setSelected(true);
				if(this.filter.contains("finishes")) this.finishesCB.setSelected(true);
				if(this.filter.contains("flavorText")) this.flavorTextCB.setSelected(true);
				if(this.filter.contains("frameEffects")) this.frameEffectsCB.setSelected(true);
				if(this.filter.contains("frameVersion")) this.frameVersionCB.setSelected(true);
				if(this.filter.contains("hasAlternativeDeckLimit")) this.hasAlternativeDeckLimitCB.setSelected(true);
				if(this.filter.contains("hasContentWarning")) this.hasContentWarningCB.setSelected(true);
				if(this.filter.contains("isOnlineOnly")) this.isOnlineOnlyCB.setSelected(true);
				if(this.filter.contains("keywords")) this.keywordsCB.setSelected(true);
				if(this.filter.contains("language")) this.languageCB.setSelected(true);
				if(this.filter.contains("layout")) this.layoutCB.setSelected(true);
				if(this.filter.contains("manaCost")) this.manaCostCB.setSelected(true);
				if(this.filter.contains("mcmId")) this.mcmIdCB.setSelected(true);
				if(this.filter.contains("mtgArenaId")) this.mtgArenaIdCB.setSelected(true);
				if(this.filter.contains("name")) this.nameCB.setSelected(true);
				if(this.filter.contains("number")) this.numberCB.setSelected(true);
				if(this.filter.contains("power")) this.powerCB.setSelected(true);
				if(this.filter.contains("printings")) this.printingsCB.setSelected(true);
				if(this.filter.contains("rarity")) this.rarityCB.setSelected(true);
				if(this.filter.contains("signature")) this.signatureCB.setSelected(true);
				if(this.filter.contains("subtypes")) this.subtypesCB.setSelected(true);
				if(this.filter.contains("supertypes")) this.supertypesCB.setSelected(true);
				if(this.filter.contains("text")) this.textCB.setSelected(true);
				if(this.filter.contains("toughness")) this.toughnessCB.setSelected(true);
				if(this.filter.contains("type")) this.typeCB.setSelected(true);
				if(this.filter.contains("uuid")) this.uuidCB.setSelected(true);
			// Buttons
			this.applyFilterBtn = new Button("Apply");
			this.applyFilterBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"Apply\"");
					System.out.println("Command - Apply Filter");
					for(int i = 0; i < filter.size(); i++) {
						System.out.println("\t"+filter.get(i));
					}

					/* Actions */
					ArrayList<String> res = new ArrayList<String>();
					if(idCB.isSelected()) 						res.add("id");
					if(artistCB.isSelected()) 					res.add("artist");
					if(availabilityCB.isSelected()) 			res.add("availablity");
					if(boosterTypesCB.isSelected()) 			res.add("boosterTypes");
					if(borderColorCB.isSelected()) 				res.add("borderColor");
					if(colorIdentityCB.isSelected()) 			res.add("colorIdentity");
					if(colorsCB.isSelected()) 					res.add("colors");
					if(convertedManaCostCB.isSelected()) 		res.add("convertedManaCost");
					if(finishesCB.isSelected()) 				res.add("finishes");
					if(flavorTextCB.isSelected()) 				res.add("flavorText");
					if(frameEffectsCB.isSelected()) 			res.add("frameEffects");
					if(frameVersionCB.isSelected()) 			res.add("frameVersion");
					if(hasAlternativeDeckLimitCB.isSelected()) 	res.add("hasAlternativeDeckLimit");
					if(hasContentWarningCB.isSelected()) 		res.add("hasContentWarning");
					if(isOnlineOnlyCB.isSelected()) 			res.add("isOnlineOnly");
					if(keywordsCB.isSelected()) 				res.add("keywords");
					if(languageCB.isSelected()) 				res.add("languages");
					if(layoutCB.isSelected()) 					res.add("layout");
					if(leadershipSkillsCB.isSelected()) 		res.add("leadershipSkills");
					if(loyaltyCB.isSelected()) 					res.add("loyalty");
					if(manaCostCB.isSelected()) 				res.add("manaCost");
					if(mcmIdCB.isSelected()) 					res.add("mcmId");
					if(mtgArenaIdCB.isSelected()) 				res.add("mtgArenaId");
					if(nameCB.isSelected()) 					res.add("name");
					if(numberCB.isSelected()) 					res.add("number");
					if(powerCB.isSelected()) 					res.add("power");
					if(printingsCB.isSelected()) 				res.add("printings");
					if(rarityCB.isSelected()) 					res.add("rarity");
					if(signatureCB.isSelected()) 				res.add("signature");
					if(subtypesCB.isSelected()) 				res.add("subtypes");
					if(supertypesCB.isSelected()) 				res.add("supertypes");
					if(textCB.isSelected()) 					res.add("text");
					if(toughnessCB.isSelected()) 				res.add("toughness");
					if(typeCB.isSelected()) 					res.add("type");
					if(uuidCB.isSelected()) 					res.add("uuid");

					root.close();
					Search searchWindow = new Search(searchQueryText, res);
				}
			});

		/* Place Objects							Coords	|	Col/Row-Span */
			// Row 0 - Top Row
			this.gp.add(idCB,						0, 0,		1, 1);
			this.gp.add(artistCB,					1, 0,		1, 1);
			this.gp.add(availabilityCB,				2, 0,		1, 1);
			this.gp.add(boosterTypesCB,				3, 0,		1, 1);
			// Row 1
			this.gp.add(borderColorCB,				0, 1,		1, 1);
			this.gp.add(colorIdentityCB,			1, 1,		1, 1);
			this.gp.add(colorsCB,					2, 1,		1, 1);
			this.gp.add(convertedManaCostCB,		3, 1,		1, 1);
			// Row 2
			this.gp.add(finishesCB,					0, 2,		1, 1);
			this.gp.add(flavorTextCB,				1, 2,		1, 1);
			this.gp.add(frameEffectsCB,				2, 2,		1, 1);
			this.gp.add(frameVersionCB,				3, 2,		1, 1);
			// Row 3
			this.gp.add(hasAlternativeDeckLimitCB,	0, 3,		1, 1);
			this.gp.add(hasContentWarningCB,		1, 3,		1, 1);
			this.gp.add(isOnlineOnlyCB,				2, 3,		1, 1);
			this.gp.add(keywordsCB,					3, 3,		1, 1);
			// Row 4
			this.gp.add(languageCB,					0, 4,		1, 1);
			this.gp.add(layoutCB,					1, 4,		1, 1);
			this.gp.add(leadershipSkillsCB,			2, 4,		1, 1);
			this.gp.add(loyaltyCB,					3, 4,		1, 1);
			// Row 5
			this.gp.add(manaCostCB,					0, 5,		1, 1);
			this.gp.add(mcmIdCB,					1, 5,		1, 1);
			this.gp.add(mtgArenaIdCB,				2, 5,		1, 1);
			this.gp.add(nameCB,						3, 5,		1, 1);
			// Row 6
			this.gp.add(numberCB,					0, 6,		1, 1);
			this.gp.add(powerCB,					1, 6,		1, 1);
			this.gp.add(printingsCB,				2, 6,		1, 1);
			this.gp.add(rarityCB,					3, 6,		1, 1);
			// Row 7
			this.gp.add(signatureCB,				0, 7,		1, 1);
			this.gp.add(subtypesCB,					1, 7,		1, 1);
			this.gp.add(supertypesCB,				2, 7,		1, 1);
			this.gp.add(textCB,						3, 7,		1, 1);
			// Row 8
			this.gp.add(toughnessCB,				0, 8,		1, 1);
			this.gp.add(typeCB,						1, 8,		1, 1);
			this.gp.add(uuidCB,						2, 8,		1, 1);
			// Row 9
			this.gp.add(applyFilterBtn,				0, 9,		2, 1);

		/* Set Base JavaFX Info */
			root.setTitle("Magic: The Gathering - Deck Designer: Filter");
			main = new Scene(gp,width,height);
			root.setScene(main);
			root.show();
	}

	// This has to be here, otherwise it throws a fit
	public void start(Stage stage) {}
}