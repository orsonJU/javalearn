package org.orson.offer.sl17;

import apple.laf.JRSUIUtils;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution17 {

    /**
     *
     * 太厉害了，发现这个树的转换就是中序排序的逆序
     * @param root
     */
    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }

        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;


        this.Mirror(root.left);
        this.Mirror(root.right);
    }
}
