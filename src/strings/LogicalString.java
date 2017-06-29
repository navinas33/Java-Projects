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
			for(int i=0;i<end.length();i++)
			{
				String newstring=end.substring(0, i)+end.substring(i+1);
			//	System.out.println("First : "+begin+end.charAt(i));
			//	System.out.println("New String : "+newstring);
				permute(begin+end.charAt(i),newstring);
			}
		}
	}

	public static void main(String[] args) {
		
		// permutation of a string
		
		//String str = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()-+_={}:'<>,.?/";
		String str = "abcdefghijkl";
		System.out.println(str);
		permute("",str);
		
		
	}

}
