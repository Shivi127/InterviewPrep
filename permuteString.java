/**
 * 
 */

/**
 * @author shivangisingh
 * This program/ function finds all the permutations of a string of characters.
 * However I have made a few assumptions that all the characters are UpperCase alphabets.
 * Else Number of Characters = 256
 *
 */
public class permuteString {
final static int num=26;
char[] characterArray= new char[num];
int[] count= new int[num];


public void printResult(char[] c) {
	for(int i=0;i<c.length;i++)
		System.out.print(c[i]);
	System.out.println();
}


	public void PrintPermutations(String s) {
//		Step 1: Find the count of all characters
		
		for( int i=0;i<s.length();i++) {
			int index= s.charAt(i)-65;
			count[index]++;
		}
		
		for( int i=0;i<num;i++) {
			characterArray[i]=(char)('A'+i);
		}
		
		char[] result= new char[s.length()];
		permute(characterArray,count, result, 1);
	}
	
	public void permute(char[] chararray,int[] count,char[] result,int level) {
//		Base case you have filled the level 
		if(level==result.length) {
			printResult(result);
		}
		
		
		else {
			
			for( int i=0;i<num;i++) {
				
				if(count[i]==0) {
					continue;
				}
				result[level]=chararray[i];
				count[i]--;
				permute(chararray,count,result,level);
				count[i]++;	
			}
			
		}
	}
}
