/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author DINESH
 */
public class Products extends javax.swing.JFrame {
    Connection cnc = null;
    PreparedStatement ps = null;
    ResultSet rs = null, rs1 = null;
    Statement st = null, st1 = null;
    private boolean Flase;
    
    public Products() {
        initComponents();
        GetSupplier();
        supplier_name.setEditable(Flase);
        ShowProducts();
    }

    private void Clear()
    {
        name.setText("");
        price.setText("");
        quantity.setText("");
        key=0;
    }

    private void ShowProducts()
    {
        try{
            cnc = DriverManager.getConnection("jdbc:mysql://localhost:3306/rrdb","root","1234");
            Statement st = cnc.createStatement();
            ResultSet rs = st.executeQuery("Select * from product_table");
            product_table.setModel(DbUtils.resultSetToTableModel(rs));
            int[] columnWidths = {50, 200, 150, 80, 80, 80, 200};
            TableColumnModel columnModel = product_table.getColumnModel();

            for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            if (i < columnWidths.length) {
                column.setPreferredWidth(columnWidths[i]);
            }
        }
        }catch (Exception e){
        }
    }
    
    private void GetSupplier(){
        try{
            cnc = DriverManager.getConnection("jdbc:mysql://localhost:3306/rrdb","root","1234");
            Statement st = cnc.createStatement();
            String query = "select * from supplier_table";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                String mysup = rs.getString("id");
                supplier_id.addItem(mysup);   
            }
        } catch (Exception e){
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        suppliershiftbtn = new javax.swing.JLabel();
        customershiftbtn = new javax.swing.JLabel();
        billingshiftbtn = new javax.swing.JLabel();
        logoutbtn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        supplier_name = new javax.swing.JTextField();
        category = new javax.swing.JComboBox<>();
        supplier_id = new javax.swing.JComboBox<>();
        savebtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        product_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 50));

        jLabel8.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("RETAIL REGISTER  -  PRODUCTS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(250, 250, 250))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 50));

        suppliershiftbtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        suppliershiftbtn.setText("Supplier");
        suppliershiftbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suppliershiftbtnMouseClicked(evt);
            }
        });

        customershiftbtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        customershiftbtn.setText("Customer");
        customershiftbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customershiftbtnMouseClicked(evt);
            }
        });

        billingshiftbtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        billingshiftbtn.setText("Billing");
        billingshiftbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billingshiftbtnMouseClicked(evt);
            }
        });

        logoutbtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        logoutbtn.setText("Logout");
        logoutbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(customershiftbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(billingshiftbtn)
                .addGap(137, 137, 137)
                .addComponent(suppliershiftbtn)
                .addGap(125, 125, 125)
                .addComponent(logoutbtn)
                .addGap(85, 85, 85))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customershiftbtn)
                    .addComponent(billingshiftbtn)
                    .addComponent(logoutbtn)
                    .addComponent(suppliershiftbtn))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Retail Register");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setText("Product Name :");

        name.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setText("Category :");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setText("Price :");

        price.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setText("Quantity :");

        quantity.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setText("Supplier  ID :");

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel7.setText("Supplier  Name :");

        supplier_name.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        supplier_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_nameActionPerformed(evt);
            }
        });

        category.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Smartphones", "Computers", "Home Appliances", "Gadgets", "Electronic Units" }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        supplier_id.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        supplier_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_idActionPerformed(evt);
            }
        });

        savebtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        savebtn.setForeground(new java.awt.Color(255, 102, 0));
        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        editbtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        editbtn.setForeground(new java.awt.Color(255, 102, 0));
        editbtn.setText("Edit");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        deletebtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        deletebtn.setForeground(new java.awt.Color(255, 102, 0));
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        product_table.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        product_table.setModel(new javax.swing.table.DefaultTableModel(
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
        product_table.setRowHeight(25);
        product_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(product_table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(supplier_id, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(supplier_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(deletebtn)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplier_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplier_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(savebtn)
                            .addComponent(editbtn))
                        .addGap(18, 18, 18)
                        .addComponent(deletebtn))
                    .addComponent(jScrollPane1))
                .addGap(0, 46, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void supplier_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplier_nameActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        if(name.getText().isEmpty() ||price.getText().isEmpty() ||quantity.getText().isEmpty() || supplier_name.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Missing Information");
        }else{
            try{
                cnc = DriverManager.getConnection("jdbc:mysql://localhost:3306/rrdb","root","1234");
                PreparedStatement Add = cnc.prepareStatement("INSERT INTO product_table (name, category, price, quantity, supplier_id, supplier_name) VALUES (?,?,?,?,?,?)");
                Add.setString(1,name.getText());
                Add.setString(2,category.getSelectedItem().toString());
                Add.setString(3,price.getText());
                Add.setString(4,quantity.getText());
                Add.setString(5,supplier_id.getSelectedItem().toString());
                Add.setString(6,supplier_name.getText());
                int row = Add.executeUpdate();
                JOptionPane.showMessageDialog(this,"Product Saved !");
                ShowProducts();
                cnc.close();
                Clear();
            }catch (Exception e){
                JOptionPane.showMessageDialog(this,e);
            }
        }
    }//GEN-LAST:event_savebtnActionPerformed
    
    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        if(name.getText().isEmpty() ||category.getSelectedIndex()==-1 ||price.getText().isEmpty() ||quantity.getText().isEmpty() ||supplier_id.getSelectedIndex()==-1 ||supplier_name.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Missing Information");
        }else{
            try {
                String updatequery = "UPDATE product_table SET name=?, category=?, price=?, quantity=?, supplier_id=?, supplier_name=? WHERE id=?";
                cnc = DriverManager.getConnection("jdbc:mysql://localhost:3306/rrdb", "root", "1234");  
                PreparedStatement Add = cnc.prepareStatement(updatequery);
                Add.setInt(7, key);
                Add.setString(1,name.getText());
                Add.setString(2,category.getSelectedItem().toString());
                Add.setString(3,price.getText());
                Add.setString(4,quantity.getText());
                Add.setString(5,supplier_id.getSelectedItem().toString());
                Add.setString(6, supplier_name.getText());
                if (Add.executeUpdate() == 1) {
                    ShowProducts();
                    JOptionPane.showMessageDialog(this, "Product Updated!");
                    Clear();
                } else {
                    JOptionPane.showMessageDialog(this, "Not Updated!");
                }
                cnc.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_editbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        if(key==0)
        {
            JOptionPane.showMessageDialog(this,"Select a Product");
        }else{
            try{
                cnc = DriverManager.getConnection("jdbc:mysql://localhost:3306/rrdb","root","1234");
                String query = "Delete from product_table where id="+key;
                Statement Delete = cnc.createStatement();
                Delete.executeUpdate(query);                
                JOptionPane.showMessageDialog(this,"Product Deleted");
                ShowProducts();
                Clear();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,e);
            }
        }
    }//GEN-LAST:event_deletebtnActionPerformed
    int key = 0;
    private void product_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel)product_table.getModel();
        int MyIndex = product_table.getSelectedRow();
        key = Integer.valueOf(model.getValueAt(MyIndex,0).toString());
        name.setText(model.getValueAt(MyIndex,1).toString());
        category.setSelectedItem(model.getValueAt(MyIndex,2).toString());
        price.setText(model.getValueAt(MyIndex,3).toString());
        quantity.setText(model.getValueAt(MyIndex,4).toString());
        supplier_id.setSelectedItem(model.getValueAt(MyIndex,5).toString());
        supplier_name.setText(model.getValueAt(MyIndex,6).toString());
    }//GEN-LAST:event_product_tableMouseClicked
    
    private void GetSupplierName(){
        String query = "select name from supplier_table where id=" + supplier_id.getSelectedItem().toString();
        try{
            cnc = DriverManager.getConnection("jdbc:mysql://localhost:3306/rrdb","root","1234");
            Statement st = cnc.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                supplier_name.setText(rs.getString("name"));
            }
        } catch (Exception e){   
        }
    }
    
    private void supplier_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_idActionPerformed
       GetSupplierName();
    }//GEN-LAST:event_supplier_idActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryActionPerformed

    private void suppliershiftbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliershiftbtnMouseClicked
        new Suppliers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_suppliershiftbtnMouseClicked

    private void customershiftbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customershiftbtnMouseClicked
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customershiftbtnMouseClicked

    private void billingshiftbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billingshiftbtnMouseClicked
        new Billings().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_billingshiftbtnMouseClicked

    private void logoutbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutbtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_logoutbtnMouseClicked

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
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel billingshiftbtn;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel customershiftbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoutbtn;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JTable product_table;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton savebtn;
    private javax.swing.JComboBox<String> supplier_id;
    private javax.swing.JTextField supplier_name;
    private javax.swing.JLabel suppliershiftbtn;
    // End of variables declaration//GEN-END:variables
}
