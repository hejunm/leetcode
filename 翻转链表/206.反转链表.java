

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode preNode = null;
//         while(head!=null){
//             ListNode nextNode = head.next;
//             head.next = preNode;
//             preNode = head;
//             head = nextNode;
//         }
//         return preNode;
//     }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

