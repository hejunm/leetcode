import MyHashMap.ListNode;

/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * 将链表分为三部分：
 * part1 （可能为空）
 *  startOfPart1
 *  endOfPart1
 * part2 （翻转）
 *  startOfPart2
 *  endOfPart2 
 * part3 
 *  startOfPart3
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n){
            return head;
        }

        // part1
        ListNode startOfPart1 = null;
        ListNode endOfPart1 = null;

        ListNode preNode = null;
        ListNode currentNode = head;
        for (int i = 1; i <= m-1; i++) {
            if(i==1){
                startOfPart1 = currentNode;
            }
            if(i==m-1){
                endOfPart1 = currentNode;
            }
            preNode = currentNode;
            currentNode = currentNode.next;
        }

        // part2
        ListNode startOfPart2 = null;
        ListNode endOfPart2 = null;
        for (int i = m; i <= n; i++) {
            if(i==m){
                startOfPart2 = currentNode;
            }
            if (i==n){
                endOfPart2 = currentNode;
            }

            ListNode next = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = next;
        }

        // part 3
        ListNode startOfPart3 = null;
        if(currentNode != null){
            startOfPart3 = currentNode;
        }

        ///连接
        if(endOfPart1 != null){
            endOfPart1.next = endOfPart2;
        }
        startOfPart2.next = startOfPart3;

        if(startOfPart1 != null){
            return startOfPart1;
        }else {
            return endOfPart2;
        }
    }
}
// @lc code=end

