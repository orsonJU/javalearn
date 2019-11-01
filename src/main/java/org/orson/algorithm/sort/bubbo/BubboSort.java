package org.orson.algorithm.sort.bubbo;


// 冒泡排序
public class BubboSort {


    public static void main(String[] args) {
        int[] arr = {6, 8, 1, 3, 9, 2};
        BubboSort app = new BubboSort();
        app.sort(arr);
        for(int i = 0; i <= arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public void sort(int[] arr) {
        // 核心
        // 变量i表示的是已经通过冒泡排序的元素个数，一开始是0
        for(int i = 0; i < arr.length - 1; i ++) {
            // 变量j负责控制从左往右的剩余元素的拍素区间
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

    }


    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
