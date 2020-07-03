/***
 Given an array of numbers and a number ‘K’, 
 we need to remove ‘K’ numbers from the array such that we are left with maximum distinct numbers.

 Example 1:
Input: [7, 3, 5, 8, 5, 3, 3], and K=2
Output: 3
Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8], we have 
to skip 5 because it is not distinct and occurred twice. 
Another solution could be to remove one instance of '5' and '3' each to be left with three 
distinct numbers [7, 5, 8], in this case, we have to skip 3 because it occurred twice.

Example 2:
Input: [3, 5, 12, 11, 12], and K=3
Output: 2
Explanation: We can remove one occurrence of 12, after which all numbers will become distinct. Then 
we can delete any two numbers which will leave us 2 distinct numbers in the result.
*/

import java.util.*;

class MaximumDistinctElements {

    public static int findMaximumDistinctElements(int[] nums, int k) {
        int maximumDistinct = 0;
        if(nums.length <= k){
            return maximumDistinct;
        }

        Map<Integer, Integer>frequentMap = new HashMap<>();
        for (int num : nums) {
            frequentMap.put(num, frequentMap.getOrDefault(num, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2)-> e1.getValue()-e2.getValue());
        
        Set<Map.Entry<Integer, Integer>> set  = frequentMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            if(entry.getValue() == 1){
                maximumDistinct++;
            }else{
                minHeap.add(entry);
            }
        }

        //删除k
        while(k>0 && !minHeap.isEmpty()){
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            k-=(entry.getValue()-1);
            if(k >= 0){
                maximumDistinct++;
            }
        }
        
        if(k>0){
            maximumDistinct-=k;
        }

        return maximumDistinct;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}