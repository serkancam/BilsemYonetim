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
public class OgrencininVelisi 
{
    private int ogrenciVelisiKodu;
    private Ogrenci ogrenci;
    private Veli veliKodu;

    public int getOgrenciVelisiKodu() {
        return ogrenciVelisiKodu;
    }

    public void setOgrenciVelisiKodu(int ogrenciVelisiKodu) {
        this.ogrenciVelisiKodu = ogrenciVelisiKodu;
    }

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    public Veli getVeliKodu() {
        return veliKodu;
    }

    public void setVeliKodu(Veli veliKodu) {
        this.veliKodu = veliKodu;
    }
    
    
}
