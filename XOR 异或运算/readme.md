# 异或运算

## 相同 0； 不同 1

``` java
A    B    A xor B
0    0    0
0    1    1
1    0    1
1    1    0
```

## Taking XOR of a number with itself returns 0, e.g

``` java
1 ^ 1 = 0
29 ^ 29 = 0
```

## Taking XOR of a number with 0 returns the same number, e.g

``` java
1 ^ 0 = 1
31 ^ 0 = 31
```

## XOR is Associative & Commutative, which means

``` java
(a ^ b) ^ c = a ^ (b ^ c)
a ^ b = b ^ a
```
