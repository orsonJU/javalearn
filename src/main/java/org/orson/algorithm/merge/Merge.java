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


    // 合并排序和 快速排序有些许相似之处
    public void sort(int[] origin, int left, int right, int[] dest) {

        int mid = (left + right) >> 1;

        if(left < right) {
            sort(origin, left, mid, dest);
            sort(origin, mid + 1, right, dest);
            merge(origin, left, mid, right, dest); // (1)
        }

    }

    private void merge(int[] origin, int left, int mid, int right, int[] dest) {
        // 核心，实现merge函数
        int low = left;
        int high = mid + 1; // (2)
        int i = left;
        while( low <= mid && high <= right) {

            if(origin[low] < origin[high]) {
                dest[i++] = origin[low++];
            }else {
                dest[i++] = origin[high++];   // (3)
            }

        }


        while(low <= mid) {
            dest[i++] = origin[low++];
        }

        while(high <= right) {
            dest[i++] = origin[high++];
        }


        // 核心，排序完毕后，要复制会源头
        for(int point = left; point <= right; point++) {
            origin[point] = dest[point];
        }

    }
}
