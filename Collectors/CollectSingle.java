package java8.tips.collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectSingle {

    public static void main(String[] args) {
        List<String> sample = Arrays.asList("A", "B", "C");
        System.out.println(sample.stream()      // Seperator ','
                                 .collect(Collectors.joining(",")));
    }

}
// Expected output
// A,B,C