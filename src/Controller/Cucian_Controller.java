/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Cucian_Controller {
    Koneksi koneksi;
    ArrayList<Data_Pelanggan> arrPelanggan;
    ArrayList<Transaksi_cucian> arrCucian;
   // Pelanggan_Controller pelanggan;

    public Cucian_Controller() throws SQLException {
        this.koneksi = new Koneksi();
      //  this.pelanggan = new Pelanggan_Controller();
        this.arrPelanggan = new ArrayList<>();
        this.arrCucian = new ArrayList<>();
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

    public ArrayList<Transaksi_cucian> getDataCucian() throws SQLException {
        this.arrCucian.clear();
        ResultSet rs = this.koneksi.GetData("SELECT TRANSAKSI_CUCIAN.*, DATA_PELANGGAN.* FROM TRANSAKSI_CUCIAN JOIN DATA_PELANGGAN ON TRANSAKSI_CUCIAN.ID_PELANGGAN = DATA_PELANGGAN.ID_PELANGGAN ORDER BY ID_TRANSAKSI ASC");
        while (rs.next()) {

            Data_Pelanggan dp = new Data_Pelanggan();
            dp.setId_Pelanggan(rs.getInt("ID_PELANGGAN"));
            dp.getJenisCucian();
            dp.setNama_Pelanggan(rs.getString("NAMA_PELANGGAN"));
            dp.setNo_Tlp(rs.getString("NO_TLP"));
            dp.setAlamat(rs.getString("ALAMAT_PELANGGAN"));
            
            Transaksi_cucian tc = new Transaksi_cucian();
            tc.setId_Transaksi(rs.getInt("ID_TRANSAKSI"));
            tc.setDataPelanggan(dp);
            tc.setBerat(rs.getInt("BERAT_CUCIAN"));
            tc.setTanggal_Masuk(rs.getDate("TANGGAL_MASUK"));
            tc.setTanggal_Pengambilan(rs.getDate("TANGGAL_PENGAMBILAN"));

            this.arrCucian.add(tc);
        }
        return this.arrCucian;
    }

    public void insertCucian(Transaksi_cucian datacucian) {
        String dateMasuk = new SimpleDateFormat("dd-MM-yyyy").format(datacucian.getTanggal_Masuk());
        String dateKeluar = new SimpleDateFormat("dd-MM-yyyy").format(datacucian.getTanggal_Pengambilan());
        this.koneksi.ManipulasiData("INSERT INTO TRANSAKSI_CUCIAN VALUES (ID_TRANSAKSI.NEXTVAL," + datacucian.getDataPelanggan().getId_Pelanggan()+ ", "
                + datacucian.getBerat() + ", '" + dateMasuk+ "', '"+ dateKeluar + "')");
        ResultSet rs = this.koneksi.GetData("SELECT ID_TRANSAKSI.CURRVAL FROM DUAL");
    } 
}
