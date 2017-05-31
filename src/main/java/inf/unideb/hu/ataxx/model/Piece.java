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
 * @author hegedattila
 */
public class Piece {
    
    private PieceType type;
    
    private int x, y;

    /**
     *
     * @return
     */
    public PieceType getType() {
        return type;
    }
    
    /**
     *
     * @param type
     */
    public void setType(PieceType type){
        this.type = type;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param type
     * @param x
     * @param y
     */
    public Piece(PieceType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }
    
    
}
