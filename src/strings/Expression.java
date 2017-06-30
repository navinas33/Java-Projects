package strings;

import java.util.HashMap;
import java.util.Stack;

public class Expression {
	
	public static HashMap<String , String> hashmap=new HashMap<>();
	
	public static int checkExpression(String input,int num1,int num2)
	{
		int ret=0;
		if(input.equals("+"))
		{
			ret= num1+num2;
		}
		else if(input.equals("-"))
		{
			ret= num1-num2;
		}
		else if(input.equals("*"))
		{
			ret= num1*num2;
		}
		else if(input.equals("/"))
		{
			ret= num1/num2;
		}
		return ret;
	}
	
	public static int checkString(String input)
	{
		String regex1="[0-9]";
		int ret=0;
		if(java.util.regex.Pattern.matches("\\d+", input))
		{
			ret=Integer.parseInt(input);
		}
		else
		{
			ret=Integer.parseInt(hashmap.get(input));
		}
		
		return ret;
	}
	
	public static void implement(String exp)
	{ 
		Stack stack=new Stack<>();
		String input;
		int num1;
		int num2;
		int operant;
		int total=0;
		String regex="[a-z]";
		
		for(int i=exp.length()-1;i>=0;--i)
		{
			input=Character.toString(exp.charAt(i));
			if(input.matches(regex))
			{
				stack.push(input);
				//System.out.println("IF :"+input);
				//System.out.println("Stack Pop :"+stack.pop());
			}
			else
			{
				String temp=(String) stack.pop();
				num1=checkString(temp);
				String temp1=(String) stack.pop();
				num2=checkString(temp1);
				total=checkExpression(input,num1,num2);
				stack.push(String.valueOf(total));
			}
			
		}
		
		System.out.println("Total: "+total);
		
	}
		

	public static void main(String[] args) {
		
		String exp="*+ab+cd";
		
		hashmap.put("a", "5");
		hashmap.put("b", "6");
		hashmap.put("c", "7");
		hashmap.put("d", "8");
		
		System.out.println(exp);
		implement(exp);

	}

}
