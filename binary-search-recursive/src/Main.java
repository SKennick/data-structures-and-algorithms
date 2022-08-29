import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {5, 99, -62, -505, 37, 204, 987, 72, 808, 210};
        Arrays.sort(array);
        // Search for element in array.
        System.out.println(binarySearchRecursive(array, 0, array.length-1, 808));
        System.out.println(array[binarySearchRecursive(array, 0, array.length-1, 808)]);
        // Search for element in array.
        System.out.println(binarySearchRecursive(array, 0, array.length-1, -505));
        System.out.println(array[binarySearchRecursive(array, 0, array.length-1, -505)]);
        // Search for elements not in array.
        System.out.println(binarySearchRecursive(array, 0, array.length-1, -2));
        // Search for elements not in array.
        System.out.println(binarySearchRecursive(array, 0, array.length-1, 1000));
    }

    public static int binarySearchRecursive(int[] array, int startIndex, int endIndex, int element) {
        if (startIndex >= endIndex) {
            return -1;
        }

        int middleIndex = (startIndex + endIndex) / 2;
        if (array[middleIndex] == element) {
            return middleIndex;
        }
        if (array[middleIndex] > element) {
            return binarySearchRecursive(array, startIndex, middleIndex, element);
        } else {
            return binarySearchRecursive(array, middleIndex+1, endIndex, element);
        }
    }

}
