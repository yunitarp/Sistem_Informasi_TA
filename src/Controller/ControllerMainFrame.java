/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Aplikasi;
import Models.Dosen;
import Models.KelompokTA;
import Models.Mahasiswa;
import Models.TugasAkhir;
import Models.Mahasiswa;
import View.MainFrame;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yunitarp2706
 */
public class ControllerMainFrame implements ActionListener{
    
    private Aplikasi apps;
    private MainFrame main;

    public void initTheme()
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public ControllerMainFrame() {
        apps = new Aplikasi();
        
        initTheme();
        main = new MainFrame();
        
        main.getBtnSignUp().addActionListener(this);
        main.getBtnLogin().addActionListener(this);
        main.getLogin().addActionListener(this);
        main.getLoginBack().addActionListener(this);
        main.getSignUpDosen().addActionListener(this);
        main.getSignUpMahasiswa().addActionListener(this);
        main.getDaftarDosen().addActionListener(this);
        main.getBackDosen().addActionListener(this);
        main.getDaftarMahasiswa().addActionListener(this);
        main.getBackMahasiswa().addActionListener(this);
        main.getCreateKelompokTA().addActionListener(this);
        main.getHapusMahasiswaBimbingan().addActionListener(this);
        main.getTambahMahasiswaBimbingan().addActionListener(this);
        main.getViewTA().addActionListener(this);
        main.getViewMahasiswaBimbingan().addActionListener(this);
        main.getLogoutDosen().addActionListener(this);
        main.getCancelCreateKelompokTA().addActionListener(this);
        main.getHomeCreateKelompokTA().addActionListener(this);
        main.getUpdateCreateKelompokTA().addActionListener(this);
        main.getHomeTambahMahasiswa().addActionListener(this);
        main.getAddTambahMahasiswa().addActionListener(this);
        main.getCekViewKelompokTA().addActionListener(this);
//        main.getTabelViewKelompokTA().addAncestorListener(listener);
        main.getHomeViewMahasiswaBimbingan().addActionListener(this);
        main.getHomeViewTA().addActionListener(this);
      //  main.getTabelViewTA().addAncestorListener(listener);
        main.getHomeHapusMahasiswa().addActionListener(this);
        main.getDeleteHapusMahasiswa().addActionListener(this);
        main.getLogoutMahasiswa().addActionListener(this);
        main.getCreateTA().addActionListener(this);
        main.getRevisiJudulTA().addActionListener(this);
        main.getSetPembimbing().addActionListener(this);
        main.getHomeCreateTA().addActionListener(this);
        main.getInsertCreateTA().addActionListener(this);
        main.getHomeRevisiJudulTA().addActionListener(this);
        main.getUpdateRevisiJudulTA().addActionListener(this);
        main.getHomeSetPembimbing().addActionListener(this);
        main.getPilihDosenPembimbing().addActionListener(this);
        main.getButtonTambahTambahMahasiswaBimbingan().addActionListener(this);
        main.getTambahMahasiswaBimbingan().addActionListener(this);
        main.getJudulTACreateTA().addActionListener(this);
        main.getFieldTopikTAViewMahasiswaBimbingan().addActionListener(this);
        main.getBackTambahMahasiswaBimbingan().addActionListener(this);
        main.getViewTAMenuDosen().addActionListener(this);
        main.getButtonLihatDosenPembimbing().addActionListener(this);
        main.getBackSignUp().addActionListener(this);
        
        main.setResizable(false);
        main.setLocationRelativeTo(null);
        main.setVisible(true);
//        main = new 
    }
    
    /**
     * Method untuk memindah card pada cardLayout
     * @param cardName 
     */
    public void show(String cardName)
    {
        CardLayout card = (CardLayout) main.getDasar().getLayout();
        card.show(main.getDasar(), cardName);
        
    }
    
     public void addMahasiswaToTable(JTable table, ArrayList<Mahasiswa> mhs)
    {
        String[] columnMahasiswa = {"Nim", "Nama"};
        DefaultTableModel tb = new DefaultTableModel(columnMahasiswa, 0);
        for (Mahasiswa m : mhs)
        {
            String[] data = {m.getNim(), m.getNama()};
            tb.addRow(data);
        }
        table.setModel(tb);
    }
     
     public void addViewKelompokTAToTable(JTable table, ArrayList<String> viewTA)
    {
        String[] columnKelompokTA = {"No", "Judul TA"};
        DefaultTableModel tb = new DefaultTableModel(columnKelompokTA, 0);
        ArrayList<String> ta = apps.viewTA(main.getFieldSearchTopikViewTA().getText());
        int no = 0;
        for (String t : ta)
        {
            no += 1;
            String[] data = {no+"", t};
            tb.addRow(data);
        }
        table.setModel(tb);
    }
     
