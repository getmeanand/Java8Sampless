import java.util.Optional;

public class MethodReference {

    public static void main(String[] args) {
    	MethodReference mr = new MethodReference();
    	String output =
    	Optional.ofNullable(mr.process("Any method which accepts/applys on one input"))
    	// cannot apply Method reference for the below code, since 2 inputs needed
    	.map(in -> in.concat(" can be replaced with Method reference"))  
    	.orElse("Default");
    	System.out.println(output);
    }
    
    public String referenceMethod(String input) { 
        return Optional.ofNullable(input)
        			// .map(in -> in.toUpperCase())
        			   .map(String::toUpperCase) // Calling static method
        			   .orElse(input);
    }
    
    public String process(String input) {
    	return Optional.ofNullable(input)
    				// .map(in -> referenceMethod(in)) 
    				   .map(this::referenceMethod) // Calling non-static method
    				   .orElse(null);
    }
}
// Expected output
// ANY METHOD WHICH ACCEPTS/APPLYS ON ONE INPUT can be replaced with Method reference