package org.orson.algorithm.shell;

public class ShellSort {


    // 希尔排序
    public static void main(String[] args) {

        int[] arr = {6, 8, 1, 3, 9, 2};


        ShellSort app = new ShellSort();

        app.sort_1(arr);


        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

    }



    public void sort_1(int[] arr) {

        int gap = arr.length;


        do{
            gap = gap/3 + 1;

            for(int i = gap; i <= arr.length - 1; i++) {
                int temp = arr[i];
                int j = i - gap;
                for(; j >= 0 && arr[j] > temp; j = j - gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }

        }while(gap > 1);

    }
}
