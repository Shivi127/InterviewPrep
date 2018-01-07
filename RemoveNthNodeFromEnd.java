/**
 * 
 */

/**
 * @author shivangisingh
 * Given a linked list, remove the nth node from the end of list and return its head.
 */
public class RemoveNthNodeFromEnd {

	
	
	public static Node removenth(Node head, int index) {
		int size= getsize(head);
		System.out.println("Size is "+size);
		return removenth(head, size, index);
				
	}
	public static Node removenth(Node head, int size, int index) {
		Node current= head;
		for( int i=0;i<size-index-1;i++)
			current=current.getNext();
		System.out.println("Current Data "+current.getData());
		current.setNext(current.getNext().getNext());
		return head;
	}
	
	public static int getsize(Node head) {
		Node temp=head;
		int size=0;
		while(temp!=null) {
			temp=temp.getNext();
			size++;
		}
		return size;
	}

	public static void printll(Node head) {
		if(head == null) {
			System.out.println("Empty List");
		}
		
		Node v=head;
		while(v!=null) {
			System.out.println(v.getData() + " ");
			v=v.getNext();
		}
	}
	
	public static void main(String[] args) {
		
		Node n =new Node(0);
		Node temp=n;
		
//		Creating a linked list
		for(int i=1;i<8;i++) {
			Node m =new Node(i);
			temp.setNext(m);
			temp= temp.getNext();
		}
//		printll(removed);
		
		Node removed=removenth(n,3);
		printll(removed);
		
		
		
	}
}
