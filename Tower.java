import java.util.Stack;

/**
 * 
 */

/**
 * @author shivangisingh
 * Tower of Hanoi
 *
 */
public class Tower {
private Stack<Integer> disks;
private int index;
public Tower(int i) {
	index=i;
}

public int index() {
	return index;
}

public void add(int d) {
	if(!disks.isEmpty() && disks.peek() <=d) {
		System.out.println("Error placing Disk");
	}
	else
	disks.push(d);
}

public void moveTopTo(Tower t) {
	int top=disks.pop();
	t.add(top);
}

public void moveDisks(int n, Tower destination, Tower buffer) {
	if(n>0) {
		moveDisks(n-1,buffer,destination);
		moveTopTo(destination);
		buffer.moveDisks(n-1, destination, this);
	}
}

public static void main(String[] args) {
	int n=3;
	Tower[] t= new Tower[3];
	for(int i=0;i<3;i++) {
		t[i]=new Tower(i);
	}
	
	for(int j=n-1;j>=0;j--) {
		System.out.println(j);
		t[0].add(j);
	}
	
	t[0].moveDisks(n, t[2], t[1]);
}
}
