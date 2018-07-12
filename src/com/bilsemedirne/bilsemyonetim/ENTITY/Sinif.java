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
public class Sinif 
{
    private int sinifKodu;
    private String sinifKisaKodu;
    private Program programKodu;
    private Ogretmen danismanOgretmen;

    public int getSinifKodu() {
        return sinifKodu;
    }

    public void setSinifKodu(int sinifKodu) {
        this.sinifKodu = sinifKodu;
    }

    public String getSinifKisaKodu() {
        return sinifKisaKodu;
    }

    public void setSinifKisaKodu(String sinifKisaKodu) {
        this.sinifKisaKodu = sinifKisaKodu;
    }

    public Program getProgramKodu() {
        return programKodu;
    }

    public void setProgramKodu(Program programKodu) {
        this.programKodu = programKodu;
    }

    public Ogretmen getDanismanOgretmen() {
        return danismanOgretmen;
    }

    public void setDanismanOgretmen(Ogretmen danismanOgretmen) {
        this.danismanOgretmen = danismanOgretmen;
    }
    
    
    
}
