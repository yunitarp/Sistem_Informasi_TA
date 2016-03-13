/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.informasi.ta;

/**
 *
 * @author yunitarp2706
 */
public class KelompokTA {
    private String topik;
    private Mahasiswa[] anggota;
    private int nAnggota;
    private int maxAnggota;

    public KelompokTA(String topik, Mahasiswa[] anggota, int maxAnggota) {
        this.topik = topik;
        this.anggota = anggota;
        this.nAnggota = 0;
        this.maxAnggota = maxAnggota;
    }
    
    
    public void setTopik(String topik){
        this.topik = topik;
    }
    public String getTopik(){
        return topik;
    }
    public void addAnggota(Mahasiswa m){
        if(nAnggota<maxAnggota){
            anggota[nAnggota]=m;
            nAnggota++;
        }
        else{
            System.out.println("Anggota sudah penuh");
        }
    
    public int getNAnggota(){
        return nAnggota;
    }
    public Mahasiswa getAnggotaByIndex(int i){
        return anggota[i];
    }
    public Mahasiswa getAnggotaByNim(String nim){
        
    }
    
}
