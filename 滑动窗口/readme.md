# 滑动窗口算法

## Core

* [解题方法](https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/hua-dong-chuang-kou-ji-qiao-jin-jie)
* 从一个序列中找到满足条件的连续子序列。序列可以是数组、链表、字符串。
* 找出“窗口限制条件”。 即子序列需要满足的条件
* 窗口向右滑动一个元素（windowEnd+1），处理窗口的右边界（windowStart）, 以满足“窗口限制条件”
* 获取结果

## 解题方法 & 代码模板

``` java
int left = 0, right = 0;

while (right < s.size()) {`
    // 增大窗口
    window.add(s[right]);
    right++;

    while (window needs shrink) {
        // 缩小窗口
        window.remove(s[left]);
        left++;
    }
}
```

## 题目

* 解决问题
* 窗口限制条件
* 如何满足条件
  