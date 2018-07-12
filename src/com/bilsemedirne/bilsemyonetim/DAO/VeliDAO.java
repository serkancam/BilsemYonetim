/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilsemedirne.bilsemyonetim.DAO;
import com.bilsemedirne.bilsemyonetim.ENTITY.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author serkancam
 */
public class VeliDAO extends DAO
{
    private final String sil = "DELETE FROM veli WHERE veliKodu=?";
    private final String tumListeyiGetir= "SELECT * FROM veli ORDER BY veliKodu";
    private final String TCyeGore = "SELECT * FROM doktor WHERE doktorTC=?";
    private final String ismeGore = "SELECT * FROM doktor WHERE doktorAdi=? or doktorSoyadi=?";
    private final String ekle = "INSERT INTO veli(veliAdi,veliSoyadi,evAdres,isAdres,evTeleonu,isTelefonu,cepTeleonu,epostaAdresi,ogretnimDurumu,hayattami,veliTipi"
            + ") VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private final String guncelle = "UPDATE veli SET veliAdi = ?, veliSoyadi = ?, evAdres = ?, isAdres = ?, evTelefonu = ?, isTelefonu = ?, cepTelefonu = ?, epostaAdresi = ?, ogrenimDurumu = ?, hayattami = ?, veliTipi = ?, WHERE veliKodu = ? ";
        
        public int Sil(String veliKodu) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(sil);
			stmt.setString(1, veliKodu);			
			return stmt.executeUpdate();
                        
		} 
                catch (SQLException e) 
                {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} 
                finally 
                {
			close(stmt);
			close(conn);
		}
	}
        
        public List<Veli> TumListeyiGetir() 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Veli> list = new ArrayList<Veli>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(tumListeyiGetir);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				Veli veli = new Veli();
				veli.setVeliKodu(rs.getInt("veliKodu"));
                                veli.setCepTelefonu(rs.getString("cepTelefonu"));
                                veli.setIsTelefonu(rs.getString("isTelefonu"));
                                veli.setEvTelefonu(rs.getString("evTelefonu"));
				veli.setEpostaAdresi(rs.getString("epostaAdresi"));
                                veli.setVeliAdi(rs.getString("veliAdi"));
                                veli.setVeliSoyadi(rs.getString("veliSoyadi"));
                                veli.setEvAdresi(rs.getString("evAdres"));
                                veli.setIsAdresi(rs.getString("isAdres"));
                                
                                
                                
				
                                
				list.add(veli);
			}
		}
                catch (SQLException e) 
                {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} 
                finally 
                {
			close(stmt);
			close(conn);
		}
		
		return list;
	}
        

}
