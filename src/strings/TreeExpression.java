package strings;

import java.util.Stack;

class TreeNode {
    TreeNode left;
    char ch;
    TreeNode right;
    TreeNode(TreeNode left, char ch, TreeNode right) {
        this.left = left;
        this.ch = ch;
        this.right = right;
    }
}

class Stack2 {
    private char[] a;
    private int    top, m;
    public Stack2(int max) {
        m = max;
        a = new char[m];
        top = -1;
    }
 
    public void push(char key)
    {
        a[++top] = key;
    }
 
    public char pop()
    {
        return (a[top--]);
    }
 
    public boolean isEmpty()
    {
        return (top == -1);
    }
}

public class TreeExpression {
	public static TreeNode root;
	static class Conversion {
	    private Stack2 s;
	    private String input;
	    private String output = "";
	    public Conversion(String str) {
	        input = str;
	        s = new Stack2(str.length());
	    }
	 
	    public String inToPost() {
	        for (int i = 0; i < input.length(); i++) {
	            char ch = input.charAt(i);
	            switch (ch) {
	                case '+':
	                case '-':
	                    gotOperator(ch, 1);
	                    break;
	                case '*':
	                case '/':
	                    gotOperator(ch, 2);
	                    break;
	                case '(':
	                    s.push(ch);
	                    break;
	                case ')':
	                    gotParenthesis();
	                    break;
	                default:
	                    output = output + ch;
	            }
	        }
	        while (!s.isEmpty())
	            output = output + s.pop();
	        return output;
	    }
	 
	    private void gotOperator(char opThis, int prec1)
	    {
	        while (!s.isEmpty()) {
	            char opTop = s.pop();
	            if (opTop == '(') {
	                s.push(opTop);
	                break;
	            } else {
	                int prec2;
	                if (opTop == '+' || opTop == '-')
	                    prec2 = 1;
	                else
	                    prec2 = 2;
	                if (prec2 < prec1) {
	                    s.push(opTop);
	                    break;
	                } else
	                    output = output + opTop;
	            }
	        }
	        s.push(opThis);
	    }
	    private void gotParenthesis() {
	        while (!s.isEmpty()) {
	            char ch = s.pop();
	            if (ch == '(')
	                break;
	            else
	                output = output + ch;
	        }
	    }
	}
    static class Stack1 {
	    private Node[] a;
	    private int top;
        private int m;
        public Stack1(int max) {
	        m = max;
	        a = new Node[m];
	        top = -1;
	    }
	    public void push(Node key)
	    {
	        a[++top] = key;
	    }
	 
	    public Node pop()
	    {
	        return (a[top--]);
	    }
	 
	    public boolean isEmpty()
	    {
	        return (top == -1);
	    }
	}

	public static void createExpressionTree(String postfix) {
		TreeNode node;
        Stack1 stk;
		Conversion c = new Conversion(postfix);
        postfix = c.inToPost();
        stk = new Stack1(postfix.length());
        postfix = postfix + "#";
        int i = 0;
        char symbol = postfix.charAt(i);
        Node newNode;
        while (symbol != '#') {
            if (symbol >= '0' && symbol <= '9' || symbol >= 'A'
                    && symbol <= 'Z' || symbol >= 'a' && symbol <= 'z') {
                newNode = new Node(symbol);
                stk.push(newNode);
            } else if (symbol == '+' || symbol == '-' || symbol == '/'
                    || symbol == '*') {
                Node ptr1 = stk.pop();
                Node ptr2 = stk.pop();
                newNode = new Node(symbol);
                newNode.left = ptr2;
                newNode.right = ptr1;
                stk.push(newNode);
            }
            symbol = postfix.charAt(++i);
        }
      //  root = stk.pop();
		
	     /*Stack<TreeNode> nodes = new Stack<TreeNode>();
	     TreeNode node;
	    for (int i = 0; i < postfix.length(); i++) 
	    {
	        char ch  = postfix.charAt(i);
	        if(ch == '(')
	        {
	        	 node = new TreeNode(null, ' ', null);
		        
	        }
	        else if(ch == ')')
	        {
	        	node=nodes.pop();
	        	nodes.push(new TreeNode(null, ' ', node));
	        	
	        }
	        else if (isOperator(ch)) 
	        {
	          // TreeNode rightNode = nodes.pop();
	           node = nodes.pop();
	           nodes.push(new TreeNode(node, ch, null));
	        } 
	        else 
	        {
	            nodes.add(new TreeNode(null, ch, null));
	        }
	    }
	    root = nodes.pop();*/
	}
	
	
	public static void dfsRecursivePreorder(TreeNode root) {
		if(root != null) {
			System.out.print(" "+root.ch);
			dfsRecursivePreorder(root.left);
			dfsRecursivePreorder(root.right);
		}
	}
	
	
	public static boolean isOperator(char c) {
	     if (c == '+' || c == '-'
	             || c == '*' || c == '/'
	             || c == '^') {
	         return true;
	     }
	     return false;
	 }
	
	public static void main(String[] args) {
		String exp = "1+2-3";
		//String postfix="ab+cd+*";
		String postfix = "a+b";
		createExpressionTree(postfix);
		//char[] charArray = exp.toCharArray();
		//Node node=constructTree(exp);
		dfsRecursivePreorder(root);
	}
}
