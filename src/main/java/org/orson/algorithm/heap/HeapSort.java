package org.orson.algorithm.heap;

public class HeapSort {


    public static void main(String[] args) {

        int[] arr = {6, 8, 1, 3, 9, 2};


        HeapSort app = new HeapSort();

        app.sort_1(arr);


        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }



    public void sort_1(int[] arr) {
        for(int i = arr.length; i > 0; i--) {
            this.reBuild(arr, i);

            int temp = arr[0];
            arr[0] = arr[i - 1];
            arr[i - 1] = temp;
        }
    }

    private void reBuild(int[] arr, int len) {
        int left, right;
        for(int index = len/2; index >= 0; index --) {

            left = index * 2 + 1;
            right = index * 2 + 2;
            if((left < len) && arr[index] < arr[left]) {
                int temp = arr[index];
                arr[index] = arr[left];
                arr[left] = temp;
            }

            if((right < len) && arr[index] < arr[right]) {
                int temp = arr[index];
                arr[index] = arr[right];
                arr[right] = temp;
            }
        }
    }
}
