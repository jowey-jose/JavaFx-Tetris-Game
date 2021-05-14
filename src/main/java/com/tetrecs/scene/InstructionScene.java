package com.tetrecs.scene;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.tetrecs.ui.GamePane;
import com.tetrecs.ui.GameWindow;

/**
 * The main menu of the game. Provides a gateway to the rest of the game.
 */
public class InstructionScene extends BaseScene {

    private static final Logger logger = LogManager.getLogger(MenuScene.class);

    /**
     * Create a new menu scene
     * @param gameWindow the Game Window this will be displayed in
     */
    public InstructionScene(GameWindow gameWindow) {
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
        menuPane.getStyleClass().add("instructions-background");
        root.getChildren().add(menuPane);

//        var mainPane = new BorderPane();
//        menuPane.getChildren().add(mainPane);

        BorderPane border = new BorderPane();
        menuPane.getChildren().add(border);

        border.setCenter(addGridPane());

        border.setCenter(addAnchorPane(addGridPane()));


    }

    public GridPane addGridPane() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        return grid;
    }

    public AnchorPane addAnchorPane(GridPane grid) {
        AnchorPane anchorpane = new AnchorPane();
        Button buttonMenu = new Button("Menu");
        Button buttonPlay = new Button("Play");


        HBox hb = new HBox();
        hb.setPadding(new Insets(0, 10, 10, 10));
        hb.setSpacing(10);
        hb.getChildren().addAll(buttonMenu, buttonPlay);

        anchorpane.getChildren().addAll(grid,hb);   // Add grid from Example 1-5
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);
        AnchorPane.setTopAnchor(grid, 10.0);

        //Bind the button action to the startGame method in the menu
        buttonMenu.setOnAction(this::startMenu);

        return anchorpane;
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
    private void startGame(ActionEvent event) {
//        gameWindow.startChallenge();
    }

    /**
     * Handle when the Start Game button is pressed
     * @param event event
     */
    private void startMenu(ActionEvent event) {
        gameWindow.startMenu();
    }

}