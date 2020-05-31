/*
 * [47] Permutations II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (44.22%)
 * Total Accepted:    2.1K
 * Total Submissions: 4.8K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums==null || nums.length==0){
            return resultList;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrace(resultList,new ArrayList<>(),nums,used);
        return resultList;
    }

    private void backTrace(List<List<Integer>> resultList,List<Integer>tempList,int[] nums,boolean[] used){
        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));
        }else{
            for(int i=0;i<nums.length;i++){
                if(used[i]){
                    continue;
                }
                if(i>0 && nums[i-1]==nums[i] && used[i-1]==false){
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backTrace(resultList,tempList,nums,used);
                used[i] = false;
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
