package com.kennick;

public class Main {

    public static void main(String[] args) {

        int[] array = {70, 20, 4, -50, -99, 23, 82, 78};

        // keep reducing the gap length in half. Start at half-length of array.
        for (int gap = array.length/2; gap > 0; gap /= 2) {

            for (int startingElement = gap; startingElement < array.length; startingElement++) {
                int element = array[startingElement];

                while (startingElement >= gap && element <= array[startingElement-gap]) {
                    array[startingElement] = array[startingElement-gap];
                    startingElement -= gap;
                }
                array[startingElement] = element;
            }

        }

        for(int i : array) {
            System.out.println(i);
        }
    }
}
