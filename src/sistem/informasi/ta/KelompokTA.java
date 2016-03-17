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
public abstract class KelompokTA {
	private String topik;
	private Mahasiswa[] anggota;
	
	public KelompokTA(String topik) {
		this.topik = topik;
		Mahasiswa[] anggota = new Mahasiswa[4];
	}
		
	public void setTopikTA(String topik) {
		this.topik=topik;
	}
	
	public String getTopikTA() {
		return topik;
	}
	
	public void addAnggota(Mahasiswa m) {
		Mahasiswa[] m = new Mahasiswa;
		
		if (anggota < 4){
			Mahasiswa[anggota] = m;
			m++;
		}
                else {
		System.out.println("Anggota Kelompok TA Penuh.");
		}
	}
}

