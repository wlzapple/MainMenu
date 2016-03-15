
package MusicStore;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
public class LogScreen extends JFrame{
    
    private final static int WIDTH = 350;
    private final static int HEIGHT = 200;
    
    private JLabel usernameLBL, passwordLBL;
    
    private JTextField username, password;
    
    private JButton login, exit;
    
    //Button handlers:
    private LoginButtonHandler logBH;
    private ExitButtonHandler exitBH;
    
    public LogScreen(){
        usernameLBL = new JLabel("Username: ", SwingConstants.LEFT);
        passwordLBL = new JLabel("Password: ", SwingConstants.LEFT);
        
        username = new JTextField(10);
        password = new JTextField(10);
        
        //Create buttons and connect them to the appropriate action
        login = new JButton("Login");
        login.setSize(10,10);
        logBH = new LoginButtonHandler();
        login.addActionListener(logBH);
        
        exit = new JButton("Exit");
        exitBH = new ExitButtonHandler();
        exit.addActionListener(exitBH);
        
        this.setTitle("The Sound of Music");
        
        SpringLayout layout = new SpringLayout();
        Container pane = getContentPane();
        pane.setLayout(layout);
        
        pane.add(usernameLBL);
        pane.add(username);
        pane.add(passwordLBL);
        pane.add(password);
        pane.add(login);
        pane.add(exit);
        
        layout.putConstraint(SpringLayout.WEST, usernameLBL, 75, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, usernameLBL, 20, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, passwordLBL, 75, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, passwordLBL, 40, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, username, 150, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, username, 20, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, password, 150, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, password, 40, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, login, 100, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, login, 100, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, exit, 200, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, exit, 100, SpringLayout.NORTH, pane);
        
        
        
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

    
    protected class LoginButtonHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            MenuMain start = new MenuMain();
        }
    }
    
    protected class ExitButtonHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    protected String getUser(){
        return username.getText();
    }
    


    
}
