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
 *
 * @author hegedattila
 */
public class TileView extends Rectangle{
    
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
    
//    public void highLight(int x, int y, Color color){
//        setWidth(Board.TILE_SIZE);
//        setHeight(Board.TILE_SIZE);
//
//        relocate(x * Board.TILE_SIZE, y * Board.TILE_SIZE);
//        
//        setStroke(color);
//        setStrokeWidth(Board.TILE_SIZE * 0.03);
//    }
    
}
