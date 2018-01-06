import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 */

/**
 * @author shivangisingh
 * Imagine a robot sitting on the upper left corner of the grid
 * with r rows and c columns. The robot can only move in two directions, right and
 * down but certain cells are off limits such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom right
 * 
 * 
 * 
 * [(n-1,n-1) ........(n-1,0),
 *   ..................(0,0)]
 *
 */
public class RobotProblem {
	
	public ArrayList<Point> getPath(boolean[][] board){
//		Basic case if board doesnt exist
		if(board.length==0 || board==null || board[0][0]==false) {
			return null;
		}
//		for storing points or coordinates
		ArrayList<Point> p = new ArrayList<Point>();
//		board.length-1 - row of the piece 
//		board[0].length-1 = column of the piece
		HashSet<Point> failedPoints= new HashSet<Point>();
		if(getPath(board,board.length-1,board[0].length-1,p,failedPoints)) {
			return p;
		}
		return null;
	}
	
	
	public boolean getPath(boolean[][] board, int row, int col, ArrayList<Point> p, HashSet<Point> failedPoints){
		
//		Case1: that we dont find a path 
//		we have traversed all the points, secondly it could be that the board coordinate is blocked
		if(board[row][col]==false || row<0|| col <0 || failedPoints.contains(new Point(row,col))) {
			return false;
		}
		else {
			boolean there_yet= (row==0)&&(col==0); //reached the final destination
			if(there_yet||getPath(board,row-1,col,p,failedPoints)||getPath(board,row,col-1,p,failedPoints)) {
//				add the point to the path
				Point points= new Point(row,col);
				p.add(points);
				return true;
				
			}
		}
		failedPoints.add(new Point(row,col));
		return false;
	}
	
	
	
	
	
	
	

}
