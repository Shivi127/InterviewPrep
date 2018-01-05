import java.util.HashMap;

/**
 * 
 */

/**
 * @author shivangisingh
 * Given a Binary tree, how would you find the vertical sum of the binary tree.
 *
 */
public class VerticalSumOfBinaryTree {

	/**
	 * @param args
	 */
	
	public void verticalsum(Node n, HashMap<Integer,Integer> m, int level) {
//		n represents the node
		if(n==null) {
			return;
		}
		else {
			//TraverseLeft
			if(m.containsKey(level)) {
				int sum=m.get(level)+n.getData();
			}
			else {
//				when the key doesn't exist then you just add
				m.put(level, n.getData());
			}
			
			verticalsum(n.getLeft(),m,level-1);
			
//			TeaverseRight
			verticalsum(n.getRight(),m,level+1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> m= new HashMap<Integer,Integer>();
//		assuming n is the Binary Tree Passed.
		verticalsum(n,m,0);
//		Then just traverse the map to print the values
		
		for(Integer level:m.keySet()) {
			System.out.println("The Sum at Level"+ level+ "is " + (int)m.get(level));
		}
		
	}

}
