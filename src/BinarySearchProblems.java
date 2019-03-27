
public class BinarySearchProblems {

	public static int binarySearch(int[] array, int left, int right, int searchTerm) {

		if (right < left) {
			return -1;

		} else {
			int mid = (left + right) / 2;

			if (array[mid] == searchTerm)
				return mid;

			if (array[mid] < searchTerm) {
				return binarySearch(array, mid + 1, right, searchTerm);
			} else {
				return binarySearch(array, left, mid - 1, searchTerm);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		//System.out.println(binarySearch(array, 0, array.length - 1, 5));
		System.out.println("dbc".compareTo("bbc"));
	}

}
