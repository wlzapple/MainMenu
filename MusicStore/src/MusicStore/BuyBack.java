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
public class BuyBack extends JFrame {

    private final static int WIDTH = 350, HEIGHT = 200;
    private JButton back, transact;
    private JLabel itemL, condL;
    private backButtonHandler backBH;
    private BoxValueHandler select;
    private transactButtonHandler transactBH;
    String username;

    private final String[] instruments = {"Drum Set", "Alto Sax", "Tenor Sax", "Trumpet",
        "Electric Guitar", "Euphonium", "Flute", "Drum Sticks", "Music Books",
        "Stands", "Amplifiers", "Guitar Picks", "Baritone Sax", "Timpani",
        "Cymbals", "CDs", "Violin", "Piano", "Ocarina", "Acoustic Guitar",
        "Trombone", "Sousaphone", "Marimba", "Clarinet", "Triangle"
    };

    private String[] conditions = {"Perfect", "Good", "Acceptable", "Broken"};

    JComboBox<String> options;
    JComboBox<String> conds;

    String selectedInstrument;

    public BuyBack(String user) {
        username = user;

        int rYN = JOptionPane.YES_NO_OPTION;
        int receiptYN = JOptionPane.showConfirmDialog(null, "Does the customer have a receipt?", "Receipt", rYN);
        if (receiptYN != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Inform the customer that we cannot accept an item without a receipt.", "", JOptionPane.PLAIN_MESSAGE);
            MainMenu mainMenu = new MainMenu(username);
        } else {

            select = new BoxValueHandler();
            options = new JComboBox<>(instruments);
            options.setSelectedIndex(-1);
            options.addActionListener(select);

            conds = new JComboBox<>(conditions);
            conds.setSelectedIndex(-1);
            conds.addActionListener(select);

            back = new JButton("Back");
            backBH = new backButtonHandler();
            back.addActionListener(backBH);

            transact = new JButton("Transact");
            transactBH = new transactButtonHandler();
            transact.addActionListener(transactBH);

            itemL = new JLabel("Item for Buy-Back", SwingConstants.LEFT);
            condL = new JLabel("Condition of Item", SwingConstants.LEFT);

            this.setTitle("Buy-Back");

            SpringLayout layout = new SpringLayout();
            Container pane = getContentPane();
            pane.setLayout(layout);

            pane.add(itemL);
            pane.add(options);
            pane.add(condL);
            pane.add(conds);
            pane.add(back);
            pane.add(transact);

            transact.setEnabled(false);

            layout.putConstraint(SpringLayout.WEST, itemL, 50, SpringLayout.WEST, pane);
            layout.putConstraint(SpringLayout.NORTH, itemL, 25, SpringLayout.NORTH, pane);
            layout.putConstraint(SpringLayout.WEST, options, 50, SpringLayout.WEST, pane);
            layout.putConstraint(SpringLayout.NORTH, options, 40, SpringLayout.NORTH, pane);
            layout.putConstraint(SpringLayout.EAST, condL, -50, SpringLayout.EAST, pane);
            layout.putConstraint(SpringLayout.NORTH, condL, 25, SpringLayout.NORTH, pane);
            layout.putConstraint(SpringLayout.EAST, conds, -50, SpringLayout.EAST, pane);
            layout.putConstraint(SpringLayout.NORTH, conds, 40, SpringLayout.NORTH, pane);
            layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, pane);
            layout.putConstraint(SpringLayout.SOUTH, back, -25, SpringLayout.SOUTH, pane);
            layout.putConstraint(SpringLayout.EAST, transact, -25, SpringLayout.EAST, pane);
            layout.putConstraint(SpringLayout.SOUTH, transact, -25, SpringLayout.SOUTH, pane);

            this.setSize(WIDTH, HEIGHT);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    private class backButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BuyBack.this.dispose();
            MainMenu mainMenu = new MainMenu(username);
        }

    }

    private class transactButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String item = options.getSelectedItem().toString();
            String cond = conds.getSelectedItem().toString();
            BuyBack.this.dispose();
            JOptionPane.showMessageDialog(null, "For a " + item + " in " + cond + " condition,"
                    + " we will give $X", "", JOptionPane.PLAIN_MESSAGE);

            int YesNo = JOptionPane.YES_NO_OPTION;
            int receiptYesNo = JOptionPane.showConfirmDialog(null, "Would the customer like to make a purchase?", "Sale", YesNo);
            if (receiptYesNo != JOptionPane.YES_OPTION) {
                MainMenu mainMenu = new MainMenu(username);
            } else {
                Sale sale = new Sale(username);
            }
        }

    }

    private class BoxValueHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (options.getSelectedIndex() != -1) {
                if (conds.getSelectedIndex() != -1) {
                    transact.setEnabled(true);
                }
            }
        }

    }

}
