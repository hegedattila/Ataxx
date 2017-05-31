/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.model;

/**
 * A játéktábla egy mezője és az, hogy a mező foglalt-e már.
 * 
 * @author hegedattila
 */
public class Tile {
    
    private Piece piece;

    /**
     *
     * @return
     */
    public boolean hasPiece() {
        return piece != null;
    }

    /**
     *
     * @return
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     *
     * @param piece
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
}
