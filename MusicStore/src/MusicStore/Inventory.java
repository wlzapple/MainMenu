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

    private final static int WIDTH = 425;
    private final static int HEIGHT = 500;

    private JTable instrTable;

    private JButton back;

    private backButtonHandler backBH;

    public static String[][] stock = new String[26][3];
    private String[] colNames = new String[]{"Name", "Amount", "Price"};
    
    public Inventory(){
        File file = new File("src/MusicStore/Stock.txt");
        stock[0][0] = "Name";
        stock[0][1] = "Quantity";
        stock[0][2] = "Price ($)";
        
       try {
            Scanner scan = new Scanner(file);
            scan.useDelimiter(":");
            int i = 1;
            while (scan.hasNextLine()) {
                stock[i][0] = scan.next();
                scan.skip(":");
                stock[i][1] = scan.next();
                scan.skip(":");
                stock[i][2] = scan.nextLine();
                i++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        
        
    }

    public Inventory(String username, boolean showBack) {
        this.username = username;
        this.getContentPane().setBackground(new Color(0, 129, 172));
        //read stock from file
//        File file = new File("src/MusicStore/Stock.txt");
//        stock[0][0] = "Name";
//        stock[0][1] = "Quantity";
//        stock[0][2] = "Price ($)";
//            
//        try {
//            Scanner scan = new Scanner(file);
//            scan.useDelimiter(":");
//            int i = 1;
//            while (scan.hasNextLine()) {
//                stock[i][0] = scan.next();
//                scan.skip(":");
//                stock[i][1] = scan.next();
//                scan.skip(":");
//                stock[i][2] = scan.nextLine();
//                i++;
//            }
//            scan.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }

        this.getContentPane().setBackground(new Color(0, 129, 172));

        instrTable = new JTable(stock, colNames);
        instrTable.getColumn("Name").setPreferredWidth(120);
        instrTable.getColumn("Amount").setPreferredWidth(70);
        instrTable.getColumn("Price").setPreferredWidth(60);

        back = new JButton("Back");
        backBH = new backButtonHandler();
        back.addActionListener(backBH);

        //Main menu layout
        SpringLayout layout = new SpringLayout();
        Container pane = getContentPane();
        pane.setLayout(layout);

        pane.add(instrTable);

        if (showBack) {
            pane.add(back);
        }

        layout.putConstraint(SpringLayout.WEST, instrTable, 110, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, instrTable, 40, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.SOUTH, back, -25, SpringLayout.SOUTH, pane);

        this.setTitle("Stock");
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
