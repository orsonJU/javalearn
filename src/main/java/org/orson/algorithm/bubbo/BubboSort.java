package org.orson.algorithm.bubbo;

import java.util.Arrays;

public class BubboSort {


    public static void main(String[] args) {
        int[] arr = {6, 8, 1, 3, 9, 2};

        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if( arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
