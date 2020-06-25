import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 * 
 * 组合
 * start    end k
 * 1  n-k+1       
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer>trackList = new LinkedList<>();
        backtrack(n, k, 1, trackList, result);
        return result;
    }

    private void backtrack(int n, int k, int first, LinkedList<Integer>trackList, List<List<Integer>> result){
        if(trackList.size() == k){
            result.add(new LinkedList(trackList));
            return;
        }
        for (int i = first; i <= n; i++) {
            trackList.add(i);
            backtrack(n, k, i+1, trackList, result);
            trackList.removeLast();
        }
    }
}
// @lc code=end

