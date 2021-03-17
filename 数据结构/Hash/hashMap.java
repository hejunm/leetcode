/*
 * @lc app=leetcode.cn id=706 lang=java
 *
 * [706] 设计哈希映射
 */
class MyHashMap {
    final ListNode[] nodes = new ListNode[10000];

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashCode = customHashCode(key);
        if(nodes[hashCode]==null){
            nodes[hashCode] = new ListNode(-1, -1);
        }
        ListNode pre = findPreNodeOf(nodes[hashCode], key);
        if(pre.next != null){
            pre.next.val = value;
        }else{
            pre.next = new ListNode(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashCode = customHashCode(key);
        if(nodes[hashCode]==null){
            return -1;
        }
        ListNode pre = findPreNodeOf(nodes[hashCode], key);
        if(pre.next == null){
            return -1;
        }else{
            return pre.next.val;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashCode = customHashCode(key);
        if(nodes[hashCode]==null){
            return;
        }
        ListNode pre = findPreNodeOf(nodes[hashCode], key);
        if(pre.next != null){
            pre.next = pre.next.next;
        }
    }

    private int customHashCode(int key){
        return key % nodes.length;
    }

    //找到k对应节点的前一个
    private ListNode findPreNodeOf(ListNode bucket,int k){
        ListNode node = bucket;
        ListNode pre = null;
        while(node!=null && node.key!=k){
            pre = node;
            node =  node.next;
        }
        return pre;
    }

    class ListNode{
        int key,val;
        ListNode next;

        ListNode(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
}
