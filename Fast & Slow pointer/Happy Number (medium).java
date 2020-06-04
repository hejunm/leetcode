import java.util.HashSet;
import java.util.Set;

/**
 * Happy Number (medium)
 Any number will be called a happy number if, 
 after repeatedly replacing it with a number equal to the sum of the square of all of its digits, 
 leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. 
 Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

 Input: 23   
Output: true (23 is a happy number)  
Explanations: Here are the steps to find out that 23 is a happy number:
2^2 + 3^2 = 4 + 9 = 13
1^2 + 3^2 = 1 + 9 = 10
1^2 + 0^2 = 1
*/
class HappyNumber {

    public static boolean find(int num) {
        Set<Integer>set = new HashSet<>();
        if (num == 1){
            return true;
        }else{
            set.add(num);
        }
        while(num != 1){
            num = findSquareSum(num);
            if (num == 1){
                return true;
            }
            if (set.contains(num)){ //构成循环
                return false;
            }
            set.add(num);
        }
        return true;
    }

    private static int findSquareSum(int num) {
        int sum = 0, digit;
        while (num > 0) {
          digit = num % 10;
          sum += digit * digit;
          num /= 10;
        }
        return sum;
    }
  
    public static void main(String[] args) {
      System.out.println(HappyNumber.find(23));
      System.out.println(HappyNumber.find(12));
    }
  }