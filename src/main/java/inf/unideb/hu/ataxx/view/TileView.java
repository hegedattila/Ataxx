/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.view;

import inf.unideb.hu.ataxx.model.Game;
import inf.unideb.hu.ataxx.model.PieceType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Ez az osztály felelős a játék mezőinek megrajzolására.
 * 
 * A játék kezdetekor, valamint minden érvényes lépés után megrajzolja a táblát
 * a meglévő mezők alapján.
 * 
 * @author Hegedűs Attila
 */
public class TileView extends Rectangle{
    
    /**
     * Megrajzolja a játékmezőt a megadott mezőszámmal.
     * 
     * Az üres mezők szürkével lesznek kitöltve, a foglaltak pirossal vagy
     * kékkel, attól függően milyen típusú mezőről van szó.
     * 
     * @param x A tábla szélessége a mezők számában mérve.
     * @param y A tábla magassága a mezők számában mérve.
     */
    public TileView(int x, int y) {
        setWidth(Board.TILE_SIZE);
        setHeight(Board.TILE_SIZE);

        relocate(x * Board.TILE_SIZE, y * Board.TILE_SIZE);
        
        if (Game.board[x][y].hasPiece()){
            setFill(Game.board[x][y].getPiece().getType() == PieceType.RED ? Color.RED : Color.BLUE);
        }
        else {
            setFill(Color.LIGHTGRAY);
        }
        
        setStroke(Color.GRAY);
        setStrokeWidth(Board.TILE_SIZE * 0.03);
        


    }
    
}
