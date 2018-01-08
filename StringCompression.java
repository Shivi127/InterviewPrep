/**
 * 
 */

/**
 * @author shivangisingh
 * Implement a method to perform basic string compression using the counts of repeated characters. 
 * For example aabcccccaaa would be a2b1c5a3. If the compressed string would not become smaller than the 
 * original string.
 */
public class StringCompression {

	/**
	 * @param args
	 */
	
	public static String compressString(String s) {
		StringBuilder stemp=new StringBuilder();
		int count=1;
		for(int i=0;i<s.length();i++) {
			if(i==s.length()-1) {
//				then dont compare next ok
				stemp.append(s.charAt(i)).append(count);
			}
			else {
				if(s.charAt(i)==s.charAt(i+1)) {
					count++;
				}
				else {
					stemp.append(s.charAt(i)).append(count);
					count=1;
				}
			}
		}
		
		if(stemp.length()==(2*s.length())) {
			return s;
		}
		return stemp.toString();
	}
	public static void main(String[] args) {
		System.out.println(compressString("aabcccccaaa"));
		System.out.println(compressString("abcd"));
	}

}
