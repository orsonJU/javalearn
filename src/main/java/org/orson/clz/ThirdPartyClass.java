package org.orson.clz;

public class ThirdPartyClass implements ClzInfo{


    static {
        System.out.println(ThirdPartyClass.class.getName() + " is loadded");
        ClzApp.register(new ThirdPartyClass());
    }

    @Override
    public String getName() {
        return "Third-Party-Clz-Info";
    }
}
