/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Angelika
 */
public class Ksiazka {
    private String nrKsiazki;
    private String tytul;
    private String autor;
    private String rokWydania;
    private String wydawnictwo;

    public Ksiazka(String nrKsiazki, String tytul, String autor, String rokWydania, String wydawnictwo) {
        this.nrKsiazki = nrKsiazki;
        this.tytul = tytul;
        this.autor = autor;
        this.rokWydania = rokWydania;
        this.wydawnictwo = wydawnictwo;
    }

    public String getNrKsiazki() {
        return nrKsiazki;
    }

    public void setNrKsiazki(String nrKsiazki) {
        this.nrKsiazki = nrKsiazki;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(String rokWydania) {
        this.rokWydania = rokWydania;
    }

    public String getWydawnictwo() {
        return wydawnictwo;
    }

    public void setWydawnictwo(String wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }

}
