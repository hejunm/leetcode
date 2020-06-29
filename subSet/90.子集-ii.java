import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {

    /**
     * 排列组合
     * 如果连续连个数组相同， 跳过可以产生相同子集的
    */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;
            if(i>0 && nums[i] == nums[i-1]){
                startIndex = endIndex+1;
            }
            endIndex = result.size()-1;
            for (int j = startIndex; j <= endIndex; j++) {
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }

    /**
     * 回溯法
     * 1, 排序
     * 2, 遍历时去重
    */
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
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

