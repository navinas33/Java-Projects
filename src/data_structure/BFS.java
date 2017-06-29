package data_structure;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	public static void bfsImplement(Node root)
	{
		Queue<Node> queue=new LinkedList<>();
		if(root == null)
		{
			return;
		}
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node e=queue.remove();
			System.out.print(" "+e.data);
			if(e.left != null)
			{
				queue.add(e.left);
			}
			if(e.right != null)
			{
				queue.add(e.right);
			}
		}
	}

	public static void main(String[] args) {
		
		Node root=new Node(5);
		root.left=new Node(6);
		root.left.left=new Node(2);
		root.left.right=new Node(22);
		root.right=new Node(9);
		root.right.left=new Node(21);
		root.right.right=new Node(12);
		
		bfsImplement(root);
		}
}
