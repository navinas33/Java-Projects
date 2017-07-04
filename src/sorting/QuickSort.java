package sorting;

public class QuickSort {
	
	private static int[] numbers;
    private static int number;

    /*
    Quick Sort Implementation
     */
    public static void sort(int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0){
            return;
        }
        numbers = values;
        number = values.length;
        quickSort(0, number-1);
        for(int i = 0; i < values.length; i++) {
        	System.out.print(values[i]+" ");
        }
    }

    public static void quickSort(int low, int high) {
        int i = low;
        int j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];
        // Divide into two lists
        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if ( low < j ) {
            quickSort(low, j);
        }
        if (i < high) {
            quickSort(i, high);
        }
    }

    /*
    Swap values
     */
    private static void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
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
