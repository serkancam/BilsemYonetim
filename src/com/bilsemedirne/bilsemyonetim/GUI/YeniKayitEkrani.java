/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilsemedirne.bilsemyonetim.GUI;

import com.bilsemedirne.bilsemyonetim.ENTITY.*;
import com.bilsemedirne.bilsemyonetim.DAO.*;
import com.bilsemedirne.bilsemyonetim.Islem.Cift;
import com.bilsemedirne.bilsemyonetim.Islem.GorselIslemler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
/**
 *
 * @author serkancam
 */


public class YeniKayitEkrani extends javax.swing.JInternalFrame 
{
    // <editor-fold defaultstate="collapsed" desc="Degişkenler">
   

    Ogrenci ogrenci=null;
    String fotoYolu,hata="";
    Veli anne=null,baba=null;
 
    byte ogrCinsiyet=-1,ogrAileDurumu=-1,anneHayattami=-1,babaHayattami=-1;
    java.util.Date ogrDogumTarihi;
    java.util.Date ogrKayitTarihi;
    int secilenVelitipi=-1,orgunOkulIlcesi=-1,orgunOkul=-1,orgunEgitimSinifSeviyesi=-1,
    bilsemTanimlamaIli=-1,bilsemBaslamaIli=-1,nakilGeldigiBilsem=-1,anneOgrenimDurumu=-1,babaOgrenimDurumu=-1,
     ilkBilsemTanilamaYili=-1,ilkBilsemBaslamaYili=-1;
    String ogrTCNO="",ogrDogumYeri="",ogrAdi="",ogrSoyadi="",ogrOrgunEgitimSubesi="",ogrOrgunEgitimSinifOgretmeni="",
            ogrOrgunEgitimNo="",ogrSurekliIlac="",ogrSurekliHastalik="",anneAd="",anneSoyad="",anneEposta="",anneEvTelefon="",
            anneIsTelefon="",anneCeptelefon="",anneMeslegi="",anneEvAdresi="",anneIsAdresi="",babaAd="",babaSoyad="",babaEposta="",babaEvTelefon="",
            babaIsTelefon="",babaIsAdresi="",babaCeptelefon="",babaMeslegi="",babaEvAdresi="";
    boolean[] yetenekAlanlari={false,false,false};
    
            
           
    // </editor-fold >
   
    // <editor-fold defaultstate="collapsed" desc="Kamera Ayarları">
    public DaemonThread myThread=null;
    int count=0;
    public VideoCapture webSource=null;
    
    Mat frame =new Mat();
    MatOfByte mem=new MatOfByte();
  
    
    public class DaemonThread implements Runnable
    {
     protected volatile boolean runnable = false;

    @Override
    public  void run()
    {
        synchronized(this)
        {
            while(runnable)
            {
                if(webSource.grab())
                {
		    	try
                        {
                            webSource.retrieve(frame);
			    Highgui.imencode(".bmp", frame, mem);
			    Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

			    BufferedImage buff = (BufferedImage) im;
			    Graphics g=pnlKamera.getGraphics();

			    if (g.drawImage(buff, 0, 0, pnlKamera.getWidth(), pnlKamera.getHeight()  , 0, 0, buff.getWidth(), buff.getHeight(), null))
                                
			    
			    if(runnable == false)
                            {
			    	System.out.println("Going to wait()");
			    	this.wait();
			    }
			 }
			 catch(Exception ex)
                         {
			    System.out.println("Error");
                         }
                        
                }
            }
        }
     }
    
}  
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Combobox ların dolurulması">
    void VelitipiCBDoldur()
    {
       List<VeliTipi> tipler =null;
      // VeliTipi vtp=new VeliTipi();
       VeliTipiDAO islem=new VeliTipiDAO();
       tipler=islem.TumVeliTipleriniGetir();
      
        for (VeliTipi vtp : tipler) 
        {
            cbOgrenciVelisiKim.addItem(new Cift(vtp.getVeliTipiKodu(),vtp.getVeliTipiAdi()));          
          
        }
    }
    
    void OkulIlcesiCBDoldur()
    {
       List<Ilce> ilceler =null;
      
       IlceDAO islem=new IlceDAO();
       ilceler=islem.EdirneIlceleriGetir();
      
        for (Ilce gelen : ilceler) 
        {            
            cbOrgunEgitimOkulİlcesi.addItem(new Cift(gelen.getIlceKodu(),gelen.getIlceAdi()));          
            
        }
    }
    
    void OrgunEgitimOkulCBDoldur()
    {
       List<Okul> okullar =null;
      
       OkulDAO islem=new OkulDAO();
       okullar=islem.IlceyeGoreOkullariGetir(orgunOkulIlcesi);
      
        for (Okul gelen : okullar) 
        {
            
            cbOrgunEgitimOkulu.addItem(new Cift(gelen.getOkulKodu(),gelen.getOkulAdi()));          
            
        }
        
    }
    
    void IllerCbDoldur()
    {
        List<Il> iller =null;
      
       IlDAO islem=new IlDAO();
       iller=islem.TumIlleriGetir();
      
        for (Il gelen : iller) 
        {
            
            cbTanilamaIli.addItem(new Cift(gelen.getIlKodu(),gelen.getIlAdi()));  
            cbBilsemBaslamaIli.addItem(new Cift(gelen.getIlKodu(),gelen.getIlAdi()));          
            
        }
    }
    
    void OgrenimDurumuCBDoldur()
    {
        List<OgrenimDurumu> ogrenimDurumlari =null;
      
       OgrenimDurumuDAO islem=new OgrenimDurumuDAO();
       ogrenimDurumlari=islem.TumOgrenimDurumlariGetir();
      
        for (OgrenimDurumu gelen : ogrenimDurumlari) 
        {            
            cbAnneOgrenimDurumu.addItem(new Cift(gelen.getOgrenimDurumuKodu(),gelen.getOgrenimDurumuAdi()));                        
            cbBabaOgrenimDurumu.addItem(new Cift(gelen.getOgrenimDurumuKodu(),gelen.getOgrenimDurumuAdi()));
            
        }
    }
    
    void BilsemlerCBDoldur()
    {
       List<Bilsemler> bilsemler =null;
      
       BilsemlerDAO islem=new BilsemlerDAO();
       bilsemler=islem.TumBilsemleriGetir();
      
        for (Bilsemler gelen : bilsemler) 
        {            
            cbNakilGelinenBilsem.addItem(new Cift(gelen.getBilsemKodu(),gelen.getBilsemAdi()));                        
            
            
        }
    }
    // </editor-fold>
    
