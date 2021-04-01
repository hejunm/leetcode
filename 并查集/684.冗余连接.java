/*
 * @lc app=leetcode.cn id=684 lang=java
 *
 * [684] 冗余连接
 * 并查集
 * parent[x] = y  // x的根节点是y
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int edgeCount = edges.length;
        int[] parent = new int[edgeCount + 2];
        for (int i = 1; i <= edgeCount; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edgeCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];

            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    // 确定元素在哪个集合
    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        } 
        return parent[index];
    }
}
// @lc code=end

