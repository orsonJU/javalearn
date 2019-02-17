package org.orson.offer.sl;

import org.junit.Test;
import org.orson.offer.sl.Solution;

public class SolutionTest {


    /**
     *
     */
    @Test
    public void find() {
        int target = 5;
        //[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        int[][] array = new int[4][4];

        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 8;
        array[0][3] = 9;
        array[1][0] = 2;
        array[1][1] = 4;
        array[1][2] = 9;
        array[1][3] = 12;
        array[2][0] = 4;
        array[2][1] = 7;
        array[2][2] = 10;
        array[2][3] = 13;
        array[3][0] = 6;
        array[3][1] = 8;
        array[3][2] = 11;
        array[3][3] = 15;

        Solution solution = new Solution();
        boolean isExists = solution.find(target, array);

        System.out.println(isExists);

    }
}
