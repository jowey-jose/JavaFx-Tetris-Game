package com.quirko.scene;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.quirko.ui.GamePane;
import com.quirko.ui.GameWindow;


/**
 * The main menu of the game. Provides a gateway to the rest of the game.
 */
public class MenuScene extends BaseScene {

    private static final Logger logger = LogManager.getLogger(MenuScene.class);
    private PlayGameScene playGameScene;
    /**
     * Create a new menu scene
     * @param gameWindow the Game Window this will be displayed in
     */
    public MenuScene(GameWindow gameWindow) {
        super(gameWindow);
        logger.info("Creating Menu Scene");
    }

    /**
     * Build the menu layout
     */
    @Override
    public void build() {
        logger.info("Building " + this.getClass().getName());

        root = new GamePane(gameWindow.getWidth(),gameWindow.getHeight());

        var menuPane = new StackPane();
        menuPane.setMaxWidth(gameWindow.getWidth());
        menuPane.setMaxHeight(gameWindow.getHeight());
        menuPane.getStyleClass().add("menu-background");
        root.getChildren().add(menuPane);

        var mainPane = new BorderPane();
        menuPane.getChildren().add(mainPane);

        //Awful title
        var title = new Text("TetrECS");
        title.getStyleClass().add("title");
        mainPane.setTop(title);

        var vBox = new VBox();

        //For now, let us just add a button that starts the game. I'm sure you'll do something way better.
        var button1 = new Button("Play");
        var button2 = new Button("Instructions");
        var button3 = new Button("Lobby");

        vBox.getChildren().add(button1);
        vBox.getChildren().add(button2);
        vBox.getChildren().add(button3);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(50);
        mainPane.setCenter(vBox);

        //Bind the button action to the startGame method in the menu

        button1.setOnAction(this::startGame) ;
        button2.setOnAction(this::startInstruction) ;


    }

    /**
     * Initialise the menu
     */
    @Override
    public void initialise() {

    }

    /**
     * Handle when the Start Game button is pressed
     * @param event event
     */
    public void startGame(ActionEvent event) {
        gameWindow.startChallenge();
    }

    /**
     * Handle when the Start Instruction button is pressed
     * @param event event
     */
    public void startInstruction(ActionEvent event) {
        gameWindow.startInstructions();
    }


}
