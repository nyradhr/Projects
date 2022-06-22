package it.accenture.javaFundamentals.interfaces;

import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;

public class Developer implements Person {

    @Override
    public void speak() {

    }

    @Override
    public void eat() {

    }

    //use iterable if you don't need to add or remove items
    public Iterable<Developer> recruit() {
        ArrayList<Developer> x = new ArrayList<>();
        Developer d1 = new Developer();
        Developer d2 = new Developer();
        x.add(d1);
        x.add(d2);
        return x;
    }
}
