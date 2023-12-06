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
       this.vista.btn_agregarIC.addActionListener(this);
       this.vista.btn_modificar.addActionListener(this);
       this.vista.btn_buscar.addActionListener(this);
       this.vista.btn_limpiar.addActionListener(this);
       this.vista.btn_mostrar.addActionListener(this);
       
    }

    //Funcion Para desplegar Menú
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btn_agregarIC) {
            AgregarEstudiante();
        } else if (e.getSource() == vista.btn_modificar) {
            ModificarEstudiante();
            Mostrar();
           limpiarCampos();
        } else if (e.getSource() == vista.btn_buscar) {
            BuscarEstudiante();
        } else if (e.getSource() == vista.btn_limpiar) {
            limpiarCampos();
        } else if(e.getSource()==vista.btn_mostrar){
            Mostrar();
        }
    }

   public void Mostrar(){
        consultador.MostrarAlumnos(vista.tabla2);
    }

    public void Seleccionar(JTable paramTabla, JTextField matricula, JTextField paramNombres, JTextField calif1, JTextField md2, JTextField md3, JTextField md4, JTextField cfinal){
    
        try {
            
            int fila = paramTabla.getSelectedRow();
            
            if(fila>=0){
                matricula.setText((paramTabla.getValueAt(fila, 0).toString()));
                paramNombres.setText((paramTabla.getValueAt(fila, 1).toString()));
                calif1.setText((paramTabla.getValueAt(fila, 2).toString()));
                cfinal.setText((paramTabla.getValueAt(fila, 6).toString()));
                
                
                boolean dip=true;
                
                 if(Integer.parseInt(paramTabla.getValueAt(fila, 2).toString())>=70){
                    vista.txt_estado1.setText("Aprobado");
                 }else{
                    vista.txt_estado1.setText("Reprobado");
                    dip=false;
                 }
                 
                 if(Integer.parseInt(paramTabla.getValueAt(fila, 3).toString())>=70){
                    vista.txt_md2.setText("Aprobado");
                 }else{
                    vista.txt_md2.setText("Reprobado");
                    dip=false;
                 }
                 
                 if(Integer.parseInt(paramTabla.getValueAt(fila, 4).toString())>=70){
                    vista.txt_md3.setText("Aprobado");
                 }else{
                    vista.txt_md3.setText("Reprobado");
                    dip=false;
                 }
                 
                 if(Integer.parseInt(paramTabla.getValueAt(fila, 5).toString())>=70){
                    vista.txt_md4.setText("Aprobado");
                 }else{
                    vista.txt_md4.setText("Reprobado");
                    dip=false;
                 }
                
                 if(dip){
                    vista.txt_estadoDiplomado.setText("Aprobado");
                }else{
                    vista.txt_estadoDiplomado.setText("Reprobado");
                }
                 
            }else{
                 JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
            
           
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de Selección");
        }
    
    }   
    
    
    
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
        int fila =vista.tabla2.getSelectedRow();
        estudiante.setMatricula(Integer.parseInt(vista.tabla2.getValueAt(fila, 0).toString()));
        estudiante.setCalif1(Integer.parseInt(vista.tabla2.getValueAt(fila, 2).toString()));
        estudiante.setCalif2(Integer.parseInt(vista.tabla2.getValueAt(fila, 3).toString()));
        estudiante.setCalif3(Integer.parseInt(vista.tabla2.getValueAt(fila, 4).toString()));
        estudiante.setCalif4(Integer.parseInt(vista.tabla2.getValueAt(fila, 5).toString()));
        estudiante.setCalif(((estudiante.getCalif1()+estudiante.getCalif2()+estudiante.getCalif3()+estudiante.getCalif4())/4));
        
        
        if (consultador.modificar(estudiante)) {
            JOptionPane.showMessageDialog(null, "Estudiante modificado");
            
            
            if(estudiante.getCalif1()>=70){
               vista.txt_estado1.setText("Aprobado");
            }else{
               vista.txt_estado1.setText("Reprobado");
            }
          
          
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
         estudiante.setMatricula(Integer.parseInt(vista.txt_matricula.getText()));
        if (consultador.buscar(estudiante)) {
            llenarVistaDesdeEstudiante();
            
            if(estudiante.getCalif1()>=70){
               vista.txt_estado1.setText("Aprobado");
            }else{
               vista.txt_estado1.setText("Reprobado");
            }
            
            if(estudiante.getCalif1()<70 || estudiante.getCalif1()<70 || estudiante.getCalif1()<70 || estudiante.getCalif1()<70 ){
            
                vista.txt_estadoDiplomado.setText("Aprobado");
               
            }else{
                vista.txt_estadoDiplomado.setText("Reprobado");
            }
            
            
            int total = (estudiante.getCalif1() + estudiante.getCalif2() + estudiante.getCalif3() + estudiante.getCalif4())/4;
            vista.txt_diplomado.setText(String.valueOf(total));
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al buscar");
            limpiarCampos();
        }
    }
    
    
    public void llenarEstudianteDesdeVista() {
        
        estudiante.setMatricula(Integer.parseInt(vista.txt_matricula.getText()));
        estudiante.setNombre(vista.txt_nombre.getText());
        estudiante.setCalif(Integer.parseInt(vista.txt_Calif.getText()));
    }

    public void llenarVistaDesdeEstudiante() {
        vista.txt_matricula.setText(String.valueOf(estudiante.getMatricula()));
        vista.txt_nombre.setText(estudiante.getNombre());
        vista.txt_Calif.setText(String.valueOf(estudiante.getCalif()));
        
    }

    public void limpiarCampos() {
        vista.txt_nombre.setText("");
        vista.txt_matricula.setText("");
        vista.txt_Calif.setText("");
    }

}
