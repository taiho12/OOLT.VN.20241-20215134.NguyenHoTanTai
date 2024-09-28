package Main;

import javax.swing.JOptionPane;

public class HelloNameDialog {
    public static void main(String[] args) {
        String result;
        result = JOptionPane.showInputDialog("Nguyen Ho Tan Tai - 20215134 - Please enter your name:");
        JOptionPane.showMessageDialog(null,
            "Toi la Nguyen Ho Tan Tai - 20215134. Hi " + result + "!");
        System.exit(0);
    }
}
