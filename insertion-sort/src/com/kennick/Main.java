package com.kennick;

public class Main {

    public static void main(String[] args) {
	    int[] array = {-12, 24, 3, -5, 17, 10, -9, 8};

        /*
         * This can be cleaned up with an inner for loop that better handles the conditions.
         */
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int element = array[firstUnsortedIndex];
            for (int x = firstUnsortedIndex; x >= 0; x--) {
                if (x == 0) {
                    // If we have hit 0, we know we have the smallest element.
                    array[x] = element;
                } else if (array[x-1] <= element) {
                    // We have found the proper spot. Assign and break out of loop.
                    array[x] = element;
                    break;
                } else {
                    // Shift and continue.
                    array[x] = array[x-1];
                }
            }
        }

        for (int x : array) {
            System.out.println(x);
        }
    }
}
