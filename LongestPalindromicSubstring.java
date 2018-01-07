/**
 * 
 */

/**
 * @author shivangisingh
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
 * 
 * Manacher's Algorithm
 *
 */
public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */
	
	
//	Do not pick a character in the palindrome 
//	if it is already contained in the palindrome or current palindrome expands till the end
//	Or if the palindrome expands till right edge and its mirror palindrome is prefix
//	Expand if	
	
	
	
	
	
	
	
	public static int longestPalinSubstringNaive(String s) {

//		In this method we cannot return the string just the max length
		int longest_substring=1;
		for(int i=0;i<s.length();i++) {
			int cur=i;
			int cright=i+1;
			
			int palindrome=0;
			
//			Handles Even Cases
			while(cur>=0 && cright <s.length() && s.charAt(cur)== s.charAt(cright)) {
				cur--;
				cright++;
				palindrome+=2;
			}
			
			longest_substring =Math.max(longest_substring, palindrome);
			cur=i-1;
			cright=i+1;
			palindrome=1;
//			Handles Odd cases.
			
			while(cur>=0 && cright <s.length() && s.charAt(cur)== s.charAt(cright)) {
				cur--;
				cright++;
				palindrome+=2;
			}
			
			longest_substring =Math.max(longest_substring, palindrome);
			
		}
		return longest_substring;
		
	}
	


//	As done through Dynamic Programming
	public static int dpmethod(char[] s) {
		boolean a[][]= new boolean[s.length][s.length];
		int maxlength=1;
//		Diagonal should be true as one character is its palindrome.
		for(int i=0;i<s.length;i++) {
			a[i][i]=true;
			}

		for(int i=0;i<s.length-2;i++) {
			if(s[i]==s[i+1]) {
				a[i][i+1]=true;
				maxlength=2;
			}
		}
		
		
		for(int l=2;l<s.length;l++) {
//			Starting from second position
			System.out.println("Value of L" +l);
			int length=0;
			
			for(int i=0;i<s.length-l;i++) {
				int j=i+l;
				System.out.println("Value of i,j  " +i + "  "+j);
				if(l==2) {
					System.out.println("In l==2");
					if(s[i]== s[j]) {
						a[i][j]=true;
						length=2;
					}
				}
				else {
					if(s[i]== s[j] && a[i+1][j-1]) {
						a[i][j]=true;
						length=j-i+1;
					}
					if(length>maxlength)
						maxlength=length;
				}

			}
		}
		return maxlength;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(dpmethod("babcbaabcbaccba".toCharArray()));
		
	}

}
