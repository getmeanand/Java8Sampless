import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {

    public static void main(String[] args) {
       Map<String, List<Vegetables>> input = getList().parallelStream()
                                                      .collect(Collectors.groupingBy(Vegetables::getItem));
       // Grouping records based on one of its character, in this example: item
       System.out.println(input);
    }

    public static List<Vegetables> getList() {
        List<Vegetables> input = new ArrayList<>();
        input.add(new Vegetables("Tomato", 14));
        input.add(new Vegetables("Potato", 23));
        input.add(new Vegetables("Onion", 40));
        input.add(new Vegetables("Tomato", 28));
        input.add(new Vegetables("Onion", 39));
        return input;
    }
}
// Expected output
//{Potato=[java8.tips.collector.Vegetables@6d03e736],
// Onion=[java8.tips.collector.Vegetables@568db2f2, java8.tips.collector.Vegetables@378bf509],
// Tomato=[java8.tips.collector.Vegetables@5fd0d5ae, java8.tips.collector.Vegetables@2d98a335]}



class Vegetables {

    private String item;
    private Integer weight;

    public Vegetables(String item, Integer weight) {
        this.item = item;
        this.weight = weight;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}