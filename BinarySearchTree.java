package TweetSearch;

@SuppressWarnings({ "hiding" })
public class BinarySearchTree<String> {
	private Node<String> root;

	// Constructor #1: Create an empty binary search tree (BST)
	public BinarySearchTree() {
		root = null;
	}

	// Constructor #2: Create a BST given a root
	public BinarySearchTree(Node<String> root) {
		this.root = root;
	}

	// Constructor #3: Create a BST given a root, left tree, and a right tree
	public BinarySearchTree(String data, BinarySearchTree<String> leftTree,
			BinarySearchTree<String> rightTree) {
		// Create a root node for this tree
		this.root = new Node<String>(data);
		// Connect the leftNode of the root with the leftTree
		if (leftTree != null)
			this.root.leftNode = leftTree.root;
		// Connect the rightNode of the root with rightTree
		if (rightTree != null)
			this.root.rightNode = rightTree.root;
	}

	// Method: insertNode (insert a value into a BST)
	public void insertNode(String insertValue) {

		if (this.root == null)
			this.root = new Node<String>(insertValue);
		else
			this.root.insert(insertValue);
	}

	public BinarySearchTree<String> getLeftTree() {

		if (root != null && root.leftNode != null) {

			return (new BinarySearchTree<String>(root.leftNode));
		} else
			return null;
	}

	public BinarySearchTree<String> getRightTree() {

		if (root != null && root.rightNode != null) {

			return (new BinarySearchTree<String>(root.rightNode));
		} else
			return null;
	}

	// Method: findTweet. Enter a tweet and search the binary tree to see if it
	// exists

	@SuppressWarnings("unchecked")
	public String findTweet(BinarySearchTree<String> tree, java.lang.String key) {
		String foundTweet;
		String notFound = (String) "Tweet not found";
		
		if (tree == null)
			return (String) "";
		else if (tree.root.data.equals(key)) {
			foundTweet = (String) key;
			return foundTweet;}
		else if (!tree.root.data.equals(key))
			return (String) (findTweet(tree.getLeftTree(),key)
					+ tree.root.toString() + " " + findTweet(tree
						.getRightTree(),key));
		
		else 
			return notFound;
		}

	@SuppressWarnings("unchecked")
	public String printInorderTraversal(BinarySearchTree<String> tree) {
		if (tree == null)
			return (String) "";

		else
			return (String) (printInorderTraversal(tree.getLeftTree())
					+ tree.root.toString() + " " + printInorderTraversal(tree
						.getRightTree()));
	}

}
