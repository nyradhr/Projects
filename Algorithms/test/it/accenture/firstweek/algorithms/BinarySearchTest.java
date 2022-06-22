package it.accenture.firstweek.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

public class BinarySearchTest {

    double[] a1 = {2.0, 4.0, 5.0, 7.0, 10.0};

    @Test
    public void binarySearch_returns_position_when_target_present() {
        double target = 7.0;
        int pos = ArrayAlgorithms.binarySearch(target,a1);
        Assertions.assertEquals(3, pos);
    }

    @Test
    public void binarySearch_returns_minus_1_when_target_outside_right_range() {
        double target = 15.0;
        int pos = ArrayAlgorithms.binarySearch(target, a1);
        Assertions.assertEquals(-1, pos);
    }

    @Test
    public void binarySearch_returns_minus_1_when_target_outside_left_range(){
        double target = 1.0;
        int pos = ArrayAlgorithms.binarySearch(target, a1);
        Assertions.assertEquals(-1, pos);
    }

    @Test
    public void binarySearch_returns_minus_1_when_target_in_range_but_not_found() {
        double target = 6.0;
        int pos = ArrayAlgorithms.binarySearch(target,a1);
        Assertions.assertEquals(-1, pos);
    }

    @Test //fans condition first num
    public void binarySearchTest_returns_position_for_first_element() {
        double target = 2.0;
        int pos = ArrayAlgorithms.binarySearch(target, a1);
        Assertions.assertEquals(0, pos);
    }

    @Test //fans condition first num
    public void binarySearchTest_returns_position_for_last_element() {
        double target = 10.0;
        int pos = ArrayAlgorithms.binarySearch(target, a1);
        Assertions.assertEquals(4, pos);
    }

}
