package Main_Part.Controller;

import Main_Part.View.MainMenu;
import Main_Part.View.SettingsMenu;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;

public class MainController extends Controller {
    private StackPane canvasStack;
    private Canvas canvas;
    private StackPane uiLayer;
    private Group root;

    // all views
    private MainMenu mainMenu;
    private SettingsMenu settingsMenu;

    // all controllers
    private SettingsController settingsController;

    public MainController(Canvas canvas, Group root) {
        super(canvas);
        this.canvas = canvas;
        this.canvasStack = new StackPane();
        this.uiLayer = new StackPane();

        uiLayer.setAlignment(Pos.CENTER);
        canvasStack.setPrefSize(canvas.getWidth(), canvas.getHeight());
        canvasStack.getChildren().addAll(canvas, uiLayer);
        canvasStack.setAlignment(Pos.CENTER);
        canvas.setMouseTransparent(true);

        this.root = root;

        settingsController = new SettingsController(canvas);
        settingsMenu = new SettingsMenu(settingsController, this, root);

        mainMenu = new MainMenu(this, root);

        placeCanvas(root);
        setUIContent(mainMenu);
    }

    public void placeCanvas(Group root) {
        if (!root.getChildren().contains(canvasStack)) {
            root.getChildren().add(canvasStack);
        }
    }

    public void pageRedirection(int i) {
        switch (i) {
            case 0:
                uiLayer.getChildren().clear();
                break;
            case 1:
                uiLayer.getChildren().clear();
                break;
            case 2:
                setUIContent(settingsMenu);
                break;
            case 3:
                setUIContent(mainMenu);
                break;
            default:
                break;
        }
    }

    public void setUIContent(javafx.scene.Node content) {
        uiLayer.getChildren().clear();
        if (content != null) {
            uiLayer.getChildren().add(content);
        }
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public StackPane getUiLayer() {
        return uiLayer;
    }
}
