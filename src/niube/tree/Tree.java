package niube.tree;

public class Tree {

	private Node root;

	public Tree(Node root) {
		super();
		this.root = root;
	}

	public Tree() {
		super();
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
}
