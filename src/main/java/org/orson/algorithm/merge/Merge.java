package org.orson.algorithm.merge;

public class Merge {

    public static void main(String[] args) {
        Merge app = new Merge();

        int[] arr = {6, 8, 1, 3, 9, 2};
        int[] temp = new int[arr.length];


    }

    private void sort(int[] arr, int left, int right, int[] temp) {

        if(left < right) {
            int mid = (left + right)/2;

            sort(arr, left, mid, temp);

            sort(arr, mid + 1, right, temp);
            
            
            merge(arr, left, mid, right, temp);


        }





    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int low = left;
        int high = mid + 1;
        int offset = 0;
        while(low < mid && high < right) {
            if(arr[low] < arr[high]) {
                temp[offset] = arr[low];
                low++;
            }else {
                temp[offset] = arr[high];
                high++;
            }
            offset++;
        }


    }
}
