package com.tetrecs.scene;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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

//        var mainPane = new BorderPane();
//        menuPane.getChildren().add(mainPane);

        BorderPane border = new BorderPane();
        menuPane.getChildren().add(border);

        HBox hbox = addHBox();
        border.setTop(hbox);

        border.setCenter(addVBox());

    }
    private HBox addHBox() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
        hbox.setStyle("-fx-background-color: #336699;");

        //Game title
        var title = new Text("Welcome to TetrECS Game");
        title.getStyleClass().add("score");


        hbox.getChildren().addAll(title);

        return hbox;
    }

    private VBox addVBox() {

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(8);              // Gap between nodes

        Text title = new Text("Select Menu");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        //For now, let us just add a button that starts the game. I'm sure you'll do something way better.
        var button1 = new Button("Play");
        var button2 = new Button("Instructions");

        vbox.getChildren().add(button1);
        vbox.getChildren().add(button2);

        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(50);
//        border.setCenter(vBox);

        //Bind the button action to the startMenu method in the menu
        button1.setOnAction(this::startGame) ;
        button2.setOnAction(this::startInstruction) ;


        return vbox;
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

//        gameWindow.startChallenge();
    }

    /**
     * Handle when the Start Instruction button is pressed
     * @param event event
     */
    public void startInstruction(ActionEvent event) {
        gameWindow.startInstructions();
    }


}
