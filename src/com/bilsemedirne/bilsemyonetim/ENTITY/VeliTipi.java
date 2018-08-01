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
public class VeliTipi 
{
    private int veliTipiKodu;
    private String veliTipiAdi;

    public VeliTipi()
    {
    }

    public VeliTipi(int veliTipiKodu)
    {
        this.veliTipiKodu = veliTipiKodu;
     
    }

    public VeliTipi(int veliTipiKodu, String veliTipiAdi)
    {
        this.veliTipiKodu = veliTipiKodu;
        this.veliTipiAdi = veliTipiAdi;
    }
    
    
    
    

    public int getVeliTipiKodu() {
        return veliTipiKodu;
    }

    public void setVeliTipiKodu(int veliTipiKodu) {
        this.veliTipiKodu = veliTipiKodu;
    }

    public String getVeliTipiAdi() {
        return veliTipiAdi;
    }

    public void setVeliTipiAdi(String veliTipiAdi) {
        this.veliTipiAdi = veliTipiAdi;
    }

    @Override
    public String toString()
    {
        return "VeliTipi{" + "veliTipiKodu=" + veliTipiKodu + ", veliTipiAdi=" + veliTipiAdi + '}';
    }
    
    
}
