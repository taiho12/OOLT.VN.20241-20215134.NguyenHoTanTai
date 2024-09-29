package Ex6_6;

import java.util.Scanner;

public class Ex6_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of matrix: ");
        int size = sc.nextInt();
        int[][] firstMatrix = new int[size][size];
        int[][] secondMatrix = new int[size][size];
        int[][] newMatrix = new int[size][size];

        System.out.println("Enter the element of first matrix:");
        for(int i=0; i<size; i++){
            for (int j=0; j<size; j++) firstMatrix[i][j] = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Enter the element of second matrix:");
        for(int i=0; i<size; i++){
            for (int j=0; j<size; j++) {
                secondMatrix[i][j] = sc.nextInt();
                newMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
            sc.nextLine();
        }

        System.out.println("The sum of two matrix is:");
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++) System.out.print(newMatrix[i][j]+" ");
            System.out.println();
        }
        sc.close();
    }
}
