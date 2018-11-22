import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMax {

    public static void main(String[] args) {
        List<Vegetable> vegetables = Arrays.asList(new Vegetable("Carrot", 5),
                                                   new Vegetable("Potato", 4),
                                                   new Vegetable("Cabage", 10),
                                                   new Vegetable("Tomato", 3));
        System.out.println("Max weight : " + vegetables.stream().max(Comparator.comparing(Vegetable::getWeight)));
        System.out.println("Min weight : " + vegetables.stream().min(Comparator.comparing(Vegetable::getWeight)));
    }
}
//Expected output
//Max weight : Optional[Vegetable [name=Cabage, weight=10]]
//Min weight : Optional[Vegetable [name=Tomato, weight=3]]
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