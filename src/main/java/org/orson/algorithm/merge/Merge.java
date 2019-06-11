package org.orson.algorithm.merge;

public class Merge {

    public static void main(String[] args) {
        Merge app = new Merge();

        int[] arr = {6, 8, 1, 3, 9, 2, 0};
        int[] temp = new int[arr.length];


        app.sort(arr, 0, arr.length - 1, temp);

        for(int i = 0; i <= arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }

    }

    private void sort(int[] arr, int left, int right, int[] temp) {

        int mid = (left + right) >> 1;
        if(left < right) {

            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }


    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int point = left;
        int low = left, high = mid + 1;
        while(low <= mid && high <= right) {

            if(arr[low] < arr[high]) {
                temp[point++] = arr[low++];
            }else {
                temp[point++] = arr[high++];
            }

        }

        while(low <= mid) {
            temp[point++] = arr[low++];
        }

        while(high <= right) {
            temp[point++] = arr[high++];
        }

        for(int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }



    }
}
