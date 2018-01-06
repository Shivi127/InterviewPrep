/**
 * 
 */

/**
 * @author shivangisingh
 * A magic Index in an array A[0....n-1] is defined to be an index such that A[i]=i. Given a sorted array
 *  write a method to find a magic index, if one exists in an array A
 *
 */
public class MagicIndex {
	
	public int magicIndexBF(int[] a) {
		for(int i=0;i<a.length;i++) {
			if(i==a[i])
				return i;
		}
		return -1;
	}
	
	
	
// But why did they mention that the array is sorted?
		public static int magicIndexBinary(int [] a) {
			 return magicIndexBinary(a,0,a.length);
		 }
		 public static int magicIndexBinary(int [] a, int start, int end) {
			 int mid= (start+end)/2;
			 if(mid== a[mid]) {
				 return mid;
			 }
			 else if (a[mid]>mid) {
//				 then we recurse on left
				 return magicIndexBinary(a,start,mid-1);
			 }
			 else if (a[mid]<mid)
				 return magicIndexBinary(a,mid+1,end);
			 
			 else return -1;
		 }

		 
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			int[] A = { -1, 0, 1, 2, 4, 10 };
			System.out.println("Magic index " + magicIndexBinary(A));
			}
		
}

