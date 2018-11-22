import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CascadePredicate {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("A", "BA", "AC", "");
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> startsWithA = s -> s.startsWith("A");
        
        // list all values starts with "A"
        System.out.println(filter(input, isEmpty.negate().and(startsWithA)));
    }

    public static List<String> filter(List<String> list, Predicate<String> p) {
        return list.stream()
                   .filter(p::test)
                   .collect(Collectors.toList());
    }

}
//Expected output
//[A, AC]