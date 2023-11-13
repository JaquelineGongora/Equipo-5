import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private JButton studentsButton;
    private JButton coursesButton;
    private JButton diplomasButton;

    public MainFrame() {
        setTitle("Gestión de Estudiantes");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        studentsButton = new JButton("Administrar Estudiantes");
        coursesButton = new JButton("Administrar Cursos");
        diplomasButton = new JButton("Administrar Diplomas");

        studentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openStudentsManagementWindow();
            }
        });

        // Agregar eventos a los otros botones (cursos y diplomas)

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(studentsButton);
        panel.add(coursesButton);
        panel.add(diplomasButton);

        getContentPane().add(panel);
    }

    private void openStudentsManagementWindow() {
        StudentsManagementFrame studentsFrame = new StudentsManagementFrame();
        String[] studentData = fetchStudentDataFromDatabase(); // Obtener datos reales de la base de datos
        studentsFrame.setStudentData(studentData);
        studentsFrame.setVisible(true);
    }

    // Otras funciones para abrir ventanas de administración de cursos, diplomas.

    private String[] fetchStudentDataFromDatabase() {
        // Implementar la lógica para obtener los datos reales de estudiantes desde la base de datos
        // Devuelve los datos como un arreglo de cadenas
        // Podemos implementar una conexión a la base de datos para esto.

        // Este es un ejemplo de como quedaría
        String[] studentData = {
            "Estudiante 1",
            "Estudiante 2",
            "Estudiante 3",
            "Estudiante 4",
            "Estudiante 5"
        };
        return studentData;
    }
}
