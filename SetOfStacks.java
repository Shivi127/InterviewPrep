/**
 * 
 */
import java.util.ArrayList;
import java.util.Stack;
/**
 * @author shivangisingh
 *
 */
public class SetOfStacks {

	/**
	 * @param args
	 */
	private int size;
	private ArrayList<Stack<Integer>> ss= new ArrayList<Stack<Integer>>();
	
	
	public SetOfStacks(int v) {
		size=v;
		ss.add(new Stack<Integer>());
	}
	
//	push
	public void push (int v) {
		Stack<Integer> lastStack = getLastStack();
		if(lastStack.size()==size) {
//			Create a new stack and add to ss and then add the element to that 
			Stack<Integer> s= new Stack<Integer>();
			s.push(v);
			ss.add(s);
			
		}
		else {
		lastStack.push(v);}
	}
	public Stack<Integer> getLastStack(){
		int last=ss.size()-1;
		return ss.get(last);
	}
	
	public int pop() {
		if(ss.size()==0) {
			System.out.println("Nothing has been added yet");
			return -1;
		}
		Stack<Integer> lastStack = getLastStack();
		int temp= lastStack.pop();
		

		if(lastStack.isEmpty()) {
			ss.remove(ss.size()-1);
		}
		return temp;
	}

	public int peek() {
		if(ss.size()==0) {
			System.out.println("Nothing has been added yet");
			return -1;
		}
		Stack<Integer> lastStack = getLastStack();
		int temp= lastStack.peek();
		return temp;
	}
	
	public int popAt(int index) {
//		number of the stack in the set of stacks
		if(ss.size()==0) {
			System.out.println("Nothing has been added yet");
			return -1;
		}
		Stack<Integer> lastStack = ss.get(index-1);
		int temp= lastStack.pop();
		

		if(lastStack.isEmpty()) {
			ss.remove(ss.size()-1);
		}
		return temp;
	}
//	peak
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetOfStacks s= new SetOfStacks(2);
		for(int i=0;i<13;i++)
			s.push(i);
		System.out.println(s.pop());
		System.out.println("Pop at 2nd" +s.popAt(2));
	}

}
