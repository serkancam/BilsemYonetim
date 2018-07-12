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
public class BilsemlerDAO extends DAO
{
    private final String tumBilsemleriGetir = "select * from bilsemler";
    
    public List<Bilsemler> TumBilsemleriGetir()
    {
        Connection conn = null;
                PreparedStatement stmt = null;
		
		List<Bilsemler> list = new ArrayList<Bilsemler>();
		
		try 
                {
			conn = getConnection();                        
			stmt = conn.prepareStatement(tumBilsemleriGetir);                        
                        ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				
                            Bilsemler bilsem=new Bilsemler();
                            bilsem.setBilsemKodu(rs.getInt("bilsemKodu"));
                            bilsem.setBilsemAdi(rs.getString("bilsemAdi"));
                            
                            list.add(bilsem);
                                
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
