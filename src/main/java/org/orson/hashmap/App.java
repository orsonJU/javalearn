package org.orson.hashmap;

public class App {


    public static void main(String[] args) {


        OrsonMap<String, String> map = new OrsonMap<>();

        map.put("name", "orson");
        map.put("address", "guangzhou");
        map.put("lover", "martin");
        map.put("pet", "qinghua");
        map.put("height", "178");
        map.put("weigh", "65");


        System.out.println(map);


        String weigh = map.get("weigh");
        System.out.println(weigh);


        String address = map.get("address");
        System.out.println(address);


        String address1 = map.remove("address");
        System.out.println(map);

        String address2 = map.get("address");
        System.out.println(address2);

        String put = map.put("address", "guangzhou");
        System.out.println(map);
    }
}
