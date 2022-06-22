package it.accenture.firstweek.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    double[] a1 = {2.0, 4.0, 5.0, 7.0, 10.0};

    @Test
    public void binarySearch_returns_position_when_target_present() {
        double target = 7.0;
        int pos = ArrayAlgorithms.binarySearch(target,a1);
        Assertions.assertEquals(3, pos);
    }

    @Test
    public void binarySearch_returns_minus_1_when_target_not_found() {
        double target = 15.0;
        int pos = ArrayAlgorithms.binarySearch(target, a1);
        Assertions.assertEquals(-1, pos);
    }

    //aggiungi questi test
    //cerca un numero fuori dal range a sinistra
    //cerca numero fuori dal range a destra
    //il numero non c'è ed è contenuto dal range
    //il resto vedilo dalla registrazione o su github oppure boh

}
