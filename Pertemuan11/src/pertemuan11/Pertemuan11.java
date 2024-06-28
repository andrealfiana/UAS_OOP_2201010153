package pertemuan11;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author IKadekAndreAlfiana_2201010153
 * TGL: 2024-06-27
 * 
 */
public class Pertemuan11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {        
       //list_all();
       
       //loadformteman
        frmdataonepiece FPiece = new frmdataonepiece();
        FPiece.setResizable(false);
        FPiece.setVisible(true);
    }
    
    public static void list_all() throws SQLException{
        Connection cnn = koneksi.getConnection();
        if(cnn.isClosed()){
            System.out.println("Koneksi gagal");
        }else{
            String sqlvd = "SELECT nama, alamat, telp FROM datateman;";
            PreparedStatement PS=cnn.prepareStatement(sqlvd);
            ResultSet rs= PS.executeQuery();
            while(rs.next()){
                System.out.println("Nama   : "+rs.getString("nama"));
                System.out.println("Alamat : "+rs.getString("alamat"));
                System.out.println("Telp   : "+rs.getString("telp"));
            }
            cnn.close();
        }
    }
    
}
