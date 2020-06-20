/**
Comparing Strings containing Backspaces (medium) #

Given two strings containing backspaces (identified by the character ‘#’),
check if the two strings are equal.

Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.

Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.

Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.

Input: str1="xywrrmp", str2="xywrrmu#p"
Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
*/
class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
        int index1 = str1.length()-1;
        int index2 = str2.length()-1;

        while(index1 >= 0 || index2>=0){
            int i1 = getNextValidCharIndex(str1, index1);
            int i2 = getNextValidCharIndex(str2, index2);
            if(i1< 0 && i2<0){ //全部结束
                return true;
            }
            if(i1< 0 || i2<0){ //一个结束 一个没有结束
                return false;
            }

            if(str1.charAt(i1) != str2.charAt(i2)){
                return false;
            }
            index1 = i1-1;
            index2 = i2-1;
        }
        return true;
    }

    /**
     * 获取下个合法字符的下标
     * （ab, 1)  返回1
     * （ab#, 2）返回0
     * @param str 
     * @param currentIndex 当前下标
     * @@return 合法字符小标
    */
    private static int getNextValidCharIndex(String str, int currentIndex){
        int backspacesCount = 0;
        while(currentIndex >= 0){
            char c = str.charAt(currentIndex);
            if (c == '#'){
                backspacesCount++;
            }else if(backspacesCount>0){
                backspacesCount--;
            }else{
                break;
            }
            currentIndex--;
        }
        return currentIndex;
    }
  }