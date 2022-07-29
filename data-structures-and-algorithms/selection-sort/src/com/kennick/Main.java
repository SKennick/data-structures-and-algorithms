package com.kennick;

public class Main {

    public static void main(String[] args) {
	    int[] array = {20, 35, -15, 7, 55, 1, -22};
        for (int lastUnsortedIndex = array.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int indexOfLargest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (array[i] > array[indexOfLargest]) {
                    indexOfLargest = i;
                }
            }
            swap(array, indexOfLargest, lastUnsortedIndex);
        }

        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void swap(int[] array, int largeIndex, int lastUnsortedIndex) {
        if (largeIndex == lastUnsortedIndex) {
            return;
        }

        int hold = array[lastUnsortedIndex];
        array[lastUnsortedIndex] = array[largeIndex];
        array[largeIndex] = hold;
    }
}
