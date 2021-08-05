package view;

import controller.Controller;
import model.Frame;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SaleHistoryFrame extends JFrame {

    private JTable GlassTable1;
    private JTable frameTable;
    private JTable lensTable;
    private JTable otherTable1;

    private JTextField cancelField;

    private JLabel cancelLabel;
    private JLabel netIncNumLabel;
    private JLabel ooPriceLabel2;
    private JLabel overallProfitLabel;
    private JLabel searchSsnLabel;
    private JLabel tInLabel;
    private JLabel totExtNumLabel;
    private JLabel totIncLabel;
    private JLabel totInvOutLabel;
    private JLabel totInvOutNumLabel;
    private JLabel totOutSaleLabel;

    private JButton cancelSaleButton;
    private JButton mainMenuButton;
    private JButton searchSaleButton;
    private JButton searchSsnButton;

    private JScrollPane frameScrollPane;
    private JScrollPane glassScrollPane;
    private JScrollPane lensScrollPane;
    private JScrollPane otherScrollPane;

    private JPanel jPanel1;

    private JSeparator jSeparator2;

    private JTabbedPane jTabbedPane;

    private JPanel lowerMenu;
    private JPanel upperMenu;

    private JTextField searchSaleField;
    private JTextField searchSsnField;

    private DefaultTableModel glassTModel;
    private DefaultTableModel frameTModel;
    private DefaultTableModel lensTModel;
    private DefaultTableModel otherTModel;

    private Controller controller;

    public SaleHistoryFrame() {
        initComponents();
        setTitle("Sale History");
        setVisible(true);
    }

    private void initComponents() {

        GridBagConstraints gridBagConstraints;
        glassTModel = new DefaultTableModel();
        frameTModel = new DefaultTableModel();
        lensTModel = new DefaultTableModel();
        otherTModel = new DefaultTableModel();

        controller = new Controller();
        jPanel1 = new JPanel();
        lowerMenu = new JPanel();
        totInvOutNumLabel = new JLabel();
        netIncNumLabel = new JLabel();
        totOutSaleLabel = new JLabel();
        tInLabel = new JLabel();
        overallProfitLabel = new JLabel();
        totExtNumLabel = new JLabel();
        totInvOutLabel = new JLabel();
        totIncLabel = new JLabel();
        jTabbedPane = new JTabbedPane();
        glassScrollPane = new JScrollPane();
        GlassTable1 = new JTable();
        frameScrollPane = new JScrollPane();
        frameTable = new JTable();
        lensScrollPane = new JScrollPane();
        lensTable = new JTable();
        otherScrollPane = new JScrollPane();
        otherTable1 = new JTable();
        searchSsnLabel = new JLabel();
        searchSsnField = new JTextField();
        searchSaleField = new JTextField();
        cancelLabel = new JLabel();
        jSeparator2 = new JSeparator();
        cancelField = new JTextField();
        ooPriceLabel2 = new JLabel();
        searchSaleButton = new JButton();
        searchSsnButton = new JButton();
        cancelSaleButton = new JButton();
        upperMenu = new JPanel();
        mainMenuButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sell History");

        setColumnNames();

        jPanel1.setBackground(new Color(78, 137, 174));
        jPanel1.setLayout(new GridBagLayout());

        lowerMenu.setBackground(new Color(78, 137, 174));
        lowerMenu.setLayout(new GridBagLayout());

        totInvOutNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        totInvOutNumLabel.setForeground(new Color(255, 163, 114));
        totInvOutNumLabel.setText("0.0");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 5, 0, 15);
        lowerMenu.add(totInvOutNumLabel, gridBagConstraints);

        netIncNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        netIncNumLabel.setForeground(new Color(255, 163, 114));
        netIncNumLabel.setText("0.0");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 5, 0, 15);
        lowerMenu.add(netIncNumLabel, gridBagConstraints);

        totOutSaleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        totOutSaleLabel.setForeground(new Color(255, 163, 114));
        totOutSaleLabel.setText("Total Outcome From Sale:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        lowerMenu.add(totOutSaleLabel, gridBagConstraints);

        tInLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        tInLabel.setForeground(new Color(255, 163, 114));
        tInLabel.setText("0.0");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 5, 0, 15);
        lowerMenu.add(tInLabel, gridBagConstraints);

        overallProfitLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        overallProfitLabel.setForeground(new Color(255, 163, 114));
        overallProfitLabel.setText("Overall Profil:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        lowerMenu.add(overallProfitLabel, gridBagConstraints);

        totExtNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        totExtNumLabel.setForeground(new Color(255, 163, 114));
        totExtNumLabel.setText("0.0");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 5, 0, 15);
        lowerMenu.add(totExtNumLabel, gridBagConstraints);

        totInvOutLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        totInvOutLabel.setForeground(new Color(255, 163, 114));
        totInvOutLabel.setText("Total Inventory Outcome:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        lowerMenu.add(totInvOutLabel, gridBagConstraints);

        totIncLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        totIncLabel.setForeground(new Color(255, 163, 114));
        totIncLabel.setText("Total Income From Sale:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        lowerMenu.add(totIncLabel, gridBagConstraints);

        jTabbedPane.setBackground(new Color(67, 101, 139));
        jTabbedPane.setForeground(new Color(255, 163, 114));
        jTabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N

        GlassTable1.setBackground(new Color(67, 101, 139));
        GlassTable1.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        GlassTable1.setForeground(new Color(255, 163, 114));
        GlassTable1.setModel(glassTModel);
        GlassTable1.setGridColor(new Color(255, 163, 114));
        glassScrollPane.setViewportView(GlassTable1);

        jTabbedPane.addTab("Glass", glassScrollPane);

        frameTable.setBackground(new Color(67, 101, 139));
        frameTable.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        frameTable.setForeground(new Color(255, 163, 114));
        frameTable.setModel(frameTModel);
        frameTable.setGridColor(new Color(255, 163, 114));
        frameScrollPane.setViewportView(frameTable);

        jTabbedPane.addTab("Frame", frameScrollPane);

        lensTable.setBackground(new Color(67, 101, 139));
        lensTable.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        lensTable.setForeground(new Color(255, 163, 114));
        lensTable.setModel(lensTModel);
        lensTable.setGridColor(new Color(255, 163, 114));
        lensScrollPane.setViewportView(lensTable);

        jTabbedPane.addTab("Lens", lensScrollPane);

        otherScrollPane.setForeground(new Color(255, 163, 114));

        otherTable1.setBackground(new Color(67, 101, 139));
        otherTable1.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        otherTable1.setForeground(new Color(255, 163, 114));
        otherTable1.setModel(otherTModel);
        otherTable1.setGridColor(new Color(255, 163, 114));
        otherScrollPane.setViewportView(otherTable1);

        jTabbedPane.addTab("Other", otherScrollPane);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 11;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 10);
        lowerMenu.add(jTabbedPane, gridBagConstraints);

        searchSsnLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        searchSsnLabel.setForeground(new Color(255, 163, 114));
        searchSsnLabel.setText("Search by SSN:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        lowerMenu.add(searchSsnLabel, gridBagConstraints);

        searchSsnField.setColumns(13);
        searchSsnField.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        searchSsnField.setForeground(new Color(180, 180, 180));
        searchSsnField.setText("SSN");
        searchSsnField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                searchSsnFieldFocusGained(evt);
            }
        });
        searchSsnField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                searchSsnFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(10, 5, 5, 0);
        lowerMenu.add(searchSsnField, gridBagConstraints);

        searchSaleField.setColumns(13);
        searchSaleField.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        searchSaleField.setForeground(new Color(180, 180, 180));
        searchSaleField.setText("Sale Id");
        searchSaleField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                searchSaleFieldFocusGained(evt);
            }
        });
        searchSaleField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                searchSaleFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(10, 5, 0, 0);
        lowerMenu.add(searchSaleField, gridBagConstraints);

        cancelLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        cancelLabel.setForeground(new Color(255, 163, 114));
        cancelLabel.setText("Cancel:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        lowerMenu.add(cancelLabel, gridBagConstraints);

        jSeparator2.setBackground(new Color(255, 163, 114));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new Insets(0, 10, 0, 10);
        lowerMenu.add(jSeparator2, gridBagConstraints);

        cancelField.setColumns(13);
        cancelField.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        cancelField.setForeground(new Color(180, 180, 180));
        cancelField.setText("Sale Id");
        cancelField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                cancelFieldFocusGained(evt);
            }
        });
        cancelField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                cancelFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(10, 5, 0, 0);
        lowerMenu.add(cancelField, gridBagConstraints);

        ooPriceLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        ooPriceLabel2.setForeground(new Color(255, 163, 114));
        ooPriceLabel2.setText("Search by Sale Id:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        lowerMenu.add(ooPriceLabel2, gridBagConstraints);

        searchSaleButton.setBackground(new Color(67, 101, 139));
        searchSaleButton.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        searchSaleButton.setForeground(new Color(255, 163, 114));
        searchSaleButton.setText("Search");
        searchSaleButton.addActionListener(this::searchSaleButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new Insets(10, 5, 0, 10);
        lowerMenu.add(searchSaleButton, gridBagConstraints);

        searchSsnButton.setBackground(new Color(67, 101, 139));
        searchSsnButton.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        searchSsnButton.setForeground(new Color(255, 163, 114));
        searchSsnButton.setText("Search");
        searchSsnButton.addActionListener(this::searchSsnButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new Insets(10, 5, 0, 10);
        lowerMenu.add(searchSsnButton, gridBagConstraints);

        cancelSaleButton.setBackground(new Color(67, 101, 139));
        cancelSaleButton.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        cancelSaleButton.setForeground(new Color(255, 163, 114));
        cancelSaleButton.setText("Cancel");
        cancelSaleButton.addActionListener(this::cancelSaleButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new Insets(10, 5, 0, 10);
        lowerMenu.add(cancelSaleButton, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        jPanel1.add(lowerMenu, gridBagConstraints);

        upperMenu.setBackground(new Color(78, 137, 174));
        upperMenu.setBorder(BorderFactory.createLineBorder(new Color(255, 163, 114), 2));
        upperMenu.setLayout(new GridBagLayout());

        mainMenuButton.setBackground(new Color(67, 101, 139));
        mainMenuButton.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        mainMenuButton.setForeground(new Color(255, 163, 114));
        mainMenuButton.setText("Main Menu");
        mainMenuButton.addActionListener(this::mainMenuButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 10);
        upperMenu.add(mainMenuButton, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(5, 10, 10, 10);
        jPanel1.add(upperMenu, gridBagConstraints);

        setLayout(new BorderLayout());
        getContentPane().add(jPanel1, BorderLayout.CENTER);

        pack();

    }

    private void searchSsnButtonActionPerformed(ActionEvent evt) {
        resetTables();

        String ssn = searchSsnField.getText();
        ArrayList<Sale> sales = new ArrayList<>();
        ArrayList<String> barcodes = new ArrayList<String>();
        Object item;
        Sale sale;

        if (!ssn.isEmpty()) {
            ArrayList<Integer> saleIds = controller.searchByTckn(ssn);
            for (Integer saleId : saleIds) {
                barcodes.clear();
                sale = controller.findSaleBySaleId(saleId);
                sales.add(sale);
                barcodes.addAll(controller.findRecordsBySaleId(sale.getId()));
                PrescriptionCam pc = controller.findPrescriptionGlass(sale.getCamReceteNo());
                PrescriptionLens pl = controller.findPrescriptionLens(sale.getLensReceteNo());

                for (int j = 0; j < barcodes.size(); j++) {
                    item = controller.findStock(barcodes.get(j));
                    if (item.getClass().getTypeName().contains("Glass")) {
                        System.out.println("h");
                        if (!pc.getRcBarcode().isEmpty() && pc.getRcBarcode().equals(((Glass) item).getBarcode())) {
                            glassTModel.addRow(new String[]{String.valueOf(sale.getId()), sale.getTarih(),
                                    sale.getCamReceteNo(), pc.getReceteTarihi(), "right", pc.getRcSph(), pc.getRcCyl(),
                                    pc.getRcAx(), pc.getRcPd(), pc.getRcYukseklik(), ((Glass) item).getBarcode(),
                                    String.valueOf(((Glass) item).getAlisFiyati()), String.valueOf(((Glass) item).getSatisFiyati()),
                                    ((Glass) item).getTur(), ((Glass) item).getMarka(), ((Glass) item).getindeks(), "1"});

                        } else if (!pc.getLcBarcode().isEmpty() && pc.getLcBarcode().equals(((Glass) item).getBarcode())) {
                            glassTModel.addRow(new String[]{String.valueOf(sale.getId()), sale.getTarih(),
                                    sale.getCamReceteNo(), pc.getReceteTarihi(), "left", pc.getLcSph(), pc.getLcCyl(),
                                    pc.getLcAx(), pc.getLcPd(), pc.getLcYukseklik(), ((Glass) item).getBarcode(),
                                    String.valueOf(((Glass) item).getAlisFiyati()), String.valueOf(((Glass) item).getSatisFiyati()),
                                    ((Glass) item).getTur(), ((Glass) item).getMarka(), ((Glass) item).getindeks(), "1"});
                        }
                    } else if (item.getClass().getTypeName().contains("Frame")) {
                        frameTModel.addRow(new String[]{String.valueOf(sale.getId()), sale.getTarih(),
                                ((Frame) item).getBarcode(), String.valueOf(((Frame) item).getAlisFiyati()),
                                String.valueOf(((Frame) item).getSatisFiyati()), ((Frame) item).getRenk(),
                                ((Frame) item).getMarka(), ((Frame) item).getModel(), ((Frame) item).getOzelAdi(),
                                ((Frame) item).getEkartman(), "1"});
                    } else if (item.getClass().getTypeName().contains("ContactLens")) {
                        if (!pl.getRlBarcode().isEmpty() && pl.getRlBarcode().equals(((ContactLens) item).getBarcode())) {
                            lensTModel.addRow(new String[]{String.valueOf(sale.getId()), sale.getTarih(), pl.getReceteNo(),
                                    pl.getReceteTarihi(), "right", pl.getRlTemelEgri(), pl.getRlTumCap(), pl.getRlRenk(),
                                    pl.getRlOzelAd(), pl.getRlBarcode(), ((ContactLens) item).getDiyoptri(),
                                    ((ContactLens) item).getAks(), ((ContactLens) item).getSilindirik(),
                                    String.valueOf(((ContactLens) item).getAlisFiyati()),
                                    String.valueOf(((ContactLens) item).getSatisFiyati())});
                        } else if (!pl.getLlBarcode().isEmpty() && pl.getLlBarcode().equals(((ContactLens) item).getBarcode())) {
                            lensTModel.addRow(new String[]{
                                    String.valueOf(sale.getId()), sale.getTarih(), pl.getReceteNo(),
                                    pl.getReceteTarihi(), "left", pl.getLlTemelEgri(), pl.getLlTumCap(), pl.getLlRenk(),
                                    pl.getLlOzelAd(), pl.getLlBarcode(), ((ContactLens) item).getDiyoptri(),
                                    ((ContactLens) item).getAks(), ((ContactLens) item).getSilindirik(),
                                    String.valueOf(((ContactLens) item).getAlisFiyati()),
                                    String.valueOf(((ContactLens) item).getSatisFiyati())
                            });
                        }
                    } else if (item.getClass().getTypeName().contains("Special")) {
                        otherTModel.addRow(new String[]{String.valueOf(sale.getId()), sale.getTarih(),
                                ((Special) item).getBarcode(), String.valueOf(((Special) item).getAlisFiyati()),
                                String.valueOf(((Special) item).getSatisFiyati())});
                    }
                }
            }
        }
    }

    private void resetTables() {
        glassTModel.setRowCount(0);
        frameTModel.setRowCount(0);
        lensTModel.setRowCount(0);
        otherTModel.setRowCount(0);
    }

    private void addRow(ArrayList<String> barcodes) {
        //glassTModel.addRow();
    }

    private void setColumnNames() {
        String[] glassAttributes = new String[]{"sale no", "sale date", "presc. no.", "presc. date", "right/left", "sph",
                "cyl", "axis", "pd", "height", "barcode", "purchase price",
                "sell price", "type", "brand", "index", "quantity"};
        glassTModel.setColumnIdentifiers(glassAttributes);

        String[] frameAttributes = new String[]{"sale no", "sale date", "barcode",
                "purchase price", "sell price", "color", "brand", "model",
                "special name", "size", "quantity"};
        frameTModel.setColumnIdentifiers(frameAttributes);

        String[] lensAttributes = new String[]{"sale no", "sale date", "presc. no.",
                "presc. date", "sale date", "right/left", "basic curve", "diameter", "color",
                "special name", "barcode", "dioptri", "ax", "cylindrical", "purchase price", "sell price"};
        lensTModel.setColumnIdentifiers(lensAttributes);

        String[] otherAttributes = new String[]{"sale no", "sale date", "barcode", "purchase price", "sell price"};
        otherTModel.setColumnIdentifiers(otherAttributes);


    }


    private void searchSsnFieldFocusGained(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void searchSsnFieldKeyTyped(KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void searchSaleFieldFocusGained(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void searchSaleFieldKeyTyped(KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void cancelFieldFocusGained(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void cancelFieldKeyTyped(KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void searchSaleButtonActionPerformed(ActionEvent evt) {
        resetTables();

        String saleId = searchSaleField.getText();
        Object item;
        Sale sale;
        if (!saleId.isEmpty()) {
            try {
                sale = controller.findSaleBySaleId(Integer.parseInt(saleId));
            } catch (NumberFormatException e) {
                sale = new Sale();
            }
            ArrayList<String> barcodes = controller.findRecordsBySaleId(sale.getId());
            PrescriptionCam pc = controller.findPrescriptionGlass(sale.getCamReceteNo());
            PrescriptionLens pl = controller.findPrescriptionLens(sale.getLensReceteNo());

            for (String barcode : barcodes) {
                item = controller.findStock(barcode);
                if (item.getClass().getTypeName().contains("Glass")) {
                    System.out.println("h");
                    if (!pc.getRcBarcode().isEmpty() && pc.getRcBarcode().equals(((Glass) item).getBarcode())) {
                        glassTModel.addRow(new String[]{String.valueOf(sale.getId()), sale.getTarih(),
                                sale.getCamReceteNo(), pc.getReceteTarihi(), "right", pc.getRcSph(), pc.getRcCyl(),
                                pc.getRcAx(), pc.getRcPd(), pc.getRcYukseklik(), ((Glass) item).getBarcode(),
                                String.valueOf(((Glass) item).getAlisFiyati()), String.valueOf(((Glass) item).getSatisFiyati()),
                                ((Glass) item).getTur(), ((Glass) item).getMarka(), ((Glass) item).getindeks(), "1"});

                    } else if (!pc.getLcBarcode().isEmpty() && pc.getLcBarcode().equals(((Glass) item).getBarcode())) {
                        glassTModel.addRow(new String[]{String.valueOf(sale.getId()), sale.getTarih(),
                                sale.getCamReceteNo(), pc.getReceteTarihi(), "left", pc.getLcSph(), pc.getLcCyl(),
                                pc.getLcAx(), pc.getLcPd(), pc.getLcYukseklik(), ((Glass) item).getBarcode(),
                                String.valueOf(((Glass) item).getAlisFiyati()), String.valueOf(((Glass) item).getSatisFiyati()),
                                ((Glass) item).getTur(), ((Glass) item).getMarka(), ((Glass) item).getindeks(), "1"});
                    }
                } else if (item.getClass().getTypeName().contains("Frame")) {
                    frameTModel.addRow(new String[]{String.valueOf(sale.getId()), sale.getTarih(),
                            ((Frame) item).getBarcode(), String.valueOf(((Frame) item).getAlisFiyati()),
                            String.valueOf(((Frame) item).getSatisFiyati()), ((Frame) item).getRenk(),
                            ((Frame) item).getMarka(), ((Frame) item).getModel(), ((Frame) item).getOzelAdi(),
                            ((Frame) item).getEkartman(), "1"});
                } else if (item.getClass().getTypeName().contains("ContactLens")) {
                    if (!pl.getRlBarcode().isEmpty() && pl.getRlBarcode().equals(((ContactLens) item).getBarcode())) {
                        lensTModel.addRow(new String[]{String.valueOf(sale.getId()), sale.getTarih(), pl.getReceteNo(),
                                pl.getReceteTarihi(), "right", pl.getRlTemelEgri(), pl.getRlTumCap(), pl.getRlRenk(),
                                pl.getRlOzelAd(), pl.getRlBarcode(), ((ContactLens) item).getDiyoptri(),
                                ((ContactLens) item).getAks(), ((ContactLens) item).getSilindirik(),
                                String.valueOf(((ContactLens) item).getAlisFiyati()),
                                String.valueOf(((ContactLens) item).getSatisFiyati())});
                    } else if (!pl.getLlBarcode().isEmpty() && pl.getLlBarcode().equals(((ContactLens) item).getBarcode())) {
                        lensTModel.addRow(new String[]{
                                String.valueOf(sale.getId()), sale.getTarih(), pl.getReceteNo(),
                                pl.getReceteTarihi(), "left", pl.getLlTemelEgri(), pl.getLlTumCap(), pl.getLlRenk(),
                                pl.getLlOzelAd(), pl.getLlBarcode(), ((ContactLens) item).getDiyoptri(),
                                ((ContactLens) item).getAks(), ((ContactLens) item).getSilindirik(),
                                String.valueOf(((ContactLens) item).getAlisFiyati()),
                                String.valueOf(((ContactLens) item).getSatisFiyati())
                        });
                    }
                } else if (item.getClass().getTypeName().contains("Special")) {
                    otherTModel.addRow(new String[]{String.valueOf(sale.getId()), sale.getTarih(),
                            ((Special) item).getBarcode(), String.valueOf(((Special) item).getAlisFiyati()),
                            String.valueOf(((Special) item).getSatisFiyati())});
                }
            }

        }

    }

    private void cancelSaleButtonActionPerformed(ActionEvent evt) {
        try {
            int saleId = Integer.parseInt(cancelField.getText());
            controller.cancelSale(saleId);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number.");
        }
    }

    private void mainMenuButtonActionPerformed(ActionEvent evt) {
        super.dispose();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new SaleHistoryFrame().setVisible(true));
    }

}
