import java.util.Arrays;

public class BubbleSort {

    public static int[] quickSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {

                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String args[]) {

        int array[] = { 10, 45, 3, 7, 21, 99, 34, 76, 0, 22, 11 };
        System.out.println(Arrays.toString(quickSort(array)));

    }
}