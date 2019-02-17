package org.orson.offer.sl12;

import org.junit.Test;

public class Solution12Test {

    @Test
    public void test() {

        Solution12 sl12 = new Solution12();

        int[] array = new int[]{1,2,3,4,5,6,7};
        sl12.reOrderArray(array);

        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
