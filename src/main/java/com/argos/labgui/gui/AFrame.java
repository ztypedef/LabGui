/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argos.labgui.gui;

import com.argos.labgui.gui.nec.CenterPanel;
import com.argos.labgui.gui.nec.MainPanel;
import com.argos.labgui.gui.perspective.Perspective;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Zaparivanny Pavel
 */
public class AFrame{
      
    private MainPanel mainPanel;
    
    public final int RIGHT_BUTTTON = 0x1;
    public final int TOOL_FUNCTION = 0x2;
    
    public AFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, screenSize.width / 2, screenSize.height / 2);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        mainPanel = new MainPanel();
        
        frame.getContentPane().add(mainPanel);
 
        
        frame.setVisible(true);
    }
    
    public void addCommand(String name, ActionListener a, int flag){
        if((flag & RIGHT_BUTTTON) == RIGHT_BUTTTON){
            mainPanel.addRightPanelButton(name, a);
        }
    }
    
    public void addPerspective(Perspective pesp){
        mainPanel.addPerspective(pesp);
    }
    
    public Perspective getCurrentPerspective(){
        return getCurrentPerspective();
    }
    
    
}
