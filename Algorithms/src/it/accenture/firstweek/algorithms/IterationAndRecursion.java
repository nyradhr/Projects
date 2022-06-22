package it.accenture.firstweek.algorithms;

public class IterationAndRecursion {

    public static long factorial(int n) {
        long fact = n;
        for(int i = n-1; i >= 1; i--) {
           fact *= i;
        }
        return fact;
    }

    public static long recFactorial(int n) {
        if (n==1){
            return 1;
        }
        return n*recFactorial(n-1);
    }

    public static void main(String[] args) {
        long f1 = factorial(10);
        System.out.println("10! = "+f1);
        long f2 = recFactorial(10);
        System.out.println("10! = "+f2);
    }
}
