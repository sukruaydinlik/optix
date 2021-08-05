package controller;

import model.*;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {

    static Database db;

    public Controller() {
        db = new Database();
    }

    public void addContactLens(String barcode, String diyoptri, String aks, String silindirik, double alisFiyati,
                               double satisFiyati, int quantity) {
        try {
            db.writeContactLens(barcode, diyoptri, aks, silindirik, alisFiyati, satisFiyati, quantity);
        } catch (SQLException throwables) {
            System.out.println("Unable to write lens");
        }
    }

    public void addCustomer(String tcno, String isim, String soyisim, String telefon) {
        try {
            db.writeCustomer(tcno, isim, soyisim, telefon);
        } catch (SQLException throwables) {
            System.out.println("Unable to write customer");
        }
    }

    public void addExtra(double satisFiyati, String ozelAdi) {
        try {
            db.writeExtra(satisFiyati, ozelAdi);
        } catch (SQLException throwables) {
            System.out.println("Unable to write extra");
        }
    }

    public void addFrame(String barcode, String marka, String model, String ekartman, String renk, double alisFiyati,
                         double satisFiyati, String ozelAdi, int quantity) {
        try {
            db.writeFrame(barcode, marka, model, ekartman, renk, alisFiyati, satisFiyati, ozelAdi, quantity);
        } catch (SQLException throwables) {
            System.out.println("Unable to write frame");

        }
    }

    public void addGlass(String barcode, double alisFiyati, double satisFiyati, String tur, String marka,
                         String indeks, int quantity) {
        try {
            db.writeGlass(barcode, alisFiyati, satisFiyati, tur, marka,
                    indeks, quantity);
        } catch (SQLException throwables) {
            System.out.println("Unable to write glass");
        }
    }

    public void addPrescriptionGlass(String receteNo, String receteTarihi, String tarih, String rcBarcode, String rcSph,
                                     String rcCyl, String rcAx, String rcPd, String rcYukseklik, String lcBarcode,
                                     String lcSph, String lcCyl, String lcAx, String lcPd, String lcYukseklik) {
        try {
            db.writePrescriptionCam(receteNo, receteTarihi, tarih, rcBarcode, rcSph, rcCyl, rcAx, rcPd, rcYukseklik,
                    lcBarcode, lcSph, lcCyl, lcAx, lcPd, lcYukseklik);
        } catch (SQLException throwables) {
            System.out.println("Unable to write prescription glass");
        }
    }

    public void addPrescriptionLens(String receteNo, String receteTarihi, String tarih, String rlBarcode,
                                    String rlTemelEgri, String rlTumCap, String rlTorik, String rlMultifokal,
                                    String rlRenk, String rlOzelAd, String llBarcode, String llTemelEgri,
                                    String llTumCap, String llTorik, String llMultifokal, String llRenk,
                                    String llOzelAd) {
        try {
            db.writePrescriptionLens(receteNo, receteTarihi, tarih, rlBarcode, rlTemelEgri, rlTumCap, rlTorik, rlMultifokal,
                    rlRenk, rlOzelAd, llBarcode, llTemelEgri, llTumCap, llTorik, llMultifokal, llRenk, llOzelAd);
        } catch (SQLException throwables) {
            System.out.println("Unable to write prescription lens");
        }
    }

    public void addSale(double toplamFiyat, String tarih, String tcNo, String camReceteNo, String lensReceteNo,
                        double sgk, double kart, double nakit) {
        try {
            db.writeSale(toplamFiyat, tarih, tcNo, camReceteNo, lensReceteNo, sgk, kart, nakit);
        } catch (SQLException throwables) {
            System.out.println("Unable to write sale");
        }
    }

    public void addSpecial(String barcode, String urunAdi, double alisFiyati, double satisFiyati, int quantity) {
        try {
            db.writeSpecial(barcode, urunAdi, alisFiyati, satisFiyati, quantity);
        } catch (SQLException throwables) {
            System.out.println("Unable to write special");
        }
    }

    public void cancelSale(int saleId) {
// remember to delete the record!!!!!
        ArrayList<String> itemBarcodes; // barcodes for sold items
        int isSaleDeleted;
        int isPrescriptionDeleted;
        int isRecordDeleted;
        String tableName;

        try {
            if (!db.searchSales(saleId).isEmpty()) {
                Sale sale = db.searchSales(saleId).get(0);

                // get items from the sale
                itemBarcodes = db.searchRecords(saleId);

                // add items back
                for (int i = 0; i < itemBarcodes.size(); i++) {
                    tableName = db.searchType(itemBarcodes.get(i));

                    if (tableName.equals("ContactLens")) {
                        db.updateLensQuantity(itemBarcodes.get(i), +1);
//                    } else if (tableName.equals("Extra")) {
//                        db.updateExtraQuantity(itemBarcodes.get(i), +1);
//
                    } else if (tableName.equals("Frame")) {
                        db.updateFrameQuantity(itemBarcodes.get(i), +1);

                    } else if (tableName.equals("Glass")) {
                        db.updateGlassQuantity(itemBarcodes.get(i), +1);

                    } else if (tableName.equals("Special")) {
                        db.updateSpecialQuantity(itemBarcodes.get(i), +1);

                    }

                }


                // delete records
                isRecordDeleted = db.deleteRecord(saleId);

                if (!sale.getCamReceteNo().isEmpty()) {
                    db.deletePrescriptionCam(sale.getCamReceteNo());
                }
                if (!sale.getLensReceteNo().isEmpty()) {
                    db.deletePrescriptionLens(sale.getLensReceteNo());
                }

                // delete sale from database
                isSaleDeleted = db.deleteSale(saleId);

                if (isSaleDeleted != 0 && isRecordDeleted != 0) {
                    JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti!", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Belirtilen satış numarası silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);

                }
            } else {
                System.out.println("Satış bulunamadı");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean checkLogin(String tempID, String tempPass) {
        boolean isLogged; // initially null
        isLogged = db.login(tempID, tempPass);
        return isLogged;
    }

    public ArrayList<ContactLens> findLens(String barcode) {
        try {
            return db.searchContactLens(barcode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public ArrayList<Customer> findCustomer(String tckn) {
        try {
            return db.searchCustomers(tckn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

//    public ArrayList<Extra> findExtras(String barcode) {
//        try {
//            return db.searchExtrasByBarcode(barcode);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
//    }

    public ArrayList<Frame> findFrames(String barcode) {
        try {
            return db.searchFrames(barcode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public ArrayList<Glass> findGlasses(String barcode) {
        try {
            return db.searchGlasses(barcode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public PrescriptionCam findPrescriptionGlass(String searchReceteNo) {
        try {
            if (!db.searchPrescriptionCam(searchReceteNo).isEmpty()) {
                return db.searchPrescriptionCam(searchReceteNo).get(0);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public PrescriptionLens findPrescriptionLens(String searchReceteNo) {
        try {
            if (!db.searchPrescriptionLens(searchReceteNo).isEmpty()) {
                return db.searchPrescriptionLens(searchReceteNo).get(0);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<Special> findSpecials(String barcode) {
        try {
            return db.searchSpecials(barcode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public Object findStock(String barcode) {
        try {
            if (!db.searchAll(barcode).isEmpty())
                return db.searchAll(barcode).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public double findLensPrice(String barcode) {
        try {
            if (!db.searchContactLens(barcode).isEmpty()) {
                return db.searchContactLens(barcode).get(0).getSatisFiyati();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bulunamadı. Lütfen tekrar deneyin", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }

    public double findFramePrice(String barcode) {
        try {
            if (!db.searchFrames(barcode).isEmpty()) {
                return db.searchFrames(barcode).get(0).getSatisFiyati();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bulunamadı. Lütfen tekrar deneyin", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }

    public double findGlassPrice(String barcode) {
        try {
            if (!db.searchGlasses(barcode).isEmpty()) {
                return db.searchGlasses(barcode).get(0).getSatisFiyati();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bulunamadı. Lütfen tekrar deneyin", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;

    }

    public double findSpecialPrice(String barcode) {
        try {
            if (!db.searchSpecials(barcode).isEmpty()) {
                return db.searchSpecials(barcode).get(0).getSatisFiyati();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bulunamadı. Lütfen tekrar deneyin", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }

    public Sale findSaleBySaleId(int saleId) {
        try {
            if (!db.searchSales(saleId).isEmpty())
                return db.searchSales(saleId).get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Sale();
    }

    public ArrayList<Sale> findSaleByPresc(int prescNumber) {
        try {
            return db.searchSaleByPresc(prescNumber);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public String findTableName(String barcode) throws SQLException {
        return db.searchType(barcode);
    }

    public ArrayList<String> findRecordsBySaleId(int saleId) {
        try {
            System.out.println(db.searchRecords(saleId).size());

            return db.searchRecords(saleId);
        } catch (SQLException throwables) {
            System.out.println("no record found");
            throwables.printStackTrace();
            return null;
        }
    }

    public ArrayList<ContactLens> getContactLenses() {
        try {
            return db.readContactLenses();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public ArrayList<Customer> getCustomer() {
        try {
            return db.readCustomers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public ArrayList<Extra> getExtras() {
        try {
            return db.readExtras();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public ArrayList<Frame> getFrames() {
        try {
            return db.readFrames();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public ArrayList<Glass> getGlasses() {
        try {
            return db.readGlasses();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public ArrayList<PrescriptionCam> getPrescriptionGlass() {
        try {
            return db.readPrescriptionsCam();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public ArrayList<PrescriptionLens> getPrescriptionLens() {
        try {
            return db.readPrescriptionLens();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public ArrayList<Sale> getSale() {
        try {
            return db.readSales();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public ArrayList<Special> getSpecials() {
        try {
            return db.readSpecials();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    //////////////////////////////////////////// Remove Methods ////////////////////////////////////////////////////////////
    public void removeLens(String barcode) {
        int affectedRow = 0;

        try {
            if (!db.searchContactLens(barcode).isEmpty() && db.searchItemRecords(barcode).isEmpty()) {
                affectedRow = db.deleteLens(barcode);

                if (affectedRow != 0) {
                    JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti",
                            "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Lens silinemedi!", "Hata!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ürün daha önce satıldığı için silinemedi!!"
                        , "Hata!", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeCustomer(String tckn) {
        int affectedRow = 0;
        try {
            affectedRow = db.deleteCustomer(tckn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (affectedRow != 0) {
            JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Müşteri silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void removeExtra(int id) {
        int affectedRow = 0;
        try {
            affectedRow = db.deleteExtra(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (affectedRow != 0) {
            JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Extra silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void removeFrame(String barcode) {
        int affectedRow = 0;
        try {
            if (!db.searchFrames(barcode).isEmpty() && db.searchItemRecords(barcode).isEmpty()) {
                affectedRow = db.deleteFrame(barcode);

                if (affectedRow != 0) {
                    JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Çerçeve silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ürün daha önce satıldığı için silinemedi!!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeGlass(String barcode) {
        int affectedRow = 0;
        try {
            if (!db.searchGlasses(barcode).isEmpty() && db.searchItemRecords(barcode).isEmpty()) {

                affectedRow = db.deleteGlass(barcode);
                if (affectedRow != 0) {
                    JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Cam silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ürün daha önce satıldığı için silinemedi!!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

//    public void removePrescription(String receteNo) {
//        int affectedRow = 0;
//        try {
//            affectedRow = db.deletePrescription(receteNo);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if (affectedRow != 0) {
//            JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(null, "Reçete silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
//        }
//
//    }

//    public void removeRecord(int saleId) {
//        int affectedRow = 0;
//        try {
//            affectedRow = db.deleteRecord(saleId);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if (affectedRow != 0) {
//            JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(null, "Kayıt silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
//        }
//
//    }

    public void removeSale(int saleId) {
        int affectedRow = 0;
        try {
            affectedRow = db.deleteSale(saleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (affectedRow != 0) {
            JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Satış kaydı silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void removeSpecial(String barcode) {
        int affectedRow = 0;
        try {
            if (!db.searchSpecials(barcode).isEmpty() && db.searchItemRecords(barcode).isEmpty()) {
                affectedRow = db.deleteSpecial(barcode);

                if (affectedRow != 0) {
                    JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Özel ürün silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ürün daha önce satıldığı için silinemedi!!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public boolean sell(ArrayList<String> soldItems, PrescriptionCam pc, PrescriptionLens pl, double totalPrice,
                        double sgk, double kart, double nakit, double discount, Customer customer)
            throws Exception {

        // Steps of sale
        // 1-Check stock for errors
        // 2-If everything is fine;
        //      I-add prescriptions
        //      I-add sale
        //      II-get sale id
        //      III-add each item
        // 3-else, show error


        boolean inStock = true;
        String tableName = "";
        int tempQuantity = 0;

        // Check stock for errors
        for (int i = 0; i < soldItems.size(); i++) {

            tableName = db.searchType(soldItems.get(i));
            // System.out.println(tableName);

            if (tableName.equals("ContactLens")) {

                tempQuantity = db.searchContactLens(soldItems.get(i)).get(0).getQuantity();

                if (tempQuantity <= 0) {
                    inStock = false;
                    break;
                }
            } else if (tableName.equals("Frame")) {

                tempQuantity = db.searchFrames(soldItems.get(i)).get(0).getQuantity();
                if (tempQuantity <= 0) {
                    inStock = false;
                    break;
                }
            } else if (tableName.equals("Glass")) {

                tempQuantity = db.searchGlasses(soldItems.get(i)).get(0).getQuantity();
                if (tempQuantity <= 0) {
                    inStock = false;
                    break;
                }
            } else if (tableName.equals("Special")) {

                tempQuantity = db.searchSpecials(soldItems.get(i)).get(0).getQuantity();
                if (tempQuantity <= 0) {
                    inStock = false;
                    break;
                }
            }
        }

        if (inStock) {
            if (pc != null) {
                db.writePrescriptionCam(pc.getReceteNo(), pc.getReceteTarihi(), pc.getTarih(), pc.getRcBarcode(), pc.getRcSph(), pc.getRcCyl(), pc.getRcAx(), pc.getRcPd(), pc.getRcYukseklik(), pc.getLcBarcode(), pc.getLcSph(), pc.getLcCyl(), pc.getLcAx(), pc.getLcPd(), pc.getLcYukseklik());
            } else {
                System.out.println("Cam recetesi yok!");
            }

            if (pl != null) {
                db.writePrescriptionLens(pl.getReceteNo(), pl.getReceteTarihi(), pl.getTarih(), pl.getRlBarcode(), pl.getRlTemelEgri(), pl.getRlTumCap(), pl.getRlTorik(), pl.getRlMultifokal(), pl.getRlRenk(), pl.getRlOzelAd(), pl.getLlBarcode(), pl.getLlTemelEgri(), pl.getLlTumCap(), pl.getLlTorik(), pl.getLlMultifokal(), pl.getLlRenk(), pl.getLlOzelAd());
            } else {
                System.out.println("Lens recetesi yok!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Stok hatası. Ürün stoğu bitmiş olabilir", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }

        db.writeSale(totalPrice, LocalDateTime.now().toString(), customer.getTcNo(), pc.getReceteNo(), pl.getReceteNo(), sgk, kart, nakit);
        int saleId = db.readLastSaleId();

        for (int i = 0; i < soldItems.size(); i++) {


            tableName = db.searchType(soldItems.get(i));
            // System.out.println(tableName);

            if (tableName.equals("ContactLens")) {

                db.writeRecord(soldItems.get(i), saleId);
                db.updateLensQuantity(soldItems.get(i), -1);

//            } else if (tableName.equals("Extra")) {
//
//                db.writeRecord(soldItems.get(i), saleId);
//                db.updateExtraQuantity(soldItems.get(i), -1);

            } else if (tableName.equals("Frame")) {


                db.writeRecord(soldItems.get(i), saleId);
                db.updateFrameQuantity(soldItems.get(i), -1);

            } else if (tableName.equals("Glass")) {


                db.writeRecord(soldItems.get(i), saleId);
                db.updateGlassQuantity(soldItems.get(i), -1);

            } else if (tableName.equals("Special")) {

                db.writeRecord(soldItems.get(i), saleId);
                db.updateSpecialQuantity(soldItems.get(i), -1);

            }
        }
        db.writeCustomer(customer.getTcNo(), customer.getIsim(), customer.getSoyisim(), customer.getTelefon());

        return inStock;
    }

    public ArrayList<Integer> searchByTckn(String tckn) {
        ArrayList<Integer> saleIds;
        try {
            saleIds = db.searchSale(tckn);

        } catch (SQLException e) {
            e.printStackTrace();
            saleIds = new ArrayList<Integer>();
        }
        return saleIds;
    }

    public ArrayList<Extra> getExtraBetweenDates(String firstDate, String lastDate) {

        try {
            return db.searchExtraBetween(firstDate, lastDate);
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<Sale> getSaleBetweenDates(String firstDate, String lastDate) {
        try {
            return db.searchSaleBetween(firstDate, lastDate);
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean changeLoginInfo(String oldPass, String newPass) {
        ArrayList<String> userNameList = null;
        int changed = 0;

        try {
            changed = db.updatePassword(oldPass, newPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (changed == 0) {
            JOptionPane.showMessageDialog(null, "Something is wrong. Password couldn't changed");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Password changed successfully.");
            return true;
        }
    }

    public double calcDiscount(int saleId) throws SQLException {

        if (!db.searchSales(saleId).isEmpty()) {
            Sale sale = db.searchSales(saleId).get(0);
            double discount = sale.getToplamFiyat() - (sale.getKart() + sale.getNakit() + sale.getSgk());
            return discount;
        } else {
            return 0.0;
        }
    }
}