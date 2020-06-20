/**
Minimum Window Sort (medium) #
Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
 
Input: [1, 2, 5, 3, 7, 10, 9, 12]
Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted

Input: [1, 3, 2, 0, -1, 7, 10]
Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted

Input: [1, 2, 3]
Output: 0
Explanation: The array is already sorted

Input: [3, 2, 1]
Output: 3
Explanation: The whole array needs to be sorted.
*/

class ShortestWindowSort {
    public static int sort(int[] arr) {
        int low = 0;
        int high = arr.length-1;

        //low 升序的最后一个
        while(low < arr.length-1 && arr[low] < arr[low+1]){
            low++;
        }
        if(low==arr.length-1){//已经排好序了
            return 0;
        }

        //high
        while(high>0 && arr[high-1] < arr[high]){
            high--;
        }

        //low-->hight 找到最大值 最小值
        int maxInSubArray = Integer.MIN_VALUE;
        int minInSubArray = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            maxInSubArray = Math.max(arr[i], maxInSubArray);
            minInSubArray = Math.min(arr[i], minInSubArray);
        }

        //如有 minInSubArray 比 arr[low-1]小，low--
        while(low>0 && arr[low-1] > minInSubArray){
            low--;
        }
        //如果 maxInSubArray > arr[high+1] high++;
        while(high<arr.length-1 && arr[high+1]<maxInSubArray){
            high++;
        }

        return high-low+1;
    }
  }