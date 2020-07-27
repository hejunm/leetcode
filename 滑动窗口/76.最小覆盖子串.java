/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, sLength = s.length(), tLength = t.length();

        int count = 0; //匹配到的字符数量
        int minLength = sLength+1;
        String result = "";

        int[] needs = new int[128];
        int[] window = new int[128]; //窗口中匹配的数
        char[] tChars = t.toCharArray();
        for (char c : tChars) {
            needs[c]++;
        }

        while(right < sLength){
            char rightChar = s.charAt(right);
            window[rightChar]++;
            if(needs[rightChar] > 0 && needs[rightChar] >= window[rightChar]){ 
                //属于子串的一部分
                count++;
            }

//缩小窗口
while(count == tLength){
    char leftChar = s.charAt(left);
    if(needs[leftChar] == 0 || needs[leftChar] < window[leftChar]){
        //leftChar  s中没有 ||  [left, right]中数量多于所需数量
    }else{
        count--;
        if(right-left+1 < minLength){
            minLength = right-left+1;
            result = s.substring(left, right+1);
        }
    }
    window[leftChar]--;
    left++;
}
            right++;
        }
        return result;
    }
}
// @lc code=end

