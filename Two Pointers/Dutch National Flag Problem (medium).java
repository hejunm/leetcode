/**
Dutch National Flag Problem (medium)

Given an array containing 0s, 1s and 2s, sort the array in-place. 
You should treat numbers of the array as objects, hence,
we can’t count 0s, 1s, and 2s to recreate the array.

The flag of the Netherlands consists of three colors: red, white and blue; 
and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.

Input: [1, 0, 2, 1, 0]
Output: [0 0 1 1 2]

Input: [2, 2, 0, 1, 2, 0]
Output: [0 0 1 2 2 2 ]
*/

class DutchFlag {
    public static void sort(int[] arr) {
       int left = 0;
       int right = arr.length-1;
       for (int i = 0; i <= right; ) {
            if(arr[i] == 0){
                swap(arr,i,left);
                left++;
                i++;
            }else if (arr[i]==2){
                swap(arr,i,right);
                right--;
            }else{
                i++;
            }
       }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  }