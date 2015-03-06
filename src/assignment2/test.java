
public class test {

	public static void main(String[] args) {
		
		/* contract 4 should fail because we are passing null to setLeft()
		BinTree t1 = new BinTree(0);
		BinTree t2 = new BinTree(1);
		t1.setLeft(null);
		*/
		
		/* contract 5 should fail because we are overwriting an existing left node 
		BinTree t1 = new BinTree(0);
		BinTree t2 = new BinTree(1);
		BinTree t3 = new BinTree(2);
		t1.setLeft(t2);
		t1.setLeft(t3);
		*/
		
		/* for contract 6 and 7 errors have to be injected. Thus, similar methods
		 * with injected errors and same contracts will be used
		 */
		
		/* contract 6 should fail as the method leaves the left as null
		BinTree t1 = new BinTree(0);
		BinTree t2 = new BinTree(1);
		BinTree t3 = new BinTree(2);
		t1.setLeftErr1(t2);
		*/
		
		/* contract 7 should fail as the method assigns a different left node than the one provided
		BinTree t1 = new BinTree(0);
		BinTree t2 = new BinTree(1);
		BinTree t3 = new BinTree(2);
		t1.setLeftErr2(t2);
		*/
		
		/* contract 8 should fail because we are passing null to setRight()
		BinTree t1 = new BinTree(0);
		BinTree t2 = new BinTree(1);
		t1.setRight(null);
		*/
		
		/* contract 9 should fail because we are overwriting an existing right node 
		BinTree t1 = new BinTree(0);
		BinTree t2 = new BinTree(1);
		BinTree t3 = new BinTree(2);
		t1.setRight(t2);
		t1.setRight(t3);
		*/
		
		/* for contract 10 and 11 errors have to be injected. Thus, similar methods
		 * with injected errors and same contracts will be used
		 */
		
		/* contract 10 should fail as the method leaves the right as null
		BinTree t1 = new BinTree(0);
		BinTree t2 = new BinTree(1);
		BinTree t3 = new BinTree(2);
		t1.setRightErr1(t2);
		*/
		
		/* contract 11 should fail as the method assigns a different left node than the one provided
		BinTree t1 = new BinTree(0);
		BinTree t2 = new BinTree(1);
		BinTree t3 = new BinTree(2);
		t1.setRightErr2(t2);
		*/

	}
}
