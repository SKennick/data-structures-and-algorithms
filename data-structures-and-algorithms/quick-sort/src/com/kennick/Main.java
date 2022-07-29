package com.kennick;

public class Main {

    public static void main(String[] args) {
//        int[] intArray = { 20, 35, -15, 7, 35, 1, -22, -50, 99, 72, 38};
//
//        quickSort(intArray, 0, intArray.length);
//
//        for (int i = 0; i < intArray.length; i++) {
//            System.out.println(intArray[i]);
//        }
        int[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };

        radixSort(radixArray, 10, 4);

        for (int i = 0; i < radixArray.length; i++) {
            System.out.println(radixArray[i]);
        }
    }

    public static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix) {

        int numItems = input.length;
        System.out.println(numItems);
        int[] countArray = new int[radix];

        for (int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }
        // Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] =
                    input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }


    public static int getDigit(int position, int value, int radix) {
        System.out.println("Position = " + position + "; Value = " + value + "; Radix = " + radix);
        int digit = value / (int) Math.pow(radix, position) % radix;
        System.out.println((int) Math.pow(radix, position));
        System.out.println("Digit = " + digit);
        return digit;
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
