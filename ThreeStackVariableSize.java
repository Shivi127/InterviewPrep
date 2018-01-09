import java.util.Arrays;

/**
 * 
 */

/**
 * @author shivangisingh
 * Three Stack Implementation: Variable Size implementation
 */
public class ThreeStackVariableSize {

	/**
	 * @param args
	 */
//	Stores the index of the last entered element for the respective stacks
	int[] topOfStack;
//	Stores data
	int[] stackData;
//	Stores the next available position also previous
	int[] nextIndex;
	int nextAvailable=0;
	
//	Constructor
	public ThreeStackVariableSize(int n, int capacity) {
		topOfStack=new int[n];
		Arrays.fill(topOfStack, -1);
		 stackData=new int[capacity];
		 nextIndex=new int[capacity];
		 
		 for(int i=0;i<capacity-1;i++) {
			 nextIndex[i]=i+1;
		 }
		 nextIndex[capacity-1]=-1;
	}
	
	public void push(int n, int value) {
//		n is the stack number
//		Check if the stack number is Vaild or not.
		if(n<0||n>topOfStack.length) {
			throw new IndexOutOfBoundsException();
		}
		if(nextAvailable <0) {
//			fail with print
			System.out.println("No more space on the stacks. Please try again");
		}
//		 Index where you will add the passed value
		int currentIndex=nextAvailable;
		nextAvailable=nextIndex[currentIndex];
		stackData[currentIndex]=value; 
		nextIndex[currentIndex]= topOfStack[n-1];
		topOfStack[n-1]=currentIndex;
	}
	
	
	public int pop(int n) {
		
		if(n<0||n>topOfStack.length) {
			throw new IndexOutOfBoundsException();
		}
		
		if(topOfStack[n-1]==-1) {
			System.out.println("The Stack is empty");
			return -1;	
		}
		
		else {
			int currentIndex=topOfStack[n-1];
			int value= stackData[currentIndex];
			topOfStack[n-1]=nextIndex[currentIndex];
			nextIndex[currentIndex]=nextAvailable;
			nextAvailable= currentIndex;
			return value;
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeStackVariableSize s= new ThreeStackVariableSize(2,3);
		System.out.println(s.pop(1));
		s.push(1, 5);
		System.out.println(s.pop(1));
		System.out.println(s.pop(1));
	}

}
