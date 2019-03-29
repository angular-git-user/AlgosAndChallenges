
public class PeakFinder {

    /*
     * Complexity - O(logN)
     */
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

    /*
     * Complexity to find global max from unsorted list in O(N)
     */
    public static int findGlobalMax(int[][] array, int col) {
        int index = -1;
        int max = -1;

        for (int i = 0; i < array.length; i++) {

            if (array[i][col] > max) {
                max = array[i][col];
                index = i;
            }
        }
        return index;
    }

    /**
     * 
     * @param array (NxM), low index, high index
     * @Complexity - findGlobalMax - O(N) - twoDimPeakFinder - O(N logM)
     * @return peak value
     */
    public static int twoDimPeakFinder(int[][] array, int low, int high) {

        int mid = (low + high) / 2;

        if (low <= high) {
            int col = findGlobalMax(array, mid);
            // System.out.println(array[col][mid]);

            if ((mid - 1 >= low && mid + 1 <= high)
                    && (array[col][mid - 1] <= array[col][mid] && array[col][mid + 1] <= array[col][mid])) {
                return array[col][mid];
            } else if ((mid - 1 >= low) && (array[col][mid - 1] > array[col][mid])) {
                return twoDimPeakFinder(array, low, mid - 1);
            } else if ((mid + 1 <= high) && (array[col][mid + 1] > array[col][mid])) {
                return twoDimPeakFinder(array, mid + 1, high);
            } else {
                return array[col][mid];
            }
        }
        return 0;
    }

    public static void main(String args[]) {

        // int array[] = { 1, 2, 3, 4, 5, 6, 6, 6, 8 };
        // System.out.println(oneDimPeakFinder(array, 0, array.length - 1));
        int row1[] = { 5, 2, 7, 1, 8, 10 };
        int row2[] = { 7, 121, 34, 7, 0, 23 };
        int row3[] = { 9, 43, 12, 67, 89, 4 };
        int row4[] = { 77, 44, 11, 55, 91, 90 };
        int row5[] = { 35, 52, 87, 89, 66, 90 };
        int array[][] = { row1, row2, row3, row4, row5 };
        System.out.println(twoDimPeakFinder(array, 0, array[0].length - 1));
    }
}