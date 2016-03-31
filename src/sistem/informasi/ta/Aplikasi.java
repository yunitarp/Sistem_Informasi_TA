/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.informasi.ta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yunitarp2706
 */
public class Aplikasi {
    private ArrayList<Dosen> daftarDosen = new ArrayList<>();
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    int loggedin;
    Scanner sc = new Scanner(System.in);
    
    public void addDosen(String nama, String status, String nip, String kodeDosen, int maxTopikTA ){
        Dosen d = new Dosen(status, nip, kodeDosen, maxTopikTA, nama, loggedin, nip, nama, nama, nama, status);
        daftarDosen.add(d);
        try{
            FileOutputStream fos = new FileOutputStream(new File("file_dosen.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(daftarDosen);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException ex) {
            System.err.println("error File Not Found");
        }  catch (IOException ex) {
            System.err.println("Error : "+ex);
        }
    }
    
    public void ViewMahasiswaBimbingan() {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            daftarMahasiswa.get(i).toString();
        }
    } 
    
    public Mahasiswa getMahasiswa(String nim){
        try{
            for(int i=0; i<daftarMahasiswa.size(); i++){
            if(daftarMahasiswa.get(i).getNim().equals(nim)){
                return daftarMahasiswa.get(i);
            }
            return null;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            
        }
        return null;
    }
    
    public boolean deleteDosen(String kodeDosen){
        try{
             for(int i=0; i<daftarDosen.size(); i++){
                if(daftarDosen.get(i).getKodeDosen().toLowerCase().equals(kodeDosen.toLowerCase())){
                    daftarDosen.remove(i);
                    return true;
                }
            }
            return false;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public void viewKelompokTA(String judul){
        try{
             int no = 0;
             for(int i=0; i<daftarMahasiswa.size(); i++){
//                if(daftarMahasiswa.get(i).tugasAkhir.getJudul().equals(judul.toLowerCase())){
//                System.out.println((no+1)+". "+"Nama : "+daftarMahasiswa.get(i).getNama());
//                System.out.println((no+1)+". "+"Nama : "+daftarMahasiswa.get(i).getNim());
//                System.out.println((no+1)+". "+"Nama : "+daftarMahasiswa.get(i).getStatus());

                 System.out.println(daftarMahasiswa.get(i).toString());
                return;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
    
    public void mainMenu(){
        String pilihan;
        System.out.println("MENU UTAMA");
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        System.out.println("3. Exit");
        System.out.print("Masukkan pilihan :");
        pilihan = sc.next();
        switch(pilihan){
            case "1" : System.out.print("Username : ");
                      String username = sc.next();
                      System.out.print("Password : ");
                      String password = sc.next();
                      String status = login(username, password);
                      if(status=="masiswa"){
                          menuMahasiswa();
                      }else
                      if(status =="dosen"){
                          menuDosen();
                      } else{
                          System.out.println("Akun tidak tersedia");
                      }
                      
                      break;
            case "2" : 
        }
    }
    
    public String login(String username, String pw){
        for (Dosen dosen : daftarDosen) {
            if(dosen.getUsername()==username && dosen.getPassword()==pw){
                loggedin = daftarDosen.indexOf(dosen);
                return "dosen";
            }
        }
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa.getUsername()==username && mahasiswa.getPassword()==pw) {
                loggedin = daftarMahasiswa.indexOf(mahasiswa);
                return "mahasiswa";
            }
        }
        return "salah";
        
        
    }
    public void menuDosen(){
        System.out.println("1. Create Kelompok TA");
        System.out.println("2. View Mahasiswa Bimbingan");
        System.out.println("3. View TA");
        System.out.println("4. Log out");
    }
    public void menuMahasiswa(){
        System.out.println("1. Create TA ");
        System.out.println("2. Revisi Judul TA");
        System.out.println("3. Set Pembimbing");
        System.out.println("4. View Kelompok TA"); // harus ada daftar dosen pembimbing
    }
    public void menuSignUp(){
        String pilihan=null;
        do{
        System.out.println("1. Dosen");
        System.out.println("2. Mahasiswa");
        System.out.println("3. Back");
        pilihan = sc.next();
        switch (pilihan) {
            case "1" :  System.out.print("Nama : ");
                        String namaDosen = sc.next();
                        System.out.print("Nip : ");
                        String nip = sc.next();
                        System.out.print("Kode Dosen : ");
                        String kodeDosen = sc.next();
                        System.out.print("No Telepon : ");
                        String noTelpDosen = sc.next();
                        System.out.print("Alamat : ");
                        String alamatDosen = sc.next();
                        System.out.print("Tanggal Lahir : ");
                        String tglLahirDosen = sc.next();
                        System.out.print("Username : ");
                        String usernameDosen = sc.next();
                        System.out.print("Password : ");
                        String passwordDosen = sc.next();
                        break;
            case "2" : System.out.print("Nama : ");
                       String namaMhs = sc.next();
                       System.out.print("Nim : ");
                       String nim = sc.next();
                       System.out.print("Status : ");
                       String status = sc.next();
                       System.out.print("No Telpon : ");
                       String noTelpMahasiswa = sc.next();
                       System.out.print("Alamat : ");
                       String alamatMahasiswa = sc.next();
                       System.out.print("Tanggal Lahir : ");
                       String tglLahirMahasiswa = sc.next();
                       System.out.print("Username : ");
                       String usernameMahasiswa = sc.next();
                       System.out.print("Password : ");
                       String passwordMahasiswa = sc.next();
                       break;
            default : System.out.println("Pilihan yang anda masukkan salah");
        }
        } while(pilihan!="3");    
    
        
    }
    
}
