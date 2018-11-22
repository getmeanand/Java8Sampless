import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateResemblesIf {

    public static void main(String[] args) {
        Predicate<Integer> younger = age -> age < 30;
        Predicate<Integer> elder = age -> age > 30;
        System.out.println("Youngsters" + employeeFilter(younger));
        System.out.println("Elders" + employeeFilter(elder));
    }
    // Reusing this method by passing dynamic if conditions
    // with the help of Predicate
    public static List<Employee> employeeFilter(Predicate<Integer> predicate) {
        return EmployeeUtil.getEmployeeList()
                .stream()
                .filter(e -> predicate.test(e.getAge()))
                .collect(Collectors.toList());
    }
//Expected output
//    Youngsters[Employee [name=Harry Major, age=26]
//            , Employee [name=Nancy Smith, age=22]
//            , Employee [name=Catherine Jones, age=21]
//            ]
//    Elders[Employee [name=Tom Jones, age=45]
//            , Employee [name=Ethan Hardy, age=65]
//            , Employee [name=James Elliot, age=58]
//            , Employee [name=Frank Anthony, age=55]
//            , Employee [name=Michael Reeves, age=40]
//            ]

}

// Other supporting classes
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
