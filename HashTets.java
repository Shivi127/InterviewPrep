import java.util.Scanner;

/**
 * 
 */

/**
 * @author shivangisingh
 *Testing the implememtation
 */
public class HashTets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		        Scanner scan = new Scanner(System.in);
		        System.out.println("Hash Table Test\n\n");
		        System.out.println("Enter size"); 
		        /* Make object of HashTable */
		        HashTable htcsll = new HashTable(scan.nextInt() );
		 
		        char ch;
		        /*  Perform HashTableChainingSinglyLinkedList operations  */
		        do    
		        {
		            System.out.println("\nHash Table Operations\n");
		            System.out.println("1. insert ");
		            System.out.println("2. remove");
		            System.out.println("3.  size"); 
		            System.out.println("5. check empty");
		 
		            int choice = scan.nextInt();            
		            switch (choice)
		            {
		            case 1 : 
		                System.out.println("Enter integer element to insert");
		                htcsll.HashValue( scan.nextInt() ); 
		                break;                          
		            case 2 :                 
		                System.out.println("Enter integer element to delete");
		                htcsll.remove( scan.nextInt() ); 
		                break;                        
		            case 3 : 
		      
		                System.out.println("Size = "+ htcsll.getSize() );
		                break; 
		            case 5 : 
		                System.out.println("Empty status = "+ htcsll.isEmpty() );
		                break;        
		            default : 
		                System.out.println("Wrong Entry \n ");
		                break;   
		            }
		            /* Display hash table */ 
		            
		 
		            System.out.println("\nDo you want to continue (Type y or n) \n");
		            ch = scan.next().charAt(0);                        
		        } while (ch == 'Y'|| ch == 'y');  

	}

}
