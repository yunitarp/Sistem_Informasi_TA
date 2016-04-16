/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Aplikasi;
import View.MainFrame;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object a = e.getSource();
        if (a.equals(main.getBtnSignUp()))
        {
            show("insertDosen");
        }
        
        if (a.equals(main.getLogin()))
        {
       
            String d = apps.login(main.getUsenameLogIn().getText(), main.getPasswordLogIn().getText());
            if (d.equals("dosen")) {
                main.showMessage("Login Dosen");
            }
            else if (d.equals("mahasiswa")) {
                main.showMessage("Login Mahasiswa");
            }
            else if (d.equals("salah")) {
                main.showMessage("Login Gagal", "Error Coy", JOptionPane.ERROR_MESSAGE);
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
    }
    
    
    
}
