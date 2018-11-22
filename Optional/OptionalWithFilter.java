package java8.tips.optional;

import java.util.Optional;

public class OptionalWithFilter {

    public static void main(String[] args) {
        //Integer testNumber = 5;
        //Integer testNumber = 4;
        Integer testNumber = null;
        
        // Requirement #1
        // if you want to consume if present and met the condition or return 0
        System.out.println("Multiply by 2 if present and even :" +
                Optional.ofNullable(testNumber)
                        .filter(e->e % 2 == 0)
                        .map(e -> e * 2)
                        .orElse(0));
    }

}

// if input is odd
// Multiply by 2 if present and even :0
// ------------------------------------
// if input is even
// Multiply by 2 if present and even :8
// ------------------------------------
// if input is null
// Multiply by 2 if present and even :0

