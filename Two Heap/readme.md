# TwoHeap

* 使用大根堆和小根堆解决一些问题。
* 使用堆可以很方便的选取最大值，最小值时

```java
PriorityQueue<Integer>minHeap = new PriorityQueue<Integer>((i1, i2) -> i1-i2);PriorityQueue<Integer>maxHeap = new PriorityQueue<Integer>((i1, i2) -> i2-i1);
```
