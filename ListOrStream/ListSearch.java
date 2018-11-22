package java8.tips.list;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class ListSearch {

	public static void main(String args[]) {
		String searchName = "Tom Jones";
		// Pre-java 8 (Imperative)
		Employee result = null;
		for (Employee employee : EmployeeUtil.getEmployeeList()) {
			if (searchName.equals(employee.getName())) {
				result = employee;
				break;
			}
		}
		if (result != null) {
			print(result);
		}
		// Java 8 (Declarative)
		Optional<Employee> resultJava8 = EmployeeUtil.getEmployeeList()
				.stream()
				.filter(employee -> searchName.equals(employee.getName()))
				.findFirst();
		resultJava8.ifPresent(ListSearch::print);
	}

	private static void print(Employee result) {
		System.out.println("Record found : " + result.getName() + " Age: "
				+ result.getAge());
	}
}
//Result
//---------------------------------------
//Imperative
//Record found : Tom Jones Age: 45

//Declarative
//Record found : Tom Jones Age: 45

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



