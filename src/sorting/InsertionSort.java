package sorting;

public class InsertionSort {
	
	public static void insertionSort(int arr[])
	{
		for(int i=1;i<arr.length;i++) 
		{  
            int key = arr[i];  
            int j = i-1;  
            while((j > -1) && (arr[j] > key)) 
            {  
                arr [j+1] = arr [j];  
                j--;  
            }  
            arr[j+1] = key;  
        }
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		int array[]={5,2,3,1,7,4,0,-3,-4,-7};
		//Arrays.sort(array);
		insertionSort(array);

	}

}
