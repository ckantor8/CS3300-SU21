package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
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
    public Circle user = new Circle(15);
    public Button moveOne = new Button("Move 1");
    public Button moveThree = new Button("Move 3");
    private Stage stage;
    public PlayerModel playerModel = new PlayerModel();
    private final int width = 500;
    private final int height = 500;
    private int c = 0;
    private int r = 1;
    private Color color;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Your New Favorite Dungeon Crawler");
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

    public void generateBoard(String name, int gold, Color chtr) throws IOException {
        // Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "C:\\Users\\royal\\OneDrive\\Desktop\\CS3300\\CS3300-SU21\\Board.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

        //loader.setController(this);

        // Create the Pane and all Details
        grid = loader.load(fxmlStream);

        grid.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(0), new Insets(0))));
        grid.getStyleClass().add("mygridStyle");

        // Create the Scene
        Scene scene = new Scene(grid);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("A SceneBuilder Example");

        playerModel.setName(name);
        playerModel.setGold(gold);
        playerModel.setCharacter(chtr);
        user.setFill(playerModel.getCharacter());
        color = playerModel.getCharacter();
        grid.add(user, 0, 1);
        grid.add(moveOne, 1, 6, 2, 1);
        grid.add(moveThree, 5, 6, 2, 1);

        c = GridPane.getColumnIndex(user);
        r = GridPane.getRowIndex(user);
        // Display the Stage
        stage.show();

        moveOne.setOnAction(e -> moveOneSquare());
        moveThree.setOnAction(e -> move3Squares());
    }

    public void moveOneSquare() {

        grid.getChildren().remove(user);

        if ((c == 7 && r == 1) || (c == 0 && r == 3) || (r == 2 || r == 4)) {
            r++;
        } else if (r == 3) {
            c--;
        } else if (c == 7 && r == 5) {
            youWin();
        } else {
            c++;
        }

        //user.setFill(playerModel.getCharacter());
        grid.add(user, c, r);
        //user.setFill(playerModel.getCharacter());

    }

    public void move3Squares() {
        for(int i = 1; i <= 3; i++) {
            moveOneSquare();
        }
    }

    private void youWin() {
        stage.setTitle("You Win!");
        String bigText = new String("Congratulations on winning \n "
            + "Dying for Die, " + playerModel.getName() + "!");
        String bg = new String("file:resources/images/backgrounds/win_screen.jpg");
        String playText = new String("Click Here to Play Again");
        Screen winScreen = new Screen(width, height, bigText, bg, playText, null);

        Button quitButton = winScreen.getQuitButton();
        quitButton.setOnAction(e -> stage.close());

        Button replayButton = winScreen.getPlayButton();
        replayButton.setId("replaybutton");
        replayButton.setOnAction(e -> initWelcomeScreen());

        Scene winScene = winScreen.getScene();
        stage.setScene(winScene);
        stage.show();
    }

    public Circle getUser() {
        return user;
    }

}