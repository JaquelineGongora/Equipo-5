/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author margl
 */
public class Conexion {
    
    Connection conectar=null;
    
    //Datos para acceder a la conexión
    String usuario ="root";
    String contrasenia = "mauro1407";
    String ip = "localhost";
    String bd = "ec";
    String puerto = "3306";
    String cadena = "jdbc:mysql://" +ip+":"+ puerto+"/"+bd;
    
    public Connection getConexion(){
    
       try {
           
           Class.forName("com.mysql.cj.jdbc.Driver");
           conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
           //JOptionPane.showMessageDialog(null, "Conexión Exitosa");
           
       } catch(Exception e){
       
           JOptionPane.showMessageDialog(null, "no conexion");
       
       }
       return conectar;
    }
    
}
