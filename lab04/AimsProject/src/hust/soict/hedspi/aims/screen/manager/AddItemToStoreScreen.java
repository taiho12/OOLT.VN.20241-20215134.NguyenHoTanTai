package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class AddItemToStoreScreen extends JFrame {
    public StoreManagerScreen storeManagerScreen;
    protected JTextField titleField = new JTextField();
    protected JTextField categoryField = new JTextField();
    protected JTextField costField = new JTextField();

    public AddItemToStoreScreen(StoreManagerScreen storeManagerScreen) {
        this.storeManagerScreen = storeManagerScreen;
    }
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> dispose());
        menu.add(viewStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }
}
