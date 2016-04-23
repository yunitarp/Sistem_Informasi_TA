/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.Database;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author yunitarp2706
 */
public class Aplikasi{
    private ArrayList<Dosen> daftarDosen = new ArrayList<>();
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    int loggedin;
    Scanner sc = new Scanner(System.in);

    public ArrayList<Mahasiswa> getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

    
    
    public Aplikasi() {
        daftarDosen = readDosen();
        daftarMahasiswa = readMahasiswa();
    }
    
    /*public Aplikasi(){
        db = new Database();
    }*/
    
    public void updateFileDosen(){
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
    
    public void updateFileMahasiswa(){
        try{
            FileOutputStream fos = new FileOutputStream(new File("file_mahasiswa.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(daftarMahasiswa);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException ex) {
            System.err.println("error File Not Found");
        }  catch (IOException ex) {
            System.err.println("Error : "+ex);
        }
    }
    
    public void addDosen(String nama, String nip, String kodeDosen, String noTelp, String alamat, String tglLahir, String username, String password){
        Dosen d = new Dosen(nama, nip, kodeDosen, noTelp, alamat, tglLahir, username, password);
        daftarDosen.add(d);
        updateFileDosen();
    }
    
    public void addMahasiswa(String nama, String nim, String status, String noTelp, String alamat, String tglLahir, String username, String password){
        Mahasiswa m = new Mahasiswa(nama, nim, status, noTelp, alamat, tglLahir, username, password);
        daftarMahasiswa.add(m);
        updateFileMahasiswa();
    }
    
    public ArrayList<Dosen> readDosen(){
        try {
            FileInputStream fis = new FileInputStream(new File("file_dosen.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Dosen> daftarDosen = (ArrayList<Dosen>)ois.readObject();
            return daftarDosen;
        } catch (FileNotFoundException ex){
            return new ArrayList<>();
        } catch (EOFException ex){
            return new ArrayList<>();
        } catch (IOException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Mahasiswa> readMahasiswa(){
        try {
            FileInputStream fis = new FileInputStream(new File("file_mahasiswa.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Mahasiswa> daftarMahasiswa = (ArrayList<Mahasiswa>)ois.readObject();
            return daftarMahasiswa;
        } catch (FileNotFoundException ex){
            return new ArrayList<>();
        } catch (EOFException ex){
            return new ArrayList<>();
        } catch (IOException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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


    
    public void mainMenu(){
        String pilihan;

        System.out.println("MENU UTAMA");
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        System.out.println("3. Exit");
        System.out.print("Masukkan pilihan :");
//        switch(pilihan){
 //           case "1" : System.out.print("Username : ");
//                         String username = sc.next();
//                      System.out.print("Password : ");
//                      String password = sc.next();
//                      String status = login(username, password);
//                      if(status.equals("mahasiswa")){
//                          menuMahasiswa();
//                      }else
//                      if(status.equals("dosen")){
//                          menuDosen();
//                      } else{
//                          System.out.println("Akun tidak tersedia");
//                      }
//                      
//                      break;
//            case "2" : menuSignUp();
//                       break;
//        }
//    } while(!pilihan.equals("3"));
    }
    
    public String login(String username, String pw){
        for (Dosen dosen : daftarDosen) {
            if(dosen.getUsername().equals(username) && dosen.getPassword().equals(pw)){
                loggedin = daftarDosen.indexOf(dosen);
                return "dosen";
            }
        }
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa.getUsername().equals(username) && mahasiswa.getPassword().equals(pw)) {
                loggedin = daftarMahasiswa.indexOf(mahasiswa);
                return "mahasiswa";
            }
        }
        return "salah";
        
        
    }
    public void menuDosen(){
            System.out.println("1. Create Kelompok TA");
            System.out.println("2. Tambah Mahasiswa Bimbingan");
            System.out.println("3. Hapus Mahasiswa Bimbingam");
            System.out.println("4. View Mahasiswa Bimbingan");
            System.out.println("5. View TA");
            System.out.println("6. Log out");
//    //           case "1" : System.out.println("Masukkan topik TA : ");
//     //                     String topikInput = sc.next();
//     //                     createKelompokTA(topikInput);
//                          break;
//               case "2" : 
                          
 //                         }
//                          break;
//               case "3" : System.out.print("Masukkan Topik Kelompok TA yang akan dihapus anggotanya : ");
//                          String topikSearchDelete = sc.next();
//                          KelompokTA k2 = daftarDosen.get(loggedin).getKelompokByTopik(topikSearchDelete);
//                          if(k2!=null){
//                              for (int i = 0; i < daftarMahasiswa.size(); i++) {
//                                  if(!k2.getAnggota().contains(daftarMahasiswa.get(i)))
//                                    System.out.println((i+1)+" "+daftarMahasiswa.get(i).getNim()+" | "+daftarMahasiswa.get(i).getNama());
//                              }
//                          }
//                          System.out.print("Masukkan nim urut mahasiswa yang ingin anda hapus : ");
//                              String nim = sc.next();
//                              k2.removeAnggota(nim);
//                              updateFileDosen();
//                          break;
//               case "4" : for(int i=0;i<daftarDosen.get(loggedin).getnTopikTA();i++){
//                                System.out.println(daftarDosen.get(loggedin).getKelompokByIndex(i).getTopikTA());
//                                ArrayList<Mahasiswa> mhs = daftarDosen.get(loggedin).getKelompokByIndex(i).getAnggota();
//                                if(mhs.size()>0)
//                                for (Mahasiswa mh : mhs) {
//                                    System.out.println(mh);
//                                }
//                                else System.out.println("Belum ada mahasiswa");
//                           }
//                          break;
//               case "5" : System.out.println("Masukkan Topik TA :");
//                          String topik = sc.next();
//                          updateFileDosen();
//                          KelompokTA k1 = daftarDosen.get(loggedin).getKelompokByTopik(topik);
//                          if(k1!=null){
//                               for (int i=0; i<daftarMahasiswa.size(); i++){
//                                   if(!k1.getAnggota().contains(daftarMahasiswa.get(i)))
//                                       System.out.println((i+1)+" "+daftarMahasiswa.get(i).getTugasAkhir().getJudul());
//                               }
//                  
//                          }
//               default:
//                   System.out.println("Anda salah memasukkan pilihan");
//           }
//       } while (!pilihan.equals("6"));
    }
    public void menuMahasiswa(){
        String pilihan = null;
 //       do{
           System.out.println("1. Create TA ");
           System.out.println("2. Revisi Judul TA");
           System.out.println("3. Set Pembimbing");
            System.out.println("4. Logout");
           System.out.println("Masukkan pilihan : ");
//           pilihan = sc.next();
//            switch (pilihan) {
//                case "1" : System.out.println("Masukkan Judul Tugas Akhir : ");
//                          String judulTA = sc.next();
//                          
//                          break;
//                case "2" : System.out.println("Masukkan Judul TA baru : ");
//                           String judulTABaru = sc.next();
//                           daftarMahasiswa.get(loggedin).getTugasAkhir().setJudul(judulTABaru);
//                           updateFileMahasiswa();
//                           break;
//                case "3" : System.out.println("Set pembimbing 1/2? :");
//                           int n = sc.nextInt();
//                           for (int i = 0;i<daftarDosen.size(); i++) {
//                               if(!daftarMahasiswa.get(loggedin).getTugasAkhir().getPembimbing().contains(daftarDosen.get(i)))
//                                   System.out.println((i+1)+daftarDosen.get(i).getKodeDosen());
//                            }
//                           System.out.println("Masukkan pilihan : ");
//                           int i = sc.nextInt();
//                           daftarMahasiswa.get(loggedin).getTugasAkhir().setPembimbing(daftarDosen.get(i-1), n);
//                           System.out.println(daftarMahasiswa.get(loggedin).toString());
//                           updateFileMahasiswa();
//                           break;
//                default : System.out.println("Menu yang anda masukkan salah");;
//            }
//        } while (!pilihan.equals("4"));
        
    }
    public void menuSignUp(){
        System.out.println("1. Dosen");
        System.out.println("2. Mahasiswa");
        System.out.println("3. Back");
        System.out.print("Masukkan pilihan : ");
        
    }
    
    public boolean createKelompokTA(String topik){
        daftarDosen.get(loggedin).createKelompokTA(topik);
        updateFileDosen();
        return true;
    }
    
    public boolean createTA(String judul){
        daftarMahasiswa.get(loggedin).createTA(judul);
        updateFileMahasiswa();
        return true;
    }
    
   
   public boolean tambahMahasiswaBimbingan(String kelompokTA, String nim){
       KelompokTA k = daftarDosen.get(loggedin).getKelompokByTopik(kelompokTA);
       if (k.getAnggotaByNim(nim) != null) return false;
       if(k!=null){
           int i = 0;
           for (Mahasiswa mhs : daftarMahasiswa) {
               if(mhs.getNim().equals(nim)){
                  k.addAnggota(daftarMahasiswa.get(i));
                  updateFileDosen(); 
                  return true;
                }
                  i++;
            }
       }
       return false;
   }
   
   public boolean SignUpDosen(Dosen d, boolean status){
       daftarDosen.add(d);
       updateFileDosen();
       return status = true;
   }
   
   public boolean SignUpMahasiswa(Mahasiswa m, boolean status){
       daftarMahasiswa.add(m);
       updateFileMahasiswa();
       return status = true;
   }
   
   public KelompokTA viewMahasiswaBimbingan(String topik){
       updateFileDosen();
       for(int i=0;i<daftarDosen.get(loggedin).getnTopikTA();i++){
            if(daftarDosen.get(loggedin).getKelompokByIndex(i).getTopikTA().equals(topik))
                return daftarDosen.get(loggedin).getKelompokByIndex(i);
       }
       return null;
   }
           
   public ArrayList<String> viewTA(String topik){
        updateFileDosen();
        KelompokTA k1 = daftarDosen.get(loggedin).getKelompokByTopik(topik);
        ArrayList<String> ta = new ArrayList<>();
        if(k1!=null){
            for (int i=0; i<daftarMahasiswa.size(); i++){
                if(!k1.getAnggota().contains(daftarMahasiswa.get(i)))
                    ta.add(daftarMahasiswa.get(i).getTugasAkhir().getJudul());
            }
        }
        return ta;
   }
   
   public ArrayList<Mahasiswa> getMahasiswaBimbingan(KelompokTA kelompok){
       return kelompok.getAnggota();
   }
   
   public boolean hapusMahasiswaBimbingan(String topik, String nim){
       KelompokTA k2 = daftarDosen.get(loggedin).getKelompokByTopik(topik);
       if(k2!=null){
           k2.removeAnggota(nim);
           updateFileDosen();
           return true;
       }else{
           return false;
       }
   }
   
   public boolean revisiJudulTA(String judulTABaru){
       daftarMahasiswa.get(loggedin).getTugasAkhir().setJudul(judulTABaru);
       updateFileMahasiswa();
       return true;
   }
   
   public ArrayList<Dosen> viewDosenPembimbing(){
       updateFileDosen();
       ArrayList<Dosen> d = new ArrayList<>();
       for (int i = 0;i<daftarDosen.size(); i++) {
            if(!daftarMahasiswa.get(loggedin).getTugasAkhir().getPembimbing().contains(daftarDosen.get(i)))
                    d.add(daftarDosen.get(i));
            }
       return d;
   }
   
   public boolean setPembimbing(int i){
       daftarMahasiswa.get(loggedin).getTugasAkhir().setPembimbing(daftarDosen.get(i-1), i);
       updateFileMahasiswa();
       return true;
   }
   
   
    
}
