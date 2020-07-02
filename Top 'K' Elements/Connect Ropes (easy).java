/**
Connect Ropes (easy)
Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost. 
The cost of connecting two ropes is equal to the sum of their lengths.

Example 1:
Input: [1, 3, 11, 5]
Output: 33
Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)

Example 2:
Input: [3, 4, 5, 6]
Output: 36
Explanation: First connect 3+4(=7), then 5+6(=11), 7+11(=18). Total cost is 36 (7+11+18)

Example 3:
Input: [1, 3, 11, 5, 2]
Output: 42
Explanation: First connect 1+2(=3), then 3+3(=6), 6+5(=11), 11+11(=22). Total cost is 42 (3+6+11+22)

解题： 小根堆，每次拼接最短的两个
*/

import java.util.*;

class ConnectRopes {

public static int minimumCostToConnectRopes(int[] ropeLengths) {
    int result=0;
    PriorityQueue<Integer>minHeap = new PriorityQueue<Integer>();
    for (int rope : ropeLengths) {
        minHeap.add(rope);
    }

    while(minHeap.size() > 1){
        int first = minHeap.poll();
        int sectond = minHeap.poll();
        int temp = first + sectond;
        result += temp;
        minHeap.add(temp);
    }
    return result;
}

  public static void main(String[] args) {
    int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
    System.out.println("Minimum cost to connect ropes: " + result);
    result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
    System.out.println("Minimum cost to connect ropes: " + result);
    result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
    System.out.println("Minimum cost to connect ropes: " + result);
  }
}