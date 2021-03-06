import java.util.Arrays;

public class Insertion {

	public static int[] rec(int[] array, int i) {

		if (i < array.length) {

			int val = array[i];
			int j;
			for (j = i - 1; j >= 0; j--) {

				if (val < array[j]) {

					array[j + 1] = array[j];

				} else {
					break;
				}
			}
			array[j + 1] = val;
			return rec(array, i + 1);
		}
		return array;
	}

	/**
	 * Complexity - O(N^2)
	 */
	public static void insertionSort(int[] array) {

		for (int i = 1; i < array.length; i++) {

			int val = array[i];
			int j;
			for (j = i - 1; j >= 0; j--) {

				if (array[j] > val) {

					array[j + 1] = array[j];
				} else {
					break;
				}
			}
			array[j + 1] = val;
		}
		System.out.println(Arrays.toString(array));
	}

	public static void main(String args[]) {
		// insertion(new int[] { 4, 2, 1, 3 });
		int array[] = { 10, 45, 3, 7, 21, 99, 34, 76, 0, 22, 11 };
		insertionSort(array);
		// System.out.println(Arrays.toString(rec(new int[] { 7, 10, 5, 8, 2, 90, 3 },
		// 1)));
	}
}
