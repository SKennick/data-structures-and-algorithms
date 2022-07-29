package com.kennick;

public class Main {

    public static void main(String[] args) {
        String[] stringArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb" };

        radixSort(stringArray, 5, 26);

        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }
    }

    private static void radixSort(String[] array, int length, int radix) {
        for (int x = length-1; x >= 0; x--) {
            sort(array, x, radix);
        }
    }

    private static void sort(String[] array, int position, int radix) {
        int[] countArray = new int[radix];
        int numItems = array.length;

        for (int x = 0; x < array.length; x++) {
            countArray[getDigit(array[x], position)]++;
        }

        for (int y = 1; y < countArray.length; y++) {
            countArray[y] = countArray[y] + countArray[y-1];
        }

        String[] tempArray = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            tempArray[--countArray[getDigit(array[tempIndex], position)]] =
                    array[tempIndex];
        }

        System.arraycopy(tempArray, 0, array, 0, tempArray.length);
    }

    private static int getDigit(String c, int position) {
        return c.charAt(position) - 'a';
    }
}
