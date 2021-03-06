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

	// Method: retrieve the left node in the tree and return it to findHashtag
	// method
	public BinarySearchTree<String> getLeftTree() {
		if (root != null && root.leftNode != null) {
			return (new BinarySearchTree<String>(root.leftNode));
		} else
			return null;
	}

	// Method: retrieve the right node in the tree and return it to findHashtag
	// method
	public BinarySearchTree<String> getRightTree() {
		if (root != null && root.rightNode != null) {
			return (new BinarySearchTree<String>(root.rightNode));
		} else
			return null;
	}

	// Method: findTweet. Enter a tweet and search the binary tree to see if it
	// exists

	@SuppressWarnings("unchecked")
	public String findHashtag(BinarySearchTree<String> tree,
			java.lang.String key) {
		String foundTweet;
		String notFound = (String) ("\n" + key + " was not found in the hashtag list.");

		if (tree == null)
			return (String) notFound;
		else if (((java.lang.String) tree.root.data).compareToIgnoreCase(key) == 0) {
			foundTweet = (String) ("\n" + key + " was found in the hashtag list.");
			return foundTweet;
		} else if ((key).compareToIgnoreCase((java.lang.String) tree.root.data) > 0)
			return (String) findHashtag(tree.getRightTree(), key);
		else
			return (findHashtag(tree.getLeftTree(), key));

	}
}
