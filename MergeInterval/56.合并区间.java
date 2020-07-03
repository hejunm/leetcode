import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 
定于区间：
class Interval {
    int start;
    int end;
};
区间a、b, 满足a.start <= b.start,
if(b.start > a.end){ 
    //b.start > a.end 不存在交集 不能合并
    //存储a, 更新start end
}else{ 
    //b.start <= a.end  存在交集 可以合并
    int statr = a.start;
    int end = max(a.end, b.end)
}
*/

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2){
            return intervals;
        }

        //排序，升序
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int n1[], int[] n2){
                return n1[0]==n2[0] ? n1[1]-n2[1] : n1[0]-n2[0];
            }
        });

        List<int[]> resultList = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(interval[0] > end){
                //b.start > a.end 不存在交集 不能合并
                resultList.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }else{
                //b.start <= a.end  存在交集 可以合并
                end = Math.max(end, interval[1]);
            }
        }
        //添加最后一个
        resultList.add(new int[]{start, end});

        int[][] result = new int[resultList.size()][2];
        for(int j=0; j < resultList.size(); j++){
            result[j] = resultList.get(j);
        }
        return result;
    }
}
// @lc code=end

