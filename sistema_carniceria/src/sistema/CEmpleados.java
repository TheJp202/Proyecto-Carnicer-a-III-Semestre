
package sistema;

import java.awt.HeadlessException;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.*;


public class CEmpleados {
   int codigoEmpleado;
   String nombreEmpleado;
   String apellidoEmpleado;
   String dniEmpleado;
   int cargoEmpleado;
   String fechaContratEmpleado;
   int distritoEmpleado;
   int tiendaEmpleado;
   String direccionEmpleado;
   String contraseñaEmpleado;

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public int getCargoEmpleado() {
        return cargoEmpleado;
    }

    public void setCargoEmpleado(int cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }

    public String getFechaContratEmpleado() {
        return fechaContratEmpleado;
    }

    public void setFechaContratEmpleado(String fechaContratEmpleado) {
        this.fechaContratEmpleado = fechaContratEmpleado;
    }

    public int getDistritoEmpleado() {
        return distritoEmpleado;
    }

    public void setDistritoEmpleado(int distritoEmpleado) {
        this.distritoEmpleado = distritoEmpleado;
    }

    public int getTiendaEmpleado() {
        return tiendaEmpleado;
    }

    public void setTiendaEmpleado(int tiendaEmpleado) {
        this.tiendaEmpleado = tiendaEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public String getContraseñaEmpleado() {
        return contraseñaEmpleado;
    }

    public void setContraseñaEmpleado(String contraseñaEmpleado) {
        this.contraseñaEmpleado = contraseñaEmpleado;
    }
    
   public void InsertarEmpleado(JTextField paramCodigo,JTextField paramNombre,JTextField paramApellido, JTextField paramDNI,
           JTextField paramCargo,JTextField paramcontratacion, JTextField paramdistrito,JTextField paramtienda,
           JTextField paramdireccion,JTextField paramcontraseña){
   
       setCodigoEmpleado(Integer.parseInt(paramCodigo.getText()));
       setNombreEmpleado(paramNombre.getText());
       setApellidoEmpleado(paramApellido.getText());
       setDniEmpleado(paramDNI.getText());
       setCargoEmpleado(Integer.parseInt(paramCargo.getText()));
       setFechaContratEmpleado(paramcontratacion.getText());
       setDistritoEmpleado(Integer.parseInt(paramdistrito.getText()));
       setTiendaEmpleado(Integer.parseInt(paramtienda.getText()));
       setDireccionEmpleado(paramdireccion.getText());
       setContraseñaEmpleado(paramcontraseña.getText());
       
      
       
       String consulta = "INSERT INTO EMPLEADO(COD_EMP,NOM_EMP,APE_EMP,DNI_EMP,COD_CARGO,FECH_CONTR,COD_DIS,COD_TIE,DIR_EMP,CONT_EMP) VALUES (?,?,?,?,?,?,?,?,?,?);";
       
       try {
           CallableStatement cs = conexion.conexion().prepareCall(consulta);
           
           cs.setInt(1, getCodigoEmpleado());
           cs.setString(2, getNombreEmpleado());
           cs.setString(3, getApellidoEmpleado());
           cs.setString(4, getDniEmpleado());
           cs.setInt(5, getCargoEmpleado());
           cs.setString(6,getFechaContratEmpleado());
           cs.setInt(7, getDistritoEmpleado());
           cs.setInt(8, getTiendaEmpleado());
           cs.setString(9,getDireccionEmpleado());
           cs.setString(10,getContraseñaEmpleado());
           
           cs.execute();
           JOptionPane.showMessageDialog(null, "Se insertó un nuevo registro");
           
           
       } catch (HeadlessException | SQLException e) {
           JOptionPane.showMessageDialog(null, "No se logró insertar un nuevo registro"+e);
       }
       
       
   }
   public void MostrarEmpleados(JTable paramTotalEmpleados){
       
       DefaultTableModel modelo = new DefaultTableModel();
       
       TableRowSorter <TableModel> OrdenTabla = new TableRowSorter<TableModel>(modelo);
       paramTotalEmpleados.setRowSorter(OrdenTabla);
       
       String sql = "";
       
       modelo.addColumn("Codigo");
       modelo.addColumn("Nombre");
       modelo.addColumn("Apellido");
       modelo.addColumn("DNI");
       modelo.addColumn("Codigo de Cargo");
       modelo.addColumn("Fecha de Contratacion");
       modelo.addColumn("Distrito");
       modelo.addColumn("Codigo de Tienda");
       modelo.addColumn("Direccion");
       modelo.addColumn("Contraseña");
       
       paramTotalEmpleados.setModel(modelo);
       
       sql = "SELECT * FROM empleado";
       
       String[] datos = new String [10];
       Statement st;
       
       try {
           st = conexion.conexion().createStatement();
           ResultSet rs = st.executeQuery(sql);
           
           while (rs.next()) {
               datos[0] = rs.getString(1);
               datos[1] = rs.getString(2);
               datos[2] = rs.getString(3);
               datos[3] = rs.getString(4);
               datos[4] = rs.getString(5);
               datos[5] = rs.getString(6);
               datos[6] = rs.getString(7);
               datos[7] = rs.getString(8);
               datos[8] = rs.getString(9);
               datos[9] = rs.getString(10);
               modelo.addRow(datos);
               
               
           }
           paramTotalEmpleados.setModel(modelo);
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "No se pudo mostrar empleados"+e);
       }
   
   }
   public void SeleccionarEmpleados(JTable paramTablaEmpleados,JTextField paramCodigo,JTextField paramNombre,JTextField paramApellido, JTextField paramDNI,
           JTextField paramCargo,JTextField paramcontratacion, JTextField paramdistrito,JTextField paramtienda,
           JTextField paramdireccion,JTextField paramcontraseña){
       try {
           int fila = paramTablaEmpleados.getSelectedRow();
           if (fila >= 0) {
               paramCodigo.setText(paramTablaEmpleados.getValueAt(fila, 0).toString());
               paramNombre.setText(paramTablaEmpleados.getValueAt(fila, 1).toString());
               paramApellido.setText(paramTablaEmpleados.getValueAt(fila, 2).toString());
               paramDNI.setText(paramTablaEmpleados.getValueAt(fila, 3).toString());
               paramCargo.setText(paramTablaEmpleados.getValueAt(fila, 4).toString());
               paramcontratacion.setText(paramTablaEmpleados.getValueAt(fila, 5).toString());
               paramdistrito.setText(paramTablaEmpleados.getValueAt(fila, 6).toString());
               paramtienda.setText(paramTablaEmpleados.getValueAt(fila, 7).toString());
               paramdireccion.setText(paramTablaEmpleados.getValueAt(fila, 8).toString());
               paramcontraseña.setText(paramTablaEmpleados.getValueAt(fila, 9).toString());
           }else{
           JOptionPane.showMessageDialog(null, "La fila no puedo ser seleccionada");
           }
                   
       } catch (HeadlessException e) {
           JOptionPane.showMessageDialog(null, "Error de seleccion : "+e);
       }
       
   }
   public void ModificarEmpleado(JTextField paramCodigo,JTextField paramNombre,JTextField paramApellido, JTextField paramDNI,
           JTextField paramCargo,JTextField paramcontratacion, JTextField paramdistrito,JTextField paramtienda,
           JTextField paramdireccion,JTextField paramcontraseña){
       
       
     
      
       setCodigoEmpleado(Integer.parseInt(paramCodigo.getText()));
       setNombreEmpleado(paramNombre.getText());
       setApellidoEmpleado(paramApellido.getText());
       setDniEmpleado(paramDNI.getText());
       setCargoEmpleado(Integer.parseInt(paramCargo.getText()));
       setFechaContratEmpleado(paramcontratacion.getText());
       setDistritoEmpleado(Integer.parseInt(paramdistrito.getText()));
       setTiendaEmpleado(Integer.parseInt(paramtienda.getText()));
       setDireccionEmpleado(paramdireccion.getText());
       setContraseñaEmpleado(paramcontraseña.getText());
       
       
       
       conexion objetoConexion = new conexion();
       String consulta = "UPDATE empleado SET NOM_EMP = ?, APE_EMP = ?, DNI_EMP = ?, COD_CARGO = ?,FECH_CONTR = ?,COD_DIS = ?,COD_TIE = ? ,DIR_EMP = ?, CONT_EMP = ? WHERE COD_EMP = ?";
       
       try {
           CallableStatement cs = objetoConexion.conexion().prepareCall(consulta);
           
           
           cs.setString(1, getNombreEmpleado());
           cs.setString(2, getApellidoEmpleado());
           cs.setString(3, getDniEmpleado());
           cs.setInt(4,getCargoEmpleado());
           cs.setString(5, getFechaContratEmpleado());
           cs.setInt(6,getDistritoEmpleado());
           cs.setInt(7,getTiendaEmpleado());
           cs.setString(8, getDireccionEmpleado());
           cs.setString(9, getContraseñaEmpleado());
           cs.setInt(10,getCodigoEmpleado());
           
           cs.execute();
           
           JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "No se puedo hacer la modificacion "+ e);
       }
 
   }
   public void ElimiarEmpleado(JTextField paramCodigoEmpleado){
       setCodigoEmpleado(Integer.parseInt(paramCodigoEmpleado.getText()));
       conexion objetoConexion = new conexion();
       String consulta="DELETE FROM empleado WHERE COD_EMP = ?;";
       try {
           CallableStatement cs = objetoConexion.conexion().prepareCall(consulta);
           cs.setInt (1,getCodigoEmpleado());
           cs.execute();
           
           JOptionPane.showMessageDialog(null, "Se elimino Correctamente el alumno");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro "+e);
       }
   }
   
   
          
}
