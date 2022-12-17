package src.gui;

import src.MTG.Deck;
import src.MTG.Card;
import src.MTG.CardDatabase;
import src.gui.Search;
import src.gui.Filter;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.control.Button.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.*;
import javafx.collections.*;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.util.*;
import java.io.File;
import java.sql.*;
import java.util.*;


public class Edit extends Application {

	/* Variable & Object Declarations */
		// Program Variables
		Deck curDeck;
		ObservableList<ObservableList> tableData;
		ArrayList<String> filter;
		// JavaFX Base Objects
		Stage root;
		Scene main;
		GridPane gp;
		// JavaFX GUI/Interactive Objects
		Label titleLabel;
		Label typeLabel;
		TextField addCardInput;
		Button addCardBtn;
		TextField removeCardInput;
		Button removeCardBtn;
		Button openSearchBtn;
		Button openFilterBtn;
		Button saveBtn;
		TableView deckTable;
		// Constants
		private final int width = 1000;
		private final int height = 500;

	/* Constructor */
	public Edit(Deck newDeck, ArrayList<String> newFilter) {

		// Log to Console
		System.out.println("New Stage: Edit");

		/* Initialization */
			// Info & Back-end
			this.curDeck = newDeck;
			this.filter = newFilter;
			this.gp = new GridPane();
			this.root = new Stage();
			// Info Objects
			this.titleLabel = new Label("Edit Deck: "+this.curDeck.getName());
			this.typeLabel = new Label("Deck Type: "+this.curDeck.getType());
			this.deckTable = new TableView();
			// Inputs
			this.addCardInput = new TextField();
				this.addCardInput.setPromptText("Card Name");
			this.removeCardInput = new TextField();
				this.removeCardInput.setPromptText("Card Name");
			// Buttons
			this.addCardBtn = new Button("Add");
			this.addCardBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"Add\"");
					System.out.println("Command - Add Card\n\tName: "+addCardInput.getText());

					/* Actions */
						curDeck.addCard(addCardInput.getText());
						root.close();
						Edit editWindow = new Edit(curDeck, filter);
				}
			});
			this.removeCardBtn = new Button("Remove");
			this.removeCardBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"Remove\"");
					System.out.println("Command - Remove Card\n\tName: "+removeCardInput.getText());

					/* Actions */
						curDeck.removeCard(removeCardInput.getText());
						root.close();
						Edit editWindow = new Edit(curDeck, filter);
				}
			});
			this.openSearchBtn = new Button("Open Search Window");
			this.openSearchBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"Open Search Window\"");
					System.out.println("Command - Open Search Window");

					/* Actions */
						Search searchWindow = new Search("",filter);
				}
			});
			this.openFilterBtn = new Button("Filter");
			this.openFilterBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"Filter\"");
					System.out.println("Command - Open Filter Window");

					/* Actions */
					root.close();
					Filter filterWindow = new Filter(curDeck,filter);
				}
			});
			this.saveBtn = new Button("Save");
			this.saveBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"Save\"");
					
					/* Actions */
						FileChooser fc = new FileChooser();
						fc.setTitle("Save Deck File");
						fc.getExtensionFilters().addAll(
							new ExtensionFilter("Deck Files", "*.deck"),
							new ExtensionFilter("All Files", "*.*")
						);

						//Log to Console
						System.out.println("Open FileChooser - Save");
						File deckFile = fc.showSaveDialog(root);

						System.out.println("Command - Save");
						curDeck.save(deckFile);
				}
			});
		
		/* Customization & Options */
			// Deck Table
				deckTable.setEditable(false);
				ResultSet rs = this.curDeck.getCardInfoByColumn(this.filter);
				try {
					System.out.println(this.curDeck);
				}
				catch(Exception e) {System.out.println(e);}
				this.tableData = FXCollections.observableArrayList();

				// Create table columns
				try {
					for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        final int j = i;
                        TableColumn tableColumn = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                        tableColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param ->
                                new SimpleStringProperty(param.getValue().get(j).toString()));
                        deckTable.getColumns().addAll(tableColumn);
                        // System.out.println("Column [" + i + "] ");
                    }
                }
                catch(Exception e) {System.out.println(e);}

                // Fill table by row
				try {
					while(rs.next()) {
						// System.out.println(rs.getString("name")+"  |  "+
						// 	rs.getString("colorIdentity")+"  |  "+
						// 	rs.getString("manaCost")+"  |  "+
						// 	rs.getString("rarity")+"  |  "+
						// 	rs.getString("type")+"  |  "+
						// 	rs.getString("subtypes")+"  |  "+
						// 	rs.getString("keywords")+"  |  "+
						// 	rs.getString("power")+"  |  "+
						// 	rs.getString("toughness")+"  |  "+
						// 	rs.getString("text"));
						ObservableList<String> row = FXCollections.observableArrayList();
						for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
							if(rs.getString(i) != null) {
								row.add(rs.getString(i));
							}
							else {
								row.add("");
							}
						}
						// System.out.println("Row: " + row);
						this.tableData.add(row);
					}
					this.deckTable.getItems().addAll(tableData);
				}
				catch(Exception e) {System.out.println(e);}


		/* Place Objects				Coords	|	Col/Row-Span */
			// Row 0 - Top Row
			this.gp.add(titleLabel,		0, 0,		1, 1);
			this.gp.add(typeLabel,		1, 0,		1, 1);
			// Row 1
			this.gp.add(addCardInput,	0, 1,		1, 1);
			this.gp.add(addCardBtn,		1, 1,		1, 1);
			this.gp.add(removeCardInput,2, 1,		1, 1);
			this.gp.add(removeCardBtn,	3, 1,		1, 1);
			this.gp.add(openSearchBtn,	4, 1,		1, 1);
			this.gp.add(openFilterBtn,	5, 1,		1, 1);
			this.gp.add(saveBtn,		6, 1,		1, 1);
			// Row 2
			this.gp.add(deckTable,		0, 2,		9, 9);

		/* Set Base JavaFX Info */
			root.setTitle("Magic: The Gathering - Deck Designer: Edit");
			main = new Scene(gp,width,height);
			root.setScene(main);
			root.show();
	}

	// This has to be here, otherwise it throws a fit
	public void start(Stage stage) {}
}