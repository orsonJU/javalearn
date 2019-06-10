package org.orson.offer.sl22;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution22 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) {
            return false;
        }

        int root = sequence[sequence.length - 1];
        int len = sequence.length - 1;
        int left = -1;

        for(int i = len - 1; i >=0; i--) {

            if(sequence[i] < root) {
                left = i;
                break;
            }
        }

        for(int i = 0; i < left; i++) {
            if(sequence[i] > root) {
                return false;
            }
        }

        return true;
    }
}
