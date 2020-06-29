import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {

    /**
     * 1, 2, 3
     * []
     * [1]
     * [2,1], [1,2]
     * [3,2,1], [2,3,1],[2,1,3],   [3,1,2],[1,3,2],[1,2,3]
     * 
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>>queue = new LinkedList<>();
        queue.add(new ArrayList<>());
        for (int num : nums) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> oldPermute = queue.poll();
                for (int j = 0; j <= oldPermute.size(); j++) {
                    List<Integer> newPermute = new ArrayList<>(oldPermute);
                    newPermute.add(j, num);
                    if(newPermute.size() == nums.length){
                        result.add(newPermute);
                    }else{
                        queue.add(newPermute);
                    }
                }
            }
        }
        return result;
    }


    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Set<Integer> trackSet =  new HashSet<>();
        LinkedList<Integer> trackList = new LinkedList<>();
        backtrack(nums, result, trackSet, trackList);
        return result;
    }

    /**
     * trackSet:  已遍历数字集合
     * trackList: 已遍历数字列表
    */
    private void backtrack(int[] nums, List<List<Integer>> result, Set<Integer>trackSet, LinkedList<Integer> trackList){
        if(trackList.size() == nums.length){
            result.add(new LinkedList(trackList));
            return;
        }
        for (int currentNum : nums) {
            if(trackSet.contains(currentNum)){
                continue;
            }
            trackSet.add(currentNum);
            trackList.add(currentNum);

            backtrack(nums, result, trackSet, trackList);
            
            trackSet.remove(currentNum);
            trackList.removeLast();
        }
    }
}
// @lc code=end

