package view;

import controller.Controller;
import model.Frame;
import model.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

public class StatisticsFrame extends JFrame {
    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    private JButton applyFilterBtn;
    private JButton addOtherOutBtn;
    private JButton clearBtn;
    private JButton mainMenuBtn;

    private JSeparator jSeparator1;

    private JTabbedPane jTabbedPane1;

    private JPanel lowerMenu;
    private JPanel jPanel1;

    private JSpinner lastDateSpinner;
    private JSpinner firstDateSpinner;

    private JTextField otherOutcomeField;
    private JTextField ooPriceField;

    private JScrollPane otherScrollPane;
    private JScrollPane extraScrollPane;
    private JScrollPane frameScrollPane;
    private JScrollPane glassScrollPane;
    private JScrollPane lensScrollPane;

    private JTable otherTable;
    private JTable lensTable;
    private JTable frameTable;
    private JTable extraTable;
    private JTable GlassTable;

    private JLabel firstDateLabel;
    private JLabel ooPriceLabel;
    private JLabel overallProfitLabel;
    private JLabel tInLabel;
    private JLabel tioNumLabel;
    private JLabel totExtNumLabel;
    private JLabel totExtOutLabel;
    private JLabel totIncLabel;
    private JLabel totInvOutLabel;
    private JPanel upperMenu;
    private JLabel netIncNumLabel;
    private JLabel lastDateLabel;
    private JLabel jLabel11;

    private DefaultTableModel glassTModel;
    private DefaultTableModel frameTModel;
    private DefaultTableModel lensTModel;
    private DefaultTableModel otherTModel;
    private DefaultTableModel extraModel;

    private Controller controller;

    public StatisticsFrame() {

        initComponents();
        setColumnNames();
        fillTables(null, null);
        setMinimumSize(new Dimension(1280, 720));
        setTitle("Statistics");
        setVisible(true);

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

        String[] extraAttributes = new String[]{"description", "price", "date"};
        extraModel.setColumnIdentifiers(extraAttributes);
    }