    public YeniKayitEkrani() 
    {        
        initComponents();      
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        rbgCinsiyet = new javax.swing.ButtonGroup();
        rbgAileDurumu = new javax.swing.ButtonGroup();
        rbgBabaOgreniDurumu = new javax.swing.ButtonGroup();
        rbgAnneOgrenimDurumu = new javax.swing.ButtonGroup();
        rbgAnneHayattami = new javax.swing.ButtonGroup();
        rbgBabaHayattami = new javax.swing.ButtonGroup();
        pnlOgrenci = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOgrenciTCNO = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtOgrenciSoyadi = new javax.swing.JTextField();
        rbKiz = new javax.swing.JRadioButton();
        rbErkek = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtOgrenciDogumYeri = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbOgrenciSinifSeviyesi = new javax.swing.JComboBox<>();
        cbOrgunEgitimOkulİlcesi = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtOrgunEgitimOgretmeni = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtOrgunEgitimNumarasi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSurekliHastalik = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSurekliIlac = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTanilamaYili = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        cbBilsemBaslamaIli = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtBilsemBaslamaYili = new javax.swing.JFormattedTextField();
        cbTanilamaIli = new javax.swing.JComboBox<>();
        cbNakilGelinenBilsem = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtKayitTarihi = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        rbAyri = new javax.swing.JRadioButton();
        rbBeraber = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        cbOgrenciVelisiKim = new javax.swing.JComboBox<>();
        btnFotograCek = new javax.swing.JButton();
        pnlKamera = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOgrenciAdres = new javax.swing.JTextArea();
        pnlFotograf = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtOrgunEgitimSubesi = new javax.swing.JTextField();
        cbOrgunEgitimOkulu = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        chkbGenel = new javax.swing.JCheckBox();
        chkbGorsel = new javax.swing.JCheckBox();
        chkbMuzik = new javax.swing.JCheckBox();
        jLabel44 = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        txtOgrenciAdi = new javax.swing.JTextField();
        txtOgrenciDogumTarihi = new javax.swing.JFormattedTextField();
        pnlVeliBilgileri = new javax.swing.JPanel();
        pnlAnneBilgileri = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtAnneMeslegi = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtAnneIsTelefonu = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAnneEvAdresi = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        cbAnneOgrenimDurumu = new javax.swing.JComboBox<>();
        rbAnneHayir = new javax.swing.JRadioButton();
        jLabel28 = new javax.swing.JLabel();
        rbAnneEvet = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnneIsAdresi = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtAnneCepTelefonu = new javax.swing.JTextField();
        txtAnneSoyadi = new javax.swing.JTextField();
        txtAnneAdi = new javax.swing.JTextField();
        txtAnneEvTelefonu = new javax.swing.JTextField();
        txtAnneEposta = new javax.swing.JTextField();
        pnlBabaBilgileri = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtBabaIsTelefonu = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtBabaSoyadi = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtBabaEvAdresi = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtBabaIsAdresi = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        rbBabaEvet = new javax.swing.JRadioButton();
        cbBabaOgrenimDurumu = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        rbBabaHayir = new javax.swing.JRadioButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtBabaEposta = new javax.swing.JTextField();
        txtBabaMeslegi = new javax.swing.JTextField();
        txtBabaAdi = new javax.swing.JTextField();
        txtBabaEvTelefonu = new javax.swing.JTextField();
        txtBabaCepTelefonu = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);
        setMaximumSize(new java.awt.Dimension(1360, 700));
        setMinimumSize(new java.awt.Dimension(1360, 630));
        setPreferredSize(new java.awt.Dimension(1360, 700));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener()
        {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt)
            {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt)
            {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.jdesktop.swingx.HorizontalLayout());

