package Main_Part.Controller;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class MainController extends Controller {
    public static StackPane canvasStack;

    private Canvas canvas;
    private BorderPane uiPane;

    public MainController(Canvas canvas) {
        super(canvas);
        this.canvas = canvas;
        uiPane = new BorderPane(canvas);
        uiPane.setId("uiPane");
        canvasStack = new StackPane();
    }

    public void placeCanvas(Group root) {
        StackPane.setAlignment(getCanvas(), Pos.CENTER);

        getCanvas().setMouseTransparent(true);

        canvasStack.getChildren().clear();
        canvasStack.getChildren().addAll(getCanvas(), uiPane);

        root.getChildren().add(canvasStack);
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
