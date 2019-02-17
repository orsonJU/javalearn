package org.orson.offer.sl7;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solution7 {

    /**
     *
     * 这一题是一个变形的斐波那契数列
     * @param target
     * @return
     */
    public int jumpFloor(int target) {
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
