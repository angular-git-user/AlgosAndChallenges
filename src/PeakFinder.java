
/*
Complexity - O(logN)
*/
public class PeakFinder {

    public static int oneDimPeakFinder(int[] array, int low, int high) {

        int mid = (low + high) / 2;

        if (low <= high) {

            if ((mid - 1 >= low && mid + 1 <= high) && (array[mid - 1] <= array[mid] && array[mid + 1] <= array[mid])) {
                return array[mid];
            } else if ((mid - 1 >= low) && (array[mid - 1] > array[mid])) {
                return oneDimPeakFinder(array, low, mid - 1);
            } else if ((mid + 1 <= high) && (array[mid + 1] > array[mid])) {
                return oneDimPeakFinder(array, mid + 1, high);
            } else {
                return array[mid];
            }
        }
        return 0;
    }

    public static void main(String args[]) {

        int array[] = { 3, 5, 12, 8, 10, 21, 4 };
        System.out.println(oneDimPeakFinder(array, 0, array.length - 1));
    }
}