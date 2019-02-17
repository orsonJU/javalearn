package org.orson.offer.sl9;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Solution9 {

    /**
     *
     * 这道题目考察道还是斐波那契数列。
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target == 0) {
            return 0;
        }

        if(target == 1) {
            return 1;
        }

        if(target == 2) {
            return 2;
        }

        int last = 1;
        int cur = 2;

        for(int i = 3; i <= target; i++) {
            cur = cur + last;
            last = cur - last;
        }

        return cur;
    }
}
