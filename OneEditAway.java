import java.util.HashMap;

/**
 * 
 */

/**
 * @author shivangisingh
 * One Edit Away: There are three types of edits that can be performed on strings: Insert, remove or replace a character.
 * Given two strings, write a function to check if they are one edit away.
 */
public class OneEditAway {

	/**
	 * @param args
	 */
	
//	Two HashMaps?
	
	public static boolean EditOk(String s1, String s2) {
		
		if(Math.abs(s1.length()-s2.length())>=2) {
//			If length is different more than 2 then obviously you are not one distance away
			return false;
		}
		
		int[] c1=new int[26];
		int[] c2=new int[26];
		
		for(int i=0;i<s1.length();i++) {
			c1[s1.charAt(i)-65]+=1;
			}
		for(int i=0;i<s2.length();i++) {
			c2[s2.charAt(i)-65]+=1;
			}
		int diff = 0;
		for(int i=0;i<26;i++) {
			if(c1[i]!=c2[i]) {
				diff++;
				if(diff>1) {
					return false;
				}
			}
		}
		return true;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(EditOk("HIEEE","H"));
	}

}
