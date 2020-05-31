class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode preNode = null;
        if(head==null || n<=0){ //数据有效性
            return null;
        }
        for(int i=0;i<n-1;i++){
            if(fastNode.next != null){ //n 无效
                fastNode = fastNode.next;
            }else{
                return null;
            }
        }

        while(fastNode.next != null){
            fastNode = fastNode.next;
            preNode = slowNode;
            slowNode = slowNode.next;
        }
        if(slowNode==head){
            head = head.next;
        }else{
            preNode.next = preNode.next.next;
        }
        return head;
    }
}