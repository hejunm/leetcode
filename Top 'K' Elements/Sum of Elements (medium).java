/**
Sum of Elements (medium)
Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.

Example 1:
Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
Output: 23
Explanation: The 3rd smallest number is 5 and 6th smallest number 15. The sum of numbers coming
between 5 and 15 is 23 (11+12).

Example 2:
Input: [3, 5, 8, 7], and K1=1, K2=4
Output: 12
Explanation: The sum of the numbers between the 1st smallest number (3) and the 4th smallest 
number (8) is 12 (5+7).
*/

import java.util.*;

class SumOfElements {

    public static int findSumOfElements(int[] nums, int k1, int k2) {
        PriorityQueue<Integer>minHeap = new PriorityQueue<Integer>();
        for (int num : nums) {
            minHeap.add(num);
        }

        for (int i = 0; i < k1; i++) {
            minHeap.poll();
        }

        int sum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++){
            sum += minHeap.poll();
        }
        return sum;
    }

  public static void main(String[] args) {
    int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

    result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
  }
}