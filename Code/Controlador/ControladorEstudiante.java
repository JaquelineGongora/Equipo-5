package Controlador;

import Modelo.Consultas;
import Modelo.Estudiante;
import Vista.NewJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;


public class ControladorEstudiante implements ActionListener{
   
    Estudiante estudiante;
    NewJFrame vista;
    Consultas consultador;
    JTextArea textArea;
    

    //Constructor 
    public ControladorEstudiante(NewJFrame vista, Consultas consultador, Estudiante estudiante){
       this.estudiante=estudiante;
       this.vista = vista;
       this.consultador=consultador;
       this.vista.btn_agregar.addActionListener(this);
       this.vista.btn_modificar.addActionListener(this);
       this.vista.btn_eliminar.addActionListener(this);
       this.vista.btn_buscar.addActionListener(this);
       this.vista.btn_limpiar.addActionListener(this);
       
    }

    //Funcion Para desplegar Menú
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btn_agregar) {
            AgregarEstudiante();
        } else if (e.getSource() == vista.btn_modificar) {
            ModificarEstudiante();
        } else if (e.getSource() == vista.btn_eliminar) {
            EliminarEstudiante();
        } else if (e.getSource() == vista.btn_buscar) {
            BuscarEstudiante();
        } else if (e.getSource() == vista.btn_limpiar) {
            limpiarCampos();
        }
    }

    /*
    //Función Para Ordenar Por Nombre
    public List<Estudiante> OrdenarNombre(){
    
        //Se obtienen los datos de la lista por medio del consultador
        List<Estudiante> productos = consultador.CargarBase();
        
        //Collections ordena la lista por el nombre ascendentemente por medio del comparador que va comparando cada nombre
        Collections.sort(productos, Comparator.comparing(Estudiante::getNombre, String.CASE_INSENSITIVE_ORDER));
        //Se devuelve la lista ordenada
        return productos;
        
    }
    
    //Función Para Ordenar Por Precio
    public List<Estudiante> OrdenarPrecio() {
        //Se obtienen los datos de la lista por medio del consultador
        List<Estudiante> productos = consultador.CargarBase();
        //Collections ordena la lista por precio de menor a mayor por medio del comparador que va comparando cada nombre
        Collections.sort(productos, Comparator.comparing(Estudiante::getPrecio));
        return productos;
    }
*/
    
    
     public void AgregarEstudiante() {
        llenarEstudianteDesdeVista();
        if (consultador.registrar(estudiante)) {
            JOptionPane.showMessageDialog(null, "Estudiante agregado");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar");
            limpiarCampos();
        }
    }

    public void ModificarEstudiante() {
        llenarEstudianteDesdeVista();
        if (consultador.modificar(estudiante)) {
            JOptionPane.showMessageDialog(null, "Estudiante modificado");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");
            limpiarCampos();
        }
    }

    public void EliminarEstudiante() {
        estudiante.setId(Integer.parseInt(vista.txt_id.getText()));
        if (consultador.eliminar(estudiante)) {
            JOptionPane.showMessageDialog(null, "Estudiante eliminado");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
            limpiarCampos();
        }
    }
    
    public void BuscarEstudiante() {
        estudiante.setId(Integer.parseInt(vista.txt_id.getText()));
        if (consultador.buscar(estudiante)) {
            llenarVistaDesdeEstudiante();
        } else {
            JOptionPane.showMessageDialog(null, "Error al buscar");
            limpiarCampos();
        }
    }
    
    
    public void llenarEstudianteDesdeVista() {
        
        estudiante.setMatricula(Integer.parseInt(vista.txt_matricula.getText()));
        estudiante.setNombre(vista.txt_nombre.getText());
        estudiante.setDiplomado(vista.txt_diplomado.getText());
        estudiante.setCalif(Integer.parseInt(vista.txt_Calif.getText()));
    }

    public void llenarVistaDesdeEstudiante() {
        vista.txt_id.setText(String.valueOf(estudiante.getId()));
        vista.txt_matricula.setText(String.valueOf(estudiante.getMatricula()));
        vista.txt_nombre.setText(estudiante.getNombre());
        vista.txt_diplomado.setText(estudiante.getDiplomado());
        vista.txt_Calif.setText(String.valueOf(estudiante.getCalif()));
        
    }

    public void limpiarCampos() {
        vista.txt_id.setText("");
        vista.txt_nombre.setText("");
        vista.txt_diplomado.setText("");
        vista.txt_matricula.setText("");
        vista.txt_Calif.setText("");
    }

}
