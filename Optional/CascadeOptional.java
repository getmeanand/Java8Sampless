import java.util.Optional;

public class CascadeOptional {

    public static void main(String[] args) {
        String input = "Declarative";
        System.out.println("Output => " + limitString1(input, 5));
    }
    public static String limitString1(String input, Integer limit) {
        return Optional.ofNullable(input)
                       .filter(b->b.length() > limit)
                       .map(e-> input.substring(0, limit))
                       .map(String::toUpperCase)
                       .orElse(Optional.ofNullable(input)
                                       .orElse(""));
    }
}
//Expected output
//Output => DECLA