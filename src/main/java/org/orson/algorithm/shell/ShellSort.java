package org.orson.algorithm.shell;

public class ShellSort {


    public static void main(String[] args) {

        int[] arr = {6, 8, 1, 3, 9, 2};


        ShellSort app = new ShellSort();

        app.sort_1(arr);


        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

    }



    public void sort_1(int[] arr) {

        int incr = arr.length;


        int i, j;

        do {
            incr = incr/10 + 1;
            for(i = incr; i < arr.length; i++) {
                int temp = arr[i];

                for(j = i - incr; j >= 0 && arr[j] > temp; j = j - incr) {
                    arr[j + incr] = arr[j];
                }
                arr[j + incr] = temp;

            }

        }while(incr > 1);

    }
}
