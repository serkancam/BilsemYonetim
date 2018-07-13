/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilsemedirne.bilsemyonetim.Islem;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
                   
                  if(kmp instanceof JTextArea)
                  {
                      
                      ((JTextArea) kmp).setEnabled(durum);
                      ((JTextArea) kmp).setEditable(durum);
                  }
                                            
                  if(kmp instanceof JTextField)
                  {
                      ((JTextField) kmp).setText("");
                  }
                  if(kmp instanceof JComboBox)
                  {
                      ((JComboBox) kmp).setSelectedIndex(0);
                      
                  }
                 kmp.setEnabled(durum);
              }
           
        }
        
    }
    
}
