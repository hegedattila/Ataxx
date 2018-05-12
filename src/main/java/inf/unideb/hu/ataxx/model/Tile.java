/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.model;

/**
 * A játéktábla egy mezője és az, hogy a mező foglalt-e már.
 * 
 * @author Hegedűs Attila
 */
public class Tile {
    
    /**
     * A mező.
     */
    private Piece piece;

    /**
     * Visszaadja, hogy a terület folgalt-e már.
     * 
     * @return True, ha a terület foglalt.
     */
    public boolean hasPiece() {
        return piece != null;
    }

    /**
     * Visszaadja a mezőt.
     * 
     * @return A mező.
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Beállítja a mezőt.
     * 
     * @param piece a mező.
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
}
