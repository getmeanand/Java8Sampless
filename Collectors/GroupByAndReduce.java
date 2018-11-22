package java8.tips.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByAndReduce {

    public static void main(String[] args) {
       Map<String, List<Vegetables>> input = getList().parallelStream()
                                                      .collect(Collectors.groupingBy(Vegetables::getItem));
       System.out.println("Total Kgs in each item follows");
       input.entrySet().stream().forEach(e -> {
           System.out.println(e.getKey() + "\t: " + e.getValue().stream()
                                                                .map(Vegetables::getWeight)
                                                                .reduce(0, (a,b) -> a + b));
       });
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
//Total Kgs in each item follows
//Potato  : 23
//Onion   : 79
//Tomato  : 42

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