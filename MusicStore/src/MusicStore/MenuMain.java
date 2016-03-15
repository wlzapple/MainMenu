package MusicStore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @authors wlzapple, cabatts, ashalbert
 */
public class MenuMain extends JFrame {

    private static final int WIDTH = 500, HEIGHT = 250;

    /**
     * Need buttons for sale, return, order, trade, buy-back, order/receive
     * inventory, view inventory, logoff
     */
    private JButton saleB, retB, ordB, tradeB, buyBackB, viewInvB, logoffB;

    //labels for the buttons
    private JLabel saleL, retL, ordL, tradeL, buyBackL, viewInvL, logoffL;

    //handlers
    private SaleButtonHandler sHandler;
    private ReturnButtonHandler retHandler;
    private OrderButtonHandler ordHandler;
    private TradeButtonHandler tradeHandler;
    private BuyBackButtonHandler bbHandler;
    private ViewInvButtonHandler viHandler;
    private LogOffButtonHandler logoffHandler;

    public MenuMain(String user) {
        saleL = new JLabel("Make a Sale", SwingConstants.LEFT);
        retL = new JLabel("Make a Return", SwingConstants.LEFT);
        ordL = new JLabel("Order Inventory", SwingConstants.LEFT);
        tradeL = new JLabel("Make a Trade",SwingConstants.LEFT);
        buyBackL = new JLabel("BuyBack Item", SwingConstants.LEFT);
        viewInvL = new JLabel("View Inventory", SwingConstants.LEFT);
        logoffL = new JLabel("Make a Sale", SwingConstants.LEFT);
        
        //assign handlers to buttons, add ActionListeners
        saleB = new JButton("Sales");
        saleB.setSize(20, 20);
        sHandler = new MenuMain.SaleButtonHandler();
        saleB.addActionListener(sHandler);
        
        retB = new JButton("Return");
        retB.setSize(20, 20);
        retHandler = new MenuMain.ReturnButtonHandler();
        retB.addActionListener(retHandler);
        
        ordB = new JButton("Order");
        ordB.setSize(20,20);
        ordHandler = new MenuMain.OrderButtonHandler();
        ordB.addActionListener(ordHandler);
        
        tradeB = new JButton("Trade-In");
        tradeB.setSize(20, 20);
        tradeHandler = new MenuMain.TradeButtonHandler();
        tradeB.addActionListener(tradeHandler);
        
        buyBackB = new JButton("Buy-Back");
        buyBackB.setSize(20, 20);
        bbHandler = new MenuMain.BuyBackButtonHandler();
        buyBackB.addActionListener(bbHandler);
        
        viewInvB = new JButton("View Inventory");
        viewInvB.setSize(20,20);
        viHandler = new MenuMain.ViewInvButtonHandler();
        viewInvB.addActionListener(viHandler);        
        
        logoffB = new JButton("Logoff");
        logoffB.setSize(20,20);
        logoffHandler = new MenuMain.LogOffButtonHandler();
        logoffB.addActionListener(logoffHandler);  
    }

    private class SaleButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Sale sale = new Sale();
        }

    }

    private class ReturnButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ReturnItem ret = new ReturnItem();
        }

    }

    private class OrderButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Order order = new Order();
        }

    }

    private class TradeButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Trade trade = new Trade();
        }
    }

    private class BuyBackButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BuyBack buyback = new BuyBack();
        }

    }

    private class ViewInvButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory inv = new Inventory();
        }

    }

    private class LogOffButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MenuMain.this.dispose();
            MusicStore restart = new MusicStore();
        }

    }

}
