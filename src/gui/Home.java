package src.gui;

// Program Imports
import src.gui.Create;
import src.gui.Edit;
import src.gui.Search;
import src.MTG.Deck;
// Java imports
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

public class Home extends Application {
	/* Variable & Object Declarations */
		// Program Variables

		// JavaFX Base Objects
		Stage root;
		Scene main;
		GridPane gp;
		// JavaFX GUI/Interactive Objects
		Label titleLabel;
		Button createDeckBtn;
		Button loadDeckBtn;
		Button openSearchBtn;
		// Constants
		private final int width = 500;
		private final int height = 350;
		private ArrayList<String> defaultFilter;
			

	public Home() {

		// Log to Console
		System.out.println("New Stage: Create");

		/* Initialization */
			// Info & Back-end
			this.defaultFilter = new ArrayList<String>();
			this.defaultFilter.add("name");
			this.defaultFilter.add("colorIdentity");
			this.defaultFilter.add("manaCost");
			this.defaultFilter.add("rarity");
			this.defaultFilter.add("type");
			this.defaultFilter.add("subtypes");
			this.defaultFilter.add("keywords");
			this.defaultFilter.add("power");
			this.defaultFilter.add("toughness");
			this.defaultFilter.add("text");
			this.gp = new GridPane();
			this.root = new Stage();
			// Labels
			this.titleLabel = new Label("Magic: The Gathering\nDeck Designer");
			// Inputs

			// Buttons
			this.createDeckBtn = new Button("New");
			this.createDeckBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"New\"");

					/* Actions */
						root.close();
						Create createWindow = new Create();
				}
			});
			this.loadDeckBtn = new Button("Load");
			this.loadDeckBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"Load\"");

					/* Actions */
						FileChooser fc = new FileChooser();
						fc.setTitle("Open Deck File");
						fc.getExtensionFilters().addAll(
							new ExtensionFilter("Deck Files", "*.deck"),
							new ExtensionFilter("All Files", "*.*")
						);

						//Log to Console
						System.out.println("Open FileChooser - Load");
						File deckFile = fc.showOpenDialog(root);

						if(deckFile != null) {
							root.close();
							Edit editWindow = new Edit(Deck.importDeck(deckFile),defaultFilter);
						}
				}
			});
			this.openSearchBtn = new Button("Open Search Window");
			this.openSearchBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"Open Search Window\"");
					System.out.println("Command - Open Search Window");

					/* Actions */
						Search searchWindow = new Search("",defaultFilter);
				}
			});

		/* Place Objects			Coords	|	Col/Row-Span */
			// Row 0 - Top Row
			this.gp.add(titleLabel,		0, 0,		2, 1);
			// Row 1
			this.gp.add(createDeckBtn,	0, 1,		1, 1);
			this.gp.add(loadDeckBtn,	1, 1,		1, 1);
			// Row 2
			this.gp.add(openSearchBtn,	0, 2,		2, 1);

		/* Set Base JavaFX Info */
			root.setTitle("Magic: The Gathering - Deck Designer");
			main = new Scene(gp,width,height);
			root.setScene(main);
			root.show();
	}

	// This has to be here, otherwise it throws a fit
	public void start(Stage stage) {}

}