package assignment2;

import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

@invariant ({"$super", "$this.isBalanced()"})
public class BalancedBinTree extends BinTree{


	public BalancedBinTree(long id) {
		super(id);
	}
	
	public boolean isBalanced(){
		if (this.getLeft().height() - getRight().height() <= 1)
			return true;
		else
			return false;		
	}
}
