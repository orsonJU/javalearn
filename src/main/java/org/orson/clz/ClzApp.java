package org.orson.clz;

import java.util.ArrayList;
import java.util.List;

public class ClzApp {


    private static final List<ClzInfo> infos = new ArrayList<>();


    public static void register(ClzInfo info) {
        infos.add(info);
    }


    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("org.orson.clz.ThirdPartyClass");

        System.out.println("----------print-------------");
        for (ClzInfo info : infos) {
            System.out.println(info.getName() + " >>");
        }
    }
}
