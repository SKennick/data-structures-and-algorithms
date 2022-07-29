package com.kennick;

public class Main {

    public static void main(String[] args) {
        int[] intArray = { 2, 5, 9, 8, 2, 7, 10, 8, 3, 5};

        int min = -1;
        int max = -1;
        for (int x : intArray) {
            if (min == -1 || x < min) {
                min = x;
            }
            if (max == -1 || x > max) {
                max = x;
            }
        }
        countingSort(intArray, min, max);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void countingSort(int[] array, int min, int max) {
        int[] tempArray = new int[(max - min) + 1];

        for (int x = 0; x < array.length; x++) {
            tempArray[array[x]-min]++;
        }

        int arrayIndex = 0;
        for (int y = min; y <= max; y++) {
            while(tempArray[y-min] > 0) {
                array[arrayIndex] = y;
                tempArray[y-min]--;
                arrayIndex++;
            }
        }
    }
}
