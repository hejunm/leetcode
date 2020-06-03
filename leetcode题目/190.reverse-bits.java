import java.util.Map;

/*
 * [190] Reverse Bits
 *
 * https://leetcode.com/problems/reverse-bits/description/
 *
 * algorithms
 * Easy (29.31%)
 * Total Accepted:    143.7K
 * Total Submissions: 490.3K
 * Testcase Example:  '    43261596 (00000010100101000001111010011100)'
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * Example:
 * 
 * 
 * Input: 43261596
 * Output: 964176192
 * Explanation: 43261596 represented in binary as
 * 00000010100101000001111010011100, 
 * return 964176192 represented in binary as
 * 00111001011110000010100101000000.
 * 
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class Solution {
    // you need treat n as an unsigned value
    private final Map<Byte,Integer>cache = new HashMap<Byte, Integer>();
    
    public int reverseBits(int n) {
        byte[] bytes = new byte[4];
        for(int i=0; i<4; i++){
            bytes[i] = (byte)((n >>> 8*i)& 0xFF);
        }
        int result = 0;
        for(int i=0; i<4; i++){
            result += reverseByte(bytes[i]);
            if(i<3){
                result <<= 8;
            }
        }
        return result;
    }

    private int reverseByte(byte b){
        Integer value = cache.get(b);
        if(value != null){
            return value;
        }
        value = 0;
        for(int i=0; i<8; i++){
            value += ((b >>> i) & 1);
            if(i<7){
                value <<= 1;
            }
        }
        cache.put(b, value);
        return value;
    }
    
}
