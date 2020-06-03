/**
Triplet Sum to Zero (medium)

Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.

Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.

分析：
与Pair with Target Sum (easy) 类似。
先确定一个数first，找出 “和为负first” 的另外两个。
*/

import java.util.*;

class TripletSumToZero {

  public static List<List<Integer>> searchTriplets(int[] arr) {
    List<List<Integer>> triplets = new ArrayList<>();
    Arrays.sort(arr);
    for (int i = 0; i < arr.length-2; i++) {
        if (i>0 && arr[i]==arr[i-1]){
            continue;
        }
        search(arr, i+1, -arr[i], triplets);
    }
    return triplets;
  }

  private static void search(int[] arr, int left, int targetSum, List<List<Integer>> triplets) {
    int right = arr.length-1;
    while(left < right){
      int tempSum = arr[left] + arr[right];
      if(tempSum == targetSum){
          triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
          left++;
          right--;
          while(left < right && arr[left] == arr[left-1]){
            left++;
          }
          while(left < right && arr[right]==arr[right+1]){
            right--;
          }
      }else if(tempSum < targetSum){
          left++;
      }else  {
          right--;
      }
    }
  }
}