import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String lastName;
    private String studentNumber;
    private String email;
    private List<Grade> grades;

    public Student(String name, String lastName, String studentNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.email = email;
        this.grades = new ArrayList<>();
    }

    public void register(Course course, double grade) {
        Grade newGrade = new Grade(this, course, grade);
        grades.add(newGrade);
    }

    public void modify(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public void reviewGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
        } else {
             System.out.println("-------------------");
            System.out.println("Grades for " + name + " " + lastName + ":");
            for (Grade grade : grades) {
                System.out.println("Course/Diploma: " + getCourseInfo(grade.getCourseOrDiploma()));
                System.out.println("Grade: " + grade.getGrade());
                System.out.println("-------------------");
            }
        }
    }

    private String getCourseInfo(Object courseOrDiploma) {
        if (courseOrDiploma instanceof Course) {
            Course course = (Course) courseOrDiploma;
            return course.getName();
        } else if (courseOrDiploma instanceof Diploma) {
            Diploma diploma = (Diploma) courseOrDiploma;
            return diploma.getName();
        }
        return "Unknown";
    }
}