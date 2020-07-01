package Controller;

import Database.*;
import Model.*;
import View.Data_pelanggan;
import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class Pelanggan_Controller {

    Koneksi koneksi;
    ArrayList<Jenis_cucian> arrJenis;
    ArrayList<Data_Pelanggan> arrPelanggan;

    public Pelanggan_Controller() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrJenis = new ArrayList<>();
        this.arrPelanggan = new ArrayList<>();
    }

    public ArrayList<Jenis_cucian> getDataJenis() throws SQLException {
        this.arrJenis.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM JENIS_CUCIAN");
        while (rs.next()) {
            Jenis_cucian jc = new Jenis_cucian();
            jc.setIDJenisCucian(rs.getInt("ID_JENIS_CUCIAN"));
            jc.setNamaJenis(rs.getString("NAMA_JENIS_CUCIAN"));
            jc.setHarga_cucian(rs.getInt("HARGA_JENIS_CUCIAN"));
            this.arrJenis.add(jc);
        }
        return this.arrJenis;
    }

    public ArrayList<Data_Pelanggan> getDataPelanggan() throws SQLException {
        this.arrPelanggan.clear();
        ResultSet rs = this.koneksi.GetData("SELECT DATA_PELANGGAN.*, JENIS_CUCIAN.* FROM DATA_PELANGGAN JOIN JENIS_CUCIAN ON DATA_PELANGGAN.ID_JENIS_CUCIAN = JENIS_CUCIAN.ID_JENIS_CUCIAN ORDER BY ID_PELANGGAN ASC");
        while (rs.next()) {
            Jenis_cucian jc = new Jenis_cucian();
            jc.setIDJenisCucian(rs.getInt("ID_JENIS_CUCIAN"));
            jc.setNamaJenis(rs.getString("NAMA_JENIS_CUCIAN"));
            jc.setHarga_cucian(rs.getInt("HARGA_JENIS_CUCIAN"));

            Data_Pelanggan dp = new Data_Pelanggan();
            dp.setJenisCucian(jc);
            dp.setId_Pelanggan(rs.getInt("ID_PELANGGAN"));
            dp.setNama_Pelanggan(rs.getString("NAMA_PELANGGAN"));
            dp.setNo_Tlp(rs.getString("NO_TLP"));
            dp.setAlamat(rs.getString("ALAMAT_PELANGGAN"));

            this.arrPelanggan.add(dp);
        }
        return this.arrPelanggan;
    }

    public void insertPelanggan(Data_Pelanggan datapelanggan) {
        this.koneksi.ManipulasiData("INSERT INTO DATA_PELANGGAN VALUES (ID_PELANGGAN.NEXTVAL, " + datapelanggan.getJenisCucian().getId_Jenis_cucian()+ ", '"
                + datapelanggan.getNama_Pelanggan() + "', '" + datapelanggan.getNo_Tlp()+ "', '"+ datapelanggan.getAlamat() + "')");
        ResultSet rs = this.koneksi.GetData("SELECT ID_PELANGGAN.CURRVAL FROM DUAL");
    }
    
    public void delete(int id_pelanggan) {
        String kodeSql = "DELETE FROM DATA_PELANGGAN WHERE id_pelanggan = " + id_pelanggan;
        this.koneksi.ManipulasiData(kodeSql);
    }

    public void update(Data_Pelanggan dp) {
        this.koneksi.ManipulasiData("UPDATE DATA_PELANGGAN SET " + "ID_JENIS_CUCIAN = '"
                + dp.getJenisCucian().getId_Jenis_cucian() + "',NAMA_PELANGGAN = '" + dp.getNama_Pelanggan() + "',NO_TLP = '"
                + dp.getNo_Tlp() + "',ALAMAT_PELANGGAN = '" + dp.getAlamat() + "'WHERE ID_PELANGGAN = "+ dp.getId_Pelanggan());
    }

    public void clear() {
        String kodeSql = "DELETE FROM Data_Pelanggan";
        this.koneksi.ManipulasiData(kodeSql);
    }
}