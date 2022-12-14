package src.gui;

import src.gui.Window;
import src.MTG.Deck;

import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class sceneEditDeck {

	GridPane gp;
	Scene cn;
	Window window;

	Deck curDeck;

	final int width = 500;
	final int height = 350;

	Label titleLabel;
	Label nameLabel;
	Label typeLabel;
	TextField nameInput;
	ComboBox typeInput;
	Button createDeckBtn;

	public sceneEditDeck(Window newWindow, Deck newDeck) {
		this.gp = new GridPane();
		this.cn = new Scene(this.gp,width,height);
		this.window = newWindow;
		this.curDeck = newDeck;


		this.titleLabel = new Label("Edit Deck: "+this.curDeck.getName());
		


		this.gp.add(titleLabel,		0,0,	2,1);
	}

	public Scene get() {
		return this.cn;
	}
}