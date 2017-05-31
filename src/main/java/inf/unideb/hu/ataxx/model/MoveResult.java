/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.model;

/**
 * Lépéskor eltárolja a lépés adatait.
 * 
 * Egy lépés után eltárolja, hogy milyen típusú lépés volt, illetve ha szabályos
 * lépés volt, akkor a hozzá tartozó új területet is.
 * 
 * @author hegedattila
 */
public class MoveResult {
    
    private MoveType type;

    /**
     *
     * @return
     */
    public MoveType getType() {
        return type;
    }

    private Piece piece;

    /**
     *
     * @return
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     *
     * @param type
     */
    public MoveResult(MoveType type) {
        this(type, null);
    }

    /**
     *
     * @param type
     * @param piece
     */
    public MoveResult(MoveType type, Piece piece) {
        this.type = type;
        this.piece = piece;
    }
    
}
