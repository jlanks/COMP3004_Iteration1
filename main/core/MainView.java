package core;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MainView extends Pane {

	Pane innerPane = new Pane();
	Button addToButton = new Button("Add To Meld");
	Button createNewButton = new Button("Create New Meld");
	Button drawTileButton = new Button("Draw Tile");
	Button endTurnButton = new Button("NEXT TURN");
	ListView<String> meldList = new ListView<String>();
	Label meldlabel = new Label("MELDS ON TABLE:");


	public MainView(final Controller c) {
		Game game = c.getGame();
		meldlabel.relocate(10, 10);
		meldlabel.setPrefSize(150, 25);

		// Position the "Add To Meld" Button
		addToButton.relocate(10, 295);
		addToButton.setPrefSize(150, 20);

		// Position the "Create New Meld" Button
		createNewButton.relocate(10, 320);
		createNewButton.setPrefSize(150, 20);
		
		drawTileButton.relocate(10, 345);
		drawTileButton.setPrefSize(150, 20);
		
		endTurnButton.relocate(10, 370);
		endTurnButton.setPrefSize(150, 20);

		// each row needs to be an array of tile representations
		// make a method in meld class which represents
		// the meld in a string form.
		// array of melds in string form can then populate
		// the listview
		//
		meldList.setItems(FXCollections.observableArrayList(game.getTable().getMeldsString()));
		meldList.relocate(10, 45);
		meldList.setPrefSize(150, 245);
		
		GameInfoView giv = new GameInfoView(c);
		Pane infoPane = new Pane();
		infoPane.getChildren().add(giv);
		infoPane.relocate(200, 0);
		
		// Adding elements to the pane
		innerPane.getChildren().addAll(meldlabel, addToButton, createNewButton, drawTileButton, meldList, endTurnButton, infoPane);
		getChildren().addAll(innerPane);

		// *** EVENT HANDLERS ***//
		addToButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				innerPane.getChildren().clear();
				innerPane.getChildren().addAll(meldlabel, addToButton, createNewButton, drawTileButton, meldList, endTurnButton);
				String meldStr = meldList.getSelectionModel().getSelectedItem();
				//System.out.println(meldStr);
				AddToMeldView atv = new AddToMeldView(c, meldStr);
				atv.relocate(200, 0);
				innerPane.getChildren().add(atv);
			}
		});
		
		createNewButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				innerPane.getChildren().clear();
				innerPane.getChildren().addAll(meldlabel, addToButton, createNewButton, drawTileButton, meldList, endTurnButton);
				CreateMeldView cmv = new CreateMeldView(c);
				cmv.relocate(200, 0);
				innerPane.getChildren().add(cmv);
			}
		});
		
		endTurnButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				c.nextTurn();
				innerPane.getChildren().clear();
				innerPane.getChildren().addAll(meldlabel, addToButton, createNewButton, drawTileButton, meldList, endTurnButton);
				meldList.setItems(FXCollections.observableArrayList(c.getTable().getMeldsString()));
				GameInfoView giv = new GameInfoView(c);
				Pane infoPane = new Pane();
				infoPane.getChildren().add(giv);
				infoPane.relocate(200, 0);
				innerPane.getChildren().add(infoPane);
			}
		});
		
		drawTileButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				c.giveTile();
				innerPane.getChildren().clear();
				innerPane.getChildren().addAll(meldlabel, addToButton, createNewButton, drawTileButton, meldList, endTurnButton);
				meldList.setItems(FXCollections.observableArrayList(c.getTable().getMeldsString()));
				GameInfoView giv = new GameInfoView(c);
				Pane infoPane = new Pane();
				infoPane.getChildren().add(giv);
				infoPane.relocate(200, 0);
				innerPane.getChildren().add(infoPane);
			}
		});
	}
}
