/**
 * 
 */

/**
 * @author shivangisingh
 *Assume that you have a method substring that checks if one word is a substring of another. 
 *Given two strings s1 and s2, write code to check if s2 is a rotation of s1 using only one call to substring
 *
 */
public class StringRotation {

	/**
	 * @param args
	 */
	
	
	public static boolean substring(String s1, String s2) {
		if(s1.length() < s2.length())
			return false;
		boolean isSub = false;
		int j = 0;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == s2.charAt(j))
				j++;
			else
				j = 0;
			if(j == s2.length()) {
				isSub = true;
				break;
			}
		}
		return isSub;
	}
	
	
	public static boolean isSubsting(String s1, String s2) {
		StringBuilder s1temp=new StringBuilder(s1);
		s1temp.append(s1).append(s1);
		return substring(s1temp.toString(),s2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isSubsting("waterbottle", "erbottlewat"));
		System.out.println(isSubsting("waterbottle", "zvb"));

	}

}
