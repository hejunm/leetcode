/**
Squaring a Sorted Array (easy)
Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

Input: [-3, -1, 0, 1, 2]
Output: [0 1 1 4 9]

问题：
数组中的每个元素平方， 升序排序

双指针：收尾指针
result[] 的最后一个取arr[0], arr[arr.length-1] 绝对值大的平方
*/

class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int left = 0;
        int right = arr.length-1;
        int highestSquareIdx = arr.length-1;

        while(left <= right){
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if(leftSquare > rightSquare){
                squares[highestSquareIdx] = leftSquare;
                left++;
            }else{
                squares[highestSquareIdx] = rightSquare;
                right--;
            }
            highestSquareIdx--;
        }
        return squares;
    }
}