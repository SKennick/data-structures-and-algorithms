package com.kennick;

public class Main {

    public static void main(String[] args) {
        int[] intArray = { 4725, 4586, 1330, 8792, 1594, 5729 };

        //System.out.println(getDigit(4725, 1, 10));
        radixSort(intArray, 4, 10);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void radixSort(int[] array, int length, int radix) {
        for (int x = 0; x < length; x++) {
            sort(array, x, radix);
        }
    }

    private static void sort(int[] array, int position, int radix) {
        int[] countArray = new int[radix];
        int[] tempArray = new int[array.length];

        for (int x = 0; x < array.length; x++) {
            countArray[getDigit(array[x], position, radix)]++;
        }

        for (int y = 1; y < countArray.length; y++) {
            countArray[y] = countArray[y] + countArray[y-1];
        }

        for (int z = 0; z < array.length; z++) {
            tempArray[--countArray[getDigit(array[z], position, radix)]] = array[z];
        }

        System.arraycopy(tempArray, 0, array, 0, tempArray.length);
    }

    private static int getDigit(int number, int position, int radix) {
        return number / (int) Math.pow(radix, position) % radix;
    }
}