        pnlOgrenci.setBorder(javax.swing.BorderFactory.createTitledBorder("Öğrenci Bilgileri"));
        pnlOgrenci.setMinimumSize(new java.awt.Dimension(910, 605));
        pnlOgrenci.setPreferredSize(new java.awt.Dimension(910, 680));
        pnlOgrenci.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("TC Kimlik NO");
        pnlOgrenci.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, -1));

        jLabel2.setText("Adı");
        pnlOgrenci.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtOgrenciTCNO.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtOgrenciTCNOKeyReleased(evt);
            }
        });
        pnlOgrenci.add(txtOgrenciTCNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 180, 30));

        jLabel3.setText("Soyadı");
        pnlOgrenci.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));
        pnlOgrenci.add(txtOgrenciSoyadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 180, 30));

        rbgCinsiyet.add(rbKiz);
        rbKiz.setText("Kız");
        rbKiz.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbKizItemStateChanged(evt);
            }
        });
        pnlOgrenci.add(rbKiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 46, -1));

        rbgCinsiyet.add(rbErkek);
        rbErkek.setText("Erkek");
        rbErkek.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbErkekItemStateChanged(evt);
            }
        });
        pnlOgrenci.add(rbErkek, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        jLabel4.setText("Doğum Tarihi");
        pnlOgrenci.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel5.setText("Doğum Yeri");
        pnlOgrenci.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtOgrenciDogumYeri.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOgrenciDogumYeri.setPreferredSize(new java.awt.Dimension(116, 20));
        pnlOgrenci.add(txtOgrenciDogumYeri, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 180, 30));

        jLabel6.setText("Cinsiyet");
        pnlOgrenci.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel7.setText("<html>Devam Ettiği Okul</html>");
        pnlOgrenci.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 110, 40));

        cbOgrenciSinifSeviyesi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sınıf Seviyesi", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " ", " ", " " }));
        cbOgrenciSinifSeviyesi.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cbOgrenciSinifSeviyesiActionPerformed(evt);
            }
        });
        pnlOgrenci.add(cbOgrenciSinifSeviyesi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 180, 30));

        cbOrgunEgitimOkulİlcesi.setModel(new javax.swing.DefaultComboBoxModel<>(new Cift[] { new Cift(-1,"İlçe Seç")}));
        cbOrgunEgitimOkulİlcesi.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cbOrgunEgitimOkulİlcesiActionPerformed(evt);
            }
        });
        pnlOgrenci.add(cbOrgunEgitimOkulİlcesi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 180, 30));

        jLabel8.setText("<html>Sınıf/Rehber Öğretmeninin Adı-Soyadı </html>");
        pnlOgrenci.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 130, 40));

        txtOrgunEgitimOgretmeni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnlOgrenci.add(txtOrgunEgitimOgretmeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 180, 30));

        jLabel9.setText("<html>Devam ettiği Okuldaki Öğrenci Numarası</html>");
        pnlOgrenci.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 130, 40));
        pnlOgrenci.add(txtOrgunEgitimNumarasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 180, 30));

        jLabel10.setText("Sürekli Hastalık");
        pnlOgrenci.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 90, 30));
        pnlOgrenci.add(txtSurekliHastalik, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 200, 30));

        jLabel11.setText("<html>Sürekli Kullanılan İlaç</html>");
        pnlOgrenci.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 110, 30));
        pnlOgrenci.add(txtSurekliIlac, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 200, 30));

        jLabel12.setText("Adres");
        pnlOgrenci.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 60, -1));

        jLabel13.setText("<html>Bilsem Tanımlama Yılı</html>");
        pnlOgrenci.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 100, 30));

        txtTanilamaYili.setColumns(4);
        try
        {
            txtTanilamaYili.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }
        txtTanilamaYili.setText("2018");
        pnlOgrenci.add(txtTanilamaYili, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 120, 30));

        jLabel14.setText("<html>Bilseme Tanımlama İli</html>");
        pnlOgrenci.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 110, 30));

        cbBilsemBaslamaIli.setModel(new javax.swing.DefaultComboBoxModel<>(new Cift[] { new Cift(-1,"İl Seç")})
        );
        cbBilsemBaslamaIli.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cbBilsemBaslamaIliActionPerformed(evt);
            }
        });
        pnlOgrenci.add(cbBilsemBaslamaIli, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 150, 30));

        jLabel15.setText("<html>İlk Bilsem Başlama Yılı</html>");
        pnlOgrenci.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 110, 40));

        jLabel16.setText("<html>Bilsem Başlama İli</html>");
        pnlOgrenci.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 120, 30));

        try
        {
            txtBilsemBaslamaYili.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }
        txtBilsemBaslamaYili.setText("2018");
        pnlOgrenci.add(txtBilsemBaslamaYili, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 120, 30));

        cbTanilamaIli.setModel(new javax.swing.DefaultComboBoxModel<>(new Cift[] { new Cift(-1,"İl Seç")}));
        cbTanilamaIli.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cbTanilamaIliActionPerformed(evt);
            }
        });
        pnlOgrenci.add(cbTanilamaIli, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 150, 30));

        cbNakilGelinenBilsem.setMaximumRowCount(6);
        cbNakilGelinenBilsem.setModel(new javax.swing.DefaultComboBoxModel<>(new Cift[] { new Cift(-1,"Nakil Gelinen Bilsem Seç")}));
        cbNakilGelinenBilsem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cbNakilGelinenBilsemActionPerformed(evt);
            }
        });
        pnlOgrenci.add(cbNakilGelinenBilsem, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 200, 30));

        jLabel17.setText("<html>Nakil Geldiği Bilsem</html>");
        pnlOgrenci.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 100, 30));

        jLabel18.setText("Kayıt Tarihi");
        pnlOgrenci.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 120, 30));

        txtKayitTarihi.setEditable(false);
        txtKayitTarihi.setColumns(10);
        try
        {
            txtKayitTarihi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##.####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }
        txtKayitTarihi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtKayitTarihi.setPreferredSize(new java.awt.Dimension(116, 21));
        pnlOgrenci.add(txtKayitTarihi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 180, 30));

        jLabel19.setText("Aile Durumu");
        pnlOgrenci.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        rbgAileDurumu.add(rbAyri);
        rbAyri.setText("Ayrı");
        rbAyri.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbAyriItemStateChanged(evt);
            }
        });
        pnlOgrenci.add(rbAyri, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 60, -1));

        rbgAileDurumu.add(rbBeraber);
        rbBeraber.setText("Beraber");
        rbBeraber.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbBeraberItemStateChanged(evt);
            }
        });
        pnlOgrenci.add(rbBeraber, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 80, -1));

        jLabel20.setText("<html>Veli</html>");
        pnlOgrenci.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 40, 40));

        cbOgrenciVelisiKim.setModel(new javax.swing.DefaultComboBoxModel<>(new Cift[] { new Cift(-1,"Veli Seç")}));
        cbOgrenciVelisiKim.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cbOgrenciVelisiKimActionPerformed(evt);
            }
        });
        pnlOgrenci.add(cbOgrenciVelisiKim, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 180, 30));

        btnFotograCek.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFotograCek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bilsemedirne/bilsemyonetim/GUI/icons/screenshot-filled.png"))); // NOI18N
        btnFotograCek.setText("Fotoğraf Çek");
        btnFotograCek.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnFotograCekActionPerformed(evt);
            }
        });
        pnlOgrenci.add(btnFotograCek, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, 160, 50));

        pnlKamera.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout pnlKameraLayout = new javax.swing.GroupLayout(pnlKamera);
        pnlKamera.setLayout(pnlKameraLayout);
        pnlKameraLayout.setHorizontalGroup(
            pnlKameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        pnlKameraLayout.setVerticalGroup(
            pnlKameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        pnlOgrenci.add(pnlKamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 160, 130));

        txtOgrenciAdres.setColumns(50);
        txtOgrenciAdres.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtOgrenciAdres.setLineWrap(true);
        txtOgrenciAdres.setRows(5);
        jScrollPane2.setViewportView(txtOgrenciAdres);

        pnlOgrenci.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 200, 100));

        pnlFotograf.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout pnlFotografLayout = new javax.swing.GroupLayout(pnlFotograf);
        pnlFotograf.setLayout(pnlFotografLayout);
        pnlFotografLayout.setHorizontalGroup(
            pnlFotografLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        pnlFotografLayout.setVerticalGroup(
            pnlFotografLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        pnlOgrenci.add(pnlFotograf, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 160, 130));

        jLabel39.setText("<html>Örgün eğtimdeki Sınıfı Şubesi </html>");
        pnlOgrenci.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 130, 40));

        jLabel40.setText("<html>Örgün eğtimdeki Sınıfı Seviyesi </html>");
        pnlOgrenci.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 130, 40));
        pnlOgrenci.add(txtOrgunEgitimSubesi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 180, 30));

        cbOrgunEgitimOkulu.setModel(new javax.swing.DefaultComboBoxModel<>(new Cift[] { new Cift(-1,"Okul Seç")})
        );
        cbOrgunEgitimOkulu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cbOrgunEgitimOkuluActionPerformed(evt);
            }
        });
        pnlOgrenci.add(cbOrgunEgitimOkulu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 180, 30));

        jLabel41.setText("<html>Devam Ettiği Okul İlçesi</html>");
        pnlOgrenci.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 110, 40));

        chkbGenel.setText("Genel Zihinsel");
        chkbGenel.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                chkbGenelItemStateChanged(evt);
            }
        });
        pnlOgrenci.add(chkbGenel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, -1));

        chkbGorsel.setText("Görsel Sanatlar");
        chkbGorsel.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                chkbGorselItemStateChanged(evt);
            }
        });
        pnlOgrenci.add(chkbGorsel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, -1, -1));

        chkbMuzik.setText("Müzik");
        chkbMuzik.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                chkbMuzikItemStateChanged(evt);
            }
        });
        pnlOgrenci.add(chkbMuzik, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 250, -1, -1));

        jLabel44.setText("<html>Öğrencinin Tanımlandığı Yetenek Alanlar</html>");
        pnlOgrenci.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 130, 40));

        btnKaydet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bilsemedirne/bilsemyonetim/GUI/icons/Save-icon.png"))); // NOI18N
        btnKaydet.setText("Kaydet");
        btnKaydet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKaydet.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnKaydetActionPerformed(evt);
            }
        });
        pnlOgrenci.add(btnKaydet, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 580, 160, 50));
        pnlOgrenci.add(txtOgrenciAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 180, 30));

        txtOgrenciDogumTarihi.setColumns(10);
        try
        {
            txtOgrenciDogumTarihi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##.####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }
        txtOgrenciDogumTarihi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOgrenciDogumTarihi.setPreferredSize(new java.awt.Dimension(116, 21));
        pnlOgrenci.add(txtOgrenciDogumTarihi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 180, 30));

        getContentPane().add(pnlOgrenci);

        pnlVeliBilgileri.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Veli Bilgileri")));
        pnlVeliBilgileri.setMinimumSize(new java.awt.Dimension(462, 630));
        pnlVeliBilgileri.setPreferredSize(new java.awt.Dimension(450, 680));
        pnlVeliBilgileri.setLayout(new org.jdesktop.swingx.VerticalLayout());

        pnlAnneBilgileri.setBorder(javax.swing.BorderFactory.createTitledBorder("Anne Bilgileri"));
        pnlAnneBilgileri.setPreferredSize(new java.awt.Dimension(450, 330));
        pnlAnneBilgileri.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setText("Adı:");
        jLabel21.setName("elleme"); // NOI18N
        pnlAnneBilgileri.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, 30));

        txtAnneMeslegi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAnneMeslegi.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(txtAnneMeslegi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 145, 30));

        jLabel22.setText("Soyadı:");
        jLabel22.setName("elleme"); // NOI18N
        pnlAnneBilgileri.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 70, 30));

        txtAnneIsTelefonu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAnneIsTelefonu.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(txtAnneIsTelefonu, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 140, 145, 30));

        jLabel23.setText("Ev telefonu");
        jLabel23.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, 30));

        jLabel24.setText("İş telefonu");
        jLabel24.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 70, 30));

        jLabel25.setText("Cep telefonu");
        jLabel25.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 30));

        jLabel26.setText("Ev adresi");
        jLabel26.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 70, 30));

        jScrollPane1.setName("gizle"); // NOI18N

        txtAnneEvAdresi.setColumns(50);
        txtAnneEvAdresi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtAnneEvAdresi.setLineWrap(true);
        txtAnneEvAdresi.setRows(5);
        txtAnneEvAdresi.setName("gizle"); // NOI18N
        jScrollPane1.setViewportView(txtAnneEvAdresi);

        pnlAnneBilgileri.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 200, 80));

        jLabel27.setText("<html>Öğrenim Durumu</html>");
        jLabel27.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 175, 50, 40));

        cbAnneOgrenimDurumu.setModel(new javax.swing.DefaultComboBoxModel<>(new Cift[] { new Cift(-1,"Öğrenim Durumu Seç")}));
        cbAnneOgrenimDurumu.setName("gizle"); // NOI18N
        cbAnneOgrenimDurumu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cbAnneOgrenimDurumuActionPerformed(evt);
            }
        });
        pnlAnneBilgileri.add(cbAnneOgrenimDurumu, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 180, 145, 30));

        rbgAnneHayattami.add(rbAnneHayir);
        rbAnneHayir.setText("Hayır");
        rbAnneHayir.setName("elleme"); // NOI18N
        rbAnneHayir.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbAnneHayirItemStateChanged(evt);
            }
        });
        pnlAnneBilgileri.add(rbAnneHayir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabel28.setText("Hayatta mı?");
        jLabel28.setName("elleme"); // NOI18N
        pnlAnneBilgileri.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 60, 30));

        rbgAnneHayattami.add(rbAnneEvet);
        rbAnneEvet.setText("Evet");
        rbAnneEvet.setName("elleme"); // NOI18N
        rbAnneEvet.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbAnneEvetItemStateChanged(evt);
            }
        });
        pnlAnneBilgileri.add(rbAnneEvet, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 70, -1));

        jScrollPane3.setName("gizle"); // NOI18N

        txtAnneIsAdresi.setColumns(50);
        txtAnneIsAdresi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtAnneIsAdresi.setLineWrap(true);
        txtAnneIsAdresi.setRows(5);
        txtAnneIsAdresi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtAnneIsAdresi.setName("gizle"); // NOI18N
        jScrollPane3.setViewportView(txtAnneIsAdresi);

        pnlAnneBilgileri.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 80));

        jLabel29.setText("İş adresi");
        jLabel29.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 70, 30));

        jLabel43.setText("<html>Eposta Adresi</html>");
        jLabel43.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 60, 30));

        jLabel46.setText("Mesleği");
        jLabel46.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 70, 30));

        txtAnneCepTelefonu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAnneCepTelefonu.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(txtAnneCepTelefonu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 145, 30));

        txtAnneSoyadi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAnneSoyadi.setName("elleme"); // NOI18N
        pnlAnneBilgileri.add(txtAnneSoyadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 60, 145, 30));

        txtAnneAdi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAnneAdi.setName("elleme"); // NOI18N
        pnlAnneBilgileri.add(txtAnneAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 145, 30));

        txtAnneEvTelefonu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAnneEvTelefonu.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(txtAnneEvTelefonu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 145, 30));

        txtAnneEposta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAnneEposta.setName("gizle"); // NOI18N
        pnlAnneBilgileri.add(txtAnneEposta, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 100, 145, 30));

        pnlVeliBilgileri.add(pnlAnneBilgileri);

        pnlBabaBilgileri.setBorder(javax.swing.BorderFactory.createTitledBorder("Baba Bilgileri"));
        pnlBabaBilgileri.setPreferredSize(new java.awt.Dimension(450, 330));
        pnlBabaBilgileri.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setText("Adı:");
        jLabel31.setName("elleme"); // NOI18N
        pnlBabaBilgileri.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, 30));

        txtBabaIsTelefonu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBabaIsTelefonu.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(txtBabaIsTelefonu, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 140, 145, 30));

        jLabel32.setText("Ev telefonu");
        jLabel32.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, 30));

        txtBabaSoyadi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBabaSoyadi.setName("elleme"); // NOI18N
        pnlBabaBilgileri.add(txtBabaSoyadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 60, 145, 30));

        jScrollPane5.setName("gizle"); // NOI18N

        txtBabaEvAdresi.setColumns(50);
        txtBabaEvAdresi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtBabaEvAdresi.setLineWrap(true);
        txtBabaEvAdresi.setRows(5);
        txtBabaEvAdresi.setName("gizle"); // NOI18N
        jScrollPane5.setViewportView(txtBabaEvAdresi);

        pnlBabaBilgileri.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 200, 80));

        jScrollPane4.setName("gizle"); // NOI18N

        txtBabaIsAdresi.setColumns(50);
        txtBabaIsAdresi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtBabaIsAdresi.setLineWrap(true);
        txtBabaIsAdresi.setRows(5);
        txtBabaIsAdresi.setName("gizle"); // NOI18N
        jScrollPane4.setViewportView(txtBabaIsAdresi);

        pnlBabaBilgileri.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, 80));

        jLabel35.setText("Ev adresi");
        jLabel35.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 70, 30));

        rbgBabaHayattami.add(rbBabaEvet);
        rbBabaEvet.setText("Evet");
        rbBabaEvet.setName("elleme"); // NOI18N
        rbBabaEvet.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbBabaEvetItemStateChanged(evt);
            }
        });
        pnlBabaBilgileri.add(rbBabaEvet, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 70, -1));

        cbBabaOgrenimDurumu.setModel(new javax.swing.DefaultComboBoxModel<>(new Cift[] { new Cift(-1,"Öğrenim Durumu Seç")}));
        cbBabaOgrenimDurumu.setName("gizle"); // NOI18N
        cbBabaOgrenimDurumu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cbBabaOgrenimDurumuActionPerformed(evt);
            }
        });
        pnlBabaBilgileri.add(cbBabaOgrenimDurumu, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 180, 145, 30));

        jLabel38.setText("<html>Öğrenim Durumu</html>");
        jLabel38.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 175, 50, 40));

        rbgBabaHayattami.add(rbBabaHayir);
        rbBabaHayir.setText("Hayır");
        rbBabaHayir.setName("elleme"); // NOI18N
        rbBabaHayir.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbBabaHayirItemStateChanged(evt);
            }
        });
        pnlBabaBilgileri.add(rbBabaHayir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabel30.setText("Hayatta mı?");
        jLabel30.setName("elleme"); // NOI18N
        pnlBabaBilgileri.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 60, 30));

        jLabel34.setText("İş adresi");
        jLabel34.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 70, 30));

        jLabel33.setText("Cep telefonu");
        jLabel33.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 30));

        jLabel36.setText("Soyadı:");
        jLabel36.setName("elleme"); // NOI18N
        pnlBabaBilgileri.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 70, 30));

        jLabel37.setText("İş telefonu");
        jLabel37.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 70, 30));

        jLabel42.setText("<html>Eposta Adresi</html>");
        jLabel42.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 60, 30));

        jLabel45.setText("Mesleği");
        jLabel45.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 70, 30));

        txtBabaEposta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBabaEposta.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(txtBabaEposta, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 100, 145, 30));

        txtBabaMeslegi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBabaMeslegi.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(txtBabaMeslegi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 145, 30));

        txtBabaAdi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBabaAdi.setName("elleme"); // NOI18N
        pnlBabaBilgileri.add(txtBabaAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 145, 30));

        txtBabaEvTelefonu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBabaEvTelefonu.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(txtBabaEvTelefonu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 145, 30));

        txtBabaCepTelefonu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBabaCepTelefonu.setName("gizle"); // NOI18N
        pnlBabaBilgileri.add(txtBabaCepTelefonu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 145, 30));

        pnlVeliBilgileri.add(pnlBabaBilgileri);

        getContentPane().add(pnlVeliBilgileri);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        VelitipiCBDoldur();
        OkulIlcesiCBDoldur();
        IllerCbDoldur();
        BilsemlerCBDoldur();
        OgrenimDurumuCBDoldur();
        
       java.util.Date simdi=new java.util.Date();
       SimpleDateFormat df=new SimpleDateFormat("dd.MM.yyyy",Locale.ROOT);       
        try
        {
            txtKayitTarihi.setText(df.format(simdi));
            ogrKayitTarihi=df.parse(txtKayitTarihi.getText());           

        } 
        catch (ParseException e)
        {
             e.printStackTrace();

        }
       
        
        webSource =new VideoCapture(0);
        myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();      
	
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
       
       myThread.runnable = false;
        webSource.release();
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnFotograCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotograCekActionPerformed
        // TODO add your handling code here:
       // fotoYolu="\\\\SNCO_IDARI_1\\foto\\"+txtOgrenciTCNo.getText()+".jpg";
        fotoYolu="G:/foto/"+txtOgrenciTCNO.getText()+".jpg";
        Highgui.imwrite(fotoYolu, frame);
        try 
        {
            BufferedImage  img = ImageIO.read(new File(fotoYolu));
            Graphics g=pnlFotograf.getGraphics();

            g.drawImage(img, 0, 0, pnlFotograf.getWidth(), pnlFotograf.getHeight()  , 0, 0, img.getWidth(), img.getHeight(), null);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(YeniKayitEkrani.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFotograCekActionPerformed

    private void cbOgrenciVelisiKimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOgrenciVelisiKimActionPerformed
        // TODO add your handling code here:
        secilenVelitipi=-1;
       if(cbOgrenciVelisiKim.getSelectedIndex()>0)
       {
        secilenVelitipi=((Cift)cbOgrenciVelisiKim.getSelectedItem()).key;
       
        
       }
        System.out.println(((Cift)cbOgrenciVelisiKim.getSelectedItem()).key);
    }//GEN-LAST:event_cbOgrenciVelisiKimActionPerformed

    private void cbOrgunEgitimOkulİlcesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrgunEgitimOkulİlcesiActionPerformed
        // TODO add your handling code here:
        cbOrgunEgitimOkulu.removeAllItems();
        cbOrgunEgitimOkulu.addItem(new Cift(-1,"Okul Seç"));
        orgunOkulIlcesi=-1;
        if(cbOrgunEgitimOkulİlcesi.getSelectedIndex()>0)
        {
            orgunOkulIlcesi=((Cift)cbOrgunEgitimOkulİlcesi.getSelectedItem()).key;
            OrgunEgitimOkulCBDoldur();
        }
        
        
    }//GEN-LAST:event_cbOrgunEgitimOkulİlcesiActionPerformed

    private void cbOrgunEgitimOkuluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrgunEgitimOkuluActionPerformed
        // TODO add your handling code here:
        orgunOkul=-1;
       if(cbOrgunEgitimOkulu.getSelectedIndex()>0)
       {
        orgunOkul=((Cift)cbOrgunEgitimOkulu.getSelectedItem()).key;
           System.out.println(((Cift)cbOrgunEgitimOkulu.getSelectedItem()).value);
        
       }
    }//GEN-LAST:event_cbOrgunEgitimOkuluActionPerformed

    private void cbTanilamaIliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTanilamaIliActionPerformed
        // TODO add your handling code here:
       bilsemTanimlamaIli=-1;
       if(cbTanilamaIli.getSelectedIndex()>0)
       {
        bilsemTanimlamaIli=((Cift)cbTanilamaIli.getSelectedItem()).key;
          System.out.println(((Cift)cbTanilamaIli.getSelectedItem()).value); 
        
       }
    }//GEN-LAST:event_cbTanilamaIliActionPerformed

    private void cbBilsemBaslamaIliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBilsemBaslamaIliActionPerformed
        // TODO add your handling code here:
         bilsemBaslamaIli=-1;
       if(cbBilsemBaslamaIli.getSelectedIndex()>0)
       {
        bilsemBaslamaIli=((Cift)cbBilsemBaslamaIli.getSelectedItem()).key;
          System.out.println(((Cift)cbBilsemBaslamaIli.getSelectedItem()).value); 
        
       }
        
    }//GEN-LAST:event_cbBilsemBaslamaIliActionPerformed

    private void cbOgrenciSinifSeviyesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOgrenciSinifSeviyesiActionPerformed
        // TODO add your handling code here:
        orgunEgitimSinifSeviyesi=-1;
        if(cbOgrenciSinifSeviyesi.getSelectedIndex()>0)
        {
           orgunEgitimSinifSeviyesi=Integer.parseInt(cbOgrenciSinifSeviyesi.getSelectedItem().toString());
            System.out.println(cbOgrenciSinifSeviyesi.getSelectedItem().toString()); 
        
        }
        
    }//GEN-LAST:event_cbOgrenciSinifSeviyesiActionPerformed

    private void cbNakilGelinenBilsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNakilGelinenBilsemActionPerformed
        // TODO add your handling code here:
       nakilGeldigiBilsem=-1;
       if(cbNakilGelinenBilsem.getSelectedIndex()>0)
       {
        nakilGeldigiBilsem=((Cift)cbNakilGelinenBilsem.getSelectedItem()).key;
        System.out.println(((Cift)cbNakilGelinenBilsem.getSelectedItem()).value); 
        
       }
    }//GEN-LAST:event_cbNakilGelinenBilsemActionPerformed

    private void cbAnneOgrenimDurumuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cbAnneOgrenimDurumuActionPerformed
    {//GEN-HEADEREND:event_cbAnneOgrenimDurumuActionPerformed
        // TODO add your handling code here:
       anneOgrenimDurumu=-1;
       if(cbAnneOgrenimDurumu.getSelectedIndex()>0)
       {
        anneOgrenimDurumu=((Cift)cbAnneOgrenimDurumu.getSelectedItem()).key;
        System.out.println(((Cift)cbAnneOgrenimDurumu.getSelectedItem()).value);        
       }
        
    }//GEN-LAST:event_cbAnneOgrenimDurumuActionPerformed

    private void cbBabaOgrenimDurumuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cbBabaOgrenimDurumuActionPerformed
    {//GEN-HEADEREND:event_cbBabaOgrenimDurumuActionPerformed
        // TODO add your handling code here:
       babaOgrenimDurumu=-1;
       if(cbBabaOgrenimDurumu.getSelectedIndex()>0)
       {
        babaOgrenimDurumu=((Cift)cbBabaOgrenimDurumu.getSelectedItem()).key;
        System.out.println(((Cift)cbBabaOgrenimDurumu.getSelectedItem()).value);        
       }
    }//GEN-LAST:event_cbBabaOgrenimDurumuActionPerformed

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnKaydetActionPerformed
    {//GEN-HEADEREND:event_btnKaydetActionPerformed
        // TODO add your handling code here:
        boolean islem=true;
        
        hata="Hatalı Yapılan İşlemler";

        // <editor-fold defaultstate="collapsed" desc="Hata işlemleri">
        if(!txtOgrenciTCNO.getText().trim().matches("\\d{11}"))
        {
            islem=false;
            hata+="\n"+"* Lüten TC kimlik numarasını 11 rakamdan oluşacak şekilde giriniz.";

        }
        if(!txtOgrenciDogumTarihi.getText().matches("\\d{2}.\\d{2}.\\d{4}"))
        {
            islem=false;
            hata+="\n"+"* 01.01.2008 biçiminde tarih değeri giriniz";          

        }
        if(!txtOgrenciDogumYeri.getText().matches("\\S+"))
        {
            islem=false;
            hata+="\n"+"* Lütfen Doğum Yeri bilgisini giriniz.";          

        }
        //if(!(txtOgrenciAdi.getText().trim().matches("\\S+") || txtOgrenciAdi.getText().trim().matches("\\S+\\s+\\S+")))
         if(!txtOgrenciAdi.getText().trim().matches("^[ığĞüÜşŞİöÖçÇa-zA-Z ]+$"))
        {
            islem=false;
            hata+="\n"+"* Lütfen öğrenci Adını giriniz.";          

        }
          if(!txtOgrenciSoyadi.getText().trim().matches("\\S+"))
        {
            islem=false;
            hata+="\n"+"* Lütfen öğrenci soyadını giriniz.";          

        }
        if(!txtOrgunEgitimSubesi.getText().trim().matches("\\S"))
        {
            islem=false;
            hata+="\n"+"* Lütfen öğrenci Örgün eğitimdeki sınıf şubesi bilgisini doğru giriniz.";          

        }
       // if(!(txtOrgunEgitimOgretmeni.getText().trim().matches("\\S+\\s+\\S+")||txtOrgunEgitimOgretmeni.getText().trim().matches("\\S+\\s+\\S+\\s+\\S+")||
        //        txtOrgunEgitimOgretmeni.getText().trim().matches("\\S+\\s+\\S+\\s+\\S+\\s+\\S+")))
        if(!(txtOrgunEgitimOgretmeni.getText().trim().matches("^[ığĞüÜşŞİöÖçÇa-zA-Z ]+$")))
        {
            islem=false;
            hata+="\n"+"* Lütfen öğrenci Örgün eğitimdeki öğretmen bilgisini giriniz.";          

        }
        if(!txtOrgunEgitimNumarasi.getText().trim().matches("\\d+"))
        {
            islem=false;
            hata+="\n"+"* Lütfen öğrenci Örgün okul numarası bilgisini doğru giriniz.";          

        }
        if(!txtTanilamaYili.getText().trim().matches("\\d{4}"))
        {
            islem=false;
            hata+="\n"+"* Lütfen öğrenci ilk BİLSEM tanılama yılı bilgisini doğru giriniz.";          

        }
        
        if(!txtBilsemBaslamaYili.getText().trim().matches("\\d{4}"))
        {
            islem=false;
            hata+="\n"+"* Lütfen öğrenci ilk BİLSEM başlama yılı bilgisini doğru giriniz.";          

        }
        if(!(txtOgrenciAdres.getText().trim().length()>6))
        {
        islem=false;
        hata+="\n"+"* Lütfen öğrenci adres bilgisini doğru giriniz.";          

        }
        if(!(txtAnneAdi.getText().trim().matches("^[ığĞüÜşŞİöÖçÇa-zA-Z ]+$")))
        {
        islem=false;
        hata+="\n"+"* Lütfen Anne adı bilgisini doğru giriniz.";          

        }
        if(!(txtBabaAdi.getText().trim().matches("^[ığĞüÜşŞİöÖçÇa-zA-Z ]+$")))
        {
        islem=false;
        hata+="\n"+"* Lütfen Baba adı bilgisini doğru giriniz.";          

        }
        if(!(txtAnneSoyadi.getText().trim().matches("^[ığĞüÜşŞİöÖçÇa-zA-Z ]+$")))
        {
        islem=false;
        hata+="\n"+"* Lütfen Anne soyadı bilgisini doğru giriniz.";          

        }
        if(!(txtBabaSoyadi.getText().trim().matches("^[ığĞüÜşŞİöÖçÇa-zA-Z ]+$")))
        {
        islem=false;
        hata+="\n"+"* Lütfen Baba soyadı bilgisini doğru giriniz.";          

        }
        if(rbAnneEvet.isSelected())
        {
            if(!(txtAnneMeslegi.getText().trim().matches("^[ığĞüÜşŞİöÖçÇa-zA-Z ]+$")))
            {
                islem=false;
                hata+="\n"+"* Lütfen Anne meslek bilgisini doğru giriniz.";          

            }
              if(!(txtAnneEvAdresi.getText().trim().length()>6))
            {
                islem=false;
                hata+="\n"+"* Lütfen Anne ev adresi bilgisini doğru giriniz.";          

            }
             if(!(txtAnneCepTelefonu.getText().trim().matches("^[0][5]\\d{9}+$")))
            {
                islem=false;
                hata+="\n"+"* Lütfen Anne cep telefonu  bilgisini 05XXXXXXXXX şeklinde giriniz.";          

            }
            if(((Cift)cbAnneOgrenimDurumu.getSelectedItem()).key==-1)
            {
                islem=false;
                hata+="\n"+"* Lütfen Anne Öğrenim durumu bilgisini doğru giriniz.";
            }
            
        }
        if(rbBabaEvet.isSelected())
        {
             if(!(txtBabaMeslegi.getText().trim().matches("^[ığĞüÜşŞİöÖçÇa-zA-Z ]+$")))
            {
                islem=false;
                hata+="\n"+"* Lütfen Baba meslek bilgisini doğru giriniz.";          

            }
              if(!(txtBabaEvAdresi.getText().trim().length()>6))
            {
                islem=false;
                hata+="\n"+"* Lütfen Baba ev adresi bilgisini doğru giriniz.";          

            }
            if(!(txtBabaCepTelefonu.getText().trim().matches("^[0][5]\\d{9}+$")))
            {
                islem=false;
                hata+="\n"+"* Lütfen Baba cep telefonu  bilgisini 05XXXXXXXXX şeklinde giriniz.";          

            }
            if(((Cift)cbBabaOgrenimDurumu.getSelectedItem()).key==-1)
            {
                islem=false;
                hata+="\n"+"* Lütfen Baba Öğrenim durumu bilgisini doğru giriniz.";
            }
        }
         
         

         if(!rbErkek.isSelected() && !rbKiz.isSelected())
         {
            islem=false;
            hata+="\n"+"* Lütfen öğrenci cinsiyet bilgisini seçiniz."; 
         }
          if(!rbBeraber.isSelected() && !rbAyri.isSelected())
         {
            islem=false;
            hata+="\n"+"* Lütfen öğrenci aile durum bilgisini seçiniz."; 
         }
          if(((Cift)cbOgrenciVelisiKim.getSelectedItem()).key==-1)
          {
              islem=false;
            hata+="\n"+"* Lütfen öğrenci velisinin kim olduğunu seçiniz."; 
          }
           if(((Cift)cbOrgunEgitimOkulu.getSelectedItem()).key==-1)
          {
              islem=false;
            hata+="\n"+"* Lütfen öğrencinin örgün eğitimde devam ettiği okul bilgisini seçiniz."; 
          }
           if(cbOgrenciSinifSeviyesi.getSelectedIndex()==0)
          {
              islem=false;
            hata+="\n"+"* Lütfen öğrencinin örgün eğitimde devam ettiği sınıf seviyesi bilgisini  seçiniz."; 
          }
           if(((Cift)cbTanilamaIli.getSelectedItem()).key==-1)
          {
              islem=false;
            hata+="\n"+"* Lütfen öğrencinin BİLSEM tanımlamasının yapıldığı İl bilgisini  seçiniz."; 
          }
           if(((Cift)cbBilsemBaslamaIli.getSelectedItem()).key==-1)
          {
              islem=false;
            hata+="\n"+"* Lütfen öğrencinin ilk BİLSEM'e başladığı İl bilgisini  seçiniz."; 
          }
          if(((Cift)cbNakilGelinenBilsem.getSelectedItem()).key==-1)
          {
              islem=false;
            hata+="\n"+"* Lütfen öğrencinin nakil geldiği BİLSEM bilgisini seçiniz."; 
          }
        if(!(chkbGenel.isSelected() || chkbGorsel.isSelected() || chkbMuzik.isSelected()))
        {
            islem=false;
            hata+="\n"+"* Lütfen öğrencinin Tanımlandığı Yetenek Alan veya Alanlarını seçiniz."; 
        }

        if(islem==false)
        {
            JOptionPane.showMessageDialog(rootPane, hata,"Hata",JOptionPane.ERROR_MESSAGE);
            return;
        }
      
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Öğrenci Değişkenleri doldurma">
        
        ogrTCNO=txtOgrenciTCNO.getText();      
           
        SimpleDateFormat df=new SimpleDateFormat("dd.MM.yyyy",Locale.ROOT);       
        try
        {           
            ogrDogumTarihi=df.parse(txtOgrenciDogumTarihi.getText());                 

        } 
        catch (ParseException e) { e.printStackTrace();}
        ogrDogumYeri=txtOgrenciDogumYeri.getText().trim().toUpperCase();
        ogrAdi=txtOgrenciAdi.getText().trim().toUpperCase();
        ogrSoyadi=txtOgrenciSoyadi.getText().trim().toUpperCase();
        ogrOrgunEgitimSubesi=txtOrgunEgitimSubesi.getText().trim().toUpperCase();
        ogrOrgunEgitimSinifOgretmeni=txtOrgunEgitimOgretmeni.getText().trim().toUpperCase();
        ogrOrgunEgitimNo=txtOrgunEgitimNumarasi.getText();
        ilkBilsemTanilamaYili=Integer.parseInt(txtTanilamaYili.getText());
        ilkBilsemBaslamaYili=Integer.parseInt(txtBilsemBaslamaYili.getText());
        ogrSurekliIlac=txtSurekliIlac.getText().trim().toUpperCase();
        ogrSurekliHastalik=txtSurekliHastalik.getText().trim().toUpperCase();
        
        
        
          
       
       // </editor-fold>
       
        // <editor-fold defaultstate="collapsed" desc="Anne Değişkenleri doldurma">
        anneAd=txtAnneAdi.getText().trim().toUpperCase();
        anneSoyad=txtAnneSoyadi.getText().trim().toUpperCase();
        anneCeptelefon=txtAnneCepTelefonu.getText();
        anneEposta=txtAnneEposta.getText().trim().toUpperCase();
        anneEvAdresi=txtAnneEvAdresi.getText().trim().toUpperCase();
        anneEvTelefon=txtAnneEvTelefonu.getText();
        anneIsTelefon=txtAnneIsTelefonu.getText();
        anneMeslegi=txtAnneMeslegi.getText().trim().toUpperCase();
        anneIsAdresi=txtAnneIsAdresi.getText().trim().toUpperCase();
       
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Baba Değişkenleri doldurma">
        babaAd=txtBabaAdi.getText().trim().toUpperCase();
        babaSoyad=txtBabaSoyadi.getText().trim().toUpperCase();
        babaCeptelefon=txtBabaCepTelefonu.getText();
        babaEposta=txtBabaEposta.getText().trim().toUpperCase();
        babaEvAdresi=txtBabaEvAdresi.getText().trim().toUpperCase();
        babaEvTelefon=txtBabaEvTelefonu.getText();
        babaIsTelefon=txtBabaIsTelefonu.getText();
        babaMeslegi=txtBabaMeslegi.getText().trim().toUpperCase();
        babaIsAdresi=txtBabaIsAdresi.getText().trim().toUpperCase();
        // </editor-fold>
        
         // <editor-fold defaultstate="collapsed" desc="Kayıt ve Pdf'ye yazdırma İşlemleri">
        if(islem==true)
        {
         String[] choices = { "Bilgileri Kaydet ve Yazdır", "İptal"};
        int result = JOptionPane.showOptionDialog(this,
        "Bilgileriniz doğruysa Kaydet Butonuna Basınız", "Dikkat",
        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, 
        null, choices, choices[0]);  
            System.out.println(result);
            
        }
        Ogrenci ogrenci=new Ogrenci();
        Veli baba=new Veli();
        Veli anne=new Veli();
        OgrenciDAO islemler=new OgrenciDAO()();
         // </editor-fold>
        
        
        
    }//GEN-LAST:event_btnKaydetActionPerformed

    private void rbKizItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbKizItemStateChanged
    {//GEN-HEADEREND:event_rbKizItemStateChanged
        // TODO add your handling code here:
        
        if(rbKiz.isSelected()){ogrCinsiyet=0;}
    }//GEN-LAST:event_rbKizItemStateChanged

    private void rbErkekItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbErkekItemStateChanged
    {//GEN-HEADEREND:event_rbErkekItemStateChanged
        // TODO add your handling code here:
        if(rbErkek.isSelected()){ogrCinsiyet=1;}
    }//GEN-LAST:event_rbErkekItemStateChanged

    private void rbAyriItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbAyriItemStateChanged
    {//GEN-HEADEREND:event_rbAyriItemStateChanged
        // TODO add your handling code here:
        if(rbAyri.isSelected()){ogrAileDurumu=0;}
    }//GEN-LAST:event_rbAyriItemStateChanged

    private void rbBeraberItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbBeraberItemStateChanged
    {//GEN-HEADEREND:event_rbBeraberItemStateChanged
        // TODO add your handling code here:
        if(rbBeraber.isSelected()){ogrAileDurumu=1;}
    }//GEN-LAST:event_rbBeraberItemStateChanged

    private void chkbGenelItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_chkbGenelItemStateChanged
    {//GEN-HEADEREND:event_chkbGenelItemStateChanged
        // TODO add your handling code here:
        if(chkbGenel.isSelected()){yetenekAlanlari[0]=true;}
        else{yetenekAlanlari[0]=false;}
    }//GEN-LAST:event_chkbGenelItemStateChanged

    private void chkbGorselItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_chkbGorselItemStateChanged
    {//GEN-HEADEREND:event_chkbGorselItemStateChanged
        // TODO add your handling code here:
        if(chkbGorsel.isSelected()){yetenekAlanlari[1]=true;}
        else{yetenekAlanlari[1]=false;}
    }//GEN-LAST:event_chkbGorselItemStateChanged

    private void chkbMuzikItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_chkbMuzikItemStateChanged
    {//GEN-HEADEREND:event_chkbMuzikItemStateChanged
        // TODO add your handling code here:
        if(chkbMuzik.isSelected()){yetenekAlanlari[2]=true;}
        else{yetenekAlanlari[2]=false;}
    }//GEN-LAST:event_chkbMuzikItemStateChanged

    private void rbAnneEvetItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbAnneEvetItemStateChanged
    {//GEN-HEADEREND:event_rbAnneEvetItemStateChanged
        // TODO add your handling code here:
        GorselIslemler islem=new GorselIslemler();
        if(rbAnneEvet.isSelected())
        {
            anneHayattami=1;
            islem.PanelBirimleriPasiflestirme(pnlAnneBilgileri, true);
            
        }
       
    }//GEN-LAST:event_rbAnneEvetItemStateChanged

    private void rbAnneHayirItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbAnneHayirItemStateChanged
    {//GEN-HEADEREND:event_rbAnneHayirItemStateChanged
        // TODO add your handling code here:
         GorselIslemler islem=new GorselIslemler();
        if(rbAnneHayir.isSelected())
        {
            anneHayattami=0;
            islem.PanelBirimleriPasiflestirme(pnlAnneBilgileri,  false);
            
        }
       
    }//GEN-LAST:event_rbAnneHayirItemStateChanged

    private void rbBabaEvetItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbBabaEvetItemStateChanged
    {//GEN-HEADEREND:event_rbBabaEvetItemStateChanged
        // TODO add your handling code here:
         GorselIslemler islem=new GorselIslemler();
        if(rbBabaEvet.isSelected())
        {
            babaHayattami=1;
            islem.PanelBirimleriPasiflestirme(pnlBabaBilgileri,  true);
            
        }
    }//GEN-LAST:event_rbBabaEvetItemStateChanged

    private void rbBabaHayirItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbBabaHayirItemStateChanged
    {//GEN-HEADEREND:event_rbBabaHayirItemStateChanged
        // TODO add your handling code here:
         GorselIslemler islem=new GorselIslemler();
        if(rbBabaHayir.isSelected())
        {
            babaHayattami=0;
            islem.PanelBirimleriPasiflestirme(pnlBabaBilgileri,  false);
            
        }
    }//GEN-LAST:event_rbBabaHayirItemStateChanged

    private void txtOgrenciTCNOKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtOgrenciTCNOKeyReleased
    {//GEN-HEADEREND:event_txtOgrenciTCNOKeyReleased
        // TODO add your handling code here:
         if(txtOgrenciTCNO.getText().matches("\\d{11}"))
        {
            //islem=false;
            //hata="\n"+"Lüten TC kimlik numarasını 11 haneli ve doğru giriniz";
            txtOgrenciTCNO.setBackground(Color.WHITE);
           // txtOgrenciTCNO.setText("");
        }else{ txtOgrenciTCNO.setBackground(Color.orange);}
    }//GEN-LAST:event_txtOgrenciTCNOKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFotograCek;
    private javax.swing.JButton btnKaydet;
    private javax.swing.JComboBox<Cift> cbAnneOgrenimDurumu;
    private javax.swing.JComboBox<Cift> cbBabaOgrenimDurumu;
    private javax.swing.JComboBox<Cift> cbBilsemBaslamaIli;
    private javax.swing.JComboBox<Cift> cbNakilGelinenBilsem;
    private javax.swing.JComboBox<String> cbOgrenciSinifSeviyesi;
    private javax.swing.JComboBox<Cift> cbOgrenciVelisiKim;
    private javax.swing.JComboBox<Cift> cbOrgunEgitimOkulu;
    private javax.swing.JComboBox<Cift> cbOrgunEgitimOkulİlcesi;
    private javax.swing.JComboBox<Cift> cbTanilamaIli;
    private javax.swing.JCheckBox chkbGenel;
    private javax.swing.JCheckBox chkbGorsel;
    private javax.swing.JCheckBox chkbMuzik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel pnlAnneBilgileri;
    private javax.swing.JPanel pnlBabaBilgileri;
    private javax.swing.JPanel pnlFotograf;
    private javax.swing.JPanel pnlKamera;
    private javax.swing.JPanel pnlOgrenci;
    private javax.swing.JPanel pnlVeliBilgileri;
    private javax.swing.JRadioButton rbAnneEvet;
    private javax.swing.JRadioButton rbAnneHayir;
    private javax.swing.JRadioButton rbAyri;
    private javax.swing.JRadioButton rbBabaEvet;
    private javax.swing.JRadioButton rbBabaHayir;
    private javax.swing.JRadioButton rbBeraber;
    private javax.swing.JRadioButton rbErkek;
    private javax.swing.JRadioButton rbKiz;
    private javax.swing.ButtonGroup rbgAileDurumu;
    private javax.swing.ButtonGroup rbgAnneHayattami;
    private javax.swing.ButtonGroup rbgAnneOgrenimDurumu;
    private javax.swing.ButtonGroup rbgBabaHayattami;
    private javax.swing.ButtonGroup rbgBabaOgreniDurumu;
    private javax.swing.ButtonGroup rbgCinsiyet;
    private javax.swing.JTextField txtAnneAdi;
    private javax.swing.JTextField txtAnneCepTelefonu;
    private javax.swing.JTextField txtAnneEposta;
    private javax.swing.JTextArea txtAnneEvAdresi;
    private javax.swing.JTextField txtAnneEvTelefonu;
    private javax.swing.JTextArea txtAnneIsAdresi;
    private javax.swing.JTextField txtAnneIsTelefonu;
    private javax.swing.JTextField txtAnneMeslegi;
    private javax.swing.JTextField txtAnneSoyadi;
    private javax.swing.JTextField txtBabaAdi;
    private javax.swing.JTextField txtBabaCepTelefonu;
    private javax.swing.JTextField txtBabaEposta;
    private javax.swing.JTextArea txtBabaEvAdresi;
    private javax.swing.JTextField txtBabaEvTelefonu;
    private javax.swing.JTextArea txtBabaIsAdresi;
    private javax.swing.JTextField txtBabaIsTelefonu;
    private javax.swing.JTextField txtBabaMeslegi;
    private javax.swing.JTextField txtBabaSoyadi;
    private javax.swing.JFormattedTextField txtBilsemBaslamaYili;
    private javax.swing.JFormattedTextField txtKayitTarihi;
    private javax.swing.JTextField txtOgrenciAdi;
    private javax.swing.JTextArea txtOgrenciAdres;
    private javax.swing.JFormattedTextField txtOgrenciDogumTarihi;
    private javax.swing.JTextField txtOgrenciDogumYeri;
    private javax.swing.JTextField txtOgrenciSoyadi;
    private javax.swing.JTextField txtOgrenciTCNO;
    private javax.swing.JTextField txtOrgunEgitimNumarasi;
    private javax.swing.JTextField txtOrgunEgitimOgretmeni;
    private javax.swing.JTextField txtOrgunEgitimSubesi;
    private javax.swing.JTextField txtSurekliHastalik;
    private javax.swing.JTextField txtSurekliIlac;
    private javax.swing.JFormattedTextField txtTanilamaYili;
    // End of variables declaration//GEN-END:variables
}
