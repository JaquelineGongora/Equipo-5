import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StudentsManagementFrame extends JFrame {
    public StudentsManagementFrame() {
        setTitle("Lista de Estudiantes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setStudentData(String[] studentData) {
        // Configurar la lista de estudiantes con los datos 
        JList<String> studentList = new JList<>(studentData);
        JScrollPane scrollPane = new JScrollPane(studentList);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(panel);
    }
}
