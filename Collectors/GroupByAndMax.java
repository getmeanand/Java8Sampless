import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupByAndMax {

	public static void main(String[] args) {
		Map<String, Optional<StudentDetails>> firstMarkHoldersSubjectwise = 
				getInput().parallelStream()
						  .collect(Collectors.groupingBy(StudentDetails::getSubject,
								  		Collectors.maxBy(Comparator.comparing(StudentDetails::getMarks))));
		System.out.println(firstMarkHoldersSubjectwise);
	}

	private static List<StudentDetails> getInput() {
		List<StudentDetails> students = new ArrayList<>();
		students.add(new StudentDetails("John", "Maths", 23));
		students.add(new StudentDetails("Remo", "Maths", 89));
		students.add(new StudentDetails("Paul", "Maths", 67));
		students.add(new StudentDetails("John", "Physics", 50));
		students.add(new StudentDetails("Remo", "Physics", 67));
		students.add(new StudentDetails("Paul", "Physics", 87));
		return students;
	}
}
// Expected output
// {Maths=Optional[Remo], Physics=Optional[Paul]}
class StudentDetails {
	private String name;
	private String subject;
	private Integer marks;

	public StudentDetails(String name, String subject, Integer marks) {
		this.name = name;
		this.subject = subject;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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