     public void addDosenPembimbingToTable(JTable table, ArrayList<Dosen> dosenPembimbing){
         String[] columnDosen = {"No", "Nama Dosen", "Kode Dosen"};
        DefaultTableModel tb = new DefaultTableModel(columnDosen, 0);
        int no=0;
        for (Dosen d : dosenPembimbing)
        {
            no+=1;
            String[] data = {no+"", d.getNama(), d.getKodeDosen()};
            tb.addRow(data);
        }
        table.setModel(tb);
     }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object a = e.getSource();
        if (a.equals(main.getBtnSignUp()))
        {
            show("SignUp");
        }
        
        if (a.equals(main.getLogin()))
        {
            //apps.login(username, pw);
            String d = apps.login(main.getUsenameLogIn().getText(), main.getPasswordLogIn().getText());
            if (d.equals("dosen")) {
                apps.menuDosen();
                show("MenuDosen");
            }
            else if (d.equals("mahasiswa")) {
                apps.menuMahasiswa();
                show("MenuMahasiswa");
            }
            else if (d.equals("salah")) {
                main.showMessage("Login Gagal", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (a.equals(main.getLoginBack())) {
            show("HalamanUtama");
        }
        
        if (a.equals(main.getBtnLogin()))
        {
            show("HalamanLogin");
        }
        
        if (a.equals(main.getBtnSignUp()))
        {
            apps.menuSignUp();
            show("SignUp");
        }
        
        if (a.equals(main.getDaftarDosen()))
        {
            
        }
        
        if (a.equals(main.getSignUpDosen()))
        {
            show("DosenSignUp");
        }
        
        if (a.equals(main.getBackDosen()))
        {
            show("HalamanUtama");
        }
        
        if (a.equals(main.getDaftarDosen()))
        {
            
        }
        if(a.equals(main.getSignUpMahasiswa())){
            show("MahasiswaSignUp");
        }
        if (a.equals(main.getBackMahasiswa()))
        {
            show("HalamanUtama");
        }
        
        if(a.equals(main.getDaftarMahasiswa()))
        {
            apps.menuSignUp();
            String namaMhs = main.getFieldNamaMahasiswaSignUp().getText();
            String nim = main.getFieldNimMahasiswaSignUp().getText();
            String status = main.getFieldStatusMahasiswaSignUp().getText();
            String notelfon = main.getFieldNoTelfonMahasiswaSignUp().getText();
            String alamat = main.getFieldAlamatMahasiswaSignUp().getText();
            String tgllahir = main.getFieldTglLahirMahasiswaSignUp().getText();
            String username = main.getFieldUserNameMahasiswaSignUp().getText();
            String password = main.getFieldPasswordMahasiswaSignUp().getText();
            
            Mahasiswa m = new Mahasiswa(namaMhs, nim, status, notelfon, alamat, tgllahir, username, password);
            if(apps.SignUpMahasiswa(m, true)){
                main.showMessage("Sign Up Berhasil!");
            }else{
                main.showMessage("Sign Up Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (a.equals(main.getCreateKelompokTA()))
        {
            show("HalamanCreateKelompokTA");
        }
        
        if (a.equals(main.getTambahMahasiswaBimbingan()))
        {
           
            show("HalamanTambahMahasiswaBimbingan");
        }
        
        if(a.equals(main.getHapusMahasiswaBimbingan()))
        {
            show("HapusMahasiswaBimbingan");
        }
        
        if(a.equals(main.getViewTA()))
        {
            show("ViewTA");
        }
        
        if(a.equals(main.getViewMahasiswaBimbingan()))
        {
            show("ViewMahasiswaBimbingan");
        }
        
        if(a.equals(main.getLogoutDosen()))
        {
            
            show("HalamanUtama");
        }
        
        if (a.equals(main.getUpdateCreateKelompokTA()))
        {
            String topik = main.getFieldTopikTA().getText();
            KelompokTA k = new KelompokTA(topik);
            if(apps.createKelompokTA(topik)){
                main.showMessage("Kelompok TA Berhasil ditambahkan!");
            }else{
                main.showMessage("Kelompok TA Gagal ditambahakan", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(a.equals(main.getCancelCreateKelompokTA()))
        {
            show("MenuDosen");
        }
        
        if(a.equals(main.getHomeCreateKelompokTA()))
        {
            show("MenuDosen");
        }
        
        if(a.equals(main.getTambahMahasiswaBimbingan()))
        {
           show("HalamanTambahMahasiswaBimbingan");
        }
        
        if(a.equals(main.getHomeTambahMahasiswa()))
        {
            show("MenuDosen");
        }
        
        if(a.equals(main.getHomeViewMahasiswaBimbingan()))
        {
         show("MenuDosen");   
        }
        
        if(a.equals(main.getHomeViewTA()))
        {
            show("MenuDosen");
        }
        
        if(a.equals(main.getHomeHapusMahasiswa()))
        {
            show("MenuDosen");
        }
        
        if(a.equals(main.getDeleteHapusMahasiswa()))
        {
          if(apps.hapusMahasiswaBimbingan(main.getFieldTopikTAHapusMahasiswaBimbingan().getText(), main.getFieldNimHapusMahasiswaBimbingan().getText())){
              main.showMessage("Mahasiswa Berhasil Dihapus");
          }else{
              main.showMessage("Gagal Menghapus Mahasiswa", "Error", JOptionPane.ERROR_MESSAGE);
          }
            
        }
        
        if(a.equals(main.getLogoutMahasiswa()))
        {
            show("HalamanUtama");
        }
        
        if(a.equals(main.getCreateTA()))
        {
            show("CreateTA");
        }
        
        if(a.equals(main.getRevisiJudulTA()))
        {
            show("RevisiJudulTA");
        }
        
        if(a.equals(main.getSetPembimbing()))
        {
            show("SetPembimbing");
            
        }
        
        if(a.equals(main.getHomeCreateTA()))
        {
            show("MenuMahasiswa");
        }
        
        if(a.equals(main.getInsertCreateTA()))
        {
        }
        
        if(a.equals(main.getHomeCreateTA()))
        {
            show("MenuMahasiswa");
        }
        
        if(a.equals(main.getHomeRevisiJudulTA()))
        {
            show("MenuMahasiswa");
        }
        
        if(a.equals(main.getUpdateRevisiJudulTA()))
        {
            if(apps.revisiJudulTA(main.getFieldJudulTABaru().getText())){
                main.showMessage("Judul TA Berhasil di revisi");
            }else{
                main.showMessage("Gagal merevisi judul TA", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(a.equals(main.getHomeSetPembimbing()))
        {
            show("MenuMahasiswa");
        }
        
        if(a.equals(main.getPilihDosenPembimbing()))
        {
            int i = Integer.parseInt(main.getFieldIndexPembimbingSetPembimbing().getText());
            int n = Integer.parseInt(main.getFieldKodeDosenSetPembimbing().getText());
            if(apps.setPembimbing(n,i)){
                main.showMessage("Dosen Pembimbing berhasil di set");
            }else{
                main.showMessage("Gagal menset dosen Pembimbing", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(a.equals(main.getDaftarDosen())){
            apps.menuSignUp();
            String namaDosen = main.getFieldNamaDosenSignUp().getText();
            String nip = main.getFieldNipDosenSignUp().getText();
            String kodedosen = main.getFieldKodeDosenSignUp().getText();
            String notelfon = main.getFieldNomorTelfonSignUpDosen().getText();
            String alamat = main.getFieldAlamatSignUpDosen().getText();
            String tgllahir = main.getFieldTglLahirDosenSignUp().getText();
            String username = main.getFieldUsernameDosenSignup().getText();
            String password = main.getFieldPasswordDosenSignUp().getText();
            
            Dosen d = new Dosen(namaDosen, nip, kodedosen, notelfon, alamat, tgllahir, username, password);
            if(apps.SignUpDosen(d, true)){
                main.showMessage("Sign Up Berhasil!");
            }else{
                main.showMessage("Sign Up Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            }
       }
       if(a.equals(main.getBackSignUp())){
           show("HalamanUtama");
       }
       if(a.equals(main.getViewTAMenuDosen())){
           addViewKelompokTAToTable(main.getTabelViewTA(), apps.viewTA(main.getFieldSearchTopikViewTA().getText()));
       }
       if(a.equals(main.getButtonTambahTambahMahasiswaBimbingan())){
           apps.updateFileDosen();
           if(apps.tambahMahasiswaBimbingan(main.getFieldTopikTATambahAnggota().getText(), main.getFieldNimMahasiswaTambahMahasiswaBimbingan().getText())){
               main.showMessage("Mahasiswa Berhasil Ditambahkan");
           }else{
               main.showMessage("Mahasiswa gagal ditambahkan, topik belum dibuat atau mahasiswa sudah ditambahkan", "Gagal", JOptionPane.ERROR_MESSAGE);
           }
       }
       if(a.equals(main.getBackTambahMahasiswaBimbingan())){
           show("MenuDosen");
       }
       if(a.equals(main.getInsertCreateTA())){
           if(apps.createTA(main.getJudulTACreateTA().getText())){
               main.showMessage("Tugas Akhir Berhasil Dibuat");
           }else{
               main.showMessage("Tugas Akhir Gagal Dibuat", "Gagal", JOptionPane.ERROR_MESSAGE);
           }
       }
       if(a.equals(main.getCekViewKelompokTA())){
           apps.updateFileDosen();
           apps.updateFileMahasiswa();
           KelompokTA ta = apps.viewMahasiswaBimbingan(main.getFieldTopikTAViewMahasiswaBimbingan().getText());
           if(ta != null){
                addMahasiswaToTable(main.getTabelViewKelompokTA(),apps.getMahasiswaBimbingan(ta));
           }else{
               main.showMessage("Topik ta belum dibuat","Error", JOptionPane.ERROR_MESSAGE);
           }
          
       }
       if(a.equals(main.getButtonLihatDosenPembimbing())){
           apps.updateFileDosen();
           addDosenPembimbingToTable(main.getTableDosenPembimbing(), apps.viewDosenPembimbing());
       }
    
    
    
}}
