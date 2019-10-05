package org.orson.offer.v26;

// 树的子结构
public class Solution {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if(root1 == null || root2 == null) {
            return false;
        }


        boolean res = false;
        if(root1.val == root2.val) {
            res = DoesTree1HaveTree2(root1, root2);
        }
        if(!res) {
            res = HasSubtree(root1.left, root2.left);
        }
        if(!res) {
            res = HasSubtree(root1.right, root2.right);
        }
        return res;
    }

    private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if(root2 == null) {
            return true;
        }

        if(root1 == null) {
            return false;
        }

        if(root1.val != root2.val) {
            return false;
        }

        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }


}
