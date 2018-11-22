import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CascadeSorting {

    public static void main(String[] args) {
        List<Person> studentList = new ArrayList<>();
        studentList.add(new Person("Anbu", "ROLL1"));
        studentList.add(new Person("Anbu", "ROLL2"));
        studentList.add(new Person("Ramu", "ROLL3"));

        studentList.sort(Comparator.comparing(Person::getStudentName).reversed()
                                    .thenComparing(Comparator.comparing(Person::getRollNo)));
        System.out.println("Prining Students Name: \n" + studentList);
    }

}
//Expected output
//Prining Students Name: 
//[Person [studentName=Ramu, rollNo=ROLL3]
//, Person [studentName=Anbu, rollNo=ROLL1]
//, Person [studentName=Anbu, rollNo=ROLL2]
//]
class Person {
    private String studentName;
    private String rollNo;

    public Person(String studentName, String rollNo) {
        this.studentName = studentName;
        this.rollNo = rollNo;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Person [studentName=" + studentName + ", rollNo=" + rollNo + "]\r";
    }

}