    private void fillTables(ArrayList<Extra> extras, ArrayList<Sale> sales) {

        glassTModel.setRowCount(0);
        frameTModel.setRowCount(0);
        lensTModel.setRowCount(0);
        otherTModel.setRowCount(0);
        extraModel.setRowCount(0);

        if (sales == null) {
            sales = controller.getSale();
        }

        if (extras == null) {
            System.out.println("extra list is empty");
            extras = controller.getExtras();
        }
        Object item;

        if (!sales.isEmpty()) {
            for (Sale sale : sales) {


                try {
                    sale = controller.findSaleBySaleId(sale.getId());
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


            }// end sales
        }
        for (Extra extra : extras) {
            extraModel.addRow(new String[]{extra.getAciklama(), String.valueOf(extra.getFiyat()), extra.getTarih()});
        }


    }

    UtilDateModel model;
    Properties p;
    JDatePanelImpl datePanel;
    JDatePickerImpl firstDatePicker;
    UtilDateModel lastModel;
    Properties lastP;
    JDatePanelImpl lastdatePanel;
    JDatePickerImpl lastDatePicker;


    private void initComponents() {
        // implement date picker
        model = new UtilDateModel();
        p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        datePanel = new JDatePanelImpl(model, p);
        firstDatePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        lastModel = new UtilDateModel();
        lastP = new Properties();
        lastP.put("text.today", "Today");
        lastP.put("text.month", "Month");
        lastP.put("text.year", "Year");
        lastdatePanel = new JDatePanelImpl(lastModel, lastP);
        lastDatePicker = new JDatePickerImpl(lastdatePanel, new DateLabelFormatter());


        GridBagConstraints gridBagConstraints;
        controller = new Controller();
        glassTModel = new DefaultTableModel();
        frameTModel = new DefaultTableModel();
        lensTModel = new DefaultTableModel();
        otherTModel = new DefaultTableModel();
        extraModel = new DefaultTableModel();

        jPanel1 = new JPanel();
        upperMenu = new JPanel();
        lastDateSpinner = new JSpinner();
        applyFilterBtn = new JButton();
        mainMenuBtn = new JButton();
        firstDateSpinner = new JSpinner();
        lastDateLabel = new JLabel();
        firstDateLabel = new JLabel();
        clearBtn = new JButton();
        lowerMenu = new JPanel();
        tioNumLabel = new JLabel();
        netIncNumLabel = new JLabel();
        totExtOutLabel = new JLabel();
        tInLabel = new JLabel();
        overallProfitLabel = new JLabel();
        totExtNumLabel = new JLabel();
        totInvOutLabel = new JLabel();
        totIncLabel = new JLabel();
        jTabbedPane1 = new JTabbedPane();
        glassScrollPane = new JScrollPane();
        GlassTable = new JTable();
        frameScrollPane = new JScrollPane();
        frameTable = new JTable();
        lensScrollPane = new JScrollPane();
        lensTable = new JTable();
        extraScrollPane = new JScrollPane();
        extraTable = new JTable();
        otherScrollPane = new JScrollPane();
        otherTable = new JTable();
        jLabel11 = new JLabel();
        addOtherOutBtn = new JButton();
        otherOutcomeField = new JTextField();
        ooPriceField = new JTextField();
        ooPriceLabel = new JLabel();
//        ooSpinner = new JSpinner();
//        ooDateLabel = new JLabel();
        jSeparator1 = new JSeparator();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new Color(78, 137, 174));
        jPanel1.setLayout(new GridBagLayout());

        upperMenu.setBackground(new Color(78, 137, 174));
        upperMenu.setBorder(BorderFactory.createLineBorder(new Color(255, 163, 114), 2));
        upperMenu.setLayout(new GridBagLayout());

//        lastDateSpinner.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
//        lastDateSpinner.setModel(new SpinnerDateModel());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 10);
        upperMenu.add(lastDatePicker, gridBagConstraints);

        applyFilterBtn.setBackground(new Color(67, 101, 139));
        applyFilterBtn.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        applyFilterBtn.setForeground(new Color(255, 163, 114));
        applyFilterBtn.setText("Apply Filter");
        applyFilterBtn.addActionListener(this::applyActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 10);
        upperMenu.add(applyFilterBtn, gridBagConstraints);

        mainMenuBtn.setBackground(new Color(67, 101, 139));
        mainMenuBtn.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        mainMenuBtn.setForeground(new Color(255, 163, 114));
        mainMenuBtn.setText("Main Menu");
        mainMenuBtn.addActionListener(this::mainMenuButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 10);
        upperMenu.add(mainMenuBtn, gridBagConstraints);

//        firstDateSpinner.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
//        //SpinnerDateModel spd = new SpinnerDateModel();
//        firstDateSpinner.setModel(new SpinnerDateModel());
//        firstDateSpinner.setEditor(new JSpinner.DateEditor(firstDateSpinner, "dd.MM.yyyy"));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 10);
        upperMenu.add(firstDatePicker, gridBagConstraints);

        lastDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        lastDateLabel.setForeground(new Color(255, 163, 114));
        lastDateLabel.setText("Last Date:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 10);
        upperMenu.add(lastDateLabel, gridBagConstraints);

        firstDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        firstDateLabel.setForeground(new Color(255, 163, 114));
        firstDateLabel.setText("First Date:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 10);
        upperMenu.add(firstDateLabel, gridBagConstraints);

        clearBtn.setBackground(new Color(67, 101, 139));
        clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        clearBtn.setForeground(new Color(255, 163, 114));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(this::clearButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 5, 10, 10);
        upperMenu.add(clearBtn, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        jPanel1.add(upperMenu, gridBagConstraints);

        lowerMenu.setBackground(new Color(78, 137, 174));
        lowerMenu.setLayout(new GridBagLayout());

        tioNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        tioNumLabel.setForeground(new Color(255, 163, 114));
        tioNumLabel.setText("0.0");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 5, 0, 15);
        lowerMenu.add(tioNumLabel, gridBagConstraints);

        netIncNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        netIncNumLabel.setForeground(new Color(255, 163, 114));
        netIncNumLabel.setText("0.0");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 5, 0, 15);
        lowerMenu.add(netIncNumLabel, gridBagConstraints);

        totExtOutLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        totExtOutLabel.setForeground(new Color(255, 163, 114));
        totExtOutLabel.setText("Total Extra Outcome:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        lowerMenu.add(totExtOutLabel, gridBagConstraints);

        tInLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        tInLabel.setForeground(new Color(255, 163, 114));
        tInLabel.setText("0.0");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
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
        gridBagConstraints.gridy = 8;
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
        gridBagConstraints.gridy = 6;
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
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        lowerMenu.add(totInvOutLabel, gridBagConstraints);

        totIncLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        totIncLabel.setForeground(new Color(255, 163, 114));
        totIncLabel.setText("Total Income:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        lowerMenu.add(totIncLabel, gridBagConstraints);

        jTabbedPane1.setBackground(new Color(67, 101, 139));
        jTabbedPane1.setForeground(new Color(255, 163, 114));
        jTabbedPane1.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N

        GlassTable.setBackground(new Color(67, 101, 139));
        GlassTable.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        GlassTable.setForeground(new Color(255, 163, 114));
        GlassTable.setModel(glassTModel);
//        GlassTable.setRowSorter(glassRowSorter);
        GlassTable.setGridColor(new Color(255, 163, 114));
        glassScrollPane.setViewportView(GlassTable);

        jTabbedPane1.addTab("Glass", glassScrollPane);

        frameTable.setBackground(new Color(67, 101, 139));
        frameTable.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        frameTable.setForeground(new Color(255, 163, 114));
        frameTable.setModel(frameTModel);
//        frameTable.setRowSorter(frameRowSorter);
        frameTable.setGridColor(new Color(255, 163, 114));
        frameScrollPane.setViewportView(frameTable);

        jTabbedPane1.addTab("Frame", frameScrollPane);

        lensTable.setBackground(new Color(67, 101, 139));
        lensTable.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        lensTable.setForeground(new Color(255, 163, 114));
        lensTable.setModel(lensTModel);
//        lensTable.setRowSorter(lensRowSorter);
        lensTable.setGridColor(new Color(255, 163, 114));
        lensScrollPane.setViewportView(lensTable);

        jTabbedPane1.addTab("Lens", lensScrollPane);

        extraTable.setBackground(new Color(67, 101, 139));
        extraTable.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        extraTable.setForeground(new Color(255, 163, 114));
        extraTable.setModel(extraModel);
        //    extraTable.setRowSorter(extraRowSorter);
        extraTable.setGridColor(new Color(255, 163, 114));
        extraScrollPane.setViewportView(extraTable);

        jTabbedPane1.addTab("Extra", extraScrollPane);

        otherScrollPane.setForeground(new Color(255, 163, 114));

        otherTable.setBackground(new Color(67, 101, 139));
        otherTable.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        otherTable.setForeground(new Color(255, 163, 114));
        otherTable.setModel(otherTModel);
//        otherTable.setRowSorter(otherRowSorter);
        otherTable.setGridColor(new Color(255, 163, 114));
        otherScrollPane.setViewportView(otherTable);

        jTabbedPane1.addTab("Other", otherScrollPane);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 10);
        lowerMenu.add(jTabbedPane1, gridBagConstraints);

        jLabel11.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel11.setForeground(new Color(255, 163, 114));
        jLabel11.setText("Other Outcome:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        lowerMenu.add(jLabel11, gridBagConstraints);

        addOtherOutBtn.setBackground(new Color(67, 101, 139));
        addOtherOutBtn.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        addOtherOutBtn.setForeground(new Color(255, 163, 114));
        addOtherOutBtn.setText("Add Other Outcome");
        addOtherOutBtn.addActionListener(this::addOtherOutButtonActionPerformed);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(5, 10, 0, 10);
        lowerMenu.add(addOtherOutBtn, gridBagConstraints);

        otherOutcomeField.setColumns(13);
        otherOutcomeField.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        otherOutcomeField.setForeground(new Color(180, 180, 180));
        otherOutcomeField.setText("Description");
        otherOutcomeField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                otherOutcomeFieldFocusGained(evt);
            }
        });
        otherOutcomeField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent evt) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                otherOutcomeFieldKeyTyped(e);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(10, 5, 5, 0);
        lowerMenu.add(otherOutcomeField, gridBagConstraints);

