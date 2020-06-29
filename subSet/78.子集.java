import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
/**
 * 方法1：
 * []
 * [] [1]
 * [] [1]   [2] [1 2]
 * [] [1]   [2] [1 2],  [3] [1 3] [2 3] [1 2 3]
 * 
 * 方法2: 回溯法
 * 
 * 子问题：给定一个数组nums 和 整数subSetSize，返回数组所有 大小为subSetSize的 子集。
 * 这个子问题与77题相似，简单修改下就可以用。
 * for(subSetSize in [0 nums.lengh]){
 *     求出subSetSize对应组合， 放在一起就是所求结果了
 * }
 * 
 * [1,2,3]为例：
 * subSetSize=0：[]
 * subSetSize=1：[1],[2],[3]
 * subSetSize=2: [1,2], [1,3], [2,3]
 * subSetSize=3: [1,2,3]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int currentLevelSize = result.size();
            for (int j = 0; j < currentLevelSize; j++) {
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(num);
                result.add(newList);
            }
        }
        return result;
    }

    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> result = new LinkedList<>();
    //     for (int subSetSize = 0; subSetSize <= nums.length; subSetSize++) {
    //         LinkedList<Integer>trackList = new LinkedList<>();
    //         backtrack(nums, subSetSize, 0, trackList, result);
    //     }
    //     return result;
    // }

    // private void backtrack(int[] nums, int subSetSize, int start, LinkedList<Integer>trackList, List<List<Integer>> result){
    //     if(trackList.size() == subSetSize){
    //         result.add(new LinkedList(trackList));
    //         return;
    //     }
    //     for (int i = start; i < nums.length; i++) {
    //         trackList.add(nums[i]);
    //         backtrack(nums, subSetSize, i+1, trackList, result);
    //         trackList.removeLast();
    //     }
    // }
}
// @lc code=end

