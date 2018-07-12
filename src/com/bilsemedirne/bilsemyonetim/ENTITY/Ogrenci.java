/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilsemedirne.bilsemyonetim.ENTITY;

import java.util.Date;

/**
 *
 * @author serkancam
 */
public class Ogrenci 
{

    private String ogrenciTCNO;
    private String ogrenciAdi;
    private String ogrenciSoyadi;
    private short ogrenciBilsemNo;
    private String dogumYeri;
    private Date dogumTarihi;
    private int tanimlamaYili;
    private Il tanimlananIl;
    private int ilkBilsemBaslamaYili;
    private Il ilkBilsemBaslamaIli;
    private byte cinsiyet;//1- erkek,  0- kız
    private String orgunOgretimdekiOgretmenAdi;
    private String surekliHastalik;
    private String surekliKullanilanIlac;
    private Bilsemler nakilGeldigiBilsem;
    private String adres;
    private Date kayitTarihi;
    private Veli velayet;
    private String fotograf;
    private byte aileDurumu;//1- beraber,0- ayrı
    private String orgunEgitimokulNo;
    private int orgunEgitimSinifi;
    private String orgunEgitimSubesi;
    private Okul orgunEgitimOkulu;
    private Ogretmen danismanOgretmen;
    
    
    public int getIlkBilsemBaslamaYili()
    {
        return ilkBilsemBaslamaYili;
    }

    public void setIlkBilsemBaslamaYili(int ilkBilsemBaslamaYili)
    {
        this.ilkBilsemBaslamaYili = ilkBilsemBaslamaYili;
    }
    
    public Ogretmen getDanismanOgretmen() {
        return danismanOgretmen;
    }

    public void setDanismanOgretmen(Ogretmen danismanOgretmen) {
        this.danismanOgretmen = danismanOgretmen;
    }

    public String getOrgunEgitimSubesi() {
        return orgunEgitimSubesi;
    }

    public void setOrgunEgitimSubesi(String orgunEgitimSubesi) {
        this.orgunEgitimSubesi = orgunEgitimSubesi;
    }

    public Okul getOrgunEgitimOkulu() {
        return orgunEgitimOkulu;
    }

    public void setOrgunEgitimOkulu(Okul orgunEgitimOkulu) {
        this.orgunEgitimOkulu = orgunEgitimOkulu;
    }
            
    
    
    public String getOgrenciAdi() {
        return ogrenciAdi;
    }

    public void setOgrenciAdi(String ogrenciAdi) {
        this.ogrenciAdi = ogrenciAdi;
    }

    public String getOgrenciSoyadi() {
        return ogrenciSoyadi;
    }

    public void setOgrenciSoyadi(String ogrenciSoyadi) {
        this.ogrenciSoyadi = ogrenciSoyadi;
    }

    public int getOrgunEgitimSinifi() {
        return orgunEgitimSinifi;
    }

    public void setOrgunEgitimSinifi(int orgunEgitimSinifi) {
        this.orgunEgitimSinifi = orgunEgitimSinifi;
    }

    public String getOgrenciTCNO() {
        return ogrenciTCNO;
    }

    public void setOgrenciTCNO(String ogrenciTCNO) {
        this.ogrenciTCNO = ogrenciTCNO;
    }

    public short getOgrenciBilsemNo() {
        return ogrenciBilsemNo;
    }

    public void setOgrenciBilsemNo(short ogrenciBilsemNo) {
        this.ogrenciBilsemNo = ogrenciBilsemNo;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public int getTanimlamaYili() {
        return tanimlamaYili;
    }

    public void setTanimlamaYili(int tanimlamaYili) {
        this.tanimlamaYili = tanimlamaYili;
    }

    public Il getTanimlananIl() {
        return tanimlananIl;
    }

    public void setTanimlananIl(Il tanimlananIl) {
        this.tanimlananIl = tanimlananIl;
    }

    public Il getIlkBilsemBaslamaIli() {
        return ilkBilsemBaslamaIli;
    }

    public void setIlkBilsemBaslamaIli(Il ilkBilsemBaslamaIli) {
        this.ilkBilsemBaslamaIli = ilkBilsemBaslamaIli;
    }

    public byte getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(byte cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getOrgunOgretimdekiOgretmenAdi() {
        return orgunOgretimdekiOgretmenAdi;
    }

    public void setOrgunOgretimdekiOgretmenAdi(String orgunOgretimdekiOgretmenAdi) {
        this.orgunOgretimdekiOgretmenAdi = orgunOgretimdekiOgretmenAdi;
    }

    public String getSurekliHastalik() {
        return surekliHastalik;
    }

    public void setSurekliHastalik(String surekliHastalik) {
        this.surekliHastalik = surekliHastalik;
    }

    public String getSurekliKullanilanIlac() {
        return surekliKullanilanIlac;
    }

    public void setSurekliKullanilanIlac(String surekliKullanilanIlac) {
        this.surekliKullanilanIlac = surekliKullanilanIlac;
    }

    public Bilsemler getNakilGeldigiBilsem() {
        return nakilGeldigiBilsem;
    }

    public void setNakilGeldigiBilsem(Bilsemler nakilGeldigiBilsem) {
        this.nakilGeldigiBilsem = nakilGeldigiBilsem;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Date kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public Veli getVelayet() {
        return velayet;
    }

    public void setVelayet(Veli velayet) {
        this.velayet = velayet;
    }

    public String getFotograf() {
        return fotograf;
    }

    public void setFotograf(String fotograf) {
        this.fotograf = fotograf;
    }

    public byte getAileDurumu() {
        return aileDurumu;
    }

    public void setAileDurumu(byte aileDurumu) {
        this.aileDurumu = aileDurumu;
    }

    public String getOrgunEgitimokulNo() {
        return orgunEgitimokulNo;
    }

    public void setOrgunEgitimokulNo(String orgunEgitimokulNo) {
        this.orgunEgitimokulNo = orgunEgitimokulNo;
    }
    
    
    
    
    
}
