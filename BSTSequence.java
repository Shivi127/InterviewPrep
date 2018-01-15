/**
 * 
 */

/**
 * @author shivangisingh
 * A binary Search Tree was created by traversing through an array from left to right
 * and inserting each element. Given a BST with distinct elements, print all the possible arrays
 * that could have led to this tree.
 */
public class BSTSequence {

	
	
	public int numofpossible(int[] a) {
		int[] t= new int[a.length+1];
		t[0]=1;
		t[1]=1;
		
		for(int i=2;i<=a.length;i++) {
			for(int j=0;j<i;j++) {
				t[i]+=t[j]+t[i-j-1];
			}
		}
//		Catlan Number
		return(t[t.length-1]);
		
	}
}
