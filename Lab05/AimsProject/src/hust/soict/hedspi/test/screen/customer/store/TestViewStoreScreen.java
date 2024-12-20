package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DVD;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;
    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

        fxmlLoader.setController(new ViewStoreController(store, cart));

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        Book myBook = new Book();
        DVD myDVD = new DVD();
        CompactDisc myCD = new CompactDisc();

        // Setting titles using the setTitle method
        myBook.setTitle("The Great Gatsby");
        myDVD.setTitle("Inception");
        myCD.setTitle("Abbey Road");

        myDVD.setLength(100);
        myCD.setLength(60);

        myDVD.setCost(20);
        myCD.setCost(20);

        store.addMedia(myBook);
        store.addMedia(myCD);
        store.addMedia(myDVD);

        DVD myDVD1 = new DVD();
        myDVD1.setTitle("You, and the world like night!");
        myDVD1.setLength(-20);
        myDVD1.setCost(100);
        store.addMedia(myDVD1);

        launch(args);
    }
}
