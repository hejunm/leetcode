/**
Rearrange a LinkedList (medium) #

Given the head of a Singly LinkedList, 
write a method to modify the LinkedList such that the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order. 
So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, 
your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.

Your algorithm should not use any extra space and the input LinkedList should be modified in-place.

Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null 

Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
*/


class ListNode {
    int value = 0;
    ListNode next;
  
    ListNode(int value) {
      this.value = value;
    }
  }
  
  class RearrangeList {
  
    public static void reorder(ListNode head) {
        if (head == null || head.next == null)
            return;
        //find middle
        ListNode middle = findMiddle(head);
        //revert second
        ListNode second = reverse(middle);
        //merge
        merge(head, second);  
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head){
        ListNode node = head;
        ListNode preNode = null;
        while(node != null){
            ListNode next = node.next;
            node.next = preNode;
            preNode = node;
            node = next;
        }
        return preNode; 
    }

    private static void merge(ListNode first, ListNode second){
        
        while(first!=null && second!=null){
            ListNode temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
        // set the next of the last node to 'null'
        if (first != null)
            first.next = null;
    }
  
    public static void main(String[] args) {
      ListNode head = new ListNode(2);
      head.next = new ListNode(4);
      head.next.next = new ListNode(6);
      head.next.next.next = new ListNode(8);
      head.next.next.next.next = new ListNode(10);
      head.next.next.next.next.next = new ListNode(12);
      RearrangeList.reorder(head);
      while (head != null) {
        System.out.print(head.value + " ");
        head = head.next;
      }
    }
  }