package searching;

import java.util.Arrays;

public class LinearSearch {

	/*
	Linear Search Implementation
	 */
    public static int linearSearch (int arr[],int key) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	Main Class
	 */
	public static void main(String[] args) {
		int array[] = {1,3,4,6,8,9,12,16};
		//Arrays.sort(array);
		int key = 16;
		//int result=linear(array, key);
		System.out.println("Index of "+key+" in array is "+linearSearch(array, key));

	}

}
