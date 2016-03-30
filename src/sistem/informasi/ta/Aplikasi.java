/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.informasi.ta;

import java.util.ArrayList;

/**
 *
 * @author Aldry
 */
public class Aplikasi {
    private ArrayList<Dosen> daftarDosen = new ArrayList<>();
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private String nama;

    /**
     * Method ini untuk constructor
     * @param nama 
     */
    public Aplikasi(String nama) {
        this.nama = nama;
    }

    /**
     * Method mengeset nama
     * @param nama 
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * 
     * @return nama 
     */
    public String getNama() {
        return nama;
    }
    
    public void AddDosen(String nama, String status, String nip, String kodeDosen, int maxTopikTA) {
        Dosen d = new Dosen();
        Aplikasi a = new Aplikasi(nama);
        daftarDosen.add(maxTopikTA, d);
    }
    
    public boolean DeleteMahasiswa(String nim){
       try {
           for (int i=0 ;i<daftarMahasiswa.size(); i++){
               if (daftarMahasiswa.get(i).getNim().equals(nim)) {
               daftarMahasiswa.remove(i);
            }
            return true;
            }
       }
       catch (Exception ex){
           ex.printStackTrace();
       }
       
       return false;
    }
    
    public void ViewMahasiswaBimbingan() {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            daftarMahasiswa.get(i).toString();
        }
    } 
    
}

