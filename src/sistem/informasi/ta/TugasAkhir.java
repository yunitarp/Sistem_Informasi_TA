/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.informasi.ta;

import java.util.ArrayList;

/**
 *
 * @author yunitarp2706
 */
public class TugasAkhir {
    private ArrayList<Dosen> pembimbing = new ArrayList<>();
    private String judul;

    public TugasAkhir(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public boolean setPembimbing(Dosen d, int i){
        if(i == 0 || i == 1){
            this.pembimbing.set(i, d);
            return true;
        }
        return false;
    }
    
    public Dosen getPembimbingByIndex(int i){
          if(i<pembimbing.size()) return pembimbing.get(i);
            return null;
    }
    public Dosen getPembimbingByKodeDosen(String kodeDosen){
        for(int i=0; i<2; i++){
            if(pembimbing.get(i).getKodeDosen().equals(kodeDosen)){
                return pembimbing.get(i);
            }
                
        }
        return null;
    }
    
}
