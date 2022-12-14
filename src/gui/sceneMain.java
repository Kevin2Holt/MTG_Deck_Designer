package src.gui;

import src.gui.Window;

import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class sceneMain {

	GridPane gp;
	Scene cn;
	Window window;

	final int width = 500;
	final int height = 350;

	Label titleLabel;
	Button newDeckBtn;
	Button loadDeckBtn;

	public sceneMain(Window newWindow) {
		this.gp = new GridPane();
		this.cn = new Scene(this.gp,width,height);
		this.window = newWindow;

		this.titleLabel = new Label("Magic: The Gathering\nDeck Designer");

		this.newDeckBtn = new Button("New");
		this.newDeckBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				this.window.close();
				new Window().openCreateDeckScene();
			}
		});

		this.loadDeckBtn = new Button("Load");
		this.loadDeckBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				this.window.openLoadDeckScene();
			}
		});

		this.gp.add(titleLabel,		0,0,	2,1);

		this.gp.add(newDeckBtn,		0,1);
		this.gp.add(loadDeckBtn,	1,1);
	}

	public Scene get() {
		return this.cn;
	}
}