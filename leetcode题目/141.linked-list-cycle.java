import java.util.HashSet;

/*
 * [141] Linked List Cycle
 *
 * https://leetcode.com/problems/linked-list-cycle/description/
 *
 * algorithms
 * Easy (34.81%)
 * Total Accepted:    279K
 * Total Submissions: 801.3K
 * Testcase Example:  '[]\nno cycle'
 *
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * 
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while(head != null){
            if(nodeSet.contains(head)){
                return true;
            }else{
                nodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
