package src.gui;

import src.gui.Window;

import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class sceneCreateDeck {

	GridPane gp;
	Scene cn;
	Window window;

	final int width = 500;
	final int height = 350;

	Label titleLabel;
	Label nameLabel;
	Label typeLabel;
	TextField nameInput;
	ComboBox typeInput;
	Button createDeckBtn;

	public sceneCreateDeck(Window newWindow) {
		this.gp = new GridPane();
		this.cn = new Scene(this.gp,width,height);
		this.window = newWindow;

		this.titleLabel = new Label("New Deck");
		this.nameLabel = new Label("Name:");
		this.typeLabel = new Label("Type:");

		this.nameInput= new TextField();
		
		this.typeInput = new ComboBox();
		this.typeInput.getItems().addAll(
			"Standard",
			"Commander"
		);

		this.createDeckBtn = new Button("Create");
		this.createDeckBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				this.window.close();
				new Window().openEditDeckScene(new Deck(nameInput.getText(),typeInput.getValue()));
			}
		});

		this.gp.add(titleLabel,		0,0,	2,1);

		this.gp.add(nameLabel,		0,1);
		this.gp.add(nameInput,		1,1);

		this.gp.add(typeLabel,		0,2);
		this.gp.add(typeInput,		1,2);

		this.gp.add(createDeckBtn,	1,3);
	}

	public Scene get() {
		return this.cn;
	}
}