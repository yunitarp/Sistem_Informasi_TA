/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.informasi.ta;

/**
 *
 * @author Aldry
 */
public class Mahasiswa extends Orang /*implements Bimbingan*/{
    TugasAkhir tugasAkhir;
    private String nim;
    private String status;

    public Mahasiswa(String nim, String status, String nama, int umur, String noTelp, String alamat, String tanggalLahir, String username, String password) {
        super(nama, umur, noTelp, alamat, tanggalLahir, username, password);
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
    
    public void displayInfoMahasiswa() {
        System.out.println("Nama Mahasiswa : " + getNama());
        System.out.println("Nama Mahasiswa : " + getNim());
        System.out.println("Nama Mahasiswa : " + getStatus());
    }

    @Override
    public String toString() {
        return "Nama Mahasiswa :"+getNama()+"\n"
                + "Nim Mahasiswa : "+getNim()+"\n"
                + ""; 
    }
    
    
}
