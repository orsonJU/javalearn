package org.orson.offer.sl16;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution16 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if(root2 == null) {
            return false;
        }
        return this.midSort(root1).contains(this.midSort(root2));
    }

    /**
     * 获取一棵树的中序排序
     */

    public String midSort(TreeNode root) {
        if(root == null) {
            return "";
        }
        return root.val + "" + this.midSort(root.left) + this.midSort(root.right);
    }
}
