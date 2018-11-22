package java8.tips.map;

import java.util.HashMap;
import java.util.Map;

public class MapIteration {

    public static void main(String[] args) {
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        inputMap.put("key3", "value3");

        System.out.println("# simple iteration");
        inputMap.forEach((k, v) -> {
            System.out.println("key : " + k + " value : " + v);
        });

        System.out.println("# if you need stream");
        inputMap.entrySet()
                .stream()
                 //.filter( entrySet-> entrySet.getKey().equals("key2")) use if needed
                .forEach(entrySet -> System.out.println("key : " + entrySet.getKey() + " value : " + entrySet.getValue()));
    }
}
// Expected output
//# simple iteration
//key : key1 value : value1
//key : key2 value : value2
//key : key3 value : value3
//# if you need stream
//key : key1 value : value1
//key : key2 value : value2
//key : key3 value : value3

