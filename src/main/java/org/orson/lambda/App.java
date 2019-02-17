package org.orson.lambda;

import java.util.Arrays;

/**
 * Created by orson on 2018/7/14.
 */
public class App {

    public static void main(String[] args) throws Exception {
        //Comparator<String> comparator;
        //comparator = Comparator.comparing(String::toString);

        Long count = Arrays.asList("Orson", "Martin").stream().map(String::toString).count();

        System.out.println(count);

    }
}

