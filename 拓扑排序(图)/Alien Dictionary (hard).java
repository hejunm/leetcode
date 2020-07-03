/**
Alien Dictionary (hard)

There is a dictionary containing words from an alien language for which we don’t know the ordering of the characters. 
Write a method to find the correct order of characters in the alien language.

Example 1:
Input: Words: ["ba", "bc", "ac", "cab"]
Output: bac
Explanation: Given that the words are sorted lexicographically by the rules of the alien language, so
from the given words we can conclude the following ordering among its characters:
 
1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
2. From "bc" and "ac", we can conclude that 'b' comes before 'a'
 
From the above two points, we can conclude that the correct character order is: "bac"

Example 2:
Input: Words: ["cab", "aaa", "aab"]
Output: cab
Explanation: From the given words we can conclude the following ordering among its characters:
 
1. From "cab" and "aaa", we can conclude that 'c' comes before 'a'.
2. From "aaa" and "aab", we can conclude that 'a' comes before 'b'
 
From the above two points, we can conclude that the correct character order is: "cab"

由于给定的单词是按照外来语言的规则按字典顺序排序的，因此我们始终可以比较两个相邻的单词来确定字符的顺序。

采取上面的示例1：[“ ba”，“ bc”，“ ac”，“ cab”] 取前两个单词“ ba”和“ bc”。从单词的开头开始，找到两个单词都不同的第一个字符：它将是来自“ ba”的“ a”和来自“ bc”的“ c”。
由于单词的排序顺序（即字典！），我们可以得出结论，在外语中，“ a”位于“ c”之前。 

同样，根据“ bc”和“ ac”，我们可以得出结论，“ b”位于“ a”之前。 

这两点告诉我们，实际上是要求我们查找字符的拓扑顺序，并且应该从外星字典中的相邻单词中推断出排序规则。 
这使得当前问题类似于“任务调度顺序”，唯一的区别是我们需要先比较相邻的单词，然后再执行 图形的拓扑排序，以确定字符的顺序。
*/

import java.util.*;

class AlienDictionary {
  public static String findOrder(String[] words) {
    if (words == null || words.length==0) {
      return "";
    }

    Map<Character, Integer>inDegree = new HashMap<>();          //入度
    Map<Character, List<Character>> graph = new HashMap<>();    //依赖关系

    //初始化数据结构
    for (String word : words) {
        char[] chars = word.toCharArray();
        for (char c : chars) {
            inDegree.put(c, 0);
            if(graph.get(c) == null){
                graph.put(c, new ArrayList<>());
            }
        }
    }

    //设置入度、graph
    for (int i = 0; i < words.length-1; i++) {
        String word1 = words[i];
        String word2 = words[i+1];

        int compareLength = Math.min(word1.length(), word2.length());
        for (int j = 0; j < compareLength; j++) {
            char parent = word1.charAt(j);
            char child = word2.charAt(j);
            if(parent != child){
                inDegree.put(child, inDegree.getOrDefault(child, 0)+1);
                graph.get(parent).add(child);
                break;
            }
        }
    }

    //查找入度为0的字符
    Queue<Character>sources = new LinkedList<>();
    for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
        if(entry.getValue() == 0){
            sources.add(entry.getKey());
        }
    }

    StringBuilder orderedString = new StringBuilder();
    while(sources.isEmpty() == false){
        char c = sources.poll();
        orderedString.append(c);
        List<Character> children = graph.get(c);
        for (Character child : children) {
            inDegree.put(child, inDegree.get(child)-1);
            if(inDegree.get(child) == 0){
                sources.add(child);
            }
        }   
    }
    if (orderedString.length() != inDegree.size()){
        return "";
    }else{
        return orderedString.toString();
    }
  }

  public static void main(String[] args) {
    String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
    System.out.println("Character order: " + result);

    result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
    System.out.println("Character order: " + result);

    result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
    System.out.println("Character order: " + result);
  }
}
