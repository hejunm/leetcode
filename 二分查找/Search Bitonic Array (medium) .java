/**
 * Search Bitonic Array (medium)
 Given a Bitonic array, find if a given ‘key’ is present in it. 
 An array is considered bitonic if it is monotonically increasing and then monotonically decreasing. 
 Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].
 Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.


Input: [1, 3, 8, 4, 3], key=4
Output: 3

Input: [3, 8, 3, 1], key=8
Output: 1

Input: [1, 3, 8, 12], key=12
Output: 3

Input: [10, 9, 8], key=10
Output: 0
*/

class SearchBitonicArray {

    public static int search(int[] arr, int key) {
        int maxIndex = findMax(arr);
        int keyIndex = binarySearch(arr, key, 0, maxIndex);
        if (keyIndex != -1)
          return keyIndex;
        return binarySearch(arr, key, maxIndex + 1, arr.length - 1);
    }

    //先找出最大index
    //根据最大index, 将数组拆分出两个单调增（或者递减）数组
    public static int findMax(int[] arr) {
        int start = 0, end = arr.length - 1;
        // 左闭右开区间
        while (start < end) {
          int mid = start + (end - start) / 2;
          if (arr[mid] > arr[mid + 1]) {
            end = mid;
          } else if (arr[mid] <= arr[mid + 1]){
            start = mid + 1;
          }
        }
        //结束条件 left = right
        return start;
    }
  
     // order-agnostic binary search
  private static int binarySearch(int[] arr, int key, int start, int end) {
    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (key == arr[mid])
        return mid;

      if (arr[start] < arr[end]) { // ascending order
        if (key < arr[mid]) {
          end = mid - 1;
        } else { // key > arr[mid]
          start = mid + 1;
        }
      } else { // descending order        
        if (key > arr[mid]) {
          end = mid - 1;
        } else { // key < arr[mid]
          start = mid + 1;
        }
      }
    }
    return -1; // element is not found
  }



    public static void main(String[] args) {
      System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
      System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
      System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
      System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
  }