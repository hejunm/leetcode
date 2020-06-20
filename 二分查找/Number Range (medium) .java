/**
 Number Range (medium)

 Given an array of numbers sorted in ascending order, find the range of a given number ‘key’. 
 The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
 Write a function to return the range of the ‘key’. 
 If the ‘key’ is not present return [-1, -1].

Input: [4, 6, 6, 6, 9], key = 6
Output: [1, 3]

Input: [1, 3, 8, 10, 15], key = 10
Output: [3, 3]

Input: [1, 3, 8, 10, 15], key = 12
Output: [-1, -1]

分别找出 左右位置
*/

class FindRange {

    public static int[] findRange(int[] arr, int key) {
      int[] result = new int[] { -1, -1 };
      result[0] = left_bound(arr, key);
      result[1] = right_bound(arr, key);
      return result;
    }


static int left_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    // 退出条件：left = right+1
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] == target) {
            // 别返回，锁定左侧边界
            right = mid - 1;
        }
    }
    // 最后要检查 left 越界的情况
    if (left >= nums.length || nums[left] != target)
        return -1;
    return left;
}


static int right_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    // 退出条件：right = left-1
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] == target) {
            // 别返回，锁定右侧边界
            left = mid + 1;
        }
    }
    // 最后要检查 right 越界的情况
    if (right < 0 || nums[right] != target)
        return -1;
    return right;
}

  
    public static void main(String[] args) {
      int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
      System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
      result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
      System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
      result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
      System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
  }