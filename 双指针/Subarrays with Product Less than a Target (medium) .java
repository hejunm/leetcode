/**
 Subarrays with Product Less than a Target (medium)

 Given an array with positive numbers and a target number, 
 find all of its contiguous subarrays whose product is less than the target number.

Input: [2, 5, 3, 10], target=30 
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.

Input: [8, 2, 6, 5], target=50 
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5] 
Explanation: There are seven contiguous subarrays whose product is less than the target.
*/
import java.util.*;

class SubarrayProductLessThanK {

  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> subarrays = new ArrayList<>();

    int left = 0, right = 0;
    int product = 1;
    for (; right < arr.length; right++) {
        product *= arr[right];
        while(product >= target && left<arr.length){
            product /= arr[left];
            left++;
        }

        //left-->right窗口满足条件. nice
        // since the product of all numbers from left to right is less than the target therefore,
        // all subarrays from lef to right will have a product less than the target too; to avoid
        // duplicates, we will start with a subarray containing only arr[right] and then extend it
        List<Integer> tempList = new LinkedList<>();
        for (int i = right; i >= left; i--) {
            tempList.add(0, arr[i]);
            subarrays.add(new ArrayList<>(tempList));
        }
    }

    return subarrays;
  }
}