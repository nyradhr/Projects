package it.accenture.codeSchool;

public class FizzBuzz {
    public static void doFizzBuzz(int n) {
        //print all numbers from 0 to N
        //if the number is multiple of 3 print fizz
        //if the number is multiple of 5 print buzz
        //if it's multiple of both print fizzbuzz
        //else print the number

        for(int i = 0; i < n; i++) {
            if(i%3 == 0 && i%5 == 0) {
                System.out.println("FizzBuzz");
            } else if(i%3 == 0) {
                System.out.println("Fizz");
            } else if(i%5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        doFizzBuzz(100);

    }
}
