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
public class Program 
{
    private int programKodu;
    private YetenekAlani yetenekAlaniKodu;
    private String programKisaAdi;
    private String programAdi;

    public int getProgramKodu() {
        return programKodu;
    }

    public void setProgramKodu(int programKodu) {
        this.programKodu = programKodu;
    }

    public YetenekAlani getYetenekAlaniKodu() {
        return yetenekAlaniKodu;
    }

    public void setYetenekAlaniKodu(YetenekAlani yetenekAlaniKodu) {
        this.yetenekAlaniKodu = yetenekAlaniKodu;
    }

    public String getProgramKisaAdi() {
        return programKisaAdi;
    }

    public void setProgramKisaAdi(String programKisaAdi) {
        this.programKisaAdi = programKisaAdi;
    }

    public String getProgramAdi() {
        return programAdi;
    }

    public void setProgramAdi(String programAdi) {
        this.programAdi = programAdi;
    }
    
    
    
}
