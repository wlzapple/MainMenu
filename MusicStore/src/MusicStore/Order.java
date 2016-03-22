/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusicStore;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
public class Order extends JFrame{
    private static final int WIDTH = 350, HEIGHT = 200;
    
    private JButton viewInvB;
    
    private JLabel totL;
    
    private ViewInvButtonHandler viHandler;
    
    public Order(){
    totL = new JLabel("Total:" , SwingConstants.LEFT);
    
        viewInvB = new JButton("View Inventory");
        viewInvB.setSize(20,20);
        viHandler = new ViewInvButtonHandler();
        viewInvB.addActionListener(viHandler);
        
        SpringLayout layout = new SpringLayout();
        Container pane = getContentPane();
        pane.setLayout(layout);
        pane.add(totL);
        pane.add(viewInvB);
        
        layout.putConstraint(SpringLayout.WEST, totL, 75, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, totL, 20, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, viewInvB, 75, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, viewInvB, 40, SpringLayout.NORTH, pane);
        
    }
    private class ViewInvButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
    }

