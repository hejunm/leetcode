/**
Minimum Height Trees (hard) #
We are given an undirected graph that has characteristics of a k-ary tree. 
In such a graph, we can choose any node as the root to make a k-ary tree. 
The root (or the tree) with the minimum height will be called Minimum Height Tree (MHT).
There can be multiple MHTs for a graph. 
In this problem, we need to find all those roots which give us MHTs. 
Write a method to find all MHTs of the given graph and return a list of their roots.

Example 1:
Input: vertices: 5, Edges: [[0, 1], [1, 2], [1, 3], [2, 4]]
Output:[1, 2]
Explanation: Choosing '1' or '2' as roots give us MHTs. In the below diagram, we can see that the 
height of the trees with roots '1' or '2' is three which is minimum.

Example 2:
Input: vertices: 4, Edges: [[0, 1], [0, 2], [2, 3]]
Output:[0, 2]
Explanation: Choosing '0' or '2' as roots give us MHTs. In the below diagram, we can see that the 
height of the trees with roots '0' or '2' is three which is minimum.

https://www.educative.io/courses/grokking-the-coding-interview/7nDN8y7JKVA

*/

import java.util.*;

class MinimumHeightTrees {
    
  public static List<Integer> findTrees(int nodes, int[][] edges) {
    List<Integer> minHeightTrees = new ArrayList<>();
    if(nodes <= 0){
        return minHeightTrees;
    }
    if(nodes == 1){
        minHeightTrees.add(0);
        return minHeightTrees;
    }

    Map<Integer, Integer>inDegree = new HashMap<>();
    Map<Integer, List<Integer>>graph = new HashMap<>();
    for (int i = 0; i < nodes; i++) {
        inDegree.put(i, 0);
        graph.put(i,  new LinkedList<>());
    }

    //初始化
    for (int[] edge : edges) {
        int n1 = edge[0];
        int n2 = edge[1];

        inDegree.put(n1, inDegree.get(n1)+1);
        inDegree.put(n2, inDegree.get(n2)+1);
        graph.get(n1).add(n2);
        graph.get(n2).add(n1);
    }

    //找出叶子节点 入度为1
    Queue<Integer>leaves = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
        if(entry.getValue() == 1){
            leaves.add(entry.getKey());
        }
    }
    int totalNodes = nodes;
    while(totalNodes > 2){
        int leavesSize = leaves.size();
        totalNodes -= leavesSize;
        for (int i = 0; i < leavesSize; i++) {
            int vertex = leaves.poll();
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
              inDegree.put(child, inDegree.get(child) - 1);
              if (inDegree.get(child) == 1){
                leaves.add(child);
              } 
            }
          }
    }
    minHeightTrees.addAll(leaves);
    return minHeightTrees;
  }

  public static void main(String[] args) {
    List<Integer> result = MinimumHeightTrees.findTrees(5,
        new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
    System.out.println("Roots of MHTs: " + result);

    result = MinimumHeightTrees.findTrees(4,
        new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
    System.out.println("Roots of MHTs: " + result);

    result = MinimumHeightTrees.findTrees(4,
        new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
    System.out.println("Roots of MHTs: " + result);
  }
}