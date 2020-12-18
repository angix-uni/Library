/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import backend.BazaKsiazka;
import frontend.StartFrame;


/**
 *
 * @author Angelika
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BazaKsiazka bk=new BazaKsiazka();
        bk.inicjalizujBaze();
        StartFrame sf=new StartFrame();
        sf.setSize(640,480);
        sf.setTitle("Biblioteka");
        sf.setVisible(true);
    }
    
}
