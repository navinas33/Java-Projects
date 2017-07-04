package sorting;

public class SelectionSort {
	
	public static void selectionSort(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			int index = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[index] > arr[j]) {
					index = j;
				}
			}
			int snumber = arr[index];
			arr[index] = arr[i];
			arr[i] = snumber;
		}
		for(int k = 0; k < arr.length; k++) {
			System.out.print(arr[k]+" ");
		}
	}

	/*
	Main Class
	 */
	public static void main(String[] args) {
		int array[] = {5,2,3,7,4,0,-3};
		//Arrays.sort(array);
		selectionSort(array);
	}
}
