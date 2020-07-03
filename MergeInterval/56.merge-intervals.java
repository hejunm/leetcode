import java.util.ArrayList;
import java.util.List;

/*
 * [56] Merge Intervals
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (34.46%)
 * Total Accepted:    9.2K
 * Total Submissions: 26.7K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 * 
 * 先排序，按照区间的左值 升序
 * 遍历合并
 */
// public class Interval {
//     int start;
//     int end;
//     Interval() { start = 0; end = 0; }
//     Interval(int s, int e) { start = s; end = e; }
// }

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null){
            return null;
        }
        int size = intervals.size();
        if(size<=1){
            return intervals;
        }
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval>result = new ArrayList<Interval>();
        Interval previous = intervals.get(0);

        for (int i = 1; i < size ; i++) {
            Interval interval = intervals.get(i);
            if(interval.start<=previous.end){    //存在交集
                previous = new Interval(previous.start,Math.max(previous.end, interval.end));
            }else{
                result.add(previous);
                previous = interval;
            }
        }
        result.add(previous);
        return result;
    }
}
