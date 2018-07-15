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
import java.sql.SQLException;

/**
 *
 * @author serkancam
 */
public class OgrenciDAO extends DAO
{
    private final String ilkKayit="INSERT INTO ogrenci ( ogrenciTCNO , ogrenciAdi , ogrenciSoyadi , dogumYeri , "
            + "dogumTarihi , tanilamaYili , tanimlananIl , ilkBilsemBaslamaYili , ilkBilsemBaslamaIli , cinsiyet ,"
            + " orgunEgitimdekiOgretmenAdi , orgunEgitimSinifi , orgunEgitimSubesi , adres , kayitTarihi , velayet , "
            + "fotograf , aileDurumu , orgunEgitimokulNo , OrgunEgitimOkulu ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    public Integer IlkKayit(Ogrenci ogrenci, Veli anne, Veli baba) 
    {
        Integer result=0;
        Connection conn = null;
        PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    conn.setAutoCommit(false);
                    stmt = conn.prepareStatement(ilkKayit);
                    
                    stmt.setString(1, ogrenci.getOgrenciTCNO());
                    stmt.setString(2, ogrenci.getOgrenciAdi());
                    stmt.setString(3, ogrenci.getOgrenciSoyadi());
                    stmt.setString(4, ogrenci.getDogumYeri());
                    stmt.setDate(5, new Date(ogrenci.getDogumTarihi().getTime()));
                    stmt.setInt(6, ogrenci.getTanimlamaYili());
                    stmt.setInt(7,ogrenci.getTanimlananIl().getIlKodu());
                    stmt.setInt(8, ogrenci.getIlkBilsemBaslamaYili());
                    stmt.setInt(9, ogrenci.getIlkBilsemBaslamaIli().getIlKodu());
                    stmt.setByte(10, ogrenci.getCinsiyet());
                    stmt.setString(11, ogrenci.getOrgunOgretimdekiOgretmenAdi());
                    stmt.setInt(12, ogrenci.getOrgunEgitimSinifi());
                    stmt.setString(13, ogrenci.getOrgunEgitimSubesi());
                    stmt.setString(14, ogrenci.getAdres());
                    stmt.setDate(15, new Date( ogrenci.getKayitTarihi().getTime())); 
                    stmt.setInt(16, ogrenci.getVelayet().getVeliTipiKodu());
                    stmt.setString(17, ogrenci.getFotograf());
                    stmt.setByte(18, ogrenci.getAileDurumu());
                    stmt.setString(19, ogrenci.getOrgunEgitimokulNo());
                    stmt.setInt(20, ogrenci.getOrgunEgitimOkulu().getOkulKodu());
                    
                    
                    
                    result +=stmt.executeUpdate();	
                    conn.commit();
                   
		}
                catch (SQLException e1) 
                {
			System.err.print(e1);
                    if (conn != null) 
                    {
                        try 
                        {
                            System.err.print("Transaction is being rolled back");
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
                    close(stmt);
                    close(conn);
                 
                    System.out.println("Tüm bağlantılar kapandı");
                    
		}

            return result;
        }
}
