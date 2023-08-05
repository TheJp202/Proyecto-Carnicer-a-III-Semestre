
package sistema;

import java.awt.HeadlessException;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.*;
public class CAlmacen {
    int codAlmacen;
    String tipoAlmacen;
    int codStock;
    int tamañoCantidad;
    String descripcion;
    
    public int getCodAlmacen() {
        return codAlmacen;
    }

    public void setCodAlmacen(int codAlmacen) {
        this.codAlmacen = codAlmacen;
    }

    public String getTipoAlmacen() {
        return tipoAlmacen;
    }

    public void setTipoAlmacen(String tipoAlmacen) {
        this.tipoAlmacen = tipoAlmacen;
    }

    public int getCodStock() {
        return codStock;
    }

    public void setCodStock(int codStock) {
        this.codStock = codStock;
    }

    public int getTamañoCantidad() {
        return tamañoCantidad;
    }

    public void setTamañoCantidad(int tamañoCantidad) {
        this.tamañoCantidad = tamañoCantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   public void MostrarAlmacen(JTable paramTotalAlmacen){
       
       DefaultTableModel modelo = new DefaultTableModel();
       
       TableRowSorter <TableModel> OrdenTabla = new TableRowSorter<TableModel>(modelo);
       paramTotalAlmacen.setRowSorter(OrdenTabla);
       String sql = "";
       modelo.addColumn("COD_ALMA");
       modelo.addColumn("TIPO_ALMA");
       modelo.addColumn("COD_STOCK");
       modelo.addColumn("TAM_CUA_ALMA");
       modelo.addColumn("DECS_ALMA");

       paramTotalAlmacen.setModel(modelo);
       sql = "SELECT * FROM almacen";
       
       String[] datos = new String [5];
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
              
               modelo.addRow(datos);
               
               
           }
           paramTotalAlmacen.setModel(modelo);
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "No se pudo mostrar almacen"+e);
       }
   }
}
