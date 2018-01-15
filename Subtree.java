/**
 * 
 */

/**
 * @author shivangisingh
 * 1) Check if two Binary Trees are identical
 * 2) T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an
 *    algorithm to determine if T2 is a subtree of T1.
 */
public class Subtree {

	public boolean isSubtree(BNode a, BNode b) {
//		a is the bigger one
		
		if(a== null && b== null) {
			return true;
		}
		if(a!=null && b== null) {
//			Assuming that a null tree is a subtree
			return true;
		}
		if(a==null && b!= null) {
			return false;
		}
		
		if(identical(a,b))
			return true;
//		Find the root in the main tree and pass it to a function. That compares its traversal?
		return (isSubtree(a.left,b)||isSubtree(a.right,b));
	}
	
public boolean identical(BNode a, BNode b) {
	if(a== null && b== null) {
		return true;
	}
	if(a!=null && b== null) {
//		Assuming that a null tree is a subtree
		return true;
	}
	if(a==null && b!= null) {
		return false;
	}
	else {
//		Both are not null
		if(a.value!=b.value) {
			return false;
		}
		else {
			return((identical(a.left,b.left)) && identical(a.right,b.right));
		}
	}

}
}
