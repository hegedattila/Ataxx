/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.view;

import static inf.unideb.hu.ataxx.view.Board.TILE_SIZE;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author hegedattila
 */
public class PieceView extends Pane{
    
    private static final double RADIUS = 0.35;
    
    private double oldX, oldY;

    
    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }
    
//    private static Group pieceGroup = new Group();

    
    public PieceView(String type, int x, int y) {
        relocate(x * TILE_SIZE, y * TILE_SIZE);


        Circle circle = new Circle(TILE_SIZE * RADIUS);
        circle.setFill(type.equals("RED") ? Color.RED : Color.BLUE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(TILE_SIZE * 0.03);
        circle.setTranslateX((TILE_SIZE - TILE_SIZE * RADIUS * 2) / 2);
        circle.setTranslateY((TILE_SIZE - TILE_SIZE * RADIUS * 2) / 2);
        
//        System.out.println(oldX + " " + oldY);

        getChildren().addAll(circle);

//        Board.root.getChildren().add(circle);
        
//        pieceGroup.getChildren().add(circle);
        
        
        
//        setOnMousePressed(e -> {
//            if (!choosed){
//                mouseX = e.getSceneX();
//                mouseY = e.getSceneY();
//                System.out.println("Ez a Piece.java");
//                choosed = !choosed;
//            }
//            else
//                System.out.println("Ez a Piece.java");
//        });
//                
        }
    
//    public void move(int x, int y) {
//        oldX = x * TILE_SIZE;
//        oldY = y * TILE_SIZE;
//        relocate(oldX, oldY);
//    }
    
}
