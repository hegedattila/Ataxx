/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.model;

/**
 *
 * @author hegedattila
 */
public class Piece {
    
    private PieceType type;
    
    private int x, y;

    public PieceType getType() {
        return type;
    }
    
    public void setType(PieceType type){
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece(PieceType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }
    
    
}
