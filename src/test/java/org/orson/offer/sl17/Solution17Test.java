package org.orson.offer.sl17;

import org.junit.Test;

public class Solution17Test {

    @Test
    public void test() {
        // tree1
        TreeNode root = new TreeNode(1);

        //branch 1
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(4);
        t2.right = new TreeNode(5);

        //branch 2
        TreeNode t3 = new TreeNode(3);
        t3.left = new TreeNode(6);
        t3.right = new TreeNode(7);

        root.left = t2;
        root.right = t3;

        Solution17 sl = new Solution17();

        sl.Mirror(root);


        System.out.println(root);


    }
}
