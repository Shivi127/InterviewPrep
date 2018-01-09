/**
 * 
 */

/**
 * @author shivangisingh
 * ThreeInOne: How can you use a single array to implement 3 stacks
// * Method 1: In which you have a definite size stack
 */
public class ThreeStacks {

	/**
	 * @param args
	 */
	
static //	Fixed Size
	int[] array;
	static int[] currindex=new int[3];
	static int s1start;
	static int s2start;
	static int s3start;
	static int s1end;
	static int s2end;
	static int s3end;
	public ThreeStacks(int n) {
//		N is the array size
		array =new int[n];
		s1start=0;
		s2start=n/3;
		s3start=2*n/3;
		s1end=n/3-1;
		s2end=2*n/3-1;
		s3end=n-1;
		currindex[0]= -1;
		currindex[1]=s2start-1;
		currindex[2]=s3start-1;
		
	}
		
	public static void push(int n, int value) {
//		if (n==1)
		if(n==1) {
			if(currindex[0]<=s1end) {
				array[currindex[0]+1]=value;
				currindex[0]++;
			}
			else {
				System.out.println("Strack1 is full");
			}
		}
		
		if(n==2) {
			if(currindex[1]<=s2end) {
				array[currindex[1]+1]=value;
				currindex[1]++;
			}
			else {
				System.out.println("Strack2 is full");
			}
		}
		if(n==3) {
			if(currindex[2]<=s3end) {
				array[currindex[2]+1]=value;
				currindex[2]++;
			}
			else {
				System.out.println("Strack3 is full");
			}
		}
	}
	public static int pop(int n) {
		
		if(n==1) {
			if(currindex[0]<s1start) {
				System.out.println("Stack 1 is empty");
				return -1;
			}
			else {
				int val=currindex[0];
				currindex[0]--;
				return val;
			}
		}
		if(n==2) {
			if(currindex[1]<s2start) {
				System.out.println("Stack 2 is empty");
				return -1;
			}
			else {
				int val=currindex[1];
				currindex[1]--;
				return val;
			}
		}
		if(n==3) {
			if(currindex[2]<s3start) {
				System.out.println("Stack 3 is empty");
				return -1;
			}
			else {
				int val=currindex[2];
				currindex[2]--;
				return val;
			}
		}
//		IN Non valid case
		return -1;
		}
		

	public static boolean isEmpty(int n) {
		if(n==1) {
			if(currindex[n-1]<s1start) {
				return true;
			}
			else return false;
		}
		else if(n==2) {
			if(currindex[n-2]<s2start) {
				return true;
			}
			else return false;
		}
		if(n==3) {
			if(currindex[n-3]<s3start) {
				return true;
			}
			else return false;
		}
//		Doesnt exist 
		return false;
	}
	
	
	
	public static int peek(int n) {
		if(n==1) {
			if(currindex[0]<s1start) {
				System.out.println("Stack 1 is empty");
				return -1;
			}
			else {
				int val=array[currindex[0]];
				return val;
			}
		}
		else if(n==2) {
			if(currindex[1]<s2start) {
				System.out.println("Stack 2 is empty");
				return -1;
			}
			else {
				int val=array[currindex[1]];
				return val;
			}
		}
		else if(n==3) {
			if(currindex[2]<s3start) {
				System.out.println("Stack 3 is empty");
				return -1;
			}
			else {
				int val=array[currindex[2]];
				return val;
			}
		}
//		if n >3 or <1
		else return -1;
	}
//	public static int getSize(int n) {
//		
//		if(n==1) {
//			if(s1end-currindex[0])
//		}
//		
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeStacks t= new ThreeStacks(9);
		t.push(1,4);
		t.push(2, 5);
		System.out.println(t.peek(1));
		System.out.println(t.pop(3));
		
	}

}
