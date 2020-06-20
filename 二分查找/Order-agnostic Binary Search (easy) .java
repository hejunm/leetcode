/**
Order-agnostic Binary Search (easy)

Given a sorted array of numbers, find if a given number ‘key’ is present in the array. Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order. You should assume that the array can have duplicates.

Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.

Input: [4, 6, 10], key = 10
Output: 2

Input: [1, 2, 3, 4, 5, 6, 7], key = 5
Output: 4

Input: [10, 6, 4], key = 10
Output: 0
*/

class BinarySearch {

    public static int search(int[] arr, int key) {
        int left = 0, right = arr.length-1;
        boolean isAscending = arr[left] < arr[right]; //是否升序
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == key) {
                return mid;
            }
            if (isAscending){ 
                //升序
                if (nums[mid] < key) {
                    left = mid + 1;
                } else if (nums[mid] > key) {
                    right = mid - 1; 
                }
            }else{
                //降序
                if (nums[mid] < key) {
                    right = mid - 1;
                } else if (nums[mid] > key) {
                    left = mid + 1;
                } else if(nums[mid] == key) {
                    return mid;
                }
            }
        }
        return -1;
    }
  
    public static void main(String[] args) {
      System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
      System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
      System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
      System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
  }