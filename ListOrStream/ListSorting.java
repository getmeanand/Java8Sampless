package java8.tips.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSorting {
    public static void main(String[] args) {
        // using List of string
        List<String> testList = getStringList();
        System.out.println("Input => " + testList);
        Collections.sort(testList, (String p1, String p2) -> p1.compareTo(p2));
        System.out.println("Output asc order => " + testList);

        // using List of Object
        List<Employee> employees = EmployeeUtil.getEmployeeList();
        System.out.println("Input => " + employees);
        Collections.sort(employees, (Employee e1, Employee e2) -> e2.getName().compareTo(e1.getName()));
        System.out.println("Output desc order => " + employees);
    }

    public static List<String> getStringList() {
        List<String> input = new ArrayList<String>();
        input.add("Java");
        input.add("Dot net");
        input.add("SAP");
        return input;
    }
}
// Expected output
//Input => [Java, Dot net, SAP]
//Output asc order => [Dot net, Java, SAP]
//Input => [Employee [name=Tom Jones, age=45]
//, Employee [name=Harry Major, age=26]
//, Employee [name=Ethan Hardy, age=65]
//, Employee [name=Nancy Smith, age=22]
//, Employee [name=Catherine Jones, age=21]
//, Employee [name=James Elliot, age=58]
//, Employee [name=Frank Anthony, age=55]
//, Employee [name=Michael Reeves, age=40]
//]
//Output desc order => [Employee [name=Tom Jones, age=45]
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