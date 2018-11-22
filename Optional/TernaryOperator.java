import java.util.Optional;

public class TernaryOperator {

    public static void main(String[] args) {
       //String input = null;
        String input = "Some input";

       // Ternary operation
       System.out.println(input != null ? input : "Input is null");

       // Ternary operation using Optional
       System.out.println(Optional.ofNullable(input).orElse("Input is null"));
    }

}
//Expected output
//Some input
//Some input