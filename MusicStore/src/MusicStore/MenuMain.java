package MusicStore;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

/**
 *
 * @authors wlzapple, cabatts, ashalbert
 */
public class MenuMain extends JFrame implements Observer{
    
    private JButton ordRet;
    
    
    public MenuMain(){
        ordRet = new JButton("Order or Return");
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
