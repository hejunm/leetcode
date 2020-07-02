import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=703 lang=java
 *
 * [703] 数据流中的第K大元素
 */
class KthLargest {
    //使用小根堆
    PriorityQueue <Integer> minHeap = new PriorityQueue<Integer>();
    private int k;
    private int currentSize = 0;

    public KthLargest(int k, int[] nums) {
        this.k= k;
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            currentSize++;
            if(currentSize>k){
                minHeap.poll();
                currentSize--;
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        currentSize++;
        if(currentSize > k){
            minHeap.poll();
            currentSize--;
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

