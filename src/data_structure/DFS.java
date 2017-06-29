package data_structure;

import java.util.Stack;

public class DFS {
	
	public static void dfsRecursiveInorder(Node root)
	{
		if(root != null)
		{
			dfsRecursiveInorder(root.left);
			System.out.print(" "+root.data);
			dfsRecursiveInorder(root.right);
		}
	}
	
	public static void dfsRecursivePreorder(Node root)
	{
		if(root != null)
		{
			System.out.print(" "+root.data);
			dfsRecursivePreorder(root.left);
			dfsRecursivePreorder(root.right);
		}
	}
	
	public static void dfsRecursivePostorder(Node root)
	{
		if(root != null)
		{
			dfsRecursivePostorder(root.left);
			dfsRecursivePostorder(root.right);
			System.out.print(" "+root.data);
		}
	}
	
	public static void dfsImplementPreorder(Node root)
	{
		Stack<Node> stack=new Stack<>();
		while(true)
		{
			while(root != null)
			{
				System.out.print(" "+root.data);
				stack.push(root);
				root=root.left;
			}
			if(stack.isEmpty())
			{
				return;
			}
			root=stack.pop();
			root=root.right;
		}
	}
	
	public static void dfsImplementPostorder(Node root)
	{
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		
		stack1.push(root);
		while(stack1.isEmpty() == false)
		{
			// take out the root and insert into second stack.
			Node temp = stack1.pop();
			stack2.push(temp);
			
			// push the left and right child of root into the first stack
			if(temp.left != null)
			{
				stack1.push(temp.left);
			}
			if(temp.right != null)
			{
				stack1.push(temp.right);
			}
		}
		//once the all node are traversed, take out the nodes from second stack and print it.
		while(stack2.isEmpty() == false)
		{
			System.out.print(" "+stack2.pop());
		}
	}
	
	public static void dfsImplementInorder(Node root)
	{
		Stack<Node> stack=new Stack<>();
		while(true)
		{
			while(root != null)
			{
				stack.push(root);
				root=root.left;
			}
			if(stack.isEmpty())
			{
				return;
			}
			root=stack.pop();
			System.out.print(" "+root.data);
			root=root.right;
		}
		
		
		
	}

	public static void main(String[] args) {
		
		Node root=new Node(1);
		root.left=new Node(2);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right=new Node(3);
		root.right.left=new Node(6);
		root.right.right=new Node(7);

		System.out.println("--------  Inorder -------");
		dfsRecursiveInorder(root);
		System.out.println("");
		dfsImplementInorder(root);
		System.out.println("");
		
		System.out.println("--------  Preorder -------");
		dfsRecursivePreorder(root);
		System.out.println("");
		dfsImplementPreorder(root);
		System.out.println("");
		
		System.out.println("--------  Postorder -------");
		dfsRecursivePostorder(root);
		System.out.println("");
		dfsImplementPostorder(root);
		System.out.println("");
		
	}

}
