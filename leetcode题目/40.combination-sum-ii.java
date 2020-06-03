/*
 * [40] Combination Sum II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (48.65%)
 * Total Accepted:    2.5K
 * Total Submissions: 5.1K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void getResult(List<List<Integer>> result,List<Integer>current,int candidates[],int target,int start){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<candidates.length && target>=candidates[i];i++){
            current.add(candidates[i]);
            getResult(result, current, candidates, target - candidates[i], i+1);
            current.remove(current.size()-1);
            while(i<candidates.length-1 && candidates[i]==candidates[i+1]){ //不是最后一个 & 连续相同
                i++;
            }
        }
    }
}
