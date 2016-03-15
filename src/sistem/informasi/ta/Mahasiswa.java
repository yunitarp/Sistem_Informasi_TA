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
public class Mahasiswa extends Orang implements Bimbingan {
    private TugasAkhir tugasAkhir;
    private String nim;
    private String status;
    
    /**
     *
     * @param nim
     * @param status
     * @param nama
     */
    public Mahasiswa(String nim,String status,String nama){
       this.nim = nim;
       super(nama);
       this.status = status;
    }
    
    public void createTA (String judul) {
        tugasAkhir = new TugasAkhir(judul);
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
        System.out.println("Nama Mahasiswa : " + nama);
        System.out.println("Nama Mahasiswa : " + nim);
        System.out.println("Nama Mahasiswa : " + status);
    }
}
