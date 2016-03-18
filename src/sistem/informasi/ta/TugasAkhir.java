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
public class TugasAkhir {
    private Dosen[] pembimbing = new Dosen[2];
    private String judul;

    public TugasAkhir(String judul) {
        this.judul = judul;
        this.pembimbing = new Dosen[2];
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public boolean setPembimbing(Dosen d, int i){
        if(i == 0 || i == 1){
            this.pembimbing[i] = d;
            return true;
        }
        return false;
    }
    
    public Dosen getPembimbingByIndex(int i){
        return pembimbing[i];
    }
    public Dosen getPembimbingByKodeDosen(String kodeDosen){
        for(int i=0; i<2; i++){
            if(pembimbing[i].getKodeDosen().equals(kodeDosen)){
                return pembimbing[i];
            }
                
        }
        return null;
    }
    
}
