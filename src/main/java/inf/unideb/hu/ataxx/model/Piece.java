/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.model;

/**
 * Egy terület adatai.
 * 
 * A terület pozíciója a táblán, valamint a típusa, hogy melyik játékoshoz
 * tartozik.
 * 
 * @author Hegedűs Attila
 */
public class Piece {
    
    /**
     * A mező típusa, ha az már tartozik az egyik játékoshoz.
     */
    private PieceType type;
    
    /**
     * A mező koordinátái a táblán.
     */
    private int x, y;

    /**
     * Visszaadja a mező típusát.
     * 
     * @return a mező típusa.
     */
    public PieceType getType() {
        return type;
    }
    
    /**
     * Beállítja a mező típusát.
     * 
     * @param type a mező típusa.
     */
    public void setType(PieceType type){
        this.type = type;
    }

    /**
     * Visszaadja a mező sorindexe a mezők számában mérve.
     * 
     * @return a mező sorindexe a mezők számában mérve.
     */
    public int getX() {
        return x;
    }

    /**
     * Visszaadja a mező oszlopindexe a mezők számában mérve.
     * 
     * @return a mező oszlopindexe a mezők számában mérve.
     */
    public int getY() {
        return y;
    }

    /**
     * Az osztály konstruktora.
     * 
     * Ezzel létrejön egy elfoglalt mező.
     * 
     * @param type A mező típusa.
     * @param x A mező sorindexe a mezők számában mérve.
     * @param y A mező oszlopindexe a mezők számában mérve.
     */
    public Piece(PieceType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }
    
    
}
