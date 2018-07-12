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
public class OkulDAO extends DAO
{
    
    private final String ilceyeAitOkullariGetir = "select * from okul where ilceKodu=? order by okulAdi asc";
    
    public List<Okul> IlceyeGoreOkullariGetir(int ilceId)
    {
        Connection conn = null;
                PreparedStatement stmt = null;
		
		List<Okul> list = new ArrayList<Okul>();
		
		try 
                {
			conn = getConnection();                        
			stmt = conn.prepareStatement(ilceyeAitOkullariGetir);                        
                        stmt.setInt(1,ilceId );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				
                            Okul okul=new Okul();
                            okul.setOkulKodu(rs.getInt("okulKodu"));
                            okul.setOkulAdi(rs.getString("okulAdi"));
                            
                            list.add(okul);
                                
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
