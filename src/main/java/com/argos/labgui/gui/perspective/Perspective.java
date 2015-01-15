/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argos.labgui.gui.perspective;

import com.argos.labgui.gui.unit.Unit;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author Zaparivanny Pavel
 */
public class Perspective extends JPanel{

    private final String namePerspective;
    
    public Perspective(String name) {
        namePerspective = name;
    }
    
    public String getNamePerspective(){
        return namePerspective;
    }
    
    public boolean addUnit(Unit unit){
        Component[] c = getComponents();
        for (Component c1 : c) {
            if (((Unit) c1).getSlaveAddress() == unit.getSlaveAddress()) {
                return false;
            }
        }
        add(unit);
        return true;
    }
    
    
    public Component getUnit(int slaveAddress){
        Component[] c = getComponents();
        for (Component c1 : c) {
            if (((Unit) c1).getSlaveAddress() == slaveAddress) {
                return c1;
            }
        }
        return null;
    }
    
    public void removeUnit(int slaveAddress){
        Component[] c = getComponents();
        for (Component c1 : c) {
            if (((Unit) c1).getSlaveAddress() == slaveAddress) {
                remove(c1);
            }
        }
    }
}
