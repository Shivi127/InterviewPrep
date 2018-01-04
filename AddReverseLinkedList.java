// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddReverseLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode *head1=l1;// creating pointers to head of the two list 
        ListNode *head2=l2;
        ListNode addList= new ListNode();
        ListNode *curr=addList;
        int temprem=0;
        int tempsum=0;
        while (head1!=null&&head2!=null){
          //while there are more nodes we add the values.
          tempsum= head1.getval()+head2.getval()+temprem;
          //have to check if the number is greater than 9
          if(temp >9){
            temprem= temp/10;
            tempsum= temp%10;
          }
          //add to list 
          ListNode tempNode= new ListNode(tempsum);
          tempNode.setnext()=null;
          curr.setnext()=tempNode;
          curr=tempNode;
          tempsum=0;
          head1=head1.getnext();
          head2=head2.getnext();
        }//ending the while loop
        
        if(head1!=null){
          //we still have elements
          tempsum=head1.getval()+temprem;
          ListNode tempNode= new ListNode(tempsum);
          tempNode.setnext()=null;
          tempsum=0;
          curr.setnext()=tempNode;
          curr=tempNode;
          head1=head1.getnext();
        }
        else if(head2!=null){
          //we still have elements
          tempsum=head2.getval()+temprem;
          ListNode tempNode= new ListNode(tempsum);
          tempNode.setnext()=null;
          tempsum=0;
          curr.setnext()=tempNode;
          curr=tempNode;
          head2=head2.getnext();
        }
        if (temprem!=0)
        {
          //we still have a carry over left
          ListNode tempNode= new ListNode(tempsum);
          tempNode.setnext()=null;
          curr.setnext()=tempNode;
          curr=tempNode;
        }
        return addList;
    }
}
