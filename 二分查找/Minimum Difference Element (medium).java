/**
 * Minimum Difference Element (medium)
Given an array of numbers sorted in ascending order, 
find the element in the array that has the minimum difference with the given ‘key’.

Input: [4, 6, 10], key = 7
Output: 6
Explanation: The difference between the key '7' and '6' is minimum than any other number in the array 

Input: [4, 6, 10], key = 4
Output: 4

Input: [1, 3, 8, 10, 15], key = 12
Output: 10

Input: [4, 6, 10], key = 17
Output: 10
*/

class MinimumDifference {

    public static int searchMinDiffElement(int[] arr, int key) {
        int left = 0;
        int right = arr.length-1;
        if (arr[0] > key){
            return arr[0];
        }
        if (arr[right] < key){
            return arr[right];
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = arr[mid];
            if (midValue < key) {
                left = mid + 1;
            } else if (midValue > key) {
                right = mid - 1;
            } else if(midValue == key) {
                return mid;
            }
        }

        // 结束时 left = right+1;  arr[right] < k, key < arr[right+1], 
        if (key-arr[right] > arr[left]-key){
            return arr[left];
        }else{
            return arr[right];
        }
    }
  
    public static void main(String[] args) {
      System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
      System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
      System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
      System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
  }
