/*
Triplets with Smaller Sum (medium)

Given an array arr of unsorted numbers and a target sum, 
count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
Write a function to return the count of such triplets.

Input: [-1, 0, 2, 3], target=3 
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]

分析：
排序
确定一个数字 arr[i]
双指针 找出arr[left]+arr[right] < target - arr[i]
**/

import java.util.*;

class TripletWithSmallerSum {
  public static int searchTriplets(int[] arr, int target) {
    int count = -1;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length-2; i++) {
        int left = i+1;
        int right = arr.length-1;
        while(left < right){
            int sum = arr[i] + arr[left] + arr[right];
            if (sum < target){
                // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between 
                // left and right to get a sum less than the target sum
                count += (right-left);
                left++;
            }else {
                right--;
            }
        }
    }
    return count;
  }
}