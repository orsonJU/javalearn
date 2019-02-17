package org.orson.offer.sl5;

import org.junit.Test;

public class Solution5Test {

    @Test
    public void test() {

        int[] array = new int[]{3,4,5,6,7,8,9,10,15,17,1,2};
        int[] array1 = new int[]{6501,6828,6963,7036, 7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};

        Solution5 sl = new Solution5();
        int i = sl.minNumberInRotateArray1(array);

        System.out.println(i);
    }


    @Test
    public void test2() {
        int[] array = new int[]{3,4,5,6,7,8,9,10,15,17,1,2};
        int[] array1 = new int[]{6501,6828,6963,7036,7421, 7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};

        Solution5 sl = new Solution5();
        int i = sl.minNumberInRotateArray2(array1);

        System.out.println(i);
    }
}
