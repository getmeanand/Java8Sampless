package java8.tips.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfList {
    public static void main(String[] args) {
        // Some operation which gives List<List<?>>
        List<String> sample = Arrays.asList("A", "AA", "AAA");
        List<List<String>> input = sample.stream()
                                         .map(ListOfList::testMethod)
                                         .collect(Collectors.toList());
        System.out.println(input);
        // Streaming into single List<>
        List<String> output = input.stream()
                                   .flatMap(List::stream)
                                   .collect(Collectors.toList());

        System.out.println(output);

    }

    public static List<String> testMethod(String input) {
        return Arrays.asList(input);
    }
}
// Expected output
//[[A], [AA], [AAA]]
//[A, AA, AAA]