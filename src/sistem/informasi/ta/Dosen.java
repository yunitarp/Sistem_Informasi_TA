/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.informasi.ta;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author yunitarp2706
 */
public class Dosen extends Orang implements Serializable {
    private KelompokTA topikTA[];
    private String status;
    private String nip;
    private String kodeDosen;
    private int nTopikTA;
    private int maxTopikTA = 10;

    public Dosen(String nama, String nip, String kodeDosen, String noTelp, String alamat, String tanggalLahir, String username, String password) {
        super(nama, noTelp, alamat, tanggalLahir, username, password);
        this.status = status;
        this.nip = nip;
        this.kodeDosen = kodeDosen;
        this.nTopikTA = 0;
        this.topikTA = new KelompokTA[maxTopikTA];
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
    
    public boolean createKelompokTA(String topik){
        if(nTopikTA<maxTopikTA){
         this.topikTA[nTopikTA]= new KelompokTA(topik);
         nTopikTA++;
         return true;   
        }
        return false;
        
    }
    
    public KelompokTA getKelompokByIndex(int i){
        return topikTA[i];
    }
    public KelompokTA getKelompokByTopik(String topik){
        for(int i=0; i<nTopikTA; i++){
            if(topikTA[i].getTopikTA().equals(topik)){
                return topikTA[i];
            }
        }
        return null;
    }
    
    public boolean deleteKelompok(String topik){
        for(int i=0; i<nTopikTA; i++){
            if(topikTA[i].getTopikTA().toLowerCase().equals(topik.toLowerCase())){
                topikTA[i]=null;
                for(int j=i+1; j<nTopikTA; j++){
                    topikTA[j-1]=topikTA[j];
                }
                nTopikTA--;
                return true;
            }
        }
        return false;
    }

    public String getKodeDosen() {
        return kodeDosen;
    }

    public void setKodeDosen(String kodeDosen) {
        this.kodeDosen = kodeDosen;
    }

    public int getnTopikTA() {
        return nTopikTA;
    }
    
}
