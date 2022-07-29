package com.kennick;

public class Main {

    public static void main(String[] args) {
	    int[] array = {5, 99, -62, -505, 37, 204, 987, 72, 808, 210};
        bubbleSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void bubbleSort(int[] arrayToSort) {
        for (int lastUnsortedIndex = arrayToSort.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                int next = i+1;
                if (arrayToSort[i] > arrayToSort[next]) {
                    int swap = arrayToSort[next];
                    arrayToSort[next] = arrayToSort[i];
                    arrayToSort[i] = swap;
                }
            }
        }
    }
}
