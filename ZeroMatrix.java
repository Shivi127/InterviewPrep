import java.util.HashSet;

/**
 * 
 */

/**
 * @author shivangisingh
 *Write an algorithm such that if an element in an N*M matrix is 0, its entire row and column is set too
 */
public class ZeroMatrix {

	/**
	 * @param args
	 */

	
	public static void printMatrix(int [][] matrix) {
		for(int i=0;i<matrix.length;i++ ) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void zeroit(int[][] matrix) {
		HashSet<Integer> row= new HashSet<Integer>();
		HashSet<Integer> col= new HashSet<Integer>();
		for(int i=0;i<matrix.length;i++ ) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==0) {
//					Storing the row and columns that need to be made 0
					row.add(i);
					col.add(j);
				}
			}
		}
		
		for(int i=0;i<matrix.length;i++ ) {
			for(int j=0;j<matrix[0].length;j++) {
				if(row.contains(i)|| col.contains(j)) {
					matrix[i][j]=0;
				}
			}
		}
		
		printMatrix(matrix);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m= {{1,2,0},{12,39,9}};
		zeroit(m);

	}

}
