package java8.tips.predicate;

import java.util.Optional;

public class Pipeline {

    public static void main(String[] args) {
        //Possibles inputs
        Integer input = 12345678;
        //Integer input = 123456789;
        //Integer input = 1234567891;
        //Integer input = null;
        
        System.out.println("Declarative Style : " + addTrailingZero9Declarative(input));
        System.out.println("Imperative Style  : " + addTrailingZero9Imperative(input));
    }
    
    public static Integer addTrailingZero9Imperative(Integer input) {
        Integer result;
        if (input != null) {
            int noOfZeros = 9 - (String.valueOf(input).length());
            Double multiplier = Math.pow(10, noOfZeros);
            result = input * Math.max(multiplier.intValue(), 1);
        } else {
            result = null;
        }
        return result;
    }

    public static Integer addTrailingZero9Declarative(Integer input) {
       return Optional.ofNullable(input)
        .map(e-> Integer.valueOf(9 - (String.valueOf(e).length())))
        .map(noOfZeros->Math.pow(10, noOfZeros))
        .map(e-> input * Math.max(e.intValue(), 1))
        .orElse(null);
    }
}
// Expected output
//Declarative Style : 123456780
//Imperative Style  : 123456780
