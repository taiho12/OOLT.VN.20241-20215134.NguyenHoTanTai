package Ex6_2;

import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your name?");
        String strName = keyboard.nextLine();
        System.out.println("How old are you?");
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you?");
        double dHeight = keyboard.nextDouble();
            
        //similiar to other data types
        //nextByte(), nextShort(), nextLong()
        //nextFloat(), nextBoolean()
            
        System.out.println("Mrs/ms. " + strName + ", " + iAge + " years old." +
                " Yours height is " + dHeight);
        keyboard.close();
    }
}
