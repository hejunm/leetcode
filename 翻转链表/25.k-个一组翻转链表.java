import MyHashMap.ListNode;

/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k <= 1){
            return head;
        }

        ListNode current = head;
        ListNode tail = null;
        for (int i = 1; i <= k && current!=null; i++) {
            if (i == k){
                tail = current;
            }
            current = current.next;
        }
        if(tail == null){
            return head;
        }

        ListNode nextGroupHead = tail.next;
        ListNode[] revertResult = revertList(head, tail);
        revertResult[1].next = reverseKGroup(nextGroupHead, k);
        return revertResult[0];
    }

    /**
     * 翻转链表 startNode-> ... -> endNode 
     * return [endNode, startNode]
     * */
    private ListNode[] revertList(ListNode startNode, ListNode endNode){
        ListNode preNode = null;
        ListNode currentNode = startNode;
        while(preNode!=endNode){
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
       return new ListNode[]{endNode, startNode};
    }
}
// @lc code=end

