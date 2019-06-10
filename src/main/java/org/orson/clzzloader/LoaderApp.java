package org.orson.clzzloader;

public class LoaderApp {




    static {
        System.out.println("static 块");
    }

    static MyObject object = new MyObject();


    {
        System.out.println("构造 块");
    }

    public LoaderApp() {
        System.out.println("构造函数");
    }

    public static void main(String[] args) {

        new LoaderApp();

    }
}
