public class ArrayProblems {

    public static void reverseArray(int[] arr) {
        // TODO: reverse in place, O(1) extra space, two-pointer swap
    }

    public static int findSecondLargest(int[] arr) {
        // TODO: single pass, track largest and secondLargest as you go
        return -1;
    }

    public static boolean isPalindrome(String s) {
        // TODO: ignore case + non-alphanumeric, then check symmetry
        return false;
    }

    public static void moveZeroesToEnd(int[] arr) {
        // TODO: in place, keep relative order of non-zero elements
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2, 3};
        reverseArray(a);
        System.out.println("Reversed: " + java.util.Arrays.toString(a));

        System.out.println("2nd largest of {5,1,4,2,3}: " + findSecondLargest(new int[]{5, 1, 4, 2, 3}));

        System.out.println("isPalindrome(\"A man a plan a canal Panama\"): "
                + isPalindrome("A man a plan a canal Panama"));

        int[] z = {0, 1, 0, 3, 12};
        moveZeroesToEnd(z);
        System.out.println("Zeroes moved: " + java.util.Arrays.toString(z));
    }
}
