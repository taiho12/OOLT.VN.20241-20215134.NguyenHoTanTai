package Main;

import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "Nguyen Ho Tan Tai - 20215134 - You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null,
            "Nguyen Ho Tan Tai - 20215134 - Please input the first number: ",
            "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null,
            "Nguyen Ho Tan Tai - 20215134 - Please input the second number: ",
            "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;

        JOptionPane.showMessageDialog(null, strNotification,
            "Nguyen Ho Tan Tai - 20215134 - Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
