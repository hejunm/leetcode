import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * [39] Combination Sum
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (58.38%)
 * Total Accepted:    3.4K
 * Total Submissions: 5.8K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
    private void getResult(List<List<Integer>> result,List<Integer>current,int candidates[],int target,int start){
        if(target>0){
            for(int i=start;i<candidates.length && target>=candidates[i];i++){
                current.add(candidates[i]);
                getResult(result, current, candidates, target - candidates[i], i);
                current.remove(current.size()-1);
            }
        }else if(target==0){
            result.add(new ArrayList<>(current));
        }
    }
}
