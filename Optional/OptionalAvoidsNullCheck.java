package java8.tips.optional;

import java.util.Optional;

public class OptionalAvoidsNullCheck {

    public static void main(String[] args) {
        Integer testNumber = 2;
        //Integer testNumber = null;
        
        // Requirement #1
        // to check only if present or not
        if(Optional.ofNullable(testNumber).isPresent()) {
            System.out.println("Prints only if testNumber is not null");
        }
        
        // Requirement #2
        // if present consume; if not do something something else
        System.out.println("Multiply by 2 if present :" +
                Optional.ofNullable(testNumber).map(e -> e * 2).orElse(0));
    }

}

//Expected output if present
//--------------------------
//Prints only if testNumber is not null
//Multiply by 2 if present :4

//Expected output if not present
//------------------------------
//Multiply by 2 if present :0


