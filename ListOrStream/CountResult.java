import java.util.ArrayList;
import java.util.List;

public class CountResult {
    public static void main(String[] args) {
        List<String> technologies = getStringList();
        System.out.println("Input => " + technologies);
        
        System.out.println("No. of Technology starts with 'J' : " + technologies.stream()
                                                                         .filter(t -> t.startsWith("J"))
                                                                         .count());

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
//No. of Technology starts with 'J' : 2