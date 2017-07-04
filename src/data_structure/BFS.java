package data_structure;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    /*
    BFS Implementation
     */
	public static void bfsImplement(Node root) {
		Queue<Node> queue = new LinkedList<>();
		if(root == null) {
            return;
        }
		queue.add(root);
		while( !queue.isEmpty() ) {
			Node node = queue.remove();
			System.out.print(" "+node.data);
			if(node.left != null) {
                queue.add(node.left);
            }
			if(node.right != null) {
                queue.add(node.right);
            }
		}
	}

	/*
	Main class
	 */
	public static void main(String[] args) {
	    Node root = new Node(5);
		root.left = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(22);
		root.right = new Node(9);
		root.right.left = new Node(21);
		root.right.right = new Node(12);
		bfsImplement(root);
		}
}
