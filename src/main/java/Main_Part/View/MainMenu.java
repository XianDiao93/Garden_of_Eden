package Main_Part.View;

import Main_Part.Controller.MainController;
import javafx.scene.Group;

public class MainMenu extends UI {
    MainController controller;

    public MainMenu(MainController controller) {
        super(controller);
        this.controller = controller;
    }

    @Override
    public void create() {

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
}
