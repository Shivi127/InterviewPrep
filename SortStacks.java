import java.util.Stack;

/**
 * 
 */

/**
 * @author shivangisingh
 *Sort Stacks:Write a program to sort a stack such that the smallest items are on the top.
 *You can use an additional temporary stack, but you may not copy the elements into any other
 *data structures.
 */
public class SortStacks {

	/**
	 * @param args
	 */
	
	public static Stack<Integer> sortStack(Stack<Integer> s) {
		
		if(s.isEmpty()||s==null) {
//			empty stack is always sorted
			return s;
		}
		else {
			Stack<Integer> temp= new Stack<Integer>();
			temp.push(s.pop());
			while(!s.isEmpty()) {
				int top=s.pop();
				while(!temp.isEmpty()&& top>temp.peek() ) {
					s.push(temp.pop());
				}
				temp.push(top);
			}
			return temp;
		}
	}
	
	
	public static void printstack(Stack<Integer>s) {
		System.out.println("I am in stack Print");
		if(s== null || s.isEmpty()) {
			System.out.println("The Stack is null or empty");
		}
		while(!s.isEmpty()) {
			System.out.print(s.pop()+ " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s= new Stack<Integer>();
		s.push(1);
		s.push(5);
		s.push(2);
		s=sortStack(s);
		printstack(s);
	}

}
