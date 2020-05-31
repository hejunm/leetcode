/*
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (32.65%)
 * Total Accepted:    3.5K
 * Total Submissions: 10.6K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {nums.length,-1};
        searchRange(nums, target, 0, nums.length-1, range);
        if(range[0]>range[1]){
            range[0] = -1;
        }
        return range;
    }

    private void searchRange(int[] nums,int target,int left,int right,int[] range){
        if(left > right){
            return;
        }
        int mid = (right+left)/2;
        if(nums[mid]==target){
            if(mid < range[0]){
                range[0] = mid;
                searchRange(nums, target, left, mid-1, range);
            }
            if(mid>range[1]){
                range[1] = mid;
                searchRange(nums, target, mid+1, right, range);
            }
        }else if(nums[mid]<target){
            searchRange(nums, target, mid+1, right, range);
        }else{
            searchRange(nums, target, left, mid-1, range);
        }
    }
}
