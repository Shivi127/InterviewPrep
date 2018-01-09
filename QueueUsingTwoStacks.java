import java.util.Stack;

/**
 * 
 */

/**
 * @author shivangisingh
 *
 */
public class QueueUsingTwoStacks {

	/**
	 * @param args
	 */
	
	static Stack<Integer> s1=new Stack<Integer>();
	static Stack<Integer> s2=new Stack<Integer>();
	
	public static void push(int val) {
//		s1 for pushing
		s1.push(val);
	}
	public static int pop() {
		
		if(s1.empty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		int val=s2.pop();
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		return val;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingTwoStacks q=  new QueueUsingTwoStacks ();
		q.push(11);
		q.push(3);
		System.out.println(q.pop());
		q.pop();
		System.out.println(q.pop());

	}

}
