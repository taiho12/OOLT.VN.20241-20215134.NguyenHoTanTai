package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    @FXML public Label lblTitle;
    @FXML public Label lblCost;
    @FXML public Button btnAddToCart;
    @FXML public Button btnPlay;
    private Media media;
    private final Cart cart;
    public ItemController(Cart cart) {
        this.cart = cart;
    }
    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + "$");

        if (media instanceof Playable) btnPlay.setVisible(true);
        else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
    public void btnAddToCartClicked(ActionEvent e) {
        if (cart.addMedia(media)) {
            cart.setTotalCost(cart.getTotalCost() + media.getCost());
        }
    }
    public void btnPlayClicked(ActionEvent e) {
        PlayingPopUpController playingPopUpController = new PlayingPopUpController();

        playingPopUpController.showPlayingPopUp(media, e);
    }
}
