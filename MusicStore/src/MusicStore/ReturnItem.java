/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusicStore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
class ReturnItem {
    private final static int WIDTH = 350;
    private final static int HEIGHT = 200;
    
    private JLabel receipt;
    
    private JButton yes, no;
    
    private YesButtonHandler yesBH;
    private NoButtonHandler noBH;
    
    public ReturnItem(){
        //ask if they have a receipt
        int rYN = JOptionPane.YES_NO_OPTION;
        int receiptYN = JOptionPane.showConfirmDialog(null, "Does the customer have a receipt?", "Receipt", rYN);
        if(receiptYN != JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Inform the customer that we cannot accept an item without a receipt.", "", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private class NoButtonHandler implements ActionListener{

        public NoButtonHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class YesButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        
    }
    
}
