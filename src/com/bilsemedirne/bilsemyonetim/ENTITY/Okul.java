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
public class Okul 
{
    private int okulKodu;
    private String okulAdi;
    private Ilce ilceKodu;

    public Okul()
    {
    }

    public Okul(int okulKodu)
    {
        this.okulKodu = okulKodu;
    }

    public Okul(int okulKodu, String okulAdi)
    {
        this.okulKodu = okulKodu;
        this.okulAdi = okulAdi;
    }
    
    
    
    
    public int getOkulKodu() {
        return okulKodu;
    }

    public void setOkulKodu(int okulKodu) {
        this.okulKodu = okulKodu;
    }

    public String getOkulAdi() {
        return okulAdi;
    }

    public void setOkulAdi(String okulAdi) {
        this.okulAdi = okulAdi;
    }

    public Ilce getIlceKodu() {
        return ilceKodu;
    }

    public void setIlceKodu(Ilce ilceKodu) {
        this.ilceKodu = ilceKodu;
    }

    @Override
    public String toString()
    {
        return "Okul{" + "okulKodu=" + okulKodu + ", okulAdi=" + okulAdi + ", ilceKodu=" + ilceKodu + '}';
    }
    
    
           
    
}
