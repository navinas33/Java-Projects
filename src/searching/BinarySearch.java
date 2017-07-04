package searching;

public class BinarySearch {

	/*
	Binary Search Implementation
	 */
    public static int binarySearch (int arr[], int key) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (key == arr[mid]) {
				return mid;
			}
			if (key < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
        return -1;
	}

	/*
	Main Class
	 */
	public static void main(String[] args) {
		int array[] = { 1, 3, 4, 6, 8, 9, 12, 16 };
		// Arrays.sort(array);
		int key = 8;
		// int result=linear(array, key);
		System.out.println("Index of " + key + " in array is " + binarySearch(array, key));

	}
}
