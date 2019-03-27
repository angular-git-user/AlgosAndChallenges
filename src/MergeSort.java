import java.util.Arrays;

public class MergeSort {

	public static int[] merge(int[] array, int p, int q, int r) {

		int[] leftArray = new int[q - p + 1];
		int[] rightArray = new int[r - q];

		System.arraycopy(array, p, leftArray, 0, q - p + 1);
		System.arraycopy(array, q + 1, rightArray, 0, r - q);

		int leftCounter = 0;
		int rightCounter = 0;

		for (int i = p; i <= r; i++) {

			if (leftCounter < leftArray.length && rightCounter < rightArray.length) {
				if (leftArray[leftCounter] < rightArray[rightCounter]) {
					array[i] = leftArray[leftCounter++];
				} else {
					array[i] = rightArray[rightCounter++];
				}
			} else if (leftCounter == leftArray.length) {
				array[i] = rightArray[rightCounter++];
			} else if (rightCounter == rightArray.length) {
				array[i] = leftArray[leftCounter++];
			}
		}
		return array;
	}

	public static int[] mergeSort(int[] array, int p, int r) {

		if (r < p + 1) {

			return array;
		}

		int q = (r + p) / 2;
		mergeSort(array, p, q);
		mergeSort(array, q + 1, r);
		merge(array, p, q, r);
		return array;
	}

	public static void main(String args[]) {

		System.out.println(Arrays.toString(mergeSort(new int[] { 3, 55, 52, 26, 38, 57, 9, 49 }, 0, 7)));
	}

	public static int threshold = 5;

	public static int[] mergeInsertSort(int[] array, int p, int r) {

		if (r < p + 1) {

			return array;
		}

		if (r - p + 1 <= threshold) {
			array = insertion(array, p, r);
		} else {
			int q = (r + p) / 2;
			array = mergeInsertSort(array, p, q);

			array = mergeInsertSort(array, q + 1, r);

			array = merge(array, p, q, r);
		}
		return array;
	}

	public static int[] insertion(int[] array, int p, int r) {

		for (int i = p + 1; i < r + 1; i++) { // 0, 1, 2, 3

			int val = array[i];

			int j;
			for (j = i - 1; j >= p; j--) { // 0, 1*2, 2*2, 3*3

				if (val < array[j]) {

					array[j + 1] = array[j];

				} else {
					break;
				}
			}
			array[j + 1] = val;
		}
		return array;
	}

}
