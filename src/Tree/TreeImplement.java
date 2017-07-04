package Tree;

public class TreeImplement {
	
	/*
	Add child to root node
	 */
    public static Node addChild(Node parent, String id) {
		Node node = new Node(parent);
		node.setId(id);
		parent.getChildren().add(node);
		return node;
	}
	
	/*
	Print tree
	 */
	public static void printTree(Node node , String appender) {
		System.out.println(appender+node.getId());
		for(Node each : node.getChildren()) {
			printTree(each, appender+appender);
		}
	}

	/*
	Main Class
	 */
	public static void main(String[] args) {
		Node treeNode = new Node(null);
		treeNode.setId("root");
		Node child=addChild(treeNode, "child-1");   // add child to root node
		addChild(child, "child-11");    // add child to child-1 node
		addChild(child, "child-12");    // add child to child-1 node
		Node child1=addChild(treeNode, "child-2");  // add child to root node
		addChild(child1, "child-21");   // add child to child-2 node
		addChild(child1, "child-22");   // add child to child-2 node
		System.out.println("Root Node: "+treeNode.getRoot().getId());
		printTree(treeNode, " ");   // print tree
	}
}
