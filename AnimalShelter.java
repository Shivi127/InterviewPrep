/**
 * 
 */

/**
 * @author shivangisingh
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis. 
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can 
 * select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). 
 * They cannot select which specific animal they would like. Create the data structures to maintain 
 * this system and implement opera- tions such as enqueue, dequeueAny, dequeueDog and dequeueCat. 
 * You may use the built-in LinkedList data structure.
 *
 */

class LL{
	String type; 
	String name;
	LL next;
	
	public LL(String type, String name) {
		this.name=name;
		this.type=type;
	}
}
public class AnimalShelter {

	/**
	 * @param args
	 */
//	Stores as LinkedList
	LL head;
	LL tail;
	public void enqueue(String type, String name) {
		LL n= new LL(type, name);
		if(head== null) {
			head=n;
			tail=n;
		}
		else {
			tail.next=n;
			tail=n;
		}
	}
	
	public LL dequeueAny() {
		if(head==null) {
			System.out.println("No pets are available");
			return null;
		}
		LL temp= head;
		if(head==tail) {
//			Only one element
			head=null;
			tail=null;
		}
		else {
			head=head.next;
		}
		return temp; 
	}
	
	public LL dequeueDog() {
		if(head==null) {
			System.out.println("No pets are available");
			return null;
		}
	
		
		LL temp= head;
		if(head.type.equalsIgnoreCase("dog")) {
			return(dequeueAny());
		}
		
		
		else {
			LL prev=null;
			while(temp!=null) {
				
				if(temp.type.equalsIgnoreCase("dog")){
//					remove this accordingly
					if(temp==tail) {
//						Removing Last Element
						tail=prev;
						prev.next=temp.next;
						return temp;}
					else {
						prev.next=temp.next;
						return temp;
					}
				}
//				inside the while loop
				prev=temp;
				temp=temp.next;
			}
		}//closing else
		System.out.println("No Dog Available");
		return temp; 
	}
	
	public LL dequeueCat() {
		if(head==null) {
			System.out.println("No pets are available");
			return null;
		}
	
		
		LL temp= head;
		if(head.type.equalsIgnoreCase("cat")) {
			return(dequeueAny());
		}
		
		
		else {
			LL prev;
			while(temp!=null) {
				prev=temp;
				if(temp.type.equalsIgnoreCase("cat")){
//					remove this accordingly
					if(temp==tail) {
//						Removing Last Element
						tail=prev;
						prev.next=temp.next;
						return temp;}
					else {
						prev.next=temp.next;
						return temp;
					}
				}
				temp=temp.next;
			}
			head=head.next;
		}
		System.out.println("No Cat Available");
		return temp; 
	}
	
//	Simpler Way where type stores cat or dog.
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalShelter a= new AnimalShelter();
		a.enqueue("Dog", "Sheru");
		a.enqueue("Dog", "Motu");
		a.enqueue("Dog", "Shii");
		a.enqueue("Cat", "Shiimo");
		a.enqueue("Cat", "Meow");
//		
		System.out.println(a.dequeueAny().name);
		System.out.println(a.dequeueDog().name);
		System.out.println(a.dequeueAny().name);
		System.out.println(a.dequeueCat().name);
		System.out.println(a.dequeueAny().name);
		System.out.println(a.dequeueAny().name);
	}

}
