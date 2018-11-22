package java8.tips.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsAsList {

    public static Integer i = 0;

    public static void main(String[] args) {
        // Wrong usage
        List<Integer> output = new ArrayList<>();
        getStringList().stream()
                       .forEach(e -> output.add(sendInt(e)));
        System.out.println(output);

        // Correct usage
        List<Integer> testList = getStringList().stream()
                                                .map(e -> sendInt(e))
                                                .collect(Collectors.toList());
        System.out.println(testList);
    }

    public static List<String> getStringList() {
        // Random Input
        List<String> input = new ArrayList<String>();
        input.add("a");
        input.add("b");
        input.add("c");
        return input;
    }

    public static Integer sendInt(String input) {
        // Some business operation
        return i++;
    }
}

// Expected Output
//[0, 1, 2]
//[3, 4, 5]
