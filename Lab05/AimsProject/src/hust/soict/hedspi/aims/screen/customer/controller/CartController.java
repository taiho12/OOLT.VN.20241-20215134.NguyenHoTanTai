package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {
    private Cart cart;
    private final Store store;
    @FXML
    public TableView<Media> tblMedia;
    @FXML
    public TableColumn<Media, Integer> colMediaId;
    @FXML
    public TableColumn<Media, String> colMediaTitle;
    @FXML
    public TableColumn<Media, String> colMediaCategory;
    @FXML
    public TableColumn<Media, Float> colMediaCost;
    @FXML
    public Button btnRemove;
    @FXML
    public Button btnPlay;
    @FXML
    TextField tfFilter;
    @FXML
    public ToggleGroup filterCategory;
    @FXML
    public Label costLabel;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }
    public void updateTotalCost() {
        costLabel.setText(cart.getTotalCost() + "$");
    }
    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<>("Id")
        );
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<>("Title")
        );
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<>("Category")
        );
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<>("Cost")
        );

        if (cart.getItemsOrdered() != null)
            tblMedia.setItems(cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> updateButtonBar(newValue)
        );

        tfFilter.textProperty().addListener(
                (observable, oldValue, newValue) -> showFilteredMedia(newValue)
        );
    }
    void showFilteredMedia(String value) {

    }
    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }

        if (media != null) {
            btnRemove.setVisible(true);

            btnPlay.setVisible(media instanceof Playable);
        }
    }
    @FXML
    void btnRemovePressed(ActionEvent e) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        cart.setTotalCost(cart.getTotalCost() - media.getCost());
        updateTotalCost();
    }
    @FXML
    void btnPlayPressed(ActionEvent e) {
        PlayingPopUpController playingPopUpController = new PlayingPopUpController();
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        playingPopUpController.showPlayingPopUp(media, e);
    }
    @FXML
    void btnViewStorePressed(ActionEvent e) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));

            Parent root = fxmlLoader.load();

            Stage storeStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            storeStage.setScene(new Scene(root));
            storeStage.setTitle("Store");
            storeStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    @FXML
    public void btnPlaceOrderClicked(ActionEvent e) {
        try {
            final String ORDER_PLACED_POPUP_PATH = "/hust/soict/hedspi/aims/screen/customer/view/OrderPlacedPopUp.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ORDER_PLACED_POPUP_PATH));

            Parent orderPlacedPopUpRoot = fxmlLoader.load();
            Stage orderPlacedStage = new Stage();
            orderPlacedStage.initOwner(((Node) e.getSource()).getScene().getWindow());
            orderPlacedStage.setScene(new Scene(orderPlacedPopUpRoot));
            orderPlacedStage.setTitle("Notification");
            orderPlacedStage.show();

            tblMedia.getItems().clear();
            cart = new Cart();
            updateTotalCost();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
