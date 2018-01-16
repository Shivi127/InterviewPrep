/**
 * 
 */

/**
 * @author shivangisingh
 *
 */
class Position{
		int row, col;
		Position(int row, int col){
			this.row=row;
			this.col=col;
		}
	}
public class NQueens {

	/**
	 * @param args
	 */
	
	public static Position[] solveNQueens(int n) {
		Position[] positions = new Position[n];
		boolean hasSolution= solveNQueens(n,0,positions);
		if(hasSolution) return positions;
		return null;
	}
	
	public static boolean solveNQueens(int n, int row, Position[] p) {
		if(n== row)
			return true;
		
		int col;
		for(col=0;col<n;col++) {
			boolean safestate=true;
			
//			Check if this row, col is under attack
			for(int q=0;q<row;q++) {
				if(p[q].col == col || p[q].row-p[q].col == row- col || 
						p[q].row +p[q].col ==row+col) {
					safestate=false;
				}
			}
			if(safestate) {
				Position j=new Position(row,col);
				p[row]=j;
				if(solveNQueens(n,row+1,p)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Position[] x= solveNQueens(8);
		for(int i=0;i<x.length;i++) {
			System.out.println(x[i].row + " "+x[i].col);
		}
	}

}
