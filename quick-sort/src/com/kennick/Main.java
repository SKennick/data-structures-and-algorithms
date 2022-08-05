package com.kennick;

public class Main {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 35, 1, -22, -50, 99, 72, 38};

        quickSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void quickSort(int[] array, int start, int end) {
        if (end-start < 2) {
            return;
        }

        int partitionIndex = partition(array, start, end);
        quickSort(array, start, partitionIndex);
        quickSort(array, partitionIndex+1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int pivot = array[start];

        while (i < j) {
            while(i<j && array[--j] >= pivot);
            if (i<j) {
                array[i] = array[j];
            }

            while(i<j && array[++i] <= pivot);
            if (i<j) {
                array[j] = array[i];
            }
        }

        array[j] = pivot;
        return j;
    }

}
