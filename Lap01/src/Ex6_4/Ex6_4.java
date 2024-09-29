package Ex6_4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex6_4 {
    private static void solution(int month, int year) {
        month += 1;
        boolean isLeapYear = (year % 4 == 0 && year % 100 !=0) || year % 400 == 0 ;
        String typeYear = "Day of month in "+((isLeapYear) ? "Leap Year is " : "Common Year is ");
        if((month!=2 && month <= 7 && month % 2 == 1) || (month > 7 && month % 2 == 0)){
            System.out.println(typeYear+"31");
        }else if(month==2){
            System.out.println(typeYear+((isLeapYear) ? "29" : "28"));
        }else {
            System.out.println(typeYear+"30");
        }
    }

    public static void main(String[] args) {

        List<String> months = Arrays.asList("january", "february", "march", "april", "may", "june",
                "july", "august", "september", "october", "november", "december");
        List<String> abbreviation = Arrays.asList("jan.", "feb.", "mar.", "apr.", "may", "june",
                "july", "aug.", "sept.", "oct.", "nov.", "dec.");
        List<String> letter = Arrays.asList("jan", "feb", "mar", "apr", "may", "june",
                "july", "aug", "sept", "oct", "nov", "dec");
        List<String> number = Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month and year: ");
        try {
            String month = sc.next().toLowerCase();
            int year = sc.nextInt();

            int index;
            if((index=months.indexOf(month))!=-1) solution(index,year);
            else if((index=abbreviation.indexOf(month))!=-1) solution(index,year);
            else if((index=letter.indexOf(month))!=-1) solution(index,year);
            else if((index=number.indexOf(month))!=-1) solution(index,year);
            else System.out.println("Month is not correct!");
        }catch (Exception e){
            System.out.println("Month or year is not correct!");
        }
        sc.close();
    }
}
