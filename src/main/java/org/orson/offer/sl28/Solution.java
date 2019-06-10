package org.orson.offer.sl28;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        Solution app = new Solution();

        ArrayList<String> result = app.Permutation("aab");

        System.out.println(result);
    }


    public ArrayList<String> Permutation(String str) {

        ArrayList<String> result = new ArrayList<>();
        if(str == null || str.length() == 0) {
            return result;
        }

        if(str.length() == 1) {
            result.add(str);
            return result;
        }

        String[] chars = str.split("");



        int point = 0;
        String temp = null;

        do {
            result.add(String.join("", chars));
            temp =  chars[point];
            chars[point] = chars[point + 1];
            chars[point + 1] = temp;
            point = (point + 1)%chars.length == chars.length - 1 ? 0 : (point + 1)%chars.length;
        }while(!result.get(0).equals(String.join("", chars)));

        return result;

    }
}
