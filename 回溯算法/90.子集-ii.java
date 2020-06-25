import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
/**
 * 1, 排序
 * 2, 遍历时去重
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int subSetSize = 0; subSetSize <= nums.length; subSetSize++) {
            LinkedList<Integer>trackList = new LinkedList<>();
            backtrack(nums, subSetSize, 0, trackList, result);
        }
        return result;
    }

    private void backtrack(int[] nums, int subSetSize, int start, LinkedList<Integer>trackList, List<List<Integer>> result){
        if(trackList.size() == subSetSize){
            result.add(new LinkedList(trackList));
            return;
        }
        for (int i = start; i < nums.length;) {
            trackList.add(nums[i]);
            backtrack(nums, subSetSize, i+1, trackList, result);
            trackList.removeLast();
            do{
                i++;
            }while(i < nums.length && nums[i-1] == nums[i]); 
        }
    }
}
// @lc code=end

