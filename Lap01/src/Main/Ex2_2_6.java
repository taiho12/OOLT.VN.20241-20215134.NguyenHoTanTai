package Main;

import java.util.Scanner;

public class Ex2_2_6 {
    private static void firstDegreeEquation(double a, double b){
        if(b==0) System.out.println("x = 0");
        else if(a==0 && b==0) System.out.println("Wealth of counter");
        else if(a==0 && b!=0) System.out.println("No solution");
        else System.out.println("x = "+ -b/a);
    }

    public static void main(String[] args) {
        System.out.println("Nguyen Ho Tan Tai 20215134");
        try (Scanner sc = new Scanner(System.in)) {
            try {
                System.out.println("The first-degree equation (linear equation) with one variable");
                System.out.print("Enter figure of equation : ");
                double a = Double.parseDouble(sc.next());
                double b = Double.parseDouble(sc.next());
                System.out.println("Experiment of "+a+"*x + "+b+" = 0 is:");
                firstDegreeEquation(a,b);
                System.out.println("The system of first-degree equations (linear system) with two variables");
                System.out.print("Enter figure of equation : ");
                double a11 = Double.parseDouble(sc.next());
                double a12 = Double.parseDouble(sc.next());
                double b1 = Double.parseDouble(sc.next());
                double a21 = Double.parseDouble(sc.next());
                double a22 = Double.parseDouble(sc.next());
                double b2 = Double.parseDouble(sc.next());
                double D = a11*a22 - a12*a21;
                double Dx = b1*a22 - b2*a12;
                double Dy = a11*b2 - a21*b1;
                System.out.println("Experiment of \n"+a11+"*x1 + "+a12+"*x2 = "+b1+"\n"+a21+"*x1 + "+a22+"*x2 = "+b2+"\nIs:");
                if(D!=0) System.out.println("x1 = "+Dx/D+"; x2 = "+Dy/D);
                else if(D==0 && (Dx ==0 || Dy == 0)) System.out.println("No solution");
                else System.out.println("Wealth of counter");
                System.out.println("The second-degree equation with one variable");
                a = Double.parseDouble(sc.next());
                b = Double.parseDouble(sc.next());
                double c = Double.parseDouble(sc.next());
                double delta = Math.pow(b,2)-4*a*c;
                System.out.println("Experiment of \n"+a+"*x^2 + "+b+"*x + "+c+" = 0 is:");
                if(a==0) firstDegreeEquation(b,c);
                else {
                    if(delta < 0) System.out.println("No solution");
                    else if(delta == 0) System.out.println("x1 = x2 = "+ -b/2*a);
                    else System.out.println("x1 = "+(-b+Math.sqrt(delta))/2*a+"\n x2 = "+(-b-Math.sqrt(delta))/2*a);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
