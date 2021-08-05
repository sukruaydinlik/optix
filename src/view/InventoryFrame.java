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

public class InventoryFrame extends JFrame {

    private JScrollPane stockFrameScrollPane;
    private JTable stockFrameTable;
    private JScrollPane addGlassScrollPane8;
    private JTable stockGlassTable;
    private JScrollPane stockLensScrollPane;
    private JTable stockLensTable;
    private JScrollPane stockOtherScrollPane;
    private JTable stockOtherTable;
    private JScrollPane frameScrollPane;
    private JTable frameTable;
    private JScrollPane glassScrollPane;
    private JTable glassTable;
    private JScrollPane lensScrollPane;
    private JTable lensTable;
    private JScrollPane otherScrollPane;
    private JTable otherTable;

    private JButton menuButton;
    private JButton removeButton;
    private JButton saveButton;
    private JButton removeStockButton;
    private JButton addRowButton;
    private JPanel jPanel1;

    private JTextField searchField;

    private JTabbedPane stockTabbedPane;
    private JTabbedPane addTabbedPane;

    private DefaultTableModel lowerGlassModel;
    private DefaultTableModel upperGlassModel;
    private DefaultTableModel lowerFrameModel;
    private DefaultTableModel upperFrameModel;
    private DefaultTableModel lowerLensModel;
    private DefaultTableModel upperLensModel;
    private DefaultTableModel lowerOtherModel;
    private DefaultTableModel upperOtherModel;
    private Controller controller;
    private TableRowSorter<TableModel> glassRowSorter;
    private TableRowSorter<TableModel> frameRowSorter;
    private TableRowSorter<TableModel> lensRowSorter;
    private TableRowSorter<TableModel> otherRowSorter;


    public InventoryFrame() {
        initComponents();
        setTableColumns();
        fillLowerTable();
        setVisible(true);

    }

