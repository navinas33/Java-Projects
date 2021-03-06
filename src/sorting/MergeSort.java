package sorting;

public class MergeSort {
	
	public static int[] array;
    public static int[] tempMergArr;
    public static int length;
	
    /*
    Merge Sort Implementation
     */
    public static void sort(int inputArr[]) {
        array = inputArr;
        length = inputArr.length;
        tempMergArr = new int[length];
        doMergeSort(0, length - 1);
        for(int i = 0; i < inputArr.length; i++) {
        	System.out.print(inputArr[i]+" ");
        }
    }
 
    /*
    Recursion to attain sort
     */
    private static void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);    // sorts the left side of the array
            doMergeSort(middle + 1, higherIndex);    // sorts the right side of the array
            mergeParts(lowerIndex, middle, higherIndex);    // merge two sorted sides
        }
    }

    /*
    Merge arrays
     */
    private static void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }

	/*
	Main Class
	 */
    public static void main(String[] args) {
		int array[] = {5,2,3,1,7,4,0,-3,-4,-7};
		//Arrays.sort(array);
		sort(array);
	}
}
