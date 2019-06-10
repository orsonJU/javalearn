package org.orson.algorithm.insert;

public class InsertSort {


    public static void main(String[] args) {
        int[] arr = {6, 8, 1, 3, 9, 2};
        // 6, 8, 1, 3, 9, 2
        // 6, 8, 1, 3, 9, 2

        InsertSort app = new InsertSort();


        app.sort_2(arr);


        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }


    public void sort_1(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {

            int value = arr[i + 1];
            int offset = i + 1;
            boolean flag = false;
            for(int j = offset; j > 0 && (value < arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
                offset = j - 1;
                flag = true;
            }

            if(flag) {
                arr[offset] = value;
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
}
