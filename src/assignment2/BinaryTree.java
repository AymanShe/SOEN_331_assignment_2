package assignment2;

public interface BinaryTree {

	public BinTree getLeft(); // Return the left child of the current node.

	public BinTree getRight(); // Return the right child of the current node.

	public void setLeft(BinTree iBinTree); // Set the left child of the current node to iBinTree.

	public void setRight(BinTree iBinTree); // Set the right child of the current node to iBinTree.

	public boolean hasLeft(); // Test whether the current node has a left child.

	public boolean hasRight(); // Test whether the current node has a right child.

	// The interface contains the following auxiliary methods:

	public int sumNodes(); // Return the number of nodes present in the tree.

	public int height(); // Return the height of the tree.
}
