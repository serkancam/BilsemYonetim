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
public class IlceDAO extends DAO
{
    private final String edirneIlceleriniGetir = "select * from ilce where ilKodu=22";
    private final String tumListeyiGetir= "SELECT * FROM veli ORDER BY veliKodu";
    private final String TCyeGore = "SELECT * FROM doktor WHERE doktorTC=?";
    private final String ismeGore = "SELECT * FROM doktor WHERE doktorAdi=? or doktorSoyadi=?"; 
    
    public List<Ilce> EdirneIlceleriGetir()
    {
        Connection conn = null;
		PreparedStatement stmt = null;
		List<Ilce> list = new ArrayList<Ilce>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(edirneIlceleriniGetir);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				Ilce ilce = new Ilce();
                                ilce.setIlceKodu(rs.getInt("ilceKodu"));
                                ilce.setIlceAdi(rs.getString("ilceAdi"));
				                                
				list.add(ilce);
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
