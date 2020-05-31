/*
 * [46] Permutations
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (61.27%)
 * Total Accepted:    4.3K
 * Total Submissions: 7K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backTrace(resultList,new ArrayList<>(),nums);
        return resultList;
    }

    private void backTrace(List<List<Integer>> resultList,List<Integer>tempList,int[] nums){
        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));
        }else{
            for(int i=0;i<nums.length;i++){
                if(tempList.contains(nums[i])){
                    continue;
                }
                tempList.add(nums[i]);
                backTrace(resultList,tempList,nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
