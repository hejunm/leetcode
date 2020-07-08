/*
 * @lc app=leetcode.cn id=832 lang=java
 *
 * [832] 翻转图像
 */

// @lc code=start
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int leftIndex = 0;
            int rightIndex = A[0].length-1;
            while(leftIndex <= rightIndex){
                if(leftIndex == rightIndex){
                    A[i][leftIndex] = A[i][leftIndex] ^ 1;
                }else{
                    int left = A[i][leftIndex];
                    int right = A[i][rightIndex];
                    A[i][leftIndex] = right ^ 1;
                    A[i][rightIndex] = left ^ 1;
                }
                leftIndex++;
                rightIndex--;
            }
        }
        return A;
    }
}
// @lc code=end

