package org.orson.offer.v21;

// 整数组顺序使奇数位于偶数前面
public class Solution {


    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};

        Solution app = new Solution();

        app.reOrderArray(arr);


        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }


    //利用插入排序对原理
    public void reOrderArray(int [] array) {

        for(int i = 1; i < array.length; i++) {
            // 是奇数
            int j = i;
            int temp = array[i];
            if((array[i] & 0x1) == 1 ) {
                while(j > 0 && (array[j - 1] & 0x1) == 0) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
        }

    }
}
