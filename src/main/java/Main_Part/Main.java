package Main_Part;

import Main_Part.Controller.MainController;
import Main_Part.View.MainMenu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/*
All views must have a main controller and a specific controller except for main menu;
The main controller is used to manage all pages and control page redirection logic
Other controllers are used to control other behaviours
*/

public class Main extends Application {
    private Canvas canvas;
    private Group root;

    private MainController mainController;

    public static void main(String[] args) {
        loadResources();
        launch(args);
    }

    @Override
    public void start(Stage defaultStage) throws Exception {
        canvas = new Canvas(1000, 750);
        root = new Group();
        mainController = new MainController(canvas, root);

        Scene scene = new Scene(root, 1000, 750);

        defaultStage.setTitle("Garden Of Eden");
        defaultStage.setScene(scene);
        defaultStage.show();
    }

    /**
     * Load data from mapping files
     */
    public static void loadResources() {

    }
}