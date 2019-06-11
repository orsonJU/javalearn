package org.orson.algorithm.bubbo;


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
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
