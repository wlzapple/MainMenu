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
    private String username;
    private static final int WIDTH = 350, HEIGHT = 200;
    
    private JButton viewInvB, totB, viewCartB;
    
    //private JLabel;
    private ViewCartButtonHandler vcHandler;
    private ViewInvButtonHandler viHandler;
    private TotalButtonHandler totHandler;
    
    public Order(String username){
    //= new JLabel("Total:" , SwingConstants.LEFT);
        this.username = username;
        
        totB = new JButton("Total");
        totB.setSize(20,20);
        totHandler = new TotalButtonHandler();
        totB.addActionListener(totHandler);
        
        viewInvB = new JButton("View Inventory");
        viewInvB.setSize(20,20);
        viHandler = new ViewInvButtonHandler();
        viewInvB.addActionListener(viHandler);
        
        viewCartB = new JButton("View Cart");
        viewCartB.setSize(20,20);
        vcHandler = new ViewCartButtonHandler();
        viewCartB.addActionListener(vcHandler);
        
        SpringLayout layout = new SpringLayout();
        Container pane = getContentPane();
        pane.setLayout(layout);
        pane.add(totB);
        pane.add(viewInvB);
        pane.add(viewCartB);
        
        layout.putConstraint(SpringLayout.WEST, totB, 260, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, totB, 140, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, viewInvB, 20, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, viewInvB, 20, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, viewCartB, 250, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, viewCartB, 20, SpringLayout.NORTH, pane);
        
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private static class ViewCartButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class TotalButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Order.this.dispose(); 
        }

    }
    private class ViewInvButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {         
            Inventory inv = new Inventory(username);
            
            //To change body of generated methods, choose Tools | Templates.
        }

    }
    }

