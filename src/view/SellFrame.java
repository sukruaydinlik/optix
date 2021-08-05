package view;

import controller.Controller;
import model.Frame;
import model.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SellFrame extends JFrame {

    private JButton saveButton;
    private JButton addFrameButton;
    private JButton addLGlassButton;
    private JButton addLLensButton;
    private JButton addOtherBarcodeBtn;
    private JButton addRGlassButton;
    private JButton addRLensButton;
    private JButton deleteButton;
    private JButton homeButton;
    // private JButton jButton3;
    // private JButton jButton4;

    private JLabel totalLabel;
    private JLabel grandLabel;
    private JLabel discountLabel;
    private JLabel insuranceLabel;
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JLabel ssnLabel;
    private JLabel surnameLabel;

    private JPanel framePropPanel;
    private JPanel glassPropPanel;
    private JPanel jPanel1;
    private JPanel leftPanel;
    private JPanel otherPropPanel;
    private JPanel lensPropPanel;
    private JPanel menuPanel;
    private JPanel tablePanel;

    private JTextField lAXIS;
    private JTextField lBasicCurve;
    private JTextField lCYL;
    private JTextField lColor;
    private JTextField lDiameter;
    private JTextField lGlassBarcode;
    private JTextField lHeight;
    private JTextField lLensBarcode;
    private JTextField lPD;
    private JTextField lSPH;
    private JTextField lSpecialName;
    private JTextField grandTotalField;
    private JTextField insuranceField;
    private JTextField discountField;
    private JTextField frameBarcodeField;
    private JTextField phoneField;
    private JTextField prescDate;
    private JTextField prescNumber;
    private JTextField rAXIS;
    private JTextField rBasicCurve;
    private JTextField rCYL;
    private JTextField rColor;
    private JTextField rDiameter;
    private JTextField rGlassBarcode;
    private JTextField rHeight;
    private JTextField rLensBarcodeField;
    private JTextField rPD;
    private JTextField rSPH;
    private JTextField rSpecialName;
    private JTextField lensPrescDate;
    private JTextField lensPrescNumber;
    private JTextField ssnField;
    private JTextField surnameField;
    private JTextField nameField;
    private JTextField otherBarcodeField;
    private JTextField totalField;

    private JTable frameTable;
    private JTable glassTable;
    private JTable otherTable;
    private JTable lensTable;

    private JSeparator separator;

    private JScrollPane frameScrollPane;
    private JScrollPane glassScrollPane;
    private JScrollPane lensScrollPane;
    private JScrollPane otherScrollPane;

    private JTabbedPane jTabbedPane1;
    private JTabbedPane tabsPane;

    private Controller controller;

    private DefaultTableModel glassTModel;
    private DefaultTableModel frameTModel;
    private DefaultTableModel lensTModel;
    private DefaultTableModel otherTModel;
    private PrescriptionCam prescriptionCam;
    private PrescriptionLens prescriptionLens;

    private double total = 0.00;
    private double grandTotal = 0.00;

    public SellFrame() {
        initComponents();
        setVisible(true);
    }

//    private void setGrandTotal(double gt) {
//        grandTotalField.setText(String.valueOf(gt));
//    }

    private void initComponents() {

        GridBagConstraints gridBagConstraints;
        glassTModel = new DefaultTableModel();
        frameTModel = new DefaultTableModel();
        lensTModel = new DefaultTableModel();
        otherTModel = new DefaultTableModel();

        controller = new Controller();
        jPanel1 = new JPanel();
        menuPanel = new JPanel();
        homeButton = new JButton();
        deleteButton = new JButton();
        // jButton3 = new JButton();
        // jButton4 = new JButton();
        leftPanel = new JPanel();
        saveButton = new JButton();
        ssnLabel = new JLabel();
        ssnField = new JTextField();
        nameField = new JTextField();
        surnameField = new JTextField();
        phoneField = new JTextField();
        nameLabel = new JLabel();
        surnameLabel = new JLabel();
        phoneLabel = new JLabel();
        discountLabel = new JLabel();
        totalLabel = new JLabel();
        grandLabel = new JLabel();
        insuranceField = new JTextField();
        discountField = new JTextField();
        totalField = new JTextField();
        insuranceLabel = new JLabel();
        separator = new JSeparator();
        grandTotalField = new JTextField();
        tablePanel = new JPanel();
        tabsPane = new JTabbedPane();
        glassScrollPane = new JScrollPane();
        glassTable = new JTable();
        frameScrollPane = new JScrollPane();
        frameTable = new JTable();
        lensScrollPane = new JScrollPane();
        lensTable = new JTable();
        otherScrollPane = new JScrollPane();
        otherTable = new JTable();
        jTabbedPane1 = new JTabbedPane();
        glassPropPanel = new JPanel();
        rGlassBarcode = new JTextField();
        rSPH = new JTextField();
        rCYL = new JTextField();
        rAXIS = new JTextField();
        lGlassBarcode = new JTextField();
        lSPH = new JTextField();
        lCYL = new JTextField();
        lAXIS = new JTextField();
        lPD = new JTextField();
        lHeight = new JTextField();
        rPD = new JTextField();
        rHeight = new JTextField();
        prescNumber = new JTextField();
        prescDate = new JTextField();
        addRGlassButton = new JButton();
        addLGlassButton = new JButton();
        framePropPanel = new JPanel();
        frameBarcodeField = new JTextField();
        addFrameButton = new JButton();
        lensPropPanel = new JPanel();
        rLensBarcodeField = new JTextField();
        rBasicCurve = new JTextField();
        rDiameter = new JTextField();
        rColor = new JTextField();
        rSpecialName = new JTextField();
        lLensBarcode = new JTextField();
        lBasicCurve = new JTextField();
        lDiameter = new JTextField();
        lColor = new JTextField();
        lSpecialName = new JTextField();
        lensPrescNumber = new JTextField();
        lensPrescDate = new JTextField();
        addRLensButton = new JButton();
        addLLensButton = new JButton();
        otherPropPanel = new JPanel();
        otherBarcodeField = new JTextField();
        addOtherBarcodeBtn = new JButton();

        // grandTotalField.setEditable(false);
        // totalField.setEditable(false);
        totalField.setFocusable(false);
        grandTotalField.setFocusable(false);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sell");

        jPanel1.setBackground(new Color(78, 137, 174));
        jPanel1.setMinimumSize(new Dimension(1080, 720));
        jPanel1.setPreferredSize(new Dimension(1080, 720));
        jPanel1.setLayout(new java.awt.BorderLayout());

        menuPanel.setBackground(new Color(78, 137, 174));
        menuPanel.setBorder(BorderFactory.createLineBorder(new Color(255, 163, 114), 2));
        menuPanel.setPreferredSize(new Dimension(800, 50));

        homeButton.setBackground(new Color(67, 101, 139));
        homeButton.setForeground(new Color(255, 163, 114));
        homeButton.setText("Main Menu");
        homeButton.setFocusable(false);
        homeButton.addActionListener(this::homeButtonActionPerformed);

        deleteButton.setBackground(new Color(67, 101, 139));
        deleteButton.setForeground(new Color(255, 163, 114));
        deleteButton.setText("Delete");
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this::deleteButtonActionPerformed);

//        jButton3.setBackground(new Color(67, 101, 139));
//        jButton3.setForeground(new Color(255, 163, 114));
//        jButton3.setText("jButton3");
//        jButton3.setFocusable(false);
//        jButton3.addActionListener(this::jButton3ActionPerformed);
//
//        jButton4.setBackground(new Color(67, 101, 139));
//        jButton4.setForeground(new Color(255, 163, 114));
//        jButton4.setText("jButton4");
//        jButton4.setFocusable(false);
//        jButton4.addActionListener(this::jButton4ActionPerformed);

        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(homeButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // .addComponent(jButton3)
                                // .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                //.addComponent(jButton4)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(homeButton)
                                                .addComponent(deleteButton)
                                        // .addComponent(jButton3)
                                        // .addComponent(jButton4))
                                        //    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                )));

        jPanel1.add(menuPanel, BorderLayout.PAGE_START);

        leftPanel.setBackground(new Color(78, 137, 174));
        leftPanel.setPreferredSize(new Dimension(250, 500));
        leftPanel.setLayout(new GridBagLayout());

        saveButton.setBackground(new Color(67, 101, 139));
        saveButton.setForeground(new Color(255, 163, 114));
        saveButton.setText("Save");
        saveButton.addActionListener(this::saveButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(10, 0, 20, 20);
        leftPanel.add(saveButton, gridBagConstraints);

        ssnLabel.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        ssnLabel.setForeground(new Color(255, 163, 114));
        ssnLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        ssnLabel.setText("SSN: ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(ssnLabel, gridBagConstraints);

        ssnField.setColumns(11);
        ssnField.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        ssnField.setForeground(new Color(180, 180, 180));
        ssnField.setHorizontalAlignment(JTextField.LEFT);
        ssnField.setText("SSN");
        ssnField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent evt) {
                ssnField.setText("");
                ssnField.setForeground(new Color(255, 163, 114));
            }

            public void focusLost(FocusEvent evt) {
                ssnFieldFocusLost(evt);
            }
        });
        ssnField.addActionListener(this::ssnFieldActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(ssnField, gridBagConstraints);

        nameField.setColumns(11);
        nameField.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        nameField.setForeground(new Color(180, 180, 180));
        nameField.setHorizontalAlignment(JTextField.LEFT);
        nameField.setText("Name");
        nameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent evt) {
                nameField.setText("");
                nameField.setForeground(new Color(255, 163, 114));
            }

            public void focusLost(FocusEvent evt) {
                nameFieldFocusLost(evt);
            }
        });
        nameField.addActionListener(this::nameFieldActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(nameField, gridBagConstraints);

        surnameField.setColumns(11);
        surnameField.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        surnameField.setForeground(new Color(180, 180, 180));
        surnameField.setHorizontalAlignment(JTextField.LEFT);
        surnameField.setText("Surname");
        surnameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent evt) {
                surnameField.setText("");
                surnameField.setForeground(new Color(255, 163, 114));
            }

            public void focusLost(FocusEvent evt) {
                surnameFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(surnameField, gridBagConstraints);

        phoneField.setColumns(11);
        phoneField.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        phoneField.setForeground(new Color(180, 180, 180));
        phoneField.setHorizontalAlignment(JTextField.LEFT);
        phoneField.setText("Phone");
        phoneField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                phoneField.setText("");
                phoneField.setForeground(new Color(255, 163, 114));
            }

            public void focusLost(FocusEvent evt) {
                phoneFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(phoneField, gridBagConstraints);

        nameLabel.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        nameLabel.setForeground(new Color(255, 163, 114));
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        nameLabel.setText("Name:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(nameLabel, gridBagConstraints);

        surnameLabel.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        surnameLabel.setForeground(new Color(255, 163, 114));
        surnameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        surnameLabel.setText("Surname:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(surnameLabel, gridBagConstraints);

        phoneLabel.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        phoneLabel.setForeground(new Color(255, 163, 114));
        phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        phoneLabel.setText("Phone:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(phoneLabel, gridBagConstraints);

        discountLabel.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        discountLabel.setForeground(new Color(255, 163, 114));
        discountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        discountLabel.setText("Discount:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(discountLabel, gridBagConstraints);

        totalLabel.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        totalLabel.setForeground(new Color(255, 163, 114));
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        totalLabel.setText("Total:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(totalLabel, gridBagConstraints);

        grandLabel.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        grandLabel.setForeground(new Color(255, 163, 114));
        grandLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        grandLabel.setText("Grand Total:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(grandLabel, gridBagConstraints);

        insuranceField.setColumns(11);
        insuranceField.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        insuranceField.setForeground(new Color(180, 180, 180));
        insuranceField.setHorizontalAlignment(JTextField.LEFT);
        insuranceField.setText("Insurance");
        insuranceField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent evt) {
                insuranceField.setText("");
                insuranceField.setForeground(new Color(255, 163, 114));
            }

            @Override
            public void focusLost(FocusEvent evt) {

            }
        });
        insuranceField.addActionListener(evt -> insuranceFieldActionPerformed(evt));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(insuranceField, gridBagConstraints);

        discountField.setColumns(11);
        discountField.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        discountField.setForeground(new Color(180, 180, 180));
        discountField.setHorizontalAlignment(JTextField.LEFT);
        discountField.setText("Discount");
        discountField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent evt) {
                discountField.setText("");
                discountField.setForeground(new Color(255, 163, 114));
            }

            public void focusLost(FocusEvent evt) {
                discountFieldFocusLost(evt);
            }
        });
        discountField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!grandTotalField.getText().equals("") && !grandTotalField.getText().equals("Grand Total")) {
                    try {
                        double str = Double.parseDouble(discountField.getText());
                        double gt = Double.parseDouble(grandTotalField.getText());
                        gt = gt - str;
                        grandTotalField.setText(String.valueOf(gt));
                    } catch (NumberFormatException nfe) {
                        //
                        System.out.println("here");
                    }
                }
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(discountField, gridBagConstraints);

        totalField.setColumns(11);
        totalField.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        totalField.setForeground(new Color(180, 180, 180));
        totalField.setHorizontalAlignment(JTextField.LEFT);
        totalField.setText("Total");
        totalField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent evt) {
                totalField.setText("");
                totalField.setForeground(new Color(255, 163, 114));
            }

            public void focusLost(FocusEvent evt) {
                totalFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(totalField, gridBagConstraints);

        insuranceLabel.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        insuranceLabel.setForeground(new Color(255, 163, 114));
        insuranceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        insuranceLabel.setText("Insurance: ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(insuranceLabel, gridBagConstraints);

        separator.setBackground(new Color(255, 163, 114));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(2, 10, 2, 10);
        leftPanel.add(separator, gridBagConstraints);

        grandTotalField.setColumns(11);
        grandTotalField.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        grandTotalField.setForeground(new Color(180, 180, 180));
        grandTotalField.setText("Grand Total");
        grandTotalField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent evt) {
                grandTotalField.setText("");
                grandTotalField.setForeground(new Color(255, 163, 114));
            }

            public void focusLost(FocusEvent evt) {
                grandTotalFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(grandTotalField, gridBagConstraints);

        jPanel1.add(leftPanel, BorderLayout.LINE_START);

        tablePanel.setBackground(new Color(78, 137, 174));
        tablePanel.setMaximumSize(new Dimension(2147483647, 1000));
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.PAGE_AXIS));

        tabsPane.setBackground(new Color(67, 101, 139));
        tabsPane.setForeground(new Color(255, 163, 114));
        tabsPane.setMaximumSize(new Dimension(32767, 800));
        tabsPane.setPreferredSize(new Dimension(1080, 400));
        tabsPane.addChangeListener(evt -> tabsPaneStateChanged(evt));
        tabsPane.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                tabsPaneFocusGained(evt);
            }
        });

        glassScrollPane.setBackground(new Color(78, 137, 174));
        setColumnNames();
        glassTable.setAutoCreateRowSorter(true);
        glassTable.setBackground(new Color(67, 101, 139));
        glassTable.setForeground(new Color(255, 163, 114));
        glassTable.setModel(glassTModel);
        glassTable.setGridColor(new Color(255, 163, 114));
        glassScrollPane.setViewportView(glassTable);

        tabsPane.addTab("Glass", glassScrollPane);

        frameScrollPane.setBackground(new Color(78, 137, 174));

        frameTable.setBackground(new Color(67, 101, 139));
        frameTable.setForeground(new Color(255, 163, 114));
        frameTable.setModel(frameTModel);
        frameTable.setGridColor(new Color(255, 163, 114));
        frameScrollPane.setViewportView(frameTable);

        tabsPane.addTab("Frame", frameScrollPane);

        lensScrollPane.setBackground(new Color(78, 137, 174));

        lensTable.setBackground(new Color(67, 101, 139));
        lensTable.setForeground(new Color(255, 163, 114));
        lensTable.setModel(lensTModel);
        lensTable.setGridColor(new Color(255, 163, 114));
        lensScrollPane.setViewportView(lensTable);

        tabsPane.addTab("Lens", lensScrollPane);

        otherScrollPane.setBackground(new Color(78, 137, 174));

        otherTable.setBackground(new Color(67, 101, 139));
        otherTable.setForeground(new Color(255, 163, 114));
        otherTable.setModel(otherTModel);
        otherTable.setGridColor(new Color(255, 163, 114));
        otherScrollPane.setViewportView(otherTable);

        tabsPane.addTab("Other", otherScrollPane);

        tablePanel.add(tabsPane);

        jTabbedPane1.setBackground(new Color(67, 101, 139));
        jTabbedPane1.setForeground(new Color(255, 163, 114));
        jTabbedPane1.setMaximumSize(new Dimension(32767, 370));
        jTabbedPane1.setPreferredSize(new Dimension(830, 240));

        glassPropPanel.setBackground(new Color(67, 101, 139));
        glassPropPanel.setLayout(new java.awt.GridBagLayout());

        rGlassBarcode.setForeground(new Color(180, 180, 180));
        rGlassBarcode.setText("Right Glass Barcode");
        rGlassBarcode.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                rGlassBarcode.setText("");
                rGlassBarcode.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(rGlassBarcode, gridBagConstraints);

        rSPH.setForeground(new Color(180, 180, 180));
        rSPH.setText("SPH");
        rSPH.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                rSPH.setText("");
                rSPH.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(rSPH, gridBagConstraints);

        rCYL.setForeground(new Color(180, 180, 180));
        rCYL.setText("CYL");
        rCYL.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                rCYL.setText("");
                rCYL.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(rCYL, gridBagConstraints);

        rAXIS.setForeground(new Color(180, 180, 180));
        rAXIS.setText("AXIS");
        rAXIS.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                rAXIS.setText("");
                rAXIS.setForeground(new Color(255, 163, 114));
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(rAXIS, gridBagConstraints);

        lGlassBarcode.setForeground(new Color(180, 180, 180));
        lGlassBarcode.setText("Left Glass Barcode");
        lGlassBarcode.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lGlassBarcode.setText("");
                lGlassBarcode.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(lGlassBarcode, gridBagConstraints);

        lSPH.setForeground(new Color(180, 180, 180));
        lSPH.setText("SPH");
        lSPH.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lSPH.setText("");
                lSPH.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(lSPH, gridBagConstraints);

        lCYL.setForeground(new Color(180, 180, 180));
        lCYL.setText("CYL");
        lCYL.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lCYL.setText("");
                lCYL.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(lCYL, gridBagConstraints);

        lAXIS.setForeground(new Color(180, 180, 180));
        lAXIS.setText("AXIS");
        lAXIS.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lAXIS.setText("");
                lAXIS.setForeground(new Color(255, 163, 114));
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(lAXIS, gridBagConstraints);

        lPD.setForeground(new Color(180, 180, 180));
        lPD.setText("PD");
        lPD.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lPD.setText("");
                lPD.setForeground(new Color(255, 163, 114));
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(lPD, gridBagConstraints);

        lHeight.setForeground(new Color(180, 180, 180));
        lHeight.setText("Height");
        lHeight.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lHeight.setText("");
                lHeight.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(lHeight, gridBagConstraints);

        rPD.setForeground(new Color(180, 180, 180));
        rPD.setText("PD");
        rPD.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                rPD.setText("");
                rPD.setForeground(new Color(255, 163, 114));
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(rPD, gridBagConstraints);

        rHeight.setForeground(new Color(180, 180, 180));
        rHeight.setText("Height");
        rHeight.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                rHeight.setText("");
                rHeight.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(rHeight, gridBagConstraints);

        prescNumber.setForeground(new Color(180, 180, 180));
        prescNumber.setText("Prescription Number");
        prescNumber.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                prescNumber.setText("");
                prescNumber.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(prescNumber, gridBagConstraints);

        prescDate.setForeground(new Color(180, 180, 180));
        prescDate.setText("Presctiption Date");
        prescDate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                prescDate.setText("");
                prescDate.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(prescDate, gridBagConstraints);

        addRGlassButton.setBackground(new Color(78, 137, 174));
        addRGlassButton.setForeground(new Color(255, 163, 114));
        addRGlassButton.setText("Add Right Glass");
        addRGlassButton.setFocusable(false);
        addRGlassButton.addActionListener(e -> addRGlassButtonActionEvent());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(addRGlassButton, gridBagConstraints);

        addLGlassButton.setBackground(new Color(78, 137, 174));
        addLGlassButton.setForeground(new Color(255, 163, 114));
        addLGlassButton.setText("Add Left Glass");
        addLGlassButton.setFocusable(false);
        addLGlassButton.addActionListener(e -> addLGlassButtonActionEvent(e));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        glassPropPanel.add(addLGlassButton, gridBagConstraints);

        jTabbedPane1.addTab("Glass", glassPropPanel);

        framePropPanel.setBackground(new Color(67, 101, 139));
        framePropPanel.setLayout(new java.awt.GridBagLayout());

        frameBarcodeField.setBackground(new Color(240, 240, 240));
        frameBarcodeField.setColumns(11);
        frameBarcodeField.setForeground(new Color(180, 180, 180));
        frameBarcodeField.setText("Frame Barcode");
        frameBarcodeField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                frameBarcodeField.setText("");
                frameBarcodeField.setForeground(new Color(255, 163, 114));
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        framePropPanel.add(frameBarcodeField, gridBagConstraints);

        addFrameButton.setBackground(new Color(67, 101, 139));
        addFrameButton.setForeground(new Color(255, 163, 114));
        addFrameButton.setText("Add Frame");
        addFrameButton.addActionListener(this::addFrameButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        framePropPanel.add(addFrameButton, gridBagConstraints);

        jTabbedPane1.addTab("Frame", framePropPanel);

        lensPropPanel.setBackground(new Color(67, 101, 139));
        lensPropPanel.setLayout(new GridBagLayout());

        rLensBarcodeField.setBackground(new Color(240, 240, 240));
        rLensBarcodeField.setForeground(new Color(180, 180, 180));
        rLensBarcodeField.setText("Right Lens Barcode");
        rLensBarcodeField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                rLensBarcodeField.setText("");
                rLensBarcodeField.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(rLensBarcodeField, gridBagConstraints);

        rBasicCurve.setBackground(new Color(240, 240, 240));
        rBasicCurve.setForeground(new Color(180, 180, 180));
        rBasicCurve.setText("Basic Curve");
        rBasicCurve.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                rBasicCurve.setText("");
                rBasicCurve.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(rBasicCurve, gridBagConstraints);

        rDiameter.setBackground(new Color(240, 240, 240));
        rDiameter.setForeground(new Color(180, 180, 180));
        rDiameter.setText("Diameter");
        rDiameter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                rDiameter.setText("");
                rDiameter.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(rDiameter, gridBagConstraints);

        rColor.setBackground(new Color(240, 240, 240));
        rColor.setForeground(new Color(180, 180, 180));
        rColor.setText("Color");
        rColor.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                rColor.setText("");
                rColor.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(rColor, gridBagConstraints);

        rSpecialName.setBackground(new Color(240, 240, 240));
        rSpecialName.setForeground(new Color(180, 180, 180));
        rSpecialName.setText("Special Name");
        rSpecialName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                rSpecialName.setText("");
                rSpecialName.setForeground(new Color(255, 163, 114));
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(rSpecialName, gridBagConstraints);

        lLensBarcode.setBackground(new Color(240, 240, 240));
        lLensBarcode.setForeground(new Color(180, 180, 180));
        lLensBarcode.setText("Left Lens Barcode");
        lLensBarcode.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lLensBarcode.setText("");
                lLensBarcode.setForeground(new Color(255, 163, 114));
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(lLensBarcode, gridBagConstraints);

        lBasicCurve.setBackground(new Color(240, 240, 240));
        lBasicCurve.setForeground(new Color(180, 180, 180));
        lBasicCurve.setText("Basic Curve");
        lBasicCurve.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lBasicCurve.setText("");
                lBasicCurve.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(lBasicCurve, gridBagConstraints);

        lDiameter.setBackground(new Color(240, 240, 240));
        lDiameter.setForeground(new Color(180, 180, 180));
        lDiameter.setText("Diameter");
        lDiameter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lDiameter.setText("");
                lDiameter.setForeground(new Color(255, 163, 114));
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(lDiameter, gridBagConstraints);

        lColor.setBackground(new Color(240, 240, 240));
        lColor.setForeground(new Color(180, 180, 180));
        lColor.setText("Color");
        lColor.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lColor.setText("");
                lColor.setForeground(new Color(255, 163, 114));
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(lColor, gridBagConstraints);

        lSpecialName.setBackground(new Color(240, 240, 240));
        lSpecialName.setForeground(new Color(180, 180, 180));
        lSpecialName.setText("Special Name");
        lSpecialName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lSpecialName.setText("");
                lSpecialName.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(lSpecialName, gridBagConstraints);

        lensPrescNumber.setBackground(new Color(240, 240, 240));
        lensPrescNumber.setForeground(new Color(180, 180, 180));
        lensPrescNumber.setText("Prescription Number");
        lensPrescNumber.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lensPrescNumber.setText("");
                lensPrescNumber.setForeground(new Color(255, 163, 114));
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(lensPrescNumber, gridBagConstraints);

        lensPrescDate.setBackground(new Color(240, 240, 240));
        lensPrescDate.setForeground(new Color(180, 180, 180));
        lensPrescDate.setText("Prescription Date");
        lensPrescDate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lensPrescDate.setText("");
                lensPrescDate.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(lensPrescDate, gridBagConstraints);

        addRLensButton.setBackground(new Color(78, 137, 174));
        addRLensButton.setForeground(new Color(255, 163, 114));
        addRLensButton.setText("jButton1");
        addRLensButton.addActionListener(this::addRLensButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(addRLensButton, gridBagConstraints);

        addLLensButton.setBackground(new Color(78, 137, 174));
        addLLensButton.setForeground(new Color(255, 163, 114));
        addLLensButton.setText("jButton5");
        addLLensButton.addActionListener(this::addLLensButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(20, 10, 10, 10);
        lensPropPanel.add(addLLensButton, gridBagConstraints);

        jTabbedPane1.addTab("Lens", lensPropPanel);

        otherPropPanel.setBackground(new Color(67, 101, 139));
        otherPropPanel.setLayout(new GridBagLayout());

        otherBarcodeField.setBackground(new Color(240, 240, 240));
        otherBarcodeField.setColumns(11);
        otherBarcodeField.setForeground(new Color(180, 180, 180));
        otherBarcodeField.setText("Other Barcode");
        otherBarcodeField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                otherBarcodeField.setText("");
                otherBarcodeField.setForeground(new Color(255, 163, 114));

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        otherPropPanel.add(otherBarcodeField, gridBagConstraints);

        addOtherBarcodeBtn.setBackground(new Color(67, 101, 139));
        addOtherBarcodeBtn.setForeground(new Color(255, 163, 114));
        addOtherBarcodeBtn.setText("Add Other");
        addOtherBarcodeBtn.addActionListener(evt -> addOtherBarcodeBtnAction());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        otherPropPanel.add(addOtherBarcodeBtn, gridBagConstraints);

        jTabbedPane1.addTab("Other", otherPropPanel);

        tablePanel.add(jTabbedPane1);

        jPanel1.add(tablePanel, BorderLayout.CENTER);


        getContentPane().add(jPanel1);

        pack();
    }


    private void saveButtonActionPerformed(ActionEvent evt) {

        Customer customer = new Customer(
                ssnField.getText(),
                nameField.getText(),
                surnameField.getText(),
                phoneField.getText());
//        System.out.println(customer);
        ArrayList<String> barcodes = new ArrayList<>();
        for (int i = 0; i < lensTModel.getRowCount(); i++) {
            barcodes.add(lensTModel.getValueAt(i, 1).toString());
        }
        for (int i = 0; i < glassTModel.getRowCount(); i++) {
            barcodes.add(glassTModel.getValueAt(i, 1).toString());
        }
        for (int i = 0; i < frameTModel.getRowCount(); i++) {
            barcodes.add(frameTModel.getValueAt(i, 0).toString());
        }
        for (int i = 0; i < otherTModel.getRowCount(); i++) {
            barcodes.add(otherTModel.getValueAt(i, 0).toString());
        }
        boolean isSold = false;
        try {
            double tot;
            tot = Double.parseDouble(totalField.getText());
            isSold = controller.sell(barcodes, prescriptionCam, prescriptionLens, tot, Double.parseDouble(insuranceField.getText()), 0, 0, Double.parseDouble(discountField.getText()), customer);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Something is wrong. Sale has not been made");

        } finally {
            if (isSold) {
                JOptionPane.showMessageDialog(null, "Sale made!!");
            }

        }
    }


    private void addFrameButtonActionPerformed(ActionEvent e) {
        ArrayList<Frame> frames = controller.findFrames(frameBarcodeField.getText());
        if (!frames.isEmpty()) {
            String[] temp = new String[]{
                    frames.get(0).getBarcode(),
                    String.valueOf(frames.get(0).getAlisFiyati()),
                    String.valueOf(frames.get(0).getSatisFiyati()),
                    frames.get(0).getRenk(),
                    frames.get(0).getMarka(),
                    frames.get(0).getModel(),
                    frames.get(0).getOzelAdi(),
                    frames.get(0).getEkartman(),
            };

            frameTModel.addRow(temp);
            total += frames.get(0).getSatisFiyati(); //update price
            grandTotal += frames.get(0).getSatisFiyati(); //update grand total
            totalField.setText(String.valueOf(total));
            totalField.setForeground(new Color(255,163,114));
            grandTotalField.setText(String.valueOf(grandTotal));
            grandTotalField.setForeground(new Color(255, 163, 114));

        } else {
            JOptionPane.showMessageDialog(null, "Couldn't find any item with provided barcode");
        }
    }

    private void homeButtonActionPerformed(ActionEvent evt) {
        super.dispose();
    }

    private void deleteButtonActionPerformed(ActionEvent evt) {

        glassTModel.setRowCount(0);
        prescriptionCam = null;
        frameTModel.setRowCount(0);
        lensTModel.setRowCount(0);
        prescriptionLens = null;
        otherTModel.setRowCount(0);
        totalField.setText("0");
        grandTotalField.setText("0");

    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

    }


    private void ssnFieldFocusLost(FocusEvent evt) {
        // TODO add your handling code here:

    }

    private void ssnFieldActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void nameFieldFocusLost(FocusEvent evt) {
        // TODO add your handling code here:

    }

    private void nameFieldActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

    }


    private void surnameFieldFocusLost(FocusEvent evt) {
        // TODO add your handling code here:

    }


    private void phoneFieldFocusLost(FocusEvent evt) {
        // TODO add your handling code here:

    }


    private void insuranceFieldActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void discountFieldFocusLost(FocusEvent evt) {
        // TODO add your handling code here:

    }


    private void totalFieldFocusLost(FocusEvent evt) {
        // TODO add your handling code here:
    }


    private void grandTotalFieldFocusLost(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void tabsPaneStateChanged(ChangeEvent evt) {
        // TODO add your handling code here:
    }

    private void tabsPaneFocusGained(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void addRLensButtonActionPerformed(ActionEvent evt) {
        ArrayList<ContactLens> lens = controller.findLens(rLensBarcodeField.getText());

        if (lens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Couldn't find any lens with provided barcode");
        } else {
            String[] temp = new String[]{"Right", lens.get(0).getBarcode(), lens.get(0).getDiyoptri(), lens.get(0).getAks(), lens.get(0).getSilindirik(), String.valueOf(lens.get(0).getAlisFiyati()), String.valueOf(lens.get(0).getSatisFiyati())};

            lensTModel.addRow(temp);
            total += lens.get(0).getSatisFiyati(); //update price
            grandTotal += lens.get(0).getSatisFiyati(); //update grand total
            totalField.setText(String.valueOf(total));
            totalField.setForeground(new Color(255,163,114));
            grandTotalField.setText(String.valueOf(grandTotal));
            grandTotalField.setForeground(new Color(255, 163, 114));

            if (prescriptionLens == null) {
                prescriptionLens = new PrescriptionLens(
                        lensPrescNumber.getText(),
                        lensPrescDate.getText(),
                        temp[1],
                        rBasicCurve.getText(),
                        rDiameter.getText(),
                        rColor.getText(),
                        rSpecialName.getText(),
                        "",
                        "",
                        "",
                        "",
                        ""
                );
            } else {
                prescriptionLens.setRlBarcode(temp[1]);
                prescriptionLens.setRlTemelEgri(rBasicCurve.getText());
                prescriptionLens.setRlTumCap(rDiameter.getText());
                prescriptionLens.setRlRenk(rColor.getText());
                prescriptionLens.setRlOzelAd(rSpecialName.getText());
            }
            //System.out.println(prescriptionLens.toString());
            lens.clear();

        }
    }

    private void addLLensButtonActionPerformed(ActionEvent evt) {
        ArrayList<ContactLens> lens = controller.findLens(lLensBarcode.getText());

        if (lens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Couldn't find any lens with provided barcode");
        } else {
            String[] temp = new String[]{"left", lens.get(0).getBarcode(), lens.get(0).getDiyoptri(), lens.get(0).getAks(), lens.get(0).getSilindirik(), String.valueOf(lens.get(0).getAlisFiyati()), String.valueOf(lens.get(0).getSatisFiyati())};

            lensTModel.addRow(temp);
            total += lens.get(0).getSatisFiyati(); //update price
            grandTotal += lens.get(0).getSatisFiyati(); //update grand total
            totalField.setText(String.valueOf(total));
            totalField.setForeground(new Color(255,163,114));
            grandTotalField.setText(String.valueOf(grandTotal));
            grandTotalField.setForeground(new Color(255, 163, 114));

            if (prescriptionLens == null) {
                prescriptionLens = new PrescriptionLens(
                        lensPrescNumber.getText(),
                        lensPrescDate.getText(),
                        "",
                        "",
                        "",
                        "",
                        "",
                        temp[1],
                        lBasicCurve.getText(),
                        lDiameter.getText(),
                        lColor.getText(),
                        lSpecialName.getText()
                );
            } else {
                prescriptionLens.setLlBarcode(temp[1]);
                prescriptionLens.setLlTemelEgri(rBasicCurve.getText());
                prescriptionLens.setLlTumCap(rDiameter.getText());
                prescriptionLens.setLlRenk(rColor.getText());
                prescriptionLens.setLlOzelAd(rSpecialName.getText());
            }
            //System.out.println(prescriptionLens.toString());
            lens.clear();
        }

    }

    private void addRGlassButtonActionEvent() {
        ArrayList<Glass> glasses = controller.findGlasses(rGlassBarcode.getText());
        if (glasses.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Couldn't find any lens with provided barcode");
        } else {
            String[] temp = new String[]{"right", glasses.get(0).getBarcode(), String.valueOf(glasses.get(0).getAlisFiyati()), String.valueOf(glasses.get(0).getSatisFiyati()), glasses.get(0).getTur(), glasses.get(0).getMarka(), glasses.get(0).getindeks()};
            glassTModel.addRow(temp);
            total += glasses.get(0).getSatisFiyati(); //update price
            grandTotal += glasses.get(0).getSatisFiyati(); //update grand total
            totalField.setText(String.valueOf(total));
            totalField.setForeground(new Color(255,163,114));
            grandTotalField.setText(String.valueOf(grandTotal));
            grandTotalField.setForeground(new Color(255, 163, 114));
            if (prescriptionCam == null) {
                prescriptionCam = new PrescriptionCam(
                        prescNumber.getText(),
                        prescDate.getText(),
                        rGlassBarcode.getText(),
                        rSPH.getText(),
                        rCYL.getText(),
                        rAXIS.getText(),
                        rPD.getText(),
                        rHeight.getText(),
                        "",
                        "",
                        "",
                        "",
                        "",
                        ""
                );
            } else {
                prescriptionCam.setRcAx(rAXIS.getText());
                prescriptionCam.setRcBarcode(rGlassBarcode.getText());
                prescriptionCam.setRcCyl(rCYL.getText());
                prescriptionCam.setRcPd(rPD.getText());
                prescriptionCam.setRcSph(rSPH.getText());
                prescriptionCam.setRcYukseklik(rHeight.getText());
            }

        }
    }

    private void addLGlassButtonActionEvent(ActionEvent e) {
        ArrayList<Glass> glasses = controller.findGlasses(rGlassBarcode.getText());
        if (glasses.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Couldn't find any lens with provided barcode");
        } else {
            String[] temp = new String[]{"left", glasses.get(0).getBarcode(), String.valueOf(glasses.get(0).getAlisFiyati()), String.valueOf(glasses.get(0).getSatisFiyati()), glasses.get(0).getTur(), glasses.get(0).getMarka(), glasses.get(0).getindeks()};
            glassTModel.addRow(temp);
            total += glasses.get(0).getSatisFiyati(); //update price
            grandTotal += glasses.get(0).getSatisFiyati(); //update grand total
            totalField.setText(String.valueOf(total));
            totalField.setForeground(new Color(255,163,114));
            grandTotalField.setText(String.valueOf(grandTotal));
            grandTotalField.setForeground(new Color(255, 163, 114));

            if (prescriptionCam == null) {
                prescriptionCam = new PrescriptionCam(
                        prescNumber.getText(),
                        prescDate.getText(),
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        lGlassBarcode.getText(),
                        lSPH.getText(),
                        lCYL.getText(),
                        lAXIS.getText(),
                        lPD.getText(),
                        lHeight.getText()
                );
            } else {
                prescriptionCam.setLcAx(lAXIS.getText());
                prescriptionCam.setLcBarcode(lGlassBarcode.getText());
                prescriptionCam.setLcCyl(lCYL.getText());
                prescriptionCam.setLcPd(lPD.getText());
                prescriptionCam.setLcSph(lSPH.getText());
                prescriptionCam.setLcYukseklik(lHeight.getText());
            }
        }
    }

    private void addOtherBarcodeBtnAction() {
        ArrayList<Special> specials = controller.findSpecials(otherBarcodeField.getText());

        if (specials.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Couldn't find any item with proviced barcode");
        } else {
            String[] temp = new String[]{specials.get(0).getBarcode(), String.valueOf(specials.get(0).getAlisFiyati()), String.valueOf(specials.get(0).getSatisFiyati())};
            otherTModel.addRow(temp);
            total += specials.get(0).getSatisFiyati(); //update price
            grandTotal += specials.get(0).getSatisFiyati(); //update grand total
            totalField.setText(String.valueOf(total));
            totalField.setForeground(new Color(255,163,114));
            grandTotalField.setText(String.valueOf(grandTotal));
            grandTotalField.setForeground(new Color(255, 163, 114));

        }
    }

    public void setColumnNames() {

        String[] glassAttributes = new String[]{"right/left", "barcode", "purchase price", "sell price", "type", "brand", "index"};
        glassTModel.setColumnIdentifiers(glassAttributes);

        String[] frameAttributes = new String[]{"barcode", "purchase price", "sell price", "color", "brand", "model", "special name", "size"};
        frameTModel.setColumnIdentifiers(frameAttributes);

        String[] lensAttributes = new String[]{"right/left", "barcode", "dioptri", "ax", "cylindrical", "purchase price", "sell price"};
        lensTModel.setColumnIdentifiers(lensAttributes);

        String[] otherAttributes = new String[]{"barcode", "purchase price", "sell price"};
        otherTModel.setColumnIdentifiers(otherAttributes);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> new SellFrame().setVisible(true));
    }
}
