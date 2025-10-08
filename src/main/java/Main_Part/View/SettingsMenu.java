package Main_Part.View;

import Main_Part.Controller.MainController;
import Main_Part.Controller.SettingsController;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SettingsMenu extends UI{
    MainController mainController;
    SettingsController controller;
    Group root;
    public SettingsMenu(SettingsController controller, MainController mainController, Group root) {
        super(controller, root);
        this.mainController = mainController;
        this.controller = controller;
        this.root = root;

        setLayout();
    }

    @Override
    public void setLayout() {
        VBox titleBox = new VBox(100);
        titleBox.setAlignment(Pos.TOP_CENTER);
        titleBox.setPrefSize(1000, 750);

        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.TOP_LEFT);
        buttonBox.setPrefSize(1000, 750);

        Label title = new Label("Settings");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        title.setTextFill(Color.WHITE);

        Label text = new Label("Not Available");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 100));
        text.setTextFill(Color.WHITE);

        Button back = new Button("Back");
        Button exit = new Button("Exit");

        back.setMinSize(100, 30);
        exit.setMinSize(100, 30);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 30);
        back.setFont(buttonFont);
        exit.setFont(buttonFont);

        // set transparent background and text
        back.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        exit.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");

        // set cursor float effect
        back.setOnMouseEntered(e -> back.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: #3498db;"));
        back.setOnMouseExited(e -> back.setStyle("-fx-background-color: transparent; -fx-text-fill: white;"));

        exit.setOnMouseEntered(e -> exit.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: #e74c3c;"));
        exit.setOnMouseExited(e -> exit.setStyle("-fx-background-color: transparent; -fx-text-fill: white;"));

        // set round angle background
        back.setStyle(back.getStyle() + " -fx-background-radius: 5px;");
        exit.setStyle(exit.getStyle() + " -fx-background-radius: 5px;");

        // set cursor style
        back.setCursor(Cursor.HAND);
        exit.setCursor(Cursor.HAND);

        back.setOnAction(e -> {
            mainController.pageRedirection(3);
        });

        exit.setOnAction(e -> {
            Platform.exit();
        });

        titleBox.getChildren().addAll(title, text);
        buttonBox.getChildren().addAll(back, exit);

        this.getChildren().addAll(titleBox, buttonBox);
        this.setStyle("-fx-background-color: linear-gradient(to bottom, #2c3e50, #4a6491); -fx-padding: 20px;");

    }

    @Override
    public void placeCanvas(Group root) {
        mainController.placeCanvas(root);
    }

    @Override
    public void initStats() {

    }

    @Override
    public void cleanUp() {

    }

    @Override
    public void updateSprites() {

    }

    public Node getView() {
        return root;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
