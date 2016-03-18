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
public class SistemInformasiTA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //tes fungsionalitas class Dosen
        Dosen d = new Dosen("Nita","Dosen Tetap","12345","YRP",4);
        Dosen d1 = new Dosen("Rachma","Dosen Tetap","7890","YRS",4);
        System.out.println(d.getNama());
        System.out.println(d.getStatus());
        System.out.println(d.getNip());
        System.out.println(d.getKodeDosen());
        
        d.createKelompokTA("Internet of Things");
        d.createKelompokTA("Kriptografi");
        System.out.println(d.getKelompokByIndex(1).getTopikTA());
        System.out.println(d.getKelompokByTopik("Internet of Things"));
        d.deleteKelompok("Internet Of Things");
        System.out.println(d.getKelompokByIndex(0).getTopikTA());
        
        //tes fungsionalitas class TugasAkhir
        TugasAkhir ta = new TugasAkhir("Ini Tugas Akhir");
        System.out.println(ta.getJudul());
        ta.setPembimbing(d, 0);
        ta.setPembimbing(d1,1);
        System.out.println(ta.getPembimbingByIndex(0).getNama());
        System.out.println(ta.getPembimbingByIndex(1).getNama());
        System.out.println(ta.getPembimbingByKodeDosen("YRP").getNama());
        System.out.println(ta.getPembimbingByKodeDosen("YRS").getNama());
        
        //tes fungsionalitas class Mahasiswa
        Mahasiswa m1 = new Mahasiswa("Yunita","1301141193","Belum lulus");
        Mahasiswa m2 = new Mahasiswa("Bety","1301140303","Belum lulus");
        m1.createTA("Machine Learning");
        System.out.println(m1.getNama());
        System.out.println(m1.getNim());
        m1.displayInfoMahasiswa();
        
        //tes fungsionalitas class KelompokTA
        KelompokTA kel = new KelompokTA("Ini Topiknya");
        kel.addAnggota(m1);
        kel.addAnggota(m2);
        System.out.println(kel.getNAnggota());
        System.out.println(kel.getAnggotaByIndex(0).getNama());
        System.out.println(kel.getAnggotaByIndex(1).getNama());
        System.out.println(kel.getAnggotaByNim("1301141193").getNama());
        kel.removeAnggota("1301141193");
        System.out.println(kel.getAnggotaByIndex(0).getNama());
    }
    
}
