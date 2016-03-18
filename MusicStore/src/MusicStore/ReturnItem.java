/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusicStore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
class ReturnItem extends JFrame{
    private final static int WIDTH = 350;
    private final static int HEIGHT = 200;
    
    private JLabel itemL, condL;
    
    private JButton finalize;
    
    private String[] instruments = {"Drum Set", "Alto Sax", "Tenor Sax", "Trumpet",
            "Electric Guitar", "Baritone", "Flute", "Drum Sticks", "Music Books",
            "Stands", "Amplifiers", "Guitar Picks", "Baritone Sax", "Timpani",
            "Cymbals", "CDs", "Violin", "Piano", "Ocarina", "Acoustic Guitar",
            "Trombone", "Sousephone", "Marimba", "Clarinet", "Triangle"
    };
    
    private String[] condition = {"Perfect", "Good", "Acceptable", "Broken"};
    
    private JComboBox<String> instrumentBox;
    private JComboBox<String> conds;
      
    
    private FinalButtonHandler finalBH;
  
    private JButton finalButton;
    
  
    
    public ReturnItem(){
        //ask if they have a receipt
        int rYN = JOptionPane.YES_NO_OPTION;
        int receiptYN = JOptionPane.showConfirmDialog(null, "Does the customer have a receipt?", "Receipt", rYN);
        if(receiptYN != JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Inform the customer that we cannot accept an item without a receipt.", "", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            
            instrumentBox = new JComboBox<>(instruments);
            instrumentBox.setSelectedIndex(-1);

            finalBH = new FinalButtonHandler();
            finalButton.addActionListener(finalBH);
            
            itemL = new JLabel("Item to Return", SwingConstants.LEFT);
            condL = new JLabel("Condition of Item", SwingConstants.LEFT);
            
            this.setTitle("Return an Item");
            
            SpringLayout layout = new SpringLayout();
            Container pane = getContentPane();
            pane.setLayout(layout);
            

            
            
        }
    }



    

    private class FinalButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String item = instrumentBox.getSelectedItem().toString();
        }

        
    }
    
}
