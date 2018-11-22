import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLambda {

    public static void main(String[] args) {
        List<Student> students = getInput();
        // Grouping students into GRADE-wise based on their marks
        Map<Object, List<Student>> studentByGrade =
                students.stream().collect(Collectors.groupingBy(student -> {
                    if (student.getMarks() > 80) return Grade.A;
                    else if (student.getMarks() > 60) return Grade.B;
                    else return Grade.C;
                }));
        System.out.println(studentByGrade);
    }

    private static List<Student> getInput() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 87));
        students.add(new Student("Remo", 91));
        students.add(new Student("Paul", 67));
        students.add(new Student("Prince", 34));
        students.add(new Student("Melvin", 50));
        return students;
    }
}

enum Grade {
    A, B, C
}

// Expected output
// {C=[Prince, Melvin], B=[Paul], A=[John, Remo]}
class Student {
    private String name;
    private Integer marks;
    public Student(String name, Integer marks) {
        this.name = name;
        this.marks = marks;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getMarks() {
        return marks;
    }
    public void setMarks(Integer marks) {
        this.marks = marks;
    }
    @Override
    public String toString() {
        return name;
    }
    
}
