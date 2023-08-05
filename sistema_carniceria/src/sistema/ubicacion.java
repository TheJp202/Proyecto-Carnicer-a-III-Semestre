/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author JP
 */
public class ubicacion extends javax.swing.JFrame {
    
    
    
    void MostrarClientes() throws SQLException{
        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("ID");
        modelo1.addColumn("Nombres");
        modelo1.addColumn("Apellidos");
        modelo1.addColumn("DNI");
        modelo1.addColumn("RUC");
        modelo1.addColumn("Direccion");
        jTable1.setModel(modelo1);
        String distrito = jTextField4.getText();
                
        String queryCliente1 = "SELECT ID_CLI AS ID_C,NOM_CLI,APE_CLI,DNI_CLI,RUC_CLI,DIR_CLI FROM CLIENTE WHERE COD_DIS=(SELECT COD_DIS FROM DISTRITO WHERE NOM_DIS = '"+distrito+"')";
        String data1[] =  new String[6];
        Statement st = conexion.conexion().createStatement();
        ResultSet rs = st.executeQuery(queryCliente1);
        
        while(rs.next()){
            data1[0] = rs.getString(1);
            data1[1] = rs.getString(2);
            data1[2] = rs.getString(3);
            data1[3] = rs.getString(4);
            data1[4] = rs.getString(5);
            data1[5] = rs.getString(6);
            modelo1.addRow(data1);
        }
    }
    
    void MostrarProveedores() throws SQLException{
         DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("ID");
        modelo2.addColumn("Nombres");
        modelo2.addColumn("Apellidos");
        modelo2.addColumn("Telefono");
        modelo2.addColumn("RUC");
        modelo2.addColumn("Direccion");
        jTable3.setModel(modelo2);
        String distrito = jTextField4.getText();
                
        String queryPro = "SELECT ID_PRO,NOM_PRO,APE_PRO,TEL_PRO,RUC_PRO,DIR_PRO FROM PROVEEDOR WHERE COD_DIS=(SELECT COD_DIS FROM DISTRITO WHERE NOM_DIS = '"+distrito+"')";
        String data2[] =  new String[6];
        
        Statement st = conexion.conexion().createStatement();
        ResultSet rs = st.executeQuery(queryPro);
        while(rs.next()){
            data2[0] = rs.getString(1);
            data2[1] = rs.getString(2);
            data2[2] = rs.getString(3);
            data2[3] = rs.getString(4);
            data2[4] = rs.getString(5);
            data2[5] = rs.getString(6);
            modelo2.addRow(data2);
        }
    }
    
    /**
     * Creates new form ubicacion
     */
    public ubicacion() {
        
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Anterior");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Sistema de Ubicación");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre del Distrito:");

