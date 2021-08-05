package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class CustomerFrame extends JFrame {

    private JButton clearButton;
    private JPanel jPanel1;
    private JButton mainMenuButton;
    private JScrollPane priceScrollPane1;
    private JTable priceTable1;
    private JTextField searchField;
    private DefaultTableModel dtm;

    public CustomerFrame() {
        initComponents();
        setTitle("Check Price");
        setVisible(true);
    }

    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        dtm = new DefaultTableModel();
        jPanel1 = new JPanel();
        priceScrollPane1 = new JScrollPane();
        priceTable1 = new JTable();
        mainMenuButton = new JButton();
        clearButton = new JButton();
        searchField = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        String[] colNames = new String[]{"Name", "Surname", "SSN", "Phone"};
        dtm.setColumnIdentifiers(colNames);

        jPanel1.setBackground(new Color(78, 137, 174));
        jPanel1.setPreferredSize(new Dimension(1280, 720));
        jPanel1.setLayout(new GridBagLayout());

        priceTable1.setBackground(new Color(67, 101, 139));
        priceTable1.setForeground(new Color(255, 163, 114));
        priceTable1.setModel(dtm);
        priceTable1.setGridColor(new Color(255, 163, 114));
        priceScrollPane1.setViewportView(priceTable1);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(0, 10, 10, 10);
        jPanel1.add(priceScrollPane1, gridBagConstraints);

        mainMenuButton.setBackground(new Color(67, 101, 139));
        mainMenuButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        mainMenuButton.setForeground(new Color(255, 163, 114));
        mainMenuButton.setText("MainFrame");
        mainMenuButton.addActionListener(evt -> mainMenuButtonActionPerformed(evt));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        jPanel1.add(mainMenuButton, gridBagConstraints);

        clearButton.setBackground(new Color(67, 101, 139));
        clearButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        clearButton.setForeground(new Color(255, 163, 114));
        clearButton.setText("Clear");
        clearButton.addActionListener(evt -> clearButtonActionPerformed(evt));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        jPanel1.add(clearButton, gridBagConstraints);

        searchField.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        searchField.setForeground(new Color(180, 180, 180));
        searchField.setText(" Search...");
        searchField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
        });
        searchField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        jPanel1.add(searchField, gridBagConstraints);

        getContentPane().add(jPanel1, BorderLayout.CENTER);

        pack();
    }

    private void mainMenuButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        super.dispose();
    }

    private void clearButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void searchFieldFocusGained(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void searchFieldKeyTyped(KeyEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerFrame().setVisible(true);
            }
        });
    }
}
