/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Jenis_cucian {
    
    private Integer Id_jenis_cucian;
    private String Nama_jenis_cucian;
    private Integer Harga_jenis_cucian;

    public Integer getId_Jenis_cucian() {
        return Id_jenis_cucian;
    }

    public void setIDJenisCucian(Integer Id_jenis_cucian) {
        this.Id_jenis_cucian = Id_jenis_cucian;
    }

    public String getNama_jenis_cucian() {
        return Nama_jenis_cucian;
    }

    public void setNamaJenis(String Nama_jenis_cucian) {
        this.Nama_jenis_cucian = Nama_jenis_cucian;
    }
    
    public void setHarga_cucian(Integer Harga_jenis_cucian) {
        this.Harga_jenis_cucian = Harga_jenis_cucian;
    }
    
    public Integer getHarga_cucian() {
        return Harga_jenis_cucian;
    }
}

