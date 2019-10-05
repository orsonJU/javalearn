package org.orson.offer.v27;

// 二叉树的镜像
public class Solution {

    public void Mirror(TreeNode root) {

        this.miroor(root);
    }

    private TreeNode miroor(TreeNode root) {

        if(root == null) {
            return null;
        }

        TreeNode left = miroor(root.left);
        TreeNode right = miroor(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
