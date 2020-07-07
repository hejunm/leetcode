/**
FindMissingNumber
Given an array of n-1n−1 integers in the range from 11 to nn, 
find the one number that is missing from the array.

Input: 1, 5, 2, 6, 4
Answer: 3

*/

// class MissingNumber {

//     public static int findMissingNumber(int[] arr) {
//       int n = arr.length + 1;
//       // find sum of all numbers from 1 to n.
//       int s1 = 0;
//       for (int i = 1; i <= n; i++)
//         s1 += i;
  
//       // subtract all numbers in input from sum.
//       for (int num : arr)
//         s1 -= num;
  
//       // s1, now, is the missing number
//       return s1;
//     }
  
//     public static void main(String[] args) {
//       int[] arr = new int[] { 1, 5, 2, 6, 4 };
//       System.out.print("Missing number is: " + MissingNumber.findMissingNumber(arr));
//     }
//   }

class MissingNumber {

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;

        int x1 = 1;
        for (int i = 2; i <= n; i++) {
            x1 ^= i;
        }

        int x2 = arr[0];
        for (int i = 1; i < n-1; i++){
            x2 = x2 ^ arr[i];
        }
        return x1 ^ x2;
    }
  
    public static void main(String[] args) {
      int[] arr = new int[] { 1, 5, 2, 6, 4 };
      System.out.print("Missing number is: " + MissingNumber.findMissingNumber(arr));
    }
  }