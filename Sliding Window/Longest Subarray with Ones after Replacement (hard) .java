/**
 * Longest Subarray with Ones after Replacement (hard)
 * 
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, 
 * find the length of the longest contiguous subarray having all 1s.
 * 
 * 解决问题：
 * 从数组中查询一个连续子数组
 * 
 * 窗口限制条件：
 * 窗口大小减去窗口中1的个数 <= k
 * 
 * 如何满足条件：
 * 当 windowEnd-windowStart+1 - maxOnesCount > k， 缩小窗口
**/

class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int windowStart = 0, maxLength = 0, maxOnesCount = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) {
                maxOnesCount++;
            }
            if (windowEnd-windowStart+1 - maxOnesCount > k) {
                if (arr[windowStart] == 1) {
                    maxOnesCount--;
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }
  }