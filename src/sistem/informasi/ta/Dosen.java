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
public class Dosen {
    private KelompokTA topikTA[];
    private String status;
    private String nip;
    private String kodeDosen;
    private int nTopikTA;
    private int maxTopikTA;
    
    public Dosen(String nama, String status, String nip, String kodeDosen, int maxTopikTA ){
        super(nama);
        this.nip = nip;
        this.status = status;
        this.kodeDosen = kodeDosen;
        this.nTopikTA = 0;
        this.maxTopikTA = maxTopikTA;
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
         this.topikTA[nTopikTA]= new KelompokTA(topik,5);
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
            if(topikTA[i].getTopik() == topik){
                return topikTA[i];
            }
        }
        return null;
    }
    
    public boolean deleteKelompok(String topik){
        for(int i=0; i<nTopikTA; i++){
            if(topikTA[i].getTopik() == topik){
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
    
}
