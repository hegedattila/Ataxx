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
 * @author Hegedűs Attila
 */
public class MoveResult {
    
    /**
     * A lépés típusa.
     */
    private MoveType type;

    /**
     * Visszaadja a lépés típusát.
     * 
     * @return a lépés típusa.
     */
    public MoveType getType() {
        return type;
    }

    /**
     * A célmező.
     */
    private Piece piece;

    /**
     * Visszaadja a célmezőt.
     * 
     * @return a célmező.
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Az osztály konstruktora.
     * 
     * @param type a lépés típusa.
     */
    public MoveResult(MoveType type) {
        this(type, null);
    }

    /**
     * Beállítja a lépés típusát és a célmezőt.
     * 
     * Háromféle lépéstípus van. Egy mezős lépés, ha a közvetlen szomszédjába
     * lép. Két mezős lépés ha a két kiválasztott terület között van egy mező.
     * Érvénytelen lépés pedig, ha vagy kettőnél többet akar lépni, vagy 
     * a célnak kiválasztott mező már foglalt.
     * A célmező mindenképpen a célnak kiválasztott mező.
     * 
     * @param type a lépés típusa.
     * @param piece a célmező.
     */
    public MoveResult(MoveType type, Piece piece) {
        this.type = type;
        this.piece = piece;
    }
    
}
