/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argos.labgui;

import com.argos.labgui.gui.AFrame;
import com.argos.labgui.gui.perspective.Perspective;
import com.argos.labgui.gui.unit.Unit;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * 
 * @author Zaparivanny Pavel
 */
public class TestClass {
    
    public TestClass() {
    
    }
    
    public void go(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AFrame frame = new AFrame();
                frame.addCommand("Start", Start, frame.RIGHT_BUTTTON | frame.TOOL_FUNCTION);

            }
        });
        
        
    }
    
    private ActionListener Start = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Start");
        }
    };
    
}
