package src.gui;

// Program Imports
import src.gui.Edit;
import src.MTG.Deck;
import src.gui.Home;
// Java Imports
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

public class Create extends Application {

	/* Variable & Object Declarations */
		// Program Variables

		// JavaFX Base Objects
		Stage root;
		Scene main;
		GridPane gp;
		// JavaFX GUI/Interactive Objects
		Label titleLabel;
		Label nameLabel;
		Label typeLabel;
		TextField nameInput;
		ComboBox<String> typeInput;
		Button createDeckBtn;
		Button homeBtn;
		// Constants
		private final int width = 500;
		private final int height = 350;
		private ArrayList<String> defaultFilter;

	/* Constructor */
	public Create() {

		// Log to Console
		System.out.println("New Stage: Create");

		/* Initialization */
			// Info & Back-end
			defaultFilter = new ArrayList<String>();
			defaultFilter.add("name");
			defaultFilter.add("colorIdentity");
			defaultFilter.add("manaCost");
			defaultFilter.add("rarity");
			defaultFilter.add("type");
			defaultFilter.add("subtypes");
			defaultFilter.add("keywords");
			defaultFilter.add("power");
			defaultFilter.add("toughness");
			defaultFilter.add("text");
			this.gp = new GridPane();
			this.root = new Stage();
			// Labels
			this.titleLabel = new Label("New Deck");
			this.nameLabel = new Label("Name:");
			this.typeLabel = new Label("Type:");
			// Inputs
			this.nameInput= new TextField();
			this.typeInput = new ComboBox<String>();
			this.typeInput.getItems().addAll("Standard", "Commander");
			this.typeInput.setValue("Standard");
			// Buttons
			this.createDeckBtn = new Button("Create");
			this.createDeckBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"Create\"");
					System.out.println("Command - Create New Deck\n\tName: \""+nameInput.getText()+"\"\n\tType: \""+typeInput.getValue().toUpperCase()+"\"");

					/* Actions */
						root.close();
						Edit editWindow = new Edit(new Deck(nameInput.getText(),typeInput.getValue()),defaultFilter);
				}
			});
			this.homeBtn = new Button("Home");
			this.homeBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"Home\"");

					/* Actions */
						root.close();
						Home homeWindow = new Home();
				}
			});

		/* Place Objects				Coords	|	Col/Row-Span */
			// Row 0 - Top Row
			this.gp.add(titleLabel,		0, 0,		2, 1);
			// Row 1
			this.gp.add(nameLabel,		0, 1,		1, 1);
			this.gp.add(nameInput,		1, 1,		1, 1);
			// Row 2
			this.gp.add(typeLabel,		0, 2,		1, 1);
			this.gp.add(typeInput,		1, 2,		1, 1);
			// Row 3
			this.gp.add(createDeckBtn,	0, 3,		1, 1);
			this.gp.add(homeBtn,		1, 3,		1, 1);

		/* Set Base JavaFX Info */
			root.setTitle("Magic: The Gathering - Deck Designer: Create New Deck");
			main = new Scene(gp,width,height);
			root.setScene(main);
			root.show();
	}

	// This has to be here, otherwise it throws a fit
	public void start(Stage stage) {}
}