/**
 * 
 */

/**
 * @author shivangisingh
 *Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfSortedArrays {
	
	public double MedianFinder(int[] a1, int[] a2) {
//		going to use Binary Search
//		Let us assume that a1 is the smaller array
		int x=a1.length;
		int y=a2.length;
		
		
		boolean found=false;
		int start=0;
		int end=x;
		int maxleftX,minrightX,maxleftY,minrightY;
//		So if we are partitioning the arrays like 
//		a1[]= partioned on partitionX
//		a2[]=partitioned on partitionY
//		| partioned
//		a1= . . . maxLeftX | minRightX. . .
//		a2= . . . maxLeftY | minRightY. . .
		
		while(start<=end) {
			int partX=start+end/2; 
			int partY=((x+y+1)/2)-partX;
//			Edge cases 
			
			
//			If We have partitioned with no elements on the left side in the array.
			maxleftX= (partX==0)? Integer.MIN_VALUE: a1[partX-1];
//			We have partitioned with no elements on the right hand side
			minrightX=(partX==x)? Integer.MAX_VALUE: a1[partX];
			
			maxleftY= (partY==0)? Integer.MIN_VALUE: a1[partY-1];
			minrightY=(partY==y)? Integer.MAX_VALUE: a1[partY];
			
//			Binary Search Part
			if(maxleftX<=minrightY && maxleftY<=minrightX) {
//				then we have almost found the median 
				if((x+y)%2==0) {
//					Even number of elements 
//					Median = Avg(max(maxLeftX,maxLeftY)+min(maxRightX,maxRightY));
					double median = (Math.max(maxleftX, maxleftY) +Math.min(minrightX,minrightY))/2;
					return median;
				}
				else {
					return ((double)Math.max(maxleftX, maxleftY));
				}
				
			}
			
			else if(maxleftX>minrightY) {
//				You are too far on the right of partX. Move Left
				end= partX-1;
			}
			
			else {
				start=partX+1;
			}
		}
//		if the arrays were not sorted this will not work
		throw new IllegalArgumentException();
	}

}
