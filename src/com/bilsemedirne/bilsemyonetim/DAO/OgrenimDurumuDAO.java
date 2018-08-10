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
public class OgrenimDurumuDAO extends DAO
{
    private final String tumOgrenimDurumlariGetir = "select * from ogrenimdurumu where ogrenimDurumuKodu<=7";
    
    public List<OgrenimDurumu> TumOgrenimDurumlariGetir()
    {
        Connection conn = null;
        PreparedStatement stmt = null;		
        List<OgrenimDurumu> list = new ArrayList<OgrenimDurumu>();

        try 
        {
            conn = getConnection();                        
            stmt = conn.prepareStatement(tumOgrenimDurumlariGetir);                        
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) 
            {

                OgrenimDurumu ogrenimDurumu=new OgrenimDurumu();
                ogrenimDurumu.setOgrenimDurumuKodu(rs.getInt("ogrenimDurumuKodu"));
                ogrenimDurumu.setOgrenimDurumuAdi(rs.getString("ogrenimDurumuAdi"));

                list.add(ogrenimDurumu);

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
