/**
 * Search in Rotated Array (medium) #
Given an array of numbers which is sorted in ascending order and also rotated by some arbitrary number, 
find if a given ‘key’ is present in it.

Write a function to return the index of the ‘key’ in the rotated array. 
If the ‘key’ is not present, return -1. 
You can assume that the given array does not have any duplicates.

Input: [10, 15, 1, 3, 8], key = 15
Output: 1
Explanation: '15' is present in the array at index '1'.

Input: [4, 5, 7, 9, 10, -1, 2], key = 10
Output: 4
Explanation: '10' is present in the array at index '4'.
*/

class SearchRotatedArray {

    public static int search(int[] arr, int key) {
      return binary_search(arr, key);
    }
  
    static int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            if(midValue == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]){
                // 左侧单调
                if(target >=nums[start] &&  midValue < target){
                    left = mid+1;
                }else if (midValue > target){
                    right = mid-1;
                }
            }else{
                // 右侧单调
                if(target <= nums[end] && midValue < target){
                    left = mid+1;
                }else if (midValue > target){
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
      System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
      System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
    }
  }
