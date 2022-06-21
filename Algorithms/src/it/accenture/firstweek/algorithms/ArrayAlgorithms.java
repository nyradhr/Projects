package it.accenture.firstweek.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ArrayAlgorithms {
    public static void main(String[] args) {
        double[] array = new double[100];

        for(int i=0; i<array.length; i++) {
            array[i] = (int) (Math.random()*10);
        }

        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }

        int instances = findInstances(64,array);
        //System.out.println(instances);

        double result = betterFindMode(array);
        System.out.println(result);

        double mode = findMode(array);
        System.out.println(mode);

    }

    public double findMin(double[] array) {
        double min = array[0];
        for(int i = 1; i < array.length; i++){
            if(min > array[i]){
                min = array[i];
            }
        }
        return min;
    }

    public static int findInstances(double target, double array[]) {
        int count=0;

        for(int i = 0; i < array.length; i++) {
            if(array[i]==target){
                count++;
            }
        }
        return count;

    }

    public static double findMode(double[] array) {
        int modeInstances = findInstances(array[0], array);
        double mode = array[0];
        for(int i = 1; i < array.length; i++) {
            int instances = findInstances(array[i], array);
            if(modeInstances < instances){
                mode = array[i];
                modeInstances = instances;
            }
        }
        return mode;
    }

    public static double betterFindMode(double[] array) {
        HashMap<Double, Integer> m = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            /*if (m.containsKey(array[i])){
                m.put(array[i], m.get(array[i])+1);
            } else {
                m.put(array[i], 1);
            }*/
            Integer n = m.get(array[i]);
            if(n==null){
                n=0;
            }
            n++;
            m.put(array[i],n);
        }
        double[] numbers = new double[5];
        for(double d : numbers){
            System.out.println(d);
        }
        ArrayList<Double> numbers2 = new ArrayList<Double>();
        for (double d: numbers2){
            System.out.println(d);
        }
        for(Iterator<Double> it = numbers2.iterator(); it.hasNext(); ){
            Double d = it.next();
            System.out.println(d);
        }
        System.out.println("Stampiamo le chiavi della mappa: ");
        for(double key: m.keySet()){
            System.out.println(key);
        }
        System.out.println("Stampiamo i valori della mappa: ");
        for(Integer occurrence: m.values()){
            System.out.println(occurrence);
        }

        System.out.println("Stampiamo le coppie chiave-valore della mappa: ");
        //var z = 3;
        for(Map.Entry<Double, Integer> kv: m.entrySet()){
            System.out.printf("Chiave %f valore %d %n", kv.getKey(), kv.getValue());
        }

        Iterator<Map.Entry<Double,Integer>> it = m.entrySet().iterator();
        Map.Entry<Double, Integer> modeEntry = it.next();
        while(it.hasNext()){
            var entry = it.next();
            if(entry.getValue() > modeEntry.getValue()){
                modeEntry = entry;
            }
        }
        return modeEntry.getKey();
    }
}
