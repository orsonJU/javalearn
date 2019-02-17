package org.orson.offer.sl5;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution5 {

    /**
     * 非减排序，而且是旋转数组，一定存在某个位置开始的数 k < k -1
     *
     * 漏洞：假若这个数组没有发生移动，最少数字就是第一个
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        for(int i = 0; i< array.length; i++) {
            if(array[i + 1] < array[i]) {
                return array[i + 1];
            }
        }

        if(array.length != 0) {
            return array[0];
        }
        // length == 0
        return 0;
    }


    /**
     * @param array
     * @return
     */
    public int minNumberInRotateArray1(int [] array) {
        if(array.length == 0) {
            return 0;
        }
        return this.minNumber(array, 0, array.length - 1);
    }

    public int minNumber(int[] array, int start, int end) {
        //middle
        int mid = (start + end)/2;

        if(array[start] > array[mid]) {
            return minNumber(array, start, mid);
        }else if(array[mid + 1] > array[end]){
            return minNumber(array, mid + 1, end);
        }else {
            return array[mid+1];
        }
    }


    /**
     *
     * 精辟
     * @param array
     * @return
     */
    public int minNumberInRotateArray2(int [] array) {
        //3,4,5,6,7,8,9,10,15,17,1,2
        if (array.length == 0)
            return 0;
        int start = 0, end = array.length - 1;
        while (start < end) {
            int m = start + (end - start) / 2;
            if (array[m] <= array[end])
                end = m;
            else
                start = m + 1;
        }
        return array[start];
    }
}
