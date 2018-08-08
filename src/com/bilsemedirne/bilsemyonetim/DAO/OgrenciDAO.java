/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilsemedirne.bilsemyonetim.DAO;
import com.bilsemedirne.bilsemyonetim.ENTITY.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author serkancam
 */
public class OgrenciDAO extends DAO
{
    private final String ilkKayitOgrenci="INSERT INTO ogrenci ( ogrenciTCNO , ogrenciAdi , ogrenciSoyadi , dogumYeri , "
            + "dogumTarihi , tanilamaYili , tanimlananIl , ilkBilsemBaslamaYili , ilkBilsemBaslamaIli , cinsiyet ,"
            + " orgunEgitimdekiOgretmenAdi , orgunEgitimSinifi , orgunEgitimSubesi , adres , kayitTarihi , velayet , "
            + "fotograf , aileDurumu , orgunEgitimokulNo , OrgunEgitimOkulu ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String ilkKayitVeli="INSERT INTO veli (veliAdi, veliSoyadi, evAdres, isAdresi, evTelefonu, "
            + "isTelefonu, cepTelefonu, epostaAdresi, ogrenimDurumu, hayattami,veliTipi, meslegi) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String ilkKayitVelisiKim="INSERT INTO ogrencininvelisi(ogrenciTCNO,veliKodu) VALUES(?,?)";
    
    private final String yetenekAlaniEkle="INSERT INTO ogrenciyetenekalani(ogrenciTCNO,yetenekAlanKodu) VALUES(?,?)";
    
    public Integer IlkKayit(Ogrenci ogrenci, Veli anne, Veli baba, boolean[] yetenekAlanlari) 
    {
        Integer result=0;
        int pk = 0;
        
        Connection conn = null;
        PreparedStatement stmtOgrenci = null;
        PreparedStatement stmtAnne = null;
        PreparedStatement stmtBaba = null;
        PreparedStatement stmtVelisi=null;
        PreparedStatement stmtYetenekAlani=null;
		
		try 
                {
                    conn = getConnection();
                    conn.setAutoCommit(false);
                    
                    //ogrenci
                    stmtOgrenci = conn.prepareStatement(ilkKayitOgrenci);               
                    
                    stmtOgrenci.setString(1, ogrenci.getOgrenciTCNO());
                    stmtOgrenci.setString(2, ogrenci.getOgrenciAdi());
                    stmtOgrenci.setString(3, ogrenci.getOgrenciSoyadi());
                    stmtOgrenci.setString(4, ogrenci.getDogumYeri());
                    stmtOgrenci.setDate(5, new Date(ogrenci.getDogumTarihi().getTime()));
                    stmtOgrenci.setInt(6, ogrenci.getTanimlamaYili());
                    stmtOgrenci.setInt(7,ogrenci.getTanimlananIl().getIlKodu());
                    stmtOgrenci.setInt(8, ogrenci.getIlkBilsemBaslamaYili());
                    stmtOgrenci.setInt(9, ogrenci.getIlkBilsemBaslamaIli().getIlKodu());
                    stmtOgrenci.setByte(10, ogrenci.getCinsiyet());
                    stmtOgrenci.setString(11, ogrenci.getOrgunOgretimdekiOgretmenAdi());
                    stmtOgrenci.setInt(12, ogrenci.getOrgunEgitimSinifi());
                    stmtOgrenci.setString(13, ogrenci.getOrgunEgitimSubesi());
                    stmtOgrenci.setString(14, ogrenci.getAdres());
                    stmtOgrenci.setDate(15, new Date( ogrenci.getKayitTarihi().getTime())); 
                    stmtOgrenci.setInt(16, ogrenci.getVelayet().getVeliTipiKodu());
                    stmtOgrenci.setString(17, ogrenci.getFotograf());
                    stmtOgrenci.setByte(18, ogrenci.getAileDurumu());
                    stmtOgrenci.setString(19, ogrenci.getOrgunEgitimokulNo());
                    stmtOgrenci.setInt(20, ogrenci.getOrgunEgitimOkulu().getOkulKodu());
                    
                    //anne
                     stmtAnne = conn.prepareStatement(ilkKayitVeli,Statement.RETURN_GENERATED_KEYS); 
                     
                     stmtAnne.setString(1, anne.getVeliAdi());
                     stmtAnne.setString(2, anne.getVeliSoyadi());
                     stmtAnne.setString(3, anne.getEvAdresi());
                     stmtAnne.setString(4, anne.getIsAdresi());
                     stmtAnne.setString(5, anne.getEvTelefonu());
                     stmtAnne.setString(6, anne.getIsTelefonu());
                     stmtAnne.setString(7, anne.getCepTelefonu());
                     stmtAnne.setString(8, anne.getEpostaAdresi());
                     stmtAnne.setInt(9, anne.getOgrenimDurumu().getOgrenimDurumuKodu());
                     stmtAnne.setByte(10, anne.getHayattami());
                     stmtAnne.setInt(11, anne.getVeliTipi().getVeliTipiKodu());
                     stmtAnne.setString(12, anne.getMeslegi());
                                          
                     //baba
                     stmtBaba = conn.prepareStatement(ilkKayitVeli,Statement.RETURN_GENERATED_KEYS);
                     
                     stmtBaba.setString(1, baba.getVeliAdi());
                     stmtBaba.setString(2, baba.getVeliSoyadi());
                     stmtBaba.setString(3, baba.getEvAdresi());
                     stmtBaba.setString(4, baba.getIsAdresi());
                     stmtBaba.setString(5, baba.getEvTelefonu());
                     stmtBaba.setString(6, baba.getIsTelefonu());
                     stmtBaba.setString(7, baba.getCepTelefonu());
                     stmtBaba.setString(8, baba.getEpostaAdresi());
                     stmtBaba.setInt(9, baba.getOgrenimDurumu().getOgrenimDurumuKodu());
                     stmtBaba.setByte(10, baba.getHayattami());
                     stmtBaba.setInt(11, baba.getVeliTipi().getVeliTipiKodu());
                     stmtBaba.setString(12, baba.getMeslegi());
                     
                     
                    result +=stmtOgrenci.executeUpdate();
                    result +=stmtAnne.executeUpdate();
                    ResultSet rsA=stmtAnne.getGeneratedKeys();
                    result +=stmtBaba.executeUpdate();
                    ResultSet rsB=stmtBaba.getGeneratedKeys();
                    
                    
                    for(int i=0;i<yetenekAlanlari.length;i++)
                    {
                        if(yetenekAlanlari[i]==true)
                        {
                            stmtYetenekAlani=conn.prepareStatement(yetenekAlaniEkle);
                            stmtYetenekAlani.setString(1, ogrenci.getOgrenciTCNO());
                            stmtYetenekAlani.setInt(2, i+1);
                            result +=stmtYetenekAlani.executeUpdate();
                            //stmtYetenekAlani=null;
                            
                        }
                    }
                    //
                    if(ogrenci.getVelayet().getVeliTipiKodu()==1)
                    {
                        
                        while(rsA.next())
                        {
                         pk = rsA.getInt(1);
                        }
                    }
                    else if(ogrenci.getVelayet().getVeliTipiKodu()==2)
                    {
                        
                        while(rsB.next())
                        {
                         pk = rsB.getInt(1);
                        }
                    }
                    else
                    {
                        ;
                    }
                    
                    stmtVelisi = conn.prepareStatement(ilkKayitVelisiKim);
                     
                    stmtVelisi.setString(1, ogrenci.getOgrenciTCNO());
                    stmtVelisi.setInt(2, (int) pk);
                    result +=stmtVelisi.executeUpdate();
                    
                    conn.commit();
                    
                    System.out.println("*******************önemli************** \n"+pk+"\n*******************önemli************** \n");
                    //
                   
		}
                catch (SQLException e1) 
                {
			System.err.print(e1);
                    if (conn != null) 
                    {
                        try 
                        {
                            System.err.print("Transaction is being rolled back");
                            result=0;
                            conn.rollback();
                            
                        } 
                        catch(SQLException e2) 
                        {
                            System.err.print(e2);
                        }
                    }
		} 
                finally 
                {
                    close(stmtVelisi);
                    close(stmtBaba);
                    close(stmtAnne);
                    close(stmtOgrenci);
                    close(conn);
                 
                    System.out.println("Tüm bağlantılar kapandı");
                    
		}

            return result;
        }
    
    public Integer IlkKayit(Ogrenci ogrenci, Veli anne, Veli baba,Veli veli, boolean[] yetenekAlanlari) 
    {
        Integer result=0;
        int pk = 0;
        
        Connection conn = null;
        PreparedStatement stmtOgrenci = null;
        PreparedStatement stmtAnne = null;
        PreparedStatement stmtBaba = null;
        PreparedStatement stmtVeli = null;
        PreparedStatement stmtVelisi=null;        
        PreparedStatement stmtYetenekAlani=null;
		
		try 
                {
                    conn = getConnection();
                    conn.setAutoCommit(false);
                    
                    //ogrenci
                    stmtOgrenci = conn.prepareStatement(ilkKayitOgrenci);               
                    
                    stmtOgrenci.setString(1, ogrenci.getOgrenciTCNO());
                    stmtOgrenci.setString(2, ogrenci.getOgrenciAdi());
                    stmtOgrenci.setString(3, ogrenci.getOgrenciSoyadi());
                    stmtOgrenci.setString(4, ogrenci.getDogumYeri());
                    stmtOgrenci.setDate(5, new Date(ogrenci.getDogumTarihi().getTime()));
                    stmtOgrenci.setInt(6, ogrenci.getTanimlamaYili());
                    stmtOgrenci.setInt(7,ogrenci.getTanimlananIl().getIlKodu());
                    stmtOgrenci.setInt(8, ogrenci.getIlkBilsemBaslamaYili());
                    stmtOgrenci.setInt(9, ogrenci.getIlkBilsemBaslamaIli().getIlKodu());
                    stmtOgrenci.setByte(10, ogrenci.getCinsiyet());
                    stmtOgrenci.setString(11, ogrenci.getOrgunOgretimdekiOgretmenAdi());
                    stmtOgrenci.setInt(12, ogrenci.getOrgunEgitimSinifi());
                    stmtOgrenci.setString(13, ogrenci.getOrgunEgitimSubesi());
                    stmtOgrenci.setString(14, ogrenci.getAdres());
                    stmtOgrenci.setDate(15, new Date( ogrenci.getKayitTarihi().getTime())); 
                    stmtOgrenci.setInt(16, ogrenci.getVelayet().getVeliTipiKodu());
                    stmtOgrenci.setString(17, ogrenci.getFotograf());
                    stmtOgrenci.setByte(18, ogrenci.getAileDurumu());
                    stmtOgrenci.setString(19, ogrenci.getOrgunEgitimokulNo());
                    stmtOgrenci.setInt(20, ogrenci.getOrgunEgitimOkulu().getOkulKodu());
                    
                    //anne
                     stmtAnne = conn.prepareStatement(ilkKayitVeli,Statement.RETURN_GENERATED_KEYS); 
                     
                     stmtAnne.setString(1, anne.getVeliAdi());
                     stmtAnne.setString(2, anne.getVeliSoyadi());
                     stmtAnne.setString(3, anne.getEvAdresi());
                     stmtAnne.setString(4, anne.getIsAdresi());
                     stmtAnne.setString(5, anne.getEvTelefonu());
                     stmtAnne.setString(6, anne.getIsTelefonu());
                     stmtAnne.setString(7, anne.getCepTelefonu());
                     stmtAnne.setString(8, anne.getEpostaAdresi());
                     stmtAnne.setInt(9, anne.getOgrenimDurumu().getOgrenimDurumuKodu());
                     stmtAnne.setByte(10, anne.getHayattami());
                     stmtAnne.setInt(11, anne.getVeliTipi().getVeliTipiKodu());
                     stmtAnne.setString(12, anne.getMeslegi());
                                          
                     //baba
                     stmtBaba = conn.prepareStatement(ilkKayitVeli,Statement.RETURN_GENERATED_KEYS);
                     
                     stmtBaba.setString(1, baba.getVeliAdi());
                     stmtBaba.setString(2, baba.getVeliSoyadi());
                     stmtBaba.setString(3, baba.getEvAdresi());
                     stmtBaba.setString(4, baba.getIsAdresi());
                     stmtBaba.setString(5, baba.getEvTelefonu());
                     stmtBaba.setString(6, baba.getIsTelefonu());
                     stmtBaba.setString(7, baba.getCepTelefonu());
                     stmtBaba.setString(8, baba.getEpostaAdresi());
                     stmtBaba.setInt(9, baba.getOgrenimDurumu().getOgrenimDurumuKodu());
                     stmtBaba.setByte(10, baba.getHayattami());
                     stmtBaba.setInt(11, baba.getVeliTipi().getVeliTipiKodu());
                     stmtBaba.setString(12, baba.getMeslegi());
                     
                     //Veli
                     stmtVeli = conn.prepareStatement(ilkKayitVeli,Statement.RETURN_GENERATED_KEYS);
                     
                     stmtVeli.setString(1, veli.getVeliAdi());
                     stmtVeli.setString(2, veli.getVeliSoyadi());
                     stmtVeli.setString(3, veli.getEvAdresi());
                     stmtVeli.setString(4, veli.getIsAdresi());
                     stmtVeli.setString(5, veli.getEvTelefonu());
                     stmtVeli.setString(6, veli.getIsTelefonu());
                     stmtVeli.setString(7, veli.getCepTelefonu());
                     stmtVeli.setString(8, veli.getEpostaAdresi());
                     stmtVeli.setInt(9, veli.getOgrenimDurumu().getOgrenimDurumuKodu());
                     stmtVeli.setByte(10, veli.getHayattami());
                     stmtVeli.setInt(11, veli.getVeliTipi().getVeliTipiKodu());
                     stmtVeli.setString(12, veli.getMeslegi());
                     
                    result +=stmtOgrenci.executeUpdate();
                    result +=stmtAnne.executeUpdate();
                    ResultSet rsA=stmtAnne.getGeneratedKeys();
                    result +=stmtBaba.executeUpdate();
                    ResultSet rsB=stmtBaba.getGeneratedKeys();
                    result +=stmtVeli.executeUpdate();
                    ResultSet rsV=stmtVeli.getGeneratedKeys();
                    
                    
                    for(int i=0;i<yetenekAlanlari.length;i++)
                    {
                        if(yetenekAlanlari[i]==true)
                        {
                            stmtYetenekAlani=conn.prepareStatement(yetenekAlaniEkle);
                            stmtYetenekAlani.setString(1, ogrenci.getOgrenciTCNO());
                            stmtYetenekAlani.setInt(2, i+1);
                            result +=stmtYetenekAlani.executeUpdate();
                            //stmtYetenekAlani=null;
                            
                        }
                    }
                    //
                    if(ogrenci.getVelayet().getVeliTipiKodu()==1)
                    {
                        
                        while(rsA.next())
                        {
                         pk = rsA.getInt(1);
                        }
                    }
                    else if(ogrenci.getVelayet().getVeliTipiKodu()==2)
                    {
                        
                        while(rsB.next())
                        {
                         pk = rsB.getInt(1);
                        }
                    }
                    else
                    {
                        while(rsV.next())
                        {
                         pk = rsV.getInt(1);
                        }
                    }
                    
                    stmtVelisi = conn.prepareStatement(ilkKayitVelisiKim);
                     
                    stmtVelisi.setString(1, ogrenci.getOgrenciTCNO());
                    stmtVelisi.setInt(2, (int) pk);
                    result +=stmtVelisi.executeUpdate();
                    
                    conn.commit();
                    
                    System.out.println("*******************önemli************** \n"+pk+"\n*******************önemli************** \n");
                    //
                   
		}
                catch (SQLException e1) 
                {
			System.err.print(e1);
                    if (conn != null) 
                    {
                        try 
                        {
                            System.err.print("Transaction is being rolled back");
                            result=0;
                            conn.rollback();
                            
                        } 
                        catch(SQLException e2) 
                        {
                            System.err.print(e2);
                        }
                    }
		} 
                finally 
                {
                    close(stmtVelisi);
                    close(stmtBaba);
                    close(stmtAnne);
                    close(stmtOgrenci);
                    close(conn);
                 
                    System.out.println("Tüm bağlantılar kapandı");
                    
		}

            return result;
        }
}
