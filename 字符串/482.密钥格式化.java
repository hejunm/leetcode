/*
 * @lc app=leetcode.cn id=482 lang=java
 *
 * [482] 密钥格式化
 */

// @lc code=start
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] charArray = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = charArray.length-1; i >= 0; i--) {
            char c = charArray[i];
            if(c == '-') {
                continue;
            }
            if(count>0 && count%K == 0){
                sb.append('-');
            }
            sb.append(Character.toUpperCase(c));
            count++;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

