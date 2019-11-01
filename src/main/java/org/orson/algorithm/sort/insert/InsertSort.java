package org.orson.algorithm.sort.insert;

//插入排序
public class InsertSort {


    public static void main(String[] args) {
        int[] arr = {6, 8, 1, 3, 9, 2};
        InsertSort app = new InsertSort();
        app.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }


    public void sort(int[] arr) {
        // 变量i表示已经完成排序的元素个数，一开始是0
        for(int i = 0; i < arr.length - 1; i++) {
            // 变量j负责从左往右依次查找需要插入元素的位置
            int j = i + 1;
            // 核心，要保存当前值，然后不断地比较，找到合适的位置
            int temp = arr[j];
            while ( j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }

    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
