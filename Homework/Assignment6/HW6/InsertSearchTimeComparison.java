package HW6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author SHAO
 */
public class InsertSearchTimeComparison {
    public static void main(String[] args) {

        // Declare HashMap, ArrayList, LinkedList
        HashMap<Integer, Integer> myMap = new HashMap<>();
        ArrayList<Integer> myArrayList = new ArrayList<>();
        LinkedList myLinkedList = new LinkedList();

        //Declare start, end, elapsed time; total insert/search time
        long startTime, endTime, elapsedTime;
        long mapInsertTime = 0, arrayListInsertTime = 0, linkedListInsertTime = 0;
        long mapSearchTime = 0, arrayListSearchTime = 0, linkedListSearchTime = 0;

        // keys array
        Integer[] keys = new Integer[100000];

        Random random = new Random();

        // loop for 10 times
        for (int i = 0; i < 10; i++) {
            myMap.clear();
            myArrayList.clear();
            myLinkedList.clear();
            
            random.setSeed(System.currentTimeMillis());

            // Generate 100000 numbers
            for (int j = 0; j < 100000; j++) {
                Integer number = random.nextInt(1000000) + 1;
                keys[j] = number;
            }

            // HashMap insertion
            startTime = System.currentTimeMillis();
            for (int j = 0; j < 100000; j++) {
                myMap.put(keys[j], j);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            mapInsertTime += elapsedTime;

            // ArrayList insertion
            startTime = System.currentTimeMillis();
            for (int j = 0; j < 100000; j++) {
                myArrayList.add(keys[j]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            arrayListInsertTime += elapsedTime;

            // LinkedList insertion
            startTime = System.currentTimeMillis();
            for (int j = 0; j < 100000; j++) {
                myLinkedList.add(keys[j]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            linkedListInsertTime += elapsedTime;
        }

        // loop for 10 times
        for (int i = 0; i < 10; i++) {

            random.setSeed(System.currentTimeMillis());
            
            // Generate 100000 random number
            for (int j = 0; j < 100000; j++) {
                Integer number = random.nextInt(2000000) + 1;
                keys[j] = number;
            }

            // HashMap search
            startTime = System.currentTimeMillis();
            for (int j = 0; j < 100000; j++) {
                myMap.containsKey(keys[j]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            mapSearchTime += elapsedTime;

            // ArrayList search
            startTime = System.currentTimeMillis();
            for (int j = 0; j < 100000; j++) {
                myArrayList.contains(keys[j]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            arrayListSearchTime += elapsedTime;

            // LinkedList search
            startTime = System.currentTimeMillis();
            for (int j = 0; j < 100000; j++) {
                myLinkedList.contains(keys[j]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            linkedListSearchTime += elapsedTime;
        }

        // Output print
        System.out.println("Number of keys = " + keys.length + "\n");

        System.out.println("HashMap average total insert time = " + (mapInsertTime / 10));
        System.out.println("ArrayList average total insert time = " + (arrayListInsertTime / 10));
        System.out.println("LinkedList average total insert time = " + (linkedListInsertTime / 10));

        System.out.println("\nHashMap average total search time = " + (mapSearchTime / 10));
        System.out.println("ArrayList average total search time = " + (arrayListSearchTime / 10));
        System.out.println("LinkedList average total search time = " + (linkedListSearchTime / 10));
    }
}
