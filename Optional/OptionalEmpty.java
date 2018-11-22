import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalEmpty {

    public static void main(String[] args) {
       List<Integer> input = Arrays.asList(2, 5, 9);
		
		Optional<Integer> maxValue = getMax(input);
		maxValue.ifPresent(o -> System.out.println("The max value of the list is : " + o));
	}

    private static Optional<Integer> getMax(List<Integer> input) {
        return Optional.ofNullable(input)
                       .map(in -> in.parallelStream().max(Integer::compareTo))
                       .orElse(Optional.empty()); // instead of null
    }
}
// Expected output
// The max value of the list is : 9