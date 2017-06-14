package strings;

public class LogicalString {
	
	public static void permute(String begin,String end)
	{
		if(end.length()<=1)
		{
			System.out.println(begin+end);
		}
		else
		{
			
		}
	}

	public static void main(String[] args) {
		
		System.out.println("HAI HELLO");
		
		// permutation of a string
		
		String str = "abc";
		permute("",str);
		
		
	}

}