        ooPriceField.setColumns(13);
        ooPriceField.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        ooPriceField.setForeground(new Color(180, 180, 180));
        ooPriceField.setText("Price");
        ooPriceField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                ooPriceFieldFocusGained(evt);
            }
        });
        ooPriceField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent evt) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                ooPriceFieldKeyTyped(e);

            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(10, 5, 0, 0);
        lowerMenu.add(ooPriceField, gridBagConstraints);

        ooPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        ooPriceLabel.setForeground(new Color(255, 163, 114));
        ooPriceLabel.setText("Other Outcome Price:  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        lowerMenu.add(ooPriceLabel, gridBagConstraints);

        jSeparator1.setBackground(new Color(255, 163, 114));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new Insets(0, 10, 0, 10);
        lowerMenu.add(jSeparator1, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        jPanel1.add(lowerMenu, gridBagConstraints);

        getContentPane().add(jPanel1, BorderLayout.CENTER);

        pack();
    }

    private void applyActionPerformed(ActionEvent evt) {
        String firstMonth;

        String firstDay;
        if (firstDatePicker.getModel().getDay()<10) {
            firstDay = 0+String.valueOf(firstDatePicker.getModel().getDay());
        }else{
            firstDay = String.valueOf(firstDatePicker.getModel().getDay());
        }

        if (firstDatePicker.getModel().getMonth()+1 < 10) {
            firstMonth = 0 + String.valueOf(firstDatePicker.getModel().getMonth() + 1);
        } else {
            firstMonth = String.valueOf(firstDatePicker.getModel().getMonth() + 1);
        }
        String firstYear = String.valueOf(firstDatePicker.getModel().getYear());


        String lastMonth;
        String lastDay;
        if (lastDatePicker.getModel().getDay()<10) {
            lastDay = 0+String.valueOf(lastDatePicker.getModel().getDay());
        }else{
            lastDay = String.valueOf(lastDatePicker.getModel().getDay());
        }
        if (lastDatePicker.getModel().getMonth() +1< 10) {
            lastMonth = 0+String.valueOf(lastDatePicker.getModel().getMonth() + 1);
        } else {
            lastMonth = String.valueOf(lastDatePicker.getModel().getMonth() + 1);
        }

        String lastYear = String.valueOf(lastDatePicker.getModel().getYear());

        String firstDate =  firstMonth+ "/" + firstDay + "/" + firstYear;
        String lastDate = lastMonth + "/" + lastDay + "/" + lastYear;
        System.out.println(firstDate);
        System.out.println(lastDate);
        fillTables(controller.getExtraBetweenDates(firstDate, lastDate), controller.getSaleBetweenDates(firstDate, lastDate));

    }


    private void mainMenuButtonActionPerformed(ActionEvent evt) {
        super.dispose();
    }

    private void clearButtonActionPerformed(ActionEvent evt) {
        firstDateSpinner.setModel(new SpinnerDateModel());
        lastDateSpinner.setModel(new SpinnerDateModel());
        fillTables(null, null);
    }

    private void addOtherOutButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        String desc = otherOutcomeField.getText();
        double price;
        try {
            price = Double.parseDouble(ooPriceField.getText());
            controller.addExtra(price, desc);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please fill all the necessary fields");
        }
        fillTables(null, null);
    }

    private void otherOutcomeFieldFocusGained(FocusEvent evt) {
        otherOutcomeField.setForeground(new Color(255, 163, 114));
        otherOutcomeField.setText("");
    }

    private void otherOutcomeFieldKeyTyped(KeyEvent evt) {
        otherOutcomeField.setForeground(new Color(255, 163, 114));
    }

    private void ooPriceFieldFocusGained(FocusEvent evt) {
        ooPriceField.setText("");
        ooPriceField.setForeground(new Color(255, 163, 114));
    }

    private void ooPriceFieldKeyTyped(KeyEvent evt) {
        ooPriceField.setForeground(new Color(255, 163, 114));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StatisticsFrame().setVisible(true));
    }
}