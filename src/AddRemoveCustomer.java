//.........................................
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AddRemoveCustomer extends javax.swing.JPanel {

   
    public AddRemoveCustomer() {
        initComponents();
        //populates tatble on startup 
        getTableContents(); 
       
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        surname = new javax.swing.JTextField();
        phoneNumber = new javax.swing.JTextField();
        addNewCustomer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        removeCustomer = new javax.swing.JButton();

        jLabel1.setText("Name: ");

        jLabel2.setText("Surname:");

        jLabel3.setText("Phone Number");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        addNewCustomer.setText("Add New Customer");
        addNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewCustomerActionPerformed(evt);
            }
        });

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Num", "Name", "Surname"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customerTable);
        if (customerTable.getColumnModel().getColumnCount() > 0) {
            customerTable.getColumnModel().getColumn(0).setResizable(false);
            customerTable.getColumnModel().getColumn(1).setResizable(false);
        }

        removeCustomer.setText("Remove Customer");
        removeCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(addNewCustomer)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(removeCustomer)
                .addGap(191, 191, 191))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29)
                        .addComponent(addNewCustomer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(removeCustomer)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewCustomerActionPerformed

        Client client = new Client(); 
        
        String cName = this.name.getText(); 
        String cSurname = this.surname.getText();
        String cPhone = this.phoneNumber.getText();
   
        this.name.setText("");
        this.surname.setText("");
        this.phoneNumber.setText("");
        
        client.addNewCustomer(cName, cSurname, cPhone);
        getTableContents(); 
        
       
        
         
        
    }//GEN-LAST:event_addNewCustomerActionPerformed

    private void removeCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCustomerActionPerformed

        
      Client k = new Client(); 
      
        int row = customerTable.getSelectedRow();
        
        if(customerTable.getRowSorter()!=null){
        row = customerTable.getRowSorter().convertRowIndexToModel(row); 
        }else{
        row = customerTable.getSelectedRow();
        }
        
        if(row == -1){
        JOptionPane.showMessageDialog(null, "Please select a customer");
        }else{
                
          int cusNumber = (Integer)customerTable.getModel().getValueAt(row, 0); 
          k.removeCustomer(cusNumber);
          model.removeRow(row);
          getTableContents(); 
          
           
    }
         

       
    }//GEN-LAST:event_removeCustomerActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewCustomer;
    private javax.swing.JTable customerTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JButton removeCustomer;
    private javax.swing.JTextField surname;
    // End of variables declaration//GEN-END:variables
    private static DefaultTableModel model;
    private static Client view; 
    private static Customer customer; 
   
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
            java.util.logging.Logger.getLogger(AddRemoveCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddRemoveCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddRemoveCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddRemoveCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddRemoveCustomer().setVisible(true);
            }
        });
    }
    
    public void getTableContents(){
    
       Client view = new Client(); 
       ArrayList<Customer> list = new ArrayList<Customer>(view.customerTable());
       //sorts the ArrayList in alphabetical order
       Collections.sort(list, new Comparator<Customer>(){
           @Override
           public int compare(Customer t, Customer t1) {
               return t.getName().compareTo(t1.getName()); 
           }
       
       });
       
       //populates the table from the arrayList
        model = (DefaultTableModel) customerTable.getModel();
        model.setRowCount(0);
        for(int a = 0; a<list.size(); a++){
        model.addRow(new Object[]{list.get(a).getCustNumber(), list.get(a).getName(),list.get(a).getSurname()});
}
    
    
}

}
