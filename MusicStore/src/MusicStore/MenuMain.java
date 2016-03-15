package MusicStore;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @authors wlzapple, cabatts, ashalbert
 */
public class MenuMain extends JFrame{
    
    private static final int WIDTH = 500, HEIGHT = 250;
    
    /**
     * Need buttons for sale, return, order, buy-back, order/receive inventory?,
     * view inventory, logoff
     */
    private JButton saleB, retB, ordB, buyBackB,viewInv, logoffB;
    
    //labels for the buttons
    private JLabel saleL, retL, ordL, buyBackL,invL, logoffL;
    
    //handlers
    private SaleButtonHandler sHandler;
    private ReturnButtonHandler retHandler;
    private OrderButtonHandler ordHandler;
    private BuyBackButtonHandler bbHandler;
    private ViewInvButtonHandler viHandler;
    private LogOffButtonHandler logoffHandler;
    
    
    
    public MenuMain(){
        
    }

    private class SaleButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Sale sale = new Sale();
        }

        
    }

    private class ReturnButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ReturnItem ret = new ReturnItem();
        }

        
    }

    private class OrderButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Order order = new Order();
        }

        
    }

    private class BuyBackButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BuyBack buyback = new BuyBack();
        }

        
    }
    
    private class ViewInvButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory inv = new Inventory();
        }
        
    }

    private class LogOffButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MenuMain.this.dispose();
            MusicStore restart = new MusicStore();
        }

       
    }
    
}
