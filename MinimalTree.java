import java.util.ArrayList;

/**
 * 
 */

/**
 * @author shivangisingh
 *1) Minimal Tree- Given a sorted array (Increasing Order) with unique integer elements, write 
 *an algorithm to create a Binary Search Tree with minimal height.
 *
 *2) List of Depths: Given a Binary Tree, design an algorithm which 
 *creates a LinkedLisr of all nodes at each depth.
 *
 *3) Validate BST:- Implemet a function to check if a Binary Tree is a BST 
 *
 *4) Successor: Write an algorithm to find the next node of a given node in a BST. You may assume
 *that each node jas a link to its parent.
 */
class BNode{
		public int value;
		public BNode left;
		public BNode right;
		
		public BNode(int v) {
			this.value=v;
			left=null;
			right=null;
		}	
	}

public class MinimalTree {

	
	
	
	public static BNode makeMinTree (int[] a, int start, int end) {
		
		
		if(start>end) {
			return null;
		}
		
		int mid = (start+ end )/2;
		
		BNode b=  new BNode(mid);
		
		
//		Left Subtree
		b.left=makeMinTree(a, start, mid-1);
		b.right=makeMinTree(a,mid+1,end);
		
		return b;
		
	}
	
	
	public static ArrayList<Node> levelList(BNode b, int level, ArrayList<Node> a){
		if(b == null)
			return null;
		
//		Index of the arrayList is the level
		
		int value=b.value;
		Node n = new Node(value);
//		if something is at that level append to head else just add
		if(a.get(level)==null) {
			a.add(level, n);
		}
		
		else {
			n.setNext(a.get(level));
			a.add(level, n);
		}
		levelList(b.left,level +1,a);
		levelList(b.right,level+1,a);
		
		return a;
	}
	
	
	
	public static int isBalancecheck(BNode b) {
		if(b== null) {
			return 0;
		}
		else {
			int leftHeight= isBalancecheck(b.left) +1;
			int rightHeight=isBalancecheck(b.right) +1;
			
			if(rightHeight == -1 || leftHeight == -1) {
				return -1;
			}
			if(Math.abs((leftHeight-rightHeight))>1) return -1;
			else return (Math.max(leftHeight,rightHeight)+1);
		}
		
	}
	
	public static boolean isBalanced(BNode b) {
		if(isBalancecheck(b)<0) {
			return false;
		}
		return true;
	}
	
	
	public static boolean isBST(BNode b, int lb, int ub) {
//		Assuming that all inputs are unique
//		lb= lower bound
//		ub= upper bound
//		O(n) as we look at all the nodes
		/* We can also do this by doing inorder transveral and then checking) Which
		 * will require O(n) space.
		 * Also just left.value<=b.value and right.value >b.value wont work in all cases 
		 * Eg:      10
		 * 		/ 		\
		 * 	  0			25
		 *   / \			/ \
		 * -1  21      16  32
		 */
		
		if(b==null)
			return true;
		
		if(b.value<= lb || b.value >ub )
			return false;
		
		return (isBST(b.left,lb,b.value) && isBST(b.right,b.value,ub));
	}
	
	
	
	
	public BNode getSuccessorOf(BNode n, int d) {
//		This function finds the node
/*		Case 1: if the node has a right subtree:
 * 			    Then  just return the leftmost value in the subtree
 * 		Case 2: if there is no right subtree: Traverse up till you find the node which is a left child of its parent.
 * 				Notable case is when you have traversed all the way up and still not found a node who is a left child of it's 
 * 				parent then return Null?
*/
		
		if(n== null) {
			return null;
		}
		if(n.value<d) {
//			Traverse Left
			return(getSuccessorOf(n.left,d));
		}
		else if(n.value>d) {
//			Traverse Right
			return(getSuccessorOf(n.right,d));
		}
		
		if(n.value == d) {
			return n;
		}
	}
	
	public BNode Succesor(BNode n) {
		if(n==null) {
			return null;
		}
		if(n.right!= null) {
//			Case 1:
			BNode rightchild=n.right;
			while(rightchild.left!=null) {
				rightchild=rightchild.left;
			}
			return rightchild;
		}
		else {
//			Case 2:
//			Suppose that parent stores a link to the parent node.
			BNode parent= n.Parent;
			BNode parent_parent=parent.Parent;
			
			while(parent!=parent_parent.left || parent_parent.Parent != null) {
				parent=parent_parent;
				parent_parent=parent.Parent;
			}
			if(parent==parent_parent.left) {
				return parent;
			}
			else 
				return null;
				
			
			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {4,5,6,78,102,509};
		BNode b=makeMinTree(a, 0, a.length-1);
		ArrayList<Node> a2=  new ArrayList<Node>();
		a2= levelList(b,0,a2);
		
	}

}
