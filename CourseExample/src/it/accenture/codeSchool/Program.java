package it.accenture.codeSchool;

import it.accenture.codeSchool.hr.Instructor;
import it.accenture.codeSchool.hr.TechnicalInstructor;
import it.accenture.codeSchool.learningMaterial.Course;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args){
        //Instructor is = new Instructor();
        //System.out.println(is.course.getTitle());

        int x = 5;
        int[] myNums = new int[10];
        //System.out.println(myNums[9]);
        for(int i=0; i<myNums.length; i++){
            //cast forzato ad int, pow restituisce double
            myNums[i] = (int) Math.pow(2, i);
        }
        for(int i=0; i<myNums.length; i++){
            //cast forzato ad int, pow restituisce double
            System.out.println(myNums[i]);
        }

        int sum = 0;
        for(int i = 0; i < myNums.length; i++){
            if(myNums[i] > 100) {
                sum += myNums[i];
            } else if(10 < myNums[i] && myNums[i] <= 100){
                sum += myNums[i] * 2;
            } else{
                sum += myNums[i] * 4;
            }
        }
        System.out.println("Sum of all numbers in the array that are bigger than 100: " + sum);

        System.out.println(findMax(myNums));
        int x1 = 0;
        int x2 = 1;
        System.out.println("x1 = "+x1+", x2 = "+x2);
        swap(x1, x2);
        System.out.println("Swapped! x1 = "+x1+", x2 = "+x2);

        Instructor i1 = new Instructor("Ciccio");
        Instructor i2 = new Instructor("Pippo");
        System.out.println("i1 = "+i1+" , i2 = "+i2);
        swap(i1, i2);
        System.out.println("i1 = "+i1+" , i2 = "+i2);
        String s1 = "Ciccio";
        String s2 = "Ciccio";
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);

        //System.out.println(i1.course);
        //null pointer exception
        //System.out.println(i1.course.title);
        i1.setCourse(new Course("IntermediateJava", 250));
        System.out.println(i1.getCourseTitle());


    }


    public boolean screenInstructor(Instructor i) {
        /*
        //boxing and unboxing

        boolean x = true;
        Boolean y = x; //boxing
        boolean z = y; //unboxing
        List<Boolean> boolList = new ArrayList<Boolean>();
        for(int i = 0; i < 100000; i++) {
            boolList.add(true); //"invisible" boxing
        }
        */
        /*
        //bad practice: using elif/switch instead of polymorphism

        boolean isSenior = false;
        if(i.getClass() == Instructor.class){
            isSenior = i.isSeniorInstructor();
        } else if (i.getClass() == TechnicalInstructor.class) {
            TechnicalInstructor ti = (TechnicalInstructor) i;
            isSenior = ti.isSeniorInstructor();
        }
        */
        
        /*
        //example of switch

        String s1 = "ciccio";
        switch(s1){
            case "pippo":
                System.out.println("franco");
                break;
            case "alberto":
                System.out.println("angela");
                break;
            default:
                System.out.println("unknown");
        }
         */
        if(i.isSeniorInstructor()) { //evaluated at runtime, dynamic binding
            return true;
        }
        return false;
    }


    public static int findMax(int[] nums) {

        if(nums.length == 0){
            return -1;
        }
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }

    // non va a modificare i valori che gli passi nel main
    // pass by value vs pass by reference
    public static void swap(int x1, int x2) {
        int temp = x1;
        x1 = x2;
        x2 = temp;
    }

    public static void swap(Instructor i1, Instructor i2) {
        Instructor temp = i1;
        i1 = i2;
        i2 = temp;
    }
}
