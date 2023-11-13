public class Grade {
    private Student student;
    private Object courseOrDiploma;
    private double grade;

    public Grade(Student student, Object courseOrDiploma, double grade) {
        this.student = student;
        this.courseOrDiploma = courseOrDiploma;
        this.grade = grade;
    }

    public Object getCourseOrDiploma() {
        return courseOrDiploma;
    }

    public double getGrade() {
        return grade;
    }
}
