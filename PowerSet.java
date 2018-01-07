/**
 * 
 */

/**
 * @author shivangisingh
 *Power Set Power set P(S) of a set S is the set of all subsets of S.
 * For example S = {a, b, c} then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}.
 */
public class PowerSet {

	/**
	 * @param args
	 */
final static int num=26;
static char[] characterArray= new char[num];
static int[] count= new int[num];

	public static void pset(String s) {

		for( int i=0;i<s.length();i++) {
			int index= s.charAt(i)-65;
			count[index]++;
		}
		
		for( int i=0;i<num;i++) {
			characterArray[i]=(char)('A'+i);
		}
		
		char[] result= new char[s.length()];
		pset(characterArray, count,0,result,0);
	}
	public static void pset(char[] input, int[] count, int pos, char[] output, int level) {
//		Base Case print an empty Set
		printit(output,level);
		
		for(int i=pos;i<input.length;i++) {
			if(count[i]==0)
				continue;
			else {
//				Add to the result array 
//				System.out.println(input[i]+"    Inside Input");
				output[level]=input[i];
//				System.out.println(output[level]+"    Inside Output");
				count[i]--;
				pset(input,count,i,output,level+1);
				count[i]++;
			}
		}
		
	}
	
	public static void printit(char[] result, int end) {
//		System.out.println("I am in the Print it");
		for(int i=0;i<end;i++) {
//			System.out.println("I am in the Print it loop");
			System.out.print(result[i]+" ");
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pset("SHI");

	}

}
