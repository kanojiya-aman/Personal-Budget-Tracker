/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgettracker;

import Connectivity.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author Lenovo
 */
public class BudgetTracker extends javax.swing.JFrame {

    /**
     * Creates new form BudgetTracker
     */
    public BudgetTracker() {
        initComponents();
        
        try{
           Connection con = DB.getCon();
           String query;
           PreparedStatement p;
                     
           query = "select * from tracker";
           Statement s= con.createStatement();
           ResultSet rs = s.executeQuery(query);
            
           while(rs.next()){          

           textarea.append(
           rs.getString(1)+"\t"+ rs.getString(2)+
                   "\t\t$"+ 
             rs.getInt(3)+"\t\t"+ rs.getString(4)+"\n"); 
          }
           
          // FOR TOTAL EARNED MONEY
          
 query = "SELECT SUM(amount)FROM TRACKER WHERE category = 'money earned'";
          s= con.createStatement();
          rs = s.executeQuery(query);
            
           while(rs.next()){                         
               earned.setText(""+rs.getInt("sum(amount)"));
          }
           
       // FOR TOTAL SPENT
          
         query = "SELECT SUM(amount)FROM TRACKER WHERE category = 'money spent '";
          s= con.createStatement();
          rs = s.executeQuery(query);
            
           while(rs.next()){                         
               spent.setText(""+rs.getInt("SUM(amount)"));
          }
           
           // FOR TOTAL SAVED
          
         query = "SELECT SUM(amount)FROM TRACKER WHERE category = 'money saved '";
          s= con.createStatement();
          rs = s.executeQuery(query);
            
           while(rs.next()){                         
               saved.setText(""+rs.getInt("SUM(amount)"));
          }
           
           // FOR TOTAL INVESTED
          
         query = "SELECT SUM(amount)FROM TRACKER WHERE category = 'money invested'";
          s= con.createStatement();
          rs = s.executeQuery(query);
            
           while(rs.next()){                         
               invested.setText(""+rs.getInt("SUM(amount)"));
          }    
           
           
       }
       catch(Exception e){
           System.out.println(e);
       }
        
        
      inhand.setText("$"+
               (
      (Integer.parseInt(earned.getText())+Integer.parseInt(saved.getText()))
               -
      (Integer.parseInt(spent.getText())+Integer.parseInt(invested.getText()))
               )
       );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        list = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        earned = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        saved = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spent = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        invested = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        inhand = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("AMOUNT (IN $)");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        list.setBackground(new java.awt.Color(255, 204, 255));
        list.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MONEY EARNED", "MONEY SPENT ", "MONEY SAVED ", "MONEY INVESTED" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setText("CATEGORY");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        amount.setBackground(new java.awt.Color(255, 204, 255));
        amount.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });

        earned.setBackground(new java.awt.Color(255, 204, 204));
        earned.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        earned.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        earned.setBorder(new javax.swing.border.MatteBorder(null));
        earned.setOpaque(true);

        desc.setBackground(new java.awt.Color(255, 204, 255));
        desc.setColumns(20);
        desc.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        desc.setRows(5);
        jScrollPane1.setViewportView(desc);

        jButton1.setBackground(new java.awt.Color(102, 0, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 204, 204));
        jButton1.setText("ENTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("TOTAL MONEY EARNED");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel7.setText("DESCRIPTION");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        saved.setBackground(new java.awt.Color(255, 204, 204));
        saved.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        saved.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saved.setBorder(new javax.swing.border.MatteBorder(null));
        saved.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("TOTAL MONEY SAVED");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        spent.setBackground(new java.awt.Color(255, 204, 204));
        spent.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        spent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        spent.setBorder(new javax.swing.border.MatteBorder(null));
        spent.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("TOTAL MONEY SPENT");
        jLabel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        invested.setBackground(new java.awt.Color(255, 204, 204));
        invested.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        invested.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invested.setBorder(new javax.swing.border.MatteBorder(null));
        invested.setOpaque(true);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("TOTAL MONEY INVESTED");
        jLabel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel13.setText("MONEY IN HAND");
        jLabel13.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        inhand.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        inhand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inhand.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jLabel15.setBackground(new java.awt.Color(102, 0, 102));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("   CATEGORY                           DATE                                AMOUNT                                 DESCRIPTION                    ");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel15.setOpaque(true);

        textarea.setBackground(new java.awt.Color(255, 204, 255));
        textarea.setColumns(20);
        textarea.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        textarea.setRows(5);
        jScrollPane2.setViewportView(textarea);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel16.setText("PREVIOUS TRANSCATIONS");
        jLabel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel17.setBackground(new java.awt.Color(255, 204, 204));
        jLabel17.setFont(new java.awt.Font("Calisto MT", 1, 48)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("B  U  D  G  E  T          T  R  A  C  K  E  R");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel17.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(279, 279, 279)))
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(68, 68, 68)
                        .addComponent(inhand, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spent, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(earned, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(30, 30, 30)
                                .addComponent(invested, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(75, 75, 75)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(saved, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(375, 375, 375))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel2)
                    .addContainerGap(872, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(list)
                    .addComponent(jLabel1)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(earned, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(saved, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(spent, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(invested, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(inhand, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(jLabel2)
                    .addContainerGap(768, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         textarea.setText("");
         LocalDate date = LocalDate.now();
         try{
           Connection con = DB.getCon();
           String query;
           PreparedStatement p;
           query = "insert into tracker(category,date,amount,description) value(?,?,?,?)";
           p = con.prepareStatement(query);
           
           p.setString(1, (String)list.getSelectedItem());
           p.setString(2, date+"");
           p.setInt(3, Integer.parseInt(amount.getText()));
           p.setString(4,desc.getText());
           p.executeUpdate();
           
          
           // FOR PREVIOUS TRANSACTIONS
           
           Statement s;
           ResultSet rs;
           
           query = "select * from tracker";
           s= con.createStatement();
           rs= s.executeQuery(query);
            
           while(rs.next()){          

           textarea.append(
           rs.getString(1)+"\t"+ rs.getString(2)+
                   "\t\t"+ 
             rs.getInt(3)+"\t\t"+ rs.getString(4)+"\n"); 
          
          }
           
          // FOR TOTAL EARNED MONEY
          
         query = "SELECT SUM(amount)FROM TRACKER WHERE category = 'money earned'";
          s= con.createStatement();
          rs = s.executeQuery(query);
            
           while(rs.next()){                         
               earned.setText("$"+rs.getInt("SUM(amount)"));
          }
           
          // FOR TOTAL SPENT
          
         query = "SELECT SUM(amount)FROM TRACKER WHERE category = 'money spent '";
          s= con.createStatement();
          rs = s.executeQuery(query);
            
           while(rs.next()){                         
               spent.setText("$"+rs.getInt("SUM(amount)"));
          }
           
           // FOR TOTAL SAVED
          
         query = "SELECT SUM(amount)FROM TRACKER WHERE category = 'money saved '";
          s= con.createStatement();
          rs = s.executeQuery(query);
            
           while(rs.next()){                         
               saved.setText("$"+rs.getInt("SUM(amount)"));
          }
           
           // FOR TOTAL INVESTED
          
         query = "SELECT SUM(amount)FROM TRACKER WHERE category = 'money invested'";
          s= con.createStatement();
          rs = s.executeQuery(query);
            
           while(rs.next()){                         
               invested.setText("$"+rs.getInt("SUM(amount)"));
          }
           
       }
       catch(Exception e){
           System.out.println(e);
       }
        
         
       inhand.setText("$"+
               (
      (Integer.parseInt(earned.getText())+Integer.parseInt(saved.getText()))
               -
      (Integer.parseInt(spent.getText())+Integer.parseInt(invested.getText()))
               )
       );
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(BudgetTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BudgetTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BudgetTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BudgetTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BudgetTracker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JTextArea desc;
    private javax.swing.JLabel earned;
    private javax.swing.JLabel inhand;
    private javax.swing.JLabel invested;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JComboBox<String> list;
    private javax.swing.JLabel saved;
    private javax.swing.JLabel spent;
    private javax.swing.JTextArea textarea;
    // End of variables declaration//GEN-END:variables
}
