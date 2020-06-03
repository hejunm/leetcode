/*
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (32.86%)
 * Total Accepted:    256.7K
 * Total Submissions: 781.4K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2.
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1;
        int index2 = n-1;
        int k = m + n -1;
        while(index1>-1 && index2>-1){
            if(nums1[index1] > nums2[index2]){
                nums1[k] = nums1[index1];
                index1--;
            }else{
                nums1[k] = nums2[index2];
                index2--;
            }
            k--;
        }
        while (index2>-1){
            nums1[k--]=nums2[index2--];
        }         
    }
}
