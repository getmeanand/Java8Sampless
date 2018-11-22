import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Average {

    public static void main(String[] args) {
        List<Vegetable> vegetables = Arrays.asList(new Vegetable("Carrot", 5),
                                                    new Vegetable("Potato", 4),
                                                    new Vegetable("Cabbage", 10),
                                                    new Vegetable("Tomato", 3));
        System.out.println(
                "Average Kg available in market : " +
                vegetables.stream().collect(Collectors.averagingInt(Vegetable::getWeight)));
    }

}

// Expected output
// Average Kg available in market : 5.5

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
