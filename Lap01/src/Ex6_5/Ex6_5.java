package Ex6_5;

import java.util.Arrays;
import java.util.Scanner;

public class Ex6_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter element of array: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int sum = Arrays.stream(arr).reduce(0,(accumulator, element) -> accumulator + element );
        Arrays.sort(arr);
        System.out.println("Array after soft is: "+Arrays.toString(arr));
        System.out.println("Sum of array is: "+sum);
        System.out.println("Average of array is: "+(double) sum/arr.length);
        sc.close();
    }
}
