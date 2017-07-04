package sorting;

import java.util.Arrays;

public class BubbleSort {
	
    /*
    Bubble Sort Implementation
     */
    public static void bubbleSort(int arr[]) {
		int temp = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
        for(int k = 0; k < arr.length; k++) {
			System.out.print(arr[k]+" ");
		}
    }

	/*
	Main Class
	 */
	public static void main(String[] args) {
		int array[]={5,2,3,1,7,4,0,-3,-4,-7,123,12,546,356};
		//Arrays.sort(array);
		bubbleSort(array);
    }
}
