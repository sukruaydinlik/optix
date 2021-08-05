package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Database {

    private final SimpleDateFormat sdf;
    private final Timestamp timestamp;
    private ArrayList<ContactLens> lenses;
    private ArrayList<Customer> customers;
    private ArrayList<Extra> extras;
    private ArrayList<Frame> frames;
    private ArrayList<Glass> glasses;
    private ArrayList<PrescriptionCam> prescriptionCams;
    private ArrayList<PrescriptionLens> prescriptionLenses;
    private ArrayList<Sale> sales;
    private ArrayList<Special> specials;
    private ArrayList<Object> objects;

    private Connection con = null;
    private static String username = ""; // needed for login and changing password

    public Database() {

        sdf = new SimpleDateFormat("MM/dd/yyyy");
        timestamp = new Timestamp(System.currentTimeMillis());

        lenses = new ArrayList<ContactLens>();
        customers = new ArrayList<Customer>();
        extras = new ArrayList<Extra>();
        frames = new ArrayList<Frame>();
        glasses = new ArrayList<Glass>();
        prescriptionCams = new ArrayList<PrescriptionCam>();
        prescriptionLenses = new ArrayList<PrescriptionLens>();
        sales = new ArrayList<Sale>();
        specials = new ArrayList<Special>();
        objects = new ArrayList<Object>();
        getConnect();
        //System.out.println(sdf.format(timestamp));
    }

    public ArrayList<ContactLens> readContactLenses() throws SQLException {

        int id;
        String barcode;
        String diyoptri;
        String aks;
        String silindirik;
        String tarih;
        double alisFiyati;
        double satisFiyati;
        int quantity;

        if (con == null) {
            getConnect();
        }
        lenses.clear();

        PreparedStatement ps = con.prepareStatement("select * from contact_lenses");
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty

            // System.out.println("Empty result");
        } else {
            do {

                id = rs.getInt("id_contact");
                barcode = rs.getString("barcode");
                diyoptri = rs.getString("diyoptri");
                aks = rs.getString("aks");
                silindirik = rs.getString("silindirik");
                tarih = rs.getString("tarih");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                quantity = rs.getInt("quantity");

                ContactLens contactLens = new ContactLens(id, barcode, diyoptri, aks, silindirik, tarih, alisFiyati, satisFiyati, quantity);
                lenses.add(contactLens);
            } while (rs.next());
        }
        ps.close();
        rs.close();
        return lenses;
    }

    public ArrayList<Customer> readCustomers() throws SQLException {

        int id;
        String tcNo;
        String eklemeTarihi;
        String isim;
        String soyisim;
        String telefon;

        if (con == null) {
            getConnect();
        }

        customers.clear();

        PreparedStatement statement = con.prepareStatement("select * from customer");
        ResultSet rs = statement.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {

                id = rs.getInt("id_customer");
                tcNo = rs.getString("tckn");
                eklemeTarihi = rs.getString("tarih");
                isim = rs.getString("isim");
                soyisim = rs.getString("soyisim");
                telefon = rs.getString("telefon");

                Customer customer = new Customer(id, tcNo, eklemeTarihi, isim, soyisim, telefon);
                customers.add(customer);
            } while (rs.next());
        }
        statement.close();
        rs.close();

        return customers;
    }

    public ArrayList<Extra> readExtras() throws SQLException {

        int id;
        double satisFiyati;
        String ozelAdi;
        String eklemeTarihi;

        if (con == null) {
            getConnect();
        }
        extras.clear();
        PreparedStatement ps = con.prepareStatement("select * from extras");

        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            //  System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_extras");
                satisFiyati = rs.getDouble("fiyat");
                ozelAdi = rs.getString("aciklama");
                eklemeTarihi = rs.getString("ekleme_tarihi");

                Extra extra = new Extra(id, ozelAdi, eklemeTarihi, satisFiyati);
                extras.add(extra);
            } while (rs.next());
        }

        ps.close();
        rs.close();

        return extras;
    }

    public ArrayList<Frame> readFrames() throws SQLException {

        int id;
        String barcode;
        double alisFiyati;
        double satisFiyati;
        String renk;
        String marka;
        String model;
        String ekartman;
        String eklemeTarihi;
        String ozelAdi;
        int quantity;

        if (con == null) {
            getConnect();
        }
        frames.clear();

        PreparedStatement ps = con.prepareStatement("select * from frames");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            //   System.out.println("Empty result");
        } else {
            do {

                id = rs.getInt("id_frame");
                barcode = rs.getString("barcode");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                renk = rs.getString("renk");
                marka = rs.getString("marka");
                model = rs.getString("model");
                ekartman = rs.getString("ekartman");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                ozelAdi = rs.getString("ozel_adi");
                quantity = rs.getInt("quantity");

                Frame frame = new Frame(id, barcode, alisFiyati, satisFiyati, renk, marka, model, ozelAdi, ekartman,
                        eklemeTarihi, quantity);
                frames.add(frame);
            } while (rs.next());
        }

        ps.close();
        rs.close();

        return frames;
    }

    public ArrayList<Glass> readGlasses() throws SQLException {

        int id;
        String barcode;
        double alisFiyati;
        double satisFiyati;
        String tur;
        String marka;
        String indeks;
        String tarih;
        int quantity;

        if (con == null) {
            getConnect();
        }

        glasses.clear();

        PreparedStatement ps = con.prepareStatement("select * from glass");
        ResultSet rs = ps.executeQuery();


        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_glass");
                barcode = rs.getString("barcode");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                tur = rs.getString("tur");
                marka = rs.getString("marka");
                tarih = rs.getString("tarih");
                quantity = rs.getInt("quantity");
                indeks = rs.getString("indeks");
                Glass glass = new Glass(id, barcode, alisFiyati, satisFiyati, tur, marka, indeks, tarih, quantity);
                glasses.add(glass);
            } while (rs.next());
        }


        ps.close();
        rs.close();

        return glasses;
    }

    public ArrayList<PrescriptionCam> readPrescriptionsCam() throws SQLException {

        int id;
        String receteNo;
        String receteTarihi;
        String tarih;
        String rcBarcode;
        String rcSph;
        String rcCyl;
        String rcAx;
        String rcPd;
        String rcYukseklik;
        String lcBarcode;
        String lcSph;
        String lcCyl;
        String lcAx;
        String lcPd;
        String lcYukseklik;

        if (con == null) {
            getConnect();
        }

        prescriptionCams.clear();

        PreparedStatement ps = con.prepareStatement("select * from prescription_cam");
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_prescription");
                receteNo = rs.getString("recete_no");
                receteTarihi = rs.getString("recete_tarihi");
                tarih = rs.getString("tarih");
                rcBarcode = rs.getString("r_cam_barcode");
                rcSph = rs.getString("r_cam_sph");
                rcCyl = rs.getString("r_cam_cyl");
                rcAx = rs.getString("r_cam_ax");
                rcPd = rs.getString("r_cam_pd");
                rcYukseklik = rs.getString("r_cam_yukseklik");
                lcBarcode = rs.getString("l_cam_barcode");
                lcSph = rs.getString("l_cam_sph");
                lcCyl = rs.getString("l_cam_cyl");
                lcAx = rs.getString("l_cam_ax");
                lcPd = rs.getString("l_cam_pd");
                lcYukseklik = rs.getString("l_cam_yukseklik");


                PrescriptionCam prescription = new PrescriptionCam(id, receteNo, receteTarihi, tarih, rcBarcode, rcSph, rcCyl, rcAx, rcPd, rcYukseklik, lcBarcode, lcSph, lcCyl, lcAx, lcPd, lcYukseklik);
                prescriptionCams.add(prescription);

            } while (rs.next());
        }


        ps.close();
        rs.close();

        return prescriptionCams;
    }

    public ArrayList<PrescriptionLens> readPrescriptionLens() throws SQLException {

        int id;
        String receteNo;
        String receteTarihi;
        String tarih;
        String rlBarcode;
        String rlTemelEgri;
        String rlTumCap;
        String rlTorik;
        String rlMultifokal;
        String rlRenk;
        String rlOzelAd;
        String llBarcode;
        String llTemelEgri;
        String llTumCap;
        String llTorik;
        String llMultifokal;
        String llRenk;
        String llOzelAd;

        if (con == null) {
            getConnect();
        }

        prescriptionLenses.clear();

        PreparedStatement ps = con.prepareStatement("select * from prescription_lens");
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_presc_lens");
                receteNo = rs.getString("recete_no");
                receteTarihi = rs.getString("recete_tarihi");
                tarih = rs.getString("tarih");
                rlBarcode = rs.getString("r_lens_barcode");
                rlTemelEgri = rs.getString("r_lens_temel_egri");
                rlTumCap = rs.getString("r_lens_tum_cap");
                rlTorik = rs.getString("r_lens_torik");
                rlMultifokal = rs.getString("r_lens_multifokal");
                rlRenk = rs.getString("r_lens_renk");
                rlOzelAd = rs.getString("r_lens_ozel_ad");
                llBarcode = rs.getString("l_lens_barcode");
                llTemelEgri = rs.getString("l_lens_temel_egri");
                llTumCap = rs.getString("l_lens_tum_cap");
                llTorik = rs.getString("l_lens_torik");
                llMultifokal = rs.getString("l_lens_multifokal");
                llRenk = rs.getString("l_lens_renk");
                llOzelAd = rs.getString("l_lens_ozel_ad");

                PrescriptionLens prescriptionLens = new PrescriptionLens(id, receteNo, receteTarihi, tarih, rlBarcode, rlTemelEgri, rlTumCap, rlTorik, rlMultifokal, rlRenk, rlOzelAd, llBarcode, llTemelEgri, llTumCap, llTorik, llMultifokal, llRenk, llOzelAd);
                prescriptionLenses.add(prescriptionLens);

            } while (rs.next());
        }


        ps.close();
        rs.close();

        return prescriptionLenses;
    }


    public ArrayList<Sale> readSales() throws SQLException {

        int id;
        double toplamFiyat;
        String tarih;
        String tcNo;
        String camReceteNo;
        String lensReceteNo;
        double sgk;
        double kart;
        double nakit;

        if (con == null) {
            getConnect();
        }

        sales.clear();

        PreparedStatement ps = con.prepareStatement("select * from sale");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_sale");
                toplamFiyat = rs.getDouble("toplam_fiyat");
                tarih = rs.getString("tarih");
                tcNo = rs.getString("tc_no");
                camReceteNo = rs.getString("cam_recete_no");
                lensReceteNo = rs.getString("lens_recete_no");
                sgk = rs.getDouble("sgk");
                kart = rs.getDouble("kart");
                nakit = rs.getDouble("nakit");

                Sale sale = new Sale(id, toplamFiyat, tarih, tcNo, camReceteNo, lensReceteNo, sgk, kart, nakit);
                sales.add(sale);
            } while (rs.next());
        }

        ps.close();
        rs.close();
        return sales;
    }

    public ArrayList<Special> readSpecials() throws SQLException {

        int id;
        String barcode;
        double alisFiyati;
        double satisFiyati;
        String urunAdi;
        String eklemeTarihi;
        int quantity;

        if (con == null) {
            getConnect();
        }
        specials.clear();
        PreparedStatement ps = con.prepareStatement("select * from special");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_special");
                barcode = rs.getString("barcode");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                urunAdi = rs.getString("urun_adi");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                quantity = rs.getInt("quantity");

                Special special = new Special(id, barcode, alisFiyati, satisFiyati, urunAdi, eklemeTarihi, quantity);
                specials.add(special);
            } while (rs.next());
        }

        ps.close();
        rs.close();

        return specials;
    }


    public void writeContactLens(String barcode, String diyoptri, String aks, String silindirik, double alisFiyati,
                                 double satisFiyati, int quantity) throws SQLException {

        if (con == null) {
            getConnect();
        }

        // if it is already in, then update
        if (searchContactLens(barcode).isEmpty()) {

            PreparedStatement ps = con.prepareStatement("insert into contact_lenses(barcode,diyoptri,aks,silindirik," +
                    "alis_fiyati,satis_fiyati,quantity,tarih) values(?,?,?,?,?,?,?,?)");

            ps.setString(1, barcode);
            ps.setString(2, diyoptri);
            ps.setString(3, aks);
            ps.setString(4, silindirik);
            ps.setDouble(5, alisFiyati);
            ps.setDouble(6, satisFiyati);
            ps.setDouble(7, quantity);
            ps.setString(8, sdf.format(timestamp));
            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            ps.close();

        } else {
            updateLensQuantity(barcode, quantity);
            System.out.println("Lens already exists, so i am updating quantity");
        }

    }

    public void writeCustomer(String tcno, String isim, String soyisim, String telefon) throws SQLException {

        if (con == null) {
            getConnect();
        }
        if (searchCustomers(tcno).isEmpty()) {
            PreparedStatement ps = con.prepareStatement("insert into customer(tckn, isim, soyisim, telefon,tarih)" +
                    " values(?,?,?,?,?)");
            ps.setString(1, tcno);
            ps.setString(2, isim);
            ps.setString(3, soyisim);
            ps.setString(4, telefon);
            ps.setString(5, sdf.format(timestamp));

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } else {
            // TODO: customer is already in there, so deal with it
            System.out.println("Customer already exists");
        }
    }

    public void writeExtra(double satisFiyati, String ozelAdi) throws SQLException {
        if (con == null) {
            getConnect();
        }

        PreparedStatement ps = con.prepareStatement("insert into extras(aciklama, fiyat, ekleme_tarihi)" +
                " values(?,?,?)");
        ps.setString(1, ozelAdi);
        ps.setDouble(2, satisFiyati);
        ps.setString(3, sdf.format(timestamp));

        try {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ps.close();

    }

    public void writeFrame(String barcode, String marka, String model, String ekartman, String renk, double alisFiyati,
                           double satisFiyati, String ozelAdi, int quantity) throws SQLException {
        if (con == null) {
            getConnect();
        }

        if (searchFrames(barcode).isEmpty()) {
            PreparedStatement ps = con.prepareStatement(
                    "insert into frames(barcode,marka,model,ekartman,renk,alis_fiyati,satis_fiyati,ozel_adi," +
                            "quantity, ekleme_tarihi) values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, barcode);
            ps.setString(2, marka);
            ps.setString(3, model);
            ps.setString(4, ekartman);
            ps.setString(5, renk);
            ps.setDouble(6, alisFiyati);
            ps.setDouble(7, satisFiyati);
            ps.setString(8, ozelAdi);
            ps.setInt(9, quantity);
            ps.setString(10, sdf.format(timestamp));

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } else {
            System.out.println("Frame already exists, so i am updating quantity");
            updateFrameQuantity(barcode, quantity);
        }

    }

    public void writeGlass(String barcode, double alisFiyati, double satisFiyati, String tur, String marka,
                           String indeks, int quantity) throws SQLException {
        if (con == null) {
            getConnect();
        }

        if (searchGlasses(barcode).isEmpty()) {
            PreparedStatement ps = con.prepareStatement(
                    "insert into glass(barcode, alis_fiyati, satis_fiyati, tur, marka, indeks, quantity, tarih) values(?,?,?,?,?,?,?,?)");

            ps.setString(1, barcode);
            ps.setDouble(2, alisFiyati);
            ps.setDouble(3, satisFiyati);
            ps.setString(4, tur);
            ps.setString(5, marka);
            ps.setString(6, indeks);
            ps.setInt(7, quantity);
            ps.setString(8, sdf.format(timestamp));

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } else {
            System.out.println("Glass already exists, so i am updating quantity");
            updateGlassQuantity(barcode, quantity);
        }

    }

    public void writePrescriptionLens(String receteNo, String receteTarihi, String tarih, String rlBarcode,
                                      String rlTemelEgri, String rlTumCap, String rlTorik, String rlMultifokal,
                                      String rlRenk, String rlOzelAd, String llBarcode, String llTemelEgri,
                                      String llTumCap, String llTorik, String llMultifokal, String llRenk,
                                      String llOzelAd) throws SQLException {
        if (con == null) {
            getConnect();
        }
        if (searchPrescriptionLens(receteNo).isEmpty()) {
            PreparedStatement ps = con.prepareStatement(
                    "insert into prescription_lens(recete_no,recete_tarihi,tarih,r_lens_barcode,r_lens_temel_egri," +
                            "r_lens_tum_cap,r_lens_torik,r_lens_multifokal,r_lens_renk,r_lens_ozel_ad,l_lens_barcode," +
                            "l_lens_temel_egri,l_lens_tum_cap,l_lens_torik,l_lens_multifokal,l_lens_renk,l_lens_ozel_ad)" +
                            " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, receteNo);
            ps.setString(2, receteTarihi);
            ps.setString(3, tarih);
            ps.setString(4, rlBarcode);
            ps.setString(5, rlTemelEgri);
            ps.setString(6, rlTumCap);
            ps.setString(7, rlTorik);
            ps.setString(8, rlMultifokal);
            ps.setString(9, rlRenk);
            ps.setString(10, rlOzelAd);
            ps.setString(11, llBarcode);
            ps.setString(12, llTemelEgri);
            ps.setString(13, llTumCap);
            ps.setString(14, llTorik);
            ps.setString(15, llMultifokal);
            ps.setString(16, llRenk);
            ps.setString(17, llOzelAd);

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } else {
            // TODO: it is already in there
            System.out.println("Prescription Lens already exists, doing nothing");
        }
    }

    public void writePrescriptionCam(String receteNo, String receteTarihi, String tarih, String rcBarcode, String rcSph,
                                     String rcCyl, String rcAx, String rcPd, String rcYukseklik, String lcBarcode,
                                     String lcSph, String lcCyl, String lcAx, String lcPd, String lcYukseklik) throws
            SQLException {
        if (con == null) {
            getConnect();
        }
        if (searchPrescriptionCam(receteNo).isEmpty()) {
            PreparedStatement ps = con.prepareStatement(
                    "insert into prescription_cam(recete_no,recete_tarihi,tarih,r_cam_barcode, l_cam_barcode, r_cam_sph," +
                            " l_cam_sph, r_cam_cyl, l_cam_cyl, r_cam_ax, l_cam_ax, r_cam_pd, l_cam_pd, r_cam_yukseklik, " +
                            "l_cam_yukseklik)" +
                            " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, receteNo);
            ps.setString(2, receteTarihi);
            ps.setString(3, tarih);
            ps.setString(4, rcBarcode);
            ps.setString(5, lcBarcode);
            ps.setString(6, rcSph);
            ps.setString(7, lcSph);
            ps.setString(8, rcCyl);
            ps.setString(9, lcCyl);
            ps.setString(10, rcAx);
            ps.setString(11, lcAx);
            ps.setString(12, rcPd);
            ps.setString(13, lcPd);
            ps.setString(14, rcYukseklik);
            ps.setString(15, lcYukseklik);

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } else {
            // TODO: it is already in there
            System.out.println("Prescription Cam already exists, doing nothing");
        }
    }

    public void writeRecord(String productBarcode, int saleId) throws SQLException {
        if (con == null) {
            getConnect();
        }
        PreparedStatement ps = con.prepareStatement("insert into record(product_barcode,sale_id) values(?,?)");
        // TODO: check record
        ps.setString(1, productBarcode);
        ps.setInt(2, saleId);

        try {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ps.close();
    }

    public void writeSale(double toplamFiyat, String tarih, String tcNo, String camReceteNo, String lensReceteNo,
                          double sgk, double kart, double nakit) throws SQLException {
        if (con == null) {
            getConnect();
        }
        PreparedStatement ps = con.prepareStatement("insert into sale(tarih, tc_no, toplam_fiyat, nakit, kart, sgk, " +
                "lens_recete_no, cam_recete_no) values(?,?,?,?,?,?,?,?)");

        ps.setString(1, sdf.format(timestamp));
        ps.setString(2, tcNo);
        ps.setDouble(3, toplamFiyat);
        ps.setDouble(4, nakit);
        ps.setDouble(5, kart);
        ps.setDouble(6, sgk);
        ps.setString(7, lensReceteNo);
        ps.setString(8, camReceteNo);

        try {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ps.close();
    }

    public void writeSpecial(String barcode, String urunAdi, double alisFiyati, double satisFiyati, int quantity)
            throws SQLException {
        if (con == null) {
            getConnect();
        }
        if (searchSpecials(barcode).isEmpty()) {
            PreparedStatement ps = con.prepareStatement(
                    "insert into special(barcode,urun_adi,alis_fiyati,satis_fiyati,quantity,ekleme_tarihi) values(?,?,?,?,?,?)");
            ps.setString(1, barcode);
            ps.setString(2, urunAdi);
            ps.setDouble(3, alisFiyati);
            ps.setDouble(4, satisFiyati);
            ps.setInt(5, quantity);
            ps.setString(6, sdf.format(timestamp));

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } else {
            System.out.println("Lens already exists, so i am updating quantity");
            updateSpecialQuantity(barcode, quantity);
        }

    }

    public boolean login(String tempID, String tempPass) {
        String dbId;
        String dbPass;
        if (con == null) {
            getConnect();
        }
        username = tempID;
        try {
            PreparedStatement ps = con.prepareStatement("select * from user");
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                ps.close();
                rs.close();
                return false;
            } else {
                do {
                    dbId = rs.getString("kullanici_adi");
                    dbPass = rs.getString("password");

                    if (tempID.equals(dbId) && tempPass.equals(dbPass)) {
                        username = tempID;
                        return true;
                    }
                } while (rs.next());
            }

            ps.close();
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public ArrayList<ContactLens> searchContactLens(String searchBarcode) throws SQLException {

        int id;
        String barcode;
        String diyoptri;
        String aks;
        String silindirik;
        String tarih;
        double alisFiyati;
        double satisFiyati;
        int quantity;

        if (con == null) {
            getConnect();
        }
        lenses.clear();


        PreparedStatement ps = con.prepareStatement("select * from contact_lenses where barcode='" + searchBarcode
                + "'");
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty

            // System.out.println("Empty result");
        } else {
            do {

                id = rs.getInt("id_contact");
                barcode = rs.getString("barcode");
                diyoptri = rs.getString("diyoptri");
                aks = rs.getString("aks");
                silindirik = rs.getString("silindirik");
                tarih = rs.getString("tarih");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                quantity = rs.getInt("quantity");

                ContactLens contactLens = new ContactLens(id, barcode, diyoptri, aks, silindirik, tarih, alisFiyati, satisFiyati, quantity);
                lenses.add(contactLens);
            } while (rs.next());
        }
        ps.close();
        rs.close();
        return lenses;

    }

    public ArrayList<Customer> searchCustomers(String tckn) throws SQLException {


        int id;
        String tcNo;
        String eklemeTarihi;
        String isim;
        String soyisim;
        String telefon;

        if (con == null) {
            getConnect();
        }

        customers.clear();

        PreparedStatement statement = con.prepareStatement("select * from customer where tckn = ?");
        statement.setString(1, tckn);
        ResultSet rs = statement.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {

                id = rs.getInt("id_customer");
                tcNo = rs.getString("tckn");
                eklemeTarihi = rs.getString("tarih");
                isim = rs.getString("isim");
                soyisim = rs.getString("soyisim");
                telefon = rs.getString("telefon");

                Customer customer = new Customer(id, tcNo, eklemeTarihi, isim, soyisim, telefon);
                customers.add(customer);
            } while (rs.next());
        }
        statement.close();
        rs.close();

        return customers;
    }

    public ArrayList<Frame> searchFrames(String searchBarcode) throws SQLException {

        int id;
        String barcode;
        double alisFiyati;
        double satisFiyati;
        String renk;
        String marka;
        String model;
        String ekartman;
        String eklemeTarihi;
        String ozelAdi;
        int quantity;

        if (con == null) {
            getConnect();
        }
        frames.clear();
        PreparedStatement ps = con.prepareStatement("select * from frames where barcode='" + searchBarcode + "'");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            //   System.out.println("Empty result");
        } else {
            do {

                id = rs.getInt("id_frame");
                barcode = rs.getString("barcode");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                renk = rs.getString("renk");
                marka = rs.getString("marka");
                model = rs.getString("model");
                ekartman = rs.getString("ekartman");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                ozelAdi = rs.getString("ozel_adi");
                quantity = rs.getInt("quantity");

                Frame frame = new Frame(id, barcode, alisFiyati, satisFiyati, renk, marka, model, ozelAdi, ekartman,
                        eklemeTarihi, quantity);
                frames.add(frame);
            } while (rs.next());
        }

        ps.close();
        rs.close();

        return frames;
    }

    public ArrayList<Glass> searchGlasses(String searchBarcode) throws SQLException {

        int id;
        String barcode;
        double alisFiyati;
        double satisFiyati;
        String tur;
        String marka;
        String indeks;
        String tarih;
        int quantity;

        if (con == null) {
            getConnect();
        }

        glasses.clear();

        PreparedStatement ps = con.prepareStatement("select * from glass where barcode ='" + searchBarcode + "'");
        ResultSet rs = ps.executeQuery();


        if (!rs.next()) {
            //
        } else {
            do {
                id = rs.getInt("id_glass");
                barcode = rs.getString("barcode");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                tur = rs.getString("tur");
                marka = rs.getString("marka");
                tarih = rs.getString("tarih");
                quantity = rs.getInt("quantity");
                indeks = rs.getString("indeks");
                Glass glass = new Glass(id, barcode, alisFiyati, satisFiyati, tur, marka, indeks, tarih, quantity);
                glasses.add(glass);
            } while (rs.next());
        }


        ps.close();
        rs.close();

        return glasses;
    }

    public ArrayList<PrescriptionCam> searchPrescriptionCam(String searchReceteNo) throws SQLException {

        int id;
        String receteNo;
        String receteTarihi;
        String tarih;
        String rcBarcode;
        String rcSph;
        String rcCyl;
        String rcAx;
        String rcPd;
        String rcYukseklik;
        String lcBarcode;
        String lcSph;
        String lcCyl;
        String lcAx;
        String lcPd;
        String lcYukseklik;

        if (con == null) {
            getConnect();
        }

        prescriptionCams.clear();

        PreparedStatement ps = con.prepareStatement("select * from prescription_cam where recete_no = '"
                + searchReceteNo + "'");
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_prescription");
                receteNo = rs.getString("recete_no");
                receteTarihi = rs.getString("recete_tarihi");
                tarih = rs.getString("tarih");
                rcBarcode = rs.getString("r_cam_barcode");
                rcSph = rs.getString("r_cam_sph");
                rcCyl = rs.getString("r_cam_cyl");
                rcAx = rs.getString("r_cam_ax");
                rcPd = rs.getString("r_cam_pd");
                rcYukseklik = rs.getString("r_cam_yukseklik");
                lcBarcode = rs.getString("l_cam_barcode");
                lcSph = rs.getString("l_cam_sph");
                lcCyl = rs.getString("l_cam_cyl");
                lcAx = rs.getString("l_cam_ax");
                lcPd = rs.getString("l_cam_pd");
                lcYukseklik = rs.getString("l_cam_yukseklik");


                PrescriptionCam prescription = new PrescriptionCam(id, receteNo, receteTarihi, tarih, rcBarcode, rcSph, rcCyl, rcAx, rcPd, rcYukseklik, lcBarcode, lcSph, lcCyl, lcAx, lcPd, lcYukseklik);
                prescriptionCams.add(prescription);

            } while (rs.next());
        }


        ps.close();
        rs.close();

        return prescriptionCams;
    }

    public ArrayList<PrescriptionLens> searchPrescriptionLens(String searchReceteNo) throws SQLException {

        int id;
        String receteNo;
        String receteTarihi;
        String tarih;
        String rlBarcode;
        String rlTemelEgri;
        String rlTumCap;
        String rlTorik;
        String rlMultifokal;
        String rlRenk;
        String rlOzelAd;
        String llBarcode;
        String llTemelEgri;
        String llTumCap;
        String llTorik;
        String llMultifokal;
        String llRenk;
        String llOzelAd;

        if (con == null) {
            getConnect();
        }

        prescriptionLenses.clear();

        PreparedStatement ps = con.prepareStatement("select * from prescription_lens where recete_no = ?");
        ps.setString(1, searchReceteNo);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_presc_lens");
                receteNo = rs.getString("recete_no");
                receteTarihi = rs.getString("recete_tarihi");
                tarih = rs.getString("tarih");
                rlBarcode = rs.getString("r_lens_barcode");
                rlTemelEgri = rs.getString("r_lens_temel_egri");
                rlTumCap = rs.getString("r_lens_tum_cap");
                rlTorik = rs.getString("r_lens_torik");
                rlMultifokal = rs.getString("r_lens_multifokal");
                rlRenk = rs.getString("r_lens_renk");
                rlOzelAd = rs.getString("r_lens_ozel_ad");
                llBarcode = rs.getString("l_lens_barcode");
                llTemelEgri = rs.getString("l_lens_temel_egri");
                llTumCap = rs.getString("l_lens_tum_cap");
                llTorik = rs.getString("l_lens_torik");
                llMultifokal = rs.getString("l_lens_multifokal");
                llRenk = rs.getString("l_lens_renk");
                llOzelAd = rs.getString("l_lens_ozel_ad");

                PrescriptionLens prescriptionLens = new PrescriptionLens(id, receteNo, receteTarihi, tarih, rlBarcode, rlTemelEgri, rlTumCap, rlTorik, rlMultifokal, rlRenk, rlOzelAd, llBarcode, llTemelEgri, llTumCap, llTorik, llMultifokal, llRenk, llOzelAd);
                prescriptionLenses.add(prescriptionLens);

            } while (rs.next());
        }


        ps.close();
        rs.close();

        return prescriptionLenses;
    }

    public ArrayList<Sale> searchSales(int saleId) throws SQLException {

        int id;
        double toplamFiyat;
        String tarih;
        String tcNo;
        String camReceteNo;
        String lensReceteNo;
        double sgk;
        double kart;
        double nakit;

        if (con == null) {
            getConnect();
        }

        sales.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM sale WHERE id_sale =  '" + saleId + "'");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_sale");
                toplamFiyat = rs.getDouble("toplam_fiyat");
                tarih = rs.getString("tarih");
                tcNo = rs.getString("tc_no");
                camReceteNo = rs.getString("cam_recete_no");
                lensReceteNo = rs.getString("lens_recete_no");
                sgk = rs.getDouble("sgk");
                kart = rs.getDouble("kart");
                nakit = rs.getDouble("nakit");

                Sale sale = new Sale(id, toplamFiyat, tarih, tcNo, camReceteNo, lensReceteNo, sgk, kart, nakit);
                sales.add(sale);
            } while (rs.next());
        }

        ps.close();
        rs.close();
        return sales;
    }

    public ArrayList<Integer> searchSale(String tckn) throws SQLException {
        int barcode;
        ArrayList<Integer> resultArray = new ArrayList<Integer>();

        if (con == null) {
            getConnect();
        }

        PreparedStatement ps = con.prepareStatement("select id_sale from sale where tc_no = '" + tckn + "'");
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                barcode = rs.getInt("id_sale");
                resultArray.add(barcode);

            } while (rs.next());
        }

        ps.close();
        rs.close();

        return resultArray;
    }

    public ArrayList<Special> searchSpecials(String searchBarcode) throws SQLException {


        int id;
        String barcode;
        double alisFiyati;
        double satisFiyati;
        String urunAdi;
        String eklemeTarihi;
        int quantity;

        if (con == null) {
            getConnect();
        }
        specials.clear();
        PreparedStatement ps = con.prepareStatement("select * from special where barcode ='" + searchBarcode + "'");

        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_special");
                barcode = rs.getString("barcode");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                urunAdi = rs.getString("urun_adi");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                quantity = rs.getInt("quantity");

                Special special = new Special(id, barcode, alisFiyati, satisFiyati, urunAdi, eklemeTarihi, quantity);
                specials.add(special);
            } while (rs.next());
        }

        ps.close();
        rs.close();

        return specials;
    }


    public ArrayList<Object> searchAll(String searchBarcode) throws Exception {
        if (con == null) {
            getConnect();
        }

        objects.clear();
        if (!searchContactLens(searchBarcode).isEmpty()) {
            for (int i = 0; i < searchContactLens(searchBarcode).size(); i++) {
                objects.add(lenses.get(i));
            }
        }
        if (!searchFrames(searchBarcode).isEmpty()) {
            for (int i = 0; i < searchFrames(searchBarcode).size(); i++) {
                objects.add(frames.get(i));
            }
        }
        if (!searchGlasses(searchBarcode).isEmpty()) {
            for (int i = 0; i < searchGlasses(searchBarcode).size(); i++) {
                objects.add(glasses.get(i));
            }
        }
        if (!searchSpecials(searchBarcode).isEmpty()) {
            for (int i = 0; i < searchSpecials(searchBarcode).size(); i++) {
                objects.add(specials.get(i));
            }
        }
        return objects;
    }

    public String searchType(String barcode) throws SQLException {
        if (con == null) {
            getConnect();
        }
        String tableName = "Null";
        objects.clear();

        for (int i = 0; i < searchContactLens(barcode).size(); i++) {
            objects.add(lenses.get(i));
        }
        for (int i = 0; i < searchFrames(barcode).size(); i++) {
            objects.add(frames.get(i));
        }
        for (int i = 0; i < searchGlasses(barcode).size(); i++) {
            objects.add(glasses.get(i));
        }
        for (int i = 0; i < searchSpecials(barcode).size(); i++) {
            objects.add(specials.get(i));
        }
        if (!objects.isEmpty()) {
            tableName = objects.get(0).getClass().getSimpleName();
        }
        return tableName;
    }

    public ArrayList<String> searchRecords(int saleId) throws SQLException {

        String productBarcode;
        ArrayList<String> resultArray = new ArrayList<String>();

        if (con == null) {
            getConnect();
        }


        PreparedStatement ps = con.prepareStatement("SELECT * FROM record WHERE sale_id = '" + saleId + "'");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO:
        } else {
            do {
                productBarcode = rs.getString("product_barcode");
                resultArray.add(productBarcode);

            } while (rs.next());
        }

        ps.close();
        rs.close();
        return resultArray;
    }

    public ArrayList<String> searchItemRecords(String barcode) throws SQLException {

        String productBarcode;
        ArrayList<String> resultArray = new ArrayList<String>();

        if (con == null) {
            getConnect();
        }


        PreparedStatement ps = con.prepareStatement("SELECT * FROM record WHERE product_barcode = '" + barcode + "';");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO:
        } else {
            do {
                productBarcode = rs.getString("product_barcode");
                resultArray.add(productBarcode);

            } while (rs.next());
        }

        ps.close();
        rs.close();
        return resultArray;
    }

    public ArrayList<Extra> searchExtraBetween(String firstDate, String lastDate) throws SQLException {

        int id;
        String barcode;
        double satisFiyati;
        String ozelAdi;
        String eklemeTarihi;

        if (con == null) {
            getConnect();
        }

        extras.clear();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM extras WHERE ekleme_tarihi BETWEEN ? AND ? ");
        ps.setString(1, firstDate);
        ps.setString(2, lastDate);

        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO:
        } else {
            do {
                id = rs.getInt("id_extras");
                // barcode = rs.getString("barcode");
                satisFiyati = rs.getDouble("fiyat");
                ozelAdi = rs.getString("aciklama");
                eklemeTarihi = rs.getString("ekleme_tarihi");

                Extra extra = new Extra(id, ozelAdi, eklemeTarihi, satisFiyati);

                extras.add(extra);

            } while (rs.next());
        }

        ps.close();
        rs.close();
        return extras;

    }

    public ArrayList<Sale> searchSaleByPresc(int presc) throws SQLException {

        int id;
        double toplamFiyat;
        String tarih;
        String tcNo;
        String camReceteNo;
        String lensReceteNo;
        double sgk;
        double kart;
        double nakit;

        if (con == null) {
            getConnect();
        }

        sales.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM sale where lens_recete_no = '" + presc + "' or cam_recete_no = '" + presc + "';");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            do {
                id = rs.getInt("id_sale");
                toplamFiyat = rs.getDouble("toplam_fiyat");
                tarih = rs.getString("tarih");
                tcNo = rs.getString("tc_no");
                camReceteNo = rs.getString("cam_recete_no");
                lensReceteNo = rs.getString("lens_recete_no");
                sgk = rs.getDouble("sgk");
                kart = rs.getDouble("kart");
                nakit = rs.getDouble("nakit");

                Sale sale = new Sale(id, toplamFiyat, tarih, tcNo, camReceteNo, lensReceteNo, sgk, kart, nakit);
                sales.add(sale);
            } while (rs.next());
        }

        ps.close();
        rs.close();
        return sales;
    }

    public ArrayList<Sale> searchSaleBetween(String firstDate, String lastDate) throws SQLException {
        int id;
        double toplamFiyat;
        String tarih;
        String tcNo;
        String camReceteNo;
        String lensReceteNo;
        double sgk;
        double kart;
        double nakit;

        if (con == null) {
            getConnect();
        }

        sales.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM sale WHERE tarih BETWEEN ? AND ? ");
        ps.setString(1, firstDate);
        ps.setString(2, lastDate);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            do {
                id = rs.getInt("id_sale");
                toplamFiyat = rs.getDouble("toplam_fiyat");
                tarih = rs.getString("tarih");
                tcNo = rs.getString("tc_no");
                camReceteNo = rs.getString("cam_recete_no");
                lensReceteNo = rs.getString("lens_recete_no");
                sgk = rs.getDouble("sgk");
                kart = rs.getDouble("kart");
                nakit = rs.getDouble("nakit");

                Sale sale = new Sale(id, toplamFiyat, tarih, tcNo, camReceteNo, lensReceteNo, sgk, kart, nakit);
                sales.add(sale);
            } while (rs.next());
        }

        ps.close();
        rs.close();
        return sales;


    }


    public void updateLensQuantity(String barcode, int quantity) throws SQLException {
        if (con == null) {
            getConnect();
        }
        PreparedStatement ps = con.prepareStatement("UPDATE contact_lenses SET quantity = (quantity + ?) WHERE " +
                "barcode = ?;");
        ps.setInt(1, quantity);
        ps.setString(2, barcode);

        ps.executeUpdate();
        ps.close();
    }

    public void updateFrameQuantity(String barcode, int quantity) throws SQLException {
        if (con == null) {
            getConnect();
        }
        PreparedStatement ps = con.prepareStatement("UPDATE frames SET quantity = (quantity + ? ) WHERE barcode = ?;");

        ps.setInt(1, quantity);
        ps.setString(2, barcode);

        ps.executeUpdate();
        ps.close();
    }

    public void updateGlassQuantity(String barcode, int quantity) throws SQLException {
        if (con == null) {
            getConnect();
        }
        PreparedStatement ps = con.prepareStatement("UPDATE glass SET quantity = (quantity + ? ) WHERE barcode = ?;");
        ps.setInt(1, quantity);
        ps.setString(2, barcode);

        ps.executeUpdate();
        ps.close();
    }

    public void updateSpecialQuantity(String barcode, int quantity) throws SQLException {
        if (con == null) {
            getConnect();
        }
        PreparedStatement ps = con.prepareStatement("UPDATE special SET quantity = (quantity + ? ) WHERE barcode = ?;");
        ps.setInt(1, quantity);
        ps.setString(2, barcode);

        ps.executeUpdate();
        ps.close();
    }

    public int updatePassword(String oldpass, String newPass) throws SQLException {
        int affectedRowCnt = 0;

        if (con == null) {
            getConnect();
        }
        System.out.println("username is "+username);
        PreparedStatement ps = con.prepareStatement("UPDATE user SET password = ? WHERE kullanici_adi = ? and password = ?;");
        ps.setString(1, newPass);
        ps.setString(2, username);
        ps.setString(3, oldpass);

        affectedRowCnt = ps.executeUpdate();
        ps.close();

        return affectedRowCnt;
    }


    public int deleteLens(String barcode) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            getConnect();
        }
        if (searchContactLens(barcode).isEmpty()) {
            // TODO: empty result
        } else {
            PreparedStatement ps = con.prepareStatement("DELETE FROM contact_lenses WHERE barcode = ?");
            ps.setString(1, barcode);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteCustomer(String tckn) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            getConnect();
        }
        if (searchCustomers(tckn).isEmpty()) {
            // TODO: empty result

        } else {
            PreparedStatement ps = con.prepareStatement("DELETE FROM customer WHERE tckn = ?");
            ps.setString(1, tckn);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteExtra(int id) throws SQLException {
        int affectedRowCnt;
        if (con == null) {
            getConnect();
        }

        // TODO: no method to search extra by id, so it does not check
        PreparedStatement ps = con.prepareStatement("DELETE FROM extras WHERE id_extras = ?");
        ps.setInt(1, id);
        affectedRowCnt = ps.executeUpdate();
        ps.close();
        return affectedRowCnt;
    }

    public int deleteFrame(String barcode) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            getConnect();
        }
        if (searchFrames(barcode).isEmpty()) {
            // TODO: empty result

        } else {

            PreparedStatement ps = con.prepareStatement("DELETE FROM frames WHERE barcode = ?");
            ps.setString(1, barcode);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteGlass(String barcode) throws SQLException {
        int affectedRowCnt = 0;

        if (con == null) {
            getConnect();
        }
        if (searchGlasses(barcode).isEmpty()) {
            // TODO: empty result

        } else {

            PreparedStatement ps = con.prepareStatement("DELETE FROM glass WHERE barcode = ?");
            ps.setString(1, barcode);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deletePrescriptionCam(String receteNo) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            getConnect();
        }
        if (searchPrescriptionCam(receteNo).isEmpty()) {
            // TODO: empty result

        } else {

            PreparedStatement ps = con.prepareStatement("DELETE FROM prescription_cam WHERE recete_no = ?");
            ps.setString(1, receteNo);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deletePrescriptionLens(String receteNo) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            getConnect();
        }
        if (searchPrescriptionLens(receteNo).isEmpty()) {
            // TODO: empty result

        } else {

            PreparedStatement ps = con.prepareStatement("DELETE FROM prescription_lens WHERE recete_no = ?");
            ps.setString(1, receteNo);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteRecord(int saleId) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            getConnect();
        }
        if (searchRecords(saleId).isEmpty()) {
            // TODO: empty result

        } else {


            PreparedStatement ps = con.prepareStatement("DELETE FROM record WHERE sale_id = ?");
            ps.setInt(1, saleId);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteSale(int saleId) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            getConnect();
        }
        if (searchSales(saleId).isEmpty()) {
            // TODO: empty result
        } else {
            PreparedStatement ps = con.prepareStatement("DELETE FROM sale WHERE id_sale = ?");
            ps.setInt(1, saleId);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteSpecial(String barcode) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            getConnect();
        }
        if (searchSpecials(barcode).isEmpty()) {
            // TODO: empty result
        } else {

            PreparedStatement ps = con.prepareStatement("DELETE FROM special WHERE barcode = ?");
            ps.setString(1, barcode);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int readLastSaleId() throws Exception {
        if (con == null) {
            getConnect();
        }
        PreparedStatement ps = con.prepareStatement("SELECT max(id_sale) as id_sale FROM sale");
        ResultSet rs = ps.executeQuery();
        int result = rs.getInt("id_sale");
        ps.close();
        rs.close();

        return result;
    }

    public void getConnect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "1234");

           // System.out.println("Connected to database");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
