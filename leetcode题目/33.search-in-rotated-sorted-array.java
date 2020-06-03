/*
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.59%)
 * Total Accepted:    3.6K
 * Total Submissions: 11.1K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            boolean isLeftSorted = isSorted(nums, left, mid);
            boolean isRightSorted = isSorted(nums, mid, right);
            if(isLeftSorted && nums[left]<=target && target<nums[mid]){
                right = mid-1;
            }else if(isRightSorted && nums[mid]<target && target<=nums[right]){
                left = mid + 1;
            }else{
                if(isLeftSorted){ //左边排好序了，但是target不在[left mid)之间。要从右边找
                    left = mid + 1;
                }else{            //右边排好序了，但是target不在(mid right]之间。 从左边找
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    private boolean isSorted(int[] nums,int left,int right){
        if(nums[left]<nums[right] || left==right){
            return true;
        }else{
            return false;
        }
    }
}
