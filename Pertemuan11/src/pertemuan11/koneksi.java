package pertemuan11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author IKadekAndreAlfiana_2201010153
 * TGL: 2024-06-27
 */
public class koneksi {
    public static Connection getConnection() throws SQLException{
       Connection cnn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dataonepiece","root","");
        } catch (ClassNotFoundException ex) {
            System.out.println("Koneksi ke database gagal");
        }
       
       return cnn;
    }
}
