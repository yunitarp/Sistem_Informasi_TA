/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;


/**
 *
 * @author Aldry
 */
public class Mahasiswa extends Orang implements Serializable{
    private TugasAkhir tugasAkhir;
    private String nim;
    private String status;

    public Mahasiswa(String nama, String nim, String status, String noTelp, String alamat, String tanggalLahir, String username, String password) {
        super(nama, noTelp, alamat, tanggalLahir, username, password);
        this.nim = nim;
        this.status = status;
    }
       
    public void createTA (String judul) {
        this.tugasAkhir = new TugasAkhir(judul);
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Nama Mahasiswa :"+getNama()+"\n"
                + "Nim Mahasiswa : "+getNim()+"\n"
                + "Status Mahasiswa : "+getStatus()
                + "Judul Tugas Akhir"+getTugasAkhir().getJudul()
                + "Dosen Pembimbing"+getTugasAkhir().getPembimbingByIndex(0)
                + "Dosen Pembimbing"+getTugasAkhir().getPembimbingByIndex(1);
    }

    public TugasAkhir getTugasAkhir() {
        return tugasAkhir;
    }
    
    
}
