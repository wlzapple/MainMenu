package MusicStore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
public class Order extends JFrame {

    private double total = 0;

    private final static int WIDTH = 500, HEIGHT = 250;
    private final JButton back, addTC, transact;
    private final backButtonHandler backBH;
    private addButtonHandler addBH;
    private final transactButtonHandler transactBH;
    private final Inventory inv;
    private final String username, password;
    private final Item[] cart = new Item[25];
    private final int[] amount = new int[25];
    private int numE = 0, quantity = 0;

    private final String[] instruments = {"Drum Set", "Alto Sax", "Tenor Sax", "Trumpet",
        "Electric Guitar", "Euphonium", "Flute", "Drum Sticks", "Music Books",
        "Stands", "Amplifiers", "Guitar Picks", "Baritone Sax", "Timpani",
        "Cymbals", "CDs", "Violin", "Piano", "Ocarina", "Acoustic Guitar",
        "Trombone", "Sousaphone", "Marimba", "Clarinet", "Triangle"};

    private final JComboBox<String> instrumentList;

    public Order(String username, String password) {

        for (int j = 0; j < amount.length; j++) {
            amount[j] = 0;
        }

        for (int j = 0; j < cart.length; j++) {
            cart[j] = new Item();
        }

        this.username = username;
        this.password = password;
        inv = new Inventory(username, password, false);
        inv.setLocation(250, 200);
        this.setLocation(700, 300);
        this.getContentPane().setBackground(new Color(0, 129, 172));

        instrumentList = new JComboBox<>(instruments);
        instrumentList.setSelectedIndex(-1);

        back = new JButton("Back");
        back.setSize(20, 20);
        backBH = new Order.backButtonHandler();
        back.addActionListener(backBH);

        addTC = new JButton("Add to Order");
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
        transact.setEnabled(false);

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
            Order.this.dispose();
            inv.dispose();
            MainMenu mainMenu = new MainMenu(username, password);
        }
    }

    private class addButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (instrumentList.getSelectedIndex() != -1) {
                if (LogScreen.stockPrep.checkOrder(instrumentList.getSelectedIndex() + 1, amount[instrumentList.getSelectedIndex()] + 1)) {
                    amount[instrumentList.getSelectedIndex()]++;
                    cart[numE].name = (String) instrumentList.getSelectedItem();
                    cart[numE].index = instrumentList.getSelectedIndex();
                    transact.setEnabled(true);
                    numE++;
                    if (numE==25) {
                        addTC.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "We have no more room for this item.");
                }
            }
        }
    }

    private class transactButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Transaction transact = new Transaction(cart, true);
            inv.dispose();
        }
    }

    private class Transaction extends JFrame {

        private final static int WIDTH = 500, HEIGHT = 250;
        private final JButton back, transact, remove;
        private final backButtonHandler backBH;
        private final transactButtonHandler transactBH;
        private removeButtonHandler removeBH;
        private final JComboBox<Item> checkOut;

        public Transaction(Item[] cart, boolean confirm) {

            Order.this.dispose();

            if (confirm) {
                JOptionPane.showMessageDialog(null, "Confirm with supplier that cart contents"
                        + " are correct.");
            }
            this.getContentPane().setBackground(new Color(0, 129, 172));

            checkOut = new JComboBox<>(cart);
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

            this.setTitle("Finish Order");

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
                Order order = new Order(username, password);
            }

        }

        private class transactButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                Transaction.this.dispose();
                for (int i = 0; i < numE; i++) {
                    total += (Integer.parseInt(Inventory.stock[cart[i].index + 1][2]) * .9);
                }
                for (int i = 0; i < amount.length; i++) {
                    if (amount[i] != 0) {
                        LogScreen.stockPrep.invAdd(i + 1, amount[i]);
                    }
                }
                JOptionPane.showMessageDialog(null, "Cost: $" + Double.toString(total));
                MainMenu mainMenu = new MainMenu(username, password);
            }

        }

        private class removeButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x = cart[checkOut.getSelectedIndex()].index;
                cart[checkOut.getSelectedIndex()] = cart[numE - 1];
                cart[numE - 1] = null;
                amount[x]--;
                numE--;
                Transaction.this.dispose();
                if (numE == 0) {
                    JOptionPane.showMessageDialog(null, "Your cart is empty. Please add an item"
                            + " to cart to continue transaction.");
                    Sale sale = new Sale(username, password);
                } else {
                    Transaction refresh = new Transaction(cart, false);
                    System.out.println(Arrays.toString(cart));
                }
            }

        }

    }

    protected class Item {

        protected String name;
        protected int index;

        protected Item() {

        }

        protected Item(String name, int index) {
            this.name = name;
            this.index = index;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

}
