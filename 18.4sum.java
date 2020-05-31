import java.util.ArrayList;
import java.util.Arrays;

import com.sun.tools.javac.code.Attribute.Array;

/*
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (28.08%)
 * Total Accepted:    171.4K
 * Total Submissions: 610.4K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<4){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){ //nums[i] is too large
                break;
            }
            if(nums[i] + nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3] < target){//nums[i] is too small
                continue;
            }
            if(i>0 && nums[i]==nums[i-1]){  //跳过重复项
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2] > target){   //nums[j] is too large
                    break;
                }
                if(nums[i]+nums[j]+nums[nums.length-1] + nums[nums.length-2] < target){ // nums[j] is too small
                    continue;
                }
                if(j>i+1 && nums[j]==nums[j-1]){    //跳过重复项
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
