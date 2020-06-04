/**
Start of LinkedList Cycle (medium)

计算入环节点
*/
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

public class LinkedListCycleStart {

  public static ListNode findCycleStart(ListNode head) {
    ListNode nodeInCycle = findOneNodeInCycle(head);
    int length = findCycleLength(nodeInCycle);
    return findCycleStart(head, length);
  }

  /**
   * 从链表的环中获取一一个节点。
   * @param 
   * head 列表头结点
   * @return 
   * Node or null if hasn't cycle
  */
  private static ListNode findOneNodeInCycle(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    while(fast!=null && fast.next!=null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow){
            return fast;
        }
    }
    return null;
  }

  /**
   * 获取有环链表 环的长度
  */
  private static int findCycleLength(ListNode node){
      int length = 0;
      ListNode current = node;
      do{
        length++;
        current = current.next;
      }while(current != node);
      return length;
  }

  private static ListNode findCycleStart(ListNode head, int cycleLength){
      ListNode fastPoint = head;
      ListNode slowPoint = head;
      while(cycleLength > 0){
        fastPoint = fastPoint.next;
        cycleLength--;
      }
      while(fastPoint != slowPoint){
        fastPoint = fastPoint.next;
        slowPoint = slowPoint.next;
      }
      return fastPoint;
  } 



  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
  }
}