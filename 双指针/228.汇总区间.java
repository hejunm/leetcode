import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int i = 0;
        int length = nums.length;

        while (i < length) {
            int low = i;
            i++;
            while (i < length && nums[i-1]+1 == nums[i]) {
                i++;
            }
            int height = i-1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if(low < height){
                temp.append("->");
                temp.append(nums[height]);
            }
            result.add(temp.toString());
        }
        return result;
    }
}
// @lc code=end

