/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BD.Consultador;
import Modelo.Estudiante;
import Modelo.Usuario;
import Vista.AccionesUI;
import Vista.InicioEstudiante;
import Vista.InstructoresUI;
import Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author mauro
 */
public class ControladorLogin implements ActionListener {
    
    Usuario usuario = new Usuario();
    Login vista = new Login();
    AccionesUI inicio = new AccionesUI();
    InicioEstudiante inEst= new InicioEstudiante();
    Consultador consultas = new Consultador();
    
    public ControladorLogin(Usuario usuario, Login vista, Consultador consultas, AccionesUI inicio, InicioEstudiante inEst){
    
       this.usuario=usuario;
       this.vista = vista;
       this.vista.usuarioBoton.addActionListener(this);
       this.consultas=consultas;
       this.inicio=inicio;
       this.inEst= inEst;
       
    }

    //Funcion Para desplegar Menú
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == vista.usuarioBoton) {
            Verificar();
        }else if(e.getSource() == vista.usuarioBoton){
        
        }
        
    }
    
    public void Verificar(){
    
        llenarUsuario();
        
        if (consultas.buscarUsuario(usuario)) {
            
           switch(usuario.getTipo()){
       
            case 1:
                inicio.setVisible(true);
                vista.dispose();
                return;
            case 2:
                inEst.setVisible(true);
                vista.dispose();
                return;
                
           }
        } else {
            JOptionPane.showMessageDialog(null, "Datos incorrectos o Usuario no existente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void llenarUsuario() {
        
        usuario.setNombre(vista.txt_user.getText());
        usuario.setContrasenia(vista.txt_contrasenia.getText());
    }
    
    
    
}
