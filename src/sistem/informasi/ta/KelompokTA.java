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
 * @author Bety Elysabeth
 */
public class KelompokTA implements Serializable {
	private String topik;
        private ArrayList<Mahasiswa> anggota = new ArrayList<>();
	
	public KelompokTA(String topik) {
		this.topik = topik;
	}
		
	public void setTopikTA(String topik) {
		this.topik=topik;
	}
	
	public String getTopikTA() {
		return topik;
	}
	
	public void addAnggota(Mahasiswa m){
            if(anggota.size()>=4) return;
            anggota.add(m);
        }
        
        
        public Mahasiswa getAnggotaByIndex(int i){
            if(i<anggota.size()) return anggota.get(i);
            return null;
        }
        
        public Mahasiswa getAnggotaByNim(String nim){
        for(int i=0; i<anggota.size(); i++){
            if(anggota.get(i).getNim().equals(nim)){
                return anggota.get(i);
            }
        }
            return null;
        }
        
        public boolean removeAnggota(String nim){
            for(int i=0; i<anggota.size(); i++){
                if(anggota.get(i).getNim().toLowerCase().equals(nim.toLowerCase())){
                    anggota.remove(i);
                    return true;
                }
            }
            return false;
        }

        public ArrayList<Mahasiswa> getAnggota() {
            return anggota;
        }
        
}

