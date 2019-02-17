package org.orson.offer.sl19;

import junit.framework.Assert;
import org.junit.Test;

public class Solution19Test {


    @Test
    public void test() {

        Solution19 sl = new Solution19();

        sl.push(10);
        sl.push(11);
        sl.push(2);
        sl.push(1);

        int min = sl.min();
        Assert.assertEquals(min, 1);
        int min1 = sl.min();
        Assert.assertEquals(min1, 2);
    }
}
