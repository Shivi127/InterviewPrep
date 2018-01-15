import java.util.Random;



/**
 * @author shivangisingh
 * Random Node: You are implementing a Binary Tree class from scratch which, in 
 * addition to insert, find and delete has a method getRandomNode() which returns a random node
 * from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm for getRandomNode,
 * and explain how you would implement the rest of the methods.
 * 
 * 
 * We make the nodes have the number of children it has, and then use Binary search to avoid O(n) worst case.
 *
 */
class CNode{
		CNode left;
		CNode right;
		int val;
		int children;
		private CNode root;
		
		public void addNode(int val) {}
		public void deleteNode(int val) {}
		
		public int getRandomNode() {
			if(root== null) throw new NullPointerException();
			Random r= new Random();
			int count= r.nextInt(root.children+1);
			return getRandomNode(root,count);
		}
		
//		Helper Method - Overloading
		private int getRandomNode(CNode curr, int count) {
//			Determine if we are at the node to be return
			
			if(count == getChildren(curr.left)) {
				return curr.val;
			}
			
			if(count < getChildren(curr.left))
				return getRandomNode(curr.left,count);
			else
				return getRandomNode(curr.right,count-getChildren(curr.left)-1);
			
			
		}
		
		private int getChildren(CNode n) {
			if(n== null) 
				return 0;
//			+1 as index starts at 0
			return n.children+1;
		}
	}

