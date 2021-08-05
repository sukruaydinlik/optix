package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

    private JPanel MainPane;
    private JButton changePasswordButton;
    private JButton checkPriceButton;
    private JButton customerButton;
    private JButton exitButton;
    private JButton historyButton;
    private JButton inventoryButton;
    private JButton sellButton;
    private JButton statisticsButton;
    private JMenuItem aboutMenuItem;
    private JMenuItem exitMenuItem;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JLabel logoLabel;
    private JMenuBar menuBar;
    private JSeparator separator;

    public MainFrame() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        MainPane = new JPanel();
        customerButton = new JButton();
        historyButton = new JButton();
        statisticsButton = new JButton();
        sellButton = new JButton();
        inventoryButton = new JButton();
        checkPriceButton = new JButton();
        logoLabel = new javax.swing.JLabel();
        changePasswordButton = new JButton();
        exitButton = new JButton();
        separator = new JSeparator();
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        exitMenuItem = new JMenuItem();
        helpMenu = new JMenu();
        aboutMenuItem = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1280, 720));
        setSize(new Dimension(1280, 720));
        setTitle("OptiX");

        MainPane.setBackground(new Color(78, 137, 174));
        MainPane.setForeground(new Color(240, 240, 240));
        MainPane.setPreferredSize(new Dimension(800, 600));
        MainPane.setLayout(new GridBagLayout());

        customerButton.setPreferredSize(new Dimension(350, 250));
        customerButton.setBackground(new Color(67, 101, 139));
        customerButton.setFont(new Font("Bahnschrift", 0, 36)); // NOI18N
        customerButton.setForeground(new Color(255, 163, 114));
        customerButton.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_business_building_100px_2.png"))); // NOI18N
        customerButton.setText("Customers");
        customerButton.setMaximumSize(new Dimension(333, 109));
        customerButton.setMinimumSize(new Dimension(333, 109));
        customerButton.setPreferredSize(new Dimension(333, 109));
        customerButton.addActionListener(evt -> customerButtonActionPerformed(evt));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        MainPane.add(customerButton, gridBagConstraints);

        historyButton.setBackground(new Color(67, 101, 139));
        historyButton.setFont(new Font("Bahnschrift", 0, 36)); // NOI18N
        historyButton.setForeground(new Color(255, 163, 114));
        historyButton.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_activity_history_100px_2.png"))); // NOI18N
        historyButton.setText("Sale History");
        historyButton.addActionListener(evt -> historyButtonActionPerformed(evt));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        MainPane.add(historyButton, gridBagConstraints);

        statisticsButton.setPreferredSize(new Dimension(350, 250));
        statisticsButton.setBackground(new Color(67, 101, 139));
        statisticsButton.setFont(new Font("Bahnschrift", 0, 36)); // NOI18N
        statisticsButton.setForeground(new Color(255, 163, 114));
        statisticsButton.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_statistics_100px_2.png"))); // NOI18N
        statisticsButton.setText("Statistics");
        statisticsButton.setMaximumSize(new Dimension(333, 109));
        statisticsButton.setMinimumSize(new Dimension(333, 109));
        statisticsButton.setPreferredSize(new Dimension(333, 109));
        statisticsButton.addActionListener(evt -> statisticsButtonActionPerformed(evt));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        MainPane.add(statisticsButton, gridBagConstraints);

        sellButton.setPreferredSize(new Dimension(350, 250));
        sellButton.setBackground(new Color(67, 101, 139));
        sellButton.setFont(new Font("Bahnschrift", 0, 36)); // NOI18N
        sellButton.setForeground(new Color(255, 163, 114));
        sellButton.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_sell_100px_4.png"))); // NOI18N
        sellButton.setText("Sell");
        sellButton.setMaximumSize(new Dimension(333, 109));
        sellButton.setMinimumSize(new Dimension(333, 109));
        sellButton.setPreferredSize(new Dimension(333, 109));
        sellButton.addActionListener(evt -> sellButtonActionPerformed(evt));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        MainPane.add(sellButton, gridBagConstraints);

        inventoryButton.setPreferredSize(new Dimension(350, 250));
        inventoryButton.setBackground(new Color(67, 101, 139));
        inventoryButton.setFont(new Font("Bahnschrift", 0, 36)); // NOI18N
        inventoryButton.setForeground(new Color(255, 163, 114));
        inventoryButton.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_inventory_flow_100px_2.png"))); // NOI18N
        inventoryButton.setText("Inventory");
        inventoryButton.setMaximumSize(new Dimension(333, 109));
        inventoryButton.setMinimumSize(new Dimension(333, 109));
        inventoryButton.setPreferredSize(new Dimension(333, 109));
        inventoryButton.addActionListener(evt -> inventoryButtonActionPerformed(evt));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        MainPane.add(inventoryButton, gridBagConstraints);

        checkPriceButton.setPreferredSize(new Dimension(350, 250));
        checkPriceButton.setBackground(new Color(67, 101, 139));
        checkPriceButton.setFont(new Font("Bahnschrift", 0, 36)); // NOI18N
        checkPriceButton.setForeground(new Color(255, 163, 114));
        checkPriceButton.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_price_100px_3.png"))); // NOI18N
        checkPriceButton.setText("Check Price");
        checkPriceButton.setToolTipText("");
        checkPriceButton.setMaximumSize(new Dimension(333, 109));
        checkPriceButton.setMinimumSize(new Dimension(333, 109));
        checkPriceButton.setPreferredSize(new Dimension(333, 109));
        checkPriceButton.addActionListener(evt -> checkPriceButtonActionPerformed(evt));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        MainPane.add(checkPriceButton, gridBagConstraints);

        logoLabel.setFont(new Font("Tahoma", 0, 80));
        logoLabel.setForeground(new Color(240, 240, 240));
        logoLabel.setText("OptiX");

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        MainPane.add(logoLabel, gridBagConstraints);

        changePasswordButton.setPreferredSize(new Dimension(200, 40));
        changePasswordButton.setBackground(new Color(67, 101, 139));
        changePasswordButton.setFont(new Font("Bahnschrift", 0, 14)); // NOI18N
        changePasswordButton.setForeground(new Color(255, 163, 114));
        changePasswordButton.setText("Change Password");
        changePasswordButton.addActionListener(evt -> changePasswordButtonActionPerformed(evt));
        MainPane.add(changePasswordButton, new GridBagConstraints());

        exitButton.setPreferredSize(new Dimension(170, 30));
        exitButton.setBackground(new Color(67, 101, 139));
        exitButton.setFont(new Font("Bahnschrift", 0, 14)); // NOI18N
        exitButton.setForeground(new Color(255, 163, 114));
        exitButton.setText("Exit");
        exitButton.addActionListener(evt -> exitButtonActionPerformed(evt));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.LAST_LINE_END;
        gridBagConstraints.insets = new Insets(0, 0, 50, 50);
        MainPane.add(exitButton, gridBagConstraints);

        separator.setBackground(new Color(255, 163, 114));
        separator.setForeground(new Color(255, 163, 114));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(20, 20, 20, 20);
        MainPane.add(separator, gridBagConstraints);

        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(evt -> exitMenuItemActionPerformed(evt));
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(evt -> aboutMenuItemActionPerformed(evt));
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(MainPane, GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(MainPane, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        pack();
    }

    private void aboutMenuItemActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void sellButtonActionPerformed(ActionEvent evt) {
        new SellFrame();
    }

    private void checkPriceButtonActionPerformed(ActionEvent evt) {
        new CheckPrcFrame();
    }

    private void inventoryButtonActionPerformed(ActionEvent evt) {
        new InventoryFrame();
    }

    private void statisticsButtonActionPerformed(ActionEvent evt) {
        new StatisticsFrame();
    }

    private void historyButtonActionPerformed(ActionEvent evt) {
        new SaleHistoryFrame();
    }

    private void customerButtonActionPerformed(ActionEvent evt) {
        new CustomerFrame();
    }

    private void exitButtonActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void changePasswordButtonActionPerformed(ActionEvent evt) {
        new ChangePasswordFrame();
    }

    private void exitMenuItemActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

}