/*
Pair with Target Sum (easy)
Given an array of sorted numbers and a target sum, 
find a pair in the array whose sum is equal to the given target.

Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6

Input: [2, 5, 9, 11], target=11
Output: [0, 2]
Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11

解决问题：
从有序数组中找出两个数， 要求：这两个数的和为给定值

**/

class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
      int left = 0; 
      int right = arr.length-1;
      while(left < right){
        int tempSum = arr[left] + arr[right];
        if(tempSum == targetSum){
            return new int[] { left, right };
        }else if(tempSum < targetSum){
            left++;
        }else  {
            right--;
        }
      }
      return new int[] { -1, -1 };
    }

    public static int[] search2(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>(); // to store numbers and their indices
        for (int i = 0; i < arr.length; i++) {
          if (nums.containsKey(targetSum - arr[i]))
            return new int[] { nums.get(targetSum - arr[i]), i };
          else
            nums.put(arr[i], i); // put the number and its index in the map
        }
        return new int[] { -1, -1 }; // pair not found
      }
}