/**
 * @author shivangisingh
 * Three Step Problem: A child is running up a staircase with n steps and can hop either 1,2,3 steps at
 * a time. Implement a method in how many possible ways can the child run up the stairs.
 *
 */
public class ThreeStepProblem {
//	Think of this as a similar problem to the Fibonacci one at
//	step 1 is 1 way
//	step 2 there are 2 ways
//	step 3 there are 4 ways to get there

	public static int naiveways(int n) {
		if(n<0) {
			return 0;
		}
		else if(n==0) {
			return 1;
		}
		else {
			return (naiveways(n-1)+naiveways(n-2)+naiveways(n-3));
		}
	}

	
	public static long dpways(int n) {
//		skipping the 0th index;
//		Base cases to handle IndexOutOfBounds
		switch(n) {
			case 0: return 0;
			case 1: return 1;
			case 2: return 2;
			}

		long[] dp= new long [n+1];
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
//		starting from the 4th step
		for(int i=4;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		return dp[n];
		
	}

public static void main(String[]args) {
	
	
	System.out.println("The number of ways to transverse 1 step"+ naiveways(1));
	System.out.println("The number of ways to transverse 2 steps" + naiveways(2));
	System.out.println("The number of ways to transverse 3 steps" + naiveways(3));
	System.out.println("The number of ways to transverse 4 steps" + naiveways(4));
	System.out.println("The number of ways to transverse 5 steps" + naiveways(5));
	
	System.out.println();
	
	System.out.println("The number of ways to transverse 1 step"+ dpways(1));
	System.out.println("The number of ways to transverse 2 steps" + dpways(2));
	System.out.println("The number of ways to transverse 3 steps" + dpways(3));
	System.out.println("The number of ways to transverse 4 steps" + dpways(4));
	System.out.println("The number of ways to transverse 5 steps" + dpways(5));
}
}