import java.awt.Point;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * 
 */

/**
 * @author shivangisingh
 *Given an array of tuples find the k closest ones.
 */
public class KClosestPoints {

	/**
	 * @param args
	 */
	

	public static void closest(Point[] points, int k) {

		double dis=0.0;
		TreeMap<Double, Point> m= new TreeMap<Double, Point>();
		for(Point p: points) {
			dis= Math.sqrt((p.x)^2 + (p.y)^2);
			m.put(dis, p);
		}
		
//		Printing the k smallest elements
		int i=1;
		for(Point p: m.values()) {
			if(i>k)
				break;
			else {
				System.out.println("Coordinates are "+ p.x + " "+ p.y);
				i++;
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] p= new Point[9];
		for(int i=0;i<=5;i++) {
			p[i]=new Point(1,i);
		}
		p[6]=new Point(-1,8);
//		p[7]=new Point(-6,-8);
		p[7]=new Point(0,0);
		p[8]=new Point(1,-2);
		
		closest(p,4);
	}

}
