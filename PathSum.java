import java.util.Stack;

/**
 * @author shivangisingh
 * Path Sum: You are given a binary tree in which each node is an integer value(which might be positive or negative). 
 * Design an algorithm to count the number of paths that sum to a given value. The path does not need to start or end at the root or a leaf, but 
 * must go downward. (traveling from parent to node.)
 *
 */
public class PathSum {

//	1) Path sum should include the root.
	
	static Stack<Integer> s= new Stack<Integer>();
	static int sum=0;
	
	public static void printPathFromRoot(BNode n, int k) {
		if(n==null) {
			return;
		}
//		Inorder traversal into a stack.
		
		sum=sum+n.value;
		s.push(n.value);
		
		if(sum == k) {
			printStack(s);
		}
		
		printPathFromRoot(n.left,k);
		printPathFromRoot(n.right,k);
		int d= s.pop();
		sum-=d;
	}
	
	
	public static void printStack(Stack<Integer> s) {
		Stack<Integer> temp= (Stack<Integer>) s.clone();
		
		for(int i=0;i<s.size();i++) {
			System.out.print(temp.pop()+ " ");
		}
		System.out.println("");
	}
	
	
	
	
	
	public int countPathWithSum(BNode root, int target) {
		if(root == null) return 0;
		
		int nfromroots= countPathWithSumFromNode(root, target,0);
		
		int nLeft=countPathWithSum(root.left,target);
		int nRight=countPathWithSum(root.right,target);
		
		return nfromroots+nLeft+nRight;
		
	}
	
	
	
	private int countPathWithSumFromNode(BNode root, int target, int csum) {
		// TODO Auto-generated method stub
		if(root == null)
			return 0;
		
		csum+=root.value;
		
		int numberofpaths=0;
		if(target == csum)
			numberofpaths++;
		
		numberofpaths+=countPathWithSumFromNode(root.left,target,csum);
		numberofpaths+=countPathWithSumFromNode(root.right,target,csum);
		return numberofpaths;
	}
	


	public static void main(String[] args) {
		BNode n= new BNode(11);
		BNode m= new BNode(1);
		BNode o= new BNode(4);
		BNode p= new BNode(8);
		n.left=m;
		m.left=o;
		m.right=p;
		
		printPathFromRoot(n,12);
	}
}
