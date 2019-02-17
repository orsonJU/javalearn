package org.orson.offer.sl6;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Solution6 {


    /**
     *
     * 递归斐波那契数列 看似代码十分简介明了，实际上性能十分差劲。
     *
     *
     * 结果： 1440ms
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return this.Fibonacci(n - 1) + this.Fibonacci(n - 2);

    }


    /**
     *
     * 根据高中学习的函数， 将斐波那契数列分开3部分处理 <-- 因为3个区间的函数不一样。
     *
     *  [0]
     *  [1]
     *  [2 ~ ]
     *
     *  性能：21ms
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        // 处理区间0的结果
        if(n == 0) {
           return  0;
        }

        // 处理区间1的结果
        if(n == 1) {
            return 1;
        }

        // 处理区间 2 ～ 无穷
        int sum = 1;
        int l = 0;
        int h = sum;
        for(int i = 2; i <= n; i++) {
            sum = l + h;
            l = h;
            h = sum;
        }

        return sum;
    }

    /**
     * 这个也太精辟了
     *
     * 性能： 16ms
     * @param n
     * @return
     */
    public int Fibonacci3(int n) {
        int f = 0, g = 1;
        while(n-- > 0) {
            g += f;
            f = g - f;
        }
        return f;
    }



}
