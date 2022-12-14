package src.gui;

import src.gui.sceneMain;
import src.gui.sceneCreateDeck;
import src.gui.sceneEditDeck;
import src.MTG.Deck;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.*;
import java.io.File;

public class Window extends Application{

	Stage primaryStage;

	public Window(String[] args) {
		Application.launch(args);
	}
	public Window() {}




//Main Functionality
	public void start(Stage newPrimaryStage) {

		this.primaryStage = newPrimaryStage;
		
		this.primaryStage.setTitle("Magic: The Gathering - Deck Designer");
		this.openMainScene();
		this.primaryStage.show();
	}

	public void close() {
		this.primaryStage.close();
	}

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}




//Change Scenes
	public void openMainScene() {
		System.out.println(1);
		sceneMain temp = new sceneMain();
		this.primaryStage.setScene(temp.get());
	}

	public void openCreateDeckScene() {
		this.primaryStage.setScene(new sceneCreateDeck(this).get());
	}

	public void openEditDeckScene(Deck newDeck) {
		this.primaryStage.setScene(new sceneEditDeck(this,newDeck).get());
	}

	public void openSaveDeckScene(Deck newDeck) {
		//this.primaryStage.setScene(new sceneSaveDeck(this,newDeck).get());
	}

	public void openLoadDeckScene() {
		
		FileChooser fc = new FileChooser();

		fc.setTitle("Open Deck File");
		fc.getExtensionFilters().addAll(
			new ExtensionFilter("Deck Files", "*.deck"),
			new ExtensionFilter("All Files", "*.*")
		);
		File deckFile = fc.showOpenDialog(this.primaryStage);

		if(deckFile != null) {
			this.openEditDeckScene(Deck.importDeck(this, deckFile));
		}
	}
}