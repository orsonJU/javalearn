package org.orson.algorithm.shell;

public class ShellSort {


    // 希尔排序
    public static void main(String[] args) {

        int[] arr = {6, 8, 1, 3, 9, 2};


        ShellSort app = new ShellSort();

        app.sort(arr);


        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

    }

    public void sort(int[] arr) {

        // 核心，希尔排序要一个起始的间隔大小，一般是数组的1/3

        int gap = arr.length - 1;
        do {

            gap = gap/3 + 1;

            // 变量i负责控制从第一个gap的位置开始，从左往右每个间隔进行比较，起始是一种小区间内的冒泡
            for(int i = gap; i <= arr.length - 1; i++) {

                int j = i - gap;
                int temp = arr[i];
                while(j >= 0 && temp < arr[j]) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }


        } while (gap > 1);

    }
}
