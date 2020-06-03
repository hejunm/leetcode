class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        // 这里只需要判断fast.next.next。 但是当fast.next=null时，调用fast.next.next会报异常
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 当链表长度是奇数时，slow要右移一个
        if (fast.next != null) {
            slow = slow.next;
        }

        // slow 和 其后面的要反转
        ListNode tail = reverse(slow);
        while (head != null && tail != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    private ListNode reverse(ListNode root) {
        ListNode pre = root;
        ListNode current = root.next;
        pre.next = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }
}