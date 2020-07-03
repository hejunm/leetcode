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

* [Fruits into Baskets (medium)](./Fruits&#32;into&#32;Baskets&#32;(medium)&#32;.java)
* [Longest Subarray with Ones after Replacement (hard)](./Longest&#32;Subarray&#32;with&#32;Ones&#32;after&#32;Replacement&#32;(hard)&#32;.java)
* [Longest Substring with K Distinct Characters (medium)](./Longest&#32;Substring&#32;with&#32;K&#32;Distinct&#32;Characters&#32;(medium)&#32;.java)
* [Longest Substring with Same Letters after Replacement(hard)](./Longest&#32;Substring&#32;with&#32;Same&#32;Letters&#32;after&#32;Replacement&#32;(hard).java)
* [No-repeat Substring (hard)](./No-repeat&#32;Substring&#32;(hard)&#32;.java)
*[Permutation in a String (hard)](./Permutation&#32;in&#32;a&#32;String&#32;(hard)&#32;.java)
* [Smallest Window containing Substring (hard)](./Smallest&#32;Window&#32;containing&#32;Substring&#32;(hard)&#32;#&#32;.java)
* [String Anagrams (hard)](./String&#32;Anagrams&#32;(hard).java)
* [Words Concatenation (hard)](./Words&#32;Concatenation&#32;(hard)&#32;.java)
