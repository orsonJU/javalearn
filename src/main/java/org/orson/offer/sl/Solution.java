package org.orson.offer.sl;

public class Solution {


    /**
     *
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     *
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     *
     * result: 202ms
     *
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int [][] array) {
        // target: 5
        // array: [[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        for(int i = 0; i < array.length; i++) {

            for(int j = 0; j < array[i].length; j++) {
                if(target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * result 189ms
     * @param target
     * @param array
     * @return
     */
    public boolean find1(int target, int [][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                if(target > array[i][j]) {
                    //break current round
                    break;
                }
                if(target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * @param target
     * @param array
     * @return
     */
    public boolean find2(int target, int [][] array) {
        int row = array.length - 1;
        int col = 0;

        while((row >=0) && (col < array[row].length)) {

            if(target < array[row][col]) {
                row--;
            }else if(target > array[row][col]) {
                col++;
            }else {
                return true;
            }
        }
        return false;
    }
}
