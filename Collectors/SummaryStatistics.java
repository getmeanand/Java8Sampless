package java8.tips.collector;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SummaryStatistics {

    public static void main(String[] args) {
        List<Student> students = getInput();
        IntSummaryStatistics statistics = students.stream()
                 .collect(Collectors.summarizingInt(Student::getMarks));
        //IntSummaryStatistics{count=5, sum=329, min=34, average=65.800000, max=91}
        System.out.println("First mark : " + statistics.getMax());
        System.out.println("Last mark : " + statistics.getMin());
        System.out.println("Average marks : " + statistics.getAverage());
        // Note: use DoubleSummaryStatistics/LongSummaryStatistics if your input data type is Double/Long
        // here it is Integer so IntSummaryStatistics is the output
    }
// Expected output
//    First mark : 91
//    Last mark : 34
//    Average marks : 65.8
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