//https://leetcode-cn.com/explore/learn/card/hash-table/203/design-a-hash-table/799/
class MyHashSet {

    private int buckets = 1000;
    private int itemsPerBuckets = 1001;
    private boolean[][] table;

    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new boolean[buckets][];
    }
    
    public int hash(int key){
        return key%buckets;
    }

    public int pos(int key){
        return key/buckets;
    }

    public void add(int key) {
        int hashKey = hash(key);
        if(table[hashKey] == null){
            table[hashKey] = new boolean[itemsPerBuckets];
        }
        table[hashKey][pos(key)] = true;
    }
    
    public void remove(int key) {
        int hashKey = hash(key);
        if(table[hashKey] != null){
            table[hashKey][pos(key)] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashKey = hash(key);
        return table[hashKey]!=null && table[hashKey][pos(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */