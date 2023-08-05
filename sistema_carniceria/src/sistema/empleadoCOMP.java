/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.sql.*;
import java.util.*;
public class empleadoCOMP {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    CEmpleados e = new CEmpleados();
    
   public CEmpleados ListarID(String dni){
   CEmpleados e = new CEmpleados();    
   String sql = "SELECT * FROM empleado WHERE DNI_EMP=?";
       try {
           con = conexion.conexion();
           ps = con.prepareStatement(sql);
           ps.setString(1, dni);
           rs = ps.executeQuery();
           while (rs.next()) {
               e.setCodigoEmpleado(rs.getInt(1));
               e.setNombreEmpleado(rs.getString(2));
               e.setApellidoEmpleado(rs.getString(3));
               e.setDniEmpleado(rs.getString(4));
               e.setCargoEmpleado(rs.getInt(5));
               e.setFechaContratEmpleado(rs.getString(6));
               e.setDistritoEmpleado(rs.getInt(7));
               e.setTiendaEmpleado(rs.getInt(8));
               e.setDireccionEmpleado(rs.getString(9));
               e.setContraseñaEmpleado(rs.getString(10));
               
               
           }
           
       } catch (Exception a) {
           
          
       }
       return e;
   
   } 
}
