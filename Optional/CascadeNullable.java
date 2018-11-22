package java8.tips.optional;

import java.util.Optional;

public class CascadeNullable {
    public static void main(String[] args) {
        // Possible inputs
        //InnerValueObject input = new InnerValueObject("value");
        InnerValueObject input = null;
        
        ValueObject valueObject = new ValueObject(input);
        System.out.println(
        Optional.ofNullable(valueObject)
                .map(ValueObject::getInnerValueObject) // will be called only if input is not null
                .map(InnerValueObject::getValue) // will be called only if previous output is not null
                .orElse("else case"));
    }
}
// Expected output
// if InnerValueObject is null
//      called : getInnerValueObject()
//      else case
// if InnerValueObject is not null
//      called : getInnerValueObject()
//      called : getValue()
//      value

class ValueObject {
    private InnerValueObject innerValueObject;

    public ValueObject(InnerValueObject innerValueObject) {
        this.innerValueObject = innerValueObject;
    }

    public InnerValueObject getInnerValueObject() {
        System.out.println("called : getInnerValueObject()");
        return innerValueObject;
    }

    public void setInnerValueObject(InnerValueObject innerValueObject) {
        this.innerValueObject = innerValueObject;
    }

}

class InnerValueObject {
    private String value;

    public InnerValueObject(String value) {
        this.value = value;
    }

    public String getValue() {
        System.out.println("called : getValue()");
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
