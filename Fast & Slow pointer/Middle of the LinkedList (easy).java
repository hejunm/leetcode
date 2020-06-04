/**
Middle of the LinkedList (easy)

Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
If the total number of nodes in the LinkedList is even, return the second middle node.

Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
Output: 3

Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
Output: 4

Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
Output: 4
*/

class ListNode {
    int value = 0;
    ListNode next;
  
    ListNode(int value) {
      this.value = value;
    }
  }
  
  class MiddleOfLinkedList {
  
    public static ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
  
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
  
      head.next.next.next.next.next = new ListNode(6);
      System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
  
      head.next.next.next.next.next.next = new ListNode(7);
      System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
    }
  }