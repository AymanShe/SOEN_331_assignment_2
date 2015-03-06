package assignment2;


import java.util.Random;
import java.util.Stack;

import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

@invariant ({"$this != null", "$this.id > 0", "$this.size >= 0"})
public class BinTree implements BinaryTree {
	private long id;
	private int size = 0;
	private BinTree leftSubTree, rightSubTree = null;
	
	public BinTree() {
		this.id = new Random().nextLong();
	}
	
	public BinTree(long id) {
		this.id = id;
		this.size++;
	}

	@Override
	public BinTree getLeft() {
		return this.leftSubTree;
	}


	@Override
	public BinTree getRight() {
		return this.rightSubTree;
	}

	@requires({"iBinTree != null","$this.leftSubTree.id != $this.iBinTree.id"})
	@ensures({"$this.leftSubTree != null","$this.leftSubTree == $this.iBinTree"})
	@Override
	public void setLeft(BinTree iBinTree){
			this.leftSubTree = iBinTree;
			this.size++;
		}
	}

	@requires({"$this.iBinTree != null","$this.rightSubTree.id != $this.iBinTree.id"})
	@ensures({"$this.rightSubTree != null","$this.rightSubTree == $this.iBinTree"})
	@Override
	public void setRight(BinTree iBinTree) {
			this.rightSubTree = iBinTree;
			this.size++;
		}
	}

	@Override
	public boolean hasLeft() {
		return (this.leftSubTree != null);
	}

	@Override
	public boolean hasRight() {
		return (this.rightSubTree == null);
	}

	/*
	 * size
	 */
	@Override
	public int sumNodes() {
		return size;
	}
	
	public boolean isEmpty() {
		return (!this.hasLeft() || !this.hasRight());
	}
	
	@Override
	public int height() {
		 int height = 0;
		    Stack<BinTree> trees = new Stack<BinTree>();
		    Stack<BinTree> path = new Stack<BinTree>();
		    BinTree root = this;
		    
		    trees.push (root);
		    while (!trees.empty()) {
		        root = trees.peek();
		        if (!path.empty() && root == path.peek()) {
		            if (path.size() > height)
		                height = path.size();
		            path.pop();
		            trees.pop();
		        } else {
		            path.push(root);
		            if (root.getRight() != null)
		                trees.push(root.getRight());
		            if (root.getLeft() != null)
		                trees.push(root.getLeft());
		        }
		    }
		    
		    System.out.println("Height: " + height);
		    return height;
	}
	
	
	
	//error injected methods
	
	@requires({"iBinTree != null","$this.leftSubTree.id != $this.iBinTree.id"})
	@ensures({"$this.leftSubTree != null","$this.leftSubTree == $this.iBinTree"})
	public void setLeftErr1(BinTree iBinTree) throws IllegalArgumentException{
		if(!(iBinTree instanceof BinaryTree) || iBinTree == null)
			throw new IllegalArgumentException("Passed tree argument is either null or empty.");
		else
			this.leftSubTree = null;
	}

	@requires({"iBinTree != null","$this.leftSubTree.id != $this.iBinTree.id"})
	@ensures({"$this.leftSubTree != null","$this.leftSubTree == $this.iBinTree"})
	public void setLeftErr2(BinTree iBinTree) throws IllegalArgumentException{
		if(!(iBinTree instanceof BinaryTree) || iBinTree == null)
			throw new IllegalArgumentException("Passed tree argument is either null or empty.");
		else
			this.leftSubTree = new BinTree(0);
	}

	@requires({"$this.iBinTree != null","$this.rightSubTree.id != $this.iBinTree.id"})
	@ensures({"$this.rightSubTree != null","$this.rightSubTree == $this.iBinTree"})
	public void setRightErr1(BinTree iBinTree) throws IllegalArgumentException{
		if(!(iBinTree instanceof BinaryTree) || iBinTree == null)
			throw new IllegalArgumentException("Passed tree argument is either null or empty.");
		else
			this.rightSubTree = null;
	}

	@requires({"$this.iBinTree != null","$this.rightSubTree.id != $this.iBinTree.id"})
	@ensures({"$this.rightSubTree != null","$this.rightSubTree == iBinTree"})
	public void setRightErr2(BinTree iBinTree) throws IllegalArgumentException{
		if(!(iBinTree instanceof BinaryTree) || iBinTree == null)
			throw new IllegalArgumentException("Passed tree argument is either null or empty.");
		else
			this.rightSubTree = new BinTree(0);
	}
}
