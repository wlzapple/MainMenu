/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusicStore;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
public class Sale extends JFrame {

    private final static int WIDTH = 500, HEIGHT = 250;
    private JButton back, addTC, transact;
    private JLabel backL, addL, transactL;
    private backButtonHandler backBH;
    private addButtonHandler addBH;
    private transactButtonHandler transactBH;
    String username;
    String[] cart = new String[25];
    int i = 0;

    private String[] instruments = {"Drum Set", "Alto Sax", "Tenor Sax", "Trumpet",
        "Electric Guitar", "Euphonium", "Flute", "Drum Sticks", "Music Books",
        "Stands", "Amplifiers", "Guitar Picks", "Baritone Sax", "Timpani",
        "Cymbals", "CDs", "Violin", "Piano", "Ocarina", "Acoustic Guitar",
        "Trombone", "Sousaphone", "Marimba", "Clarinet", "Triangle"
    };

    JComboBox<String> instrumentList;
    String selectedInstrument;

    /*public abstract class List extends JPanel implements ListSelectionListener {

     private JList list;
     private DefaultListModel listM;

     public List() {
     super(new BorderLayout());

     listM = new DefaultListModel();
     listM.addElement("Guitar");
     listM.addElement("Sax");
     listM.addElement("French Horn");

     list = new JList(listM);
     list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     list.setSelectedIndex(-1);
     list.addListSelectionListener(this);
     list.setVisibleRowCount(10);
     JScrollPane listSP = new JScrollPane(list);

     JPanel buttonPane = new JPanel();
     buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
     buttonPane.add(Box.createHorizontalStrut(5));
     buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
     buttonPane.add(Box.createHorizontalStrut(5));
     buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

     add(listSP, BorderLayout.CENTER);
     add(buttonPane, BorderLayout.PAGE_END);
     }
     }*/
    public Sale(String user) {
        username = user;

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

        this.getContentPane().setBackground(new Color(0, 129, 172));

        backL = new JLabel("Back to Main Menu", SwingConstants.LEFT);
        addL = new JLabel("Add to Cart", SwingConstants.LEFT);
        transactL = new JLabel("Transact", SwingConstants.LEFT);

        instrumentList = new JComboBox<>(instruments);
        selectedInstrument = (String) instrumentList.getSelectedItem();
        instrumentList.setSelectedIndex(-1);
        instrumentList.addActionListener(addBH);

        back = new JButton("Back");
        back.setSize(20, 20);
        backBH = new Sale.backButtonHandler();
        back.addActionListener(backBH);

        addTC = new JButton("Add to Cart");
        addTC.setSize(20, 20);
        addBH = new Sale.addButtonHandler();
        addTC.addActionListener(addBH);

        transact = new JButton("Transact");
        transact.setSize(20, 20);
        transactBH = new Sale.transactButtonHandler();
        transact.addActionListener(transactBH);

        this.setTitle("Sale");

        SpringLayout layout = new SpringLayout();
        Container pane = getContentPane();
        pane.setLayout(layout);

        pane.add(back);
        pane.add(addTC);
        pane.add(transact);
        pane.add(instrumentList);

        layout.putConstraint(SpringLayout.WEST, back, 50, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.SOUTH, back, -25, SpringLayout.SOUTH, pane);
        layout.putConstraint(SpringLayout.WEST, addTC, 200, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.SOUTH, addTC, -25, SpringLayout.SOUTH, pane);
        layout.putConstraint(SpringLayout.EAST, transact, -25, SpringLayout.EAST, pane);
        layout.putConstraint(SpringLayout.SOUTH, transact, -25, SpringLayout.SOUTH, pane);
        layout.putConstraint(SpringLayout.WEST, instrumentList, 190, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, instrumentList, 25, SpringLayout.NORTH, pane);

        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class backButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            MainMenu mainMenu = new MainMenu(username);
        }
    }

    private class addButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cart[i] = (String) instrumentList.getSelectedItem();
            i++;
        }
    }

    private class transactButtonHandler implements ActionListener {
        private JButton confirm;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            /*for (int j = 0; j < cart.length && cart[j] != null; j++) {
             System.out.println(cart[j] + ", ");*/
            Transaction transact = new Transaction(cart);
        }
    }

    public class Transaction extends JFrame {

        private final static int WIDTH = 500, HEIGHT = 250;
        private JButton back, transact, remove;
        private JLabel backL, transactL, removeL;
        private backButtonHandler backBH;
        private transactButtonHandler transactBH;
        private removeButtonHandler removeBH;
        JComboBox<String> checkOut;
        String item;

        public Transaction(String[] cart) {
            
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
            
            this.getContentPane().setBackground(new Color(0, 129, 172));
            
            backL = new JLabel("Back to Sale", SwingConstants.LEFT);
            transactL = new JLabel("Transact", SwingConstants.LEFT);
            removeL = new JLabel("Remove Item", SwingConstants.LEFT);
            
            checkOut = new JComboBox(cart);
            item = (String) checkOut.getSelectedItem();
            checkOut.setSelectedIndex(0);
            checkOut.addActionListener(removeBH);

            back = new JButton("Back");
            back.setSize(20, 20);
            backBH = new Transaction.backButtonHandler();
            back.addActionListener(backBH);

            transact = new JButton("Transact");
            transact.setSize(20, 20);
            transactBH = new Transaction.transactButtonHandler();
            transact.addActionListener(transactBH);
            
            remove = new JButton("Remove");
            remove.setSize(20, 20);
            removeBH = new Transaction.removeButtonHandler();
            remove.addActionListener(removeBH);
            
            this.setTitle("Transact");
            
            SpringLayout layout = new SpringLayout();
            Container pane = getContentPane();
            pane.setLayout(layout);
            
            pane.add(back);
            pane.add(transact);
            pane.add(remove);
            pane.add(checkOut);
            
            layout.putConstraint(SpringLayout.WEST, back, 50, SpringLayout.WEST, pane);
            layout.putConstraint(SpringLayout.SOUTH, back, -25, SpringLayout.SOUTH, pane);
            layout.putConstraint(SpringLayout.WEST, remove, 200, SpringLayout.WEST, pane);
            layout.putConstraint(SpringLayout.SOUTH, remove, -25, SpringLayout.SOUTH, pane);
            layout.putConstraint(SpringLayout.EAST, transact, -50, SpringLayout.EAST, pane);
            layout.putConstraint(SpringLayout.SOUTH, transact, -25, SpringLayout.SOUTH, pane);
            layout.putConstraint(SpringLayout.WEST, checkOut, 190, SpringLayout.WEST, pane);
            layout.putConstraint(SpringLayout.NORTH, checkOut, 25, SpringLayout.NORTH, pane);
            
            this.setSize(WIDTH, HEIGHT);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            JOptionPane.showMessageDialog(null, "Confirm with customer that cart contents"
                    + " are correct.");
        }

        private class backButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Sale sale = new Sale(username);
            }

        }
        
        private class transactButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        }
        
        private class removeButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        }

    }
}
