package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCDToStoreScreen extends AddItemToStoreScreen{
    public AddCDToStoreScreen(StoreManagerScreen storeManagerScreen) {
        super(storeManagerScreen);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel itemInputField = new JPanel(new GridLayout(3, 2));
        itemInputField.add(new JLabel("Title"));
        itemInputField.add(titleField);
        itemInputField.add(new JLabel("Category"));
        itemInputField.add(categoryField);
        itemInputField.add(new JLabel("Cost"));
        itemInputField.add(costField);

        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(new addBtnListener());

        cp.add(createMenuBar(), BorderLayout.NORTH);
        cp.add(itemInputField, BorderLayout.CENTER);
        cp.add(addBtn, BorderLayout.SOUTH);

        setTitle("Add CD to Store Screen");
        setSize(440, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    private class addBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            String category = categoryField.getText();
            int cost = Integer.parseInt(costField.getText());

            CompactDisc cd = new CompactDisc(title, category, cost);
            storeManagerScreen.getStore().addMedia(cd);

            storeManagerScreen.getCenter().removeAll();
            storeManagerScreen.updateStoreScreen();
        }
    }
}
