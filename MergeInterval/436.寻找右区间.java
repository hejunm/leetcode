import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 * 
 * 使用两个大根堆
 */

// @lc code=start
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        int[] result = new int[length];

        PriorityQueue<Integer>startMaxHead = new PriorityQueue<Integer>((i1, i2)-> intervals[i2][0]-intervals[i1][0]);
        PriorityQueue<Integer>endMaxHead = new PriorityQueue<Integer>((i1, i2)-> intervals[i2][1]-intervals[i1][1]);
        for (int i = 0; i < length; i++) {
            startMaxHead.add(i);
            endMaxHead.add(i);
        }

        while(!endMaxHead.isEmpty()){
            int maxEndIndex = endMaxHead.poll();
            int rightIndex = -1;
            while(!startMaxHead.isEmpty() && intervals[maxEndIndex][1] <= intervals[startMaxHead.peek()][0] ){
                rightIndex = startMaxHead.poll();
            }
            result[maxEndIndex] = rightIndex;
            if(rightIndex != -1){
                startMaxHead.add(rightIndex); //可能是下个区间的“右侧”
            }
        }
        return result;
    }
}
// @lc code=end

