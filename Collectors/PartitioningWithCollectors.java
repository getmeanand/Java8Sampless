package java8.tips.collector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningWithCollectors {

    public static void main(String args[]) {
        Map<Boolean, List<Employee>> employeeMap = EmployeeUtil.getEmployeeList().stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() > 30));
        System.out.println("Employees partitioned based on Predicate - 'age > 30'");
        employeeMap.forEach((Boolean key, List<Employee> empList) -> System.out.println(key + "->" + empList));
    }
}

// Expected output:
//Employees partitioned based on Predicate - 'age > 30'
//false->[Employee [name=Harry Major, age=26]
//, Employee [name=Nancy Smith, age=22]
//, Employee [name=Catherine Jones, age=21]
//]
//true->[Employee [name=Tom Jones, age=45]
//, Employee [name=Ethan Hardy, age=65]
//, Employee [name=James Elliot, age=58]
//, Employee [name=Frank Anthony, age=55]
//, Employee [name=Michael Reeves, age=40]
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
