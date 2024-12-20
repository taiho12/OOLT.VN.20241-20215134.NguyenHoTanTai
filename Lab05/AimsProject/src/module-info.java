module AimsProject {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    requires java.desktop;

    opens hust.soict.hedspi.aims;
    opens hust.soict.hedspi.test.screen.customer.store;
    opens hust.soict.hedspi.aims.screen.customer.controller;

    exports hust.soict.hedspi.aims.exception;
    exports hust.soict.hedspi.aims.store;
    exports hust.soict.hedspi.aims.media;
    exports hust.soict.hedspi.aims.cart;
}