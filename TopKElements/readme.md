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
