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
public class DevamEttigiProgram 
{
    private int devamEttigiProgramId;
    private Ogrenci ogrenciTCNO;
    private Program programKodu;

    public int getDevamEttigiProgramId() {
        return devamEttigiProgramId;
    }

    public void setDevamEttigiProgramId(int devamEttigiProgramId) {
        this.devamEttigiProgramId = devamEttigiProgramId;
    }

    public Ogrenci getOgrenciTCNO() {
        return ogrenciTCNO;
    }

    public void setOgrenciTCNO(Ogrenci ogrenciTCNO) {
        this.ogrenciTCNO = ogrenciTCNO;
    }

    public Program getProgramKodu() {
        return programKodu;
    }

    public void setProgramKodu(Program programKodu) {
        this.programKodu = programKodu;
    }
    
    
    
    
}
