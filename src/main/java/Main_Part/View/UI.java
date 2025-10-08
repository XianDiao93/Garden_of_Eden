package Main_Part.View;

import Main_Part.Controller.Controller;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public abstract class UI extends Pane {
    private Canvas canvas;
    Controller controller;

    public UI(Controller controller, Group root) {
        this.controller = controller;
        this.canvas = controller.getCanvas();
        setPickOnBounds(false);
    }

    /**
     * set layout of pages
     */
    public abstract void setLayout();

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


    /**
     *  update sprites
     */
    public abstract void updateSprites();

    /**
     * get the root
     */
    public abstract Node getView();
}