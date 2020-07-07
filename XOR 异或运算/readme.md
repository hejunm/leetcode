# XOR 异或运算

## 相同 0； 不同 1

``` java
A    B    A xor B
0    0    0
0    1    1
1    0    1
1    1    0
```

## n ^ n = 0

``` java
1 ^ 1 = 0
29 ^ 29 = 0
```

## n ^ 0 = n

``` java
1 ^ 0 = 1
31 ^ 0 = 31
```

## x & (-x) 是保留位中最右边 1 ，且将其余的 1 设位 0 的方法

## 满足 交换率、结合率

``` java
(a ^ b) ^ c = a ^ (b ^ c)
a ^ b = b ^ a
```

## [补码、反码](https://www.cnblogs.com/zhangziqiu/archive/2011/03/30/computercode.html)
