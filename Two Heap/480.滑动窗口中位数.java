import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=480 lang=java
 *
 * [480] 滑动窗口中位数
 * 
 * 双堆
 * 
 */

// @lc code=start
class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //大于中位数
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((i1, i2)-> i2-i1); //小于中位数
   
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            balanceHeaps();

            if (i - k + 1 >= 0) { 
                if (maxHeap.size() == minHeap.size()) {
                    result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else { 
                    result[i - k + 1] = maxHeap.peek();
                }

                int elementToBeRemoved = nums[i - k + 1];
                if (elementToBeRemoved <= maxHeap.peek()) {
                    maxHeap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }
                balanceHeaps();
            }
        }
        return result;
    }

    private void balanceHeaps() {
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }
}
// @lc code=end

