/**
 * Search in a Sorted Infinite Array (medium)

 Given an infinite sorted array (or an array with unknown size), 
 find if a given number ‘key’ is present in the array. 
 Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.

Since it is not possible to define an array with infinite (unknown) size, 
you will be provided with an interface ArrayReader to read elements of the array. 
ArrayReader.get(index) will return the number at index; 
if the array’s size is smaller than the index, it will return Integer.MAX_VALUE.

Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 16
Output: 6
Explanation: The key is present at index '6' in the array.

Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 11
Output: -1
Explanation: The key is not present in the array.

Input: [1, 3, 8, 10, 15], key = 15
Output: 4
Explanation: The key is present at index '4' in the array.

Input: [1, 3, 8, 10, 15], key = 200
Output: -1
Explanation: The key is not present in the array.

找出一个大于key的下标。然后二分查找
*/

class ArrayReader {
    int[] arr;
  
    ArrayReader(int[] arr) {
      this.arr = arr;
    }
  
    public int get(int index) {
      if (index >= arr.length)
        return Integer.MAX_VALUE;
      return arr[index];
    }
  }
  
  class SearchInfiniteSortedArray {
  
    public static int search(ArrayReader reader, int key) {
        int start = 0;
        int end = 1;
        while (reader.get(end)<key){
            int netStart = end+1;
            end += (end-start+1) *2; //区间翻倍 很nice
            start = netStart;
        }
        //二分查找
        return binary_search(reader, key, start, end);
    }

    static int binary_search(ArrayReader reader, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = reader.get(mid);
            if (midValue < target) {
                left = mid + 1;
            } else if (midValue > target) {
                right = mid - 1; 
            } else if(midValue == target) {
                return mid;
            }
        }
        return -1;
    }
  
    public static void main(String[] args) {
      ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
      System.out.println(SearchInfiniteSortedArray.search(reader, 16));
      System.out.println(SearchInfiniteSortedArray.search(reader, 11));
      reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
      System.out.println(SearchInfiniteSortedArray.search(reader, 15));
      System.out.println(SearchInfiniteSortedArray.search(reader, 200));
    }
  }

