package org.orson.algorithm.heap;

public class HeapSort {


    public static void main(String[] args) {

        int[] arr = {6, 8, 1, 3, 9, 2};


        int k = arr.length;

        while (k > 0) {
            int key = arr[k - 1];
            int parent = (k - 1) >>> 1;
            int e = arr[parent];
            if (key >= parent)
                break;
            arr[k] = e;
            k = parent;
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }



    public void sort_1(int[] arr) {

        for(int len = arr.length - 1; len >= 0; len--) {

            this.reBuild(arr, len);


            int temp = arr[len];
            arr[len] = arr[0];
            arr[0] = temp;
        }
    }

    private void reBuild(int[] arr, int len) {
        int left, right;

        for(int node = len/2; node >= 0; node--) {

            left = (node << 1);
            right = (node << 1);
            if((left < len) && arr[left] > arr[node]) {
                this.swap(arr, node, left);
            }
            if((right < len) && arr[right] > arr[node]) {
                this.swap(arr, node, right);
            }
        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
