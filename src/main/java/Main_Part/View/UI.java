package Main_Part.View;

import Main_Part.Controller.Controller;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public abstract class UI extends Pane {
    private Canvas canvas;
    Controller controller;

    public UI(Controller controller) {
        this.controller = controller;
        this.canvas = controller.getCanvas();
        setPickOnBounds(false);
    }

    /**
     * Creates the UI for the game.
     */
    public abstract void create();

    /**
     * Places the canvas in the designated root.
     * The canvas is where the Sprites and such are drawn onto.
     */
    public abstract void placeCanvas(Group root);

    /**
     * Updates the UI depending on the Sprites passed in.
     */
    //public abstract void updateUI(Sprite... sprites);

    /**
     * Initializes the statistics used to debug the game.
     */
    public abstract void initStats();

    public Canvas getCanvas() {
        return controller.getCanvas();
    }

    /**
     * show UI
     */
    public void show() {
        setVisible(true);
        setManaged(true);
    }

    /**
     * hide UI
     */
    public void hide() {
        setVisible(false);
        setManaged(false);
    }

    /**
     * clean up
     */
    public abstract void cleanUp();
}