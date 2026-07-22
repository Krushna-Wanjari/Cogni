import java.util.Arrays;

public class SortSearchProblems {

    public static void bubbleSort(int[] arr) {
        // TODO: classic O(n^2) bubble sort, in place
    }

    public static void selectionSort(int[] arr) {
        // TODO: classic O(n^2) selection sort, in place
    }

    public static int[] mergeSort(int[] arr) {
        // TODO: divide & conquer, O(n log n). Return a new sorted array.
        return arr;
    }

    public static int binarySearch(int[] sortedArr, int target) {
        // TODO: iterative binary search, return index or -1 if not found
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 5, 6};
        bubbleSort(a);
        System.out.println("Bubble sorted: " + Arrays.toString(a));

        int[] b = {5, 2, 9, 1, 5, 6};
        selectionSort(b);
        System.out.println("Selection sorted: " + Arrays.toString(b));

        int[] c = {5, 2, 9, 1, 5, 6};
        System.out.println("Merge sorted: " + Arrays.toString(mergeSort(c)));

        int[] sorted = {1, 3, 5, 7, 9, 11};
        System.out.println("binarySearch(sorted, 7) = " + binarySearch(sorted, 7));
    }
}
