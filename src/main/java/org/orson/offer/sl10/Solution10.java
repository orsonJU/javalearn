package org.orson.offer.sl10;


/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution10 {


    public int NumberOf1(int n) {

        String s = Integer.toBinaryString(n);

        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '1') {
                sum++;
            }
        }

        return sum;
    }


    public int NumberOf2(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
