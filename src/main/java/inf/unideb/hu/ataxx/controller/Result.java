/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.controller;


import javax.persistence.*;

/**
 * Az adatbázisért felelős osztály.
 * 
 * Az "ataxx" nevű tábla feltöltésére.
 * Minden játék végén egy új rekord kerül az adatbázisba.
 * 
 * @author Hegedűs Attila
 */
@Entity
@Table(name = "ataxx")
public class Result {
    
    /**
     * Beállítja a rekord id-ját egy automatikusan növekedvő értékekkel
     * rendelkelkező "id" nevű oszlopra.
     */
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="szekv")
    @SequenceGenerator(name="szekv", sequenceName = "szekvencia", allocationSize=1)
    
    /**
     * A rekord id-ja.
     */
    private int id;
    
    /**
     * A piros mezőkkel rendelkező játékos pontjai a játék végén.
     */
    private int red;
    /**
     * A kék mezőkkel rendelkező játékos pontjai a játék végén.
     */
    private int blue;

    /**
     * Az osztály konstruktora.
     * 
     * Felveszi a megfelelő pontszámokat.
     * 
     * @param red A piros mezőkkel rendelkező játékos pontjai a játék végén.
     * @param blue A kék mezőkkel rendelkező játékos pontjai a játék végén.
     */
    public Result(int red, int blue) {
        this.red = red;
        this.blue = blue;
    }

    /**
     * Visszaadja a rekord id-ját.
     * 
     * @return A rekord azonosítója.
     */
    public int getId() {
        return id;
    }

    /**
     * Visszaadja a piros mezőkkel rendelkező játékos pontszámát a játék végén.
     * 
     * @return A piros mezőkkel rendelkező játékos pontszáma a játék végén.
     */
    public int getRed() {
        return red;
    }

    /**
     * Visszaadja a kék mezőkkel rendelkező játékos pontszámát a játék végén.
     *
     * @return A kék mezőkkel rendelkező játékos pontszáma a játék végén.
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Beállítja a rekord id-ját.
     * 
     * @param id A rekord azonosítója.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Beállítja a piros mezőkkel rendelkező játékos pontszámát a játék végén.
     * 
     * @param red A piros mezőkkel rendelkező játékos pontszáma.
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     * Beállítja a kék mezőkkel rendelkező játékos pontszámát a játék végén.
     * 
     * @param blue A kék mezőkkel rendelkező játékos pontszáma.
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }
    
}
