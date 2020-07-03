import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 */
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer>frequencyMap = new HashMap<>();
        char[] sChars = s.toCharArray();
        for (char var : sChars) {
            frequencyMap.put(var, frequencyMap.getOrDefault(var, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((e1,e2)-> e2.getValue()-e1.getValue());
        maxHeap.addAll(frequencyMap.entrySet());

        StringBuilder sb = new StringBuilder();
        while (maxHeap.isEmpty() == false) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}

