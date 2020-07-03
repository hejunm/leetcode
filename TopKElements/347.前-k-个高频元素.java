import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
 
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer>frequentMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>>minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((e1,e2)-> e1.getValue() - e2.getValue());
        
        for (int i = 0; i < nums.length; i++) {
            frequentMap.put(nums[i],  frequentMap.getOrDefault(nums[i], 0)+1);
        }
        
        for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
              minHeap.poll();
            }
        }

        //返回值
        int[] result = new int[minHeap.size()];
        Iterator<Map.Entry<Integer, Integer>> iterator = minHeap.iterator();
        int i = 0;
        while (iterator.hasNext()){
            result[i++] = iterator.next().getKey();
        }
        return result;
    }
}
// @lc code=end

