/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class Data_Pelanggan {
    private Jenis_cucian jenis_cucian;
    private Integer Id_Pelanggan;
    private String Nama_Pelanggan;
    private String Alamat;
    private String No_Tlp;

    public Jenis_cucian getJenisCucian() {
        return jenis_cucian;
    }

    public void setJenisCucian(Jenis_cucian jenis_cucian) {
        this.jenis_cucian = jenis_cucian;
    }
    
    public Integer getId_Pelanggan() {
        return Id_Pelanggan;
    }

    public void setId_Pelanggan(Integer Id_Pelanggan) {
        this.Id_Pelanggan = Id_Pelanggan;
    }

    public String getNama_Pelanggan() {
        return Nama_Pelanggan;
    }

    public void setNama_Pelanggan(String Nama_Pelanggan) {
        this.Nama_Pelanggan = Nama_Pelanggan;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getNo_Tlp() {
        return No_Tlp;
    }

    public void setNo_Tlp(String No_Tlp) {
        this.No_Tlp = No_Tlp;
    }
}
