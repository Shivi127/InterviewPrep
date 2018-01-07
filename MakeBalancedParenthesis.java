/**
 * 
 */

/**
 * @author shivangisingh
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of
 *  well-formed parentheses.


 *
 */
public class MakeBalancedParenthesis {

	/**
	 * @param args
	 */
	
	public static void makeParenthesis(int n) {
		if(n<=0) {
			System.out.println("Not a valid value for n");
		}
		char[] s= new char[100];
		System.out.println("Calling Function");
		makeParenthesis(s,0,0,0,n);
		System.out.println("Function has retuned");
	}
	
	public static void makeParenthesis(char[] s,int pos, int left, int right, int n) {
		if(left == n && right == n) {
			for(int i=0;i<s.length-1;i++)
                System.out.print(s[i]);
		}
		else {
//			Two things to keep in mind left>= right and we can only add a right if left is there
			if(left<=n) {
				s[pos]='{';
				makeParenthesis(s,pos+1,left+1,right,n);
			}
			if(right<left) {
				s[pos]='}';
				makeParenthesis(s,pos+1,left,right+1,n);
			}
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeParenthesis(3);
	}

}
