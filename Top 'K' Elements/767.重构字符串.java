import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : S.toCharArray())
          charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
    
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
            (e1, e2) -> e2.getValue() - e1.getValue()
        );
        maxHeap.addAll(charFrequencyMap.entrySet());

        StringBuilder resultString = new StringBuilder();
        Map.Entry<Character, Integer> previousEntry = null;
        while(maxHeap.isEmpty() == false){
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            resultString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue()-1);

            if (previousEntry != null && previousEntry.getValue() > 0){
                maxHeap.offer(previousEntry);
            }
            previousEntry = currentEntry;
        }
        if(resultString.length() == S.length()){
            return resultString.toString();
        }else{
            return "";
        }
    }
}
// @lc code=end

