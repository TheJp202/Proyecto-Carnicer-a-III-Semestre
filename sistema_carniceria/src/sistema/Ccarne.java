
package sistema;
import java.awt.HeadlessException;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.*;

public class Ccarne {
int idcarne;
int codanimal;
int codcategoria;
int codMarca;
float precioUnidad;
int cantidad;
float peso;
float precioTotal;
String fechVenc;
String descrip;
int idpro;
int codInve;

    public int getCodInve() {
        return codInve;
    }

    public void setCodInve(int codInve) {
        this.codInve = codInve;
    }


    public int getIdcarne() {
        return idcarne;
    }

    public void setIdcarne(int idcarne) {
        this.idcarne = idcarne;
    }

    public int getCodanimal() {
        return codanimal;
    }

    public void setCodanimal(int codanimal) {
        this.codanimal = codanimal;
    }

    public int getCodcategoria() {
        return codcategoria;
    }

    public void setCodcategoria(int codcategoria) {
        this.codcategoria = codcategoria;
    }

    public int getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(int codMarca) {
        this.codMarca = codMarca;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getFechVenc() {
        return fechVenc;
    }

    public void setFechVenc(String fechVenc) {
        this.fechVenc = fechVenc;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }
    
    public void InsertarCarne(JTextField codCarne, JTextField codAnimal,JTextField codCate,JTextField codMar,JTextField precioUni, 
            JTextField canti,JTextField pesoCar , JTextField precioTo,JTextField fecha_venc,JTextField descripcion,JTextField idProveedor){
        setIdcarne(Integer.parseInt(codCarne.getText()));
        setCodanimal(Integer.parseInt(codAnimal.getText()));
        setCodcategoria(Integer.parseInt(codCate.getText()));
        setCodMarca(Integer.parseInt(codMar.getText()));
        setPrecioUnidad(Float.parseFloat(precioUni.getText()));
        setCantidad(Integer.parseInt(canti.getText()));
        setPeso(Float.parseFloat(pesoCar.getText()));
        setPrecioTotal(Float.parseFloat(precioTo.getText()));
        setFechVenc(fecha_venc.getText());
        setDescrip(descripcion.getText());
        setIdpro(Integer.parseInt(idProveedor.getText()));
        
        conexion objetoConexion = new conexion();
        
        String consulta = "INSERT INTO carne(ID_CAR, COD_ANI, COD_CAT, COD_MAR, PRE_UNI_CAR, CAN_CAR, PESO_CAR, FECH_VENC_CAR, DESC_CAR, ID_PRO) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        System.out.println(consulta);
        System.out.println(getPrecioTotal());
        try {
            CallableStatement cs = objetoConexion.conexion().prepareCall(consulta);
            cs.setInt(1, getIdcarne());
            cs.setInt(2, getCodanimal());
            cs.setInt(3, getCodcategoria());
            cs.setInt(4, getCodMarca());
            cs.setFloat(5, getPrecioUnidad());
            cs.setInt(6, getCantidad());
            cs.setFloat(7,getPeso());
            
            cs.setString(8,getFechVenc());
            cs.setString(9,getDescrip());
            cs.setInt(10,getIdpro());
            
            cs.execute();
           JOptionPane.showMessageDialog(null, "Se insertó un nuevo registro");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se logró insertar un nuevo registro"+e);
        }
    }

    public void ActualizarInventario(JTextField codInvent, JTextField cantInvent, JTextField pesoInvent, JTextField precioInvent){
        setCodInve(Integer.parseInt(codInvent.getText()));
        setCantidad(Integer.parseInt(cantInvent.getText()));
        setPeso(Float.parseFloat(pesoInvent.getText()));
        setPrecioUnidad(Float.parseFloat(precioInvent.getText()));
        
        Connection ObjetoConexion = conexion.conexion();
        
        String consulta = "UPDATE inventario SET CANT_INVE = ?, PESO_INVE = ?, PRECIO_INVE = ? WHERE COD_INVE = ?";
        try {
            CallableStatement cs = ObjetoConexion.prepareCall(consulta);
            cs.setInt(1, getCantidad());
            cs.setFloat(2, getPeso());
            cs.setFloat(3, getPrecioTotal());
            cs.setInt(4, getCodInve());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se actualizo el inventario");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El inventario no se pudo actualizar"+e);
        }
    }
       public void MostrarCarne(JTable paramTotalCarne){
       
       DefaultTableModel modelo = new DefaultTableModel();
       
       TableRowSorter <TableModel> OrdenTabla = new TableRowSorter<TableModel>(modelo);
       paramTotalCarne.setRowSorter(OrdenTabla);
       
       String sql = "";
       
       modelo.addColumn("ID_CAR");
       modelo.addColumn("COD_ANI");
       modelo.addColumn("COD_CAT");
       modelo.addColumn("COD_MAR");
       modelo.addColumn("PRE_UNI_CAR");
       modelo.addColumn("CAN_CAR");
       modelo.addColumn("PESO_CAR");
       modelo.addColumn("PRE_TOT_CAR");
       modelo.addColumn("FECH_VENC_CAR");
       modelo.addColumn("DESC_CAR");
       modelo.addColumn("ID_PRO");
       
       paramTotalCarne.setModel(modelo);
       
       sql = "SELECT * FROM carne";
       
       String[] datos = new String [11];
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
               datos[10] = rs.getString(11);
               modelo.addRow(datos);
               
               
           }
           paramTotalCarne.setModel(modelo);
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "No se pudo mostrar carne"+e);
       }
   
   }
   public void MostrarInventario(JTable paramTotalinventario){
       
       DefaultTableModel modelo = new DefaultTableModel();
       
       TableRowSorter <TableModel> OrdenTabla = new TableRowSorter<TableModel>(modelo);
       paramTotalinventario.setRowSorter(OrdenTabla);
       
       String sql = "";
       
       modelo.addColumn("COD_INVE");
       modelo.addColumn("NOM_INVE");
       modelo.addColumn("CANT_INVE");
       modelo.addColumn("PESO_INVE");
       modelo.addColumn("PRECIO_INVE");
       modelo.addColumn("COD_EMP");
       modelo.addColumn("COD_ALMA");

       
       paramTotalinventario.setModel(modelo);
       
       sql = "SELECT * FROM inventario";
       
       String[] datos = new String [7];
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
               

               modelo.addRow(datos);
               
               
           }
           paramTotalinventario.setModel(modelo);
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "No se pudo mostrar inventario"+e);
       }
   
   } 
}
