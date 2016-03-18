/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusicStore;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
public class Sale extends JFrame{
    private final static int WIDTH = 500, HEIGHT = 250;
    private JButton back, addTC, transact;
    private JLabel backL, addL, transactL;
    private backButtonHandler backBH;
    private addButtonHandler addBH;
    private transactButtonHandler transactBH;
    
    
    /*String[] instruments = {"Drum Set", "Alto Sax", "Tenor Sax", "Trumpet",
        "Electric Guitar", "Euphonium", "Flute", "Drum Sticks", "Music Books",
        "Stands", "Amplifiers", "Guitar Picks", "Baritone Sax", "Timpani",
        "Cymbals", "CDs", "Violin", "Piano", "Ocarina", "Acoustic Guitar",
        "Trombone", "Sousephone", "Marimba", "Clarinet", "Triangle"
    };*/

    //JComboBox<String> instrumentList;
    //String selectedInstrument;

    public Sale() {
        
         try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        this.getContentPane().setBackground(new Color(0,129,172));
        
        backL = new JLabel ("Back to Main Menu", SwingConstants.LEFT);
        addL = new JLabel ("Add to Care", SwingConstants.LEFT);
        transactL = new JLabel ("Transact", SwingConstants.LEFT);
         
        //instrumentList = new JComboBox<>(instruments);
        //selectedInstrument = (String) instrumentList.getSelectedItem();
        //instrumentList.setSelectedIndex(-1);
        //instrumentList.addActionListener(this);
        
        back = new JButton("Back");
        back.setSize(20,20);
        backBH = new Sale.backButtonHandler();
        back.addActionListener(backBH);
        
        addTC = new JButton("Add to Cart");
        addTC.setSize(20,20);
        addBH = new Sale.addButtonHandler();
        addTC.addActionListener(addBH);
        
        transact = new JButton("Transact");
        transact.setSize(20,20);
        transactBH = new Sale.transactButtonHandler();
        back.addActionListener(backBH);
        
        this.setTitle("Sale");
        
        SpringLayout layout = new SpringLayout();
        Container pane = getContentPane();
        pane.setLayout(layout);
        
        pane.add(back);
        pane.add(addTC);
        pane.add(transact);
        
        layout.putConstraint(SpringLayout.WEST, back, 50, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, addTC, 205, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, addTC, 25, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.EAST, transact, -50, SpringLayout.EAST, pane);
        layout.putConstraint(SpringLayout.SOUTH, transact, -25, SpringLayout.SOUTH, pane);
        
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class addButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class backButtonHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenu mainmenu = new MainMenu(username.getText());
        }
    }
    
   private class transactButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
