package java8.tips.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PassFunction {

    public static void main(String[] args){
        List<Person> organization = new ArrayList<>();
        organization.add(new Person("Student1", true));
        organization.add(new Person("Student2", true));
        organization.add(new Person("Professor1", false));
        
        // Passing function as parameter
        System.out.println("Prining Students Name: " +
        organization.stream().map(e -> getPersonName(e, Person::getStudentName)).collect(Collectors.toList()));
    }
    
    public static String getPersonName(Person person, Function<Person, String> nameExpected) {
        // Assume some complex logic exists only getting name is varies
        return nameExpected.apply(person);
    }
}

class Person {
    private boolean isStudent;
    private String professorName;
    private String studentName;
    public Person(String name, boolean isStudent){
        this.isStudent= isStudent;
        if(isStudent){
            this.studentName = name;
        } else {
            this.professorName = name;
        }
    }
    public boolean isStudent() {
        return isStudent;
    }
    public void setStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }
    public String getProfessorName() {
        return professorName;
    }
    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
}
