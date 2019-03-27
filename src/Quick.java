import java.util.Arrays;

public class Quick {

	public static int[] quickSort(int[] array, int index) {

		if (array.length < 2) {
			return array;
		}

		int leftCount = 0;
		int rightCount = 0;
		int pivotValue = array[index];
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] < array[index]) {
				leftCount++;
			} else if (array[i] > array[index]) {
				rightCount++;
			}
		}
		int[] leftArray = new int[leftCount];
		int[] rightArray = new int[ array.length - leftCount - 1 ];

		int leftIndex = 0;
		int rightIndex = 0;

		for (int i = 0; i < array.length; i++) {
			if( i == index ) continue;
			
			if (array[i] < array[index]) {
				leftArray[leftIndex++] = array[i];
			} else {
				rightArray[rightIndex++] = array[i];
			}
		}
		leftArray = quickSort(leftArray, leftArray.length/2);
		rightArray = quickSort(rightArray, rightArray.length/2);

		// arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		System.arraycopy(leftArray, 0, array, 0, leftArray.length);
		array[leftArray.length] = pivotValue;
		
		System.arraycopy(rightArray, 0, array, leftArray.length + 1, rightArray.length);
		return array;
	}

	public static void main(String args[]) {
		System.out.println(Arrays.toString(quickSort(new int[] { 7, 10, 5, 8, 3, 5, 90, 90, 2 }, 4)));
	}
	
}
