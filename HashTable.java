/**
 * 
 */

/**
 * @author shivangisingh
 *
 *Design and implement a hashtable that uses Chaining to handle collisions
 */

class Node{
	private int data;
	private Node next;

	public Node(int data){
		this.data= data;
		next=null;
	}

	public int getData(){
		return data;
	}

	public void setData(int d){
		this.data=d;
	}

	public Node getNext(){
		return next;
	}

	public void setNext(Node n){
		next=n;
	}

}
public class HashTable {
	
	Node[] a;
	private int size;
	private int hashasize;
	
	public HashTable(int size) {
//		empty hash;
		this.size=0;
		 a=new Node[size];
		 hashasize=size;
	}
	
	public int getHashCode(int n) {
//		returns an int- index in the array
//		could be generic but for now we are limiting ourself to the type defined by data
//		Some Cool Hash function: but let us make an ineffiecient one
		return (n%hashasize);
		
	}
	
//	Now let us think about the collisions and adding stuff.
	public void HashValue(int val) {
//		Get hash Val = index
//		check if something is at that position then chain at the beginning
//		increment size that stores the number of elements in the hash?
		Node temp=new Node(val);
		int hashindex=getHashCode(val);
		
		if(a[hashindex]==null) {
			a[hashindex]=temp;
		}
		
		else {
			temp.setNext(a[hashindex]);
			a[hashindex]=temp;		
		}
		size++;
	}
	
	public void remove(int val) {
//		removing a value from the table
//		Find Hash
//		Iterate through the chained LL
//		Manage removal and return the appropriate;
		int index= getHashCode(val);
		if(a[index]== null) {
			System.out.print("Value was not in the node");
		}
		else {
			boolean found =false;
				Node tempp=a[index];
//				should have current or previous?
//				or we can be checking .next so for that we need to check the first one
				if(a[index].getData()==val) {
					a[index]=a[index].getNext();
					size--;
					}
				
				while(tempp.getNext()!=null && found== false) {
					if(tempp.getNext().getData()==val) {
						tempp.setNext(tempp.getNext().getNext());
						size--;
						found= true;
					}
//					move pointer if not found
					tempp=tempp.getNext();
			}
		}
	} //closing the remove function
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size==0);
	}
}
