package view;

import controller.Controller;
import model.ContactLens;
import model.Frame;
import model.Glass;
import model.Special;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CheckPrcFrame extends javax.swing.JFrame {

    private JScrollPane addFrameScrollPane;
    private JTable frameTable;
    private JScrollPane addGlassScrollPane8;
    private JTable glassTable;
    private JScrollPane addLensScrollPane;
    private JTable lensTable;
    private JScrollPane addOtherScrollPane;
    private JTable otherTable;
    private JTabbedPane tabbedPane;
    private JButton clearButton;
    private JPanel jPanel2;
    private JButton mainMenuButton;
    private JTextField searchField;

    private DefaultTableModel glassModel;
    private DefaultTableModel frameModel;
    private DefaultTableModel lensModel;
    private DefaultTableModel otherModel;
    private Controller controller;
    private TableRowSorter<TableModel> glassRowSorter;
    private TableRowSorter<TableModel> frameRowSorter;
    private TableRowSorter<TableModel> lensRowSorter;
    private TableRowSorter<TableModel> otherRowSorter;

    public CheckPrcFrame() {
        initComponents();
        setTitle("Check Price");
        setVisible(true);
    }

    private void setSearchFunction() {
        glassRowSorter = new TableRowSorter<>(glassTable.getModel());
        frameRowSorter = new TableRowSorter<>(frameTable.getModel());
        lensRowSorter = new TableRowSorter<>(lensTable.getModel());
        otherRowSorter = new TableRowSorter<>(otherTable.getModel());

        glassTable.setRowSorter(glassRowSorter);
        frameTable.setRowSorter(frameRowSorter);
        lensTable.setRowSorter(lensRowSorter);
        otherTable.setRowSorter(otherRowSorter);
    }

    private void setTableColumns() {

        String[] glassAttributes = new String[]{"barcode", "sell price", "type",
                "brand", "index", "quantity"};
        String[] frameAttributes = new String[]{"barcode", "sell price", "color", "brand",
                "model", "special name", "ekartman", "quantity"};
        String[] lensAttributes = new String[]{"barcode", "dioptri", "ax", "cylindrical",
                "sell price", "quantity"};
        String[] otherAttributes = new String[]{"barcode", "sell price", "quantity"};

        glassModel.setColumnIdentifiers(glassAttributes);
        frameModel.setColumnIdentifiers(frameAttributes);
        lensModel.setColumnIdentifiers(lensAttributes);
        otherModel.setColumnIdentifiers(otherAttributes);
    }

    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        controller = new Controller();


        glassModel = new DefaultTableModel();
        frameModel = new DefaultTableModel();
        lensModel = new DefaultTableModel();
        otherModel = new DefaultTableModel();

        jPanel2 = new JPanel();
        searchField = new JTextField();
        mainMenuButton = new JButton();
        clearButton = new JButton();
        tabbedPane = new JTabbedPane();
        addGlassScrollPane8 = new JScrollPane();
        glassTable = new JTable();
        addFrameScrollPane = new JScrollPane();
        frameTable = new JTable();
        addLensScrollPane = new JScrollPane();
        lensTable = new JTable();
        addOtherScrollPane = new JScrollPane();
        otherTable = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTableColumns();


        tabbedPane.setForeground(new Color(255, 163, 114));
        tabbedPane.setBackground(new Color(67, 101, 139));

        jPanel2.setBackground(new Color(78, 137, 174));
        jPanel2.setToolTipText("");
        jPanel2.setMinimumSize(new Dimension(1280, 720));
        jPanel2.setPreferredSize(new Dimension(1280, 720));
        jPanel2.setLayout(new GridBagLayout());

        searchField.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        searchField.setForeground(new Color(180, 180, 180));
        searchField.setText(" Search...");
        searchField.setSelectedTextColor(new Color(255, 163, 114));
        searchField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                searchFieldFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                searchFieldFocusLost(evt);
            }
        });
        searchField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                sortTable();
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        jPanel2.add(searchField, gridBagConstraints);

        mainMenuButton.setBackground(new Color(67, 101, 139));
        mainMenuButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        mainMenuButton.setForeground(new Color(255, 163, 114));
        mainMenuButton.setText("Main Menu");
        mainMenuButton.setFocusable(false);
        mainMenuButton.addActionListener(evt -> mainMenuButtonActionPerformed(evt));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 5);
        jPanel2.add(mainMenuButton, gridBagConstraints);

        clearButton.setBackground(new Color(67, 101, 139));
        clearButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        clearButton.setForeground(new Color(255, 163, 114));
        clearButton.setText("Clear");
        clearButton.setFocusable(false);
        clearButton.addActionListener(evt -> clearButtonActionPerformed(evt));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 0, 10, 10);
        jPanel2.add(clearButton, gridBagConstraints);

        glassTable.setBackground(new Color(67, 101, 139));
        glassTable.setForeground(new Color(255, 163, 114));
        glassTable.setGridColor(new Color(255, 163, 114));
        glassTable.setModel(glassModel);
        glassTable.setFont(new Font("Tahoma", 0, 14));
        addGlassScrollPane8.setViewportView(glassTable);

        tabbedPane.addTab("Glass", addGlassScrollPane8);

        frameTable.setBackground(new Color(67, 101, 139));
        frameTable.setForeground(new Color(255, 163, 114));
        frameTable.setModel(frameModel);
        frameTable.setFont(new Font("Tahoma", 0, 14));
        frameTable.setGridColor(new Color(255, 163, 114));
        addFrameScrollPane.setViewportView(frameTable);

        tabbedPane.addTab("Frame", addFrameScrollPane);

        lensTable.setBackground(new Color(67, 101, 139));
        lensTable.setForeground(new Color(255, 163, 114));
        lensTable.setModel(lensModel);
        lensTable.setFont(new Font("Tahoma", 0, 14));
        lensTable.setGridColor(new Color(255, 163, 114));
        addLensScrollPane.setViewportView(lensTable);

        tabbedPane.addTab("Lens", addLensScrollPane);

        otherTable.setBackground(new Color(67, 101, 139));
        otherTable.setForeground(new Color(255, 163, 114));
        otherTable.setModel(otherModel);
        otherTable.setFont(new Font("Tahoma", 0, 14));
        otherTable.setGridColor(new Color(255, 163, 114));
        addOtherScrollPane.setViewportView(otherTable);

        tabbedPane.addTab("Other", addOtherScrollPane);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        jPanel2.add(tabbedPane, gridBagConstraints);
        setSearchFunction();
        getContentPane().add(jPanel2, BorderLayout.CENTER);
        fillLowerTable();
        mainMenuButton.setFocusable(true);
        mainMenuButton.setFocusPainted(false);
        mainMenuButton.requestFocus();

        pack();
    }
    private void sortTable() {
        String text = searchField.getText();
        if (text.trim().length() == 0) {
            glassRowSorter.setRowFilter(null);
            frameRowSorter.setRowFilter(null);
            lensRowSorter.setRowFilter(null);
            otherRowSorter.setRowFilter(null);
        }else {
            glassRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            frameRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            lensRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            otherRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));

        }

        fillLowerTable();
    }
    private void fillLowerTable() {
        glassModel.setRowCount(0);
        frameModel.setRowCount(0);
        lensModel.setRowCount(0);
        otherModel.setRowCount(0);

        ArrayList<Glass> glasses = controller.getGlasses();
        ArrayList<Frame> frames = controller.getFrames();
        ArrayList<ContactLens> lenses = controller.getContactLenses();
        ArrayList<Special> others = controller.getSpecials();

        for (Glass glass : glasses) {
            glassModel.addRow(new String[]{
                    glass.getBarcode(),
                    String.valueOf(glass.getSatisFiyati()),
                    glass.getTur(),
                    glass.getMarka(),
                    glass.getindeks(),
                    String.valueOf(glass.getQuantity())
            });
        }
        for (Frame frame : frames) {
            frameModel.addRow(new String[]{
                    frame.getBarcode(),
                    String.valueOf(frame.getSatisFiyati()),
                    frame.getRenk(),
                    frame.getMarka(),
                    frame.getModel(),
                    frame.getOzelAdi(),
                    frame.getEkartman(),
                    String.valueOf(frame.getQuantity())
            });
        }
        for (ContactLens lens : lenses) {
            lensModel.addRow(new String[]{
                    lens.getBarcode(),
                    lens.getDiyoptri(),
                    lens.getAks(),
                    lens.getSilindirik(),
                    String.valueOf(lens.getSatisFiyati()),
                    String.valueOf(lens.getQuantity())
            });
        }
        for (Special other : others) {
            otherModel.addRow(new String[]{
                    other.getBarcode(),
                    String.valueOf(other.getSatisFiyati()),
                    String.valueOf(other.getQuantity())
            });
        }
    }

    private void searchFieldFocusGained(FocusEvent evt) {
        searchField.setForeground(new Color(255, 163, 114));
        searchField.setText("");
    }

    private void searchFieldFocusLost(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void mainMenuButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void clearButtonActionPerformed(ActionEvent evt) {
        searchField.setText(" Search...");
        searchField.setForeground(new Color(180, 180, 180));

    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new CheckPrcFrame().setVisible(true));
    }

}
