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
    KelompokTA topikTA[];
    String status;
    String nip;
    
    public Dosen(String nama, String nip, String status){
//        super(nama);
        this.nip = nip;
        this.status = status;
    }
}
