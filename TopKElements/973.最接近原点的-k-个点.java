import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=973 lang=java
 *
 * [973] 最接近原点的 K 个点
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //大根堆
        PriorityQueue<int[]>maxHeap = new PriorityQueue<int[]>((n1,n2)-> ((n2[0]*n2[0]+n2[1]*n2[1]) - (n1[0]*n1[0]+n1[1]*n1[1])));
        for (int i = 0; i < K; i++) {
            maxHeap.add(points[i]);
        }

        for (int i = K; i < points.length; i++) {
            if(isPoint1CloserThanPoint2(points[i], maxHeap.peek())){
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }

        //返回
        int[][] ans = new int[K][2];
        int t = 0;
        while(!maxHeap.isEmpty()){
            ans[t++] = maxHeap.poll();
        }
        return ans;
    }

    private boolean isPoint1CloserThanPoint2(int[] point1, int[] point2){
        return (point1[0]*point1[0]+point1[1]*point1[1]) < (point2[0]*point2[0]+point2[1]*point2[1]);
    }
}
// @lc code=end

