/**
Remove Duplicates (easy)

Given an array of sorted numbers, remove all duplicates from it. 
You should not use any extra space; 
after removing the duplicates in-place return the new length of the array.

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].

Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].

解决问题：
从有序数组中 去除重复重复数组

双指针: 快慢指针
*/

class RemoveDuplicates {
    public static int remove(int[] arr) {
        int nextNonDuplicate = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[nextNonDuplicate-1] != arr[i]){
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }
  }