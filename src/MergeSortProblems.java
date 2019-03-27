import java.util.Arrays;

public class MergeSortProblems {

	public static String[] merge(String[] array, int p, int q, int r) {

		String[] leftArray = new String[q - p + 1];
		String[] rightArray = new String[r - q];

		System.arraycopy(array, p, leftArray, 0, q - p + 1);
		System.arraycopy(array, q + 1, rightArray, 0, r - q);

		int leftCounter = 0;
		int rightCounter = 0;

		for (int i = p; i <= r; i++) {

			if (leftCounter < leftArray.length && rightCounter < rightArray.length) {
				if (leftArray[leftCounter].length() <= rightArray[rightCounter].length()) {
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

	public static String[] mergeSort(String[] array, int p, int r) {

		if (r < p + 1) {

			return array;
		}

		int q = (r + p) / 2;
		array = mergeSort(array, p, q);
		array = mergeSort(array, q + 1, r);
		array = merge(array, p, q, r);
		return array;
	}
	
	public static void main(String args[]) {
		
		String[] string = {"ab", "cd", "e", "j", "asd", "ljffg", "df"};
		System.out.println(Arrays.toString(mergeSort(string, 0, 6)));
		String[] string1 = {"xy", "yx", "zxy", "zx", "xzy", "xxx"};
		System.out.println(Arrays.toString(mergeSort(string1, 0, 5)));
	}
}
