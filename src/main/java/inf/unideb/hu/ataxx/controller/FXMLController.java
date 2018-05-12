package inf.unideb.hu.ataxx.controller;

import inf.unideb.hu.ataxx.model.Game;
import inf.unideb.hu.ataxx.view.Board;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Kontroller osztály a gombok kezelésére.
 * 
 * @author Hegedűs Attila
 */
public class FXMLController implements Initializable {
    
    /**
     * A játék logikájának egy példánya.
     */
    private Game model;
    
    /**
     * "Passz" gomb.
     */
    @FXML
    private Button pass;
    
    /**
     * "Új játék" gomb.
     */
    @FXML
    private Button newGame;
    
    /**
     * Passz gomb funkciója.
     */
    @FXML
    private void handleButtonPass(){
        model.setIsCurrentRed(!model.isIsCurrentRed());
        MainApp.choosing = true;
    }
    
    /**
     * Új játék gomb funkciója.
     */
    @FXML
    private void handleButtonNewGame(){
        MainApp.game.startNewGame();
        MainApp.vbox = new VBox(MainApp.root, MainApp.board.draw());
        MainApp.vbox.setAlignment(Pos.CENTER);
        MainApp.vbox.setPadding(new Insets(0,0,Board.TILE_SIZE,0));
        MainApp.vbox.setPrefSize(Board.TILE_SIZE * Board.WIDTH + 100, Board.TILE_SIZE * Board.HEIGHT + 100);
        MainApp.scene.setRoot(MainApp.vbox);
        
        MainApp.choosing = true;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new Game(Board.WIDTH, Board.HEIGHT);
    }    
}
