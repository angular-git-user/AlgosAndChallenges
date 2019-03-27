import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortingAndSearching {

	public static void mergeTwoArray(int[] array1, int[] array2) {

		int temp;
		int arr1_counter = array1.length - array2.length - 1;
		int arr2_counter = array2.length - 1;
		int cur_counter = array1.length - 1;
		for (int i = array1.length - 1; i >= 0; i--) {

			if (!(arr2_counter >= 0)) {
				break;
			}
			if (arr1_counter >= 0 && array2[arr2_counter] < array1[arr1_counter]) {

				array1[cur_counter] = array1[arr1_counter];
				arr1_counter--;
				cur_counter--;
			} else {

				array1[cur_counter] = array2[arr2_counter];
				cur_counter--;
				arr2_counter--;

			}
		}
		System.out.println(Arrays.toString(array1));
	}

	public static void main(String[] args) {

		int[] array1 = new int[5];
		array1[0] = 8;
		int[] array2 = new int[] { 3, 5, 6, 10 };
		//mergeTwoArray(array1, array2);
		
		//int[] array = {12, 1, 5, 7, 3, 2, 13, 2 ,1, 0};
		char[] array = {'x', 'z', 'j','i','b','e','a','r'};
		quickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}

	public static int partition(char[] array, int left, int right) {

		int i = -1;
		if (left < right) {

			int pivot = array[right];
			int j = 0;
			
			while (j < right) {
				
				if(array[j] <= pivot) {
					
					i++;
					char temp = array[i];
					array[i] = array[j];
					//j++;
					array[j] = temp;
				}
				j++;
			}
			char temp = array[right];
			i++;
			array[right] = array[i];
			array[i] = temp;
		}
		return i;
	}
	
	public static char[] quickSort(char[] array, int left, int right) {
		
		if(right > left) {
			
			int mid = partition(array, left, right);
			quickSort(array, left, mid-1);
			quickSort(array, mid + 1, right);
		}
		return array;
	}
}
