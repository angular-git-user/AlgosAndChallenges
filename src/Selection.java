import java.util.Arrays;

public class Selection {

	public static void selection(int[] array) {

		for (int i = 0; i < array.length; i++) {

			int minIndex = i;
			for (int j = i; j < array.length; j++) {

				if (array[minIndex] > array[j]) {

					minIndex = j;
				}
			}
			// swap
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		selection(new int[] { 7, 10, 5, 8, 2, 5, 90, 90, 3 });
	}

}
