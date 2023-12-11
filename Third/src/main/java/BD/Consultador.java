/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import Modelo.Estudiante;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author margl
 */
public class Consultador {
    Conexion conexion;
    

    public Consultador(){
        conexion = new Conexion();
    }
    
    public List<Estudiante> CargarBase() {
        
        //Query para poder ver seleccionar los productos en MySql
        String query = "SELECT * FROM Ciberseguridad";
        
        //Se inicia una conexión y se carga en un statement el query 
         try (Connection c = conexion.getConexion();
              PreparedStatement ps = c.prepareStatement(query)){
         
        
             ResultSet rs = ps.executeQuery();
             //Se crea una lista para guardar los productos
             List<Estudiante> estudiantes = new ArrayList<>();
             //Se recorre la lista
             while(rs.next()){
                
                //Se cre un nuevo objeto producto
                Estudiante p = new Estudiante();
                 //Se guardan los valores al objeto
                p.setId(rs.getInt(1));
                p.setMatricula(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setCalif1(rs.getInt(4));
                p.setCalif2(rs.getInt(5));
                p.setCalif3(rs.getInt(6));
                p.setCalif4(rs.getInt(7));
                p.setCalif(rs.getInt(8));
                //Se agrega el producto a la lista
                estudiantes.add(p);
             }
             
             //Se devuelve la lista productos
             return estudiantes;
              
             
         }catch(SQLException e){
           e.printStackTrace();
           throw new RuntimeException("Error", e);
             
         }
    }
    
    public void MostrarAlumnos(JTable paramTabla){
    
        Conexion objetoConexion = new Conexion();
        
        //Ordenar Tabla
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTabla.setRowSorter(OrdenarTabla);
        
        String sql="";
        
        modelo.addColumn("Matricula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Modulo 1");
        modelo.addColumn("Modulo 2");
        modelo.addColumn("Modulo 3");
        modelo.addColumn("Modulo 4");
        modelo.addColumn("Final");
        
        paramTabla.setModel(modelo);
        
        sql = "select * from Ciberseguridad ORDER BY nombre;";
        
        String[] datos = new String[7];
        Statement st;
        
        try {
            st = objetoConexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                
                datos[0]=rs.getString(2);
                datos[1]=rs.getString(3);
                datos[2]=rs.getString(4);
                datos[3]=rs.getString(5);
                datos[4]=rs.getString(6);
                datos[5]=rs.getString(7);
                 int suma = Integer.parseInt(datos[2]) + Integer.parseInt(datos[3]) + Integer.parseInt(datos[4]) + Integer.parseInt(datos[5]);
                 datos[6] = String.valueOf(suma / 4);
                
                modelo.addRow(datos);
            }
            
            paramTabla.setModel(modelo);
            
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo mostrar");
        }
           
    }
    
 
    public boolean registrar(Estudiante estudiante) {
        
        if (estudiante.getCalif1() > 100) {
         JOptionPane.showMessageDialog(null, "Error: La calificación no puede ser mayor de 100.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
        }else if(estudiante.getCalif1()<0){
        JOptionPane.showMessageDialog(null, "Error: La calificación no puede ser menor de 0.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
        }
        
        try (Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Ciberseguridad (matricula, nombre, calif1) VALUES (?, ?, ?)")) {
            ps.setInt(1, estudiante.getMatricula());
            ps.setString(2, estudiante.getNombre());
            ps.setInt(3, estudiante.getCalif1());
          
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean modificar(Estudiante estudiante) {
      
        
        if (estudiante.getCalif1() > 100 || estudiante.getCalif2() > 100 || estudiante.getCalif3() > 100 || estudiante.getCalif4() > 100) {
        JOptionPane.showMessageDialog(null, "Error: Calificacion mayor a 100");
        return false;
        }else if(estudiante.getCalif1() < 0 || estudiante.getCalif2() < 0 || estudiante.getCalif3() < 0 || estudiante.getCalif4() <  0){
        JOptionPane.showMessageDialog(null, "Error: Calificación menor a 0");
        return false;
        }
        
        
         try (Connection con = conexion.getConexion();
           PreparedStatement ps = con.prepareStatement("UPDATE Ciberseguridad SET calif1=?, calif2=?, calif3=?, calif4=?, final=? WHERE matricula=?")){
            ps.setInt(1, estudiante.getCalif1());
            ps.setInt(2, estudiante.getCalif2());
            ps.setInt(3, estudiante.getCalif3());
            ps.setInt(4, estudiante.getCalif4());
            ps.setInt(5, estudiante.getCalif());
            ps.setInt(6, estudiante.getMatricula());
             return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        

        /*
        if (estudiante.getCalif1() > 100) {
         JOptionPane.showMessageDialog(null, "Error: La calificación no puede ser mayor de 100.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
        }else if(estudiante.getCalif1()<0){
        JOptionPane.showMessageDialog(null, "Error: La calificación no puede ser menor de 0.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
        }
        
        try (Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Ciberseguridad SET calif1=? WHERE matricula=?")) {
            ps.setInt(1, estudiante.getCalif1());
            ps.setInt(2, estudiante.getMatricula());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        */
    }
    
    
    public boolean buscar(Estudiante estudiante) {
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Ciberseguridad WHERE matricula=?")) {
            ps.setInt(1, estudiante.getMatricula());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    estudiante.setId(rs.getInt("id"));
                    estudiante.setMatricula(rs.getInt("matricula"));
                    estudiante.setNombre(rs.getString("nombre"));
                    estudiante.setCalif1(rs.getInt("calif1"));
                    estudiante.setCalif2(rs.getInt("calif2"));
                    estudiante.setCalif3(rs.getInt("calif3"));
                    estudiante.setCalif4(rs.getInt("calif4"));
                    estudiante.setCalif(rs.getInt("final"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean buscarUsuario(Usuario usuario) {
        try (Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuarios WHERE usuario = ? AND contrasenia = ?")) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContrasenia());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                   usuario.setTipo(rs.getInt("permiso"));
                    return true;
                }
            }
             return false;
        } catch (SQLException e) {
            e.printStackTrace();
             return false;
        }
    }
    
    /*
    public boolean GenerarPdf(Estudiante estudiante){
    
        Document documento = new Document();
       
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Alumnos.pdf"));
            documento.open();
            
            PdfPTable tabla = new PdfPTable(8);
            tabla.addCell("Id");
            tabla.addCell("Nombre");
            tabla.addCell("Diplomado");
            tabla.addCell("Modulo 1");
            tabla.addCell("Modulo 2");
            tabla.addCell("Modulo 3");
            tabla.addCell("Modulo 4");
            tabla.addCell("Final");
            
            try(Connection c = conexion.getConexion();
              PreparedStatement pst = c.prepareStatement("SELECT * FROM Ciberseguridad")) {
                
                
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                                       
                    do {                        
                         tabla.addCell(rs.getString(1));
                    tabla.addCell(rs.getString(2));
                    tabla.addCell(rs.getString(3));
                    tabla.addCell(rs.getString(4));
                    tabla.addCell(rs.getString(5));
                    tabla.addCell(rs.getString(6));
                    tabla.addCell(rs.getString(7));
                    tabla.addCell(rs.getString(8));
                    } while (rs.next());
                    documento.add(tabla);                    
                }
                
            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            return false;
        }
    
        return false;
    }
   
    
    public boolean GenerarPdf(Estudiante estudiante){
    
        Document documento = new Document();
        String query = "SELECT * FROM Ciberseguridad";
        
         try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Alumnos.pdf"));
            documento.open();
            
            PdfPTable tabla = new PdfPTable(8);
            tabla.addCell("Id");
            tabla.addCell("Nombre");
            tabla.addCell("Diplomado");
            tabla.addCell("Modulo 1");
            tabla.addCell("Modulo 2");
            tabla.addCell("Modulo 3");
            tabla.addCell("Modulo 4");
            tabla.addCell("Final");
            
            
            try (Connection c = conexion.getConexion();
              PreparedStatement ps = c.prepareStatement(query)){
                  
                
                ResultSet rs = ps.executeQuery();
                
                
                if (rs.next()) {
                    do{
                    tabla.addCell(rs.getString(1));
                    tabla.addCell(rs.getString(2));
                    tabla.addCell(rs.getString(3));
                    tabla.addCell(rs.getString(4));
                    tabla.addCell(rs.getString(5));
                    tabla.addCell(rs.getString(6));
                    tabla.addCell(rs.getString(7));
                    tabla.addCell(rs.getString(8));
                    }  while (rs.next());
                    
                    
                    documento.add(tabla);

                     JOptionPane.showMessageDialog(null, "Conexi+on exitosa.");
                }
                
            }catch (DocumentException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Fallo conexión.");
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
            return false;
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            
            JOptionPane.showMessageDialog(null, "Fallo al crear.");
        }
    
    
         return false;
    }
   */
}
