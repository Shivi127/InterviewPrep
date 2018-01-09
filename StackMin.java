/**
 * 
 */

/**
 * @author shivangisingh
 *
 */
public class StackMin {
	
	
	/**
	 * @param args
	 */
	private class LLNode{
		private int value;
		private LLNode next;
		private LLNode oldMax;
		private LLNode oldMin;
	}
	
	
	private static LLNode stack;
	private static LLNode max=null;
	private static LLNode min=null;
//	Default Constructor 
	public StackMin() {}
	
	public static void push(int value) {
		
		LLNode n= new LLNode();
		n.value=value;
		if(stack==null)
			stack=n;
		else {
			n.next=stack;
			stack=n;
		}
//		Update Max and Min
//		Case Max:
		if(max == null||n.value > max.value) {
			n.oldMax=max;
			max=n;
		}
//		Case Min
		if(max == null||n.value < min.value) {
			n.oldMin=min;
			min=n;
		}
	}
	
	
	
	
	public static int pop() {
		if(stack== null) {
			throw new NullPointerException();
		}
		
		else {
			int val= stack.value;
			LLNode n=stack;
			stack=stack.next;
			
//			Update Max
			if(n.oldMax!=null) {
				max=n.oldMax;
			}
//			Update Min
			if(n.oldMin!=null) {
				min=n.oldMin;
			}
		}
	}
	
	public int getMax() {
		if(max==null)
			throw new NullPointerException();
		return max.value;
	}
	public int getMin() {
		if(min==null)
			throw new NullPointerException();
		return min.value;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
