import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Set<Integer> trackSet =  new HashSet<>();
        LinkedList<Integer> trackList = new LinkedList<>();
        backtrack(nums, result, trackSet, trackList);
        return result;
    }

    /**
     * trackSet:  已遍历数字集合
     * trackList: 已遍历数字列表
    */
    private void backtrack(int[] nums, List<List<Integer>> result, Set<Integer>trackSet, LinkedList<Integer> trackList){
        if(trackList.size() == nums.length){
            result.add(new LinkedList(trackList));
            return;
        }
        for (int currentNum : nums) {
            if(trackSet.contains(currentNum)){
                continue;
            }
            trackSet.add(currentNum);
            trackList.add(currentNum);

            backtrack(nums, result, trackSet, trackList);
            
            trackSet.remove(currentNum);
            trackList.removeLast();
        }
    }
}
// @lc code=end

