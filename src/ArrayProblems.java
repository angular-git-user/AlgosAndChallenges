import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArrayProblems implements Comparable<String> {

	// [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]

	public static void rotateByK(int[] array, int k) {

		int[] newArray = new int[array.length];
		int new_temp = 0;
		int old_temp = array[0];
		int counter = 0;
		for (int i = 0; i < array.length; i++) {

			// 1 2 3 4 5 6 7 >>> 1
			// 1 2 1 4 5 6 7 >>> 3
			// 1 2 1 4 3 6 7 >>> 5
			// 1 2 1 4 3 6 5 >>> 7
			// 1 7 1 4 3 6 5 >>> 2
			// 1 7 1 2 3 6 5 >>> 4
			// 1 7 1 2 3 4 5 >>> 6
			// 6 7 1 2 3 4 5 >>> 1
			new_temp = array[(counter + k) % array.length];
			array[(counter + k) % array.length] = old_temp;
			old_temp = new_temp;
			counter = (counter + k) % array.length;
		}
		System.out.println(Arrays.toString(array));
	}

	static boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				System.out.println("false");
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}

	public static void replaceSpaces(String string) {

		int track = string.length() - 1;
		char[] array = string.toCharArray();
		boolean isFirstOccurance = false;
		int counter = 0;

		for (int i = track; i >= 0; i--) {

			if (!(!isFirstOccurance && array[i] == ' ')) {
				counter = i;
				isFirstOccurance = true;
			}
			if (isFirstOccurance) {

				if (array[counter] != ' ') {
					array[track] = array[counter];
					track--;
					counter--;
				} else {
					array[track] = '0';
					track--;
					array[track] = '2';
					track--;
					array[track] = '%';
					track--;
					counter--;
				}
			}
		}
		String s = new String(array);
		System.out.println(s.toString());
	}

	static boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length)
			return false;
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; // II save top
				// II left -> top
				matrix[first][i] = matrix[last - offset][first];
				// II bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				// II right -> bottom
				;
				// II top -> right
				matrix[last][last - offset] = matrix[i][last];
				;
				matrix[i][last] = top; // II right<- saved top
			}
		}
		System.out.println(Arrays.toString(matrix[0])); /*
														 * {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
														 */
		System.out.println(Arrays.toString(matrix[1]));
		System.out.println(Arrays.toString(matrix[2]));
		System.out.println(Arrays.toString(matrix[3]));
		return true;
	}

	/*
	 * [13, 9, 5, 1] [14, 10, 6, 2] [15, 11, 7, 3] [16, 12, 8, 4]
	 */

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		// rotateByK(array, 5);
		// replaceSpaces("e mo nsd z ");
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		// rotate(matrix);
		// 0 1 1 2 3 5 8
		/*
		 * 0 1 > 1 1 + 1 > 2
		 * 
		 * 
		 * 
		 * 
		 */

		for (Map.Entry<String, String> entry : new HashMap<String, String>().entrySet())
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

		int k = 2;
		// System.out.println(fibonacci(k));

		int prev = 0;
		int sum = 1;
		int temp;
		for (int i = 1; i < k; i++) {

			temp = sum;
			sum += prev;
			prev = temp;

		}
		System.out.println(sum);

		System.out.println("a".compareTo("b"));
	}

	static int fibonacci(int i) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;
		return fibonacci(i - 1) + fibonacci(i - 2);
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
