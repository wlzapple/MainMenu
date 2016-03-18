/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusicStore;

import javax.swing.JComboBox;

/**
 *
 * @author wlzapple, cabatts, ashalbert
 */
class Sale {
    String [] instruments = {"Drum Set", "Alto Sax", "Tenor Sax", "Trumpet",
            "Electric Guitar", "Baritone", "Flute", "Drum Sticks", "Music Books",
            "Stands", "Amplifiers", "Guitar Picks", "Baritone Sax", "Timpani",
            "Cymbals", "CDs", "Violin", "Piano", "Ocarina", "Acoustic Guitar",
            "Trombone", "Sousephone", "Marimba", "Clarinet", "Triangle"
    };
    
    JComboBox instrumentList = new JComboBox(instruments);
}
