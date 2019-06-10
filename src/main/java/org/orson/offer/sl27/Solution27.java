package org.orson.offer.sl27;

public class Solution27 {


    public static void main(String[] args) {
        Solution27 app = new Solution27();


        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;


        TreeNode head = app.searchTree(t1);

        System.out.println(head);

    }

    public TreeNode Convert(TreeNode pRootOfTree) {


        TreeNode treeNode = searchTree(pRootOfTree);

        return treeNode;
    }

    private TreeNode searchTree(TreeNode pRootOfTree) {

        if(pRootOfTree == null) {
            return null;
        }

        TreeNode left = searchTree(pRootOfTree.left);

        TreeNode right = searchTree(pRootOfTree.right);

        pRootOfTree.right = left;

        if(left != null) {
            left.right = right;
        }

        if(right != null) {
            right.left = left;
        }

        if(left != null) {
            left.left = pRootOfTree;
        }


        return pRootOfTree;
    }
}
