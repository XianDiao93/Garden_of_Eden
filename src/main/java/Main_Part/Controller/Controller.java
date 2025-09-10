package Main_Part.Controller;

import javafx.scene.canvas.Canvas;

public abstract class Controller {
    private Canvas canvas;

    public Controller(Canvas canvas) {
        this.canvas = canvas;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
