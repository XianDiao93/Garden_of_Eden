package Main_Part.View;

import Main_Part.Controller.MainController;
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

public class MainMenu extends UI {
    MainController controller;
    Group root;

    public MainMenu(MainController controller, Group root) {
        super(controller, root);
        this.controller = controller;
        this.root = root;

        setLayout();
    }

    @Override
    public void setLayout() {
        VBox mainMenu = new VBox(40);
        mainMenu.setAlignment(Pos.CENTER);
        mainMenu.setPrefSize(1000, 750);

        Label title = new Label("Garden Of Eden");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 100));
        title.setTextFill(Color.WHITE);

        Button start = new Button("New Simulation");
        Button load = new Button("Load Simulation");
        Button settings = new Button("SettingsMenu");
        Button exit = new Button("Exit");

        start.setMinSize(200, 60);
        load.setMinSize(200, 60);
        settings.setMinSize(200, 60);
        exit.setMinSize(200, 60);

        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 30);
        start.setFont(buttonFont);
        load.setFont(buttonFont);
        settings.setFont(buttonFont);
        exit.setFont(buttonFont);

        // set transparent background and text
        start.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        load.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        settings.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        exit.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");

        // set cursor float effect
        start.setOnMouseEntered(e -> start.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: #3498db;"));
        start.setOnMouseExited(e -> start.setStyle("-fx-background-color: transparent; -fx-text-fill: white;"));

        load.setOnMouseEntered(e -> load.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: #3498db;"));
        load.setOnMouseExited(e -> load.setStyle("-fx-background-color: transparent; -fx-text-fill: white;"));

        settings.setOnMouseEntered(e -> settings.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: #3498db;"));
        settings.setOnMouseExited(e -> settings.setStyle("-fx-background-color: transparent; -fx-text-fill: white;"));

        exit.setOnMouseEntered(e -> exit.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-text-fill: #e74c3c;"));
        exit.setOnMouseExited(e -> exit.setStyle("-fx-background-color: transparent; -fx-text-fill: white;"));

        // set round angle background
        start.setStyle(start.getStyle() + " -fx-background-radius: 5px;");
        load.setStyle(load.getStyle() + " -fx-background-radius: 5px;");
        settings.setStyle(settings.getStyle() + " -fx-background-radius: 5px;");
        exit.setStyle(exit.getStyle() + " -fx-background-radius: 5px;");

        // set cursor style
        start.setCursor(Cursor.HAND);
        load.setCursor(Cursor.HAND);
        settings.setCursor(Cursor.HAND);
        exit.setCursor(Cursor.HAND);

        settings.setOnAction(e -> {
            controller.pageRedirection(2);
        });

        exit.setOnAction(e -> {
            Platform.exit();
        });

        mainMenu.getChildren().addAll(title, start, load, settings, exit);

        this.getChildren().add(mainMenu);
        this.setStyle("-fx-background-color: linear-gradient(to bottom, #2c3e50, #4a6491); -fx-padding: 20px;");

        StackPane.setAlignment(this, Pos.CENTER);
    }

    @Override
    public void placeCanvas(Group root) {
        controller.placeCanvas(root);
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

    @Override
    public Node getView() {
        return root;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
