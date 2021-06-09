package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ConfigScreen {
    private int width;
    private int height;
    private Button advanceButton;
    private Button returnButton;
    private VBox options;
    private TextField name;
    private int diff;
    private String weap;
    private String input;
    private ToggleButton easy;
    private ToggleButton medium;
    private ToggleButton hard;
    private ToggleButton vhard;
    private ToggleButton sword;
    private ToggleButton axe;
    private ToggleButton staff;
    private ToggleButton dagger;
    private int gold;

    private ConfigScreen() {
    }

    public ConfigScreen(int width, int height) {
        this.width = width;
        this.height = height;
        returnButton = new Button("Back");
        advanceButton = new Button("Begin Game");
    }

    public Scene setupScene() {
        BorderPane configPane = new BorderPane();
        Scene configScene = new Scene(configPane, width, height);
        options = new VBox();
        options.setPadding(new Insets(100, 0, 0, 0));
        options.setSpacing(20);
        options.setAlignment(Pos.CENTER);
        configPane.setCenter(options);

        Image image0 = new Image("file:resources/images/backgrounds/config_screen.png");
        BackgroundSize backgroundSize0 = new BackgroundSize(
            BackgroundSize.AUTO, BackgroundSize.AUTO,
            true, true, true, true);
        BackgroundImage backgroundImage0 = new BackgroundImage(image0,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            backgroundSize0);
        Background background1 = new Background(backgroundImage0);
        configPane.setBackground(background1);

        return getScene(configPane, configScene);
    }

    public Scene getScene(BorderPane configPane, Scene configScene) {

        name = new TextField();
        name.setId("name");
        name.setPrefWidth(215);
        name.setMaxWidth(215);
        Text instr1 = new Text("Type Your Name");
        instr1.setFill(Color.DARKSLATEGRAY);
        instr1.setFont(new Font("Copperplate Gothic Bold", 20));
        instr1.setTextAlignment(TextAlignment.CENTER);
        StackPane instruction1 = new StackPane();

        instruction1.setBackground(new Background(new
            BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY,
            new Insets(0, 140, 0, 140))));
        instruction1.getChildren().add(instr1);
        options.getChildren().add(instruction1);
        options.getChildren().add(name);
        HBox difficulties = new HBox();
        difficulties.setSpacing(10);
        difficulties.setAlignment(Pos.CENTER);
        Text instr2 = new Text("Select Your Difficulty");
        instr2.setFill(Color.DARKSLATEGRAY);
        instr2.setFont(new Font("Copperplate Gothic Bold", 17));
        StackPane instruction2 = new StackPane();
        instruction2.setBackground(new Background(new
            BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY,
            new Insets(0, 140, 0, 140))));
        instruction2.getChildren().add(instr2);
        options.getChildren().add(instruction2);
        options.getChildren().add(difficulties);

        ToggleGroup difficulty = new ToggleGroup();
        easy = new ToggleButton("Novice");
        easy.setId("easy");
        easy.getStyleClass().add("bronze");
        easy.getStyleClass().add("button");
        difficulties.getChildren().add(easy);
        easy.setToggleGroup(difficulty);
        medium = new ToggleButton("Adept");
        medium.getStyleClass().add("silver");
        medium.getStyleClass().add("button");
        difficulties.getChildren().add(medium);
        medium.setToggleGroup(difficulty);
        hard = new ToggleButton("Expert");
        hard.setId("hard");
        hard.getStyleClass().add("gold");
        hard.getStyleClass().add("button");
        difficulties.getChildren().add(hard);
        hard.setToggleGroup(difficulty);
        vhard = new ToggleButton("Master");
        vhard.getStyleClass().add("plat");
        vhard.getStyleClass().add("button");
        difficulties.getChildren().add(vhard);
        vhard.setToggleGroup(difficulty);

        Text instr3 = new Text("Choose Your Weapon");
        instr3.setFill(Color.DARKSLATEGRAY);
        instr3.setFont(new Font("Copperplate Gothic Bold", 18));
        StackPane instruction3 = new StackPane();
        instruction3.setBackground(new Background(new
            BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY,
            new Insets(0, 140, 0, 140))));
        instruction3.getChildren().add(instr3);
        options.getChildren().add(instruction3);
        HBox weapons = new HBox();
        weapons.setSpacing(10);
        weapons.setAlignment(Pos.CENTER);
        ToggleGroup weapon = new ToggleGroup();

        Image image3 = new Image("file:resources/images/weapons/skull_staff_0.png");
        ImageView img3 = new ImageView(image3);
        staff = new ToggleButton("Staff", img3);
        staff.setContentDisplay(ContentDisplay.TOP);

        Image image1 = new Image("file:resources/images/weapons/w_broadsword_0.png");
        ImageView img1 = new ImageView(image1);
        img1.setFitWidth(image3.getWidth());
        img1.setFitHeight(image3.getHeight());
        sword = new ToggleButton("Sword", img1);
        sword.setId("sword");
        sword.setContentDisplay(ContentDisplay.TOP);
        weapons.getChildren().add(sword);
        sword.setToggleGroup(weapon);

        Image image2 = new Image("file:resources/images/weapons/w_axe_war_0.png");

        ImageView img2 = new ImageView(image2);
        img2.setFitWidth(image3.getWidth());
        img2.setFitHeight(image3.getHeight());
        axe = new ToggleButton("Axe", img2);
        axe.setId("axe");
        axe.setContentDisplay(ContentDisplay.TOP);
        weapons.getChildren().add(axe);
        axe.setToggleGroup(weapon);
        axe.setId("axe");

        weapons.getChildren().add(staff);
        staff.setToggleGroup(weapon);
        staff.setId("staff");

        Image image4 = new Image("file:resources/images/weapons/w_dagger_0.png");
        ImageView img4 = new ImageView(image4);
        img4.setFitWidth(image3.getWidth());
        img4.setFitHeight(image3.getHeight());
        dagger = new ToggleButton("Dagger", img4);
        dagger.setContentDisplay(ContentDisplay.TOP);
        weapons.getChildren().add(dagger);
        dagger.setToggleGroup(weapon);
        dagger.setId("dagger");
        options.getChildren().add(weapons);

        HBox buttons = new HBox();
        buttons.setSpacing(25);
        returnButton.getStyleClass().add("return");
        returnButton.setMinSize(100, 40);
        returnButton.setMaxSize(100, 40);
        advanceButton.getStyleClass().add("advance");
        advanceButton.setMinSize(100, 40);
        advanceButton.setMaxSize(100, 40);
        buttons.getChildren().add(returnButton);
        buttons.getChildren().add(advanceButton);
        configPane.setBottom(buttons);
        buttons.setAlignment(Pos.CENTER);

        configPane.setMargin(options, new Insets(0, 0, 0, 0));
        configPane.setMargin(buttons, new Insets(0, 0, 10, 0));
        configScene.getStylesheets().add("file:resources/css/ConfigScreen.css");
        return configScene;
    }

    public int checkSelections() {
        input = name.getText();
        if (input == null || input.isEmpty() || input.trim().isEmpty()) {
            Alert invalidName = new Alert(Alert.AlertType.ERROR);
            invalidName.setTitle("Error Dialog");
            invalidName.setHeaderText("Invalid Name");
            invalidName.setContentText("Invalid name " + '"' + input + '"'
                + " entered\nPlease enter a valid name");
            invalidName.show();
        } else {
            diff = 0;
            if (easy.isSelected()) {
                diff = 1;
            } else if (medium.isSelected()) {
                diff = 2;
            } else if (hard.isSelected()) {
                diff = 3;
            } else if (vhard.isSelected()) {
                diff = 4;
            } else {
                Alert invalidDiff = new Alert(Alert.AlertType.ERROR);
                invalidDiff.setTitle("Error Dialog");
                invalidDiff.setHeaderText("Invalid Difficulty");
                invalidDiff.setContentText("No difficulty chosen\nPlease "
                    + "select a difficulty");
                invalidDiff.show();
            }
            gold = 5 - diff;

            weap = "0";
            if (sword.isSelected()) {
                weap = "Sword";
            } else if (axe.isSelected()) {
                weap = "Axe";
            } else if (staff.isSelected()) {
                weap = "Staff";
            } else if (dagger.isSelected()) {
                weap = "Dagger";
            } else {
                Alert invalidW = new Alert(Alert.AlertType.ERROR);
                invalidW.setTitle("Error Dialog");
                invalidW.setHeaderText("Invalid Weapon");
                invalidW.setContentText("No weapon chosen\nPlease "
                    + "select a weapon");
                invalidW.show();
            }

            if (!weap.equals("0") && diff != 0) {
                return 1;
            }

        }
        return -1;
    }

    public int getDifficulty() {
        return diff;
    }

    public String getWeapon() {
        return weap;
    }

    public String getInput() {
        return input;
    }

    public int getGold() {
        return gold;
    }

    public Button getAdvanceButton() {
        return advanceButton;
    }

    public Button getReturnButton() {
        return returnButton;
    }

}
