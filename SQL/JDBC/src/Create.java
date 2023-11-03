import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Create {

    static final String DB_URL= "jdbc:mysql://localhost:3306/";
    static final String USER= "root";
    static final String PASS= "Eduardo-36";
    public static void main(String[] args) 
    {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();)
        {
                String sql = "CREATE TABLE ada2.alumnos (\r\n" + //
                        "    id INT AUTO_INCREMENT PRIMARY KEY,\r\n" + //
                        "    nombre VARCHAR(255) NOT NULL,\r\n" + //
                        "    apellido VARCHAR(255) NOT NULL,\r\n" + //
                        "    edad INT,\r\n" + //
                        "    fecha_nacimiento DATE,\r\n" + //
                        "    direccion VARCHAR(255),\r\n" + //
                        "    telefono VARCHAR(15)\r\n" + //
                        ");\r\n" + //
                        "";
                stmt.executeUpdate(sql);
                System.out.println("Base de datos creada correctamente...");
        }catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}