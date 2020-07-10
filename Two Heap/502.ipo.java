import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=502 lang=java
 *
 * [502] IPO
 */

// @lc code=start
class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Integer> profitsHeap = new PriorityQueue<Integer>((i1,i2) -> Profits[i2]-Profits[i1]);
        PriorityQueue<Integer> capitalHeap = new PriorityQueue<Integer>((i1,i2) -> Capital[i1]-Capital[i2]);

        /// 启动资金
        for (int i = 0; i < Capital.length; i++) {
            capitalHeap.add(i);
        }

        //一共K个项目
        for (int i = 0; i < k; i++) {
            while(!capitalHeap.isEmpty() && Capital[capitalHeap.peek()] <= W){
                //当前资本可以启动项目, 作为备选项目
                profitsHeap.add(capitalHeap.poll());
            }

            if (profitsHeap.isEmpty()){
                // 无备选项目
                break;
            }

            // 选择最大收益进行投资
            W += Profits[profitsHeap.poll()];
        }

        return W;
    }
}
// @lc code=end

