/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static java.awt.EventQueue.*;

public class ChangePasswordFrame extends JFrame {

    private JPanel jPanel1;
    private JLabel newAgain;
    private JPasswordField newAgainField;
    private JPasswordField newPassField;
    private JLabel newPassword;
    private JPasswordField oldPassField;
    private JLabel oldPassword;
    private JButton saveButon;
    private Controller cntr;

    public ChangePasswordFrame() {
        initComponents();
        setTitle("Change Password");
        setVisible(true);
    }

    private void initComponents() {
        cntr = new Controller();
        jPanel1 = new JPanel();
        oldPassword = new JLabel();
        newPassword = new JLabel();
        newAgain = new JLabel();
        oldPassField = new JPasswordField();
        newPassField = new JPasswordField();
        newAgainField = new JPasswordField();
        saveButon = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(67, 101, 139));
        setResizable(false);

        jPanel1.setBackground(new Color(78, 137, 174));
        jPanel1.setForeground(new Color(67, 101, 139));
        jPanel1.setPreferredSize(new Dimension(491, 300));

        oldPassword.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        oldPassword.setForeground(new Color(255, 163, 114));
        oldPassword.setText("Old Password:  ");

        newPassword.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        newPassword.setForeground(new Color(255, 163, 114));
        newPassword.setText("New Password:  ");

        newAgain.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        newAgain.setForeground(new Color(255, 163, 114));
        newAgain.setText("New Password Again:  ");

        oldPassField.setColumns(11);

        newPassField.setColumns(11);

        newAgainField.setColumns(11);

        saveButon.setBackground(new Color(67, 101, 139));
        saveButon.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        saveButon.setForeground(new Color(255, 163, 114));
        saveButon.setText("Save");
        saveButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveButtonActionPerformed();
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(saveButon)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(94, 94, 94)
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(oldPassword, GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(newAgain, GroupLayout.Alignment.TRAILING)))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(newPassword)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(oldPassField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(newPassField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(newAgainField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(oldPassword)
                                        .addComponent(oldPassField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(newPassword)
                                        .addComponent(newPassField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(newAgain)
                                        .addComponent(newAgainField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(saveButon)
                                .addContainerGap())
        );

        getContentPane().add(jPanel1, BorderLayout.CENTER);

        pack();
    }

    private void saveButtonActionPerformed() {
        if (oldPassField.getPassword().toString().equals("") || newPassField.getPassword().toString().equals("") || newAgainField.getPassword().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all fields");
        } else {
            String oldPass = new String(oldPassField.getPassword());
            String newPass = new String(newPassField.getPassword());
            String newAgain = new String(newAgainField.getPassword());
            if (!newPass.equals(newAgain)) {
                JOptionPane.showMessageDialog(null, "New passwords do not match");
            } else {
                Boolean changed = cntr.changeLoginInfo(oldPass,newPass);
                if(changed)
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

            }
        }
    }

    public static void main(String args[]) {
        invokeLater(() -> new ChangePasswordFrame());
    }
}
