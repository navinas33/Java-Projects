package numbers;

public class LeastMultiple {
	
	public static int gcd(int a, int b){
	    if (a<b) return gcd(b,a);
	    if (a%b==0) return b;
	    else return gcd(a, a%b);
	}


	public static int lcm(int a, int b){
	    return ((a*b)/gcd(a,b));

	} 
	
	public static int lcmofarray(int[] arr, int start, int end){
	    if ((end-start)==1) return lcm(arr[start],arr[end-1]);
	    else return (lcm (arr[start], lcmofarray(arr, start+1, end)));
	}

	public static void main(String[] args) {
		int array[]={1,2,3,4,5};
		

	}

}
