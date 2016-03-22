package TweetSearch;

@SuppressWarnings("hiding")
public class Node<String> {

	// class variable declaration:
	protected Node<String> leftNode;
	protected Node<String> rightNode;
	protected String data;

	// Constructor
	public Node(String data) {
		// initialization of a node
		leftNode = rightNode = null;
		this.data = data;
	}

	// Method: toString
	public java.lang.String toString() {
		return this.data.toString();
	}

	// Method: insert. Insert a node into a binary search tree
	public void insert(String insertValue) {
		int compare = ((java.lang.String) insertValue)
				.compareTo((java.lang.String) this.data);
		if (compare < 0) {
			// add this node to the left of the current node
			if (this.leftNode == null)
				this.leftNode = new Node<String>(insertValue);
			else
				this.leftNode.insert(insertValue);
		} else if (compare > 0) {
			if (this.rightNode == null)
				this.rightNode = new Node<String>(insertValue);

			else
				this.rightNode.insert(insertValue);
		}
	}// end of insert method
	
	
	
}// end of class
