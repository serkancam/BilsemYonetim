/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilsemedirne.bilsemyonetim.Islem;

import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author serkancam
 */
public class GorselIslemler
{
    public void PanelBirimleriPasiflestirme(JPanel panel,boolean durum)
    {
        Component[] komponentler=panel.getComponents();
        for(Component kmp:komponentler)
        {
              if(kmp.getName().equalsIgnoreCase("gizle"))
              {
                  kmp.setEnabled(durum);
              }
           
        }
        
    }
    
}
