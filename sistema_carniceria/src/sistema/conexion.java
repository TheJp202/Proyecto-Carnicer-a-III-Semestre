
package sistema;
import java.sql.*;
import javax.swing.JOptionPane;
public class conexion{
    static login v1 = new login();
    static menu v2 = new menu();
    static cuenta v3 = new cuenta();
    static venta v4 = new venta();
    static ubicacion v5 = new ubicacion();
    static delivery v6 = new delivery();
    static compra v7 = new compra();
    static almacen v8 = new almacen();
    static empleados v9 = new empleados();
    static Inventario v10 = new Inventario();

        public static Connection conexion(){
            Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectocarniceria","root","");
                System.out.println("Inicio exitoso");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error al iniciar la bd"+e);
            }
             return con;
        }    
            public static void main(String[] args){
            conexion.v1.setVisible(true);
            }
}
