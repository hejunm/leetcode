import java.util.ArrayList;

import com.sun.tools.javac.util.List;

/*
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (37.67%)
 * Total Accepted:    264.8K
 * Total Submissions: 702.9K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> resultList = new ArrayList<>();
        letterCombinations(resultList, digits, "", 0, mapping);
        return resultList;
    }

    private void letterCombinations(List<String> resultList,String digits,String curr,int index,String[] mapping){
        if(index==digits.length()){
            if(curr.length()!=0){
                resultList.add(curr);
            }
            return;
        }
        String temp = mapping[digits.charAt(index)-'0'];
        for(int i=0;i<temp.length();i++){
            String next = curr + temp.charAt(i);
            letterCombinations(resultList, digits, next, index+1, mapping);
        }
    }
}
