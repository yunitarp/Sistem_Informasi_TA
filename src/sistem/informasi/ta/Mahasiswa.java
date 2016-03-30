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
    private TugasAkhir tugasAkhir;
    private String nim;
    private String status;
    private String password;
    /**
     *
     * @param nim
     * @param status
     * @param nama
     */
    public Mahasiswa(String nama, String nim,String status, String password){
       super(nama);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void displayInfoMahasiswa() {
        System.out.println("Nama Mahasiswa : " + getNama());
        System.out.println("NIM Mahasiswa : " + getNim());
        System.out.println("Status Mahasiswa : " + getStatus());
        System.out.println("Password Mahasiswa" + getPassword());
        
    }
}
