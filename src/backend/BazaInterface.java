/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import javax.swing.JTextArea;

/**
 *
 * @author Angelika
 */
public interface BazaInterface {
    public void wyswietl(JTextArea tDane);
    public void dodaj(String nrKsiazki, String tytul, String autor, String rokWydania, String wydawnictwo);
}
