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
        int min = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            min = i;

            for(int j = arr.length - 1; j > i; j--) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }


    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
