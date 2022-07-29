package com.kennick;

public class Main {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 35, 1, -22, -50, 99, 72, 38};

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void mergeSort(int[] array, int start, int end) {
        //set the return condition - begin returning if the sub-array size < 2
        if (end - start < 2) {
            return;
        }

        //split up the array by calculating the mid-point.
        int mid = (end + start) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        //Begin merging the sub-arrays together
        int i = start; // pointer for left-side iteration
        int j = mid; // pointer for right-side iteration
        int tempIndex = 0; // pointer for tempArray insertion

        //create holder array to handle sorted elements.
        int tempArray[] = new int[end-start];

        //Use two points to move the smallest elements into the temp-array.
        while (i < mid && j < end) {
            tempArray[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        /*There are scenarios where the end of the 'left array' are not sorted. This moves those elements to the
        proper spot in the original array, as they should be greater than anything in the tempArray*/
        System.arraycopy(array, i, array, start + tempIndex, mid-i);

        /*Once the remaining left side array elements are moved, copy over the tempArray elements. If anything
          was remaining in the right-side of the array, it will stay there and not get overwritten. */
        System.arraycopy(tempArray, 0, array, start, tempIndex);
    }
}
