/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argos.labgui.gui.unit;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Zaparivanny Pavel
 */
public abstract class Unit extends JPanel{
    protected final int slaveAddress;

    public Unit(int slaveAddress) {
        this.slaveAddress = slaveAddress;
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), Integer.toString(slaveAddress)),
                        BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        setBackground(Color.LIGHT_GRAY);
    }
    
    public int getSlaveAddress(){
        return slaveAddress;
    }
    
    public abstract void setData(int[] pack);
    
}
