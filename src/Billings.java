
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
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DINESH
 */
public class Billings extends javax.swing.JFrame {
    Connection cnc = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement st = null;
    private boolean flase;
    
    public Billings() {
        initComponents();
        ShowProducts();
        GetCustomer();
        bill_table.getColumnModel().getColumn(0).setPreferredWidth(100);
        bill_table.getColumnModel().getColumn(1).setPreferredWidth(200);
        bill_table.getColumnModel().getColumn(2).setPreferredWidth(100);
        bill_table.getColumnModel().getColumn(3).setPreferredWidth(150);
        bill_table.getColumnModel().getColumn(4).setPreferredWidth(150);
        product_name.setEditable(flase);
        price.setEditable(flase);
        customer_name.setEditable(flase);
    }
    
    private void Clear()
    {
        product_name.setText("");
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
            products_table.setModel(DbUtils.resultSetToTableModel(rs));
            int[] columnWidths = {50, 200, 150, 150, 80, 80, 100};
            TableColumnModel columnModel = products_table.getColumnModel();
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            if (i < columnWidths.length) {
                column.setPreferredWidth(columnWidths[i]);
            }
        }
        }catch (Exception e){
        }
    }
    
    private void GetCustomer(){
        try{
            cnc = DriverManager.getConnection("jdbc:mysql://localhost:3306/rrdb","root","1234");
            Statement st = cnc.createStatement();
            String query = "select * from customer_table";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                String mycust = rs.getString("id");
                customer_id.addItem(mycust);  
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
        productshiftbtn = new javax.swing.JLabel();
        customershiftbtn = new javax.swing.JLabel();
        suppliershiftbtn = new javax.swing.JLabel();
        logoutshiftbtn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addtobillbtn = new javax.swing.JButton();
        printbtn = new javax.swing.JButton();
        customer_id = new javax.swing.JComboBox<>();
        customer_name = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        products_table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        product_name = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bill_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 50));

        jLabel8.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("RETAIL REGISTER  -  BILLINGS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(230, 230, 230))
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

        productshiftbtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        productshiftbtn.setText("Product");
        productshiftbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productshiftbtnMouseClicked(evt);
            }
        });

        customershiftbtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        customershiftbtn.setText("Customer");
        customershiftbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customershiftbtnMouseClicked(evt);
            }
        });

        suppliershiftbtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        suppliershiftbtn.setText("Supplier");
        suppliershiftbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suppliershiftbtnMouseClicked(evt);
            }
        });

        logoutshiftbtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        logoutshiftbtn.setText("Logout");
        logoutshiftbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutshiftbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(customershiftbtn)
                .addGap(119, 119, 119)
                .addComponent(productshiftbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(suppliershiftbtn)
                .addGap(110, 110, 110)
                .addComponent(logoutshiftbtn)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productshiftbtn)
                    .addComponent(suppliershiftbtn)
                    .addComponent(logoutshiftbtn)
                    .addComponent(customershiftbtn))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("Retail Register");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setText("Customer ID :");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setText("Customer Name :");

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

        addtobillbtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        addtobillbtn.setForeground(new java.awt.Color(255, 102, 0));
        addtobillbtn.setText("Add to Bill");
        addtobillbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtobillbtnActionPerformed(evt);
            }
        });

        printbtn.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        printbtn.setForeground(new java.awt.Color(255, 102, 0));
        printbtn.setText("Print");
        printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbtnActionPerformed(evt);
            }
        });

        customer_id.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        customer_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_idActionPerformed(evt);
            }
        });

        customer_name.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_nameActionPerformed(evt);
            }
        });

        products_table.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        products_table.setModel(new javax.swing.table.DefaultTableModel(
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
        products_table.setRowHeight(25);
        products_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                products_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(products_table);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("Products");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Customer Bill");

        product_name.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        product_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_nameActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel13.setText("Product Name :");

        total.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        total.setForeground(new java.awt.Color(255, 102, 0));
        total.setText("Total :");

        quantity.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        bill_table.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        bill_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "s_no", "Product_name", "Quantity", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        bill_table.setRowHeight(25);
        bill_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bill_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bill_table);

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
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2)
                                            .addComponent(customer_id, 0, 200, Short.MAX_VALUE)
                                            .addComponent(jLabel13)
                                            .addComponent(product_name, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(jLabel5)
                                            .addComponent(quantity))
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 4, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(286, 286, 286))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(addtobillbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printbtn)
                .addGap(206, 206, 206)
                .addComponent(total)
                .addGap(30, 30, 30))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(product_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printbtn)
                    .addComponent(addtobillbtn)
                    .addComponent(total))
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed
  
    private void UpdateStock(){
        try {
            String updatequery = "UPDATE product_table SET quantity=? WHERE id=?";
            cnc = DriverManager.getConnection("jdbc:mysql://localhost:3306/rrdb", "root", "1234");  
            PreparedStatement Add = cnc.prepareStatement(updatequery);
            int newstock = stock - Integer.valueOf(quantity.getText());
            Add.setInt(1, newstock);
            Add.setInt(2, key);
            if (Add.executeUpdate() == 1) {
                ShowProducts();
                JOptionPane.showMessageDialog(this, "Product Updated!");
            } else {
                JOptionPane.showMessageDialog(this, "Not Updated!");
            }
            cnc.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private int s_no = 1;

    double grndtotal = 0.0;
    private void addtobillbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtobillbtnActionPerformed
        if(customer_name.getText().isEmpty() ||product_name.getText().isEmpty() ||price.getText().isEmpty() ||quantity.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Missing Information");
        }else if (Integer.valueOf(quantity.getText()) > stock){
            JOptionPane.showMessageDialog(this,"Not Enough Stock");
        }else{
            String Product_name = product_name.getText();
            String Quantity = quantity.getText();
            String Price = price.getText();
            double Total = Double.valueOf(Quantity) * Double.valueOf(Price);
            Object[] DataRow = {s_no, Product_name, Quantity, Price, Total};
            DefaultTableModel model = (DefaultTableModel)bill_table.getModel();
            model.addRow(DataRow);
            grndtotal = grndtotal + Total;
            s_no++;
            total.setText("Rs : " + grndtotal);
            DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
            leftRenderer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            for (int i = 0; i < model.getColumnCount(); i++) {
            bill_table.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }
            UpdateStock();
            Clear();
        }
    }//GEN-LAST:event_addtobillbtnActionPerformed

    private void printbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtnActionPerformed
        try {
        bill_table.print();
        DefaultTableModel model = (DefaultTableModel) bill_table.getModel();
        model.setRowCount(0);
        grndtotal = 0.0; 
        total.setText("Rs : " + grndtotal);
        s_no = 1;
    } catch (Exception e) {
       
    }
    }//GEN-LAST:event_printbtnActionPerformed

    private void customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_nameActionPerformed

    private void product_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_nameActionPerformed

    int key = 0, stock = 0;
    private void products_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_products_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel)products_table.getModel();
        int MyIndex = products_table.getSelectedRow();
        key = Integer.valueOf(model.getValueAt(MyIndex,0).toString());
        product_name.setText(model.getValueAt(MyIndex,1).toString());
        price.setText(model.getValueAt(MyIndex,3).toString());
        stock = Integer.valueOf(model.getValueAt(MyIndex,4).toString());
    }//GEN-LAST:event_products_tableMouseClicked

    private void GetCusotmerName(){
        String query = "select name from customer_table where id=" + customer_id.getSelectedItem().toString();
        try{
            cnc = DriverManager.getConnection("jdbc:mysql://localhost:3306/rrdb","root","1234");
            Statement st = cnc.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                customer_name.setText(rs.getString("name"));
            }
        } catch (Exception e){   
        }
    }
 
    private void customer_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_idActionPerformed
        GetCusotmerName();
    }//GEN-LAST:event_customer_idActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void productshiftbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productshiftbtnMouseClicked
        new Products().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_productshiftbtnMouseClicked

    private void customershiftbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customershiftbtnMouseClicked
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customershiftbtnMouseClicked

    private void suppliershiftbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliershiftbtnMouseClicked
        new Suppliers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_suppliershiftbtnMouseClicked

    private void logoutshiftbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutshiftbtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_logoutshiftbtnMouseClicked

    private void bill_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bill_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_tableMouseClicked
   
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
            java.util.logging.Logger.getLogger(Billings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtobillbtn;
    private javax.swing.JTable bill_table;
    private javax.swing.JComboBox<String> customer_id;
    private javax.swing.JTextField customer_name;
    private javax.swing.JLabel customershiftbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logoutshiftbtn;
    private javax.swing.JTextField price;
    private javax.swing.JButton printbtn;
    private javax.swing.JTextField product_name;
    private javax.swing.JTable products_table;
    private javax.swing.JLabel productshiftbtn;
    private javax.swing.JTextField quantity;
    private javax.swing.JLabel suppliershiftbtn;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
