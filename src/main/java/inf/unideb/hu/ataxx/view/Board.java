/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.view;

import inf.unideb.hu.ataxx.model.Game;
import inf.unideb.hu.ataxx.model.PieceType;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author hegedattila
 */
public class Board {
    
    public static final int TILE_SIZE = 50;
    public static final int WIDTH = 7;
    public static final int HEIGHT = 7;
    
//    private static final double RADIUS = 0.35;

    
    private static Group tileGroup = new Group();
//    private static Group pieceGroup = new Group();
    
//    PieceView piece = new PieceView();
    
    public Parent draw(){
        
        Pane root = new Pane();
        root.setMaxSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        root.getChildren().addAll(tileGroup);
        
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                TileView tile = new TileView(x, y);

                tileGroup.getChildren().add(tile);
                
//                if(Game.board[x][y].hasPiece()){
//                    pieceGroup.getChildren().add(
//                            new PieceView(Game.board[x][y].getPiece().getType() == PieceType.RED ? "RED" : "BLUE", x, y));
//                }
                
            }
        }
                
        return root;
    }
    
}
