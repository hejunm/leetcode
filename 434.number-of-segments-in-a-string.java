/*
 * [434] Number of Segments in a String
 *
 * https://leetcode.com/problems/number-of-segments-in-a-string/description/
 *
 * algorithms
 * Easy (36.55%)
 * Total Accepted:    42.8K
 * Total Submissions: 117.1K
 * Testcase Example:  '"Hello, my name is John"'
 *
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John"
 * Output: 5
 * 
 * 
 */
class Solution {
    public int countSegments(String s) {
        String trimmed = s.trim();
        if(trimmed.equals("")){
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}
