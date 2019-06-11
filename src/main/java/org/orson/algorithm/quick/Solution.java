package org.orson.algorithm.quick;

public class Solution {


    public static void main(String[] args) {
        int[] arr = {6, 8, 1, 3, 9, 2, 2, 0};


        Solution app = new Solution();

        app.sort(arr, 0, arr.length - 1);

        for(int i = 0; i <= arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
    }



    public void sort(int[] arr, int left, int right) {

        int pivot = 0;
        if(left < right) {

            pivot = partition(arr, left, right);


            sort(arr, left, pivot);
            sort(arr, pivot + 1, right);
        }

    }


    public int partition(int[] arr, int left, int right) {

        int pivot = left;

        while(left < right) {


            while((left < right) && arr[right] >= arr[pivot]) {
                right--;
            }

            swap(arr, pivot, right);

            while((left < right) && arr[left] <= arr[pivot]) {
                left++;
            }

            swap(arr, pivot, left);

        }
        return pivot;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}