import java.util.List;
import java.util.Scanner;

public class Actions {
    
    Scanner scan = new Scanner(System.in);

    public void Menu(){
        System.out.println("¿Qué desea hacer? n"
                + "1.- Añadir alumnos n"
                + "2.- Desplegar lista de alumnos n"
                + "3.- Mostrar alumno n"
                + "4.- Modificar alumno n"
                + "5.- Borrar alumno n"
                + "OTRO --> Salir");
    }

    public int editMenu(){
        int option = 0;
        do{
            System.out.println("¿Qué desea modificar? n"
                    + "1.- Nombre n"
                    + "2.- Apellido n"
                    + "3.- Correo n"
                    + "4.- Número de control n"
                    + "5.- Calificación n"
                    + "OTRO --> Salir");
            option = scan.nextInt();
        }while(option<0 || option>3);

        return option;
    }

    public Student newStudent(){

        System.out.println("Ingrese el nombre del alumno"); 
        String name  = scan.nextLine();
        System.out.println("Ingrese el apellido del alumno");   
        String lastName = scan.nextLine();
        System.out.println("Ingrese el correo del alumno"); 
        String email = scan.nextLine();
        System.out.println("Ingrese el número de control del alumno");  
        int studentNumber = scan.nextInt();
        System.out.println("Ingrese la calificación del alumno");
        int calif = scan.nextInt();

        Student student = new Student(name, lastName, email, studentNumber, calif); 

        return student;

    }

    public boolean empty(List<Student> list, int position){
        boolean empty = false;

        if(list.size()<position){
            empty = true;   
        }

        return empty;

    }

    public Student getStudent(List<Student> list, int position){
        Student student = null;

        if(!empty(list, position)){
            student = list.get(position);
        }

        return student;
    }   

    public void deleteStudent(List<Student> list, int position){
        
        list.remove(this.getStudent(list, position));
        System.out.println("Alumno eliminado"); 

    }   

    public void modifyStudent(List<Student> list, int position){

        this.getStudent(list, position);

        switch(this.editMenu()){
            case 1: //Name
            System.out.println("Ingrese el nuevo nombre del alumno"); 
            String name  = scan.nextLine();
            this.getStudent(list, position).setName(name);
            break;
            case 2: //LastName
            System.out.println("Ingrese el nuevo apellido del alumno");   
            String lastName = scan.nextLine();
            this.getStudent(list, position).setLastName(lastName);
            break;
            case 3: //Email
            System.out.println("Ingrese el nuevo correo del alumno"); 
            String email = scan.nextLine();
            this.getStudent(list, position).setEmail(email);
            break;  
             case 4: //StudentNumber
            System.out.println("Ingrese el nuevo número de control del alumno");  
            int studentNumber = scan.nextInt();
            this.getStudent(list, position).setStudentNumber(studentNumber);
            break;
        case 5: //Calif
            System.out.println("Ingrese la nueva calificación del alumno");
            int calif = scan.nextInt();
            this.getStudent(list, position).setCalif(calif);
            break;  
        default:
            System.out.println("Opción no válida");
            break;
        }

        System.out.println("Alumno modificado");
    }

}
