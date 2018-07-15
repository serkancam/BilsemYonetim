/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilsemedirne.bilsemyonetim.ENTITY;

/**
 *
 * @author serkancam
 */
public class Bilsemler 
{
    private int bilsemKodu;
    private String bilsemAdi;
    private Il ilKodu;

    public Bilsemler()
    {
    }

    public Bilsemler(int bilsemKodu)
    {
        this.bilsemKodu = bilsemKodu;
    }
    
    

    public int getBilsemKodu() 
    {
        return bilsemKodu;
    }

    public void setBilsemKodu(int bilsemKodu) 
    {
        this.bilsemKodu = bilsemKodu;
    }

    public String getBilsemAdi() 
    {
        return bilsemAdi;
    }

    public void setBilsemAdi(String bilsemAdi) 
    {
        this.bilsemAdi = bilsemAdi;
    }

    public Il getIlKodu() 
    {
        return ilKodu;
    }

    public void setIlKodu(Il ilKodu) 
    {
        this.ilKodu = ilKodu;
    }

    @Override
    public String toString()
    {
        return "Bilsemler{" + "bilsemKodu=" + bilsemKodu + ", bilsemAdi=" + bilsemAdi + ", ilKodu=" + ilKodu + '}';
    }
    
    
    
    
}
