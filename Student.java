public class Student {
    
    private String name;
    private String lastName;
    private String email;
    private int studentNumber;
    private int calif;


    public Student(String name, String lastName, String email, int studentNumber, int calif) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.studentNumber = studentNumber;
        this.calif = calif;
    }   

    public String getName() {
        return name;
    }   

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCalif() {
        return calif;
    }

    public void setCalif(int calif) {
        this.calif = calif;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } 
    
    public String getEmail() {
        return email;
    }   

    public void setEmail(String email) {
        this.email = email;
    }   

    public int getStudentNumber() {
        return studentNumber;
    }   

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }   

    @Override
    public String toString() {
        return "Student" + "name=" + name + ", lastName=" + lastName + ", email=" + email + ", studentNumber=" + studentNumber + ", calif=" + calif + '}';
    }  
