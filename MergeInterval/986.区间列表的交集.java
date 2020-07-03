import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();

        int aIndex = 0;
        int bIndex = 0;
        
        while(aIndex<A.length && bIndex<B.length){
            int[] a = A[aIndex];
            int[] b = B[bIndex];
            
            //判断是否存在交集
            if( (b[0] <= a[0]  && a[0] <= b[1]) || (a[0] <= b[0]  && b[0] <= a[1])){
                result.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
            }

            if(a[1] < b[1]){
                aIndex++;
            }else{
                bIndex++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

