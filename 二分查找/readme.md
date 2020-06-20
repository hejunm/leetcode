# 二分查找

## Core

* [讲解](https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/er-fen-cha-zhao-xiang-jie)
* 思路很简单，细节是魔鬼
* 细节：到底要给 mid 加一还是减一，while 里到底用 <= 还是 <
  
1. 分析二分查找代码时，不要出现 else，全部展开成 else if 方便理解。
2. 注意「搜索区间」和 while 的终止条件，如果存在漏掉的元素，记得在最后检查。
3. 定义左闭右开的「搜索区间」while(left < right)，常用于比较 nums[mid] nums[mid+1]
4. 如果将「搜索区间」全都统一成两端都闭，好记，只要稍改 nums[mid] == target 条件处的代码和返回的逻辑即可.

## 解题方法 & 代码模板

```java
int binary_search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while(left <= right) {
        int mid = left + (right - left) / 2;
        int midValue = nums[mid];
        if (midValue < target) {
            left = mid + 1;
        } else if (midValue > target) {
            right = mid - 1;
        } else if(midValue == target) {
            return mid;
        }
    }
    return -1;
}

int left_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    // 退出条件：left = right+1
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midValue = nums[mid];
        if (midValue < target) {
            left = mid + 1;
        } else if (midValue > target) {
            right = mid - 1;
        } else if (midValue == target) {
            // 别返回，锁定左侧边界
            right = mid - 1;
        }
    }
    // 最后要检查 left 越界的情况
    if (left >= nums.length || nums[left] != target)
        return -1;
    return left;
}


int right_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    // 退出条件：right = left-1
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midValue = nums[mid];
        if (midValue < target) {
            left = mid + 1;
        } else if (midValue > target) {
            right = mid - 1;
        } else if (midValue == target) {
            // 别返回，锁定右侧边界
            left = mid + 1;
        }
    }
    // 最后要检查 right 越界的情况
    if (right < 0 || nums[right] != target)
        return -1;
    return right;
}
```

## 例题
