/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author ACER
 */
public class Transaksi {

    Koneksi koneksi;
    ArrayList<Jenis_cucian> arrJenis;
    ArrayList<Data_Pelanggan> arrPelanggan;
    ArrayList<Transaksi_cucian> arrCucian;
    ArrayList<Transaksi_pembayaran> arrPembayaran;

    public Transaksi() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrJenis = new ArrayList<>();
        this.arrPelanggan = new ArrayList<>();
        this.arrCucian = new ArrayList<>();
        this.arrPembayaran = new ArrayList<>();
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
    
    public ArrayList<Transaksi_pembayaran> getDataPembayaran() throws SQLException {
        this.arrPembayaran.clear();
        ResultSet rs = this.koneksi.GetData("SELECT TRANSAKSI_PEMBAYARAN.*, TRANSAKSI_CUCIAN.* FROM TRANSAKSI_PEMBAYARAN JOIN "
                + "TRANSAKSI_CUCIAN ON TRANSAKSI_PEMBAYARAN.ID_TRANSAKSI = TRANSAKSI_CUCIAN.ID_TRANSAKSI ORDER BY ID_PEMBAYARAN ASC");
        while (rs.next()) {         
            Transaksi_cucian tr = new Transaksi_cucian();
            tr.setId_Transaksi(rs.getInt("ID_TRANSAKSI"));
            tr.getDataPelanggan();
            tr.setBerat(rs.getInt("BERAT_CUCIAN"));
            tr.setTanggal_Masuk(rs.getDate("TANGGAL_MASUK"));
            tr.setTanggal_Pengambilan(rs.getDate("TANGGAL_PENGAMBILAN"));
            
            Transaksi_pembayaran tp = new Transaksi_pembayaran();
            tp.setId_Pembayaran(rs.getInt("ID_PEMBAYARAN"));
            tp.setTransaksi_cucian(tr);
            tp.setHarga_Total(rs.getInt("HARGA_TOTAL"));
            tp.setTunai(rs.getInt("TUNAI"));
            tp.setKembalian(rs.getInt("KEMBALIAN"));
            tp.setStatus(rs.getString("STATUS"));
            
            
            this.arrPembayaran.add(tp);
        }
        return this.arrPembayaran;
    }
    
    public void insertPembayaran(Transaksi_pembayaran bayar) {
        this.koneksi.ManipulasiData("INSERT INTO TRANSAKSI_PEMBAYARAN VALUES (ID_PEMBAYARAN.NEXTVAL," + bayar.getTransaksi_cucian().getId_Transaksi()+
                ", "+bayar.getHarga_Total()+ ", "+bayar.getTunai()+ ", "
                + bayar.getKembalian() + ", '" + bayar.getStatus()+ "')");
        ResultSet rs = this.koneksi.GetData("SELECT ID_PEMBAYARAN.CURRVAL FROM DUAL");
    } 
}
