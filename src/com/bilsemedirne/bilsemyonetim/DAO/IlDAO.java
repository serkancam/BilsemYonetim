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
public class IlDAO extends DAO
{
     private final String tumIlleriGetir = "select * from Il";
    
    public List<Il> TumIlleriGetir()
    {
        Connection conn = null;
                PreparedStatement stmt = null;
		
		List<Il> list = new ArrayList<Il>();
		
		try 
                {
			conn = getConnection();                        
			stmt = conn.prepareStatement(tumIlleriGetir);                        
                        ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				
                            Il il=new Il();
                            il.setIlKodu(rs.getInt("ilKodu"));
                            il.setIlAdi(rs.getString("ilAdi"));
                            
                            list.add(il);
                                
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
