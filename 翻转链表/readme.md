# 翻转链表

* 通过改变链表节点的next指针 达到翻转链表的目的。限制条件：原地翻转，不能新建节点。

## 模板

```java
public ListNode reverseList(ListNode head) {
    ListNode preNode = null;
    ListNode currentNode = head;
    while(currentNode!=null){
        ListNode nextNode = currentNode.next;
        currentNode.next = preNode;
        preNode = currentNode;
        currentNode = nextNode;
    }
    return preNode;
}
```

## 题目
