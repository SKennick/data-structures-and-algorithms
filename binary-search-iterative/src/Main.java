import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {5, 99, -62, -505, 37, 204, 987, 72, 808, 210};
        Arrays.sort(array);
        // Search for element in array.
        System.out.println(binarySearchIterative(array, 808));
        System.out.println(array[binarySearchIterative(array, 808)]);
        // Search for element in array.
        System.out.println(binarySearchIterative(array, -505));
        System.out.println(array[binarySearchIterative(array, -505)]);
        // Search for elements not in array.
        System.out.println(binarySearchIterative(array, -2));
        // Search for elements not in array.
        System.out.println(binarySearchIterative(array, 1000));
    }

    public static int binarySearchIterative(int[] array, int searchFor) {
        // I am assuming the elements are sorted beforehand
        int startIndex = 0;
        int endIndex = array.length - 1;

        while (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            if (array[middleIndex] == searchFor) {
                return middleIndex;
            }
            if (array[middleIndex] > searchFor) {
                endIndex = middleIndex;
            } else {
                startIndex = middleIndex+1;
            }
        }

        return -1;
    }

}
