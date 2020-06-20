/**
Palindrome LinkedList (medium) #

Given the head of a Singly LinkedList, 
write a method to check if the LinkedList is a palindrome or not.

Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished. 
The algorithm should have O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.

Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
Output: true

Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
Output: false
*/

class ListNode {
    int value = 0;
    ListNode next;
  
    ListNode(int value) {
      this.value = value;
    }
  }
  
  class PalindromicLinkedList {
  
    public static boolean isPalindrome(ListNode head) {
        //find middle node
        ListNode middle = findMiddle(head);
        //reverse the second
        ListNode second = reverse(middle);
        //compare
        boolean result = isSame(head, second);
        //恢复
        reverse(second);
        return result;
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head){
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

    public static boolean isSame(ListNode first, ListNode sectond){
        boolean result = true;
        while(sectond != null && first != null){
            if (first.value != sectond.value){
                result = false;
                break;
            }
            first = first.next;
            sectond = sectond.next;
        }
        return result;
    }
  
    public static void main(String[] args) {
      ListNode head = new ListNode(2);
      head.next = new ListNode(4);
      head.next.next = new ListNode(6);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(2);
      System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
  
      head.next.next.next.next.next = new ListNode(2);
      System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
  }