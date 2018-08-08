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
public class Veli 
{
    private int veliKodu;
    private String veliAdi;
    private String veliSoyadi;
    private String evAdresi;
    private String isAdresi;
    private String evTelefonu;
    private String isTelefonu;
    private String cepTelefonu;
    private String epostaAdresi;
    private OgrenimDurumu ogrenimDurumu;
    private byte hayattami;//hayatta-1, değil-0
    private VeliTipi veliTipi;
    private String meslegi;

    public Veli()
    {
    }

    public Veli(int veliKodu)
    {
        this.veliKodu = veliKodu;
    }
    
    

    public Veli(int veliKodu, String veliAdi, String veliSoyadi, String evAdresi, String isAdresi, String evTelefonu, String isTelefonu, String cepTelefonu, String epostaAdresi, OgrenimDurumu ogrenciDurumu, byte hayattami, VeliTipi veliTipi, String meslegi)
    {
        this.veliKodu = veliKodu;
        this.veliAdi = veliAdi;
        this.veliSoyadi = veliSoyadi;
        this.evAdresi = evAdresi;
        this.isAdresi = isAdresi;
        this.evTelefonu = evTelefonu;
        this.isTelefonu = isTelefonu;
        this.cepTelefonu = cepTelefonu;
        this.epostaAdresi = epostaAdresi;
        this.ogrenimDurumu = ogrenciDurumu;
        this.hayattami = hayattami;
        this.veliTipi = veliTipi;
        this.meslegi = meslegi;
    }

    
    public String getMeslegi()
    {
        return meslegi;
    }

    public void setMeslegi(String meslegi)
    {
        this.meslegi = meslegi;
    }

    public int getVeliKodu() {
        return veliKodu;
    }

    public void setVeliKodu(int veliKodu) {
        this.veliKodu = veliKodu;
    }

    public String getVeliAdi() {
        return veliAdi;
    }

    public void setVeliAdi(String veliAdi) {
        this.veliAdi = veliAdi;
    }

    public String getVeliSoyadi() {
        return veliSoyadi;
    }

    public void setVeliSoyadi(String veliSoyadi) {
        this.veliSoyadi = veliSoyadi;
    }

    public String getEvAdresi() {
        return evAdresi;
    }

    public void setEvAdresi(String evAdresi) {
        this.evAdresi = evAdresi;
    }

    public String getIsAdresi() {
        return isAdresi;
    }

    public void setIsAdresi(String isAdresi) {
        this.isAdresi = isAdresi;
    }

    public String getEvTelefonu() {
        return evTelefonu;
    }

    public void setEvTelefonu(String evTelefonu) {
        this.evTelefonu = evTelefonu;
    }

    public String getIsTelefonu() {
        return isTelefonu;
    }

    public void setIsTelefonu(String isTelefonu) {
        this.isTelefonu = isTelefonu;
    }

    public String getCepTelefonu() {
        return cepTelefonu;
    }

    public void setCepTelefonu(String cepTelefonu) {
        this.cepTelefonu = cepTelefonu;
    }

    public String getEpostaAdresi() {
        return epostaAdresi;
    }

    public void setEpostaAdresi(String epostaAdresi) {
        this.epostaAdresi = epostaAdresi;
    }

    public OgrenimDurumu getOgrenimDurumu() {
        return ogrenimDurumu;
    }

    public void setOgrenimDurumu(OgrenimDurumu ogrenimDurumu) {
        this.ogrenimDurumu = ogrenimDurumu;
    }

    public byte getHayattami() {
        return hayattami;
    }

    public void setHayattami(byte hayattami) {
        this.hayattami = hayattami;
    }

    public VeliTipi getVeliTipi() {
        return veliTipi;
    }

    public void setVeliTipi(VeliTipi veliTipi) {
        this.veliTipi = veliTipi;
    }

    @Override
    public String toString()
    {
        return "Veli{" + "veliKodu=" + veliKodu + ", veliAdi=" + veliAdi + ", veliSoyadi=" + veliSoyadi + ", evAdresi=" + evAdresi + ", isAdresi=" + isAdresi + ", evTelefonu=" + evTelefonu + ", isTelefonu=" + isTelefonu + ", cepTelefonu=" + cepTelefonu + ", epostaAdresi=" + epostaAdresi + ", ogrenimDurumu=" + ogrenimDurumu + ", hayattami=" + hayattami + ", veliTipi=" + veliTipi + ", meslegi=" + meslegi + '}';
    }
    
    
            
}
