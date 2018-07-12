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
public class Ogretmen 
{
    private String TC;
    private String ogretmenAdi;
    private String ogretmenSoyadi;
    private String adres;
    private String telefon;
    private Brans bransKodu;

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public String getOgretmenAdi() {
        return ogretmenAdi;
    }

    public void setOgretmenAdi(String ogretmenAdi) {
        this.ogretmenAdi = ogretmenAdi;
    }

    public String getOgretmenSoyadi() {
        return ogretmenSoyadi;
    }

    public void setOgretmenSoyadi(String ogretmenSoyadi) {
        this.ogretmenSoyadi = ogretmenSoyadi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Brans getBransKodu() {
        return bransKodu;
    }

    public void setBransKodu(Brans bransKodu) {
        this.bransKodu = bransKodu;
    }
    
    
}
