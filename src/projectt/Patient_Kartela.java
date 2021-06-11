/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectt;

import icons.FontAwesome;
import jiconfont.swing.IconFontSwing;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static projectt.Patient_Prescription.jTable1;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Χαρά
 */
public class Patient_Kartela extends javax.swing.JFrame {

    /**
     * Creates new form Patient_Kartela
     */
    public Patient_Kartela() {
        IconFontSwing.register(FontAwesome.getIconFont());  
        initComponents();
        getTestResults();
        getDiagnosis();
    }

    private static void getTestResults(){
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0); 
        try
        {
            LogIn_Patient login_patient = new LogIn_Patient();
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String patient_id = login_patient.patient_userId();
            String query1 = "SELECT test_id FROM test_results WHERE patient_id = '"+patient_id+"'";
            PreparedStatement pst = con.prepareStatement(query1);
            ResultSet rs = pst.executeQuery();
              
            
             
             while(rs.next())
                {
                   String test_id = Integer.toString(rs.getInt("test_id"));
                   String tbData[]={test_id};
                   DefaultTableModel tb1Model =(DefaultTableModel) jTable4.getModel();
                   
                   tb1Model.addRow(tbData);
                }
             con.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_Staff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            
        }
        
          
    }
    
    private static void getDiagnosis(){
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0); 
        try
        {
            LogIn_Patient login_patient = new LogIn_Patient();
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String patient_id = login_patient.patient_userId();
            String query2 = "SELECT diagnosis_id FROM diagnosis WHERE patient_id = '"+patient_id+"'";
            PreparedStatement pst2 = con.prepareStatement(query2);
            ResultSet rs2 = pst2.executeQuery();
              
            
             
             while(rs2.next())
                {
                   String diagnosis_id = Integer.toString(rs2.getInt("diagnosis_id"));
                   String tbData[]={diagnosis_id};
                   DefaultTableModel tb1Model =(DefaultTableModel) jTable3.getModel();
                   
                   tb1Model.addRow(tbData);
                }
             con.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_Staff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            
        } 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        back_Button1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(150, 235, 240));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/A4AD5659B5D44610AB530DF0BAB8279D.jpeg"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patient.jpg"))); // NOI18N

        back_Button1.setIcon(IconFontSwing.buildIcon(FontAwesome.ARROW_CIRCLE_LEFT, 50, Color.black));
        back_Button1.setBorderPainted(false);
        back_Button1.setContentAreaFilled(false);
        back_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_Button1ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(150, 235, 240));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField1.setText("Διαγνώσεις-Εξετάσεις Ασθενή");
        jTextField1.setBorder(null);
        jTextField1.setFocusable(false);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Τοπική αποθήκευση");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTabbedPane3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Εξέτασης"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jTabbedPane3.addTab("Εξετάσεις", jScrollPane4);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Διάγνωσης"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable3);

        jTabbedPane3.addTab("Διαγνώσεις", jScrollPane2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ασθενή", "Τίτλος Τεστ", "Ημερομηνία Τεστ"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane3.addTab("Λεπτομέρειες Εξέτασης", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Γιατρού", "ID Ασθενή", "Textbox", "Ημερομηνία Διάγνωσης"
            }
        ));
        jScrollPane6.setViewportView(jTable2);

        jTabbedPane3.addTab("Λεπτομέρειες Διάγνωσης", jScrollPane6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back_Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jButton3)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(back_Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1249, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_Button1ActionPerformed

        dispose();
        new Patient().setVisible(true);
    }//GEN-LAST:event_back_Button1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
                //the file path
               File file = new File("Text.txt");
               //if the file not exist create one
               if(!file.exists()){
                   file.createNewFile();
               }
               
               FileWriter fw = new FileWriter(file.getAbsoluteFile());
               BufferedWriter bw = new BufferedWriter(fw);
               
               //loop for jtable rows
               for(int i = 0; i < jTable1.getRowCount(); i++){
                   //loop for jtable column
                   for(int j = 0; j < jTable1.getColumnCount(); j++){
                       bw.write(jTable1.getModel().getValueAt(i, j)+" ");
                   }
                   //break line at the begin 
                   //break line at the end 
                   bw.write("\n_________\n");
               }
               //close BufferedWriter
               bw.close();
               //close FileWriter 
               fw.close();
               JOptionPane.showMessageDialog(null, "Επιτυχής αποθήκευση");
               
               }catch(Exception ex){
                   ex.printStackTrace();
               }
           
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
     DefaultTableModel tb1Model =(DefaultTableModel)jTable4.getModel();
     String  test_id =tb1Model.getValueAt(jTable4.getSelectedRow(),0).toString();
     try{
     Class.forName("com.mysql.cj.jdbc.Driver");
     java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
     String query1 = "SELECT * FROM test_results WHERE test_id = '"+test_id+"'";
     PreparedStatement pst = con.prepareStatement(query1);
     ResultSet rs = pst.executeQuery();
     if(rs.next()) {
        String doctor_id = Integer.toString(rs.getInt("patient_id"));
        String test_title = rs.getString("test_title");
        String test_date = rs.getString("test_date");
        String tbData[]={doctor_id,test_title,test_date};
        DefaultTableModel tb1Model1 =(DefaultTableModel) jTable1.getModel();
                   
        tb1Model1.addRow(tbData);
        
     }
     con.close();
     }  catch (ClassNotFoundException ex) {
            Logger.getLogger(Patient_Prescription.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Patient_Prescription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
     DefaultTableModel tb1Model =(DefaultTableModel)jTable3.getModel();
     String  diagnosis_id =tb1Model.getValueAt(jTable3.getSelectedRow(),0).toString();
     try{
     Class.forName("com.mysql.cj.jdbc.Driver");
     java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
     String query1 = "SELECT * FROM diagnosis WHERE diagnosis_id = '"+diagnosis_id+"'";
     PreparedStatement pst = con.prepareStatement(query1);
     ResultSet rs = pst.executeQuery();
     if(rs.next()) {
        String doctor_id = Integer.toString(rs.getInt("doctor_id"));
        String patient_id = Integer.toString(rs.getInt("patient_id"));
        String textbox = rs.getString("textbox");
        String diagnosis_date = rs.getString("diagnosis_date");
        String tbData[]={doctor_id,patient_id,textbox,diagnosis_date};
        DefaultTableModel tb1Model1 =(DefaultTableModel) jTable2.getModel();
                   
        tb1Model1.addRow(tbData);
        
     }
     con.close();
     }  catch (ClassNotFoundException ex) {
            Logger.getLogger(Patient_Prescription.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Patient_Prescription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable3MouseClicked

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
            java.util.logging.Logger.getLogger(Patient_Kartela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient_Kartela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient_Kartela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient_Kartela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient_Kartela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_Button1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    static javax.swing.JTabbedPane jTabbedPane3;
    static javax.swing.JTable jTable1;
    static javax.swing.JTable jTable2;
    static javax.swing.JTable jTable3;
    static javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
