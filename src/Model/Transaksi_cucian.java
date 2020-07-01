/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class Transaksi_cucian {
    private Data_Pelanggan data_pelanggan;
    private Integer Id_transaksi;
    private Integer berat_cucian;
    private Date Tanggal_Masuk;
    private Date Tanggal_Pengambilan;
    
    public Data_Pelanggan getDataPelanggan() {
        return data_pelanggan;
    }

    public void setDataPelanggan(Data_Pelanggan data_Pelanggan) {
        this.data_pelanggan = data_Pelanggan;
    }
    
    public Integer getId_Transaksi() {
        return Id_transaksi;
    }

    public void setId_Transaksi(Integer Id_transaksi) {
        this.Id_transaksi = Id_transaksi;
    }

    public Integer getBerat() {
        return berat_cucian;
    }

    public void setBerat(Integer berat_cucian) {
        this.berat_cucian = berat_cucian;
    }
    
    public Date getTanggal_Masuk() {
        return Tanggal_Masuk;
    }

    public void setTanggal_Masuk(Date Tanggal_Masuk) {
        this.Tanggal_Masuk = Tanggal_Masuk;
    }

    public Date getTanggal_Pengambilan() {
        return Tanggal_Pengambilan;
    }

    public void setTanggal_Pengambilan(Date Tanggal_Pengambilan) {
        this.Tanggal_Pengambilan = Tanggal_Pengambilan;
    }

}
