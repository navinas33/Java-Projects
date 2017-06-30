package check;
import java.io.*;

class Node
{
    public char data;
    public Node left;
    public Node right;
 
    public Node(char x)
    {
        data = x;
    }
 
    public void displayNode()
    {
        System.out.print(data);
    }
}
 
class Stack1
{
    private Node[] a;
    private int    top, m;
 
    public Stack1(int max)
    {
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
 
class Stack2
{
    private char[] a;
    private int    top, m;
 
    public Stack2(int max)
    {
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
 
class Conversion
{
    private Stack2 stack2;
    private String input;
    private String output = "";
 
    public Conversion(String str)
    {
        input = str;
        stack2 = new Stack2(str.length());
    }
 
    public String inToPost()
    {
        for (int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);
            switch (ch)
            {
                case '+':
                case '-':
                    gotOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOperator(ch, 2);
                    break;
                case '(':
                    stack2.push(ch);
                    break;
                case ')':
                    gotParenthesis();
                    break;
                default:
                    output = output + ch;
            }
        }
        while (!stack2.isEmpty())
            output = output + stack2.pop();
        return output;
    }
 
    private void gotOperator(char opThis, int prec1)
    {
        while (!stack2.isEmpty())
        {
            char opTop = stack2.pop();
            if (opTop == '(')
            {
                stack2.push(opTop);
                break;
            } else
            {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1)
                {
                    stack2.push(opTop);
                    break;
                } else
                    output = output + opTop;
            }
        }
        stack2.push(opThis);
    }
 
    private void gotParenthesis()
    {
        while (!stack2.isEmpty())
        {
            char ch = stack2.pop();
            if (ch == '(')
                break;
            else
                output = output + ch;
        }
    }
}
 
class Tree
{
    private Node root;
 
    public Tree()
    {
        root = null;
    }
 
    public void insert(String stack2)
    {
        Conversion c = new Conversion(stack2);
        stack2 = c.inToPost();
        Stack1 stack1 = new Stack1(stack2.length());
        stack2 = stack2 + "#";
        int i = 0;
        char symbol = stack2.charAt(i);
        Node newNode;
        while (symbol != '#')
        {
            if (symbol >= '0' && symbol <= '9' || symbol >= 'A'
                    && symbol <= 'Z' || symbol >= 'a' && symbol <= 'z')
            {
                newNode = new Node(symbol);
                stack1.push(newNode);
            } else if (symbol == '+' || symbol == '-' || symbol == '/'
                    || symbol == '*')
            {
                Node ptr1 = stack1.pop();
                Node ptr2 = stack1.pop();
                newNode = new Node(symbol);
                newNode.left = ptr2;
                newNode.right = ptr1;
                stack1.push(newNode);
            }
            symbol = stack2.charAt(++i);
        }
        root = stack1.pop();
    }
 
    public void traverse(int type)
    {
        System.out.print("Preorder Traversal: ");
        preOrder(root);
                
    }
 
    private void preOrder(Node root)
    {
        if (root != null)
        {
            root.displayNode();
            preOrder(root.left);
            preOrder(root.right);
        }
    }
 }
 
public class ExpressionTree
{
    public static void main(String args[]) throws IOException
    {
    	String input="(a+b)*(c+d)";
        Tree t1 = new Tree();
        t1.insert(input);
        t1.traverse(1);
     }
}