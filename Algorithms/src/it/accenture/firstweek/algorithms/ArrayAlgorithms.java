package it.accenture.firstweek.algorithms;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class ArrayAlgorithms {
    public static void main(String[] args) {
        double[] array = new double[100];

        for(int i=0; i<array.length; i++) {
            array[i] = (int) (Math.random()*10);
        }

        /*
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }

         */

        //int instances = findInstances(64,array);
        //System.out.println(instances);

        double result = betterFindMode(array);
        System.out.println("Mode = "+result);

        //double mode = findMode(array);
        //System.out.println(mode);

        Arrays.sort(array); //otherwise the binary search won't work
        boolean targetFound = binarySearch(6.0, array);
        System.out.println("6.0 in array = "+ targetFound);
        targetFound = binarySearch(23.0, array);
        System.out.println("23.0 in array = "+ targetFound);

        System.out.println("odd numbered length array2");
        double[] array2 = new double[7];
        for(int i=0; i<array2.length; i++) {
            array2[i] = (int) (Math.random()*10);
        }
        Arrays.sort(array2); //otherwise the binary search won't work
        /*
        for(int i=0; i<array2.length; i++) {
            System.out.println(array2[i]);
        }

         */
        targetFound = binarySearch(3.0, array2);
        System.out.println("3.0 in array2 = "+ targetFound);


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

    public static int findInstances(double target, double[] array) {
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

        //non mi ricordo questa porzione di codice a che serve
        //riguardare registrazione giorno 21/06
        //forse solo esempi per spiegare for each e iterator?
        //da qui
        /*
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
        */
        //fino a qua

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

    //array has to be sorted (and not null)!!!
    public static boolean binarySearch(double target, double[] array) {
        int start = 0;
        int end = array.length;
        //System.out.println("debug: "+end);
        while (start < end) {
            //int pos = (start+end)/2;
            int pos = start + (end-start)/2;
            //System.out.println("debug2: "+pos);
            if(array[pos] == target){
                //System.out.println("in here! true!");
                return true;
            }
            if(target > array[pos]) {
                //System.out.println("array[pos]= "+array[pos]);
                //System.out.println("go right");
                start = pos+1;
            } else {
                //System.out.println("array[pos]= "+array[pos]);
                //System.out.println("go left");
                end = pos-1;
            }
        }
        return false;
    }
}
