import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 * 
 * 将数据分为两部分 ， 分别存在大根堆和小根堆。
 * 两堆的size差 < 1
 * 大根堆： 小于中位数
 * 小根堆： 大于中位数
 * 
 * 
 */

// @lc code=start
class MedianFinder {
    PriorityQueue<Integer>minHeap; // 大的一部分
    PriorityQueue<Integer>maxHeap; // 小的一部分
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>((i1, i2) -> i1-i2);
        maxHeap = new PriorityQueue<Integer>((i1, i2) -> i2-i1);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.offer(num);
            return;
        }

        if(num <= maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if(maxHeapSize - minHeapSize > 1){
            minHeap.offer(maxHeap.poll());
        }else if (minHeapSize - maxHeapSize > 1){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if(maxHeapSize < minHeapSize){
            return minHeap.peek();
        }else if(maxHeapSize > minHeapSize){
            return maxHeap.peek();
        }else{
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

