package com.quirko.scene;

import com.quirko.game.Game;
import com.quirko.ui.GamePane;
import com.quirko.ui.GameWindow;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InstructionScene extends BaseScene{
    private static final Logger logger = LogManager.getLogger(InstructionScene.class);
    /**
     * Create a new scene, passing in the GameWindow the scene will be displayed in
     *
     * @param gameWindow the game window
     */
    public InstructionScene(GameWindow gameWindow) {
        super(gameWindow);
    }

    @Override
    public void initialise() {

    }

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

        //Instruction title
        var instructionsTitle = new Text("Tetris Game");
        instructionsTitle.getStyleClass().add("heading");
        mainPane.setTop(instructionsTitle);

        var vBox = new VBox();

        //For now, let us just add a button that starts the game. I'm sure you'll do something way better.
        var textInstructions = new Text("Instructions");
        textInstructions.getStyleClass().add("score");


        var speedDown = new Text("Speed Down : Use arrow keys (↓) or (S) key");
        speedDown.getStyleClass().add("menuItem");
        var moveRight = new Text("Move Right : Use arrow keys (→) or (D) key");
        moveRight.getStyleClass().add("title");
        var moveLeft = new Text("Move Left : Use arrow keys (←) or (A) key");
        moveLeft.getStyleClass().add("title");
        var rotate = new Text("Rotate : Use arrow keys (↑) or (A) key");
        rotate.getStyleClass().add("title");

        var backBtn = new Button("Back");



        vBox.getChildren().add(textInstructions);
        vBox.getChildren().add(moveLeft);
        vBox.getChildren().add(moveRight);
        vBox.getChildren().add(speedDown);
        vBox.getChildren().add(rotate);
        vBox.getChildren().add(backBtn);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        mainPane.setCenter(vBox);

        //Bind the button action to the startGame method in the menu

        backBtn.setOnAction(this::backToMenu) ;
    }

    /**
     * Handle when the Start Game button is pressed
     * @param event event
     */
    public void backToMenu(ActionEvent event) {
        gameWindow.startMenu();
    }
}
