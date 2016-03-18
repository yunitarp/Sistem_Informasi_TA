/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.informasi.ta;

/**
 *
 * @author Bety Elysabeth
 */
public class KelompokTA {
	private String topik;
	private Mahasiswa[] anggota;
        private int nAnggota;
        private int maxAnggota=4; 
	
	public KelompokTA(String topik) {
		this.topik = topik;
		this.anggota = new Mahasiswa[maxAnggota];
                this.nAnggota = 0;
	}
		
	public void setTopikTA(String topik) {
		this.topik=topik;
	}
	
	public String getTopikTA() {
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
        }
        
        public int getNAnggota(){
        return nAnggota;
        }
        
        public Mahasiswa getAnggotaByIndex(int i){
            return anggota[i];
        }
        
        public Mahasiswa getAnggotaByNim(String nim){
        for(int i=0; i<nAnggota; i++){
            if(anggota[i].getNim().equals(nim)){
                return anggota[i];
            }
        }
            return null;
        }
        
        public boolean removeAnggota(String nim){
        for(int i=0; i<nAnggota; i++){
            if(anggota[i].getNim().toLowerCase().equals(nim.toLowerCase())){
                for(int j=i+1; j<nAnggota; j++){
                    anggota[j-1]=anggota[j];
                }
                nAnggota--;
                return true;
            }
            }
        return false;
        }
}

