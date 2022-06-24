package it.accenture.firstweek.algorithms;

import org.junit.jupiter.api.*;

public class BinarySearchTest {

    double[] a1 = {2.0, 4.0, 5.0, 7.0, 10.0};

    @Test
    public void binarySearch_returns_position_when_target_present() {
        System.out.println("binarySearch_returns_position_when_target_present");
        double target = 7.0;
        int pos = ArrayAlgorithms.binarySearch(target,a1);
        Assertions.assertEquals(3, pos);
    }

    @Test
    public void binarySearch_returns_minus_1_when_target_outside_right_range() {
        System.out.println("binarySearch_returns_minus_1_when_target_outside_right_range");
        double target = 15.0;
        int pos = ArrayAlgorithms.binarySearch(target, a1);
        Assertions.assertEquals(-1, pos);
    }

    @Test
    public void binarySearch_returns_minus_1_when_target_outside_left_range(){
        System.out.println("binarySearch_returns_minus_1_when_target_outside_left_range");
        double target = 1.0;
        int pos = ArrayAlgorithms.binarySearch(target, a1);
        Assertions.assertEquals(-1, pos);
    }

    @Test
    public void binarySearch_returns_minus_1_when_target_in_range_but_not_found() {
        System.out.println("binarySearch_returns_minus_1_when_target_in_range_but_not_found");
        double target = 6.0;
        int pos = ArrayAlgorithms.binarySearch(target,a1);
        Assertions.assertEquals(-1, pos);
    }

    @Test
    public void binarySearchTest_returns_position_for_first_element() {
        System.out.println("binarySearchTest_returns_position_for_first_element");
        double target = 2.0;
        int pos = ArrayAlgorithms.binarySearch(target, a1);
        Assertions.assertEquals(0, pos);
    }

    @Test
    public void binarySearchTest_returns_position_for_last_element() {
        System.out.println("binarySearch_returns_position_for_last_element");
        double target = 10.0;
        int pos = ArrayAlgorithms.binarySearch(target, a1);
        Assertions.assertEquals(4, pos);
    }

    //test for rec
    //aggiustare e provare di nuovo i test
    //devi cambiare l'ordine dei parametri e i nomi dei metodi (e le stampe interne)

    @Test
    public void recBinarySearch_returns_position_when_target_present() {
        System.out.println("recBinarySearch_returns_position_when_target_present");
        double target = 7.0;
        int pos = ArrayAlgorithms.recBinarySearch(a1,target);
        Assertions.assertEquals(3, pos);
    }

    @Test
    public void recBinarySearch_returns_minus_1_when_target_outside_right_range() {
        System.out.println("recBinarySearch_returns_minus_1_when_target_outside_right_range");
        double target = 15.0;
        int pos = ArrayAlgorithms.recBinarySearch(a1, target);
        Assertions.assertEquals(-1, pos);
    }

    @Test
    public void recBinarySearch_returns_minus_1_when_target_outside_left_range(){
        System.out.println("recBinarySearch_returns_minus_1_when_target_outside_left_range");
        double target = 1.0;
        int pos = ArrayAlgorithms.recBinarySearch(a1, target);
        Assertions.assertEquals(-1, pos);
    }

    @Test
    public void recBinarySearch_returns_minus_1_when_target_in_range_but_not_found() {
        System.out.println("recBinarySearch_returns_minus_1_when_target_in_range_but_not_found");
        double target = 6.0;
        int pos = ArrayAlgorithms.recBinarySearch(a1,target);
        Assertions.assertEquals(-1, pos);
    }

    @Test
    public void recBinarySearch_returns_position_for_first_element() {
        System.out.println("recBinarySearch_returns_position_for_first_element");
        double target = 2.0;
        int pos = ArrayAlgorithms.recBinarySearch(a1, target);
        Assertions.assertEquals(0, pos);
    }

    @Test
    public void recBinarySearch_returns_position_for_last_element() {
        System.out.println("recBinarySearch_returns_position_for_last_element");
        double target = 10.0;
        int pos = ArrayAlgorithms.recBinarySearch(a1, target);
        Assertions.assertEquals(4, pos);
    }



    @BeforeAll
    public static void initClass() {
        System.out.println("initClass");
    }

    @AfterAll //possible usage: tear down
    public static void endClass() {
        System.out.println("endClass");
    }

    @BeforeEach
    public void startTest() {
        System.out.println("startTest");
    }

    @AfterEach
    public void endTest() {
        System.out.println("endTest");
    }

}