        jLabel3.setText("Departamento: ");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Pais:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jButton2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 314, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jTextField3))
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(89, 89, 89)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(51, 51, 51))
        );

        jTabbedPane1.addTab("Principal", jPanel1);

        jLabel5.setText("Nombre del Distrito:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Clientes:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Proveedores:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(472, 472, 472)
                        .addComponent(jButton3)
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(57, 57, 57)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(38, 38, 38))
        );

        jTabbedPane1.addTab("Consultar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(223, 223, 223))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        hide();
        conexion.v2.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
                   /*foesoeosjfos*/

        
        
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Statement cn = conexion.conexion().createStatement();
            String pais = jTextField3.getText();  
            String depa = jTextField2.getText();
            String dist = jTextField1.getText();
            String set1 = "SET @next_cod1 := (SELECT MAX(COD_PAIS) + 1 FROM PAIS);";
            cn.executeUpdate(set1);
            String set2 = "SET @next_cod2 := (SELECT MAX(COD_DEP) + 1 FROM DEPARTAMENTO);";
            cn.executeUpdate(set2);
            String set3 = "SET @next_cod3 := (SELECT MAX(COD_DIS) + 1 FROM DISTRITO);";
            cn.executeUpdate(set3);
            String insert1 = "INSERT INTO PAIS(COD_PAIS,NOM_PAIS) VALUES (@next_cod1,'"+pais+"');";
            String insert2 = "INSERT INTO DEPARTAMENTO(COD_DEP,NOM_DEP,COD_PAIS) VALUES (@next_cod2,'"+depa+"',(SELECT COD_PAIS FROM PAIS WHERE NOM_PAIS='"+pais+"'));";
            String insert3 = "INSERT INTO DISTRITO(COD_DIS,NOM_DIS,COD_DEP) VALUES (@next_cod3,'"+dist+"',(SELECT COD_DEP FROM DEPARTAMENTO WHERE NOM_DEP = '"+depa+"'));";
            String query1 = "SELECT COUNT(*) AS P FROM PAIS WHERE NOM_PAIS = '"+pais+"'";
            String query2 = "SELECT COUNT(*) AS DE FROM DEPARTAMENTO WHERE NOM_DEP = '"+depa+"'";
            String query3 = "SELECT COUNT(*) AS DI FROM DISTRITO WHERE NOM_DIS = '"+dist+"'";
            ResultSet q1 = cn.executeQuery(query1);
            int c1 = -1;
            int c2 = -1;
            int c3 = -1;
            if(q1.next()){
                c1 = q1.getInt("P");  
            }
            ResultSet q2 = cn.executeQuery(query2);
            if(q2.next()){
                c2 = q2.getInt("DE");
            }
            ResultSet q3 = cn.executeQuery(query3);
            if(q3.next()){
                c3 = q3.getInt("DI");
            }
            if((!pais.isEmpty()) && (depa.isEmpty()) && (dist.isEmpty())){
                if(c1 > 0){
                    JOptionPane.showMessageDialog(null,"Ya existe un pais llamado así..");
                }
                else{
                    cn.executeUpdate(insert1);
                    JOptionPane.showMessageDialog(null,"Pais registrado correctamente!");
                }
            }else if((!pais.isEmpty())&&(!depa.isEmpty())&&(dist.isEmpty())){
                if(c1 > 0){
                    if(c2 > 0){
                        JOptionPane.showMessageDialog(null,"Ya existe ese departamento...");
                    }else{
                        cn.executeUpdate(insert2);
                        JOptionPane.showMessageDialog(null,"Departamento registrado correctamente!");

                    }
                }else{
                
                    JOptionPane.showMessageDialog(null,"Pais no encontrado...");
                }
            }else if((pais.isEmpty())&&(!depa.isEmpty())&&(!dist.isEmpty())){
          
                    if(c2 > 0){
                        if(c3 > 0){
                         JOptionPane.showMessageDialog(null,"Ya existe ese distrito");   
                        }else{
                            cn.executeUpdate(insert3);
                            JOptionPane.showMessageDialog(null,"Distrito registrado correctamente!");
                        }
                    }else{
                        
                        JOptionPane.showMessageDialog(null,"Departamento no encontrado...");
                    }
        
            }else{
                JOptionPane.showMessageDialog(null,"No se deben rellenar todos campos o no rellenaste ninguno...");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }      
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
try {
            Statement cn = conexion.conexion().createStatement();
            String pais = jTextField3.getText();  
            String depa = jTextField2.getText();
            String dist = jTextField1.getText();
            String delete1 = "DELETE FROM PAIS WHERE NOM_PAIS = '"+pais+"';";
            String delete2 = "DELETE FROM DEPARTAMENTO WHERE NOM_DEP = '"+depa+"' ;";
            String delete3 = "DELETE FROM DISTRITO WHERE NOM_DIS = '"+dist+"';";
            String query1 = "SELECT COUNT(*) AS P FROM PAIS WHERE NOM_PAIS = '"+pais+"'";
            String query2 = "SELECT COUNT(*) AS DE FROM DEPARTAMENTO WHERE NOM_DEP = '"+depa+"'";
            String query3 = "SELECT COUNT(*) AS DI FROM DISTRITO WHERE NOM_DIS = '"+dist+"'";
            ResultSet q1 = cn.executeQuery(query1);
            int c1 = -1;
            int c2 = -1;
            int c3 = -1;
            if(q1.next()){
                c1 = q1.getInt("P");  
            }
            ResultSet q2 = cn.executeQuery(query2);
            if(q2.next()){
                c2 = q2.getInt("DE");
            }
            ResultSet q3 = cn.executeQuery(query3);
            if(q3.next()){
                c3 = q3.getInt("DI");
            }
            if((!pais.isEmpty()) && (depa.isEmpty()) && (dist.isEmpty())){
                if(c1 > 0){
                    cn.executeUpdate(delete1);
                    JOptionPane.showMessageDialog(null,"Eliminado correctamente!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"No se encontró ningún pais...");
                }
            }else if((pais.isEmpty())&&(!depa.isEmpty())&&(dist.isEmpty())){
            
                    if(c2 > 0){
                        cn.executeUpdate(delete2);
                        JOptionPane.showMessageDialog(null,"Eliminado correctamente!");
                    }else{
                        JOptionPane.showMessageDialog(null,"No se encontró ningún departamento...");
                    }
            }else if((pais.isEmpty())&&(depa.isEmpty())&&(!dist.isEmpty())){
                    if(c3 > 0){
                         cn.executeUpdate(delete3);      
                         JOptionPane.showMessageDialog(null,"Eliminado correctamente!");   
                        }else{
                            JOptionPane.showMessageDialog(null,"No se encontró ningún distrito...");
                    }
            }else{
                JOptionPane.showMessageDialog(null,"Solo se debe rellenar un campo a eliminar o no rellenaste ninguno...");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Primero debes eliminar/modificar las relaciones del pais/departamento/distrito a eliminar...");
            Logger.getLogger(ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }              
    // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            MostrarClientes();
            MostrarProveedores();
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ubicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ubicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ubicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ubicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ubicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}