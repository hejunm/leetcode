# Top 'K' Elements

## 介绍

* 从集合中查找 最*（最大、最小、出现次数最多） 的K个数。解决此类问题一般借助数据结构 ”堆“
* 根据具体题目，选择使用大根堆、小根堆

## 解题模板

``` java
//小根堆
PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

//大根堆
PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
```

## 题目

* [347.前-k-个高频元素](./347.前-k-个高频元素.java)
* [451.根据字符出现频率排序](./451.根据字符出现频率排序.java)
* [703.数据流中的第k大元素](./703.数据流中的第k大元素.java)
* [767.重构字符串](./767.重构字符串.java)
* [973.最接近原点的-k-个点](./973.最接近原点的-k-个点.java)
* [Connect Ropes (easy)](./Connect&#32;Ropes&#32;(easy).java)
* [Kth Smallest Number (easy)](./Kth&#32;Smallest&#32;Number&#32;(easy).java)
* [Maximum Distinct Elements (medium)](./Maximum&#32;Distinct&#32;Elements&#32;(medium).java)
* [Sum of Elements (medium)](./Sum&#32;of&#32;Elements&#32;(medium).java)
* [Top 'K' Numbers (easy)](./Top&#32;'K'&#32;Numbers&#32;(easy).java)
