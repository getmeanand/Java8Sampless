import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctElement {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("A", "B", "B", "D", "D");
        System.out.println(input.stream()
                                .distinct()
                                .collect(Collectors.toList()));
    }
}
//Expected output
// [A, B, D]