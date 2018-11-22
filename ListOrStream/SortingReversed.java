package java8.tips.list;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingReversed {
    public static void main(String[] args) {
        // Comparator for sorting Name in Ascending order
        Comparator<Employee> nameSorting = (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName());
        
        List<Employee> employees = EmployeeUtil.getEmployeeList();
        System.out.println("Input => " + employees);
        Collections.sort(employees, nameSorting.reversed()); // reusing [nameSorting] for descending order
        System.out.println("Output in desc order but used asc order comparator => " + employees);
    }

}
// Expected output
//Input => [Employee [name=Tom Jones, age=45]
//, Employee [name=Harry Major, age=26]
//, Employee [name=Ethan Hardy, age=65]
//, Employee [name=Nancy Smith, age=22]
//, Employee [name=Catherine Jones, age=21]
//, Employee [name=James Elliot, age=58]
//, Employee [name=Frank Anthony, age=55]
//, Employee [name=Michael Reeves, age=40]
//]
//Output in desc order but used asc order comparator => [Employee [name=Tom Jones, age=45]
//, Employee [name=Nancy Smith, age=22]
//, Employee [name=Michael Reeves, age=40]
//, Employee [name=James Elliot, age=58]
//, Employee [name=Harry Major, age=26]
//, Employee [name=Frank Anthony, age=55]
//, Employee [name=Ethan Hardy, age=65]
//, Employee [name=Catherine Jones, age=21]
//]

//Other supporting classes
class EmployeeUtil {

 // Sample inputs
     public static List<Employee> employeeList = Arrays.asList(
             new Employee("Tom Jones", 45),
             new Employee("Harry Major", 26),
             new Employee("Ethan Hardy", 65),
             new Employee("Nancy Smith", 22),
             new Employee("Catherine Jones", 21),
             new Employee("James Elliot", 58),
             new Employee("Frank Anthony", 55),
             new Employee("Michael Reeves",40));
     
 public static List<Employee> getEmployeeList() {
     return employeeList;
 }
}

class Employee {
 private String name;
 private Integer age;

 public Employee() {

 }

 public Employee(String name, Integer age) {
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
     return "Employee [name=" + name + ", age=" + age + "]\n";
 }

}
