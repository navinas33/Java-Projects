package Tree;

import java.util.ArrayList;

public class Node {
	
	String id;
	ArrayList<Node> children = new ArrayList<>();
	Node parent;
	
	public Node getRoot()
	{
		if(parent == null)
		{
			return this;
		}
		return parent.getRoot();
	}
	
	public Node(Node parent) {
		super();
		this.parent = parent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Node> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	
	

}
