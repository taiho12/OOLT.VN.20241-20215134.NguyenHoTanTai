package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayingPopUpController {
    @FXML
    public AnchorPane playingPopUp;
    @FXML
    public TextArea tfPlayingPopUp;
    public void setPlayingText(String title, float cost) {
        tfPlayingPopUp.setText("Title: " + title + "\n" + "Cost: " + cost);
    }
    public void showPlayingPopUp(Media media, ActionEvent e) {
        try {
            if (media instanceof Playable) ((Playable) media).play();

            final String PLAYING_POPUP_PATH = "/hust/soict/hedspi/aims/screen/customer/view/PlayingPopUp.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PLAYING_POPUP_PATH));
            Parent popUpRoot = fxmlLoader.load();

            PlayingPopUpController playingPopUpController = fxmlLoader.getController();
            playingPopUpController.setPlayingText(media.getTitle(), media.getCost());

            Stage popUpStage = new Stage();
            popUpStage.initModality(Modality.NONE);
            popUpStage.initOwner(((Node) e.getSource()).getScene().getWindow());
            popUpStage.setScene(new Scene(popUpRoot));
            popUpStage.setTitle("Playing~");
            popUpStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (PlayerException pe) {
            NotPlayableWarningController notPlayableWarningController = new NotPlayableWarningController();
            notPlayableWarningController.showWarning(media, e);
            pe.printStackTrace();
        }
    }
}
