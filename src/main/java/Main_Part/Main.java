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
public class Main extends Application {
    private Canvas canvas;
    private Group root;
    private MainMenu mainMenu;
    private MainController mainMenuController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage defaultStage) throws Exception {
        canvas = new Canvas(1000, 750);
        root = new Group();
        mainMenuController = new MainController(canvas);

        mainMenu = new MainMenu(mainMenuController);

        mainMenu.placeCanvas(root);

        Scene scene = new Scene(root, 1000, 750);

        defaultStage.setTitle("Garden Of Eden");
        defaultStage.setScene(scene);
        defaultStage.show();
    }
}