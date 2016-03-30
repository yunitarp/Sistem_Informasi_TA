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
public abstract class Orang {

    private String nama;
    private int umur;
    private String noTelp;
    private String alamat;
    private String tanggalLahir;
    private String username;
    private String password;

    public Orang(String nama, int umur, String noTelp, String alamat, String tanggalLahir, String username, String password) {
        this.nama = nama;
        this.umur = umur;
        this.noTelp = noTelp;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.username = username;
        this.password = password;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public int getUmur() {
        return umur;
    }

    public void setTglLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTglLahir() {
        return tanggalLahir;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getNoTelp() {
        return noTelp;
    }
}
