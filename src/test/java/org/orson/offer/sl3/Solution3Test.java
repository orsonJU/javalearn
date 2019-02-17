package org.orson.offer.sl3;

import org.junit.Test;

public class Solution3Test {

    @Test
    public void test() {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};

        Solution3 sl = new Solution3();
        TreeNode treeNode = sl.reConstructBinaryTree(pre, in);

        System.out.println(treeNode);

    }
}
