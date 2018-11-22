package java8.tips.optional;

import java.util.Optional;

public class IfPresent {

    public static void main(String[] args) {
        String name = "Java8";
        
        // Method #1
        if(Optional.ofNullable(name).isPresent()) {
            print(name);
        }
        
        // Method #2 
        // Suitable only your method consumes one input
        Optional.ofNullable(name).ifPresent(IfPresent::print);
    }
    
    // Consumer
    private static void print(String input) {
        System.out.println("Result output : " + input);
    }

}

// Expected output
//Result output : Java8
//Result output : Java8