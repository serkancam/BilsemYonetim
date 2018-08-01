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
public class Il 
{
    private int ilKodu;
    private String ilAdi;

    public Il()
    {
    }

    public Il(int ilKodu)
    {
        this.ilKodu = ilKodu;
    }

    public Il(int ilKodu, String ilAdi)
    {
        this.ilKodu = ilKodu;
        this.ilAdi = ilAdi;
    }
    
    
    

    public int getIlKodu() {
        return ilKodu;
    }

    public void setIlKodu(int ilKodu) {
        this.ilKodu = ilKodu;
    }

    public String getIlAdi() {
        return ilAdi;
    }

    public void setIlAdi(String ilAdi) {
        this.ilAdi = ilAdi;
    }

    @Override
    public String toString()
    {
        return "Il{" + "ilKodu=" + ilKodu + ", ilAdi=" + ilAdi + '}';
    }
    
    
}
