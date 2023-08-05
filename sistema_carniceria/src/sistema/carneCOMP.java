
package sistema;
import java.sql.*;
import java.util.*;

public class carneCOMP {
    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Ccarne carne = new Ccarne();
    
    public Ccarne ListarID(int id){
        Ccarne carne = new Ccarne();
    String sql = "SELECT * FROM carne WHERE ID_CAR=?";
        try {
            con = conexion.conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                carne.setIdcarne(rs.getInt(1));
                carne.setCodanimal(rs.getInt(2));
                carne.setCodcategoria(rs.getInt(3));
                carne.setCodMarca(rs.getInt(4));
                carne.setPrecioUnidad(rs.getFloat(5));
                carne.setCantidad(rs.getInt(6));
                carne.setPeso(rs.getFloat(7));
                carne.setPrecioTotal(rs.getFloat(8));
                carne.setFechVenc(rs.getString(9));
                carne.setDescrip(rs.getString(10));
                carne.setIdpro(rs.getInt(11));
                
                
            }
        } catch (SQLException e) {
        }
        return carne;
    }
    
}
