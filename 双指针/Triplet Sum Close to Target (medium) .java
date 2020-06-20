/**
Triplet Sum Close to Target (medium)

Given an array of unsorted numbers and a target number, 
find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. 
If there are more than one such triplet, return the sum of the triplet with the smallest sum.
*/

import java.util.*;
class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    if (arr == null || arr.length < 2){
        throw new IllegalArgumentException();
    }
    Arrays.sort(arr);
    int smallestDiff = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length-2; i++) {
        int left = i+1;
        int right = arr.length-1;
        while(left < right){
            int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
            if (targetDiff == 0){
                return targetSum;
            }
            if (Math.abs(targetDiff) < Math.abs(smallestDiff)){
                smallestDiff = targetDiff;
            }
            //If there are more than one such triplet, return the sum of the triplet with the smallest sum.
            else if(Math.abs(targetDiff) == Math.abs(smallestDiff) && targetDiff > smallestDiff){
                smallestDiff = targetDiff;
            }
            if (targetDiff > 0)
                left++; // we need a triplet with a bigger sum
             else
                right--; // we need a triplet with a smaller sum
        }
    }
    return targetSum - smallestDiff;
  }
}