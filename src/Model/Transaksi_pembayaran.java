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
public class Transaksi_pembayaran {
    private Transaksi_cucian transaksi_cucian;
    private Integer Id_pembayaran;
    private Integer Harga_Total;
    private Integer Tunai;
    private Integer Kembalian;
    private String Status;
    private ArrayList<Transaksi_cucian> arrTransaksi_cucian;

    public Transaksi_cucian getTransaksi_cucian() {
        return transaksi_cucian;
    }

    public void setTransaksi_cucian(Transaksi_cucian transaksi_cucian) {
        this.transaksi_cucian = transaksi_cucian;
    }
    
    public Integer getId_Pembayaran() {
        return Id_pembayaran;
    }

    public void setId_Pembayaran(Integer Id_Pembayaran) {
        this.Id_pembayaran = Id_Pembayaran;
    }

    public Integer getHarga_Total() {
        return Harga_Total;
    }

    public void setHarga_Total(Integer Harga_Total) {
        this.Harga_Total = Harga_Total;
    }

    public Integer getTunai() {
        return Tunai;
    }

    public void setTunai(Integer Tunai) {
        this.Tunai = Tunai;
    }
    
    public Integer getKembalian() {
        return Kembalian;
    }

    public void setKembalian(Integer Kembalian) {
        this.Kembalian = Kembalian;
    }
    
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
}