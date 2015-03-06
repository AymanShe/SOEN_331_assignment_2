
import java.util.Random;
import java.util.Stack;

import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

@invariant ({"$this.size >= 0"})
public class BinTree implements BinaryTree {
	public long id;
	public int size = 0;
	public BinTree leftSubTree, rightSubTree = null;
	
	@ensures ({"$this.hasLeft()==false","$this.hasRight()==false"})
	public BinTree() {
		id = Math.abs(new Random().nextLong());
	}
	
	@requires ({"id!=null"})
	@ensures ({"$this.hasLeft()==false","$this.hasRight()==false"})
	public BinTree(long id) {
		this.id = id;
		size++;
		//leftSubTree= new BinTree(); an error to trigger contract 3, remove the comment symbols to inject the error
	}

	@Override
	public BinTree getLeft() {
		return leftSubTree;
	}


	@Override
	public BinTree getRight() {
		return rightSubTree;
	}

	@requires({"iBinTree != null","$this.hasLeft()==false"})
	@ensures({"$this.leftSubTree != null","$this.leftSubTree == iBinTree"})
	@Override
	public void setLeft(BinTree iBinTree){
			leftSubTree = iBinTree;
			size++;
	}

	@requires({"iBinTree != null","$this.hasRight()==false"})
	@ensures({"$this.rightSubTree != null","$this.rightSubTree == iBinTree"})
	@Override
	public void setRight(BinTree iBinTree) {
			rightSubTree = iBinTree;
			size++;
	}

	@Override
	public boolean hasLeft() {
		return (leftSubTree != null);
	}

	@Override
	public boolean hasRight() {
		return (rightSubTree != null);
	}

	/*
	 * size
	 */
	@Override
	public int sumNodes() {
		return size;
	}
	
	public boolean isEmpty() {
		return !(hasLeft()||hasRight());
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
		    
		    return height;
	}

	//error injected methods
	
	public int sumNodesErr() {
		size=-1;
		return size;
	}
	
	@requires({"iBinTree != null","$this.hasLeft()==false"})
	@ensures({"$this.leftSubTree != null","$this.leftSubTree == iBinTree"})
	public void setLeftErr1(BinTree iBinTree){
			this.leftSubTree = null;
			size++;
	}

	@requires({"iBinTree != null","$this.hasLeft()==false"})
	@ensures({"$this.leftSubTree != null","$this.leftSubTree == iBinTree"})
	public void setLeftErr2(BinTree iBinTree) {
			this.leftSubTree = new BinTree();
	}

	@requires({"iBinTree != null","$this.hasRight()==false"})
	@ensures({"$this.rightSubTree != null","$this.rightSubTree == iBinTree"})
	public void setRightErr1(BinTree iBinTree){
			this.rightSubTree = null;
	}

	@requires({"iBinTree != null","$this.hasRight()==false"})
	@ensures({"$this.rightSubTree != null","$this.rightSubTree == iBinTree"})
	public void setRightErr2(BinTree iBinTree) {
			this.rightSubTree = new BinTree();
	}
	
}