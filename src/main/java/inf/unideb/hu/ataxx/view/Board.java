/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.view;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 *
 * @author hegedattila
 */
public class Board {
    
    public static final int TILE_SIZE = 50;
    public static final int WIDTH = 7;
    public static final int HEIGHT = 7;
    
    private static Group tileGroup = new Group();
    
    public Parent draw(){
        
        Pane root = new Pane();
        root.setMaxSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        root.getChildren().addAll(tileGroup);
        
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                TileView tile = new TileView(x, y);

                tileGroup.getChildren().add(tile);
                
            }
        }
                
        return root;
    }
    
}
