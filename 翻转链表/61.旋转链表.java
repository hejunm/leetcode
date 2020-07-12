/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        int i = 0;
        while(fast.next != null){ //获取长度
            i++;
            fast = fast.next;
        }

        ListNode slow = dummy;
        for (int j=i-k%i;j>0;j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; 
        dummy.next=slow.next;
        slow.next=null;
        
        return dummy.next;
    }
}

