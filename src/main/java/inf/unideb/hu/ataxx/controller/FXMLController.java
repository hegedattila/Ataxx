package inf.unideb.hu.ataxx.controller;

import inf.unideb.hu.ataxx.model.Game;
import inf.unideb.hu.ataxx.model.PieceType;
import inf.unideb.hu.ataxx.view.Board;
import inf.unideb.hu.ataxx.view.PieceView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {
    
    private Game model;
    
    private double mouseX, mouseY;
    
    @FXML
    public static Label label;
    
    @FXML
    private Label red;
    
    @FXML
    private Label blue;
    
    @FXML
    private Button pass;
    
    @FXML
    private void eredmeny(){
        label.setText("A játéknak vége.");
    }
    
    @FXML
    private void redLabel(){
        red.setText(String.valueOf(model.redPoints));
    }
    
    @FXML
    private void blueLabel(){
        blue.setText(String.valueOf(model.bluePoints));
    }
    
    @FXML
    private void handleButtonPass(){
        model.isCurrentRed = ! model.isCurrentRed;
        MainApp.choosing = true;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new Game(Board.WIDTH, Board.HEIGHT);
    }    
}
