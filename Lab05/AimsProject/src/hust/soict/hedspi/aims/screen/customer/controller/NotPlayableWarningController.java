package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DVD;
import hust.soict.hedspi.aims.media.Media;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class NotPlayableWarningController {
    @FXML
    public TextField tfWarning;
    public void showWarning(Media media, ActionEvent e) {
        try {
            final String NOT_PLAYABLE_WARNING_PATH = "/hust/soict/hedspi/aims/screen/customer/view/NotPlayableWarning.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(NOT_PLAYABLE_WARNING_PATH));
            Parent popUpRoot = fxmlLoader.load();

            String clsName = "";

            if (media instanceof DVD) clsName = "DVD";
            else if (media instanceof CompactDisc) clsName = "CompactDisc";

            NotPlayableWarningController notPlayableWarningController = fxmlLoader.getController();
            notPlayableWarningController.tfWarning.setText("ERROR: " + clsName + " length is non-positive.");

            Stage popUpStage = new Stage();
            popUpStage.initModality(Modality.NONE);
            popUpStage.initOwner(((Node) e.getSource()).getScene().getWindow());
            popUpStage.setScene(new Scene(popUpRoot));
            popUpStage.setTitle("Illegal " + clsName + " Length");
            popUpStage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
