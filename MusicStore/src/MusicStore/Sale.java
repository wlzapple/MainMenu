/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusicStore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
class Sale {
    private final static int WIDTH = 350;
    private final static int HEIGHT = 200;
    private JButton back, transact;
    
    String[] instruments = {"Drum Set", "Alto Sax", "Tenor Sax", "Trumpet",
        "Electric Guitar", "Euphonium", "Flute", "Drum Sticks", "Music Books",
        "Stands", "Amplifiers", "Guitar Picks", "Baritone Sax", "Timpani",
        "Cymbals", "CDs", "Violin", "Piano", "Ocarina", "Acoustic Guitar",
        "Trombone", "Sousephone", "Marimba", "Clarinet", "Triangle"
    };

    JComboBox<String> instrumentList;
    String selectedInstrument;

    public Sale() {
        instrumentList = new JComboBox<>(instruments);
        selectedInstrument = (String) instrumentList.getSelectedItem();
        instrumentList.setSelectedIndex(-1);
        //instrumentList.addActionListener(this);

    }

}