    private void fillLowerTable() {

        lowerGlassModel.setRowCount(0);
        lowerFrameModel.setRowCount(0);
        lowerLensModel.setRowCount(0);
        lowerOtherModel.setRowCount(0);

        ArrayList<Glass> glasses = controller.getGlasses();
        ArrayList<Frame> frames = controller.getFrames();
        ArrayList<ContactLens> lenses = controller.getContactLenses();
        ArrayList<Special> others = controller.getSpecials();

        for (Glass glass : glasses) {
            lowerGlassModel.addRow(new String[]{
                    glass.getBarcode(),
                    String.valueOf(glass.getAlisFiyati()),
                    String.valueOf(glass.getSatisFiyati()),
                    glass.getTur(),
                    glass.getMarka(),
                    glass.getindeks(),
                    String.valueOf(glass.getQuantity())
            });
        }
        for (Frame frame : frames) {
            lowerFrameModel.addRow(new String[]{
                    frame.getBarcode(),
                    String.valueOf(frame.getAlisFiyati()),
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
            lowerLensModel.addRow(new String[]{
                    lens.getBarcode(),
                    lens.getDiyoptri(),
                    lens.getAks(),
                    lens.getSilindirik(),
                    String.valueOf(lens.getAlisFiyati()),
                    String.valueOf(lens.getSatisFiyati()),
                    String.valueOf(lens.getQuantity())
            });
        }
        for (Special other : others) {
            lowerOtherModel.addRow(new String[]{
                    other.getBarcode(),
                    String.valueOf(other.getAlisFiyati()),
                    String.valueOf(other.getSatisFiyati()),
                    String.valueOf(other.getQuantity())
            });
        }
    }

    private void setTableColumns() {

        String[] glassAttributes = new String[]{"barcode", "purchase price", "sell price", "type",
                "brand", "index", "quantity"};
        String[] frameAttributes = new String[]{"barcode", "purchase price", "sell price", "color", "brand",
                "model", "special name", "ekartman", "quantity"};
        String[] lensAttributes = new String[]{"barcode", "dioptri", "ax", "cylindrical",
                "purchase price", "sell price", "quantity"};
        String[] otherAttributes = new String[]{"barcode", "purchase price", "sell price", "quantity"};

        lowerGlassModel.setColumnIdentifiers(glassAttributes);
        upperGlassModel.setColumnIdentifiers(glassAttributes);
        lowerFrameModel.setColumnIdentifiers(frameAttributes);
        upperFrameModel.setColumnIdentifiers(frameAttributes);
        lowerLensModel.setColumnIdentifiers(lensAttributes);
        upperLensModel.setColumnIdentifiers(lensAttributes);
        lowerOtherModel.setColumnIdentifiers(otherAttributes);
        upperOtherModel.setColumnIdentifiers(otherAttributes);
    }

    private void initComponents() {
        GridBagConstraints gridBagConstraints;
        controller = new Controller();


        lowerGlassModel = new DefaultTableModel();
        lowerFrameModel = new DefaultTableModel();
        lowerLensModel = new DefaultTableModel();
        lowerOtherModel = new DefaultTableModel();

        upperGlassModel = new DefaultTableModel();
        upperFrameModel = new DefaultTableModel();
        upperLensModel = new DefaultTableModel();
        upperOtherModel = new DefaultTableModel();

        jPanel1 = new JPanel();
        menuButton = new JButton();
        saveButton = new JButton();
        removeButton = new JButton();
        removeStockButton = new JButton();
        addRowButton = new JButton();
        searchField = new JTextField();
        addTabbedPane = new JTabbedPane();
        glassScrollPane = new JScrollPane();
        glassTable = new JTable();
        frameScrollPane = new JScrollPane();
        frameTable = new JTable();
        lensScrollPane = new JScrollPane();
        lensTable = new JTable();
        otherScrollPane = new JScrollPane();
        otherTable = new JTable();
        stockTabbedPane = new JTabbedPane();
        addGlassScrollPane8 = new JScrollPane();
        stockGlassTable = new JTable();
        stockFrameScrollPane = new JScrollPane();
        stockFrameTable = new JTable();
        stockLensScrollPane = new JScrollPane();
        stockLensTable = new JTable();
        stockOtherScrollPane = new JScrollPane();
        stockOtherTable = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventory");

        addTabbedPane.setForeground(new Color(255, 163, 114));
        stockTabbedPane.setForeground(new Color(255, 163, 114));
        addTabbedPane.setBackground(new Color(67, 101, 139));
        stockTabbedPane.setBackground(new Color(67, 101, 139));

        jPanel1.setBackground(new Color(78, 137, 174));
        jPanel1.setMinimumSize(new Dimension(1280, 720));
        jPanel1.setPreferredSize(new Dimension(1280, 720));
        jPanel1.setLayout(new GridBagLayout());

        menuButton.setBackground(new Color(67, 101, 139));
        menuButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        menuButton.setForeground(new Color(255, 163, 114));
        menuButton.setText("Main Menu");
        menuButton.setFocusable(false);
        menuButton.addActionListener(this::menuButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 5);
        jPanel1.add(menuButton, gridBagConstraints);

        saveButton.setBackground(new Color(67, 101, 139));
        saveButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        saveButton.setForeground(new Color(255, 163, 114));
        saveButton.setText("Save");
        saveButton.setFocusable(false);
        saveButton.addActionListener(this::saveButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 5);
        jPanel1.add(saveButton, gridBagConstraints);

        addRowButton.setBackground(new Color(67, 101, 139));
        addRowButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        addRowButton.setForeground(new Color(255, 163, 114));
        addRowButton.setText("Add Row");
        addRowButton.setFocusable(false);
        addRowButton.addActionListener(this::addRowButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 5);
        jPanel1.add(addRowButton, gridBagConstraints);

        removeButton.setBackground(new Color(67, 101, 139));
        removeButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        removeButton.setForeground(new Color(255, 163, 114));
        removeButton.setText("Remove");
        removeButton.setFocusable(false);
        removeButton.addActionListener(this::removeButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 5);
        jPanel1.add(removeButton, gridBagConstraints);

        removeStockButton.setBackground(new Color(67, 101, 139));
        removeStockButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        removeStockButton.setForeground(new Color(255, 163, 114));
        removeStockButton.setText("Remove From Inventory");
        removeStockButton.setFocusable(false);
        removeStockButton.addActionListener(this::removeStockButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 5);
        jPanel1.add(removeStockButton, gridBagConstraints);

        searchField.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        searchField.setForeground(new Color(180, 180, 180));
        searchField.setText(" Search...");
        searchField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                searchFieldFocusGained();
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
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 10);
        jPanel1.add(searchField, gridBagConstraints);

        glassTable.setBackground(new Color(67, 101, 139));
        glassTable.setForeground(new Color(255, 163, 114));
        glassTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        glassTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        glassTable.setModel(upperGlassModel);
        glassTable.setGridColor(new Color(255, 163, 114));
        glassScrollPane.setViewportView(glassTable);

        addTabbedPane.addTab("Glass", glassScrollPane);

        frameTable.setBackground(new Color(67, 101, 139));
        frameTable.setForeground(new Color(255, 163, 114));
        frameTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        frameTable.setModel(upperFrameModel);
        frameTable.setGridColor(new Color(255, 163, 114));
        frameScrollPane.setViewportView(frameTable);

        addTabbedPane.addTab("Frame", frameScrollPane);

        lensTable.setBackground(new Color(67, 101, 139));
        lensTable.setForeground(new Color(255, 163, 114));
        lensTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lensTable.setModel(upperLensModel);
        lensTable.setGridColor(new Color(255, 163, 114));
        lensScrollPane.setViewportView(lensTable);

        addTabbedPane.addTab("Lens", lensScrollPane);

        otherTable.setBackground(new Color(67, 101, 139));
        otherTable.setForeground(new Color(255, 163, 114));
        otherTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        otherTable.setModel(upperOtherModel);
        otherTable.setGridColor(new Color(255, 163, 114));
        otherScrollPane.setViewportView(otherTable);

        addTabbedPane.addTab("Other", otherScrollPane);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        jPanel1.add(addTabbedPane, gridBagConstraints);

        stockGlassTable.setBackground(new Color(67, 101, 139));
        stockGlassTable.setForeground(new Color(255, 163, 114));
        stockGlassTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        stockGlassTable.setModel(lowerGlassModel);
        stockGlassTable.setGridColor(new Color(255, 163, 114));
        addGlassScrollPane8.setViewportView(stockGlassTable);

        stockTabbedPane.addTab("Glass", addGlassScrollPane8);

        stockFrameTable.setBackground(new Color(67, 101, 139));
        stockFrameTable.setForeground(new Color(255, 163, 114));
        stockFrameTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        stockFrameTable.setModel(lowerFrameModel);
        stockFrameTable.setGridColor(new Color(255, 163, 114));
        stockFrameScrollPane.setViewportView(stockFrameTable);

        stockTabbedPane.addTab("Frame", stockFrameScrollPane);

        stockLensTable.setBackground(new Color(67, 101, 139));
        stockLensTable.setForeground(new Color(255, 163, 114));
        stockLensTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        stockLensTable.setModel(lowerLensModel);
        stockLensTable.setGridColor(new Color(255, 163, 114));
        stockLensScrollPane.setViewportView(stockLensTable);

        stockTabbedPane.addTab("Lens", stockLensScrollPane);

        stockOtherTable.setBackground(new Color(67, 101, 139));
        stockOtherTable.setForeground(new Color(255, 163, 114));
        stockOtherTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        stockOtherTable.setModel(lowerOtherModel);
        stockOtherTable.setGridColor(new Color(255, 163, 114));
        stockOtherScrollPane.setViewportView(stockOtherTable);

        stockTabbedPane.addTab("Other", stockOtherScrollPane);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        jPanel1.add(stockTabbedPane, gridBagConstraints);

        setSearchFunction();

        setLayout(new BorderLayout());
        getContentPane().add(jPanel1, BorderLayout.CENTER);

        menuButton.setFocusable(true);
        menuButton.setFocusPainted(false);
        menuButton.requestFocus();
        pack();
    }

    private void setSearchFunction() {
        glassRowSorter = new TableRowSorter<>(stockGlassTable.getModel());
        frameRowSorter = new TableRowSorter<>(stockFrameTable.getModel());
        lensRowSorter = new TableRowSorter<>(stockLensTable.getModel());
        otherRowSorter = new TableRowSorter<>(stockOtherTable.getModel());

        stockGlassTable.setRowSorter(glassRowSorter);
        stockFrameTable.setRowSorter(frameRowSorter);
        stockLensTable.setRowSorter(lensRowSorter);
        stockOtherTable.setRowSorter(otherRowSorter);
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

    private void addRowButtonActionPerformed(ActionEvent evt) {
        int idx = addTabbedPane.getSelectedIndex();
        if (idx == 0) {
            upperGlassModel.addRow(new String[]{});
        } else if (idx == 1) {
            upperFrameModel.addRow(new String[]{});
        } else if (idx == 2) {
            upperLensModel.addRow(new String[]{});
        } else if (idx == 3) {
            upperOtherModel.addRow(new String[]{});
        }
    }

    private void menuButtonActionPerformed(ActionEvent evt) {
        super.dispose();
    }

    private void saveButtonActionPerformed(ActionEvent evt) {
        // get data from upper table
        // send it to the db
        // repopulate lower tables
        // clear upper table

        Glass glass;
        Frame frame;
        ContactLens lens;
        Special special;

        // adds glass table to db
        for (int i = 0; i < upperGlassModel.getRowCount(); i++) {
            glass = new Glass();

            if (upperGlassModel.getValueAt(i, 0) != null) {
                try {
                    glass.setBarcode(upperGlassModel.getValueAt(i, 0).toString());
                    glass.setAlisFiyati(Double.parseDouble(upperGlassModel.getValueAt(i, 1).toString()));
                    glass.setSatisFiyati(Double.parseDouble(upperGlassModel.getValueAt(i, 2).toString()));
                    glass.setTur(upperGlassModel.getValueAt(i, 3).toString());
                    glass.setMarka(upperGlassModel.getValueAt(i, 4).toString());
                    glass.setindeks(upperGlassModel.getValueAt(i, 5).toString());
                    glass.setQuantity(Integer.parseInt(upperGlassModel.getValueAt(i, 6).toString()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Cannot add item with barcode: "
                            + upperGlassModel.getValueAt(i, 0).toString()
                            + ". Make sure you entered this item with correct values");
//                    e.printStackTrace();
                    continue;
                }
                controller.addGlass(glass.getBarcode(), glass.getAlisFiyati(), glass.getSatisFiyati(),
                        glass.getTur(), glass.getMarka(), glass.getindeks(), glass.getQuantity());
            } else {
                JOptionPane.showMessageDialog(null, "Barcode must be non-empty. Items with " +
                        "no barcode will not be added to the inventory.");
            }
        }

        // adds frame table to db
        for (int i = 0; i < upperFrameModel.getRowCount(); i++) {
            frame = new Frame();

            if (upperFrameModel.getValueAt(i, 0) != null) {
                try {
                    frame.setBarcode(upperFrameModel.getValueAt(i, 0).toString());
                    frame.setAlisFiyati(Double.parseDouble(upperFrameModel.getValueAt(i, 1).toString()));
                    frame.setSatisFiyati(Double.parseDouble(upperFrameModel.getValueAt(i, 2).toString()));
                    frame.setRenk(upperFrameModel.getValueAt(i, 3).toString());
                    frame.setMarka(upperFrameModel.getValueAt(i, 4).toString());
                    frame.setModel(upperFrameModel.getValueAt(i, 5).toString());
                    frame.setOzelAdi(upperFrameModel.getValueAt(i, 6).toString());
                    frame.setEkartman(upperFrameModel.getValueAt(i, 7).toString());
                    frame.setQuantity(Integer.parseInt(upperFrameModel.getValueAt(i, 8).toString()));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Cannot add item with barcode: "
                            + upperGlassModel.getValueAt(i, 0).toString()
                            + ". Make sure you entered this item with correct values");
                    continue;
                }
                controller.addFrame(frame.getBarcode(), frame.getMarka(),
                        frame.getModel(), frame.getEkartman(), frame.getRenk(), frame.getAlisFiyati(),
                        frame.getSatisFiyati(), frame.getOzelAdi(), frame.getQuantity());

            } else {
                JOptionPane.showMessageDialog(null, "Barcode must be non-empty. Items with " +
                        "no barcode will not be added to the inventory.");
            }

        }

        // adds lens table to db
        for (int i = 0; i < upperLensModel.getRowCount(); i++) {
            lens = new ContactLens();
            if (upperLensModel.getValueAt(i, 0) != null) {
                try {
                    lens.setBarcode(upperLensModel.getValueAt(i, 0).toString());
                    lens.setDiyoptri(upperLensModel.getValueAt(i, 1).toString());
                    lens.setAks(upperLensModel.getValueAt(i, 2).toString());
                    lens.setSilindirik(upperLensModel.getValueAt(i, 3).toString());
                    lens.setAlisFiyati(Double.parseDouble(upperLensModel.getValueAt(i, 4).toString()));
                    lens.setSatisFiyati(Double.parseDouble(upperLensModel.getValueAt(i, 5).toString()));
                    lens.setQuantity(Integer.parseInt(upperLensModel.getValueAt(i, 6).toString()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Cannot add item with barcode: "
                            + upperGlassModel.getValueAt(i, 0).toString()
                            + ". Make sure you entered this item with correct values");
                    continue;
                }
                controller.addContactLens(lens.getBarcode(), lens.getDiyoptri(),
                        lens.getAks(), lens.getSilindirik(),
                        lens.getAlisFiyati(), lens.getSatisFiyati(), lens.getQuantity());
            }
        }

        // adds other table to db
        for (int i = 0; i < upperOtherModel.getRowCount(); i++) {
            special = new Special();
            if (upperOtherModel.getValueAt(i, 0) != null) {
                try {
                    special.setBarcode(upperOtherModel.getValueAt(i, 0).toString());
                    special.setAlisFiyati(Double.parseDouble(upperOtherModel.getValueAt(i, 1).toString()));
                    special.setSatisFiyati(Double.parseDouble(upperOtherModel.getValueAt(i, 2).toString()));
                    special.setQuantity(Integer.parseInt(upperOtherModel.getValueAt(i, 3).toString()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Cannot add item with barcode: "
                            + upperGlassModel.getValueAt(i, 0).toString()
                            + ". Make sure you entered this item with correct values");
                    continue;
                }
                controller.addSpecial(special.getBarcode(), special.getOzelAdi(),
                        special.getAlisFiyati(), special.getSatisFiyati(), special.getQuantity());
            }
        }
        clearUpperTable();
        fillLowerTable();
    }

    private void removeButtonActionPerformed(ActionEvent evt) {
        int idx = addTabbedPane.getSelectedIndex();

        if (idx == 0 && glassTable.getSelectedRow() != -1) {
            upperGlassModel.removeRow(glassTable.getSelectedRow());
        } else if (idx == 1 && frameTable.getSelectedRow() != -1) {
            upperFrameModel.addRow(new String[]{});
        } else if (idx == 2 && lensTable.getSelectedRow() != -1) {
            upperLensModel.addRow(new String[]{});
        } else if (idx == 3 && otherTable.getSelectedRow() != -1) {
            upperOtherModel.addRow(new String[]{});
        }

    }

    private void removeStockButtonActionPerformed(ActionEvent evt) {
        int idx = stockTabbedPane.getSelectedIndex();
        if (idx == 0 && stockGlassTable.getSelectedRow() != -1) {
            controller.removeGlass((String) lowerGlassModel.getValueAt(stockGlassTable.getSelectedRow(), 0));
            // column zero is the barcode column
        } else if (idx == 1 && stockFrameTable.getSelectedRow() != -1) {
            controller.removeFrame((String) lowerFrameModel.getValueAt(stockFrameTable.getSelectedRow(), 0));
        } else if (idx == 2 && stockLensTable.getSelectedRow() != -1) {
            controller.removeLens((String) lowerLensModel.getValueAt(stockLensTable.getSelectedRow(), 0));
        } else if (idx == 3 && stockOtherTable.getSelectedRow() != -1) {
            controller.removeSpecial((String) lowerOtherModel.getValueAt(stockOtherTable.getSelectedRow(), 0));
        }
        fillLowerTable();
    }
    private void clearUpperTable(){
        upperGlassModel.setRowCount(0);
        upperFrameModel.setRowCount(0);
        upperLensModel.setRowCount(0);
        upperOtherModel.setRowCount(0);
    }

    private void searchFieldFocusGained() {
        searchField.setForeground(new Color(255, 163, 114));
        searchField.setText("");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new InventoryFrame().setVisible(true));
    }


}
