package Ex6_3;

import java.util.Scanner;


public class DisplayTriagle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter height of triagle: ");
        try {
            int heigth = sc.nextInt();

            for (int i = 0; i < heigth; i++) {
                for (int j = i; j < heigth; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * i + 1; j++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }
        }catch (Exception e) {
            System.out.println("Height of triagle  is not number can't print");
        }
        sc.close();
    }
}
