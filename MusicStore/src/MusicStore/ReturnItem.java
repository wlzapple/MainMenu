package MusicStore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
class ReturnItem extends JFrame {

    private final String username, password;

    private final static int WIDTH = 350;
    private final static int HEIGHT = 200;

    private JLabel itemL, condL;

    private JButton finalButton, back;

    private final String[] instruments = {"Drum Set", "Alto Sax", "Tenor Sax", "Trumpet",
        "Electric Guitar", "Euphonium", "Flute", "Drum Sticks", "Music Books",
        "Stands", "Amplifiers", "Guitar Picks", "Baritone Sax", "Timpani",
        "Cymbals", "CDs", "Violin", "Piano", "Ocarina", "Acoustic Guitar",
        "Trombone", "Sousaphone", "Marimba", "Clarinet", "Triangle"};

    private final String[] conditions = {"Perfect", "Good", "Acceptable", "Broken"};
    private final double[] percent = {1.00, .75, .50};

    private JComboBox<String> instrumentBox;
    private JComboBox<String> conds;

    private FinalButtonHandler finalBH;
    private BoxValueChangeHandler select;
    private backButtonHandler backBH;

    public ReturnItem(String username, String password) {
        this.username = username;
        this.password = password;
        this.getContentPane().setBackground(new Color(0, 129, 172));
        //ask if they have a receipt
        int receiptYN = JOptionPane.showConfirmDialog(null, "Does the customer have a receipt?", "Receipt", JOptionPane.YES_NO_OPTION);
        if (receiptYN != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Inform the customer that we cannot accept an item without a receipt.", "", JOptionPane.PLAIN_MESSAGE);
            MainMenu mainMenu = new MainMenu(username, password);
        } else {

            select = new BoxValueChangeHandler();
            instrumentBox = new JComboBox<>(instruments);
            instrumentBox.setSelectedIndex(-1);
            instrumentBox.addActionListener(select);

            conds = new JComboBox<>(conditions);
            conds.setSelectedIndex(-1);
            conds.addActionListener(select);

            finalButton = new JButton("Finalize");
            finalBH = new FinalButtonHandler();
            finalButton.addActionListener(finalBH);

            back = new JButton("Back");
            backBH = new backButtonHandler();
            back.addActionListener(backBH);

            itemL = new JLabel("Item to Return", SwingConstants.LEFT);
            condL = new JLabel("Condition of Item", SwingConstants.LEFT);

            this.setTitle("Return an Item");

            SpringLayout layout = new SpringLayout();
            Container pane = getContentPane();
            pane.setLayout(layout);

            pane.add(itemL);
            pane.add(instrumentBox);
            pane.add(condL);
            pane.add(conds);
            pane.add(back);
            pane.add(finalButton);

            finalButton.setEnabled(false);

            layout.putConstraint(SpringLayout.WEST, itemL, 50, SpringLayout.WEST, pane);
            layout.putConstraint(SpringLayout.NORTH, itemL, 25, SpringLayout.NORTH, pane);
            layout.putConstraint(SpringLayout.WEST, instrumentBox, 50, SpringLayout.WEST, pane);
            layout.putConstraint(SpringLayout.NORTH, instrumentBox, 40, SpringLayout.NORTH, pane);
            layout.putConstraint(SpringLayout.EAST, condL, -50, SpringLayout.EAST, pane);
            layout.putConstraint(SpringLayout.NORTH, condL, 25, SpringLayout.NORTH, pane);
            layout.putConstraint(SpringLayout.EAST, conds, -50, SpringLayout.EAST, pane);
            layout.putConstraint(SpringLayout.NORTH, conds, 40, SpringLayout.NORTH, pane);
            layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, pane);
            layout.putConstraint(SpringLayout.SOUTH, back, -25, SpringLayout.SOUTH, pane);
            layout.putConstraint(SpringLayout.EAST, finalButton, -25, SpringLayout.EAST, pane);
            layout.putConstraint(SpringLayout.SOUTH, finalButton, -25, SpringLayout.SOUTH, pane);

            this.setSize(WIDTH, HEIGHT);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        }
    }

    private class BoxValueChangeHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (instrumentBox.getSelectedIndex() != -1) {
                if (conds.getSelectedIndex() != -1) {
                    finalButton.setEnabled(true);
                }
            }
        }
    }

    private class backButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ReturnItem.this.dispose();
            MainMenu mainMenu = new MainMenu(username,password);
        }
    }

    private class FinalButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String item = instrumentBox.getSelectedItem().toString();
            String cond = conds.getSelectedItem().toString();
            LogScreen.stockPrep.invAdd(instrumentBox.getSelectedIndex()+1, 1);
            ReturnItem.this.dispose();
            double price = Integer.parseInt(Inventory.stock[instrumentBox.getSelectedIndex()+1][2]) * percent[conds.getSelectedIndex()];
            JOptionPane.showMessageDialog(null, "For a " + item + " in " + cond + " condition, we will give $" + Double.toString(price), "", JOptionPane.PLAIN_MESSAGE);
            MainMenu mainMenu = new MainMenu(username,password);

        }

    }

}