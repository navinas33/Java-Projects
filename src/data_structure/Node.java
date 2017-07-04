package data_structure;

/*
Node Class for Tree
 */
public class Node {
	
	public int data;
	public Node left;
	public Node right;
	
	/*
	Constructor with data as argument
	 */
	public Node(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
