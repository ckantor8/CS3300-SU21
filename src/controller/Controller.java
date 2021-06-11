package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.PlayerModel;
import view.ConfigScreen;
import view.Screen;

import java.io.FileInputStream;
import java.io.IOException;

public class Controller extends Application {
    @FXML
    public GridPane grid;
    @FXML
    public Circle user = new Circle(15);
    private Stage stage;
    private PlayerModel playerModel;
    private final int width = 500;
    private final int height = 500;
    private int c = 0;
    private int r = 1;
    private Color circ;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Your New Favorite Dungeon Crawler");
        playerModel = new PlayerModel();
        initWelcomeScreen();
    }

    private void initWelcomeScreen() {
        stage.setTitle("Your New Favorite Dungeon Crawler");
        String bigText = new String("Welcome to \n Dying for Die");
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
                try {
                    generateBoard(configScreen.getInput(), configScreen.getGold(), configScreen.getChtr());
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

    @FXML
    public void generateBoard(String name, int gold, Color chtr) throws IOException {
        // Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "C:\\Users\\royal\\OneDrive\\Desktop\\CS3300\\CS3300-SU21\\Board.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

        //loader.setController(this);

        // Create the Pane and all Details
        grid = loader.load(fxmlStream);

        // Create the Scene
        Scene scene = new Scene(grid);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("A SceneBuilder Example");

        playerModel.setName(name);
        playerModel.setGold(gold);
        circ = chtr;
        playerModel.setCharacter(chtr);
        user.setFill(chtr);
        grid.add(user, 0, 1);

        c = GridPane.getColumnIndex(user);
        r = GridPane.getRowIndex(user);
        // Display the Stage
        stage.show();
    }

    @FXML
    public void moveOneSquare(ActionEvent actionEvent) {

        grid.getChildren().remove(user);

        if ((c == 7 && r == 1) || (c == 0 && r == 3) || (r == 2 || r == 4)) {
            //GridPane.setRowIndex(user, r + 1);
            r++;
        } else if (r == 3) {
            //GridPane.setColumnIndex(user, c - 1);
            c--;
        } else {
            //GridPane.setColumnIndex(user, c + 1);
            c++;
        }

        grid.add(user, c, r);

        //user.setFill(circ);
    }

    @FXML
    public void move3Squares(ActionEvent actionEvent) {
        for(int i = 1; i <= 3; i++) {
            moveOneSquare(actionEvent);
        }
    }

    public Circle getUser() {
        return user;
    }

}