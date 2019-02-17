package org.orson.offer.sl3;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution3 {



    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int start, int end) {
        if(start > end) {
            return null;
        }
        // root for current level
        TreeNode root = new TreeNode(pre[start]);
        Integer mid = indexForInOrders.get(root.val);

        root.left = this.reConstructBinaryTree(pre, start + 1, start + mid);
        root.right = this.reConstructBinaryTree(pre, start + mid + 1, end);

        return root;
    }
}
