/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argos.labgui.gui.nec;

import com.argos.labgui.gui.perspective.Perspective;
import com.argos.labgui.gui.unit.Unit;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author pavel
 */
public class MainPanel extends JPanel{

    private final ToolPanel toolPanel;
    private final RightPanel rightPanel;
    private final CenterPanel centerPanel;
    private final Map<String, Perspective> mapPersp;
    private final JComboBox comboBox;
    
    static final int widthPanel = 150;
    static final int heightPanel = 50;
    
    public MainPanel() {
        
        mapPersp = new HashMap<>();
        
        centerPanel = new CenterPanel();
        centerPanel.setLayout(new BorderLayout()); 
        setLayout(new BorderLayout()); 

        rightPanel = new RightPanel();
        toolPanel = new ToolPanel();

        add(toolPanel, BorderLayout.NORTH);
        add(rightPanel, BorderLayout.EAST);
        add(centerPanel, BorderLayout.CENTER);
        /**********Configure tool panel******************/
        comboBox = new JComboBox();
        comboBox.setSize(100, 100);
        comboBox.addActionListener(actionSelectPerspective);
        toolPanel.add(comboBox, BorderLayout.WEST);
        
        /**************************************************/
    }
    
    public void addRightPanelButton(String name, ActionListener a){
        JButton btn = new JButton(name);
        btn.addActionListener(a);
        btn.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(widthPanel, heightPanel));
        btn.setPreferredSize(new Dimension(widthPanel, heightPanel));
        rightPanel.add(btn, rightPanel);
    }
    
    /*********************************************************/
    
    public void addPerspective(Perspective pesp){
        comboBox.addItem(pesp.getNamePerspective());
        mapPersp.put(pesp.getNamePerspective(), pesp);
    }
    
    public boolean setPerspective(String name){
        if(name == null) return false;
        centerPanel.removeAll();
        Perspective persp = mapPersp.get(name);
        if(persp == null) return false;
        centerPanel.add(persp, BorderLayout.CENTER);
        centerPanel.repaint();
        centerPanel.validate();
        return true;
    }
    
    public boolean setPerspective(Perspective persp){
        if(persp == null) return false;
        centerPanel.removeAll();
        centerPanel.add(mapPersp.get(persp.getNamePerspective()), BorderLayout.CENTER);
        centerPanel.repaint();
        centerPanel.validate();
        return true;
    }
    
    private final ActionListener actionSelectPerspective = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((String)(((JComboBox)e.getSource()).getSelectedItem()));
            setPerspective(name);
        }
    };
    
    public Perspective getCurrentPerspective(){
        return mapPersp.get(comboBox.getSelectedIndex());
    }
    
    
    /*********************************************************/
    
    public void addUnit(Unit unit){
        Perspective persp = getCurrentPerspective();
        persp.addUnit(unit);
    }
    
    /*********************************************************/
}
