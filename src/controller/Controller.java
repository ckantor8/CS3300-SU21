package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.PlayerModel;
import view.ConfigScreen;
import view.Screen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller extends Application {
    public Circle user;
    public GridPane grid;
    private Stage stage;
    private PlayerModel playerModel;
    private final int width = 500;
    private final int height = 500;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Your New Favorite Dungeon Crawler");
        playerModel = new PlayerModel();
        initWelcomeScreen();
    }

    private void initWelcomeScreen() {
        stage.setTitle("Your New Favorite Dungeon Crawler");
        String bigText = new String("Welcome to the \n Trials of "
            + "Torturestone Castle");
        String bg = new String("file:resources/images/backgrounds/welcome_screen.png");
        String playText = new String("Click Here to Begin");
        String stats = null;
        Screen welcomeScreen = new Screen(width, height, bigText, bg, playText, null);

        Button quitButton = welcomeScreen.getQuitButton();
        quitButton.setOnAction(e -> stage.close());

        Button playButton = welcomeScreen.getPlayButton();
        playButton.setOnAction(e -> goToConfigScreen());

        Scene welcomeScene = welcomeScreen.getScene();
        stage.setScene(welcomeScene);
        stage.show();
    }

    private void goToConfigScreen() {
        stage.setTitle("Choose Very Carefully");
        ConfigScreen configScreen = new ConfigScreen(width, height);

        Button returnButton = configScreen.getReturnButton();
        returnButton.setOnAction(e -> initWelcomeScreen());
        Button advanceButton = configScreen.getAdvanceButton();

        advanceButton.setOnAction(e -> {
            if (configScreen.checkSelections() > 0) {
                setSelections(configScreen.getInput(),
                    configScreen.getDifficulty(), null, configScreen.getGold());
                try {
                    generateBoard();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else {
                goToConfigScreen();
            }
        });

        Scene configScene = configScreen.setupScene();
        stage.setScene(configScene);
        stage.show();
    }

    private void setSelections(String name, int diff, String weap, int gold) {
        playerModel.setName(name);
        playerModel.setDifficulty(diff);
        playerModel.setStartingWeapon(weap);
        playerModel.setGold(gold);
        playerModel.setGoldMult(1);
        playerModel.setDP(0);
        playerModel.setAP(5);
        playerModel.setHP(10 * gold);
    }

    private void generateBoard() throws IOException {
        // Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "C:\\Users\\royal\\OneDrive\\Desktop\\CS3300\\CS3300-SU21\\Board.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

        // Create the Pane and all Details
        GridPane root = loader.load(fxmlStream);

        // Create the Scene
        Scene scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("A SceneBuilder Example");
        // Display the Stage
        stage.show();
    }

    public void moveOneSquare(ActionEvent actionEvent) {
    }

    public void move3Squares(ActionEvent actionEvent) {
    }

}