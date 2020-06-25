# 回溯算法

## 介绍

* [wiki](https://zh.wikipedia.org/wiki/%E5%9B%9E%E6%BA%AF%E6%B3%95)
* 回溯法采用试错的思想，它尝试分步的去解决一个问题。
* 在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，
* 再通过其它的可能的分步解答再次尝试寻找问题的答案。
* 回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：
  * 找到一个可能存在的正确的答案
  * 在尝试了所有可能的分步方法后宣告该问题没有答案
  
## 解题方法 & 代码模板

```java
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
// 以全排列举例
// 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
void backtrack(int[] nums, LinkedList<Integer> track) {
    // 触发结束条件
    if (track.size() == nums.length) {
        res.add(new LinkedList(track));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        // 排除不合法的选择
        if (track.contains(nums[i]))
            continue;
        // 做选择
        track.add(nums[i]);
        // 进入下一层决策树
        backtrack(nums, track);
        // 取消选择
        track.removeLast();
    }
}
```

## 题目

* [leetcode 专题](https://leetcode-cn.com/problemset/all/?topicSlugs=backtracking)
* [46.全排列](https://leetcode-cn.com/problems/permutations/)
* [51.N皇后](https://leetcode-cn.com/problems/n-queens/)
