package com.kennick;

public class Main {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 35, 1, -22, -50, 99, 72, 38};

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
        recursiveInsertionSort(intArray, intArray.length-1);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void radixSortNew(int[] array, int length, int radix) {
        for (int x = 0; x < length; x++) {
            radix(array, x, radix);
        }
    }

    private static void radix(int[] array, int position, int radix) {

    }

    private static int getDigit(int number, int position, int radix) {

    }

    private static void quickSort2(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int partitionIndex = partition2(array, start, end);
        quickSort2(array, start, partitionIndex);
        quickSort2(array, partitionIndex + 1, end);
    }

    private static int partition2(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int pivot = array[start];

        while (i < j) {
            while(i < j && array[--j] >= pivot);
            if (i < j) {
                array[i] = array[j];
            }

            while(i < j && array[++i] <= pivot);
            if (i < j) {
                array[j] = array[i];
            }
        }
        array[j] = pivot;
        return j;
    }

    private static void countingSort(int[] array, int min, int max) {
        int[] countingArray = new int[(max-min) + 1];

        for (int x = 0; x < array.length; x++) {
            countingArray[array[x]-min]++;
        }

        int insertionIndex = 0;
        for (int y = min; y <= max; y++) {
            while (countingArray[y-min] > 0) {
                array[insertionIndex] = y;
                countingArray[y-min]--;
                insertionIndex++;
            }
        }
    }

//    public static void main(String[] args) {
//
//        int[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };
//
//        radixSort(radixArray, 10, 4);
//
//        for (int i = 0; i < radixArray.length; i++) {
//            System.out.println(radixArray[i]);
//        }
//    }

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
        System.out.println("Math.pow value = " + Math.pow(radix, position));
        System.out.println("Value / Math.pow = " + value / (int) Math.pow(radix, position));
        int digit = value / (int) Math.pow(radix, position) % radix;
        System.out.println("Digit = " + digit);
        return digit;
    }

    private static void quickSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int partitionIndex = partition(array, start, end);
        quickSort(array, start, partitionIndex);
        quickSort(array, partitionIndex+1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivotNumber = array[start];
        int i = start; // pointer for left side
        int j = end; // pointer for right side

        //Continue until the pointers overlap.
        while (i < j) {

            while (i<j && array[--j] >= pivotNumber);
            if (i < j) {
                array[i] = array[j];
            }


            while (i < j && array[++i] <= pivotNumber);
            if (i < j) {
                array[j] = array[i];
            }
        }
        array[j] = pivotNumber;
        return j;
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (end-start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] tempArray = new int[end - start];

        while (i < mid && j < end) {
            tempArray[tempIndex++] = array[i] >= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start+tempIndex, mid-i);
        System.arraycopy(tempArray, 0, array, start, tempIndex);
    }
    //        int[] intArray = { 20, 35, -15, 7, 35, 1, -22, -50, 99, 72, 38};
    private static void shellSort(int[] array) {
        for (int gap = array.length/2; gap > 0; gap /= 2) {
            for (int startingElement = gap; startingElement < array.length; startingElement++) {
                int element = array[startingElement];
                int j = startingElement;
                while (j >= gap && element <= array[j-gap]) {
                    array[j] = array[j-gap];
                    j -= gap;
                }
                array[j] = element;
            }
        }
    }

    private static void recursiveInsertionSort(int[] array, int index) {
        if (index == 1) {
            return;
        }

        recursiveInsertionSort(array, --index);
        int unsortedElement = array[index];
        int insertionIndex = index;
        while (insertionIndex > 0 && array[insertionIndex-1] >= unsortedElement) {
            array[insertionIndex] = array[insertionIndex-1];
            insertionIndex--;
        }
        array[insertionIndex] = unsortedElement;
    }

    private static void insertionSort(int[] array) {
        for (int firstUnsorted = 1; firstUnsorted < array.length; firstUnsorted++) {
            int unsortedElement = array[firstUnsorted];
            int insertionIndex = firstUnsorted;
            while (insertionIndex > 0 && array[insertionIndex-1] >= unsortedElement) {
                array[insertionIndex] = array[insertionIndex-1];
                insertionIndex--;
            }
            array[insertionIndex] = unsortedElement;
        }
    }

    private static void selectionSort(int[] array) {
        for (int unsortedPartition = array.length - 1; unsortedPartition > 0; unsortedPartition--) {
            int greatestIndex = 0;
            for (int x = 1; x <= unsortedPartition; x++) {
                if (array[x] >= array[greatestIndex]) {
                    greatestIndex = x;
                }
            }
            swap(array, unsortedPartition, greatestIndex);
        }
    }

    private static void bubbleSort(int[] array) {
        for (int l = array.length-1; l > 0; l--) {
            for (int j = 0; j < l; j++) {
                if (array[j+1] <= array[j]) {
                    swap(array, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] array, int a, int b) {
        if (a == b) {
            return;
        }

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
