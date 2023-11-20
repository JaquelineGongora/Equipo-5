package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Consultas {
    
    Conexion conexion;
    

    public Consultas(){
        conexion = new Conexion();
    }
    
    public List<Estudiante> CargarBase() {
        
        String query = "select * from tablaEstudiantes";
        
         try (Connection c = conexion.getConexion();
              PreparedStatement ps = c.prepareStatement(query)){
         
        
             ResultSet rs = ps.executeQuery();
             
             List<Estudiante> estudiante = new ArrayList<>();
         
             while(rs.next()){
                Estudiante p = new Estudiante();
                p.setId(rs.getInt(1));
                p.setMatricula(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setCalif(rs.getInt(4));
                p.setDiplomado(rs.getString(7));
                estudiante.add(p);
             }
             
             
             return estudiante;
              
             
         }catch(SQLException e){
           e.printStackTrace();
           throw new RuntimeException("Error", e);
             
         }
    }
    
    public boolean registrar(Estudiante estudiante) {
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("INSERT INTO tablaEstudiantes (matricula, nombre, diplomado, calificacion) VALUES (?, ?, ?, ?)")) {
            ps.setInt(1, estudiante.getMatricula());
            ps.setString(2, estudiante.getNombre());
            ps.setString(3, estudiante.getDiplomado());
            ps.setInt(4, estudiante.getCalif());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean modificar(Estudiante estudiante) {
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("UPDATE tablaEstudiantes SET calificacion=? WHERE id=?")) {
            
            ps.setInt(1, estudiante.getCalif());
            ps.setInt(2, estudiante.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminar(Estudiante estudiante) {
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("DELETE FROM tablaEstudiantes WHERE id=?")) {
            ps.setInt(1, estudiante.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean buscar(Estudiante estudiante) {
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM tablaEstudiantes WHERE id=?")) {
            ps.setInt(1, estudiante.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    estudiante.setId(rs.getInt("id"));
                    estudiante.setMatricula(rs.getInt("matricula"));
                    estudiante.setNombre(rs.getString("nombre"));
                    estudiante.setDiplomado(rs.getString("diplomado"));
                    estudiante.setCalif(rs.getInt("calificacion"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
