import java.util.HashSet;

/**
 * 
 */

/**
 * @author shivangisingh
 *1) Remove Duplicates from an unsorterd LL
 *2) Delete Middle Node given only access to that node
 *3) Linked List is a palindrome?
 *4) Partition: Partition a linkedlist around a value x, such that 
 *all nodes smaller than x come before all nodes greater than x
 */
public class LinkedListProblems {

	/**
	 * @param args
	 */
	
	public static Node DeleteDuplicates(Node h) {
		HashSet<Integer> hset = new HashSet<Integer>();
		hset.add(h.getData());
		Node cur=h.getNext();
		Node prev=h;
		while(cur!=null) {
			if(hset.contains(cur.getData())) {
//				Delete the node
				prev.setNext(cur.getNext());
				cur=cur.getNext();
			}
			else {
				prev=prev.getNext();
				cur=cur.getNext();
			}
		}
		return h;
	}
	
	public static Node deletemid(Node n) {
//		You just copy the next nodes into it. This method wont 
//		work if the node is the last one.
		Node temp=n;
		Node prev = null;
		while(temp.getNext().getNext()!=null) {
			prev=temp;
			temp.setData(temp.getNext().getData());
			temp=temp.getNext();
		}
//		removing last one
		prev.setNext(null);
		return n;
		
	}
	
	
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
	
	public static boolean isPalin(Node n) {
//		Reverse and compare
		Node reverse=getReverse(n);
		Node tempindex=n;
		while(reverse!=null) {
			if(tempindex.getData()!=reverse.getData()) {
				return false;
			}
		}
		return true;
	}
	
	public static Node getReverse(Node n) {
		Node curr=n.getNext();
		Node rev= new Node(n.getData());
		while(curr!=null) {
			Node temp= new Node(curr.getData());
			temp.setNext(rev);
			rev=temp;
			curr=curr.getNext();
		}
		return rev;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n =new Node(1);
		Node temp=n;
		for(int i=1;i<6;i++) {
			Node m =new Node(i);
			temp.setNext(m);
			temp= temp.getNext();
		}
//		printll(n);
//		System.out.println();
		System.out.println(isPalin(n));
		printll(deletemid(n));
	}

}
