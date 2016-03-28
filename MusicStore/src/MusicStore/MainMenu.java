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
 * @authors wlzapple, cabatts, ashalbert
 */
public class MainMenu extends JFrame {

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
    String username;

    public MainMenu(String user) {
        username = user;

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.getContentPane().setBackground(new Color(0, 129, 172));

        saleL = new JLabel("Make a Sale", SwingConstants.LEFT);
        retL = new JLabel("Make a Return", SwingConstants.LEFT);
        ordL = new JLabel("Order Inventory", SwingConstants.LEFT);
        tradeL = new JLabel("Make a Trade", SwingConstants.LEFT);
        buyBackL = new JLabel("BuyBack Item", SwingConstants.LEFT);
        viewInvL = new JLabel("View Inventory", SwingConstants.LEFT);
        logoffL = new JLabel("Make a Sale", SwingConstants.LEFT);

        //assign handlers to buttons, add ActionListeners
        saleB = new JButton("Sales");
        saleB.setSize(20, 20);
        sHandler = new MainMenu.SaleButtonHandler();
        saleB.addActionListener(sHandler);

        retB = new JButton("Return");
        retB.setSize(20, 20);
        retHandler = new MainMenu.ReturnButtonHandler();
        retB.addActionListener(retHandler);

        ordB = new JButton("Order");
        ordB.setSize(20, 20);
        ordHandler = new MainMenu.OrderButtonHandler();
        ordB.addActionListener(ordHandler);

        tradeB = new JButton("Trade-In");
        tradeB.setSize(20, 20);
        tradeHandler = new MainMenu.TradeButtonHandler();
        tradeB.addActionListener(tradeHandler);

        buyBackB = new JButton("Buy-Back");
        buyBackB.setSize(20, 20);
        bbHandler = new MainMenu.BuyBackButtonHandler();
        buyBackB.addActionListener(bbHandler);

        viewInvB = new JButton("View Inventory");
        viewInvB.setSize(20, 20);
        viHandler = new MainMenu.ViewInvButtonHandler();
        viewInvB.addActionListener(viHandler);

        logoffB = new JButton("Logoff");
        logoffB.setSize(20, 20);
        logoffHandler = new MainMenu.LogOffButtonHandler();
        logoffB.addActionListener(logoffHandler);

        this.setTitle("Main Menu");

        //Main menu layout
        SpringLayout layout = new SpringLayout();
        Container pane = getContentPane();
        pane.setLayout(layout);

        
        pane.add(saleB);
        pane.add(retB);
        pane.add(ordB);
        pane.add(tradeB);
        pane.add(buyBackB);
        pane.add(viewInvB);
        pane.add(logoffB);

        layout.putConstraint(SpringLayout.WEST, saleB, 50, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, saleB, 25, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, retB, 205, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, retB, 25, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.EAST, ordB, -50, SpringLayout.EAST, pane);
        layout.putConstraint(SpringLayout.NORTH, ordB, 25, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, tradeB, 100, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, tradeB, 100, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.EAST, buyBackB, -100, SpringLayout.EAST, pane);
        layout.putConstraint(SpringLayout.NORTH, buyBackB, 100, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, viewInvB, 25, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.SOUTH, viewInvB, -25, SpringLayout.SOUTH, pane);
        layout.putConstraint(SpringLayout.EAST, logoffB, -25, SpringLayout.EAST, pane);
        layout.putConstraint(SpringLayout.SOUTH, logoffB, -25, SpringLayout.SOUTH, pane);
        
        /*if(!"manager".equals(username)){
            tradeB.setEnabled(false);
            buyBackB.setEnabled(false);
            ordB.setEnabled(false);
        }*/

        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private class SaleButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenu.this.dispose();
            Sale sale = new Sale(username);
        }

    }

    private class ReturnButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenu.this.dispose();
            ReturnItem ret = new ReturnItem(username);
        }

    }

    private class OrderButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenu.this.dispose();
            Order order = new Order();
        }

    }

    private class TradeButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenu.this.dispose();
            Trade trade = new Trade();
        }
    }

    private class BuyBackButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenu.this.dispose();
            BuyBack buyback = new BuyBack(username);
        }

    }

    private class ViewInvButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenu.this.dispose();
            Inventory inv = new Inventory(username);
        }

    }

    private class LogOffButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenu.this.dispose();
            LogScreen restart = new LogScreen();
        }

    }

}
