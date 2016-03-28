package MusicStore;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
class Inventory extends JFrame {

    private String username;

    private final static int WIDTH = 350;
    private final static int HEIGHT = 500;

    private JTable instrTable;

    private JButton back;

    private backButtonHandler backBH;

    private String[][] stock = new String[25][2];
    private String[] colNames = new String[]{"Name", "Amount"};

    public Inventory(String username, boolean showBack) {
        this.username = username;

        //read stock from file
        File file = new File("src/MusicStore/Stock.txt");

        try {
            Scanner scan = new Scanner(file);
            scan.useDelimiter(":");
            int i = 0;
            while (scan.hasNextLine()) {
                stock[i][0] = scan.next();
                scan.skip(":");
                stock[i][1] = scan.nextLine();
                i++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        this.getContentPane().setBackground(new Color(0, 129, 172));

        instrTable = new JTable(stock, colNames);
        instrTable.getColumn("Name").setPreferredWidth(100);
        instrTable.getColumn("Amount").setPreferredWidth(30);

        back = new JButton("Back");
        backBH = new backButtonHandler();
        back.addActionListener(backBH);

        //Main menu layout
        SpringLayout layout = new SpringLayout();
        Container pane = getContentPane();
        pane.setLayout(layout);

        pane.add(instrTable);
        
        if(showBack){
            pane.add(back);
        }

        layout.putConstraint(SpringLayout.WEST, instrTable, 110, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, instrTable, 40, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.SOUTH, back, -25, SpringLayout.SOUTH, pane);

        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private class backButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory.this.dispose();
            MainMenu mainMenu = new MainMenu(username);
        }

    }

}
