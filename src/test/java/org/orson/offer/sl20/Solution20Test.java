package org.orson.offer.sl20;

import org.junit.Test;

public class Solution20Test {

    @Test
    public void test() {

        Solution20 sl = new Solution20();

        int[] push = new int[]{1,2,3,4,5};
        int[] pop = new int[]{4,5,3,2,1};
        int[] pop2 = new int[]{4,3,5,1,2};

        int[] push1 = new int[]{1};
        int[] pop3 = new int[]{2};

        boolean b = sl.IsPopOrder(push1, pop3);

        System.out.println(b);
    }
}
