package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

import static java.awt.EventQueue.invokeLater;

public class Login extends JFrame {
    Controller cntr;

    public Login() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {

        cntr = new Controller();
        jPanel1 = new JPanel();
        userLabel = new JLabel();
        passLabel = new JLabel();
        userField = new javax.swing.JTextField();
        passField = new JPasswordField();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(300, 200));

        jPanel1.setBackground(new java.awt.Color(78, 137, 174));

        userLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 163, 114));
        userLabel.setText("Username:");

        passLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); // NOI18N
        passLabel.setForeground(new java.awt.Color(255, 163, 114));
        passLabel.setText("Password:");

        userField.addActionListener(this::userFieldActionPerformed);

        passField.addActionListener(this::passFieldActionPerformed);

        logoLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(240, 240, 240));
        logoLabel.setText("OptiX");

        jButton1.setBackground(new java.awt.Color(67, 101, 139));
        jButton1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 163, 114));
        jButton1.setText("Login");
        jButton1.setToolTipText("");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(211, Short.MAX_VALUE)
                                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(userLabel)
                                                        .addComponent(passLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(userField, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                        .addComponent(passField))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passLabel)
                                        .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println(passField.getPassword());
        if (!userField.getText().equals("")  && passField.getPassword().length != 0) {
            System.out.println("here");
            String userName = userField.getText();
            String password = new String(passField.getPassword()); //not appropriate but it will be fixed later.
            boolean isLogged = cntr.checkLogin(userName, password);
            if (isLogged) {
                new MainFrame();
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }else {
                JOptionPane.showMessageDialog(null, "Username or password is incorrect.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please fill all required fields.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_passFieldActionPerformed

    public static void main(String args[]) {
        invokeLater(() -> new Login().setVisible(true));
    }

    private javax.swing.JButton jButton1;
    private JPanel jPanel1;
    private JLabel logoLabel = new JLabel();
    private JPasswordField passField;
    private JLabel passLabel;
    private javax.swing.JTextField userField;
    private JLabel userLabel;
}
