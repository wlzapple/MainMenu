package MusicStore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
public class Sale extends JFrame {

    private final static int WIDTH = 500, HEIGHT = 250;
    private JButton back, addTC, transact;
    private backButtonHandler backBH;
    private addButtonHandler addBH;
    private transactButtonHandler transactBH;
    private String username;
    private String[] cart = new String[25];
    private int i = 0;

    private String[] instruments = {"Drum Set", "Alto Sax", "Tenor Sax", "Trumpet",
        "Electric Guitar", "Euphonium", "Flute", "Drum Sticks", "Music Books",
        "Stands", "Amplifiers", "Guitar Picks", "Baritone Sax", "Timpani",
        "Cymbals", "CDs", "Violin", "Piano", "Ocarina", "Acoustic Guitar",
        "Trombone", "Sousaphone", "Marimba", "Clarinet", "Triangle"
    };

    private JComboBox<String> instrumentList;
    private String selectedInstrument;

    public Sale(String username) {
        this.username = username;

        this.getContentPane().setBackground(new Color(0, 129, 172));

        instrumentList = new JComboBox<>(instruments);
        selectedInstrument = (String) instrumentList.getSelectedItem();
        instrumentList.setSelectedIndex(-1);

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
            if (instrumentList.getSelectedIndex() != -1) {
                cart[i] = (String) instrumentList.getSelectedItem();
                transact.setEnabled(true);
                i++;
            }
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
        private backButtonHandler backBH;
        private transactButtonHandler transactBH;
        private removeButtonHandler removeBH;
        private JComboBox<String> checkOut;
        private String item;

        public Transaction(String[] cart) {

            Sale.this.dispose();

            JOptionPane.showMessageDialog(null, "Confirm with customer that cart contents"
                    + " are correct.");

            this.getContentPane().setBackground(new Color(0, 129, 172));

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
                Sale sale = new Sale(username);
            }

        }

        private class transactButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                Transaction.this.dispose();
                JOptionPane.showMessageDialog(null, "Your total is: " + "$X");
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
