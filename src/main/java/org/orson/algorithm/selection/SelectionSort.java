package org.orson.algorithm.selection;

//选择排序
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {6, 8, 1, 3, 9, 2};
        SelectionSort app = new SelectionSort();
        app.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }


    public void sort(int[] arr) {
        // 核心
        // 变量i表示已经拍好顺序的元素个数，一开始是0
        for(int i = 0; i < arr.length - 1; i ++) {
            // 变量j表示从左往右需要进行比较的区域，一开始是0～arr.length - 1
            int j = 0;
            // max负责记录最大变量的位置
            int max = 0;
            while( j < arr.length - 1 - i) {
                j++;
                if(arr[j] > arr[max]) {
                    max = j;
                }
            }
            swap(arr, max, j);
        }
    }



    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
