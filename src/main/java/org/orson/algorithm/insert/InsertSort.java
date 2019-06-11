package org.orson.algorithm.insert;

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
        int point = 0;
        for(int i = 1; i <= arr.length - 1; i++) {

            boolean ischange = false;
            int temp = arr[i];

            for(int j = i; j > 0 && arr[j-1] > temp; j--) {
                arr[j] = arr[j-1];
                ischange = true;
                point = j;
            }

            if(ischange) {
                arr[point - 1] = temp;
            }

        }
    }




    public void sort_2(int[] arr) {

        for(int i = 0; i < arr.length - 1; i++) {

            int j = i + 1;
            int value = arr[j];

            while(j > 0 && value < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = value;

        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
