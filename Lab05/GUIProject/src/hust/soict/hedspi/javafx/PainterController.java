package hust.soict.hedspi.javafx;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    private Color mouseColor = Color.BLACK;
    private int radius = 4;

    @FXML
    public void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    public void drawingAreaMouseDragged(MouseEvent e) {
        Circle newCircle = new Circle(e.getX(), e.getY(), radius, mouseColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    public void drawingAreaPen() {
        mouseColor = Color.BLACK;
        radius = 4;
    }
    @FXML
    public void drawingAreaEraser() {
        mouseColor = Color.WHITE;
        radius = 8;
    }
}
