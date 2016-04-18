package MusicStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
class Trade extends JFrame {

    private final String username;
    private final static int WIDTH = 350, HEIGHT = 200;

    private JLabel itemL, condL;

    private JButton finalButton, back;

    private final String[] instruments = {"Drum Set", "Alto Sax", "Tenor Sax", "Trumpet",
        "Electric Guitar", "Euphonium", "Flute", "Drum Sticks", "Music Books",
        "Stands", "Amplifiers", "Guitar Picks", "Baritone Sax", "Timpani",
        "Cymbals", "CDs", "Violin", "Piano", "Ocarina", "Acoustic Guitar",
        "Trombone", "Sousaphone", "Marimba", "Clarinet", "Triangle"};

    private final String[] conditions = {"Perfect", "Good", "Acceptable", "Broken"};

    private JComboBox<String> instrumentBox;
    private JComboBox<String> conds;

    private FinalButtonHandler finalBH;
    private BoxValueChangeHandler select;
    private backButtonHandler backBH;

    public Trade(String username) {
        this.username = username;

        this.getContentPane().setBackground(new Color(0, 129, 172));
        int receiptYN = JOptionPane.showConfirmDialog(null, "Does the customer have a receipt?", "Receipt", JOptionPane.YES_NO_OPTION);
        if (receiptYN != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Inform the customer that we cannot accept an item without a receipt.", "", JOptionPane.PLAIN_MESSAGE);
            MainMenu mainMenu = new MainMenu(username);
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

            itemL = new JLabel("Item to Trade In", SwingConstants.LEFT);
            condL = new JLabel("Condition of Item", SwingConstants.LEFT);

            this.setTitle("Trade an Item");

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
            Trade.this.dispose();
            MainMenu mainMenu = new MainMenu(username);
        }

    }

    private class FinalButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String item = instrumentBox.getSelectedItem().toString();
            String cond = conds.getSelectedItem().toString();
            Trade.this.dispose();
            JOptionPane.showMessageDialog(null, "For a " + item + " in " + cond + " condition, we will give $X credit", "", JOptionPane.PLAIN_MESSAGE);
            Sale sale = new Sale(username);

        }

    }

}