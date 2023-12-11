/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ec;
import Controlador.ControladorLogin;
import BD.Consultador;
import Modelo.Usuario;
import Vista.AccionesUI;
import Vista.InicioEstudiante;
import Vista.Login;
/**
 *
 * @author margl
 */
public class Main {

    public static void main(String[] args) {
         
        Login vista = new Login();
        Usuario usuario = new Usuario();
        AccionesUI inicio = new AccionesUI();
        InicioEstudiante inEst= new InicioEstudiante();
        Consultador consulta = new Consultador();
        ControladorLogin controlador = new ControladorLogin(usuario, vista,consulta, inicio, inEst);
        vista.setVisible(true);
    }
    
}
