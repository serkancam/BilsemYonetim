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
public class OgrenciSinifi 
{
    private int ogrenciSinifi;
    private Ogrenci ogrenciTCNO;
    private Sinif sinifKodu;

    public int getOgrenciSinifi() {
        return ogrenciSinifi;
    }

    public void setOgrenciSinifi(int ogrenciSinifi) {
        this.ogrenciSinifi = ogrenciSinifi;
    }

    public Ogrenci getOgrenciTCNO() {
        return ogrenciTCNO;
    }

    public void setOgrenciTCNO(Ogrenci ogrenciTCNO) {
        this.ogrenciTCNO = ogrenciTCNO;
    }

    public Sinif getSinifKodu() {
        return sinifKodu;
    }

    public void setSinifKodu(Sinif sinifKodu) {
        this.sinifKodu = sinifKodu;
    }
    
}
