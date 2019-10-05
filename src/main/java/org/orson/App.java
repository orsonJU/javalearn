package org.orson;

public class App {

    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        user.name = "11111111";
        change(user);
        System.err.println(user.name);
    }

    static void change(User user) {
        user = new User();
        user.name = "2222222222";
    }
}
class User {
    String name;
}