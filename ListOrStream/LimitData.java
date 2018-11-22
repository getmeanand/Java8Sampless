import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitData {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("A", "B", "C");
        System.out.println(input.stream()
                                .limit(2)
                                .collect(Collectors.toList()));
    }
}
// Expected output
// [A, B]