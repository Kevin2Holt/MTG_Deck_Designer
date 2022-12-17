package src.gui;

// Program Imports
import src.MTG.Deck;
import src.MTG.Card;
import src.MTG.CardDatabase;
import src.gui.Filter;
// Java Imports
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


public class Search extends Application{

	/* Variable & Object Declarations */
		// Program Variables
		CardDatabase db = new CardDatabase();
		ObservableList<ObservableList> tableData;
		ArrayList<String> filter;
		// JavaFX Base Objects
		Stage root;
		Scene main;
		GridPane gp;
		// JavaFX GUI/Interactive Objects
		TextField searchInput;
		Button searchBtn;
		Button openFilterBtn;
		TableView cardTable;
		// Constants
		private final int width = 1000;
		private final int height = 500;

	/* Constructor */
	public Search(String searchQueryText, ArrayList<String> newFilter) {

		// Log to Console
		System.out.println("New Stage: Search");

		/* Initialization */
			// Info & Back-end
			this.filter = newFilter;
			this.gp = new GridPane();
			this.root = new Stage();
			// Info Objects
			this.cardTable = new TableView();
			// Inputs
			this.searchInput = new TextField();
				this.searchInput.setPromptText("Query Text");
			// Buttons
			this.searchBtn = new Button("Search");
			this.searchBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					//Log to Console
					System.out.println("Button Pressed: \"Search\"");
					System.out.println("Command - Search\n\tQuery: \""+searchInput.getText()+"\"");

					/* Actions */
					root.close();
					Search searchWindow = new Search(searchInput.getText(),filter);
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
					Filter filterWindow = new Filter(searchQueryText, filter);
				}
			});
		
		/* Customization & Options */
			// Deck Table
				cardTable.setEditable(false);
				ResultSet rs = search(searchQueryText,this.filter);
				this.tableData = FXCollections.observableArrayList();

				try {
					for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        final int j = i;
                        TableColumn tableColumn = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                        tableColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param ->
                                new SimpleStringProperty(param.getValue().get(j).toString()));
                        cardTable.getColumns().addAll(tableColumn);
                        // System.out.println("Column [" + i + "] ");
                    }
                }
                catch(Exception e) {System.out.println(e);}


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
					this.cardTable.getItems().addAll(tableData);
				}
				catch(Exception e) {System.out.println(e);}


		/* Place Objects				Coords	|	Col/Row-Span */
			// Row 0 - Top Row
			this.gp.add(searchInput,	0, 0,		1, 1);
			this.gp.add(searchBtn,		1, 0,		1, 1);
			this.gp.add(openFilterBtn,	2, 0,		1, 1);
			// Row 1
			this.gp.add(cardTable,		0, 1,		9, 9);

		/* Set Base JavaFX Info */
			root.setTitle("Magic: The Gathering - Search: "+searchQueryText);
			main = new Scene(gp,width,height);
			root.setScene(main);
			root.show();
	}

	// This has to be here, otherwise it throws a fit
	public void start(Stage stage) {}

	//Used to get all columns
	public ResultSet search(String searchText,ArrayList<String> filter) {
		String searchQuery = "SELECT ";
		if(filter.size() > 0) {
			for(int i=0; i<filter.size(); i++) {
				searchQuery += filter.get(i) +", ";
			}
			searchQuery = searchQuery.substring(0, searchQuery.length() - 2) +" FROM cards";
		}
		else {searchQuery += "* FROM cards";}

		if(searchText.length() > 0) {
			searchQuery += " WHERE";
			for(int i=0; i<filter.size(); i++) {
				searchQuery += " "+filter.get(i) + " LIKE \'"+searchText+"\' OR";
			}
			searchQuery = searchQuery.substring(0, searchQuery.length() - 3)+" GROUP BY name";
		}
		else {searchQuery += " GROUP BY name";}
		return db.query(searchQuery);
	}
}