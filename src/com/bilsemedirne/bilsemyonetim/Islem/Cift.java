/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilsemedirne.bilsemyonetim.Islem;

/**
 *
 * @author serkancam
 */
public class Cift 
{
    public int key;
    public String value;
    
    public Cift(int k, java.lang.String v)
    {
        this.key=k;
        this.value=v;
    }
    public Cift()
    {
        
    }

    @Override
    public String toString() 
    {
        return value; //To change body of generated methods, choose Tools | Templates.
       // return value;
    }
    
}
