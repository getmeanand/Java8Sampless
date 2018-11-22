package java8.tips.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateNegate {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("A", "B", "C");
        Predicate<String> p = s -> "A".equals(s);
        
        System.out.println(filter(input, p.negate()));
    }

    public static List<String> filter(List<String> list, Predicate<String> p) {
        return list.stream()
                   .filter(p::test)
                   .collect(Collectors.toList());
    }

}
//Expected output
//[B, C]
