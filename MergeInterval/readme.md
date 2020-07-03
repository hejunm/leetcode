# Merge Interval

## 介绍

* 该模式用于处理区间问题。

```java
//定义区间：
class Interval {
    int start;
    int end;
};
```

* 给定两个区间a、b, 两者之间的关系有如下六种情况：
![a b区间关系](./AB区间关系.png)

### 合并区间

区间a、b, 满足a.start <= b.start

```java
if(b.start > a.end){
    //b.start > a.end 不存在交集 不能合并
    //存储a, 更新start end
}else{
    //b.start <= a.end  存在交集 可以合并. 合并后区间：[a.start, max(a.end, b.end)]
    int statr = min(a.start, b.start);
    int end = max(a.end, b.end)
}
```

### 交集

```java
start = max(a.start, b.start)
end = min(a.end, b.end)
```

## 解题方法 & 代码模板

## 题目

* Merge Intervals (medium)
