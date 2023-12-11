/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BD.Consultador;
import Modelo.Estudiante;
import Vista.InstructoresUI ;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorInstructor implements ActionListener {
    
    Estudiante estudiante;
    InstructoresUI vista;
    Consultador consultador;
    JTextArea textArea;
   
    

    //Constructor 
    public ControladorInstructor(InstructoresUI vista, Consultador consultador, Estudiante estudiante){
       this.estudiante=estudiante;
       this.vista = vista;
       this.consultador=consultador;
       this.vista.btn_modificar.addActionListener(this);
       this.vista.btn_mostrar.addActionListener(this);
       this.vista.buscar_btn.addActionListener(this);
       
    }

    //Funcion Para desplegar Menú
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btn_modificar) {
            ModificarEstudiante();
            Mostrar();
            limpiarCampos();
        }else if(e.getSource()==vista.btn_mostrar){
            Mostrar();
        }else if(e.getSource()==vista.buscar_btn){
            buscar();
        }
    }

    //Despliega la tabla con los datos de los alumnos
    public void Mostrar(){
        
    
        consultador.MostrarAlumnos(vista.tabla2);
        
    
    }

    //Acciones en vista cuando se selecciona una fila
    public void Seleccionar(JTable paramTabla, JTextField matricula, JTextField paramNombres, JTextField calif1, JTextField md2, JTextField md3, JTextField md4, JTextField cfinal){
    
        try {
            
            int fila = paramTabla.getSelectedRow();
            
            if(fila>=0){
                //Guarda los valores de la fila seleccionada
                matricula.setText((paramTabla.getValueAt(fila, 0).toString()));
                paramNombres.setText((paramTabla.getValueAt(fila, 1).toString()));
                calif1.setText((paramTabla.getValueAt(fila, 2).toString()));
                cfinal.setText((paramTabla.getValueAt(fila, 6).toString()));
                
                
                boolean dip=true;

                //Muetra "Reprobado" y hace el jtext rojo si la calificación es menor a 60, "aprobado" y vuelve el  text field verde si es mayor o igual a 60. Esto para cada modulo y diplomado
                 if(Integer.parseInt(paramTabla.getValueAt(fila, 2).toString())>=60){
                    vista.txt_estado1.setText("Aprobado");
                    vista.txt_estado1.setBackground(Color.GREEN); 
                 }else{
                    vista.txt_estado1.setText("Reprobado");
                    vista.txt_estado1.setBackground(Color.RED); 
                    dip=false;
                 }
                 
                 if(Integer.parseInt(paramTabla.getValueAt(fila, 3).toString())>=60){
                    vista.txt_md2.setText("Aprobado");
                     vista.txt_md2.setBackground(Color.GREEN); 
                 }else{
                    vista.txt_md2.setText("Reprobado");
                    vista.txt_md2.setBackground(Color.RED); 
                    dip=false;
                 }
                 
                 if(Integer.parseInt(paramTabla.getValueAt(fila, 4).toString())>=60){
                    vista.txt_md3.setText("Aprobado");
                    vista.txt_md3.setBackground(Color.GREEN); 
                 }else{
                    vista.txt_md3.setText("Reprobado");
                    vista.txt_md3.setBackground(Color.RED); 
                    dip=false;
                 }
                 
                 if(Integer.parseInt(paramTabla.getValueAt(fila, 5).toString())>=60){
                    vista.txt_md4.setText("Aprobado");
                     vista.txt_md4.setBackground(Color.GREEN); 
                 }else{
                    vista.txt_md4.setText("Reprobado");
                    vista.txt_md4.setBackground(Color.RED); 
                    dip=false;
                 }
                
                 if(dip){
                    vista.txt_estadoDiplomado.setText("Aprobado");
                     vista.txt_estadoDiplomado.setBackground(Color.GREEN); 
                }else{
                    vista.txt_estadoDiplomado.setText("Reprobado");
                     vista.txt_estadoDiplomado.setBackground(Color.RED); 
                }
                 
            }else{
                 JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
            
           
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de Selección");
        }
    
    }

    //Modifica los datos desde la tabla
    public void ModificarEstudiante() {
        
        //Guarda los datos de la fila seleccionada en el objeto estudiante
        int fila =vista.tabla2.getSelectedRow();
        estudiante.setMatricula(Integer.parseInt(vista.tabla2.getValueAt(fila, 0).toString()));
        estudiante.setCalif1(Integer.parseInt(vista.tabla2.getValueAt(fila, 2).toString()));
        estudiante.setCalif2(Integer.parseInt(vista.tabla2.getValueAt(fila, 3).toString()));
        estudiante.setCalif3(Integer.parseInt(vista.tabla2.getValueAt(fila, 4).toString()));
        estudiante.setCalif4(Integer.parseInt(vista.tabla2.getValueAt(fila, 5).toString()));
        estudiante.setCalif(((estudiante.getCalif1()+estudiante.getCalif2()+estudiante.getCalif3()+estudiante.getCalif4())/4));
        
        //llama a modificar en el objeto consultador
        consultador.modificar(estudiante);
    }

   
    //Muestra en los  text field los datos de estudiante
    public void llenarVistaDesdeEstudiante() {
        vista.txt_matricula.setText(String.valueOf(estudiante.getMatricula()));
        vista.txt_nombre.setText(estudiante.getNombre());
        vista.txt_Calif.setText(String.valueOf(estudiante.getCalif1()));
        
    }

    //borra los datos de los text field
    public void limpiarCampos() {
       
        vista.txt_nombre.setText("");
        vista.txt_matricula.setText("");
        vista.txt_Calif.setText("");
    }

    //Metodo para filtrar los datos de un alumno desde su matricula
   public void buscar(){

       //Guarda matricula en el objeto estudiante desde vista
       estudiante.setMatricula(Integer.parseInt(vista.txt_matricula.getText()));
        if(consultador.buscar(estudiante)){

            //crea  tabla
            DefaultTableModel modelo = new DefaultTableModel();
            TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
            vista.tabla2.setRowSorter(OrdenarTabla);

            
            modelo.addColumn("Matricula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Modulo 1");
            modelo.addColumn("Modulo 2");
            modelo.addColumn("Modulo 3");
            modelo.addColumn("Modulo 4");
            modelo.addColumn("Final");
        
            vista.tabla2.setModel(modelo);

            //Llena datos de la tabla
            String[] datos = new String[7];
        
            datos[0]=String.valueOf(estudiante.getMatricula());
            datos[1]=String.valueOf(estudiante.getNombre());
            datos[2]=String.valueOf(estudiante.getCalif1());
            datos[3]=String.valueOf(estudiante.getCalif2());
            datos[4]=String.valueOf(estudiante.getCalif3());
            datos[5]=String.valueOf(estudiante.getCalif4());

            //Llena la columna "Final"
         if(estudiante.getCalif1()<=60|| estudiante.getCalif2()<=60 || estudiante.getCalif3()<=60 || estudiante.getCalif4()<=60){
         
              datos[6] = String.valueOf("Reprobado");
         
         }else{
             datos[6] = String.valueOf("Aprobado");
         }
        
                
            modelo.addRow(datos);
        
            vista.tabla2.setModel(modelo);
            
    
        }else{
            JOptionPane.showMessageDialog(null, "Datos incorrectos o Usuario no existente", "Error", JOptionPane.ERROR_MESSAGE);   
        }
        

    
    }
}
