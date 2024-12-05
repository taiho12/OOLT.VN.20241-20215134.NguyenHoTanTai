package hust.soict.hedpsi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private JTextField tfDisplay;
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;

    public NumberGrid() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button);
                return;
            }

            if (button.equals("DEL")) {
                tfDisplay.setText(tfDisplay.getText().substring(0, tfDisplay.getText().length() - 1));
                return;
            }

            if (button.equals("C")) {
                tfDisplay.setText("");
            }
        }
    }

    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();

        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnDelete.addActionListener(btnListener);

        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnDelete.addActionListener(btnListener);
    }
}
