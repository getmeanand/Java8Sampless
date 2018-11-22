package java8.tips.list;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf {
    public static void main(String[] args) {
        List<String> technologies = getStringList();
        System.out.println("Input => " + technologies);

        // Remove one or more elements from a list, without iteration
        technologies.removeIf((String tech) -> tech.equals("Hibernate"));

        System.out.println("Output after removed => " + technologies);

    }
    public static List<String> getStringList() {
        List<String> input = new ArrayList<String>();
        input.add("Spring");
        input.add("Hibernate");
        input.add("Microservices");
        input.add("JPA");
        input.add("Java8");
        return input;
    }
}
// Expected output
//Input => [Spring, Hibernate, Microservices, JPA, Java8]
//Output after removed => [Spring, Microservices, JPA, Java8]