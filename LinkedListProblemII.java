



/**
 * @author shivangisingh
 *5) Partition a LL around a value c such that all nodes smaller than x 
 *come before all the nodes bigger than x.
 *6) Given two linked List Find the Intersection 
 *7) Cycle Detection in a LL:
 */
public class LinkedListProblems {

	/**
	 * @param args
	 */
	
	
	
	public static void printll(Node head) {
		if(head == null) {
			System.out.println("Empty List");
		}
		
		Node v=head;
		while(v!=null) {
			System.out.print(v.getData() + " ");
			v=v.getNext();
		}
	}

	
	public static Node orderLL(Node n, int x) {
		Node smaller=null;
		Node larger=null;
		Node current=n;
		
		while(current!=null) {
			if(current.getData()<x) {
				Node temp=new Node (current.getData());
				temp.setNext(smaller);
				smaller=temp;
			}
			else {
			Node temp=new Node (current.getData());
			temp.setNext(larger);
			larger=temp;
			}
			current=current.getNext();
		}
		
		Node tempsmaller=smaller;
		Node prev = null;
		while(tempsmaller!=null) {
			prev=tempsmaller;
			tempsmaller=tempsmaller.getNext();
		}
		prev.setNext(larger);
		return smaller;
		
	}
	
	
	
	public static int getSize(Node n) {
		int count=0;
		if(n==null)
			return 0;
		
		Node temp=n;
		while(temp!=null) {
			count++;
			temp=temp.getNext();
		}
		return count;
	}
	
	
	public static boolean findIntersection(Node n1, Node n2) {
		if(n1==n2) {
			return true;
		}
		int n1size=getSize(n1);
		int n2size=getSize(n2);
		int diff=0;
		Node n1temp=n1;
		Node n2temp=n2;
		if(n1size>n2size) {
			diff= n1size-n2size;
			for(int i=0;i<diff;i++) {
				n1temp=n1temp.getNext();
			}
		}
		else {
			diff=n2size-n1size;
			for(int i=0;i<diff;i++) {
				n2temp=n2temp.getNext();
			}
			}
		
		while(n1temp!=null) {
			if(n1temp==n2temp) {
				return true;
			}
			n1temp=n1temp.getNext();
			n2temp=n2temp.getNext();
		}		
		return false;
	}
	
	
	public static Node cycle(Node head) {
		Node slow= head;
		Node fast=head;
		boolean cycle=false;
		do {
			fast=fast.getNext().getNext();
			slow=slow.getNext();
		}while(fast!=slow & slow.getNext()!=null);
		return fast;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n =new Node(1);
		Node temp=n;
		Node cycles=null;
		for(int i=1;i<6;i++) {
			Node m =new Node(i);
			temp.setNext(m);
			cycles=temp;	
			temp= temp.getNext();
		}
		
		Node m= new Node(9);
//		cycles.setNext(n.getNext());
//		System.out.println(isPalin(n));
//		printll(n);
		
//		System.out.println();
		
		System.out.println(cycle(n));
		
//		System.out.println(findIntersection(n,m));
	}

}
