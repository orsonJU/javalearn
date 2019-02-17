package org.orson.offer.sl4;

import org.junit.Test;

public class Solution4Test {

    @Test
    public void test() {
        Solution4 sl = new Solution4();


        sl.push(1);
        sl.push(2);
        sl.push(3);
        sl.push(4);


        System.out.println(sl.pop());
        System.out.println(sl.pop());
        System.out.println(sl.pop());

        sl.push(5);

        System.out.println(sl.pop());
        System.out.println(sl.pop());
    }
}
