package org.orson.algorithm.heap;

public class HeapSort {


    public static void main(String[] args) {

        int[] arr = {6, 8, 1, 3, 9, 2, 5, 4, 0};

        HeapSort app = new HeapSort();
        app.sort(arr);


        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public void sort(int[] arr) {
        // 核心，构造大顶堆
        // 二叉树的特性： 节点n, 它的左孩子是2n + 1， 有孩子是  2n + 2

        // 变量i控制堆尾巴已经拍好顺序的元素个数
        for(int i = arr.length - 1; i > 0; i--) {
            rebuild(arr, 0, i);
            swap(arr, 0, i);
        }
    }

    private void rebuild(int[] arr, int start, int end) {

        int lastNode = (start + end) >> 1;

        for(int i = lastNode; i >= 0; i--) {
            int left = (i << 1) + 1;
            int right = left + 1;

            if(left <= end && arr[left] > arr[i]) {
                swap(arr, left, i);
            }

            if(right <= end && arr[right] > arr[i]) {
                swap(arr, right, i);
            }
        }
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
