package it.accenture.firstweek.algorithms;

public class Circle {

    //explanation of static keyword, example of wrong usage
    private static double radius = 10.0;

    public static double getPerimeter() {
        return radius*2*Math.PI;
    }

    public static void main(String[] args) {
        radius = 100;
        double p = getPerimeter();
    }
}
