/**
 * Next Letter (medium)
 Given an array of lowercase letters sorted in ascending order, 
 find the smallest letter in the given array greater than a given ‘key’.

 Assume the given array is a circular list, 
 which means that the last letter is assumed to be connected with the first letter. 
 This also means that the smallest letter in the given array is greater than the last letter of the array and is also the first letter of the array.

 Write a function to return the next letter of the given ‘key’.

Input: ['a', 'c', 'f', 'h'], key = 'f'
Output: 'h'
Explanation: The smallest letter greater than 'f' is 'h' in the given array.

Input: ['a', 'c', 'f', 'h'], key = 'b'
Output: 'c'
Explanation: The smallest letter greater than 'b' is 'c'.

Input: ['a', 'c', 'f', 'h'], key = 'm'
Output: 'a'
Explanation: As the array is assumed to be circular, the smallest letter greater than 'm' is 'a'.

Input: ['a', 'c', 'f', 'h'], key = 'h'
Output: 'a'
Explanation: As the array is assumed to be circular, the smallest letter greater than 'h' is 'a'.

左边界问题
*/

class NextLetter {

    public static char searchNextLetter(char[] letters, char key) {
        int left = 0, right = letters.length - 1;
        // 退出条件：left = right+1
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= key) {
                left = mid + 1;
            } else if (letters[mid] > key) {
                right = mid - 1;
            } 
        }
        // 最后要检查 left 越界的情况
        if (left >= letters.length)
            return letters[0];
        return letters[left];
    }
  
    public static void main(String[] args) {
      System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
      System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
      System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
      System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
  }
