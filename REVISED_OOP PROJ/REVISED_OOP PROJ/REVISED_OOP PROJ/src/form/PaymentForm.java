/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import Lib.Car;
import Lib.CarRep;
import Lib.FleetInventory;
import Lib.PayOps;
import Lib.PayRecord;
import Lib.Payment;
import Lib.Rent;
import Lib.RentOps;
import Lib.RentRecord;
import form.carRent;
import gui.CarTable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author MVL
 */
public class PaymentForm extends javax.swing.JFrame {
    private FleetInventory fi;
    private RentOps ro;
    private PayOps po;
    private PaymentForm p;
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy");
    Payment pay;
    Car car;
    LocalDate startDate, endDate;
    Rent rent;
        
    /**
     * Creates new form Payment
     */
    public PaymentForm(Car car, boolean isAvail) {
        initComponents();
        
//        String text = String.format("%.2f", car.getPrice());
//        BaseLbl.setText(text);
        this.car = car;
        CarRep rentCar = new CarRep(car,isAvail);
        ArrayList<CarRep> rep = new ArrayList<CarRep>();
        rep.add(rentCar);
        fi = FleetInventory.getInstance();
        ro = RentOps.getInstance(fi);
        po = PayOps.getInstance(fi);
        tableUpdate(rep);
        startDate = LocalDate.now();
        rentStartLbl.setText(dtf.format(startDate).toString());
        
        
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            fi.writeFile();
            fi.readFile();
            po.writeFile();
            po.readFile(fi);
            ro.writeFile();
            ro.readFile(fi);
        }));
    }

    public void tableUpdate(ArrayList<CarRep> list){
        CarTable ct = new CarTable(list);
        this.tbl.setModel(ct);
        tbl.setRowHeight(70);
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        totalTxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        paymentMethodComboBox = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        rentStartLbl = new javax.swing.JLabel();
        rentEndLbl = new javax.swing.JLabel();
        daysRentTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        payBtn1 = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Payment");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 132, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Start of Rent");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 349, 112, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Total:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 416, -1, -1));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 333, 122, -1));

        totalTxt.setText(".");
        jPanel1.add(totalTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 418, 211, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 43, 65, -1));
        jPanel1.add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 40, 439, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Phone Number:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 82, 100, -1));
        jPanel1.add(phoneTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 79, 439, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Payment Method:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 123, 100, -1));

        tbl.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Code", "Plate#", "Brand", "Model", "Description", "Price", "Availability"
            }
        ));
        tbl.setToolTipText("");
        jScrollPane1.setViewportView(tbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 596, 98));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("End of Rent");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 371, 112, -1));

        paymentMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Online Banking", "GCash", "Maya" }));
        jPanel1.add(paymentMethodComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 120, -1, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Amount of days to rent:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 276, 135, -1));

        rentStartLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rentStartLbl.setText("CurrentDate");
        jPanel1.add(rentStartLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 349, 85, -1));

        rentEndLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rentEndLbl.setText("NULL");
        jPanel1.add(rentEndLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 371, 85, -1));

        daysRentTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                daysRentTxtKeyReleased(evt);
            }
        });
        jPanel1.add(daysRentTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 273, 85, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("MM-DD-YY");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 316, -1, 27));

        payBtn1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        payBtn1.setText("Pay");
        payBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payBtn1MouseClicked(evt);
            }
        });
        payBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(payBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 140, 70));

        menuBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        menuBtn.setText("Return to Rent Menu");
        menuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBtnMouseClicked(evt);
            }
        });
        jPanel1.add(menuBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void daysRentTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_daysRentTxtKeyReleased
        try {
        int days = Integer.parseInt(daysRentTxt.getText());
        if (days <= 0) {
            rentEndLbl.setText("Invalid");
        } else {
            endDate = startDate.plusDays(days);
            rentEndLbl.setText(dtf.format(endDate));
            
            // Calculate payment details
            pay = new Payment(nameTxt.getText(), phoneTxt.getText(), paymentMethodComboBox.getSelectedItem().toString());
            rent = new Rent(car, startDate, endDate);
            pay.setRent(rent);
            double price = pay.computePrice();
            totalTxt.setText(String.format("%.2f", price));
        }
    } catch (NumberFormatException e) {
        rentEndLbl.setText("Invalid");
    }
    }//GEN-LAST:event_daysRentTxtKeyReleased

    private void payBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payBtn1MouseClicked
        // TODO add your handling code here:
        boolean payConf = po.recordTransac(car, nameTxt.getText(), phoneTxt.getText(), paymentMethodComboBox.getSelectedItem().toString());
        boolean rentConf = ro.RentCar(car, startDate, endDate);
        if (payConf){
            po.writeFile();
        }
        if (rentConf){
            ro.writeFile();
        }
        
    }//GEN-LAST:event_payBtn1MouseClicked

    private void menuBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBtnMouseClicked
        // TODO add your handling code here:
        carRent cr = new carRent();
        this.hide();
        cr.setVisible(true);
    }//GEN-LAST:event_menuBtnMouseClicked

    private void payBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payBtn1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField daysRentTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menuBtn;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JButton payBtn1;
    private javax.swing.JComboBox<String> paymentMethodComboBox;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JLabel rentEndLbl;
    private javax.swing.JLabel rentStartLbl;
    private javax.swing.JTable tbl;
    private javax.swing.JLabel totalTxt;
    // End of variables declaration//GEN-END:variables
}
