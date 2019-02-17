package org.orson.offer.sl12;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution12 {

    /**
     * 出题者希望在原来的数组上进行操作
     *
     * @param array
     */
    public void reOrderArray(int [] array) {

        int li = 0;
        int[] l = new int[array.length];

        int hi = array.length - 1;

        int len = array.length - 1;
        for(int i = 0; i < array.length; i++) {
            if(array[i]%2==1) {
                l[li++] = array[i];
            }

            if(array[len - i] % 2 == 0) {
                l[hi--] = array[len - i];
            }


        }

        for(int i = 0; i < array.length; i++) {
            array[i] = l[i];
        }



    }

}
