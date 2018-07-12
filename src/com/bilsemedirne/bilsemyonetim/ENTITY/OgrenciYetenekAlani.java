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
public class OgrenciYetenekAlani 
{
    private int OgrenciYetenekAlaniKodu;
    private Ogrenci ogrenciTCNo;
    private YetenekAlani yetenekAlaniKodu;

    public int getOgrenciYetenekAlaniKodu() {
        return OgrenciYetenekAlaniKodu;
    }

    public void setOgrenciYetenekAlaniKodu(int OgrenciYetenekAlaniKodu) {
        this.OgrenciYetenekAlaniKodu = OgrenciYetenekAlaniKodu;
    }

    public Ogrenci getOgrenciTCNo() {
        return ogrenciTCNo;
    }

    public void setOgrenciTCNo(Ogrenci ogrenciTCNo) {
        this.ogrenciTCNo = ogrenciTCNo;
    }

    public YetenekAlani getYetenekAlaniKodu() {
        return yetenekAlaniKodu;
    }

    public void setYetenekAlaniKodu(YetenekAlani yetenekAlaniKodu) {
        this.yetenekAlaniKodu = yetenekAlaniKodu;
    }
    
    
}
