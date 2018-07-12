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
public class VeliTipiDAO extends DAO
{
    private final String tumListeyiGetir= "SELECT * FROM velitipi ORDER BY veliTipiKodu";
    
    public List<VeliTipi> TumVeliTipleriniGetir()
    {
        Connection conn = null;
		PreparedStatement stmt = null;
		List<VeliTipi> list = new ArrayList<VeliTipi>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(tumListeyiGetir);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				VeliTipi velitipi = new VeliTipi();
                                velitipi.setVeliTipiKodu(rs.getInt("veliTipiKodu"));
                                velitipi.setVeliTipiAdi(rs.getString("veliTipiAdi"));
				                                
				list.add(velitipi);
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
