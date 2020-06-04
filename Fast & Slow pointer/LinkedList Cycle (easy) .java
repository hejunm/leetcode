
/**
LinkedList Cycle (easy)

Given the head of a Singly LinkedList, 
write a function to determine if the LinkedList has a cycle in it or not.

//类似题目：
判断是否有环，如果有环 计算出环的长度
*/
class ListNode {
    int value = 0;
    ListNode next;
  
    ListNode(int value) {
        this.value = value;
    }
}
  
public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }   
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
