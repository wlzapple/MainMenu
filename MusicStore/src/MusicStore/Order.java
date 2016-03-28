package MusicStore;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
public class Order extends JFrame{
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

    public Order(String username) {
        this.username = username;
        Inventory inv = new Inventory(username);
        inv.setLocation(250, 200);
        this.setLocation(700, 300);
        this.getContentPane().setBackground(new Color(0, 129, 172));

        instrumentList = new JComboBox<>(instruments);
        selectedInstrument = (String) instrumentList.getSelectedItem();
        instrumentList.setSelectedIndex(-1);
        instrumentList.addActionListener(addBH);

        back = new JButton("Back");
        back.setSize(20, 20);
        backBH = new Order.backButtonHandler();
        back.addActionListener(backBH);

        addTC = new JButton("Add to Cart");
        addTC.setSize(20, 20);
        addBH = new Order.addButtonHandler();
        addTC.addActionListener(addBH);

        transact = new JButton("Transact");
        transact.setSize(20, 20);
        transactBH = new Order.transactButtonHandler();
        transact.addActionListener(transactBH);

        this.setTitle("Order");

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

        @Override
        public void actionPerformed(ActionEvent e) {
            Transaction transact = new Transaction(cart);
        }
    }

    private class Transaction extends JFrame {

        private final static int WIDTH = 500, HEIGHT = 250;
        private JButton back, transact, remove;
        private JLabel backL, transactL, removeL;
        private backButtonHandler backBH;
        private transactButtonHandler transactBH;
        private removeButtonHandler removeBH;
        JComboBox<String> checkOut;
        String item;

        public Transaction(String[] cart) {

            Order.this.dispose();

            JOptionPane.showMessageDialog(null, "Confirm with customer that cart contents"
                    + " are correct.");

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

        }

        private class backButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                Transaction.this.dispose();
                Order order = new Order(username);
            }

        }

        private class transactButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                Transaction.this.dispose();
                JOptionPane.showMessageDialog(null, "Cost: " + "$X");
                MainMenu mainMenu = new MainMenu(username);
            }

        }

        private class removeButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                checkOut.removeItem(checkOut.getSelectedItem());
            }

        }

    }
    
    }
