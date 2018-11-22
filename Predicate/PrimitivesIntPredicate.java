package java8.tips.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;


public class PrimitivesIntPredicate {

    public static void main(String[] args) {
        // as Primitives does not support Generics
        // Dedicated Predicates for primitive data types are there
        IntPredicate younger = age -> age < 30;
        IntPredicate elder = age -> age > 30;
        System.out.println("Youngsters" + studentFilter(younger));
        System.out.println("Elders" + studentFilter(elder));
    }

    // Method to filter student based on 'int' predicate
    public static List<Student> studentFilter(IntPredicate predicate) {
        return StudentUtil.getStudentList()
                          .stream()
                          .filter(e -> predicate.test(e.getAge()))
                          .collect(Collectors.toList());
    }
//Expected output
//    Youngsters[Student [name=Ram, age=25]
//    , Student [name=Ragu, age=26]
//    ]
//    Elders[Student [name=Raj, age=31]
//    ]

}
//Other supporting classes
class StudentUtil {

 // Sample inputs
     public static List<Student> studentList = Arrays.asList(
             new Student("Ram", 25),
             new Student("Ragu", 26),
             new Student("Raj", 31));
     
 public static List<Student> getStudentList() {
     return studentList;
 }
}

class Student {
 private String name;
 private int age;

 public Student() {

 }

 public Student(String name, Integer age) {
     this.name = name;
     this.age = age;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public Integer getAge() {
     return age;
 }

 public void setAge(Integer age) {
     this.age = age;
 }

 @Override
 public String toString() {
     return "Student [name=" + name + ", age=" + age + "]\n";
 }

}



