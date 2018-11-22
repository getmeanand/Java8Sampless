import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Counting {

    public static void main(String[] args) {
        List<Vegetable> vegetables = Arrays.asList(new Vegetable("Carrot", 5),
                new Vegetable("Potato", 4),
                new Vegetable("Cabbage", 10),
                new Vegetable("Tomato", 3),
                new Vegetable("Carrot", 3));
        // Count the occurrences of each vegetables
        System.out.println(vegetables.parallelStream()
                                     .collect(Collectors.groupingBy(Vegetable::getName, Collectors.counting())));
    }
}
// Expected output
//{Potato=1, Carrot=2, Cabbage=1, Tomato=1}
class Vegetable {
    private String name;
    private Integer weight;
    public Vegetable(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Vegetable [name=" + name + ", weight=" + weight + "]";
    }
}
